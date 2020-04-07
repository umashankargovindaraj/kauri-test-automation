package features.Automation105.StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import libs.DriverFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SurveyPage105Steps extends DriverFactory {

    @And("I select {string} in the section to choose that I want to do survey")
    public void iSelectInTheSectionToChooseThatIWantToDoSurvey(String surveyChoice) {
        _confirmationPage105.surveyChoice(surveyChoice);

    }
}
