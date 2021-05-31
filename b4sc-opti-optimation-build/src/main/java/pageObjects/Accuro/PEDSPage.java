package pageObjects.Accuro;

import libs.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PEDSPage extends BasePage {

    //************************* PEDS CHECK ******************************************************************************

    @FindBy(how = How.XPATH, using = "//a[@id='ctl00__pageContentPlaceHolder__b4SchoolChecks__peds__addNewButton']")
    private WebElement peds_AddNewButton;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__ped__concernQ1__radioButton_1']")
    private WebElement peds_Cognitive;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__ped__concernQ2__radioButton_1']")
    private WebElement peds_ExpressiveLanguageAndArticulation;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__ped__concernQ3__radioButton_1']")
    private WebElement peds_ReceptiveLanguage;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__ped__concernQ4__radioButton_1']")
    private WebElement peds_FineMotor;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__ped__concernQ5__radioButton_1']")
    private WebElement peds_GrossMotor;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__ped__concernQ6__radioButton_1']")
    private WebElement peds_Behaviour;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__ped__concernQ7__radioButton_1']")
    private WebElement peds_SocialEmotional;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__ped__concernQ8__radioButton_1']")
    private WebElement peds_SelfHelp;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__ped__concernQ9__radioButton_1']")
    private WebElement peds_School;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__ped__shadedScore__textBox']")
    private WebElement peds_CirclesScore;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__ped__unshadedScore__textBox']")
    private WebElement peds_SquaresScore;

    @FindBy(how = How.XPATH, using = "//select[@id='ctl00__pageContentPlaceHolder__ped__PEDSPathwayType__comboBox']")
    private WebElement peds_PathWayType;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__ped__checkedBy__dateCompleted__textBox']")
    private WebElement peds_DateCompleted;

    @FindBy(how = How.XPATH, using = "//select[@id='ctl00__pageContentPlaceHolder__ped__outcome__comboBox']")
    private WebElement peds_Outcome;

    @FindBy(how = How.XPATH, using = "//textarea[contains(@id,'ctl00__pageContentPlaceHolder__ped__assessmentNotes__appendedNotes')]")
    private WebElement peds_Notes;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__saveBtn']")
    private WebElement peds_SaveButton;

    @FindBy(how = How.XPATH, using = "//span[@id='ctl00__pageContentPlaceHolder__b4SchoolChecks__peds__assessmentStatus']")
    private WebElement peds_StatusCompletedValidation;


    //******************* PEDS ************************************************
    public void parentalEvaluationOfDevelopmentalStatus_PEDS(){
        waitAndClickElement(peds_AddNewButton);
        waitAndClickElement(peds_Cognitive);
        waitAndClickElement(peds_ExpressiveLanguageAndArticulation);
        waitAndClickElement(peds_ReceptiveLanguage);
        waitAndClickElement(peds_FineMotor);
        waitAndClickElement(peds_GrossMotor);
        waitAndClickElement(peds_Behaviour);
        waitAndClickElement(peds_SocialEmotional);
        waitAndClickElement(peds_SelfHelp);
        waitAndClickElement(peds_School);
        sendKeysToWebElement(peds_CirclesScore,getAppData().getElement("PEDS","CIRCLESCORE"));
        sendKeysToWebElement(peds_SquaresScore,getAppData().getElement("PEDS","SQUARESCORE"));
        selectFromDropDownbyIndex(peds_PathWayType,1);
        sendKeysToWebElement(peds_DateCompleted,getAppData().getElement("PEDS","DATECOMPLETED"));
        selectFromDropDownbyIndex(peds_Outcome,1);
        sendKeysToWebElement(peds_Notes,getAppData().getElement("PEDS","NOTES"));
        waitAndClickElement(peds_SaveButton);
        verifyText(peds_StatusCompletedValidation,"Completed");
        System.out.println("Status Of the Questionnaire:" + peds_StatusCompletedValidation.getText());
    }
}
