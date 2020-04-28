package pageObjects.BeforeSchool;

import libs.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ChildHealthCheckPage extends BasePage {

    //********************************* Child Health Questionnaire ******************************************************************
    @FindBy(how = How.XPATH, using = "//a[@id='ctl00__pageContentPlaceHolder__b4SchoolChecks__generalHealth__addNewButton']")
    private WebElement questionnaire_AddNewButton;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__generalHealth__general__medicalCentrePhone__textBox']")
    private WebElement questionnaire_phone;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__generalHealth__hospital__beenInHospital__radioButton_1']")
    private WebElement questionnaire_timeInHospital;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__generalHealth__hasConcernsAboutDentalHealth__no']")
    private WebElement questionnaire_childTeeth;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__generalHealth__wearsGlasses__no']")
    private WebElement questionnaire_WearGlasses;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__generalHealth__grommetsTubes__radioButton_1']")
    private WebElement questionnaire_EarGrommetsInserted;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__generalHealth__earOtherProblems__no']")
    private WebElement questionnaire_EarProblemOthers;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__generalHealth__gettingHelpFromServices__no']")
    private WebElement questionnaire_CaregiverCurrentHelpFromService;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__generalHealth__hasConcernsAboutToileting__no']")
    private WebElement questionnaire_CaregiverConcernAbtToileting;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__generalHealth__hasConcernsAboutSleeping__no']")
    private WebElement questionnaire_CaregiverConcernAbtSleeping;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__generalHealth__hasConcernsAboutEating__no']")
    private WebElement questionnaire_CaregiverConcernAbtEating;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__generalHealth__doesAnyoneSmokeIndoor__no']")
    private WebElement questionnaire_CaregiverSmokeIndoors;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__generalHealth__otherInformation__no']")
    private WebElement questionnaire_CaregiverAnyOtherConcernsSharedWithNurse;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__generalHealth__checkedBy__dateCompleted__textBox']")
    private WebElement questionnaire_QuestionaireDateCompleted;

    @FindBy(how = How.XPATH, using = "//select[@id='ctl00__pageContentPlaceHolder__generalHealth__outcome__comboBox']")
    private WebElement questionnaire_QuestionaireOutcome;

    @FindBy(how = How.XPATH, using = "//textarea[contains(@id,'ctl00__pageContentPlaceHolder__generalHealth__assessmentNotes__appendedNotes')]")
    private WebElement questionnaire_QuestionaireNotes;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__saveBtn']")
    private WebElement questionnaire_SaveButton;

    @FindBy(how = How.XPATH, using = "//span[@id='ctl00__pageContentPlaceHolder__b4SchoolChecks__generalHealth__assessmentStatus']")
    private WebElement questionnaire_StatusCompletedValidation;
//--------------------------------------------------------------------------------------------------------------------------
//******************* CHILD HEALTH QUESTIONAIRE DETAILS PAGE *********************
public void ChildHealthQuestionnaire(){
    waitAndClickElement(questionnaire_AddNewButton);
//    sendKeysToWebElement(questionnaire_phone,getAppData().getElement("CHILDHEALTHQUESTIONAIRE","MEDICALCENTREPHONE"));
    waitAndClickElement(questionnaire_timeInHospital);
    waitAndClickElement(questionnaire_childTeeth);
    waitAndClickElement(questionnaire_WearGlasses);
    waitAndClickElement(questionnaire_EarGrommetsInserted);
    waitAndClickElement(questionnaire_EarProblemOthers);
    waitAndClickElement(questionnaire_CaregiverCurrentHelpFromService);
    waitAndClickElement(questionnaire_CaregiverConcernAbtToileting);
    waitAndClickElement(questionnaire_CaregiverConcernAbtSleeping);
    waitAndClickElement(questionnaire_CaregiverConcernAbtEating);
    waitAndClickElement(questionnaire_CaregiverSmokeIndoors);
    waitAndClickElement(questionnaire_CaregiverAnyOtherConcernsSharedWithNurse);
    sendKeysToWebElement(questionnaire_QuestionaireDateCompleted,getAppData().getElement("CHILDHEALTHQUESTIONAIRE","DATE"));
    selectFromDropDownbyIndex(questionnaire_QuestionaireOutcome,1);
    sendKeysToWebElement(questionnaire_QuestionaireNotes,getAppData().getElement("CHILDHEALTHQUESTIONAIRE","NOTES"));
    waitAndClickElement(questionnaire_SaveButton);
    verifyText(questionnaire_StatusCompletedValidation,"Completed");
    System.out.println("Status Of the Questionnaire:" + questionnaire_StatusCompletedValidation.getText());

}
}
