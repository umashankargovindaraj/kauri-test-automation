package pageObjects.Accuro;

import libs.BasePage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AccuroAddNewMemberPage extends BasePage{

    @FindBy(how = How.XPATH, using = "//*[@id=\"b4-NoResultsFound\"]/button")
    private WebElement addNewMemberButton;

    @FindBy(how = How.ID, using = "b5-Dropdown_title")
    private WebElement memberTitle;

    @FindBy(how = How.ID, using = "b5-Input_FirstName")
    private WebElement memberFirstName;

    @FindBy(how = How.ID, using = "b5-Input_MiddleName")
    private WebElement memberMiddleName;

    //********* NAME GENERATOR **********************
    public String generateFirstName(){
        String firstName = RandomStringUtils.randomAlphabetic( 5);
        getAppData().putToMap("FirstName",firstName);
        return firstName;
    }

    public String generateMiddleName(){
        String middleName = RandomStringUtils.randomAlphabetic( 5);
        getAppData().putToMap("MiddleName",middleName);
        return middleName;
    }


    public void addNewMemberDetails(){
        try{
        clickElement(addNewMemberButton);
            Thread.sleep(5000);
            selectFromDropDownbyValue(memberTitle,getAppData().getElement("NAMETITLE","TITLE"));
            sendKeysToWebElement(memberFirstName,generateFirstName());
            sendKeysToWebElement(memberMiddleName,generateFirstName());
//            verifyText(memberMiddleName,generateFirstName());
}
        catch(Exception ie){
        }
    }


}
