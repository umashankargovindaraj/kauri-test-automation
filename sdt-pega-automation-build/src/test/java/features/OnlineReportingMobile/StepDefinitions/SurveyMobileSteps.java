package features.OnlineReportingMobile.StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import libs.DriverFactory;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SurveyMobileSteps extends DriverFactory {

    @And("I select {string} in the section to choose that I want to do survey")
    public void iSelectInTheSectionToChooseThatIWantToDoSurvey(String surveyChoice) {
        if (surveyChoice.equalsIgnoreCase("yes")) {
            _confirmation.surveyChoice(surveyChoice);
            Assert.assertTrue(_survey.checkOnlineReportingSurveyExists());
            Assert.assertEquals(_survey.getLabelSurveyHeaderText(), "Online Reporting Survey");
        } else {
            _confirmation.surveyChoice(surveyChoice);
        }
    }

    @Then("I should be able to view all survey questions and select opinion as appropriate")
    public void iShouldBeAbleToViewAllSurveyQuestionsAndSelectOpinionAsAppropriate() {
        List<String> firstQuestionChoicesActual = _survey.getChoicesChoices(1);
        String[] expectedFirst = _generateTestData.generateListData("Question1.choices");
        List<String> firstQuestionChoicesExpected = new ArrayList<>(Arrays.asList(expectedFirst));
        Assert.assertEquals(firstQuestionChoicesActual, firstQuestionChoicesExpected, "Mismatch in choices");

        List<String> secondQuestionChoicesActual = _survey.getChoicesChoices(2);
        String[] expectedSecond = _generateTestData.generateListData("Question2.choices");
        List<String> secondQuestionChoicesExpected = new ArrayList<>(Arrays.asList(expectedSecond));
        Assert.assertEquals(secondQuestionChoicesActual, secondQuestionChoicesExpected, "Mismatch in choices");

        List<String> thirdQuestionChoicesActual = _survey.getChoicesChoices(3);
        String[] expectedThird = _generateTestData.generateListData("Question3.choices");
        List<String> thirdQuestionChoicesExpected = new ArrayList<>(Arrays.asList(expectedThird));
        Assert.assertEquals(thirdQuestionChoicesActual, thirdQuestionChoicesExpected, "Mismatch in choices");

        _survey.keyInSurveyData();
        _survey.submitSurvey();

        Assert.assertTrue(_survey.checkSurveyCompletedSuccessfully());
        Assert.assertEquals(_survey.getSurveyCompletedText(), "Submission Complete");

        //_survey.clickOnCompleteSurveybutton();
    }
}
