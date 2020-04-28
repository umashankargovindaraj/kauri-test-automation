package pageObjects.BeforeSchool;

import libs.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ImmunisationCheckPage extends BasePage {
    //************************* IMMUNISATION CHECK ******************************************************************************

    @FindBy(how = How.XPATH, using = "//a[@id='ctl00__pageContentPlaceHolder__b4SchoolChecks__immunisation__addNewButton']")
    private WebElement immunisationCheck_AddNewButton;

    @FindBy(how = How.XPATH, using = "//select[@id='ctl00__pageContentPlaceHolder__imms__6weeks__comboBox']")
    private WebElement immunisationCheck_SixWeeks;

    @FindBy(how = How.XPATH, using = "//select[@id='ctl00__pageContentPlaceHolder__imms__3months__comboBox']")
    private WebElement immunisationCheck_ThreeMonths;

    @FindBy(how = How.XPATH, using = "//select[@id='ctl00__pageContentPlaceHolder__imms__5months__comboBox']")
    private WebElement immunisationCheck_FiveMonths;

    @FindBy(how = How.XPATH, using = "//select[@id='ctl00__pageContentPlaceHolder__imms__15months__comboBox']")
    private WebElement immunisationCheck_FifteenMonths;

    @FindBy(how = How.XPATH, using = "//select[@id='ctl00__pageContentPlaceHolder__imms__4years__comboBox']")
    private WebElement immunisationCheck_FourYears;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__imms__checkedBy__dateCompleted__textBox']")
    private WebElement immunisationCheck_DateCompleted;

    @FindBy(how = How.XPATH, using = "//select[@id='ctl00__pageContentPlaceHolder__imms__outcome__comboBox']")
    private WebElement immunisationCheck_Outcome;

    @FindBy(how = How.XPATH, using = "//textarea[contains(@id,'ctl00__pageContentPlaceHolder__imms__assessmentNotes__appendedNotes')]")
    private WebElement immunisationCheck_Notes;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__saveBtn']")
    private WebElement immunisationCheck_SaveButton;

    @FindBy(how = How.XPATH, using = "//span[@id='ctl00__pageContentPlaceHolder__b4SchoolChecks__immunisation__assessmentStatus']")
    private WebElement immunisationCheck_StatusCompletedValidation;

    //******************* IMMUNISATION CHECKS DETAILS PAGE *********************
    public void ImmunisationChecks(){
        waitAndClickElement(immunisationCheck_AddNewButton);
        selectFromDropDownbyIndex(immunisationCheck_SixWeeks,3);
        selectFromDropDownbyIndex(immunisationCheck_ThreeMonths,3);
        selectFromDropDownbyIndex(immunisationCheck_FiveMonths,3);
        selectFromDropDownbyIndex(immunisationCheck_FifteenMonths,3);
        selectFromDropDownbyIndex(immunisationCheck_FourYears,3);
        sendKeysToWebElement(immunisationCheck_DateCompleted,getAppData().getElement("IMMUNISATION","DATECOMPLETED"));
        selectFromDropDownbyIndex(immunisationCheck_Outcome,1);
        sendKeysToWebElement(immunisationCheck_Notes,getAppData().getElement("IMMUNISATION","NOTES"));
        waitAndClickElement(immunisationCheck_SaveButton);
        verifyText(immunisationCheck_StatusCompletedValidation,"Completed");
        System.out.println("Status Of the Questionnaire:" + immunisationCheck_StatusCompletedValidation.getText());

    }

}
