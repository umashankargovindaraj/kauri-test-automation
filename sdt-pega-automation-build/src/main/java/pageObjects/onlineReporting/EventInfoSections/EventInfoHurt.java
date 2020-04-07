package pageObjects.onlineReporting.EventInfoSections;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EventInfoHurt extends EventInfo {

    private @FindBy(xpath = "//label[@data-test-id='20190412152847098116814-Label']")
    WebElement labelWhowasThreatened = null;
    private @FindBy(xpath = "//textarea[@data-test-id='20190412152847098116814']")
    WebElement textareaWhowasThreatened = null;
    private @FindBy(xpath = "//label[@data-test-id='2019062010301008638475-Label']")
    WebElement labelHowtheywereThreatenedOrHurt = null;
    private @FindBy(xpath = "//textarea[@data-test-id='2019062010301008638475']")
    WebElement textareaHowtheywereThreatenedOrHurt = null;
    private @FindBy(xpath = "//div[@data-test-id='201905231724330528583']")
    WebElement sectionHurtOrThreatened = null;
    private @FindBy(xpath = "//button[@data-test-id='20161017110917023176385']")
    WebElement buttonContinueFromHurtPage = null;

    public boolean checkHurtRelatedFields() {
        isElementDisplayed(labelWhowasThreatened);
        isElementDisplayed(textareaWhowasThreatened);
        isElementDisplayed(labelHowtheywereThreatenedOrHurt);
        isElementDisplayed(textareaHowtheywereThreatenedOrHurt);
        return true;
    }

    public void keyInDataOnHurtRelatedFields() {
        sendKeysToWebElement(textareaWhowasThreatened, _generateTestData.generateValidData("whoWasHurt.whoWasHurt"));
        sendKeysToWebElement(textareaHowtheywereThreatenedOrHurt, _generateTestData.generateValidData("whoWasHurt.howWasHurt"));
    }

    public boolean checkIfHurtDetailsSectionIsDisplayed() {
        return isElementDisplayed(sectionHurtOrThreatened);
    }


    public void clickOnContinueFromHurtPage(){
        waitAndclickElementUsingJS(buttonContinueFromHurtPage);
    }
}
