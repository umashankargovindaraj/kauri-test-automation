package pageObjects.BeforeSchool;

import libs.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DistanceVisionPage extends BasePage {

    //-----------------------  DISTANCE VISION  -----------------------------------------------------------------------------

    @FindBy(how = How.XPATH, using = "//a[@id='ctl00__pageContentPlaceHolder__b4SchoolChecks__vision__addNewButton']")
    private WebElement vision_AddNewButton;

    @FindBy(how = How.XPATH, using = "//select[@id='ctl00__pageContentPlaceHolder__vision__rightEyeScoreID__comboBox']")
    private WebElement vision_RightEyeScore;

    @FindBy(how = How.XPATH, using = "//select[@id='ctl00__pageContentPlaceHolder__vision__leftEyeScoreID__comboBox']")
    private WebElement vision_LeftEyeScore;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__vision__checkedBy__dateCompleted__textBox']")
    private WebElement vision_DateCompleted;

    @FindBy(how = How.XPATH, using = "//select[@id='ctl00__pageContentPlaceHolder__vision__outcome__comboBox']")
    private WebElement vision_Outcome;

    @FindBy(how = How.XPATH, using = "//textarea[contains(@id,'ctl00__pageContentPlaceHolder__vision__assessmentNotes__appendedNotes')]")
    private WebElement vision_Notes;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__saveBtn']")
    private WebElement vision_SaveButton;

    @FindBy(how = How.XPATH, using = "//span[@id='ctl00__pageContentPlaceHolder__b4SchoolChecks__vision__assessmentStatus']")
    private WebElement vision_StatusCompletedValidation;

    @FindBy(how = How.XPATH, using = "//span[@id='ctl00__pageContentPlaceHolder__b4SchoolChecks__vision__assessmentOutcome']")
    private WebElement vision_StatusInProgressValidation;

    //------------------------  DISTANCE VISION  ---------------------------------------
    public void distanceVision(){
        waitAndClickElement(vision_AddNewButton);
        selectFromDropDownbyIndex(vision_RightEyeScore,1);
        selectFromDropDownbyIndex(vision_LeftEyeScore,1);
        sendKeysToWebElement(vision_DateCompleted,getAppData().getElement("HEARING","DATECOMPLETED"));
        selectFromDropDownbyIndex(vision_Outcome,1);
        sendKeysToWebElement(vision_Notes,getAppData().getElement("HEARING","NOTES"));
        waitAndClickElement(vision_SaveButton);
        verifyText(vision_StatusCompletedValidation,"Completed");
        System.out.println("Status Of the Questionnaire:" + vision_StatusCompletedValidation.getText());
    }

    public void distanceVisionReferred(){
        waitAndClickElement(vision_AddNewButton);
        sendKeysToWebElement(vision_DateCompleted,getAppData().getElement("HEARING","DATECOMPLETED"));
        selectFromDropDownbyIndex(vision_Outcome,2);
        waitAndClickElement(vision_SaveButton);
        _ConsentPage.b4SchoolLink();
        verifyText(vision_StatusInProgressValidation,getAppData().getElement("HEARING","VERIFYREFERRED"));
        System.out.println("Status Of the Questionnaire:" + vision_StatusInProgressValidation.getText());
    }
}
