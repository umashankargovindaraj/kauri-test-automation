package features.OnlineReportingMobile.StepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import libs.DriverFactory;
import libs.ResultSender;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import java.net.MalformedURLException;

public class MasterHooksMobile extends DriverFactory {

    private ResultSender resultSender = new ResultSender();

    @Before
    public void setup(cucumber.api.Scenario cukeScenario) {
        String scenarioName = cukeScenario.getName();
        _appiumDriver = getMobileDriver(scenarioName, "onlineReportingMobile");
    }

    @After
    public void tearDownAndScreenShotOnFailure(cucumber.api.Scenario cukeScenario) {

        scenarios.setScenarioName(cukeScenario.getName());
        //sessionStatus(cukeScenario.isFailed());
        try {
            if (_appiumDriver != null && cukeScenario.isFailed()) {
                cukeScenario.embed(((TakesScreenshot) _appiumDriver).getScreenshotAs(OutputType.BYTES), "image/png");
                scenarios.setTestStatus("Fail");
            } else if (!cukeScenario.isFailed()) {
                scenarios.setTestStatus("Pass");
            }
            if (_appiumDriver != null) {
                _appiumDriver.manage().deleteAllCookies();
                _appiumDriver.quit();
                _driver.quit();
                _appiumDriver = null;
                _driver = null;
            }
            deleteTestFiles();
        } catch (Exception e) {
            System.out.println("Methods failed: tearDownAndScreenShotOnFailure, Exception: " + e.getMessage());
        }
        //resultSender.sendResultsToElasticSearch(getPropertyValue("elasticSearch"), scenarios);
    }

    public void sessionStatus(boolean hasTestFailed) {
        SessionId session = null;
        if (_appiumDriver instanceof RemoteWebDriver) {
            session = ((RemoteWebDriver) _appiumDriver).getSessionId();
        }
        String url = getPropertyValue("browserStack").replace("<session>", session.toString());
        String status = "passed";
        String reason = "Test Passed";
        if (hasTestFailed) {
            status = "failed";
            reason = "Test Failed";
        }
        resultSender.sendResultsToBrowserStack(url, status, reason, getBSPropertyValue("BROWSERSTACK_USERNAME"), getBSPropertyValue("BROWSERSTACK_TOKEN"));

    }

}
