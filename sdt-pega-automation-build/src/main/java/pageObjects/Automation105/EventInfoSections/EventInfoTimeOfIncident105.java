package pageObjects.Automation105.EventInfoSections;

import io.appium.java_client.MobileBy;
import io.cucumber.datatable.DataTable;
import libs.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class EventInfoTimeOfIncident105 extends BasePage {

    private String xpathSpanStartDate = "//input[@data-test-id='2019041808432401367411']/following-sibling::span";
    private String xpathInputStartDate = "//input[@data-test-id='2019041808432401367411']";
    private String xpathSpanStartTime = "//input[@data-test-id='2019050714545402381390']/following-sibling::span";
    private String xpathInputStartTime = "//input[@data-test-id='2019050714545402381390']";
    private String xpathSpanEndDate = "//input[@data-test-id='2019041808432401378849']/following-sibling::span";
    private String xpathInputEndDate = "//input[@data-test-id='2019041808432401378849']";
    private String xpathSpanEndTime = "//input[@data-test-id='20190507154245086822959']/following-sibling::span";
    private String xpathInputEndTime = "//input[@data-test-id='20190507154245086822959']";
    private By startDateFieldAndroid = MobileBy.xpath("//*[@resource-id='$PpyWorkPage$pDateEntry$pFromDateSpan']");
    private @FindBy(xpath = "//*[@resource-id='android:id/button1']")
    WebElement startDateSetFieldAndroid = null;
    private By startTimeFieldAndroid = MobileBy.xpath("//*[@resource-id='$PpyWorkPage$pDateEntry$pFromTimeSpan']/android.widget.Spinner");
    private @FindBy(xpath = "//*[@resource-id='android:id/button1']")
    WebElement setTimeAndroid = null;
    private @FindBy(xpath = "//button[@data-test-id='20161017110917023176385']")
    WebElement buttonContinue = null;


    /*public void selectEventDateTimeFromDataFile() {
        keyInStartDate(_retrieveTestData.extractDataOffDataFile("eventTime.startDate"));
        keyInStartTime(_retrieveTestData.extractDataOffDataFile("eventTime.startTime"));
        keyInEndDate(_retrieveTestData.extractDataOffDataFile("eventTime.endDate"));
        keyInEndTime(_retrieveTestData.extractDataOffDataFile("eventTime.endTime"));
    }*/

    public void selectEventDateTimeFromDataFile() {
        String eventDateTime = "eventTime";
        try {
            String startDateXpath = eventDateTime + ".startDate";
            String testData = _retrieveTestData.extractDataOffDataFile(startDateXpath, false);
            if (!(testData == null)) {
                keyInStartDate(testData);
            } else {
                System.out.println("Start Date field not mentioned in the data file and hence will not be keyed in ");
                Assert.fail("Start Date is a mandatory field. Please mention that in the data file");
            }
        } catch (Exception e) {
            System.out.println("Exception while entering start date. " + e);
        }

        try {
            String startTimeXpath = eventDateTime + ".startTime";
            String testData = _retrieveTestData.extractDataOffDataFile(startTimeXpath, false);
            if (!(testData == null)) {
                keyInStartTime(testData);
            } else {
                System.out.println("Start Time field not mentioned in the data file and hence will not be keyed in ");
                Assert.fail("Start time is a mandatory field. Please mention that in the data file");
            }
        } catch (Exception e) {
            System.out.println("Exception while entering start time. " + e);
        }

        try {
            String endDateXpath = eventDateTime + ".endDate";
            String testData = _retrieveTestData.extractDataOffDataFile(endDateXpath, false);
            if (!(testData == null)) {
                keyInEndDate(testData);
            } else {
                System.out.println("End Date field not mentioned in the data file and hence will not be keyed in ");
            }
        } catch (Exception e) {
            System.out.println("Exception while entering end date. + e");
        }

        try {
            String endTimeXpath = eventDateTime + ".endTime";
            String testData = _retrieveTestData.extractDataOffDataFile(endTimeXpath, false);
            if (!(testData == null)) {
                keyInEndTime(testData);
            } else {
                System.out.println("End time field not mentioned in the data file and hence will not be keyed in ");
            }
        } catch (Exception e) {
            System.out.println("Exception while entering end time. " + e);
        }
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

    public List<Map<String, String>> getCucumberDataAsList(DataTable dataTable) {
        return getCucumberDataTableAsList(dataTable);
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

    public void keyInStartDateMobile(String startDate, String startDateFormatted) {
        updateFieldValueUsingJavaScriptMobile("//input[@data-test-id='2019041808432401367411' and @type='date']", startDate, "//input[@data-test-id='2019041808432401367411' and @type='hidden']", startDateFormatted);
    }

    public void keyInStartTimeMobile(String startTime, String startTimeFormatted) {
        updateFieldValueUsingJavaScriptMobile("//input[@data-test-id='2019050714545402381390' and @type='time']", startTime, "//input[@data-test-id='2019050714545402381390' and @type='hidden']", startTimeFormatted);
    }


    public void selectEventDateTimeFromDataFileMobile() {
        String eventDateTime = "eventTime";
        try {
            String startDateXpath = eventDateTime + ".startDate";
            String testData = _retrieveTestData.extractDataOffDataFile(startDateXpath, false);
            if (!(testData == null)) {
                enterStartDateMobile();
            } else {
                System.out.println("Start Date field not mentioned in the data file and hence will not be keyed in ");
                Assert.fail("Start Date is a mandatory field. Please mention that in the data file");
            }
        } catch (Exception e) {
            System.out.println("Exception while entering start date. " + e);
        }

        try {
            String startTimeXpath = eventDateTime + ".startTime";
            String testData = _retrieveTestData.extractDataOffDataFile(startTimeXpath, false);
            if (!(testData == null)) {
                enterStartTimeMobile();
            } else {
                System.out.println("Start Time field not mentioned in the data file and hence will not be keyed in ");
                Assert.fail("Start time is a mandatory field. Please mention that in the data file");
            }
        } catch (Exception e) {
            System.out.println("Exception while entering start time. " + e);
        }

        /*try {
            String endDateXpath = eventDateTime + ".endDate";
            String testData = _retrieveTestData.extractDataOffDataFile(endDateXpath, false);
            if (!(testData == null)) {
                keyInEndDate(testData);
            } else {
                System.out.println("End Date field not mentioned in the data file and hence will not be keyed in ");
            }
        } catch (Exception e) {
            System.out.println("Exception while entering end date. + e");
        }

        try {
            String endTimeXpath = eventDateTime + ".endTime";
            String testData = _retrieveTestData.extractDataOffDataFile(endTimeXpath, false);
            if (!(testData == null)) {
                keyInEndTime(testData);
            } else {
                System.out.println("End time field not mentioned in the data file and hence will not be keyed in ");
            }
        } catch (Exception e) {
            System.out.println("Exception while entering end time. " + e);
        }*/
    }


    public void clickOnContinueButtonMobile() {
        waitAndclickElementUsingJS(buttonContinue);

    }
}
