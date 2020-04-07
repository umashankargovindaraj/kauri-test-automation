package pageObjects.Automation105;

import cucumber.api.java.en.Then;
import libs.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SummaryPage105 extends BasePage {

    private @FindBy(xpath = "//button[@data-test-id='20161017110917023277518']")
    WebElement buttonSubmit = null;

    public void clickOnSubmit() {
        waitAndclickElementUsingJS(buttonSubmit);
    }
}
