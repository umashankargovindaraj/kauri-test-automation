package pageObjects.Accuro;

import libs.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AccuroSearchPage extends BasePage {

    @FindBy(how = How.ID, using = "b2-SearchLink")
    private WebElement SearchLink;

    @FindBy(how = How.ID, using = "b4-Input_SearchPhrase")
    public WebElement SearchText;

    @FindBy(how = How.XPATH, using = "//*[@id=\"b4-PersonSearchResultTable\"]/tbody/tr/td[1]/a/span")
    private WebElement verifyTextFirstName;

    @FindBy(how = How.XPATH, using = "//*[@id=\"b4-PersonSearchResultTable\"]/tbody/tr/td[2]/a/span")
    private WebElement verifyTextlastName;

    @FindBy(how = How.XPATH, using = "//*[@id=\"b4-PersonSearchResultTable\"]/tbody/tr/td[3]/span")
    private WebElement verifyDOB;

    @FindBy(how = How.XPATH, using = "//*[@id=\"b4-PersonSearchResultTable\"]/tbody/tr/td[4]/span")
    private WebElement verifyPhoneNo;

    @FindBy(how = How.XPATH, using = "//*[@id=\"b4-PersonSearchResultTable\"]/tbody/tr/td[5]/span")
    private WebElement verifyEmail;

    @FindBy(how = How.XPATH, using = "//*[@id=\"b4-b1-Table\"]/text()")
    private WebElement errorMsg;

    public void searchFName(){

        try{
            Thread.sleep(5000);
            waitAndClickElement(SearchLink);
            sendKeysToWebElement(SearchText,getAppData().getElement("FNAMESEARCH","FNVALUE")+ Keys.ENTER);
//            verifyText(verifyTextFirstName,"Umashankar");
            verifyText(verifyTextFirstName,getAppData().getElement("FNAMESEARCH","FNVALUE"));

        }
        catch(Exception ie){
        }
    }

    public void searchLName(){

        try{
            Thread.sleep(5000);
            waitAndClickElement(SearchLink);
            sendKeysToWebElement(SearchText,getAppData().getElement("LNAMESEARCH","LNVALUE")+ Keys.ENTER);
            verifyText(verifyTextlastName,getAppData().getElement("LNAMESEARCH","LNVALUE"));
        }
        catch(Exception ie){
        }
    }

    public void searchDOB(){

        try{
            Thread.sleep(5000);
            waitAndClickElement(SearchLink);
            sendKeysToWebElement(SearchText,getAppData().getElement("DOBSEARCH","DOBVALUE")+ Keys.ENTER);
            verifyText(verifyDOB,getAppData().getElement("DOBSEARCH","DOBVALUE"));
        }
        catch(Exception ie){
        }
    }

    public void searchPhNo(){

        try{
            Thread.sleep(5000);
            waitAndClickElement(SearchLink);
            sendKeysToWebElement(SearchText,getAppData().getElement("PHONESEARCH","PHVALUE")+ Keys.ENTER);
            verifyText(verifyPhoneNo,getAppData().getElement("PHONESEARCH","PHVALUE"));
        }
        catch(Exception ie){
        }
    }

    public void searchEmail(){

        try{
            Thread.sleep(5000);
            waitAndClickElement(SearchLink);
            sendKeysToWebElement(SearchText,getAppData().getElement("EMAILSEARCH","EMAILVALUE")+ Keys.ENTER);
            verifyText(verifyEmail,getAppData().getElement("EMAILSEARCH","EMAILVALUE"));
        }
        catch(Exception ie){
        }
    }

    public void searchFirstAndLastName(){

        try{
            Thread.sleep(5000);
            waitAndClickElement(SearchLink);
            sendKeysToWebElement(SearchText,getAppData().getElement("FIRSTANDLASTNAME","FNLN")+ Keys.ENTER);
            verifyText(verifyTextFirstName,getAppData().getElement("FNAMESEARCH","FNVALUE"));
            verifyText(verifyTextlastName,getAppData().getElement("LNAMESEARCH","LNVALUE"));
        }
        catch(Exception ie){
        }
    }

    public void searchFirstNameAndPhoneNo(){

        try{
            Thread.sleep(5000);
            waitAndClickElement(SearchLink);
            sendKeysToWebElement(SearchText,getAppData().getElement("FIRSTNAMEANDPHONENUMBER","FNPHNO")+ Keys.ENTER);
            verifyText(verifyTextFirstName,getAppData().getElement("FNAMESEARCH","FNVALUE"));
            verifyText(verifyPhoneNo,getAppData().getElement("PHONESEARCH","PHVALUE"));
        }
        catch(Exception ie){
        }
    }

    public void searchLastNameAndPhoneNo(){

        try{
            Thread.sleep(5000);
            waitAndClickElement(SearchLink);
            sendKeysToWebElement(SearchText,getAppData().getElement("LASTNAMEANDPHONENUMBER","LNPHNO")+ Keys.ENTER);
            verifyText(verifyTextlastName,getAppData().getElement("LNAMESEARCH","LNVALUE"));
            verifyText(verifyPhoneNo,getAppData().getElement("PHONESEARCH","PHVALUE"));
        }
        catch(Exception ie){
        }
    }

    public void searchEmailAndDOB(){

        try{
            Thread.sleep(5000);
            waitAndClickElement(SearchLink);
            sendKeysToWebElement(SearchText,getAppData().getElement("EMAILANDDOB","EMDOB")+ Keys.ENTER);
            verifyText(verifyEmail,getAppData().getElement("EMAILSEARCH","EMAILVALUE"));
            verifyText(verifyDOB,getAppData().getElement("DOBSEARCH","DOBVALUE"));

        }
        catch(Exception ie){
        }
    }

    public void searchFirstNameLastNameAndDOB(){

        try{
            Thread.sleep(5000);
            waitAndClickElement(SearchLink);
            sendKeysToWebElement(SearchText,getAppData().getElement("FIRSTNAMELASTNAMEANDDOB","FNLNDOB")+ Keys.ENTER);
            verifyText(verifyTextFirstName,getAppData().getElement("FNAMESEARCH","FNVALUE"));
            verifyText(verifyTextlastName,getAppData().getElement("LNAMESEARCH","LNVALUE"));
            verifyText(verifyDOB,getAppData().getElement("DOBSEARCH","DOBVALUE"));
        }
        catch(Exception ie){
        }
    }

    public void searchWithInvalidFirstNameLastName(){

        try{
            Thread.sleep(5000);
            waitAndClickElement(SearchLink);
            sendKeysToWebElement(SearchText,getAppData().getElement("INVALIDFIRSTNAMELASTNAME","FNLNINVALID")+ Keys.ENTER);
            verifyText(errorMsg,getAppData().getElement("OUTCOMEFORINVALID","ERRMSG"));
            verifyText(errorMsg,generateFirstName());

        }
        catch(Exception ie){
        }
    }

    public void methodtoenableAddNewMemberButton(){

        try{
            Thread.sleep(5000);
            waitAndClickElement(SearchLink);
            sendKeysToWebElement(SearchText,getAppData().getElement("FNAMESEARCH","FNVALUE")+ Keys.ENTER);
        }
        catch(Exception ie){
        }
    }
}
