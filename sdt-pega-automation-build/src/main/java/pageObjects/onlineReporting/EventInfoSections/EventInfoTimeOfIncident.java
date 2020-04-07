package pageObjects.onlineReporting.EventInfoSections;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class EventInfoTimeOfIncident extends EventInfo {

    private @FindBy(xpath = "//div[@data-test-id='201905210946100436907']")
    WebElement sectionWhenDidItHappen = null;
    private @FindBy(xpath = "//input[@data-test-id='2019041808432401367411']/following-sibling::span")
    WebElement startDate = null;
    private @FindBy(xpath = "//td[contains(@class, 'today')]")
    WebElement valueDateToday = null;
    private @FindBy(xpath = "//a[contains(@class, 'apply-link')]")
    WebElement buttonApplyTime = null;
    private @FindBy(xpath = "//img[@data-test-id='2019041808432401378849-DatePicker']")
    WebElement datePickerEndDate = null;
    private @FindBy(xpath = "//img[@data-test-id='20190507154245086822959-DatePicker']")
    WebElement datePickerEndTime = null;
    private @FindBy(xpath = "//button[@data-test-id='20161017110917023176385']")
    WebElement buttonContinue = null;
    String xpathSpanStartDate = "//input[@data-test-id='2019041808432401367411']/following-sibling::span";
    String xpathInputStartDate = "//input[@data-test-id='2019041808432401367411']";
    String xpathSpanStartTime = "//input[@data-test-id='2019050714545402381390']/following-sibling::span";
    String xpathInputStartTime = "//input[@data-test-id='2019050714545402381390']";
    String xpathSpanEndDate = "//input[@data-test-id='2019041808432401378849']/following-sibling::span";
    String xpathInputEndDate = "//input[@data-test-id='2019041808432401378849']";
    String xpathSpanEndTime = "//input[@data-test-id='20190507154245086822959']/following-sibling::span";
    String xpathInputEndTime = "//input[@data-test-id='20190507154245086822959']";
    private @FindBy(xpath = "//input[@data-test-id='2019050714545402381390' and @type='time']")
    WebElement datePickerStartTimeMobile = null;

    private By pickersIOS = MobileBy.className("XCUIElementTypePickerWheel");
    private By nativeDoneButtonIOS = MobileBy.name("Done");
    private By startDateFieldIOS = MobileBy.xpath("//XCUIElementTypeStaticText[@name='Start date']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther[1]");
    private @FindBy(xpath = "//XCUIElementTypeStaticText[@value='Start date']/ancestor::node()[1]/following-sibling::XCUIElementTypeOther[3]")
    WebElement startTimeFieldIOS = null;
    //private By startTimeFieldIOS = MobileBy.xpath("//XCUIElementTypeStaticText[@value='Start date']/ancestor::node()[1]/following-sibling::XCUIElementTypeOther[3]");
    private @FindBy(xpath = "//input[@data-test-id='2019041808432401367411' and @type='date']")
    WebElement textBoxStartDate = null;
    private By startTimeFieldAndroid = MobileBy.xpath("//*[@resource-id='$PpyWorkPage$pDateEntry$pFromTimeSpan']/android.widget.Spinner");
    //private By setTimeAndroid = MobileBy.xpath("//*[@resource-id='android:id/button1']");
    private @FindBy(xpath = "//*[@resource-id='android:id/button1']")
    WebElement setTimeAndroid = null;

    // private @FindBy(xpath = "//*[@resource-id='$PpyWorkPage$pDateEntry$pFromDateSpan']")
    // WebElement startDateFieldAndroid = null;
    private By startDateFieldAndroid = MobileBy.xpath("//*[@resource-id='$PpyWorkPage$pDateEntry$pFromDateSpan']");

    private @FindBy(xpath = "//*[@resource-id='android:id/button1']")
    WebElement startDateSetFieldAndroid = null;
    private @FindBy(xpath = "//span[@data-test-id='20190823131544042126166']/..")
    WebElement labelFirstElementOfPage = null;
    private String textFirstElementOfPage = "When did it happen?";

    public boolean checkIfWhenDidItHappenSectionIsDisplayed() {
        return isElementDisplayed(sectionWhenDidItHappen);
    }

    public void keyInStartDateMobile() {
        sendKeysToWebElement(textBoxStartDate, "Jul 22, 2018");
    }

    public void keyInStartDate(String startDate) {
        updateDatePickerUsingJavaScript(startDate, xpathSpanStartDate, xpathInputStartDate);
    }

    public void keyInStartTime(String startTime) {
        updateDatePickerUsingJavaScript(startTime, xpathSpanStartTime, xpathInputStartTime);
    }

    public void keyInEndDate(String endDate) {
        updateDatePickerUsingJavaScript(endDate, xpathSpanEndDate, xpathInputEndDate);
    }

    public void keyInEndTime(String endTime) {
        updateDatePickerUsingJavaScript(endTime, xpathSpanEndTime, xpathInputEndTime);
    }

    public void keyInStartDateMobile(String startDate, String startDateFormatted) {
        updateFieldValueUsingJavaScriptMobile("//input[@data-test-id='2019041808432401367411' and @type='date']", startDate, "//input[@data-test-id='2019041808432401367411' and @type='hidden']", startDateFormatted);
    }

    public void keyInStartTimeMobile(String startTime, String startTimeFormatted) {
        updateFieldValueUsingJavaScriptMobile("//input[@data-test-id='2019050714545402381390' and @type='time']", startTime, "//input[@data-test-id='2019050714545402381390' and @type='hidden']", startTimeFormatted);
    }

    /*public void keyInEndDateMobile(String endDate) {
        updateFieldValueUsingJavaScriptMobile(endDate, xpathSpanEndDate);
    }

    public void keyInEndTimeMobile(String endTime) {
        updateFieldValueUsingJavaScriptMobile(endTime, xpathSpanEndTime);
    }*/


    public void selectEventDateTime() {
        keyInStartDate(_generateTestData.generateValidData("whenDidItHappen.startDate"));
        keyInStartTime(_generateTestData.generateValidData("whenDidItHappen.startTime"));
        keyInEndDate(_generateTestData.generateValidData("whenDidItHappen.endDate"));
        keyInEndTime(_generateTestData.generateValidData("whenDidItHappen.endTime"));
    }

    public void keyInEventDateTimeFromDataFile(){

    }

    public void selectEventOlderThan24Hours() {
        String startDate = addOrSubtractDaysFromToday("SUB", 7);
        keyInStartDate(startDate);
        keyInStartTime(_generateTestData.generateValidData("whenDidItHappen.startTime"));
        String endDate = addOrSubtractDaysFromToday("SUB", 5);
        keyInEndDate(endDate);
        keyInEndTime(_generateTestData.generateValidData("whenDidItHappen.endTime"));
    }

    public void enterStartDateMobile() {
        if (_platFormName.equalsIgnoreCase("ios")) {
            keyInStartDateMobile("2019-10-10", "10/10/2019");
            /*switchToNativeApp();
            wait.until(ExpectedConditions.elementToBeClickable(startDateFieldIOS)).click();
            List<WebElement> pickerEls = new WebDriverWait(_appiumDriver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(pickersIOS));
            pickerEls.get(0).sendKeys("July");
            pickerEls.get(1).sendKeys("10");
            pickerEls.get(2).sendKeys("2018");
            wait.until(ExpectedConditions.elementToBeClickable(nativeDoneButtonIOS)).click();*/
        } else if (_platFormName.equalsIgnoreCase("android")) {
            //TODO - Enter Startdate value
            //scrollTillElementFound(startDateFieldAndroid, labelFirstElementOfPage);
            switchToNativeApp();
            wait.until(ExpectedConditions.elementToBeClickable(startDateFieldAndroid)).click();
            wait.until(ExpectedConditions.elementToBeClickable(startDateSetFieldAndroid)).click();
        }
        switchToWebView();
    }


    public void enterStartTimeMobile() {
        waitForPageComponentLoadFluentWait();
        if (_platFormName.equalsIgnoreCase("ios")) {
            keyInStartTimeMobile("01:10", "1:10 AM");
            /*scrollTillElementFound(datePickerStartTimeMobile, labelFirstElementOfPage);
            switchToNativeApp();
            wait.until(ExpectedConditions.elementToBeClickable(startTimeFieldIOS)).click();
            List<WebElement> timePicker = new WebDriverWait(_appiumDriver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(pickersIOS));
            timePicker.get(0).sendKeys("10");
            timePicker.get(1).sendKeys("30");
            timePicker.get(2).sendKeys("AM");
            wait.until(ExpectedConditions.elementToBeClickable(nativeDoneButtonIOS)).click();*/
        } else if (_platFormName.equalsIgnoreCase("android")) {
//            scrollTillElementFound(datePickerStartTimeMobile, labelFirstElementOfPage);
            switchToNativeApp();
            wait.until(ExpectedConditions.elementToBeClickable(startTimeFieldAndroid)).click();
            wait.until(ExpectedConditions.elementToBeClickable(setTimeAndroid)).click();
            //TODO setting start time based on value
        }
        switchToWebView();
    }

    public void clickOnContinueButtonMobile() {
        waitAndclickElementUsingJS(buttonContinue);

    }
}
