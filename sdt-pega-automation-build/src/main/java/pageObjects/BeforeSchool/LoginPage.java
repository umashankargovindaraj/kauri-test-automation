package pageObjects.BeforeSchool;

import libs.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import java.io.IOException;

import static org.testng.reporters.jq.BasePanel.S;

public class LoginPage extends BasePage {
    @FindBy(how = How.XPATH, using = "//input[@id='_loginControl_UserName']")
    private WebElement username;

    @FindBy(how = How.XPATH, using = "//input[@id='_loginControl_Password']")
    private WebElement password;

    @FindBy(how = How.XPATH, using = "//input[@id='_loginControl_LoginButton']")
    private WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'SectionBlock Clearfix')]/h1")
    private WebElement childAllocationButton;

    public void launchApplication() {
        try {
            loadUrl(testEnvironment.getAppURL());
        } catch (Exception e) {
            Assert.fail("Application launch failed " + e.getMessage());
            System.out.println("comment by Uma");
        }
    }

    public void login() {
        sendKeysToWebElement(username, "LancashireA");
        sendKeysToWebElement(password, "Welcome13");
        clickElement(loginButton);
    }

    public void AssertHomePage() {
        isElementDisplayed(childAllocationButton);
    }
}


