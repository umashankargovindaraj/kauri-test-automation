package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/java/features/OnlineReporting/onlineReporting.feature"},
        glue = {"features/OnlineReporting/StepDefinitions/"},
        monochrome = true,
        strict = true,
        plugin = {"json:target/cucumber-report-feature-composite.json","html:target/cucumber-html-report"},
        dryRun = false,
        tags = {"@ToBeUpdated"}
        //tags = {"@post-go-live-2"}
        //tags = {"@e2eLostWeb"}
)
public class onlineReportingTestRunner extends AbstractTestNGCucumberTests {

}
