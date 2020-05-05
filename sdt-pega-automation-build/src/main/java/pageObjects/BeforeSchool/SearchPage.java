package pageObjects.BeforeSchool;


import libs.BasePage;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import pageObjects.BeforeSchool.CreateChildPage;


import java.sql.SQLOutput;

public class SearchPage extends BasePage {

    //*************************SEARCH PAGE WEB ELEMENT XPATH***************************************************************

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__nhiNumber__textBox']")
    private WebElement nhinumber;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__searchAllButton']")
    private WebElement searchAllDHBbutton;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__searchButton']")
    private WebElement searchButtonInAllocationTabForCoordinatorLogin;

//**************************  ASSIGN PROVIDER TO THE NEW CHILD  *******************************************************

    @FindBy(how = How.XPATH, using = "//a[text()='Assign Provider']")
    private WebElement assignProviderLink;

    @FindBy(how = How.XPATH, using = "//a[@class='AspNet-Menu-Link']")
    private WebElement mgmtPageLink;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__nhiNumber__textBox']")
    private WebElement managementNhi;

    @FindBy(how = How.XPATH, using = "//div [@class='AspNet-GridView']/table/tbody/tr/td[3]/a")
    private WebElement surNameLink;

    @FindBy(how = How.XPATH, using = "//div [@class='AspNet-GridView']/table/tbody/tr/td[8]")
    private WebElement NHINumberLink;

    //************************* WEB ELEMENT NOT USED ********************************************************************

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__givenName__textBox']")
    private WebElement existingFirstName;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__surname__textBox']")
    private WebElement existingSurName;

    @FindBy(how = How.XPATH, using = "//label[@id='ctl00__faultInformation__errorMessageLabel']/span/span")
    private WebElement NHIerror;

 //************************************************************************************************************************
    public String generateRandomNAHINumber() {
//        boolean flag = true;
//        String NHI = null;
//        while (flag) {
//            NHI = RandomStringUtils.randomAlphabetic(3).toUpperCase() + RandomStringUtils.randomNumeric(4);
//            if (IsValidNHINumberFormat(NHI)) {
//                flag = false;
//            }
//        }
        boolean flag = true;
        String NHI=null;
        while (flag){
            NHI = RandomStringUtils.randomAlphabetic(3).toUpperCase() + RandomStringUtils.randomNumeric(4);
            if(!(NHI.contains("I")||NHI.contains("O"))){
                if(IsValidNHINumberFormat(NHI)){
                    flag = false;
                }
            }
        }
        System.out.println("Valid NHI Number is " + NHI);
        return NHI;
    }
//************* NHI NUMBER GENERATOR  ***************************************

    private final boolean IsValidNHINumberFormat(String NHINumber){
        boolean retVal = false;
        try
        {
            char[] _nhiArray = NHINumber.toUpperCase().toCharArray();
            int total = GetNHICharacterCode(_nhiArray[0]) * 7;
            total += GetNHICharacterCode(_nhiArray[1]) * 6;
            total += GetNHICharacterCode(_nhiArray[2]) * 5;
            total += Integer.parseInt(String.valueOf(_nhiArray[3])) * 4;
            total += Integer.parseInt(String.valueOf(_nhiArray[4])) * 3;
            total += Integer.parseInt(String.valueOf(_nhiArray[5])) * 2;

            int checksum = total % 11;
            if (checksum > 0)
            {
                checksum = 11 - checksum;
                if (checksum == 10)
                {
                    checksum = 0;
                }
                retVal = Integer.parseInt(String.valueOf(_nhiArray[6])) == checksum;
            }
        }
        catch (NumberFormatException e)
        {
            retVal = false;
        }
        catch (IndexOutOfBoundsException e2)
        {
            retVal = false;
        }


        return retVal;
    }

    private int GetNHICharacterCode(char nhiChar){
        int charNo = nhiChar;
        if (charNo <= 72)
        {
            charNo = charNo - 64;
        }
        else if (charNo <= 78)
        {
            charNo = charNo - 65;
        }
        else if (charNo <= 90)
        {
            charNo = charNo - 66;
        }
        return charNo;
    }
//***************  CALL ABOVE GENERATED NHI NUMBER USING HASH MAP  *************************
    public void enterNHINumber(){
        String nhiNumber = generateRandomNAHINumber();
        sendKeysToWebElement(nhinumber,nhiNumber);
        getAppData().putToMap("NHI_NUMBER",nhiNumber);
       // searchAllDHBbutton.click();
        waitAndClickElement(searchAllDHBbutton);
    }

    public void enterManagementTab(){
        System.out.println("entered management page");
        waitAndClickElement(mgmtPageLink);

    }

    public void searchWithNHINumber(){

      String storedNhiNumber=getAppData().getFromMap("NHI_NUMBER");  /* used when creating new NHI number from scratch */
        //String storedNhiNumber="UQT9330";  /* hardcode NHI number for intermediate test */
        System.out.println("Stored NHI Number"+storedNhiNumber);
        managementNhi.sendKeys(storedNhiNumber);
//        String fName=getAppData().getFromMap("FirstName");
//        existingFirstName.sendKeys(fName);
//        String sName=getAppData().getFromMap("SurName");
//        existingFirstName.sendKeys(sName);
//        System.out.println("Search firstname: "+fName);
//        System.out.println("Search surname: "+sName);
    }

    public void clickAllDHBButton(){
        waitAndClickElement(searchAllDHBbutton);

    }

    public void clickAssignProviderLink(){

        waitAndClickElement(assignProviderLink);
    }

    public void surNameLinkClick(){

        waitAndClickElement(surNameLink);
    }

    public void clickSearchButtonandConfirmChildReturnedtoCoordinator() {
        searchWithNHINumber();
        waitAndClickElement(searchButtonInAllocationTabForCoordinatorLogin);
        String storedNhiNumber=getAppData().getFromMap("NHI_NUMBER");
        System.out.println("Stored NHI Number"+storedNhiNumber);
        verifyText(NHINumberLink, getAppData().getFromMap("NHI_NUMBER"));

    }

}

