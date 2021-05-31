package pageObjects.Accuro;

import libs.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.awt.*;

public class ReturnChildToCoordinatorPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//span[@id='ctl00__DHBCoordinator__text']")
    private WebElement allocationHistoryLink;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__returnRecord__providerContactNumber__textBox']")
    private WebElement providerContactNumber;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__returnRecord__reason__textBox']")
    private WebElement ressonForReturningChild;

    @FindBy(how = How.XPATH, using = "//input[contains(@id,'ctl00__pageContentPlaceHolder__returnRecord__returnRecordButton')]")
    private WebElement returnSubmitButton;

    @FindBy(how = How.XPATH, using = "//span[@id='ctl00__pageContentPlaceHolder__allocationHistory__allocations_repeater_ctl00__pageLink__linkLabel']")
    private WebElement verifyCoordinatorReturnConfimationText;

    @FindBy(how = How.XPATH, using = "//span[@id='ctl00__LeadProvider__text']")
    private WebElement providerNotesLink;

    @FindBy(how = How.XPATH, using = "//textarea[@id='ctl00__pageContentPlaceHolder__urgentNotes__notes__appendedNotes']")
    private WebElement providerNotes;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__saveBtn']")
    private WebElement providerNotesSaveButton;

    public void returnChildToCoordinator() throws InterruptedException, AWTException {
        waitAndClickElement(allocationHistoryLink);
        sendKeysToWebElement(providerContactNumber,getAppData().getElement("RETURNCHILDTOCOORDINATOR","PROVIDERCONTACTNUMBER"));
        sendKeysToWebElement(ressonForReturningChild,getAppData().getElement("RETURNCHILDTOCOORDINATOR","REASONFORRETURNINGCHILD"));
//        waitAndClickElement(returnSubmitButton);
        (returnSubmitButton).click();
        checkPopupIsVisible();
        isAlertPresent();
        closeAlertPopupBox();
        verifyTextPartially(verifyCoordinatorReturnConfimationText,getAppData().getElement("RETURNCHILDTOCOORDINATOR","VERIFYTEXT"));
        System.out.println("Status Of the Questionnaire:" + verifyCoordinatorReturnConfimationText.getText());

    }

    public void enterProviderNotes(){
        waitAndClickElement(providerNotesLink);
        sendKeysToWebElement(providerNotes,getAppData().getElement("RETURNCHILDTOCOORDINATOR","PROVIDERNOTES"));
//        sendKeysToWebElement(providerNotes,"HELLO");
        waitAndClickElement(providerNotesSaveButton);

    }

}
