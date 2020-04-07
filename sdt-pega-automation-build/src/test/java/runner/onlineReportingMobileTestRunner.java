package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/java/features/OnlineReportingMobile/onlineReportingMobile.feature"},
        glue = {"features/OnlineReportingMobile/StepDefinitions"},
        monochrome = true,
        strict = true,
        plugin = "json:target/cucumber-report-feature-composite.json",
        dryRun = false,
        tags = {"@e2eLostMobile"}
        //tags = {"@post-go-live-1"}
        //tags = {"@e2eLostMobile"}
)
public class onlineReportingMobileTestRunner extends AbstractTestNGCucumberTests {

}
