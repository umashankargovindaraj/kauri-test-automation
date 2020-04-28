package pageObjects.BeforeSchool;

import libs.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SDQTeacherPage extends BasePage {
    //************************* TEACHER SDQ CHECK ******************************************************************************

    @FindBy(how = How.XPATH, using = "//a[@id='ctl00__pageContentPlaceHolder__b4SchoolChecks__sdqTeacher__addNewButton']")
    private WebElement sdqTeacher_AddNewButton;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__sdqParent__SDQ1__radioButton_0']")
    private WebElement sdqTeacher_Considerate;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__sdqParent__SDQ2__radioButton_0']")
    private WebElement sdqTeacher_Restless;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__sdqParent__SDQ3__radioButton_0']")
    private WebElement sdqTeacher_Somatic;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__sdqParent__SDQ4__radioButton_0']")
    private WebElement sdqTeacher_Shares;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__sdqParent__SDQ5__radioButton_0']")
    private WebElement sdqTeacher_Temper;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__sdqParent__SDQ6__radioButton_0']")
    private WebElement sdqTeacher_Solitary;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__sdqParent__SDQ7__radioButton_0']")
    private WebElement sdqTeacher_Obedience;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__sdqParent__SDQ8__radioButton_0']")
    private WebElement sdqTeacher_Worries;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__sdqParent__SDQ9__radioButton_0']")
    private WebElement sdqTeacher_Helpful;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__sdqParent__SDQ10__radioButton_0']")
    private WebElement sdqTeacher_Fidgets;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__sdqParent__SDQ11__radioButton_0']")
    private WebElement sdqTeacher_Friend;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__sdqParent__SDQ12__radioButton_0']")
    private WebElement sdqTeacher_Fights;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__sdqParent__SDQ13__radioButton_0']")
    private WebElement sdqTeacher_Unhappy;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__sdqParent__SDQ14__radioButton_0']")
    private WebElement sdqTeacher_Liked;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__sdqParent__SDQ15__radioButton_0']")
    private WebElement sdqTeacher_Distracted;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__sdqParent__SDQ16__radioButton_0']")
    private WebElement sdqTeacher_Nervous;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__sdqParent__SDQ17__radioButton_0']")
    private WebElement sdqTeacher_Kind;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__sdqParent__SDQ18__radioButton_0']")
    private WebElement sdqTeacher_Argumentative;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__sdqParent__SDQ19__radioButton_0']")
    private WebElement sdqTeacher_PickedOn;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__sdqParent__SDQ20__radioButton_0']")
    private WebElement sdqTeacher_VolunteersToHelp;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__sdqParent__SDQ21__radioButton_0']")
    private WebElement sdqTeacher_StopsAndThinks;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__sdqParent__SDQ22__radioButton_0']")
    private WebElement sdqTeacher_Spiteful;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__sdqParent__SDQ23__radioButton_0']")
    private WebElement sdqTeacher_BetterWithAdults;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__sdqParent__SDQ24__radioButton_0']")
    private WebElement sdqTeacher_Fearful;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__sdqParent__SDQ25__radioButton_0']")
    private WebElement sdqTeacher_Attention;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__sdqParent__SDQ26__radioButton_0']")
    private WebElement sdqTeacher_Difficulties;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__sdqParent__SDQ27__radioButton_0']")
    private WebElement sdqTeacher_LengthOfTime;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__sdqParent__SDQ28__radioButton_0']")
    private WebElement sdqTeacher_DistressChild;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__sdqParent__SDQ30__radioButton_0']")
    private WebElement sdqTeacher_Friendships;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__sdqParent__SDQ31__radioButton_0']")
    private WebElement sdqTeacher_Learning;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__sdqParent__SDQ33__radioButton_0']")
    private WebElement sdqTeacher_Burden;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__sdqParent__calculateScores']")
    private WebElement sdqTeacher_CalculateScoresButton;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__sdqParent__checkedBy__dateCompleted__textBox']")
    private WebElement sdqTeacher_DateCompleted;

    @FindBy(how = How.XPATH, using = "//select[@id='ctl00__pageContentPlaceHolder__sdqParent__outcome__comboBox']")
    private WebElement sdqTeacher_Outcome;

    @FindBy(how = How.XPATH, using = "//textarea[contains(@id,'ctl00__pageContentPlaceHolder__sdqParent__assessmentNotes__appendedNotes')]")
    private WebElement sdqTeacher_Notes;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__saveBtn']")
    private WebElement sdqTeacher_SaveButton;

    @FindBy(how = How.XPATH, using = "//span[@id='ctl00__pageContentPlaceHolder__b4SchoolChecks__sdqTeacher__assessmentStatus']")
    private WebElement sdqTeacher_StatusCompletedValidation;

    //---------------------- SDQ TEACHER ------------------------------------------

    public void SDQTeacher(){
        waitAndClickElement(sdqTeacher_AddNewButton);
        waitAndClickElement(sdqTeacher_Considerate);
        waitAndClickElement(sdqTeacher_Restless);
        waitAndClickElement(sdqTeacher_Somatic);
        waitAndClickElement(sdqTeacher_Shares);
        waitAndClickElement(sdqTeacher_Temper);
        waitAndClickElement(sdqTeacher_Solitary);
        waitAndClickElement(sdqTeacher_Obedience);
        waitAndClickElement(sdqTeacher_Worries);
        waitAndClickElement(sdqTeacher_Helpful);
        waitAndClickElement(sdqTeacher_Fidgets);
        waitAndClickElement(sdqTeacher_Friend);
        waitAndClickElement(sdqTeacher_Fights);
        waitAndClickElement(sdqTeacher_Unhappy);
        waitAndClickElement(sdqTeacher_Liked);
        waitAndClickElement(sdqTeacher_Distracted);
        waitAndClickElement(sdqTeacher_Nervous);
        waitAndClickElement(sdqTeacher_Kind);
        waitAndClickElement(sdqTeacher_Argumentative);
        waitAndClickElement(sdqTeacher_PickedOn);
        waitAndClickElement(sdqTeacher_VolunteersToHelp);
        waitAndClickElement(sdqTeacher_StopsAndThinks);
        waitAndClickElement(sdqTeacher_Spiteful);
        waitAndClickElement(sdqTeacher_BetterWithAdults);
        waitAndClickElement(sdqTeacher_Fearful);
        waitAndClickElement(sdqTeacher_Attention);
        waitAndClickElement(sdqTeacher_Difficulties);
        waitAndClickElement(sdqTeacher_LengthOfTime);
        waitAndClickElement(sdqTeacher_DistressChild);
        waitAndClickElement(sdqTeacher_Friendships);
        waitAndClickElement(sdqTeacher_Learning);
        waitAndClickElement(sdqTeacher_Burden);
        waitAndClickElement(sdqTeacher_CalculateScoresButton);
        sendKeysToWebElement(sdqTeacher_DateCompleted,getAppData().getElement("SDQTEACHER","DATECOMPLETED"));
        selectFromDropDownbyIndex(sdqTeacher_Outcome,1);
        sendKeysToWebElement(sdqTeacher_Notes,getAppData().getElement("SDQTEACHER","NOTES"));
        waitAndClickElement(sdqTeacher_SaveButton);
        verifyText(sdqTeacher_StatusCompletedValidation,"Completed");
        System.out.println("Status Of the Questionnaire:" + sdqTeacher_StatusCompletedValidation.getText());
    }
}
