package pageObjects.Automation105;

import libs.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SurveyPage105 extends BasePage {

    private @FindBy(xpath = "//div[@data-test-id='2016051608015508941146']")
    WebElement labelSurveyHeader = null;
    private @FindBy(xpath = "//span[@data-test-id='201603030052400263127829'][contains(text(),'How satisfied or dissatisfied')]/ancestor::div[contains(@class, 'content-item content-layout item-1')]/following-sibling::div//label")
    List<WebElement> firstQuestionChoices = null;
    private @FindBy(xpath = "//span[@data-test-id='201603030052400263127829'][contains(text(),'How likely or unlikely are you to use the NZ Police')]/ancestor::div[contains(@class, 'content-item content-layout item-1')]/following-sibling::div//label")
    List<WebElement> secondQuestionChoices = null;
    private @FindBy(xpath = "//span[@data-test-id='201603030052400263127829'][contains(text(),'How likely or unlikely are you to recommend')]/ancestor::div[contains(@class, 'content-item content-layout item-1')]/following-sibling::div//label")
    List<WebElement> thirdQuestionChoices = null;

    public boolean checkOnlineReportingSurveyExists() {
        return isDisplayed(labelSurveyHeader);
    }

    public String getLabelSurveyHeaderText() {
        return waitandGetText(labelSurveyHeader);
    }
}
