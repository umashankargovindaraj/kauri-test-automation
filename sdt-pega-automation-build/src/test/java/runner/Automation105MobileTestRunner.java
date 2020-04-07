package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/java/features/Automation105Mobile/Automation105Mobile.feature"},
        glue = {"features/Automation105Mobile/StepDefinitions"},
        monochrome = true,
        strict = true,
        plugin = {"json:target/cucumber-report-feature-composite.json", "html:target/cucumber-html-report"},
        dryRun = false,
        tags = {"@Scenario_8"}
)
public class Automation105MobileTestRunner extends AbstractTestNGCucumberTests {

}
