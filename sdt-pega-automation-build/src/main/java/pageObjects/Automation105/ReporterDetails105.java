package pageObjects.Automation105;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.cucumber.datatable.DataTable;
import libs.BasePage;
import libs.ExecutionDeviceConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class ReporterDetails105 extends BasePage {

    private @FindBy(xpath = "//input[@data-test-id='20190410181138020711901']")
    WebElement textBoxReporterFirstName = null;
    private @FindBy(xpath = "//input[@data-test-id='20190410181138020812743']")
    WebElement textBoxReporterMiddleName = null;
    private @FindBy(xpath = "//input[@data-test-id='20190410181138020813443']")
    WebElement textBoxReporterLastName = null;
    private @FindBy(xpath = "//input[@data-test-id='201905151317120458182775']")
    WebElement textBoxAlternateFirstName = null;
    private @FindBy(xpath = "//input[@data-test-id='201905151317120459183533']")
    WebElement textBoxAlternateMiddleName = null;
    private @FindBy(xpath = "//input[@data-test-id='201905151317120459184761']")
    WebElement textBoxAlternateLastName = null;
    private @FindBy(xpath = "//input[@data-test-id='201905170904240759254550']")
    WebElement checkBoxPreviouslyKnownbyAnotherName = null;
    private @FindBy(xpath = "(//*[@data-test-id='2019041018133200689996'])[1]")
    WebElement mobileViewReporterDOB = null;
    private @FindBy(xpath = "//input[@data-test-id='2019041018133200689996']")
    WebElement textBoxReporterDateOfBirth = null;
    private @FindBy(xpath = "//div[@data-test-id='201909101118510246838']//select[@data-test-id='20190411110011006313687']")
    WebElement dropDownGender = null;
    private @FindBy(xpath = "//input[@data-test-id='201905021537390692213367']")
    WebElement textBoxDriverLicenseNumber = null;
    private @FindBy(xpath = "//select[@data-test-id='201905021504530372228423']")
    WebElement dropDownPreferredContactMethod = null;
    private @FindBy(xpath = "//div[@data-test-id='201905021608390761268']//input[@type='email']")
    List<WebElement> textBoxEmailAddress = null;
    private @FindBy(xpath = "//div[@data-test-id='201905140840180682537']//select[@data-test-id='20190411125517041712957']")
    WebElement dropDownPhoneType = null;
    private @FindBy(xpath = "//div[@data-test-id='201905241135120567201']//select[@data-test-id='20191127095351032818541']")
    List<WebElement> dropDownReporterPhoneTypeCountry = null;
    private @FindBy(xpath = "//div[@data-test-id='201905241135120567201']//input[@data-test-id='20191127101604009732639']")
    List<WebElement> textBoxReporterPhoneNumberArea = null;
    private @FindBy(xpath = "//div[@data-test-id='201905241135120567201']//input[@data-test-id='20191127101954039317217']")
    List<WebElement> textBoxReporterPhoneNumber = null;
    private @FindBy(xpath = "//select[@data-test-id='201909182311530418691736']")
    WebElement dropDownReporterAddressTypeMobile = null;
    private @FindBy(xpath = "//select[@data-test-id='201909181609060664180297']")
    WebElement dropDownReporterAddressType = null;
    private @FindBy(xpath = "//input[@data-test-id='20190415114949074560411']")
    WebElement checkBoxCantFindAddress = null;
    private @FindBy(xpath = "//div[@class='autocomplete-results']//li[contains(@class,'ac-item')]")
    List<WebElement> addressAutoCompleteListMobile = null;
    private @FindBy(xpath = "//table[contains(@pl_prop_class, 'Police-Data-NIA-MasterLocation')]//tr[contains(@oaargs,'Police-Data-NIA-MasterLocation')]")
    List<WebElement> addressAutoCompleteList = null;
    private @FindBy(xpath = "//input[@data-test-id='2019031415200802003627']")
    WebElement textBoxReporterAddress = null;
    private @FindBy(xpath = "//button[@data-test-id='20190506100908067919212']")
    WebElement buttonContinueToSummaryPage = null;

    private By reporterDOBYearAndroid = MobileBy.xpath("//*[@resource-id='android:id/date_picker_header_year']");
    private By reporterDOBNewYearAndroid = MobileBy.xpath("//*[@resource-id='android:id/text1'][1]");
    private By reporterDOBCalendarSetButtonAndroid = MobileBy.xpath("//*[@resource-id='android:id/button1']");
    private @FindBy(xpath = "//div[@data-test-id='201905241135120567201']//div[@data-test-id='20190418114941075437388']//label[text()='Yes']")
    WebElement toggleReporterVictimSupportYes = null;
    private @FindBy(xpath = "//div[@data-test-id='201905241135120567201']//div[@data-test-id='20190418114941075437388']//label[text()='No']")
    WebElement toggleReporterVictimSupportNo = null;
    private @FindBy(xpath = "//div[@data-test-id='20190827120614093039571']//label[contains(text(),'International')]")
    List<WebElement> tabReporterInternational = null;
    private @FindBy(xpath = "//div[@data-test-id='201904241255380732246']//input[@data-test-id='201904111522500376683985']")
    List<WebElement> lookupReporterUnitType = null;
    private @FindBy(xpath = "//div[@data-test-id='201904241255380732246']//input[@data-test-id='201904111522500377684750']")
    List<WebElement> textBoxReporterUnitNumber = null;
    private @FindBy(xpath = "//div[@data-test-id='201904241255380732246']//input[@data-test-id='201904111522500378687291']")
    List<WebElement> textBoxReporterStreetNumber = null;
    private @FindBy(xpath = "//div[@data-test-id='201904241255380732246']//input[@data-test-id='201904111522500379688406']")
    List<WebElement> textBoxReporterStreetName = null;
    private @FindBy(xpath = "//div[@data-test-id='201904241255380732246']//input[@data-test-id='201904111522500380689446' and contains(@name,'StreetType')]")
    List<WebElement> lookupReporterStreetType = null;
    private @FindBy(xpath = "//div[@data-test-id='201904241255380732246']//input[@data-test-id='201904111522500380689446' and contains(@name,'StreetDirection')]")
    List<WebElement> lookupReporterStreetDirection = null;
    private @FindBy(xpath = "//div[@data-test-id='201904241255380732246']//input[@data-test-id='201904111527000430464605']")
    List<WebElement> lookupReporterTownSuburb = null;
    private @FindBy(xpath = "//div[@data-test-id='201904241255380732246']//input[@data-test-id='20190726160046054615911']")
    List<WebElement> textBoxReporterTownSuburb = null;
    private @FindBy(xpath = "//div[@data-test-id='201904241255380732246']//select[@data-test-id='201904111527000431465607']")
    List<WebElement> dropDownReporterCountry = null;
    private @FindBy(xpath = "//table[@pl_prop_class='Police-Data-NIA-Reference' and contains(@grid_ref_page, 'FreeFormAddress')]//tr[contains(@oaargs, 'TownSuburb')]")
    List<WebElement> townSuburbReporterAutoCompleteList = null;
    private @FindBy(xpath = "//table[@pl_prop_class='Police-Data-NIA-Reference' and contains(@grid_ref_page, 'FreeFormAddress')]//tr[contains(@oaargs, 'StreetDirection')]")
    List<WebElement> streetDirectionAutoCompleteList = null;
    private @FindBy(xpath = "//table[@pl_prop_class='Police-Data-NIA-Reference' and contains(@grid_ref_page, 'FreeFormAddress')]//tr[contains(@oaargs, 'UnitType')]")
    List<WebElement> unitTypeAutoCompleteList = null;
    private @FindBy(xpath = "//table[@pl_prop_class='Police-Data-NIA-Reference' and contains(@grid_ref_page, 'FreeFormAddress')]//tr[contains(@oaargs, 'StreetType')]")
    List<WebElement> streetTypeAutoCompleteList = null;


    private boolean reporterAddressToKeyInManually = false;
    private boolean isReporterInternationalAddress = false;

    public void keyInDataOnFieldsRelatedToReporterContactDetails() {
        keyInReporterFirstName();
        keyInReporterMiddleName();
        keyInReporterLastName();
        selectReporterGender();
        keyInReporterDriverLicenceNumber();
        keyInReporterPreviousName();
        selectReporterPreferredContactDetails();
        keyInDataReporterEmailAddress(0);
        keyInDataReporterPhoneNumberandPhoneType(0);
        selectReporterDropDownAddressType();
        if (reporterAddressToKeyInManually) {
            clickReporterCantFindAddressCheckBox();
            if (isReporterInternationalAddress) {
                _addressManualEntry.selectReporterManualAddressTab(0);
                _addressManualEntry.keyInReporterAddressManually(0, true);
            } else {
                _addressManualEntry.keyInReporterAddressManually(0, false);
            }

        } else {
            keyInReporterAddress();
        }
        if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
            keyInReporterDOBMobile();
        } else {
            keyInReporterDOB();
        }
    }

    public  void keyInDataOnFieldsRelatedToReporterContactDetailsWithManualAddress(String isInternationalAddress){
        keyInReporterFirstName();
        keyInReporterMiddleName();
        keyInReporterLastName();
        selectReporterGender();
        keyInReporterDriverLicenceNumber();
        keyInReporterPreviousName();
        selectReporterPreferredContactDetails();
        keyInDataReporterEmailAddress(0);
        keyInDataReporterPhoneNumberandPhoneType(0);
        selectReporterDropDownAddressType();
        clickReporterCantFindAddressCheckBox();
        if(isInternationalAddress.equalsIgnoreCase("yes")){
            selectReporterManualAddressInternationalTab(0);
        }
        keyInManualAddressDetailsReporter(0,isInternationalAddress);
        if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
            keyInReporterDOBMobile();
        } else {
            keyInReporterDOB();
        }

    }
    private void keyInReporterFirstName() {
        sendKeysToWebElement(textBoxReporterFirstName, _retrieveTestData.extractDataOffDataFile("reporterDetails.firstName"));
    }

    private void keyInReporterMiddleName() {
        sendKeysToWebElement(textBoxReporterMiddleName, _retrieveTestData.extractDataOffDataFile("reporterDetails.middleName"));
    }

    private void keyInReporterLastName() {
        sendKeysToWebElement(textBoxReporterLastName, _retrieveTestData.extractDataOffDataFile("reporterDetails.lastName"));
        waitAndClickElement(textBoxReporterMiddleName);
        waitForOwnerLastNameToTurnCaps(textBoxReporterLastName);
    }

    private void keyInReporterPreviousFirstName() {
        sendKeysToWebElement(textBoxAlternateFirstName, _retrieveTestData.extractDataOffDataFile("reporterDetails.previousFirstName"));
    }

    private void keyInReporterPreviousMiddleName() {
        sendKeysToWebElement(textBoxAlternateMiddleName, _retrieveTestData.extractDataOffDataFile("reporterDetails.previousMiddleName"));
    }

    private void keyInReporterPreviousLastName() {
        sendKeysToWebElement(textBoxAlternateLastName, _retrieveTestData.extractDataOffDataFile("reporterDetails.previousLastName"));
        waitAndClickElement(textBoxAlternateMiddleName);
        waitForOwnerLastNameToTurnCaps(textBoxAlternateLastName);
    }

    private void keyInReporterPreviousName() {
        waitAndclickElementUsingJS(checkBoxPreviouslyKnownbyAnotherName);
        keyInReporterPreviousFirstName();
        keyInReporterPreviousMiddleName();
        keyInReporterPreviousLastName();
    }

    private void keyInReporterDOBMobile() {

        if (_platFormName.equalsIgnoreCase("ios")) {
            updateFieldValueUsingJavaScriptMobile("//input[@data-test-id='2019041018133200689996' and @type='date']", "2017-10-31", "//input[@data-test-id='2019041018133200689996' and @type='hidden']", "31/10/2017");
        } else if (_platFormName.equalsIgnoreCase("android")) {
            switchToNativeApp();
            switchToWebView();
            //waitAndclickElementUsingJS(mobileViewReporterDOB);
            actionMoveAndClick(mobileViewReporterDOB);
            switchToNativeApp();
            (new TouchAction(_appiumDriver))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                    .perform();
            wait.until(ExpectedConditions.elementToBeClickable(reporterDOBYearAndroid)).click();
            wait.until(ExpectedConditions.elementToBeClickable(reporterDOBNewYearAndroid)).click();
            wait.until(ExpectedConditions.elementToBeClickable(reporterDOBCalendarSetButtonAndroid)).click();
        }
        switchToWebView();
    }

    private void keyInReporterDOB() {
        String dateOfBirth = _retrieveTestData.extractDataOffDataFile("reporterDetails.dob");
        sendKeysToWebElement(textBoxReporterDateOfBirth, dateOfBirth);
    }

    private void selectReporterGender() {
        selectFromDropDownbyValue(dropDownGender, _retrieveTestData.extractDataOffDataFile("reporterDetails.gender"));
    }

    private void keyInReporterDriverLicenceNumber() {
        sendKeysToWebElement(textBoxDriverLicenseNumber, _retrieveTestData.extractDataOffDataFile("reporterDetails.driverLicence"));
    }

    private void selectReporterPreferredContactDetails() {
        selectFromDropDownbyValue(dropDownPreferredContactMethod, _retrieveTestData.extractDataOffDataFile("reporterDetails.preferredContact"));
    }

    private void selectReporterPreviousNameIndicator() {
        waitAndclickElementUsingJS(checkBoxPreviouslyKnownbyAnotherName);
    }

    private void keyInDataReporterEmailAddress(int index) {
        sendKeysToWebElement(textBoxEmailAddress.get(index), _retrieveTestData.extractDataOffDataFile("reporterDetails.emailAddress"));
    }

    private void selectReporterPhoneType() {
        selectFromDropDownbyValue(dropDownPhoneType, _retrieveTestData.extractDataOffDataFile("reporterDetails.phoneType"));
    }

    private void keyInDataReporterPhoneNumberandPhoneType(int index) {
        selectReporterPhoneType();
        selectReporterPhoneCountry(index);
        keyInReporterPhoneTypeArea(index);
        keyInReporterPhoneNumber(index);
    }

    private void selectReporterPhoneCountry(int index) {
        //verifyReporterPhoneCountryField(index);
        selectFromDropDownbyValue(dropDownReporterPhoneTypeCountry.get(index), _retrieveTestData.extractDataOffDataFile("reporterDetails.countryCode"));
    }

    /*private void verifyReporterPhoneCountryField(int index) {
        Select select = new Select(dropDownReporterPhoneTypeCountry.get(index));
        Assert.assertTrue(select.getOptions().size() > 1);
        String[] country = _generateTestData.generateListData("reporterDetails.countryCode");
        List<WebElement> dropDownValues = getAllListValuesInDropDown(dropDownReporterPhoneTypeCountry.get(0));
        validateDropDownListValues(dropDownValues, country);
    }*/

    public void clickOnContinueToNavigateToSummaryPage() {
        waitAndclickElementUsingJS(buttonContinueToSummaryPage);
    }

    private void keyInReporterPhoneTypeArea(int index) {
        sendKeysToWebElement(textBoxReporterPhoneNumberArea.get(index), _retrieveTestData.extractDataOffDataFile("reporterDetails.area"));
    }

    private void keyInReporterPhoneNumber(int index) {
        sendKeysToWebElement(textBoxReporterPhoneNumber.get(index), _retrieveTestData.extractDataOffDataFile("reporterDetails.phoneNumber"));
    }

    private void selectReporterDropDownAddressType() {
        if (_platFormName.equalsIgnoreCase("ios") || _platFormName.equalsIgnoreCase("android")) {
            selectFromDropDownbyValue(dropDownReporterAddressTypeMobile, _retrieveTestData.extractDataOffDataFile("reporterDetails.addressType"));
        } else {
            selectFromDropDownbyValue(dropDownReporterAddressType, _retrieveTestData.extractDataOffDataFile("reporterDetails.addressType"));
        }
    }

    private void clickReporterCantFindAddressCheckBox() {
        waitAndclickElementUsingJS(checkBoxCantFindAddress);
    }

    private void keyInReporterAddress() {
        executionDeviceConfiguration = new ExecutionDeviceConfiguration(getDeviceKey());
        String deviceType = executionDeviceConfiguration.getDeviceParameters("DEVICE");
        if (deviceType.toLowerCase().contains("tab") || deviceType.equalsIgnoreCase("Google Nexus 9") || deviceType.toLowerCase().contains("ipad")) {
            addressAutoCompleteListMobile = addressAutoCompleteList;
        }
        if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
            selectLookupValue(textBoxReporterAddress, addressAutoCompleteListMobile, _retrieveTestData.extractDataOffDataFile("reporterDetails.address"), true);
        } else {
            selectLookupValue(textBoxReporterAddress, addressAutoCompleteList, _retrieveTestData.extractDataOffDataFile("reporterDetails.address"), true);
        }
    }

    public void selectAnswerForReporterVictimSupport(int index){
        if (getVictimSupportIndicator().equalsIgnoreCase("yes")) {
            waitAndclickElementUsingJS(toggleReporterVictimSupportYes);
        } else {
            waitAndclickElementUsingJS(toggleReporterVictimSupportNo);
        }
    }

    private String getVictimSupportIndicator() {
        return _retrieveTestData.extractDataOffDataFile("reporterDetails.victimSupport");
    }


    public List<Map<String, String>> getCucumberDataAsList(DataTable dataTable) {
        return getCucumberDataTableAsList(dataTable);
    }

    public void selectReporterManualAddressInternationalTab(int index) {
        waitAndclickElementUsingJS(tabReporterInternational.get(index));
    }

    private void keyInManualAddressDetailsReporter(int elementInApplicationIndex, String internationalAddressIndicator) {
        try {
            String addressUnitTypeXpath = "reporterDetails.manualAddress.unitType";
            String testData = _retrieveTestData.extractDataOffDataFile(addressUnitTypeXpath, false);
            if (!(testData == null)) {
                selectLookupValue(lookupReporterUnitType.get(elementInApplicationIndex), unitTypeAutoCompleteList, testData, false);
            } else {
                System.out.println("Unit Type field not mentioned in the data file and hence will not be keyed in ");
            }

        } catch (Exception e) {
            System.out.println("Unit Type field not mentioned in the data file and hence will not be keyed in ");
        }

        try {
            String addressUnitNumberXpath = "reporterDetails.manualAddress.unitNumber";
            String testData = _retrieveTestData.extractDataOffDataFile(addressUnitNumberXpath, false);
            if (!(testData == null)) {
                sendKeysToWebElement(textBoxReporterUnitNumber.get(elementInApplicationIndex), testData);
            } else {
                System.out.println("Unit Number field not mentioned in the data file and hence will not be keyed in ");
            }

        } catch (Exception e) {
            System.out.println("Unit Number field not mentioned in the data file and hence will not be keyed in ");
        }

        try {
            String addressStreetNumberXpath = "reporterDetails.manualAddress.streetNumber";
            String testData = _retrieveTestData.extractDataOffDataFile(addressStreetNumberXpath, false);
            if (!(testData == null)) {
                sendKeysToWebElement(textBoxReporterStreetNumber.get(elementInApplicationIndex), testData);
            } else {
                System.out.println("Street Number field not mentioned in the data file and hence will not be keyed in ");
            }
        } catch (Exception e) {
            System.out.println("Street Number field not mentioned in the data file and hence will not be keyed in ");
        }

        try {
            String addressStreetNameXpath = "reporterDetails.manualAddress.streetName";
            String testData = _retrieveTestData.extractDataOffDataFile(addressStreetNameXpath, false);
            if (!(testData == null)) {
                sendKeysToWebElement(textBoxReporterStreetName.get(elementInApplicationIndex), testData);
            } else {
                System.out.println("Street Name field not mentioned in the data file and hence will not be keyed in ");
            }
        } catch (Exception e) {
            System.out.println("Street Name field not mentioned in the data file and hence will not be keyed in ");
        }

        try {
            String addressStreetTypeXpath = "reporterDetails.manualAddress.streetType";
            String testData = _retrieveTestData.extractDataOffDataFile(addressStreetTypeXpath, false);
            if (!(testData == null)) {
                selectLookupValue(lookupReporterStreetType.get(elementInApplicationIndex),streetTypeAutoCompleteList,testData,false);
            } else {
                System.out.println("Street Type field not mentioned in the data file and hence will not be keyed in ");
            }
        } catch (Exception e) {
            System.out.println("Street Type field not mentioned in the data file and hence will not be keyed in ");
        }

        try {
            String addressStreetDirectionXpath = "reporterDetails.manualAddress.streetDirection";
            String testData = _retrieveTestData.extractDataOffDataFile(addressStreetDirectionXpath, false);
            if (!(testData == null)) {
                selectLookupValue(lookupReporterStreetDirection.get(elementInApplicationIndex), streetDirectionAutoCompleteList, testData, false);
            } else {
                System.out.println("Street Direction field not mentioned in the data file and hence will not be keyed in ");
            }
        } catch (Exception e) {
            System.out.println("Street Direction field not mentioned in the data file and hence will not be keyed in ");
        }

        try {
            String addressTownSuburbXpath = "reporterDetails.manualAddress.townSuburb";
            String testData = _retrieveTestData.extractDataOffDataFile(addressTownSuburbXpath, false);
            if (!(testData == null)) {
                if(internationalAddressIndicator.equalsIgnoreCase("yes")){
                    sendKeysToWebElement(textBoxReporterTownSuburb.get(elementInApplicationIndex),testData);
                    selectInternationalCountry(elementInApplicationIndex);
                }else{
                    selectLookupValue(lookupReporterTownSuburb.get(elementInApplicationIndex), townSuburbReporterAutoCompleteList, testData, false);
                }
            } else {
                System.out.println("Town Suburb field not mentioned in the data file ");
                Assert.fail("Town/Suburb xpath reference is not mentioned in cucumber feature file. That's a mandatory field");
            }
        } catch (Exception e) {
            System.out.println("Town Suburb field not mentioned in the data file ");
            Assert.fail("Town/Suburb xpath reference is not mentioned in cucumber feature file. That's a mandatory field");
        }

    }
    private void selectInternationalCountry(int index){
        try {
            String addressUnitTypeXpath = "reporterDetails.manualAddress.Country";
            String testData = _retrieveTestData.extractDataOffDataFile(addressUnitTypeXpath, false);
            if (!(testData == null)) {
                selectFromDropDownbyValue(dropDownReporterCountry.get(index), testData);
            } else {
                System.out.println("Country field not mentioned in the data file and hence will not be keyed in ");
            }
        } catch (Exception e) {
            System.out.println("Country field not mentioned in the data file and hence will not be keyed in ");
        }
    }

}
