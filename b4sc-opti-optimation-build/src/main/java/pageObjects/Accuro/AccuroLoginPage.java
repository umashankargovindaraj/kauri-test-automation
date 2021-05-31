package pageObjects.Accuro;


import libs.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;


public class AccuroLoginPage extends BasePage {



    @FindBy(how = How.ID, using = "Input_UsernameVal")
    private WebElement UnAccuro;

    @FindBy(how = How.ID, using = "Input_PasswordVal")
    private WebElement PwdAccuro;

    @FindBy(how = How.ID, using = "Btn_Login")
    private WebElement SubmitButton;


    public void launchApplicationAccuro() {
        try {
            loadUrl(getPropertyValue("url"));
        } catch (Exception e) {
            Assert.fail("Application launch failed " + e.getMessage());
        }
    }

    public void enterCredentialAndLoginAccuro() {
        sendKeysToWebElement(UnAccuro, (getPropertyValue("username")));
        sendKeysToWebElement(PwdAccuro, (getPropertyValue("password")));
        clickElement(SubmitButton);
    }

}
