package pageObjects.Automation105;

import libs.BasePage;
import org.testng.Assert;

import java.io.IOException;

public class ApplicationLaunch105 extends BasePage {

    public void launchWebApplication() throws IOException {
        loadUrl(testEnvironment.getAppURL());
//        Assert.assertTrue(_eventInfo.checkIfOnlineReportingPageIsDisplayed(), "Online Reporting form is not displayed");
    }

}
