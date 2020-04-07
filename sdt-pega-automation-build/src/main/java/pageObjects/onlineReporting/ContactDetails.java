package pageObjects.onlineReporting;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import libs.BasePage;
import libs.ExecutionDeviceConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;


public class ContactDetails extends BasePage {


    private @FindBy(xpath = "//div[@data-test-id='201905241135120567201']")
    WebElement sectionProvideYourDetails = null;

    private @FindBy(xpath = "//label[@data-test-id='20190410181138020711901-Label' and text()='First name']")
    WebElement labelFirstName = null;
    private @FindBy(xpath = "//input[@data-test-id='20190410181138020711901']")
    WebElement textBoxReporterFirstName = null;
    private @FindBy(xpath = "//label[@data-test-id='20190410181138020812743-Label' and text()='Middle name']")
    WebElement labelMiddleName = null;
    private @FindBy(xpath = "//input[@data-test-id='20190410181138020812743']")
    WebElement textBoxReporterMiddleName = null;
    private @FindBy(xpath = "//label[@data-test-id='20190410181138020813443-Label' and text()='Last name']")
    WebElement labelLastName = null;
    private @FindBy(xpath = "//input[@data-test-id='20190410181138020813443']")
    WebElement textBoxReporterLastName = null;
    private @FindBy(xpath = "//label[@data-test-id='2019041018133200689996-Label' and text()='Date of birth']")
    WebElement labelDateOfBirth = null;
    private @FindBy(xpath = "//input[@data-test-id='2019041018133200689996']")
    WebElement textBoxReporterDateOfBirth = null;
    private @FindBy(xpath = "//label[@data-test-id='20190411110011006313687-Label' and text()='Gender']")
    WebElement labelGender = null;
    private @FindBy(xpath = "//select[@data-test-id='20190411110011006313687']")
    WebElement dropDownGender = null;
    private @FindBy(xpath = "//label[@data-test-id='201905021537390692213367-Label' and text()='Driver Licence Number']")
    WebElement labelDriverLicenceNumber = null;
    private @FindBy(xpath = "//input[@data-test-id='201905021537390692213367']")
    WebElement textBoxDriverLicenseNumber = null;
    private @FindBy(xpath = "//label[@data-test-id='201905170904240759254550-Label' and text()='(For example: maiden name, non-English name)']")
    WebElement labelPreviouslyKnownbyAnotherName = null;
    private @FindBy(xpath = "//input[@data-test-id='201905170904240759254550']")
    WebElement checkBoxPreviouslyKnownbyAnotherName = null;
    private @FindBy(xpath = "//div[@data-test-id='201904241255380732246']//label")
    WebElement labelHomeAddress = null;
    private @FindBy(xpath = "//input[@data-test-id='2019031415200802003627']")
    WebElement textBoxReporterAddress = null;
    private @FindBy(xpath = "//label[@data-test-id='20190415114949074560411-Label']")
    WebElement labelCantFindAddress = null;
    private @FindBy(xpath = "//input[@data-test-id='20190415114949074560411']")
    WebElement checkBoxCantFindAddress = null;
    private @FindBy(xpath = "//label[@data-test-id='2019050216083907625630-Label' and text()='Email address']")
    List<WebElement> labelEmailAddress = null;
    //    private @FindBy(xpath = "//div[@data-test-id='201905021601220271608']//input[@data-test-id='2019050216083907625630']")
    //    private @FindBy(xpath = "//div[@data-test-id='201905021601220271608']//input[@data-test-id='2019050216083907625630']")
//    List<WebElement> textBoxEmailAddress = null;
    private @FindBy(xpath = "//div[@data-test-id='201905021608390761268']//input[@type='email']")
    List<WebElement> textBoxEmailAddress = null;
    private @FindBy(xpath = "//div[@data-test-id='201905140840180682537']//input[@data-test-id='2019050216083907625630']")
    WebElement textBoxReporterEmailAddress = null;
    private @FindBy(xpath = "//div[@data-test-id='201905021601220271608']//button[@data-test-id='20190827141318091140717']")
    List<WebElement> buttonDeleteEmailAddress = null;
    private @FindBy(xpath = "//div[@data-test-id='201905021601220271608']//button[@data-test-id='201905021654190101570342']")
    WebElement buttonAddEmailAddress = null;
    private @FindBy(xpath = "//label[@data-test-id='20190411125517041712957-Label' and text()='Phone type']")
    List<WebElement> labelPhoneType = null;
    private @FindBy(xpath = "//div[@data-test-id='201905140840180682537']//select[@data-test-id='20190411125517041712957']")
    WebElement dropDownPhoneType = null;
    private @FindBy(xpath = "//*[@data-test-id='20190411125517041712957']")
    WebElement dropDownPhoneTypeOwner = null;
    private @FindBy(xpath = "//div[@data-test-id='201905140840180682537']//label[@data-test-id='20190411125517041713446-Label' and text()='Phone number']")
    List<WebElement> labelPhoneNumber = null;
    private @FindBy(xpath = "//div[@data-test-id='201908201212270001604']//input[@data-test-id='20190411125517041713446']")
    List<WebElement> textBoxPhoneNumber = null;
    private @FindBy(xpath = "//div[@data-test-id='201905241135120567201']//select[@data-test-id='20191127095351032818541']")
    List<WebElement> dropDownReporterPhoneTypeCountry = null;
    private @FindBy(xpath = "//div[@data-test-id='201905241135120567201']//input[@data-test-id='20191127101604009732639']")
    List<WebElement> textBoxReporterPhoneNumberArea = null;
    private @FindBy(xpath = "//div[@data-test-id='201905241135120567201']//input[@data-test-id='20191127101954039317217']")
    List<WebElement> textBoxReporterPhoneNumber = null;


    //private @FindBy(xpath = "//div[@data-test-id='201905140840180682537']//input[@data-test-id='20190411125517041713446']")
    //WebElement textBoxReporterPhoneNumber = null;
    private @FindBy(xpath = "//div[@data-test-id='201905021601220271608']//button[@data-test-id='20190827124951054514620']")
    List<WebElement> buttonDeletePhoneNumber = null;
    private @FindBy(xpath = "//div[@data-test-id='201905021601220271608']//button[@data-test-id='201904111325420679260150']")
    WebElement buttonAddPhoneNumber = null;
    private @FindBy(xpath = "//label[@data-test-id='201905021504530372228423-Label']")
    WebElement labelPreferredContactMethod = null;
    private @FindBy(xpath = "//select[@data-test-id='201905021504530372228423']")
    WebElement dropDownPreferredContactMethod = null;

    private @FindBy(xpath = "//label[@data-test-id='20190418114941075437388-Label']")
    WebElement labelCanContactByVictimSupport = null;

    private @FindBy(xpath = "//div[@data-test-id='201905241135120567201']//div[@data-test-id='20190418114941075437388']//label[text()='Yes']")
    WebElement toggleReporterVictimSupportYes = null;
    private @FindBy(xpath = "//div[@data-test-id='201905241135120567201']//div[@data-test-id='20190418114941075437388']//label[text()='No']")
    WebElement toggleReporterVictimSupportNo = null;
    private @FindBy(xpath = "//div[@data-test-id='20190418114941075437388']//input[@value='Yes']")
    WebElement toggleSomethingElseOwnerVictimSupportYes = null;
    private @FindBy(xpath = "//div[@data-test-id='20190418114941075437388']//input[@value='No']")
    WebElement toggleSomethingElseOwnerVictimSupportNo = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//div[@data-test-id='20190418114941075437388']//input[@value='Yes']")
    List<WebElement> toggleSomeOneElseOwnerVictimSupportYes = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//div[@data-test-id='20190418114941075437388']//input[@value='No']")
    List<WebElement> toggleSomeOneElseOwnerVictimSupportNo = null;
    private @FindBy(xpath = "//div[@data-test-id='20190418114941075437388']//input[@value='Yes']")
    WebElement toggleVictimSupportYesMobile = null;
    private @FindBy(xpath = "//div[@data-test-id='20190418114941075437388']//input[@value='No']")
    WebElement toggleVictimSupportNoMobile = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//select[@data-test-id='20191127095351032818541']")
    List<WebElement> dropDownSomebodyElseOwnerPhoneTypeCountry = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//input[@data-test-id='20191127101604009732639']")
    List<WebElement> textBoxSomebodyElseOwnerPhoneNumberArea = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//input[@data-test-id='20191127101954039317217']")
    List<WebElement> textBoxSomebodyElseOwnerPhoneNumber = null;

