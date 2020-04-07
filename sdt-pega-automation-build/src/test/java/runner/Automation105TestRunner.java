package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/java/features/Automation105/Automation105_Feb12.feature"},
        glue = {"features/Automation105/StepDefinitions"},
        monochrome = true,
        strict = true,
        plugin = {"json:target/cucumber-report-feature-composite.json","html:target/cucumber-html-report"},
        dryRun = false,
        tags = {""}
)
public class Automation105TestRunner extends AbstractTestNGCucumberTests {

}
