package pageObjects.onlineReporting;

import libs.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class Survey extends BasePage {

    private @FindBy(xpath = "//div[@data-test-id='2016051608015508941146']")
    WebElement labelSurveyHeader = null;
    private @FindBy(xpath = "//span[@data-test-id='201603030052400263127829'][contains(text(),'How satisfied or dissatisfied')]/ancestor::div[contains(@class, 'content-item content-layout item-1')]/following-sibling::div//label")
    List<WebElement> firstQuestionChoices = null;
    private @FindBy(xpath = "//span[@data-test-id='201603030052400263127829'][contains(text(),'How likely or unlikely are you to use the NZ Police')]/ancestor::div[contains(@class, 'content-item content-layout item-1')]/following-sibling::div//label")
    List<WebElement> secondQuestionChoices = null;
    private @FindBy(xpath = "//span[@data-test-id='201603030052400263127829'][contains(text(),'How likely or unlikely are you to recommend')]/ancestor::div[contains(@class, 'content-item content-layout item-1')]/following-sibling::div//label")
    List<WebElement> thirdQuestionChoices = null;
    private @FindBy(xpath = "//span[@data-test-id='201603030052400263127829'][contains(text(),'How satisfied or dissatisfied')]/ancestor::div[contains(@class, 'content-item content-layout item-1')]/following-sibling::div//input")
    List<WebElement> radioFirstQuestionChoices = null;
    private @FindBy(xpath = "//span[@data-test-id='201603030052400263127829'][contains(text(),'How likely or unlikely are you to use the NZ Police')]/ancestor::div[contains(@class, 'content-item content-layout item-1')]/following-sibling::div//input")
    List<WebElement> radioSecondQuestionChoices = null;
    private @FindBy(xpath = "//span[@data-test-id='201603030052400263127829'][contains(text(),'How likely or unlikely are you to recommend')]/ancestor::div[contains(@class, 'content-item content-layout item-1')]/following-sibling::div//input")
    List<WebElement> radioThirdQuestionChoices = null;
    private @FindBy(xpath = "//textarea[@data-test-id='20160218032524027026864']")
    WebElement textBoxAdditionalComments = null;
    private @FindBy(xpath = "//button[@data-test-id='2014121801251706289770']")
    WebElement buttonSubmitSurvey = null;
    private @FindBy(xpath = "//div[@data-test-id='20190930162739089135_header']//h1")
    WebElement labelSurveyCompleteHeader = null;
    private @FindBy(xpath = "//button[@data-test-id='20190930211750029237504']")
    WebElement buttonCompleteSurvey = null;
    private @FindBy(xpath = "//div[@data-test-id='2015012615503109611417']")
    WebElement labelThanksMessage = null;


    public boolean checkOnlineReportingSurveyExists() {
        return isDisplayed(labelSurveyHeader);
    }

    public String getLabelSurveyHeaderText() {
        return waitandGetText(labelSurveyHeader);
    }

    public List<String> getChoicesChoices(int questionNumber) {
        List<String> choices = new ArrayList<>();
        switch (questionNumber) {
            case 1:
                for (WebElement firstQuestionChoices : firstQuestionChoices) {
                    choices.add(getAttributeValue(firstQuestionChoices, "title"));
                }
                break;
            case 2:
                for (WebElement firstQuestionChoices : secondQuestionChoices) {
                    choices.add(getAttributeValue(firstQuestionChoices, "title"));
                }
                break;
            case 3:
                for (WebElement firstQuestionChoices : thirdQuestionChoices) {
                    choices.add(getAttributeValue(firstQuestionChoices, "title"));
                }
                break;
        }
        return choices;
    }

    public void selectChoices(int questionNumber) {
        int questionIndex = generateRandomValueBetweenRange(4, 0);
        System.out.println("Question Index : " + questionIndex);
        switch (questionNumber) {
            case 1:
                waitAndclickElementUsingJS(radioFirstQuestionChoices.get(questionIndex));
                break;
            case 2:
                waitAndclickElementUsingJS(radioSecondQuestionChoices.get(questionIndex));
                break;
            case 3:
                waitAndclickElementUsingJS(radioThirdQuestionChoices.get(questionIndex));
                break;

        }

    }

    public void keyInAdditionalCommentsOnSurvey() {
        sendKeysToWebElement(textBoxAdditionalComments, _generateTestData.generateValidData("additionalComments.comments"));
    }


    public void keyInSurveyData() {
        _survey.selectChoices(1);
        _survey.selectChoices(2);
        _survey.selectChoices(3);
        _survey.keyInAdditionalCommentsOnSurvey();
    }

    public void submitSurvey() {
        waitAndclickElementUsingJS(buttonSubmitSurvey);
    }

    public boolean checkSurveyCompletedSuccessfully() {
        return isDisplayed(labelSurveyCompleteHeader);
    }

    public String getSurveyCompletedText() {
        return waitandGetText(labelSurveyCompleteHeader);
    }

    public void clickOnCompleteSurveybutton() {
        waitAndclickElementUsingJS(buttonCompleteSurvey);
    }

    public boolean checkThankYouMessageDisplayed() {
        return isDisplayed(labelThanksMessage);
    }
}