    private @FindBy(xpath = "//button[@data-test-id='20190506100908067919212']")
    WebElement buttonContinueToSummaryPage = null;

    private @FindBy(xpath = "//div[@data-node-id='SomebodyElse']//div[@data-test-id='201904111102500743434']")
    List<WebElement> someoneElseDoesSection = null;
    private @FindBy(xpath = "//div[@data-node-id='SomebodyElse']//div[@data-test-id='201904111102500743434']//input[contains(@name, 'FirstName')]")
    List<WebElement> someOneElseDoesTextBoxOwnerFirstName = null;
    private @FindBy(xpath = "//div[@data-node-id='SomebodyElse']//div[@data-test-id='201904111102500743434']//input[contains(@name, 'MiddleName')]")
    List<WebElement> someOneElseDoesTextBoxOwnerMiddleName = null;
    private @FindBy(xpath = "//div[@data-node-id='SomebodyElse']//div[@data-test-id='201904111102500743434']//input[contains(@name, 'SurName')]")
    List<WebElement> someOneElseDoesTextBoxOwnerLastName = null;
    //    private @FindBy(xpath = "//div[@data-node-id='SomebodyElse']//div[@data-test-id='201904111102500743434']//input[@data-test-id='20190517122426054075903']")
//    List<WebElement> someOneElseDoesTextBoxOwnerAgeOrDOB = null;
    private @FindBy(xpath = "//div[@data-node-id='SomebodyElse']//div[@data-test-id='201904111102500743434']//input[@data-test-id='20191001163651019767140']")
    List<WebElement> someOneElseDoesTextBoxOwnerAgeOrDOB = null;
    private @FindBy(xpath = "//div[@data-node-id='SomebodyElse']//div[@data-test-id='201904111102500743434']//select[@data-test-id='20190411110011006313687']")
    List<WebElement> dropDownSomeOneElseDoesOwnerGender = null;
    private @FindBy(xpath = "//div[@data-node-id='SomebodyElse']//div[@data-test-id='201904111102500743434']//input[@data-test-id='2019050216083907625630']")
    List<WebElement> someOneElseDoesTextBoxOwnerEmailAddress = null;
    private @FindBy(xpath = "//div[@data-node-id='SomebodyElse']//div[@data-test-id='201904111102500743434']//select[@data-test-id='20190411125517041712957']")
    List<WebElement> dropDownSomeOneElseOwnerPhoneType = null;
    private @FindBy(xpath = "//div[@data-node-id='SomebodyElse']//div[@data-test-id='201904111102500743434']//input[@data-test-id='20190411125517041713446']")
    List<WebElement> someOneElseDoesTextBoxOwnerPhoneNumber = null;
    private @FindBy(xpath = "//div[@data-node-id='SomebodyElse']//div[@data-test-id='201904111102500743434']//input[@data-test-id='2019031415200802003627']")
    List<WebElement> someOneElseDoesTextBoxOwnerAddress = null;
    private @FindBy(xpath = "//div[@data-node-id='SomebodyElse']//div[@data-test-id='201904111102500743434']//input[@data-test-id='20190412132543093548630']")
    List<WebElement> cantFindAddressSomeOneElseOwner = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//div[contains(text(), 'Please provide')]")
    List<WebElement> labelOwnerDetailsSection = null;
    private @FindBy(xpath = "//div[@data-node-id='OrganizationDoes']//div[@data-test-id='201905091206250186440']")
    List<WebElement> organisationDoesSection = null;
    private @FindBy(xpath = "//div[@data-node-id='OrganizationDoes']//div[@data-test-id='201905091206250186440']//input[@data-test-id='201905091148140434211869']")
    List<WebElement> textBoxOrganisationName = null;
    private @FindBy(xpath = "//div[@data-node-id='OrganizationDoes']//div[@data-test-id='201905091206250186440']//input[@data-test-id='2019031415200802003627']")
    List<WebElement> textBoxOrganisationAddress = null;
    private @FindBy(xpath = "//div[@data-node-id='OrganizationDoes']//div[@data-test-id='201905091206250186440']//input[@data-test-id='20190412132543093548630']")
    List<WebElement> cantFindAddressOrganisationOwner = null;
    private @FindBy(xpath = "//div[@data-test-id='201905091206250186440']//select[@data-test-id='20190411125517041712957']")
    List<WebElement> dropDownOrganisationOwnerPhoneType = null;
    private @FindBy(xpath = "//div[@data-test-id='201905091206250186440']//select[@data-test-id='20191127095351032818541']")
    List<WebElement> dropDownOrganisationOwnerPhoneTypeCountry = null;
    private @FindBy(xpath = "//div[@data-test-id='201905091206250186440']//input[@data-test-id='20191127101604009732639']")
    List<WebElement> textBoxOrganisationOwnerPhoneNumberArea = null;
    private @FindBy(xpath = "//div[@data-test-id='201905091206250186440']//input[@data-test-id='20191127101954039317217']")
    List<WebElement> textBoxOrganisationOwnerPhoneNumber = null;


    private @FindBy(xpath = "//input[@data-test-id='201905151317120458182775']")
    WebElement textBoxAlternateFirstName = null;
    private @FindBy(xpath = "//input[@data-test-id='201905151317120459183533']")
    WebElement textBoxAlternateMiddleName = null;
    private @FindBy(xpath = "//input[@data-test-id='201905151317120459184761']")
    WebElement textBoxAlternateLastName = null;
    private @FindBy(xpath = "(//*[@data-test-id='2019041018133200689996'])[1]")
    WebElement mobileViewReporterDOB = null;
    private @FindBy(xpath = "//div[@data-test-id='201806191352060317785']//li")
    WebElement labelErrorFutureAndCurrentDateValidation = null;


    private @FindBy(xpath = "//button[@data-test-id='20161017110917023176385']")
    WebElement buttonContinueFromReporterPage = null;

    private @FindBy(xpath = "//button[@data-test-id='20161017110917023278926']")
    WebElement buttonBackMobile = null;

    private static By pickers = MobileBy.className("XCUIElementTypePickerWheel");

    private boolean reporterAddressToKeyInManually = false;
    private boolean isReporterInternationalAddress = false;
    private boolean someoneElseDoesAddressToKeyInManually = false;
    private boolean organisationDoesAddressToKeyInManually = false;

    private String xpathSpanDOB = "//input[@data-test-id='2019041018133200689996']/following-sibling::span";
    private String xpathInputDOB = "//input[@data-test-id='2019041018133200689996']";

    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//div[@data-test-id='20190528113323020052300']")
    List<WebElement> contactDetailsSomeoneElseDoesOwnerNameHeader = null;
    private @FindBy(xpath = "//div[@data-node-id='OrganizationDoes']//div[@data-test-id='201905091206250186440']//div[@data-test-id='201904111102500743434']")
    List<WebElement> contactDetailsOrganisationDoesOwnerNameHeader = null;

    private @FindBy(xpath = "//table[contains(@pl_prop_class, 'Police-Data-NIA-MasterLocation')]//tr[contains(@oaargs,'Police-Data-NIA-MasterLocation')]")
    List<WebElement> addressAutoCompleteList = null;
    private @FindBy(xpath = "//div[@class='autocomplete-results']//li[contains(@class,'ac-item')]")
    List<WebElement> addressAutoCompleteListMobile = null;


