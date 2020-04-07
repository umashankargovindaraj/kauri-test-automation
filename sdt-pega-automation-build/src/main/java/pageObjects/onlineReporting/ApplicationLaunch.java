package pageObjects.onlineReporting;


import libs.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class ApplicationLaunch extends BasePage {

    private static boolean isPoliceNetwork = false;

    private @FindBy(xpath = "//p[contains(text(),'Start your report now')]")
    WebElement startReportNowLink = null;

    public ApplicationLaunch() {
        super();
    }

    public void clickOnStartReportNow() {
        new WebDriverWait(_driver, 10).until(ExpectedConditions.elementToBeClickable(startReportNowLink)).click();
    }

    public boolean check105LandingPageIsDisplayed() {
        return new WebDriverWait(_driver, 10).until(ExpectedConditions.urlContains("105"));
    }

    public boolean getIsPoliceNetworkFlag() {
        return isPoliceNetwork;
    }

    public void launchWebApplication() throws IOException {
        String url = testEnvironment.getAppURL();
        loadUrl(url);
        Assert.assertTrue(_eventInfo.checkIfOnlineReportingPageIsDisplayed(), "Online Reporting form is not displayed");
    }

    public void switchToFrame() {
        switchToBrowserFrame();
    }
}
