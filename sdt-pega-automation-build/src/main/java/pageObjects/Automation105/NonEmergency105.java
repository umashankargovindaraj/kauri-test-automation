package pageObjects.Automation105;

import libs.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NonEmergency105 extends BasePage {

    private @FindBy(xpath = "//input[@data-test-id='20190512161804070513530']")
    WebElement checkBoxNonEmergency = null;
    private @FindBy(xpath = "//button[@type='button' and text()='Continue']")
    WebElement buttonContinue = null;
    private @FindBy(xpath = "//div[@data-test-id='20190821160309012730773']//input[@value='Yes']")
    WebElement nonEmergencyButtonYes = null;
    private @FindBy(xpath = "//div[@data-test-id='20190821160309012730773']//input[@value='No']")
    WebElement nonEmergencyButtonNo = null;

    public void navigateFromNonEmergencyConfirmationPagetoThreeQuestionsPage() {
        waitAndclickElementUsingJS(checkBoxNonEmergency);
        waitAndclickElementUsingJS(buttonContinue);
    }

    public void navigateFromNonEmergencyConfirmationPagetoThreeQuestionsPageMobile() {
        clickOnEmergencyButton("no");
        clickOnContinueButton();
    }

    public void clickOnEmergencyButton(String value) {
        if (value.equalsIgnoreCase("yes")) {
            waitAndclickElementUsingJS(nonEmergencyButtonYes);
        } else {
            waitAndclickElementUsingJS(nonEmergencyButtonNo);
        }

    }

    public void clickOnContinueButton() {
        waitAndclickElementUsingJS(buttonContinue);
    }
}