    private @FindBy(xpath = "//select[@data-test-id='201909181609060664180297']")
    WebElement dropDownReporterAddressType = null;
    private @FindBy(xpath = "//select[@data-test-id='201909182311530418691736']")
    WebElement dropDownReporterAddressTypeMobile = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434_header']//label")
    WebElement someoneOwnerNameHeaderMobile = null;
    private @FindBy(xpath = "//div[@data-test-id='201905091206250186440_header']//label")
    WebElement organisationOwnerNameHeaderMobile = null;
    private @FindBy(xpath = "//input[@data-test-id='20191001163651019767140']")
    WebElement textBoxSomeOneElseOwnerAgeOrDOBMobile = null;
    private @FindBy(xpath = "//select[@data-test-id='2019052812011802847278']")
    WebElement dropDownRelationToTheOwnerMobile = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//select[@data-test-id='2019052812011802847278']")
    List<WebElement> dropDownRelationToTheOwner = null;
    private @FindBy(xpath = "//input[@data-test-id='2019031415200802003627']")
    WebElement textBoxOwnerAddressMobile = null;
    private @FindBy(xpath = "//select[@data-test-id='20190411125517041712957']")
    WebElement dropDownOwnerPhoneType = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//select[@data-test-id='20190919120043051589619']")
    List<WebElement> dropDownAddressTypeSomeOneElseOwner = null;
    private @FindBy(xpath = "//input[@data-test-id='20190411125517041713446']")
    WebElement textBoxPhoneNumberOwnerMobile = null;
    private By pickersIOS = MobileBy.className("XCUIElementTypePickerWheel");
    private By nativeDoneButtonIOS = MobileBy.name("Done");

    private By reporterDOBIOS = MobileBy.xpath("//XCUIElementTypeOther[@name=\"Process Work Area, main\"]/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[8]/XCUIElementTypeOther/XCUIElementTypeOther");
    private By reporterDOBAndroid = MobileBy.xpath("//*[@resource-id='$PpyWorkPage$pPerson$pDOBSpan']/android.widget.Spinner");
    private By reporterDOBYearAndroid = MobileBy.xpath("//*[@resource-id='android:id/date_picker_header_year']");
    private @FindBy(xpath = "//*[@resource-id='android:id/date_picker_header_year']")
    WebElement reporterDOBYearAndroid_temp = null;
    private By reporterDOBYearAndroidLowerOSVersion = MobileBy.xpath("//*[@resource-id='android:id/date_picker_year']");
    private By reporterDOBNewYearAndroidLowerOSVersion = MobileBy.xpath("//*[@resource-id='android:id/month_text_view'][1]");
    private @FindBy(xpath = "//*[@resource-id='android:id/date_picker_year']")
    WebElement reporterDOBYearAndroidLowerOSVersion_temp = null;
    private By reporterDOBNewYearAndroid = MobileBy.xpath("//*[@resource-id='android:id/text1'][1]");
    private By reporterDOBCurrentYearAndroid = MobileBy.xpath("//*[@resource-id='android:id/text1'][3]");
    private By reporterDOBFutureYearAndroid = MobileBy.xpath("//*[@resource-id='android:id/text1'][4]");
    //private By reporterDOBNewYearAndroidLowerOSVersion = MobileBy.xpath("//*[@resource-id='android:id/month_text_view'][1]");
    private By reporterDOBCalendarSetButtonAndroid = MobileBy.xpath("//*[@resource-id='android:id/button1']");

    private @FindBy(xpath = "//*[@data-test-id='20190411125517041712957']/parent::div/div/span")
    WebElement phoneTypeErrorMessage = null;

    private @FindBy(xpath = "//*[@data-test-id='20190411125517041713446']/parent::span/div/span")
    WebElement phoneNumberErrorMessage = null;
    private @FindBy(xpath = "//*[@id='$PpyWorkPage$pSomebodyElse$l1$pPhones$l1$pPhoneNumberTextError']")
    WebElement phoneNumberErrorMessageOwner = null;
    private @FindBy(xpath = "//*[@id='$PpyWorkPage$pOrganizationDoes$l1$pPhones$l1$pPhoneNumberTextError']")
    WebElement phoneNumberErrorMessageOrganisation = null;
    private @FindBy(xpath = "//input[@data-test-id='201905311011380737558612']")
    WebElement checkBoxUseTheAddressIEnteredEarlier = null;
    private @FindBy(xpath = "//*[@data-test-id='201909231549560130384106']")
    WebElement textAddressIEnteredEarlierMobile = null;
    private @FindBy(xpath = "//*[@data-test-id='201909181609060664180297']")
    WebElement textAddressTypeHome = null;
    private @FindBy(xpath = "//*[@data-test-id='201806191352060317785']/div/div/div/ul/li/div[2]/div[2]")
    WebElement textDOBError = null;

    private @FindBy(xpath = "//span[text()='Contact details']")
    WebElement labelFirstElementOfPage = null;
    private @FindBy(xpath = "//input[@data-test-id='2019041018133200689996' and @type='date']")
    WebElement datePickerDOBMobile = null;

    public WebElement getPhoneTypeErrorMessage() {
        return phoneTypeErrorMessage;
    }

    public WebElement getPhoneNumberErrorMessage() {
        return phoneNumberErrorMessage;
    }

    public WebElement getPhoneNumberErrorMessageOwner() {
        return phoneNumberErrorMessageOwner;
    }

    public WebElement getPhoneNumberErrorMessageOrganisation() {
        return phoneNumberErrorMessageOrganisation;
    }

