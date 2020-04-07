package pageObjects.onlineReporting;

import libs.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GenericControls extends BasePage {

    private @FindBy(xpath = "//button[@data-test-id='20161017110917023176385']")
    WebElement buttonContinue = null;

    public void clickOnContinueButtonToFindValidationErrors() {
        waitAndclickElementUsingJSAndExit(buttonContinue);
    }

    public void clickOnCloseButtonInPopup() {
        clickOnCloseInPopup();
    }
}
