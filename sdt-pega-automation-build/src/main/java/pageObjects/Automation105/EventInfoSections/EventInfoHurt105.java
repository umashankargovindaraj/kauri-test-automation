package pageObjects.Automation105.EventInfoSections;

import libs.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EventInfoHurt105 extends BasePage {

    private @FindBy(xpath = "//textarea[@data-test-id='20190412152847098116814']")
    WebElement textareaWhowasThreatened = null;
    private @FindBy(xpath = "//textarea[@data-test-id='2019062010301008638475']")
    WebElement textareaHowtheywereThreatenedOrHurt = null;

    public void keyInDataOnHurtRelatedFields() {
        sendKeysToWebElement(textareaWhowasThreatened, _retrieveTestData.extractDataOffDataFile("whoWasHurt.whoWasHurt"));
        sendKeysToWebElement(textareaHowtheywereThreatenedOrHurt, _retrieveTestData.extractDataOffDataFile("whoWasHurt.howWasHurt"));
    }
}