    public void keyInOwnerAddressMobile() {
        executionDeviceConfiguration = new ExecutionDeviceConfiguration(getDeviceKey());
        String deviceType = executionDeviceConfiguration.getDeviceParameters("DEVICE");
        if (deviceType.toLowerCase().contains("tab") || deviceType.equalsIgnoreCase("Google Nexus 9") || deviceType.toLowerCase().contains("ipad")) {
            addressAutoCompleteListMobile = addressAutoCompleteList;
        }
        if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
            selectLookupValue(textBoxOwnerAddressMobile, addressAutoCompleteListMobile, "191 THORNDON QUAY, PIPITEA, WELLINGTON CITY 6011", true);
        } else {
            selectLookupValue(textBoxOwnerAddressMobile, addressAutoCompleteList, "191 THORNDON QUAY, PIPITEA, WELLINGTON CITY 6011", true);
        }
    }

    public String getSomeOneElseOwnerDetailsHeaderMobile() {
        return waitandGetText(someoneOwnerNameHeaderMobile);
    }

    public String getOrganisationOwnerDetailsHeaderMobile() {
        return waitandGetText(organisationOwnerNameHeaderMobile);
    }

    public void keyInSomeOneOwnerAgeOrDOBMobile() {
        sendKeysToWebElement(textBoxSomeOneElseOwnerAgeOrDOBMobile, "22");
    }

    public void selectDropDownRelationShipToOwnerMobile() {
        selectFromDropDownbyValue(dropDownRelationToTheOwnerMobile, _generateTestData.generateValidData("ownerInformation.relationshipToReporter"));
    }

    public void selectOwnerPhoneTypeMobile() {
        selectFromDropDownbyValue(dropDownOwnerPhoneType, "Home");
    }

    public void keyInOwnerPhoneNumberMobile() {
        sendKeysToWebElement(textBoxPhoneNumberOwnerMobile, "22123123123");
    }


    public String getValueFromOwnerFirstNameField(int index) {
        return getAttributeValue(someOneElseDoesTextBoxOwnerFirstName.get(index), "value");
    }

    public String getValueFromOwnerMiddleNameField(int index) {
        return getAttributeValue(someOneElseDoesTextBoxOwnerMiddleName.get(index), "value");
    }


    public String getValueFromOwnerLastNameField(int index) {
        return getAttributeValue(someOneElseDoesTextBoxOwnerLastName.get(index), "value");
    }

    public String getValueFromOwnerOrganisationName(int index) {
        return getAttributeValue(textBoxOrganisationName.get(index), "value");
    }


    public void keyInDataOnFieldsRelatedToReporterContactDetails() {
        keyInReporterContactDetails();
    }

    public void keyInDataOnFieldsRelatedToReporterContactDetailsFutureDate() {
        keyInReporterContactDetailsFutureDOB();
    }

    public void keyInDataOnFieldsRelatedToReporterContactDetailsCurrentDate() {
        keyInReporterContactDetailsCurrentDOB();
    }

    public void keyInDataOnFieldsRelatedToReporterContactDetails(boolean addressToKeyInManually, boolean isInternationalAddress) {
        this.reporterAddressToKeyInManually = addressToKeyInManually;
        this.isReporterInternationalAddress = isInternationalAddress;
        keyInReporterContactDetails();
    }

    public void keyInReporterFirstName() {
        sendKeysToWebElement(textBoxReporterFirstName, _generateTestData.generateValidData("personalInformation.firstName"));
    }

    public void keyInReporterMiddleName() {
        sendKeysToWebElement(textBoxReporterMiddleName, _generateTestData.generateValidData("personalInformation.middleName"));
    }

    public void keyInReporterLastName() {
        sendKeysToWebElement(textBoxReporterLastName, _generateTestData.generateValidData("personalInformation.lastName"));
        waitAndClickElement(textBoxReporterMiddleName);
        waitForOwnerLastNameToTurnCaps(textBoxReporterLastName);
    }

    public void keyInReporterPreviousFirstName() {
        sendKeysToWebElement(textBoxAlternateFirstName, _generateTestData.generateValidData("personalInformation.previousFirstName"));
    }

    public void keyInReporterPreviousMiddleName() {
        sendKeysToWebElement(textBoxAlternateMiddleName, _generateTestData.generateValidData("personalInformation.previousMiddleName"));
    }

    public void keyInReporterPreviousLastName() {
        sendKeysToWebElement(textBoxAlternateLastName, _generateTestData.generateValidData("personalInformation.previousLastName"));
        waitAndClickElement(textBoxAlternateMiddleName);
        waitForOwnerLastNameToTurnCaps(textBoxAlternateLastName);
    }

    public void keyInReporterPreviousName() {
        String previousNameIndicator = _generateTestData.generateValidData("personalInformation.previousNameIndicator");
        if (previousNameIndicator.equalsIgnoreCase("yes")) {
            waitAndclickElementUsingJS(checkBoxPreviouslyKnownbyAnotherName);
            keyInReporterPreviousFirstName();
            keyInReporterPreviousMiddleName();
            keyInReporterPreviousLastName();
        }
    }

    public void keyInReporterContactDetails() {
        keyInReporterFirstName();
        keyInReporterMiddleName();
        keyInReporterLastName();
        if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
            keyInReporterDOBMobile();
        } else {
            keyInReporterDOB();
        }
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
    }

    public void keyInReporterContactDetailsFutureDOB() {
        keyInReporterFirstName();
        keyInReporterMiddleName();
        keyInReporterLastName();
        if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
            keyInReporterDOBMobile();
        } else {
            keyInReporterDOBFutureDOB();
        }
        selectReporterGender();
        keyInReporterDriverLicenceNumber();
        keyInReporterPreviousName();
        selectReporterPreferredContactDetails();
        keyInDataReporterEmailAddress(0);
        keyInDataReporterPhoneNumberandPhoneType(0);
        selectReporterDropDownAddressType();
        if (reporterAddressToKeyInManually) {
            clickReporterCantFindAddressCheckBox();
            _addressManualEntry.keyInReporterAddressManually(0, false);
        } else {
            keyInReporterAddress();
        }
    }

    public void keyInReporterContactDetailsCurrentDOB() {
        keyInReporterFirstName();
        keyInReporterMiddleName();
        keyInReporterLastName();
        if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
            keyInReporterDOBMobile();
        } else {
            keyInReporterDOBCurrentDOB();
        }
        selectReporterGender();
        keyInReporterDriverLicenceNumber();
        keyInReporterPreviousName();
        selectReporterPreferredContactDetails();
        keyInDataReporterEmailAddress(0);
        keyInDataReporterPhoneNumberandPhoneType(0);
        selectReporterDropDownAddressType();
        if (reporterAddressToKeyInManually) {
            clickReporterCantFindAddressCheckBox();
            _addressManualEntry.keyInReporterAddressManually(0, false);
        } else {
            keyInReporterAddress();
        }
    }

    public void keyInReporterAddress() {
        executionDeviceConfiguration = new ExecutionDeviceConfiguration(getDeviceKey());
        String deviceType = executionDeviceConfiguration.getDeviceParameters("DEVICE");
        if (deviceType.toLowerCase().contains("tab") || deviceType.equalsIgnoreCase("Google Nexus 9") || deviceType.toLowerCase().contains("ipad")) {
            addressAutoCompleteListMobile = addressAutoCompleteList;
        }
        if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
            selectLookupValue(textBoxReporterAddress, addressAutoCompleteListMobile, _generateTestData.generateValidData("personalInformation.homeAddress"), true);
        } else {
            selectLookupValue(textBoxReporterAddress, addressAutoCompleteList, _generateTestData.generateValidData("personalInformation.homeAddress"), true);
        }
    }


    public void keyInReporterDOB() {
        String dateOfBirth = _generateTestData.generateValidData("personalInformation.dob");
        sendKeysToWebElement(textBoxReporterDateOfBirth, dateOfBirth);
    }

    public void keyInReporterDOBFutureDOB() {
        String dateOfBirth = _generateTestData.generateValidData("personalInformation.dobFuture");
        sendKeysToWebElement(textBoxReporterDateOfBirth, dateOfBirth);
    }

    public void keyInReporterDOBCurrentDOB() {
        String dateOfBirth = getFormattedCurrentDate("dd/MM/yyyy");
        sendKeysToWebElement(textBoxReporterDateOfBirth, dateOfBirth);
    }

    public void selectReporterGender() {
        selectFromDropDownbyValue(dropDownGender, _generateTestData.generateValidData("personalInformation.gender"));
    }

    public void keyInReporterDriverLicenceNumber() {
        sendKeysToWebElement(textBoxDriverLicenseNumber, _generateTestData.generateValidData("personalInformation.driverLicense"));
    }

    public void selectReporterPreferredContactDetails() {
        selectFromDropDownbyValue(dropDownPreferredContactMethod, _generateTestData.generateValidData("personalInformation.preferredContact"));
    }

    public void selectReporterPreviousNameIndicator() {
        waitAndclickElementUsingJS(checkBoxPreviouslyKnownbyAnotherName);
    }

    public void keyInDataOnFieldsRelatedToReporterContactDetailsAllFields() {
        keyInReporterFirstName();
        keyInReporterMiddleName();
        keyInReporterLastName();
        keyInReporterDOB();
        String[] reporterDOBListData = _generateTestData.generateListData("personalInformation.gender");
        _contactDetails.validateReporterGender(reporterDOBListData);
        selectReporterGender();
        keyInReporterDriverLicenceNumber();
        waitAndclickElementUsingJS(checkBoxPreviouslyKnownbyAnotherName);
        sendKeysToWebElement(textBoxAlternateFirstName, _generateTestData.generateValidData("personalInformation.previousFirstName"));
        sendKeysToWebElement(textBoxAlternateMiddleName, _generateTestData.generateValidData("personalInformation.previousMiddleName"));
        sendKeysToWebElement(textBoxAlternateLastName, _generateTestData.generateValidData("personalInformation.previousLastName"));
        String[] preferredContactMethodDropDown = _generateTestData.generateListData("personalInformation.preferredContact");
        _contactDetails.validateReporterPreferredContactMethodDropDown(preferredContactMethodDropDown);
        selectFromDropDownbyValue(dropDownPreferredContactMethod, _generateTestData.generateValidData("personalInformation.preferredContact"));
        keyInDataReporterEmailAddress(0);
        String[] reporterPreferredContactMethodLIst = _generateTestData.generateListData("personalInformation.phoneType");
        _contactDetails.validateReporterPhoneType(reporterPreferredContactMethodLIst);
        keyInDataReporterPhoneNumberandPhoneType(0);
        keyInReporterAddress();
        if (getVictimSupportIndicator().equalsIgnoreCase("yes")) {
            waitAndclickElementUsingJS(toggleReporterVictimSupportYes);
        } else {
            waitAndclickElementUsingJS(toggleReporterVictimSupportNo);
        }
    }


    public void selectVictimSupportIndicator() {
        if (getVictimSupportIndicator().equalsIgnoreCase("yes")) {
            waitAndclickElementUsingJS(toggleReporterVictimSupportYes);
        } else {
            waitAndclickElementUsingJS(toggleReporterVictimSupportNo);
        }
    }

    public void selectVictimSupportIndicatorMobile(String victimSupport) {
        if (victimSupport.equalsIgnoreCase("yes")) {
            waitAndclickElementUsingJS(toggleVictimSupportYesMobile);
        } else {
            waitAndclickElementUsingJS(toggleVictimSupportNoMobile);
        }
    }

    public String getVictimSupportIndicator() {
        return _generateTestData.generateValidData("personalInformation.victimSupportIndicator");
    }

    public void keyInReporterEmailAddress() {
        sendKeysToWebElement(textBoxReporterEmailAddress, _generateTestData.generateValidData("personalInformation.emailAddress"));
    }

    public void keyInDataReporterEmailAddress(int index) {
        sendKeysToWebElement(textBoxEmailAddress.get(index), _generateTestData.generateValidData("personalInformation.emailAddress"));
    }

    public void selectReporterPhoneType() {
        selectFromDropDownbyValue(dropDownPhoneType, _generateTestData.generateValidData("personalInformation.phoneType"));
    }

    public void keyInDataReporterPhoneNumberandPhoneType(int index) {
        selectFromDropDownbyValue(dropDownPhoneType, _generateTestData.generateValidData("personalInformation.phoneType"));
        selectReporterPhoneCountry(index);
        keyInReporterPhoneTypeArea(index);
        keyInReporterPhoneNumber(index);
    }

    public int getPrePopulatedOwnerSomeOneElseDoesDetailsSectionsCount() {
        waitForPageComponentLoadFluentWait();
        return someoneElseDoesSection.size();
    }

    public int getPrePopulatedOwnerOrganisationDetailsSectionsCount() {
        return organisationDoesSection.size();
    }

    public void keyInAgeOfOwnerSomeOneElse(int index) {
        sendKeysToWebElement(someOneElseDoesTextBoxOwnerAgeOrDOB.get(index), _generateTestData.generateValidData("ownerInformation.ownerAge1"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void keyInAgeOfOwnerSomeOneElseInDDMMYYYY(int index) {
        String dateOfBirth = _generateTestData.generateValidData("personalInformation.dob");
        sendKeysToWebElement(someOneElseDoesTextBoxOwnerAgeOrDOB.get(index), dateOfBirth);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void keyInAgeOfOwnerSomeOneElseFutureDate(int index) {
        sendKeysToWebElement(someOneElseDoesTextBoxOwnerAgeOrDOB.get(index), _generateTestData.generateValidData("personalInformation.dobFuture"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void keyInAgeOfOwnerSomeOneElseAgeGreaterThan125(int index) {
        sendKeysToWebElement(someOneElseDoesTextBoxOwnerAgeOrDOB.get(index), _generateTestData.generateValidData("personalInformation.ageGreaterThan125"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void keyInAgeOfOwnerSomeOneElseCurrentDate(int index) {
        sendKeysToWebElement(someOneElseDoesTextBoxOwnerAgeOrDOB.get(index), getFormattedCurrentDate("dd/MM/yyyy"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectRelationsShipOfOwnerSomeOneElse(int index) {
        selectFromDropDownbyValue(dropDownRelationToTheOwner.get(index), _generateTestData.generateValidData("ownerInformation.relationshipToReporter"));
    }

    public void selectInGenderOfOwnerSomeOneElse(int index) {
        selectFromDropDownbyValue(dropDownSomeOneElseDoesOwnerGender.get(index), _generateTestData.generateValidData("ownerInformation.ownerGender1"));
    }


    public void selectAddressTypeSomeOneElseOwner(int index) {
        selectFromDropDownbyValue(dropDownAddressTypeSomeOneElseOwner.get(index), _generateTestData.generateValidData("personalInformation.addressType"));
    }

    public void keyInEmailAddressOfOwnerSomeOneElse(int index) {
        sendKeysToWebElement(someOneElseDoesTextBoxOwnerEmailAddress.get(index), _generateTestData.generateValidData("ownerInformation.ownerEmailAddress1"));
    }

    public void selectPhoneTypeOfOwnerOwnerSomeOneElse(int index) {
        selectFromDropDownbyValue(dropDownSomeOneElseOwnerPhoneType.get(index), _generateTestData.generateValidData("ownerInformation.ownerPhoneType1"));
    }

    public void keyInPhoneNumberOfOwnerSomeOneElse(int index) {
        selectSomebodyElseOwnerPhoneCountry(index);
        keyInSomebodyElseOwnerPhoneTypeArea(index);
        keyInSomebodyElseOwnerPhoneNumber(index);
    }

    public void keyInAddressOfOwnerSomeOneElse(int index) {
        executionDeviceConfiguration = new ExecutionDeviceConfiguration(getDeviceKey());
        String deviceType = executionDeviceConfiguration.getDeviceParameters("DEVICE");
        if (deviceType.toLowerCase().contains("tab") || deviceType.equalsIgnoreCase("Google Nexus 9") || deviceType.toLowerCase().contains("ipad")) {
            addressAutoCompleteListMobile = addressAutoCompleteList;
        }
        if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
            selectLookupValue(someOneElseDoesTextBoxOwnerAddress.get(index), addressAutoCompleteListMobile, _generateTestData.generateValidData("ownerInformation.ownerAddress1"), true);
        } else {
            selectLookupValue(someOneElseDoesTextBoxOwnerAddress.get(index), addressAutoCompleteList, _generateTestData.generateValidData("ownerInformation.ownerAddress1"), true);
        }
    }

    public void keyInAddressOfOwnerSomeOneElse(int index, boolean someoneElseDoesAddressToKeyInManually) {
        executionDeviceConfiguration = new ExecutionDeviceConfiguration(getDeviceKey());
        String deviceType = executionDeviceConfiguration.getDeviceParameters("DEVICE");
        if (deviceType.toLowerCase().contains("tab") || deviceType.equalsIgnoreCase("Google Nexus 9") || deviceType.toLowerCase().contains("ipad")) {
            addressAutoCompleteListMobile = addressAutoCompleteList;
        }
        if (someoneElseDoesAddressToKeyInManually) {
            _addressManualEntry.keyInSomeOneElseDoesOwnerAddressManually(index);
        } else {
            if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
                selectLookupValue(someOneElseDoesTextBoxOwnerAddress.get(index), addressAutoCompleteListMobile, _generateTestData.generateValidData("ownerInformation.ownerAddress1"), true);
            } else {
                selectLookupValue(someOneElseDoesTextBoxOwnerAddress.get(index), addressAutoCompleteList, _generateTestData.generateValidData("ownerInformation.ownerAddress1"), true);
            }
        }
    }

    public void keyInAddressOfOwnerSomeOneElse(int index, boolean someoneElseDoesAddressToKeyInManually, boolean isAddressInternational) {
        executionDeviceConfiguration = new ExecutionDeviceConfiguration(getDeviceKey());
        String deviceType = executionDeviceConfiguration.getDeviceParameters("DEVICE");
        if (deviceType.toLowerCase().contains("tab") || deviceType.equalsIgnoreCase("Google Nexus 9") || deviceType.toLowerCase().contains("ipad")) {
            addressAutoCompleteListMobile = addressAutoCompleteList;
        }
        if (someoneElseDoesAddressToKeyInManually) {
            _addressManualEntry.keyInSomeOneElseDoesOwnerAddressManually(index, isAddressInternational);
        } else {
            if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
                selectLookupValue(someOneElseDoesTextBoxOwnerAddress.get(index), addressAutoCompleteListMobile, _generateTestData.generateValidData("ownerInformation.ownerAddress1"), true);
            } else {
                selectLookupValue(someOneElseDoesTextBoxOwnerAddress.get(index), addressAutoCompleteList, _generateTestData.generateValidData("ownerInformation.ownerAddress1"), true);
            }
        }
    }

    public void keyInAddressOfOrganisationOwner(int index) {
        executionDeviceConfiguration = new ExecutionDeviceConfiguration(getDeviceKey());
        String deviceType = executionDeviceConfiguration.getDeviceParameters("DEVICE");
        if (deviceType.toLowerCase().contains("tab") || deviceType.equalsIgnoreCase("Google Nexus 9") || deviceType.toLowerCase().contains("ipad")) {
            addressAutoCompleteListMobile = addressAutoCompleteList;
        }
        if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
            selectLookupValue(textBoxOrganisationAddress.get(0), addressAutoCompleteListMobile, _generateTestData.generateValidData("ownerInformation.ownerAddress1"), true);
        } else {
            selectLookupValue(textBoxOrganisationAddress.get(0), addressAutoCompleteList, _generateTestData.generateValidData("ownerInformation.ownerAddress1"), true);
        }
        selectInOrganisationOwnerPhoneType(index);
        keyInOrganisationOwnerPhoneNumber(index);
    }

    public void selectInOrganisationOwnerPhoneType(int index) {
        selectFromDropDownbyValue(dropDownOrganisationOwnerPhoneType.get(index), _generateTestData.generateValidData("personalInformation.phoneType"));
    }


    public void keyInAddressOfOrganisationOwner(int index, boolean organisationDoesAddressToKeyInManually) {
        executionDeviceConfiguration = new ExecutionDeviceConfiguration(getDeviceKey());
        String deviceType = executionDeviceConfiguration.getDeviceParameters("DEVICE");
        if (deviceType.toLowerCase().contains("tab") || deviceType.equalsIgnoreCase("Google Nexus 9") || deviceType.toLowerCase().contains("ipad")) {
            addressAutoCompleteListMobile = addressAutoCompleteList;
        }
        if (organisationDoesAddressToKeyInManually) {
            _contactDetails.clickOrganisationOwnerCantFindAddressCheckBox(index);
            _addressManualEntry.keyInOrganisationDoesOwnerAddressManually(index);
        } else {
            if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
                selectLookupValue(textBoxOrganisationAddress.get(index), addressAutoCompleteListMobile, _generateTestData.generateValidData("ownerInformation.ownerAddress1"), true);
            } else {
                selectLookupValue(textBoxOrganisationAddress.get(index), addressAutoCompleteList, _generateTestData.generateValidData("ownerInformation.ownerAddress1"), true);
            }
        }
        _contactDetails.selectInOrganisationOwnerPhoneType(index);
        _contactDetails.keyInOrganisationOwnerPhoneNumber(index);
    }

    public void addOwnerSomeOneElseEmailAddress() {
        int emailAddressCount = textBoxEmailAddress.size();
        waitAndclickElementUsingJS(buttonAddEmailAddress);
        waitForPageComponentLoadFluentWait();
        int emailAddressCountAfterAddition = textBoxEmailAddress.size();
        Assert.assertEquals(emailAddressCount + 1, emailAddressCountAfterAddition, "Additional email address field is not added successfully");
        sendKeysToWebElement(textBoxEmailAddress.get(0), "email1@gmail.com");
        sendKeysToWebElement(textBoxEmailAddress.get(1), "email2@gmail.com");
    }

    public void deleteOwnerSomeOneElseEmailAddress() {
        int emailAddressCount = textBoxEmailAddress.size();
        Assert.assertTrue(emailAddressCount > 0, "Additional email address field is not added successfully");
        //TODO - commented index 1 due to bug
        //waitAndclickElementUsingJS(buttonDeleteEmailAddress.get(1));
        waitAndclickElementUsingJS(buttonDeleteEmailAddress.get(0));
        waitForPageComponentLoadFluentWait();
        int emailAddressCountAfterDeletion = textBoxEmailAddress.size();
        Assert.assertEquals(emailAddressCount - 1, emailAddressCountAfterDeletion, "Additional email address field is not removed successfully");
    }

    public void addOwnerSomeOneElsePhoneNumber() {
        int emailAddressCount = textBoxPhoneNumber.size();
        waitAndclickElementUsingJS(buttonAddPhoneNumber);
        waitForPageComponentLoadFluentWait();
        int emailAddressCountAfterAddition = textBoxPhoneNumber.size();
        Assert.assertEquals(emailAddressCount + 1, emailAddressCountAfterAddition, "Additional email address field is not added successfully");
        sendKeysToWebElement(textBoxPhoneNumber.get(0), "021021021");
        sendKeysToWebElement(textBoxPhoneNumber.get(1), "021021111");
    }

    public void deleteOwnerSomeOneElsePhoneNumber() {
        int emailAddressCount = textBoxPhoneNumber.size();
        Assert.assertTrue(emailAddressCount > 0, "Additional email address field is not added successfully");
        //TODO - commented index 1 due to bug
//        waitAndclickElementUsingJS(buttonDeletePhoneNumber.get(1));
        waitAndclickElementUsingJS(buttonDeletePhoneNumber.get(0));
        waitForPageComponentLoadFluentWait();
        int emailAddressCountAfterDeletion = textBoxPhoneNumber.size();
        Assert.assertEquals(emailAddressCount - 1, emailAddressCountAfterDeletion, "Additional email address field is not removed successfully");
    }

    /*public void selectVictimSupportFlag(String flag) {
        if (flag.equalsIgnoreCase("yes")) {
            waitAndclickElementUsingJS(toggleVictimSupportYes);
        } else if (flag.equalsIgnoreCase("no")) {
            waitAndclickElementUsingJS(toggleVictimSupportNo);
        }
    }*/

    //TODO Change after identifying platform
    public void selectSomeElseOwnerVictimSupportFlag(String flag, int index) {
        if (flag.equalsIgnoreCase("yes")) {
            waitAndclickElementUsingJS(toggleSomeOneElseOwnerVictimSupportYes.get(index));
        } else if (flag.equalsIgnoreCase("no")) {
            waitAndclickElementUsingJS(toggleSomeOneElseOwnerVictimSupportNo.get(index));
        }
    }

    //TODO Change after identifying platform
    public void selectVictimSupportFlag(String flag) {
        if (flag.equalsIgnoreCase("yes")) {
            waitAndclickElementUsingJS(toggleReporterVictimSupportYes);
        } else if (flag.equalsIgnoreCase("no")) {
            waitAndclickElementUsingJS(toggleReporterVictimSupportNo);
        }
    }

    public void selectSomethingElseOwnerSupportFlagMobile(String flag) {
        if (flag.equalsIgnoreCase("yes")) {
            waitAndclickElementUsingJS(toggleSomethingElseOwnerVictimSupportYes);
        } else if (flag.equalsIgnoreCase("no")) {
            waitAndclickElementUsingJS(toggleSomethingElseOwnerVictimSupportNo);
        }

    }


    public List<WebElement> getTextOfSomeoneElseDoesOwnerFirstNameHeaderInContactDetailsPage() {
        return contactDetailsSomeoneElseDoesOwnerNameHeader;
    }

    public List<WebElement> getTextOfOrganisationDoesOwnerFirstNameHeaderInContactDetailsPage() {
        return contactDetailsOrganisationDoesOwnerNameHeader;
    }

    public void validateReporterGender(String[] expectedList) {
        List<WebElement> dropDownValues = getAllListValuesInDropDown(dropDownGender);
        validateDropDownListValues(dropDownValues, expectedList);
    }

    public void validateOwnerPhoneType(String[] expectedList) {
        List<WebElement> dropDownValues = getAllListValuesInDropDown(dropDownPhoneTypeOwner);
        validateDropDownListValues(dropDownValues, expectedList);
    }

    public void validateReporterPhoneType(String[] expectedList) {
        List<WebElement> dropDownValues = getAllListValuesInDropDown(dropDownPhoneType);
        validateDropDownListValues(dropDownValues, expectedList);
    }

    public void validateReporterAddressType(String[] expectedList) {
        List<WebElement> dropDownValues = getAllListValuesInDropDown(dropDownReporterAddressTypeMobile);
        validateDropDownListValues(dropDownValues, expectedList);
    }


    public void validateReporterPreferredContactMethodDropDown(String[] expectedList) {
        List<WebElement> dropDownValues = getAllListValuesInDropDown(dropDownPreferredContactMethod);
        validateDropDownListValues(dropDownValues, expectedList);
    }

    public void validateSomeOneElseOwnerGender(String[] expectedList) {
        List<WebElement> dropDownValues = getAllListValuesInDropDown(dropDownSomeOneElseDoesOwnerGender.get(0));
        validateDropDownListValues(dropDownValues, expectedList);
    }

    public void validateSomeOneElseOwnerPhoneType(String[] expectedList) {
        List<WebElement> dropDownValues = getAllListValuesInDropDown(dropDownSomeOneElseOwnerPhoneType.get(0));
        validateDropDownListValues(dropDownValues, expectedList);
    }

    public void clickOnContinueToNavigateToSummaryPage() {
        waitAndclickElementUsingJS(buttonContinueToSummaryPage);
    }

    public void continueAndCloseAlert() {
        clickelementAndCloseAlert(buttonContinueToSummaryPage);
    }

    public int expectedCountOfOwnerSections() {
        int damagedVehicleSomeOneElseCount = _eventDamaged.addAndRetrieveDamagedVehicleOwnerSomeOneElseIndex();
        int damagedVehicleOrganisationCount = _eventDamaged.addAndRetrieveDamagedVehicleOrganisationOwnerIndex();
        int damagedItemSomeOneElseCount = _eventDamaged.addAndRetrieveDamagedItemOwnerSomeOneElseIndex();
        int damagedItemOrganisationCount = _eventDamaged.addAndRetrieveDamagedItemOrganisationOwnerIndex();
        int stolenVehicleSomeOneElseCount = _eventStolen.addAndRetrieveStolenVehicleOwnerSomeOneElseIndex();
        int stolenVehicleOrganisationCount = _eventStolen.addAndRetrieveStolenVehicleOrganisationOwnerIndex();
        int stolenItemSomeOneElseCount = _eventStolen.addAndRetrieveStolenItemOwnerSomeOneElseIndex();
        int stolenItemOrganisationCount = _eventStolen.addAndRetrieveStolenItemOrganisationOwnerIndex();
        return damagedVehicleSomeOneElseCount + damagedVehicleOrganisationCount + damagedItemSomeOneElseCount + damagedItemOrganisationCount
                + stolenVehicleSomeOneElseCount + stolenVehicleOrganisationCount + stolenItemSomeOneElseCount + stolenItemOrganisationCount;
    }


    public void clickReporterCantFindAddressCheckBox() {
        waitAndclickElementUsingJS(checkBoxCantFindAddress);
    }

    public boolean checkReporterAddressAutoCompleteFieldIsInvisible() {
        return isElementNotDisplayed(textBoxReporterAddress);
    }

    public boolean checkReporterCantFindAddressIsInvisible() {
        return isElementNotDisplayed(checkBoxCantFindAddress);
    }

    public boolean checkReporterCantFindAddressIsVisible() {
        return isElementDisplayed(checkBoxCantFindAddress);
    }


    public void clickSomeOneElseOwnerCantFindAddressCheckBox() {
        waitAndclickElementUsingJS(cantFindAddressSomeOneElseOwner.get(0));
    }

    public void clickSomeOneElseOwnerCantFindAddressCheckBox(int index) {
        waitAndclickElementUsingJS(cantFindAddressSomeOneElseOwner.get(index));
    }


    public boolean checkSomeOneElseOwnerAddressAutoCompleteFieldIsInvisible() {
        if (someOneElseDoesTextBoxOwnerAddress.size() > 0) {
            return isElementNotDisplayed(someOneElseDoesTextBoxOwnerAddress.get(0));
        } else {
            return true;
        }
    }

    public boolean checkSomeOneElseOwnerCantFindAddressIsInvisible() {
        if (cantFindAddressSomeOneElseOwner.size() > 0) {
            return isElementNotDisplayed(cantFindAddressSomeOneElseOwner.get(0));
        } else {
            return true;
        }
    }

    public boolean checkSomeOneElseOwnerCantFindAddressIsVisible() {
        return isElementDisplayed(cantFindAddressSomeOneElseOwner.get(0));
    }

    public void clickOrganisationOwnerCantFindAddressCheckBox() {
        waitAndclickElementUsingJS(cantFindAddressOrganisationOwner.get(0));
    }

    public void clickOrganisationOwnerCantFindAddressCheckBox(int index) {
        waitAndclickElementUsingJS(cantFindAddressOrganisationOwner.get(index));
    }

    public boolean checkOrganisationOwnerAddressAutoCompleteFieldIsInvisible() {
        if (textBoxOrganisationAddress.size() > 0) {
            return isElementNotDisplayed(textBoxOrganisationAddress.get(0));
        } else {
            return true;
        }
    }

    public boolean checkOrganisationOwnerCantFindAddressIsInvisible() {
        if (cantFindAddressOrganisationOwner.size() > 0) {
            return isElementNotDisplayed(cantFindAddressOrganisationOwner.get(0));
        } else {
            return true;
        }
    }

    public boolean checkOrganisationOwnerCantFindAddressIsVisible() {
        return isElementDisplayed(cantFindAddressOrganisationOwner.get(0));
    }

    public void keyInStartTimeMobile(String startTime, String startTimeFormatted) {
        updateFieldValueUsingJavaScriptMobile("//input[@data-test-id='2019050714545402381390' and @type='time']", startTime, "//input[@data-test-id='2019050714545402381390' and @type='hidden']", startTimeFormatted);
    }

    public void keyInReporterDOBMobile() {

        if (_platFormName.equalsIgnoreCase("ios")) {
            updateFieldValueUsingJavaScriptMobile("//input[@data-test-id='2019041018133200689996' and @type='date']", "2017-10-31", "//input[@data-test-id='2019041018133200689996' and @type='hidden']", "31/10/2017");
            /*wait.until(ExpectedConditions.elementToBeClickable(reporterDOBIOS)).click();
            List<WebElement> dobPicker = new WebDriverWait(_appiumDriver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(pickersIOS));
            dobPicker.get(0).sendKeys("July");
            dobPicker.get(1).sendKeys("10");
            dobPicker.get(2).sendKeys("1999");
            wait.until(ExpectedConditions.elementToBeClickable(nativeDoneButtonIOS)).click();*/
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

    public void selectReporterGenderMobile() {
        selectReporterGender();
    }

    public void selectReporterPhoneTypeMobile() {
        selectReporterPhoneType();
    }


    public void selectPreferredContactMethodMobile() {
        selectReporterPreferredContactDetails();
    }

    public void selectAddressTypeMethodMobile() {
        selectReporterDropDownAddressType();

    }

    public void clickOnContinueButtonFromReporterPage() {
        waitAndclickElementUsingJS(buttonContinueFromReporterPage);
    }

    public void selectReporterDropDownAddressType() {
        if (_platFormName.equalsIgnoreCase("ios") || _platFormName.equalsIgnoreCase("android")) {
            selectFromDropDownbyValue(dropDownReporterAddressTypeMobile, _generateTestData.generateValidData("personalInformation.addressType"));
        } else {
            selectFromDropDownbyValue(dropDownReporterAddressType, _generateTestData.generateValidData("personalInformation.addressType"));
        }
    }

    public void enterPersonInformationWithoutPhoneAndType() {
        sendKeysToWebElement(textBoxReporterFirstName, _generateTestData.generateValidData("personalInformation.firstName"));
        sendKeysToWebElement(textBoxReporterMiddleName, _generateTestData.generateValidData("personalInformation.middleName"));
        sendKeysToWebElement(textBoxReporterLastName, _generateTestData.generateValidData("personalInformation.lastName"));
        keyInReporterDOB();
        selectFromDropDownbyValueByClick(dropDownGender, _generateTestData.generateValidData("personalInformation.gender"));
        sendKeysToWebElement(textBoxDriverLicenseNumber, _generateTestData.generateValidData("personalInformation.driverLicense"));
        selectFromDropDownbyValue(dropDownPreferredContactMethod, _generateTestData.generateValidData("personalInformation.preferredContact"));
        keyInDataReporterEmailAddress(0);
        if (reporterAddressToKeyInManually) {
            clickReporterCantFindAddressCheckBox();
            _addressManualEntry.keyInReporterAddressManually(0, false);
        } else {
            keyInReporterAddress();
        }
    }

    public void selectPhoneType() {
        selectFromDropDownbyValue(dropDownPhoneType, _generateTestData.generateValidData("personalInformation.phoneType"));
    }

    public void validatePreviousNamePrompt() {
        isElementDisplayed(labelPreviouslyKnownbyAnotherName);
    }

    public void selectUseTheAddressIEnteredEarlier() {
        waitAndclickElementUsingJS(checkBoxUseTheAddressIEnteredEarlier);
    }

    public void validateEarlierAddressValueOnReporter(String address) {
        waitForPageComponentLoadFluentWait();
        Assert.assertEquals(textAddressIEnteredEarlierMobile.getText().trim(), address);
    }

    public void validateReporterHomeAddressType() {
        isElementDisplayed(dropDownReporterAddressTypeMobile);
        isElementEnabled(dropDownReporterAddressTypeMobile);
        Assert.assertEquals(getDefaultSelectedOptionForDropDown(dropDownReporterAddressTypeMobile), "Home address");
    }

    public void validateEarlierAddressEnteredOptionIsNotAvailable() {
        isElementNotDisplayed(checkBoxUseTheAddressIEnteredEarlier);
    }

    public void keyInSpecificReporterDOBMobile(String dateType) {
        String yearPart = null;
        String currentDatePart = null;
        String currentFullMonthPart = null;
        switch (dateType.toUpperCase()) {
            case "CURRENT":
                currentDatePart = getCurrentDateParts("dd");
                currentFullMonthPart = getCurrentDateParts("MMMM");
                yearPart = getCurrentDateParts("yyyy");
                reporterDOBNewYearAndroid = reporterDOBCurrentYearAndroid;
                break;
            case "FUTURE":
                yearPart = getfutureYear(1);
                reporterDOBNewYearAndroid = reporterDOBFutureYearAndroid;
                break;
        }
        //switchToNativeApp();
        if (_platFormName.equalsIgnoreCase("ios")) {
            scrollTillElementFound(datePickerDOBMobile, labelFirstElementOfPage);
            switchToNativeApp();
            wait.until(ExpectedConditions.elementToBeClickable(reporterDOBIOS)).click();
            List<WebElement> dobPicker = new WebDriverWait(_appiumDriver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(pickersIOS));
            dobPicker.get(0).sendKeys(currentDatePart);
            dobPicker.get(1).sendKeys(currentFullMonthPart);
            dobPicker.get(2).sendKeys(yearPart);
            wait.until(ExpectedConditions.elementToBeClickable(nativeDoneButtonIOS)).click();
        } else if (_platFormName.equalsIgnoreCase("android")) {
            switchToWebView();
            actionMoveAndClick(mobileViewReporterDOB);
            waitAndclickElementUsingJS(mobileViewReporterDOB);
//            actionMoveAndClick(mobileViewReporterDOB);
            switchToNativeApp();
            (new TouchAction(_appiumDriver))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)))
                    .perform();
            wait.until(ExpectedConditions.elementToBeClickable(reporterDOBYearAndroid)).click();
            wait.until(ExpectedConditions.elementToBeClickable(reporterDOBNewYearAndroid)).click();
            wait.until(ExpectedConditions.elementToBeClickable(reporterDOBCalendarSetButtonAndroid)).click();
        }
        switchToWebView();
    }

    public void validateErrorMessage(String textToVerify) {
        _genericControls.clickOnCloseButtonInPopup();
        Assert.assertEquals(waitandGetText(textDOBError).trim(), textToVerify.trim());
    }

    public void keyInSpecificOwnerDOBMobile(String dateType) {
        String yearPart = null;
        String dob = null;
        String currentDatePart = getCurrentDateParts("dd");
        String currentMonthPart = getCurrentDateParts("MM");

        switch (dateType.toUpperCase()) {
            case "CURRENT":
//                currentDatePart = getCurrentDateParts("dd");
//                currentMonthPart = getCurrentDateParts("MM");
                yearPart = getCurrentDateParts("yyyy");
                break;
            case "FUTURE":
                yearPart = getfutureYear(1);
                break;
        }
        dob = currentDatePart + "/" + currentMonthPart + "/" + yearPart;
        sendKeysToWebElement(textBoxSomeOneElseOwnerAgeOrDOBMobile, dob);
    }

    public void clearOwnerDOBandvalidateError() {
        waitForPageComponentLoadFluentWait();
        textBoxSomeOneElseOwnerAgeOrDOBMobile.clear();
        waitForPageComponentLoadFluentWait();
        clickOnContinueButtonFromReporterPage();
        validateErrorMessage("Please enter an age (in years) or a date of birth (DD/MM/YYYY)");
    }

    public void clickBackButtonOnMobile() {
        waitAndclickElementUsingJS(buttonBackMobile);
    }

    public void verifyContactDetailPage() {
        isElementDisplayed(textBoxReporterFirstName);
    }

    public String getReporterFutureDateError() {
        return waitandGetText(labelErrorFutureAndCurrentDateValidation);
    }

    public void selectReporterPhoneCountry(int index) {
        verifyReporterPhoneCountryField(index);
        selectFromDropDownbyValue(dropDownReporterPhoneTypeCountry.get(index), _generateTestData.generateValidData("personalInformation.reporterPhoneCountryCode"));
    }

    public void keyInReporterPhoneTypeArea(int index) {
        sendKeysToWebElement(textBoxReporterPhoneNumberArea.get(index), "04");
    }

    public void keyInReporterPhoneNumber(int index) {
        sendKeysToWebElement(textBoxReporterPhoneNumber.get(index), _generateTestData.generateValidData("personalInformation.phoneNumber"));
    }

    public void verifyReporterPhoneCountryField(int index) {
        Select select = new Select(dropDownReporterPhoneTypeCountry.get(index));
        Assert.assertTrue(select.getOptions().size() > 1);
        String[] country = _generateTestData.generateListData("personalInformation.reporterPhoneCountryCode");
        List<WebElement> dropDownValues = getAllListValuesInDropDown(dropDownReporterPhoneTypeCountry.get(0));
        validateDropDownListValues(dropDownValues, country);
    }


    public void selectSomebodyElseOwnerPhoneCountry(int index) {
        verifySomebodyElseOwnerPhoneCountryField(index);
        selectFromDropDownbyValue(dropDownSomebodyElseOwnerPhoneTypeCountry.get(index), _generateTestData.generateValidData("personalInformation.reporterPhoneCountryCode"));
    }

    public void keyInSomebodyElseOwnerPhoneTypeArea(int index) {
        sendKeysToWebElement(textBoxSomebodyElseOwnerPhoneNumberArea.get(index), "04");
    }

    public void keyInSomebodyElseOwnerPhoneNumber(int index) {
        sendKeysToWebElement(textBoxSomebodyElseOwnerPhoneNumber.get(index), _generateTestData.generateValidData("personalInformation.phoneNumber"));
    }

    public void verifySomebodyElseOwnerPhoneCountryField(int index) {
        Select select = new Select(dropDownSomebodyElseOwnerPhoneTypeCountry.get(index));
        Assert.assertTrue(select.getOptions().size() > 1);
        String[] country = _generateTestData.generateListData("personalInformation.reporterPhoneCountryCode");
        List<WebElement> dropDownValues = getAllListValuesInDropDown(dropDownSomebodyElseOwnerPhoneTypeCountry.get(0));
        validateDropDownListValues(dropDownValues, country);
    }

    public void selectOrganisationOwnerPhoneCountry(int index) {
        verifyOrganisationOwnerPhoneCountryField(index);
        selectFromDropDownbyValue(dropDownOrganisationOwnerPhoneTypeCountry.get(index), _generateTestData.generateValidData("personalInformation.reporterPhoneCountryCode"));
    }

    public void keyInOrganisationOwnerPhoneTypeArea(int index) {
        sendKeysToWebElement(textBoxOrganisationOwnerPhoneNumberArea.get(index), "04");
    }

    public void keyInOrganisationOwnerPhoneNumber(int index) {
        selectOrganisationOwnerPhoneCountry(index);
        keyInOrganisationOwnerPhoneTypeArea(index);
        sendKeysToWebElement(textBoxOrganisationOwnerPhoneNumber.get(index), _generateTestData.generateValidData("personalInformation.phoneNumber"));
    }

    public void verifyOrganisationOwnerPhoneCountryField(int index) {
        Select select = new Select(dropDownOrganisationOwnerPhoneTypeCountry.get(index));
        Assert.assertTrue(select.getOptions().size() > 1);
        String[] country = _generateTestData.generateListData("personalInformation.reporterPhoneCountryCode");
        List<WebElement> dropDownValues = getAllListValuesInDropDown(dropDownOrganisationOwnerPhoneTypeCountry.get(0));
        validateDropDownListValues(dropDownValues, country);
    }


    public void validateReporterPhoneCountry(String[] expectedList) {


    }
}
