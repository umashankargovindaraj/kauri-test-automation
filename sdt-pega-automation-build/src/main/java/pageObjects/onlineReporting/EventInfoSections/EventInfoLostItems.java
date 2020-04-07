package pageObjects.onlineReporting.EventInfoSections;

import io.appium.java_client.MobileBy;
import libs.BasePage;
import libs.ExecutionDeviceConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class EventInfoLostItems extends BasePage {


    private @FindBy(xpath = "//div[@data-test-id='201905221626590301705']")
    List<WebElement> sectionLostProperty = null;
    private @FindBy(xpath = "//input[@data-test-id='2019050711100204154647' and contains(@placeholder,'Start typing')]")
    List<WebElement> textBoxWhatWasLost = null;
    private @FindBy(xpath = "//table[contains(@pl_prop,'D_ItemsList')]//tr[contains(@oaargs, 'Police-SDW-Data-Items')]")
    List<WebElement> whatwasLostAutoComplete = null;
    private @FindBy(xpath = "//div[@class='autocomplete-results']//li[contains(@class,'ac-item')]")
    List<WebElement> whatwasLostAutoCompleteMobile = null;
    private @FindBy(xpath = "//select[@data-test-id='20190513125205099561874']")
    List<WebElement> dropDownWhoOwnsLostProperty = null;
    private @FindBy(xpath = "//input[@data-test-id='2019041209454504561735']")
    List<WebElement> textBoxItemID = null;
    private @FindBy(xpath = "//input[@data-test-id='20190619153612088912683']")
    List<WebElement> textBoxValueOfLostItem = null;
    private @FindBy(xpath = "//textarea[@data-test-id='20190619153620048213980']")
    List<WebElement> textBoxDescribeLostProperty = null;

    private @FindBy(xpath = "//input[@data-test-id='201905081628560147410699']")
    List<WebElement> textBoxLostPropertyOwnerFirstName = null;
    private @FindBy(xpath = "//input[@data-test-id='201905081628560148411401']")
    List<WebElement> textBoxLostPropertyOwnerMiddleName = null;
    private @FindBy(xpath = "//input[@data-test-id='201905081628560149412135']")
    List<WebElement> textBoxLostPropertyOwnerLastName = null;
    private @FindBy(xpath = "//input[@data-test-id='20190528170032047648357']")
    List<WebElement> textBoxLostPropertyOwnerOrganisationName = null;

    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//input[@data-test-id='20190412132543093548630']")
    List<WebElement> checkBoxCantFindAddressSomeOneElseDoesOwner = null;
    private @FindBy(xpath = "//div[@data-test-id='201905091206250186440']//input[@data-test-id='20190412132543093548630']")
    List<WebElement> checkBoxCantFindAddressOrganisationDoesOwner = null;


    private @FindBy(xpath = "//button[@data-test-id='20190522164128092867750']")
    WebElement buttonAddLostItem = null;

    private @FindBy(xpath = "//button[@data-test-id='20161017110917023176385']")
    WebElement buttonContinueFromLostPageMobile = null;

    private By pickersIOS = MobileBy.className("XCUIElementTypePickerWheel");
    private By nativeDoneButtonIOS = MobileBy.xpath("//XCUIElementTypeButton[@name='Done']");
    private By dropDownOwnerFirstLostPropertyIOS = MobileBy.xpath("//XCUIElementTypeOther[@name=\"Process Work Area, main\"]/XCUIElementTypeOther[3]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[6]/XCUIElementTypeOther");
    private By dropDownOwnerSecondLostPropertyIOS = MobileBy.xpath("//XCUIElementTypeOther[@name=\"Process Work Area, main\"]/XCUIElementTypeOther[3]/XCUIElementTypeOther[5]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[6]/XCUIElementTypeOther");
    private By dropDownOwnerThirdLostPropertyIOS = MobileBy.xpath("//XCUIElementTypeOther[@name=\"Process Work Area, main\"]/XCUIElementTypeOther[3]/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[6]/XCUIElementTypeOther");

    public void clickOnCheckBoxCantFindAddressSomeOneElseOwner(int index) {
        waitAndclickElementUsingJS(checkBoxCantFindAddressSomeOneElseDoesOwner.get(index));
    }

    public void clickOnCheckBoxCantFindAddressOrganisationOwner(int index) {
        waitAndclickElementUsingJS(checkBoxCantFindAddressOrganisationDoesOwner.get(index));
    }

    public void keyInWhatWasLost() {
        executionDeviceConfiguration = new ExecutionDeviceConfiguration(getDeviceKey());
        String deviceType = executionDeviceConfiguration.getDeviceParameters("DEVICE");
        if (deviceType.toLowerCase().contains("tab") || deviceType.equalsIgnoreCase("Google Nexus 9") || deviceType.toLowerCase().contains("ipad")) {
            whatwasLostAutoCompleteMobile = whatwasLostAutoComplete;
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int lostItemsCommonFieldsIndex = addAndRetrieveLostItemsCommonFieldsIndex();
        if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
            selectLookupValue(textBoxWhatWasLost.get(lostItemsCommonFieldsIndex), whatwasLostAutoCompleteMobile, _generateTestData.generateValidData("whatWasLost.lostItem"), false);
        } else {
            selectLookupValue(textBoxWhatWasLost.get(lostItemsCommonFieldsIndex), whatwasLostAutoComplete, _generateTestData.generateValidData("whatWasLost.lostItem"), false);
        }
    }

    public void keyInDescribeHowWasItemLost() {
        int lostItemsCommonFieldsIndex = addAndRetrieveLostItemsCommonFieldsIndex();
        sendKeysToWebElement(textBoxDescribeLostProperty.get(lostItemsCommonFieldsIndex), _generateTestData.generateValidData("whatWasLost.description"));
    }

    public void keyInLostItemID() {
        int lostItemsCommonFieldsIndex = addAndRetrieveLostItemsCommonFieldsIndex();
        sendKeysToWebElement(textBoxItemID.get(lostItemsCommonFieldsIndex), _generateTestData.generateValidData("whatWasLost.itemID"));
    }

    public void keyInLostItemValue() {
        int lostItemsCommonFieldsIndex = addAndRetrieveLostItemsCommonFieldsIndex();
        sendKeysToWebElement(textBoxValueOfLostItem.get(lostItemsCommonFieldsIndex), _generateTestData.generateValidData("whatWasLost.itemValue"));
    }

    public void selectLostItemOwnerFromDropDown(String owner) {
        int lostItemsCommonFieldsIndex = addAndRetrieveLostItemsCommonFieldsIndex();
        selectFromDropDownbyValue(dropDownWhoOwnsLostProperty.get(lostItemsCommonFieldsIndex), owner);
    }

    public void selectLostItemOwnerFromDropDownMobile(String owner) {
        int lostItemsCommonFieldsIndex = addAndRetrieveLostItemsCommonFieldsIndex();
        switchToNativeApp();
        if (_platFormName.equalsIgnoreCase("ios")) {
            switch (lostItemsCommonFieldsIndex) {
                case 0:
                    wait.until(ExpectedConditions.elementToBeClickable(dropDownOwnerFirstLostPropertyIOS)).click();
                    break;
                case 1:
                    wait.until(ExpectedConditions.elementToBeClickable(dropDownOwnerSecondLostPropertyIOS)).click();
                    break;
                case 2:
                    wait.until(ExpectedConditions.elementToBeClickable(dropDownOwnerThirdLostPropertyIOS)).click();
                    break;
            }
            List<WebElement> pickerEls = new WebDriverWait(_appiumDriver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(pickersIOS));
            pickerEls.get(0).sendKeys(owner);
            wait.until(ExpectedConditions.elementToBeClickable(nativeDoneButtonIOS)).click();
        } else if (_platFormName.equalsIgnoreCase("android")) {
            //TODO TO IMPLEMENT ANDROID
        }
        switchToWebView();

    }


    public void keyInLostItemOwnerFirstName(String firstName) {
        int lostItemsOwnerSomeOneElseIndex = addAndRetrieveLostItemOwnerSomeOneElseIndex();
        sendKeysToWebElement(textBoxLostPropertyOwnerFirstName.get(lostItemsOwnerSomeOneElseIndex), firstName);
    }

    public void keyInLostItemOwnerMiddleName(String middleName) {
        int lostItemsOwnerSomeOneElseIndex = addAndRetrieveLostItemOwnerSomeOneElseIndex();
        sendKeysToWebElement(textBoxLostPropertyOwnerMiddleName.get(lostItemsOwnerSomeOneElseIndex), middleName);
    }

    public void keyInLostItemOwnerLastName(String lastName) {
        int lostItemsOwnerSomeOneElseIndex = addAndRetrieveLostItemOwnerSomeOneElseIndex();
        sendKeysToWebElement(textBoxLostPropertyOwnerLastName.get(lostItemsOwnerSomeOneElseIndex), lastName);
        _persistentData.setContext("lostItemsOwnerSomeOneElseIndex", lostItemsOwnerSomeOneElseIndex + 1);
    }

    public void keyInLostItemOwnerOrganisationName(String organisationName) {
        int lostItemsOrganisationOwnerIndex = addAndRetrieveLostItemOrganisationOwnerIndex();
        sendKeysToWebElement(textBoxLostPropertyOwnerOrganisationName.get(lostItemsOrganisationOwnerIndex), organisationName);
        _persistentData.setContext("lostItemsOrganisationOwnerIndex", lostItemsOrganisationOwnerIndex + 1);
    }

    public void keyInLostVehicleOwnerName(String owner) {
        int lostItemsCommonFieldsIndex = addAndRetrieveLostItemsCommonFieldsIndex();
        int lostItemsOwnerSomeOneElseIndex = addAndRetrieveLostItemOwnerSomeOneElseIndex();
        switch (owner) {
            case "An organisation does":
                String organisation = _generateTestData.generateValidData("whatWasLost.owner.organisationName");
                keyInLostItemOwnerOrganisationName(organisation);
                waitAndClickElement(textBoxDescribeLostProperty.get(lostItemsCommonFieldsIndex));
                //waitForOwnerNameToLoadInDropDown(dropDownWhoOwnsLostProperty.get(lostItemsCommonFieldsIndex), organisation);
                break;
            case "Somebody else does":
                String firstName = _generateTestData.generateValidData("whatWasLost.owner.firstName");
                keyInLostItemOwnerFirstName(firstName);
                waitAndClickElement(textBoxLostPropertyOwnerMiddleName.get(lostItemsOwnerSomeOneElseIndex));
                //waitForOwnerNameToLoadInDropDown(dropDownWhoOwnsLostProperty.get(lostItemsCommonFieldsIndex), firstName);
                keyInLostItemOwnerMiddleName(_generateTestData.generateValidData("whatWasLost.owner.middleName"));
                keyInLostItemOwnerLastName(_generateTestData.generateValidData("whatWasLost.owner.lastName"));
                waitAndClickElement(textBoxLostPropertyOwnerMiddleName.get(lostItemsOwnerSomeOneElseIndex));
                waitForOwnerLastNameToTurnCaps(textBoxLostPropertyOwnerLastName.get(lostItemsOwnerSomeOneElseIndex));
                break;
        }
    }

    public void keyInLostVehicleOwnerNameMobile(String owner) {
        switch (owner) {
            case "An organisation does":
                String organisation = _generateTestData.generateValidData("whatWasLost.owner.organisationName");
                keyInLostItemOwnerOrganisationName(organisation);
                break;
            case "Somebody else does":
                String firstName = _generateTestData.generateValidData("whatWasLost.owner.firstName");
                keyInLostItemOwnerFirstName(firstName);
                keyInLostItemOwnerMiddleName(_generateTestData.generateValidData("whatWasLost.owner.middleName"));
                keyInLostItemOwnerLastName(_generateTestData.generateValidData("whatWasLost.owner.lastName"));
                break;
        }
    }

    public void clickOnButtonAddLostItems() {
        waitAndclickElementUsingJS(buttonAddLostItem);
        int lostItemsCommonFieldsIndex = addAndRetrieveLostItemsCommonFieldsIndex();
        _persistentData.setContext("lostItemsCommonFieldsIndex", lostItemsCommonFieldsIndex + 1);
    }


    public void validateLostItemOwnerDropDownValues(String[] expectedList) {
        int lostItemsCommonFieldsIndex = addAndRetrieveLostItemsCommonFieldsIndex();
        List<WebElement> dropDownValues = getAllListValuesInDropDown(dropDownWhoOwnsLostProperty.get(lostItemsCommonFieldsIndex));
        validateDropDownListValues(dropDownValues, expectedList);
    }


    public boolean checkIfLostPropertySectionExists() {
        return isElementListDisplayed(sectionLostProperty);
    }

    public void clickOnContinueFromLostPropertyDetailsPageMobile() {
        waitAndclickElementUsingJS(buttonContinueFromLostPageMobile);
    }

    public int addAndRetrieveLostItemsCommonFieldsIndex() {
        int lostItemsCommonFieldsIndex = 0;
        try {
            lostItemsCommonFieldsIndex = (int) _persistentData.getContext("lostItemsCommonFieldsIndex");
        } catch (Exception e) {
            _persistentData.setContext("lostItemsCommonFieldsIndex", lostItemsCommonFieldsIndex);
        }
        return lostItemsCommonFieldsIndex;
    }

    public int addAndRetrieveLostItemOwnerSomeOneElseIndex() {
        int lostItemsOwnerSomeOneElseIndex = 0;
        try {
            lostItemsOwnerSomeOneElseIndex = (int) _persistentData.getContext("lostItemsOwnerSomeOneElseIndex");
        } catch (Exception e) {
            _persistentData.setContext("lostItemsOwnerSomeOneElseIndex", lostItemsOwnerSomeOneElseIndex);
        }
        return lostItemsOwnerSomeOneElseIndex;
    }

    public int addAndRetrieveLostItemOrganisationOwnerIndex() {
        int lostItemsOrganisationOwnerIndex = 0;
        try {
            lostItemsOrganisationOwnerIndex = (int) _persistentData.getContext("lostItemsOrganisationOwnerIndex");
        } catch (Exception e) {
            _persistentData.setContext("lostItemsOrganisationOwnerIndex", lostItemsOrganisationOwnerIndex);
        }
        return lostItemsOrganisationOwnerIndex;
    }


}
