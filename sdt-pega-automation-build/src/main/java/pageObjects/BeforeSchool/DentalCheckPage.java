package pageObjects.BeforeSchool;

import libs.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DentalCheckPage extends BasePage {
    //************************* DENTAL CHECK ******************************************************************************

    @FindBy(how = How.XPATH, using = "//a[@id='ctl00__pageContentPlaceHolder__b4SchoolChecks__dental__addNewButton']")
    private WebElement dentalCheck_AddNewButton;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__dental__liftTheLip__textBox']")
    private WebElement dentalCheck_ProgressionOfDecay;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__dental__enrolment__radioButton_0']")
    private WebElement dentalCheck_IsEnrolled;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__dental__checkedBy__dateCompleted__textBox']")
    private WebElement dentalCheck_DateCompleted;

    @FindBy(how = How.XPATH, using = "//select[@id='ctl00__pageContentPlaceHolder__dental__outcome__comboBox']")
    private WebElement dentalCheck_Outcome;

    @FindBy(how = How.XPATH, using = "//textarea[contains(@id,'ctl00__pageContentPlaceHolder__dental__assessmentNotes__appendedNotes')]")
    private WebElement dentalCheck_Notes;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__saveBtn']")
    private WebElement dentalCheck_SaveButton;

    @FindBy(how = How.XPATH, using = "//span[@id='ctl00__pageContentPlaceHolder__b4SchoolChecks__dental__assessmentStatus']")
    private WebElement dentalCheck_StatusCompletedValidation;

    //******************* DENTAL CHECKS DETAILS PAGE *********************
    public void dentalChecks(){
        waitAndClickElement(dentalCheck_AddNewButton);
        sendKeysToWebElement(dentalCheck_ProgressionOfDecay,getAppData().getElement("DENTALCHECK","PROGRESSIONOFDECAY"));
        waitAndClickElement(dentalCheck_IsEnrolled);
        sendKeysToWebElement(dentalCheck_DateCompleted,getAppData().getElement("DENTALCHECK","DATE"));
        selectFromDropDownbyIndex(dentalCheck_Outcome,1);
        sendKeysToWebElement(dentalCheck_Notes,getAppData().getElement("DENTALCHECK","NOTES"));
        waitAndClickElement(dentalCheck_SaveButton);
        verifyText(dentalCheck_StatusCompletedValidation,"Completed");
        System.out.println("Status Of the Questionnaire:" + dentalCheck_StatusCompletedValidation.getText());

    }
}
