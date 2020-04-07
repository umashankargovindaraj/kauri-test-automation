package pageObjects.onlineReporting;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import libs.BasePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.time.Duration;

public class NonEmergency extends BasePage {

    private @FindBy(xpath = "//img[@data-test-id='20190905085922096285c197b7-fe98-4b1d-a599-2d7399666a71245']")
    WebElement imageCallUsIcon = null;
    private @FindBy(xpath = "//input[@data-test-id='20190512161804070513530']")
    WebElement checkBoxNonEmergency = null;
    private @FindBy(xpath = "//button[@type='button' and text()='Continue']")
    WebElement buttonContinue = null;
    private @FindBy(xpath = "//div[text()='105 Online Reporting']")
    WebElement headerOnlineReporting = null;
    private @FindBy(xpath = "//div[@data-test-id='201806191352060317785']//div[contains(text(),'This is to report non-emergency events')]")
    WebElement nonEmergencyErrorMessage = null;
    private @FindBy(xpath = "//div[@data-test-id='20190821160309012730773']//input[@value='Yes']")
    WebElement nonEmergencyButtonYes = null;
    private @FindBy(xpath = "//div[@data-test-id='20190821160309012730773']//input[@value='No']")
    WebElement nonEmergencyButtonNo = null;
    private @FindBy(xpath = "//div[@data-test-id='201806191352060317785']")
    WebElement labelNonEmergencyError = null;
    private @FindBy(xpath = "//span[@data-test-id='20190821154700053081360']/parent::div/span[2]/span/strong")
    WebElement tenFiveText = null;
    private @FindBy(xpath = "//span[@data-test-id='20190821154700053081360']/parent::div/span[3]/span/strong")
    WebElement beforeYouStartText = null;
    private @FindBy(xpath = "//span[@data-test-id='20190821154700053081360']/parent::div/ul/li[1]/span/span")
    WebElement detailsText = null;
    private @FindBy(xpath = "//span[@data-test-id='20190821154700053081360']/parent::div/ul/li[2]/span/span")
    WebElement allowText = null;
    private @FindBy(xpath = "//span[@data-test-id='20190821154700053081360']/parent::div/ul/li[3]/span/span")
    WebElement completeLaterText = null;
    private @FindBy(xpath = "//span[@data-test-id='20190821154700053081360']/parent::div/div/span/span/strong")
    WebElement emergencyCallText = null;
    private @FindBy(xpath = "//span[@data-test-id='20190821154700053081360']/parent::div/div/ul/li[1]/span/span")
    WebElement call111Text = null;
    private @FindBy(xpath = "//span[@data-test-id='20190821154700053081360']/parent::div/div/ul/li[2]/span/span")
    WebElement operatorText = null;
    private @FindBy(xpath = "//span[@data-test-id='20190821154700053081360']/parent::div/div/ul/li[3]/span/span")
    WebElement cantDecideText = null;
    private @FindBy(xpath = "//span[@data-test-id='20190821154700053081360']/parent::div/div/ul/li[4]/span/span")
    WebElement emergencyText = null;

    private @FindBy(xpath = "//span[text()='Call 111 when a Protection Order has been breached.']")
    WebElement labelMissingPerson = null;

    public WebElement getTenFiveText() {
        return tenFiveText;
    }

    public void clickOnEmergencyButton(String value) {
        if (value.equalsIgnoreCase("yes")) {
            waitAndclickElementUsingJS(nonEmergencyButtonYes);
        } else {
            waitAndclickElementUsingJS(nonEmergencyButtonNo);
        }

    }

    public String getNonEmergencyErrorMessage() {
        return waitandGetText(nonEmergencyErrorMessage);
    }


    public boolean checkIfOnlinereportingHeaderIsDisplayed() {
        return isElementDisplayed(headerOnlineReporting);
    }

    public void clickOnNonEmergencyCheckbox() {
        waitAndclickElementUsingJS(checkBoxNonEmergency);
    }

    public void clickOnContinueButton() {
        waitAndclickElementUsingJS(buttonContinue);
    }

    public boolean checkIfNonEmergencyErrorIsDisplayed() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return isElementDisplayed(labelNonEmergencyError);
    }

    public void navigateFromNonEmergencyConfirmationPagetoThreeQuestionsPage() {
        clickOnNonEmergencyCheckbox();
        clickOnContinueButton();
    }

    public void navigateFromNonEmergencyConfirmationPagetoThreeQuestionsPageMobile() {
        clickOnEmergencyButton("no");
        clickOnContinueButton();
    }

    public void verifyGettingStartedInstructions() {
        Assert.assertEquals(tenFiveText.getText().trim(), _generateTestData.generateValidData("LetsGetStarted.tenFiveText"));
        Assert.assertEquals(beforeYouStartText.getText().trim(), _generateTestData.generateValidData("LetsGetStarted.beforeYouStartText"));
        Assert.assertEquals(detailsText.getText().trim(), _generateTestData.generateValidData("LetsGetStarted.provideDetailsText"));
        Assert.assertEquals(allowText.getText().trim(), _generateTestData.generateValidData("LetsGetStarted.allowTenText"));
        Assert.assertEquals(completeLaterText.getText().trim(), _generateTestData.generateValidData("LetsGetStarted.saveLaterText"));
        Assert.assertEquals(emergencyCallText.getText().trim(), _generateTestData.generateValidData("LetsGetStarted.emergencyCallTest"));
        Assert.assertEquals(call111Text.getText().trim(), _generateTestData.generateValidData("LetsGetStarted.call11Text"));
        Assert.assertEquals(operatorText.getText().trim(), _generateTestData.generateValidData("LetsGetStarted.operatorText"));
        Assert.assertEquals(cantDecideText.getText().trim(), _generateTestData.generateValidData("LetsGetStarted.cantDecideText"));
        Assert.assertEquals(emergencyText.getText().trim(), _generateTestData.generateValidData("LetsGetStarted.txtServiceText"));
    }

    public void checkEvents() {
        _whatHappened.checkDamagedToggleDeSelectedMobile();
    }

    public boolean checkMissingPersonInformation() {
        return isDisplayed(labelMissingPerson);
    }
}
