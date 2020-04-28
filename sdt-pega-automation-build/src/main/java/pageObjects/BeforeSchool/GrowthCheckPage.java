package pageObjects.BeforeSchool;

import libs.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GrowthCheckPage extends BasePage {

    //************************* GROWTH CHECK ******************************************************************************

    @FindBy(how = How.XPATH, using = "//a[@id='ctl00__pageContentPlaceHolder__b4SchoolChecks__growth__addNewButton']")
    private WebElement growthCheck_AddNewButton;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__growth__height__textBox']")
    private WebElement growthCheck_Height;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__growth__weight__textBox']")
    private WebElement growthCheck_Weight;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__growth__dateEntered__textBox']")
    private WebElement growthCheck_DateEntered;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__growth__calcPercentilesButton']")
    private WebElement growthCheck_CalculatePercentilesButton;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__growth__checkedBy__dateCompleted__textBox']")
    private WebElement growthCheck_DateCompleted;

    @FindBy(how = How.XPATH, using = "//select[@id='ctl00__pageContentPlaceHolder__growth__outcome__comboBox']")
    private WebElement growthCheck_Outcome;

    @FindBy(how = How.XPATH, using = "//textarea[contains(@id,'ctl00__pageContentPlaceHolder__growth__assessmentNotes__appendedNotes')]")
    private WebElement growthCheck_Notes;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__saveBtn']")
    private WebElement growthCheck_SaveButton;

    @FindBy(how = How.XPATH, using = "//span[@id='ctl00__pageContentPlaceHolder__b4SchoolChecks__growth__assessmentStatus']")
    private WebElement growthCheck_StatusCompletedValidation;

    //******************* GROWTH CHECKS DETAILS PAGE *********************
    public void growthChecks(){
        waitAndClickElement(growthCheck_AddNewButton);
        sendKeysToWebElement(growthCheck_Height,getAppData().getElement("GROWTHCHECK","HEIGHT"));
        sendKeysToWebElement(growthCheck_Weight,getAppData().getElement("GROWTHCHECK","WEIGHT"));
        sendKeysToWebElement(growthCheck_DateEntered,getAppData().getElement("GROWTHCHECK","DATEENTERED"));
        waitAndClickElement(growthCheck_CalculatePercentilesButton);
        sendKeysToWebElement(growthCheck_DateCompleted,getAppData().getElement("GROWTHCHECK","DATECOMPLETED"));
        selectFromDropDownbyIndex(growthCheck_Outcome,1);
        sendKeysToWebElement(growthCheck_Notes,getAppData().getElement("GROWTHCHECK","NOTES"));
        waitAndClickElement(growthCheck_SaveButton);
        verifyText(growthCheck_StatusCompletedValidation,"Completed");
        System.out.println("Status Of the Questionnaire:" + growthCheck_StatusCompletedValidation.getText());

    }

}
