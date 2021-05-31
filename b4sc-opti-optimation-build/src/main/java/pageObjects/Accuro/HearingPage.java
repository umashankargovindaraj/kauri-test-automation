package pageObjects.Accuro;

import libs.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HearingPage extends BasePage {

    //-----------------------  HEARING  -----------------------------------------------------------------------------

    @FindBy(how = How.XPATH, using = "//a[@id='ctl00__pageContentPlaceHolder__b4SchoolChecks__hearing__addNewButton']")
    private WebElement hearing_AddNewButton;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__hearing__audiometryRight__radioButton_0']")
    private WebElement hearing_RightEarPassed;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__hearing__audiometryLeft__radioButton_0']")
    private WebElement hearing_LeftEarPassed;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__hearing__checkedBy__dateCompleted__textBox']")
    private WebElement hearing_DateCompleted;

    @FindBy(how = How.XPATH, using = "//select[@id='ctl00__pageContentPlaceHolder__hearing__outcome__comboBox']")
    private WebElement hearing_Outcome;

    @FindBy(how = How.XPATH, using = "//textarea[contains(@id,'ctl00__pageContentPlaceHolder__hearing__assessmentNotes__appendedNotes')]")
    private WebElement hearing_Notes;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__saveBtn']")
    private WebElement hearing_SaveButton;

    @FindBy(how = How.XPATH, using = "//span[@id='ctl00__pageContentPlaceHolder__b4SchoolChecks__hearing__assessmentStatus']")
    private WebElement hearing_StatusCompletedValidation;


    //------------------------  HEARING  ---------------------------------------
    public void hearing(){
        waitAndClickElement(hearing_AddNewButton);
        waitAndClickElement(hearing_RightEarPassed);
        waitAndClickElement(hearing_LeftEarPassed);
        sendKeysToWebElement(hearing_DateCompleted,getAppData().getElement("HEARING","DATECOMPLETED"));
        selectFromDropDownbyIndex(hearing_Outcome,1);
        sendKeysToWebElement(hearing_Notes,getAppData().getElement("HEARING","NOTES"));
        waitAndClickElement(hearing_SaveButton);
        verifyText(hearing_StatusCompletedValidation,"Completed");
        System.out.println("Status Of the Questionnaire:" + hearing_StatusCompletedValidation.getText());
    }
}
