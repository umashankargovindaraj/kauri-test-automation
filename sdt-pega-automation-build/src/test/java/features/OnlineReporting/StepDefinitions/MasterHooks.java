package features.OnlineReporting.StepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import libs.DriverFactory;
import libs.ResultSender;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.Assert;

import java.net.MalformedURLException;

public class MasterHooks extends DriverFactory {

    private ResultSender resultSender;

    @Before
    public void setup(cucumber.api.Scenario cukeScenario) throws MalformedURLException {
        String scenarioName = cukeScenario.getName();
        _driver = getWebDriver(scenarioName,"");
    }

    @After
    public void tearDownAndScreenShotOnFailure(cucumber.api.Scenario cukeScenario) {
        resultSender = new ResultSender();
        scenarios.setScenarioName(cukeScenario.getName());
        //sessionStatus(cukeScenario.isFailed());
        try {
            if (_driver != null && cukeScenario.isFailed()) {
                cukeScenario.embed(((TakesScreenshot) _driver).getScreenshotAs(OutputType.BYTES), "image/png");
                scenarios.setTestStatus("Fail");
            } else if (!cukeScenario.isFailed()) {
                scenarios.setTestStatus("Pass");
            }
            if (_driver != null) {
                _driver.manage().deleteAllCookies();
                _driver.quit();
                _appiumDriver.quit();
                _driver = null;
                _appiumDriver = null;
            }
            deleteTestFiles();
        } catch (Exception e) {
            System.out.println("Methods failed: tearDownAndScreenShotOnFailure, Exception: " + e.getMessage());
        }
        //resultSender.sendResultsToElasticSearch(getPropertyValue("elasticSearch"), scenarios);
    }


    public void sessionStatus(boolean hasTestFailed) {
        SessionId session = null;
        if (_driver instanceof RemoteWebDriver) {
            session = ((RemoteWebDriver) _driver).getSessionId();
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
