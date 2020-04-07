package pageObjects.Automation105.EventInfoSections;

import io.cucumber.datatable.DataTable;
import libs.BasePage;
import libs.ExecutionDeviceConfiguration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventInfoLost105 extends BasePage {

    private @FindBy(xpath = "//select[@data-test-id='20190513125205099561874']")
    List<WebElement> dropDownWhoOwnsLostProperty = null;
    private @FindBy(xpath = "//input[@data-test-id='20190528170032047648357']")
    List<WebElement> textBoxLostPropertyOwnerOrganisationName = null;
    private @FindBy(xpath = "//textarea[@data-test-id='20190619153620048213980']")
    List<WebElement> textBoxDescribeLostProperty = null;
    private String xpathDescribeLostProperty = "(//textarea[@data-test-id='20190619153620048213980'])[$index$]";
    private @FindBy(xpath = "//input[@data-test-id='201905081628560147410699']")
    List<WebElement> textBoxLostPropertyOwnerFirstName = null;
    private @FindBy(xpath = "//input[@data-test-id='201905081628560148411401']")
    List<WebElement> textBoxLostPropertyOwnerMiddleName = null;
    private @FindBy(xpath = "//input[@data-test-id='201905081628560149412135']")
    List<WebElement> textBoxLostPropertyOwnerLastName = null;
    private @FindBy(xpath = "//div[@class='autocomplete-results']//li[contains(@class,'ac-item')]")
    List<WebElement> whatwasLostAutoCompleteMobile = null;
    private @FindBy(xpath = "//table[contains(@pl_prop,'D_ItemsList')]//tr[contains(@oaargs, 'Police-SDW-Data-Items')]")
    List<WebElement> whatwasLostAutoComplete = null;
    private @FindBy(xpath = "//div[@data-test-id='201905221626590301705']//input[@data-test-id='2019050711100204154647']")
    List<WebElement> textBoxWhatWasLost = null;
    private @FindBy(xpath = "//input[@data-test-id='2019050711100204154647']")
    List<WebElement> textBoxWhatWasLostMobile = null;
    private @FindBy(xpath = "//input[@data-test-id='2019041209454504561735']")
    List<WebElement> textBoxItemID = null;
    private @FindBy(xpath = "//input[@data-test-id='20190619153612088912683']")
    List<WebElement> textBoxValueOfLostItem = null;
    private @FindBy(xpath = "//button[@data-test-id='20190522164128092867750']")
    WebElement buttonAddLostItem = null;
    private @FindBy(xpath = "//div[@data-test-id='201905221626590301705']//input[@data-test-id='20190919151250052142317']")
    List<WebElement> checkBoxLostItemManualEntry = null;

    public void selectLostItemOwnerFromDropDown(String owner) {
        int lostItemsCommonFieldsIndex = addAndRetrieveLostItemsCommonFieldsIndex();
        selectFromDropDownbyValue(dropDownWhoOwnsLostProperty.get(lostItemsCommonFieldsIndex), owner);
    }

    public void keyInLostOwnerDetails(String owner) {
        int lostItemsCommonFieldsIndex = addAndRetrieveLostItemsCommonFieldsIndex();
        int lostItemsOwnerSomeOneElseIndex = addAndRetrieveLostItemOwnerSomeOneElseIndex();
        switch (owner) {
            case "An organisation does":
                String organisation = _retrieveTestData.extractDataOffDataFile("whatWasLost.owner.organisationName");
                keyInLostItemOwnerOrganisationName(organisation);
                waitAndClickElement(textBoxDescribeLostProperty.get(lostItemsCommonFieldsIndex));
                waitForOwnerNameToLoadInDropDown(dropDownWhoOwnsLostProperty.get(lostItemsCommonFieldsIndex), organisation);
                break;
            case "Somebody else does":
                String firstName = _retrieveTestData.extractDataOffDataFile("whatWasLost.owner.firstName");
                keyInLostItemOwnerFirstName(firstName);
                waitAndClickElement(textBoxLostPropertyOwnerMiddleName.get(lostItemsOwnerSomeOneElseIndex));
                waitForOwnerNameToLoadInDropDown(dropDownWhoOwnsLostProperty.get(lostItemsCommonFieldsIndex), firstName);
                keyInLostItemOwnerMiddleName(_retrieveTestData.extractDataOffDataFile("whatWasLost.owner.middleName"));
                keyInLostItemOwnerLastName(_retrieveTestData.extractDataOffDataFile("whatWasLost.owner.lastName"));
                waitAndClickElement(textBoxLostPropertyOwnerMiddleName.get(lostItemsOwnerSomeOneElseIndex));
                waitForOwnerLastNameToTurnCaps(textBoxLostPropertyOwnerLastName.get(lostItemsOwnerSomeOneElseIndex));
                break;
        }
    }

    public void keyInLostOwnerDetails(String owner, String lostItemRootObjectXpath) {
        int lostItemsCommonFieldsIndex = addAndRetrieveLostItemsCommonFieldsIndex();
        int lostItemsOwnerSomeOneElseIndex = addAndRetrieveLostItemOwnerSomeOneElseIndex();
        switch (owner) {
            case "An organisation does":
                String organisation = _retrieveTestData.extractDataOffDataFile(lostItemRootObjectXpath + ".owner.organisationName");
                keyInLostItemOwnerOrganisationName(organisation);
                waitAndClickElement(textBoxDescribeLostProperty.get(lostItemsCommonFieldsIndex));
                //waitForOwnerNameToLoadInDropDown(dropDownWhoOwnsLostProperty.get(lostItemsCommonFieldsIndex), organisation);
                break;
            case "Somebody else does":
                String firstName = _retrieveTestData.extractDataOffDataFile(lostItemRootObjectXpath + ".owner.firstName");
                keyInLostItemOwnerFirstName(firstName);
                waitAndClickElement(textBoxLostPropertyOwnerMiddleName.get(lostItemsOwnerSomeOneElseIndex));
                //waitForOwnerNameToLoadInDropDown(dropDownWhoOwnsLostProperty.get(lostItemsCommonFieldsIndex), firstName);
                keyInLostItemOwnerMiddleName(_retrieveTestData.extractDataOffDataFile(lostItemRootObjectXpath + ".owner.middleName"));
                keyInLostItemOwnerLastName(_retrieveTestData.extractDataOffDataFile(lostItemRootObjectXpath + ".owner.lastName"));
                waitAndClickElement(textBoxLostPropertyOwnerMiddleName.get(lostItemsOwnerSomeOneElseIndex));
                //waitForOwnerLastNameToTurnCaps(textBoxLostPropertyOwnerLastName.get(lostItemsOwnerSomeOneElseIndex));
                break;
        }
    }

    private int addAndRetrieveLostItemsCommonFieldsIndex() {
        int lostItemsCommonFieldsIndex = 0;
        try {
            lostItemsCommonFieldsIndex = (int) _persistentData.getContext("lostItemsCommonFieldsIndex");
        } catch (Exception e) {
            _persistentData.setContext("lostItemsCommonFieldsIndex", lostItemsCommonFieldsIndex);
        }
        return lostItemsCommonFieldsIndex;
    }

    private int addAndRetrieveLostItemOwnerSomeOneElseIndex() {
        int lostItemsOwnerSomeOneElseIndex = 0;
        try {
            lostItemsOwnerSomeOneElseIndex = (int) _persistentData.getContext("lostItemsOwnerSomeOneElseIndex");
        } catch (Exception e) {
            _persistentData.setContext("lostItemsOwnerSomeOneElseIndex", lostItemsOwnerSomeOneElseIndex);
        }
        return lostItemsOwnerSomeOneElseIndex;
    }

    private void keyInLostItemOwnerOrganisationName(String organisationName) {
        int lostItemsOrganisationOwnerIndex = addAndRetrieveLostItemOrganisationOwnerIndex();
        sendKeysToWebElement(textBoxLostPropertyOwnerOrganisationName.get(lostItemsOrganisationOwnerIndex), organisationName);
        _persistentData.setContext("lostItemsOrganisationOwnerIndex", lostItemsOrganisationOwnerIndex + 1);
    }

    private int addAndRetrieveLostItemOrganisationOwnerIndex() {
        int lostItemsOrganisationOwnerIndex = 0;
        try {
            lostItemsOrganisationOwnerIndex = (int) _persistentData.getContext("lostItemsOrganisationOwnerIndex");
        } catch (Exception e) {
            _persistentData.setContext("lostItemsOrganisationOwnerIndex", lostItemsOrganisationOwnerIndex);
        }
        return lostItemsOrganisationOwnerIndex;
    }

    private void keyInLostItemOwnerFirstName(String firstName) {
        int lostItemsOwnerSomeOneElseIndex = addAndRetrieveLostItemOwnerSomeOneElseIndex();
        sendKeysToWebElement(textBoxLostPropertyOwnerFirstName.get(lostItemsOwnerSomeOneElseIndex), firstName);
    }

    private void keyInLostItemOwnerMiddleName(String middleName) {
        int lostItemsOwnerSomeOneElseIndex = addAndRetrieveLostItemOwnerSomeOneElseIndex();
        sendKeysToWebElement(textBoxLostPropertyOwnerMiddleName.get(lostItemsOwnerSomeOneElseIndex), middleName);
    }

    private void keyInLostItemOwnerLastName(String lastName) {
        int lostItemsOwnerSomeOneElseIndex = addAndRetrieveLostItemOwnerSomeOneElseIndex();
        sendKeysToWebElement(textBoxLostPropertyOwnerLastName.get(lostItemsOwnerSomeOneElseIndex), lastName);
        _persistentData.setContext("lostItemsOwnerSomeOneElseIndex", lostItemsOwnerSomeOneElseIndex + 1);
    }

    private void clickOnLostItemManualEntryCheckBox(int index) {
        waitAndclickElementUsingJS(checkBoxLostItemManualEntry.get(index));
    }

    public void keyInWhatWasLost() {
        executionDeviceConfiguration = new ExecutionDeviceConfiguration(getDeviceKey());
        String deviceType = executionDeviceConfiguration.getDeviceParameters("DEVICE");
        if (deviceType.toLowerCase().contains("tab") || deviceType.equalsIgnoreCase("Google Nexus 9") || deviceType.toLowerCase().contains("ipad")) {
            whatwasLostAutoCompleteMobile = whatwasLostAutoComplete;
        }
        int lostItemsCommonFieldsIndex = addAndRetrieveLostItemsCommonFieldsIndex();
        if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
            selectLookupValue(textBoxWhatWasLost.get(lostItemsCommonFieldsIndex), whatwasLostAutoCompleteMobile, _retrieveTestData.extractDataOffDataFile("lostItem.whatWasLost"), false);
        } else {
            if (_retrieveTestData.extractDataOffDataFile("lostItem.whatWasLost").equalsIgnoreCase("not found")) {
                clickOnLostItemManualEntryCheckBox(lostItemsCommonFieldsIndex);
                sendKeysToWebElement(textBoxWhatWasLost.get(lostItemsCommonFieldsIndex), _retrieveTestData.extractDataOffDataFile("lostItem.lostItemManual"));
            } else {
                selectLookupValue(textBoxWhatWasLost.get(lostItemsCommonFieldsIndex), whatwasLostAutoComplete, _retrieveTestData.extractDataOffDataFile("lostItem.whatWasLost"), false);
            }
        }
    }

    public void keyInWhatWasLost(String lostItemRootObjectXpath) {
        int lostItemsCommonFieldsIndex = addAndRetrieveLostItemsCommonFieldsIndex();
        selectLookupValue(textBoxWhatWasLost.get(lostItemsCommonFieldsIndex), whatwasLostAutoComplete, _retrieveTestData.extractDataOffDataFile(lostItemRootObjectXpath + ".whatWasLost"), false);
    }

    public void keyInWhatWasLostMobile(String lostItemRootObjectXpath) {
        int lostItemsCommonFieldsIndex = addAndRetrieveLostItemsCommonFieldsIndex();
        JavascriptExecutor js = (JavascriptExecutor) _driver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "down");
        WebElement element = textBoxWhatWasLostMobile.get(lostItemsCommonFieldsIndex);
        scrollObject.put("element", ((RemoteWebElement) element).getId());
        js.executeScript("mobile: scroll", scrollObject);
        selectLookupValue(textBoxWhatWasLostMobile.get(lostItemsCommonFieldsIndex), whatwasLostAutoCompleteMobile, _retrieveTestData.extractDataOffDataFile(lostItemRootObjectXpath + ".whatWasLost"), false);
    }

    public void keyInLostItemID() {
        int lostItemsCommonFieldsIndex = addAndRetrieveLostItemsCommonFieldsIndex();
        sendKeysToWebElement(textBoxItemID.get(lostItemsCommonFieldsIndex), _retrieveTestData.extractDataOffDataFile("lostItem.ID"));
    }

    public void keyInLostItemID(String lostItemRootObjectXpath) {
        int lostItemsCommonFieldsIndex = addAndRetrieveLostItemsCommonFieldsIndex();
        sendKeysToWebElement(textBoxItemID.get(lostItemsCommonFieldsIndex), _retrieveTestData.extractDataOffDataFile(lostItemRootObjectXpath + ".ID"));
    }

    public void keyInLostItemValue() {
        int lostItemsCommonFieldsIndex = addAndRetrieveLostItemsCommonFieldsIndex();
        sendKeysToWebElement(textBoxValueOfLostItem.get(lostItemsCommonFieldsIndex), _retrieveTestData.extractDataOffDataFile("lostItem.valueOfItem"));
    }

    public void keyInLostItemValue(String lostItemRootObjectXpath) {
        int lostItemsCommonFieldsIndex = addAndRetrieveLostItemsCommonFieldsIndex();
        sendKeysToWebElement(textBoxValueOfLostItem.get(lostItemsCommonFieldsIndex), _retrieveTestData.extractDataOffDataFile(lostItemRootObjectXpath + ".valueOfItem"));
    }

    public void keyInDescriptionOfItemLost() {
        int lostItemsCommonFieldsIndex = addAndRetrieveLostItemsCommonFieldsIndex();
        sendKeysToWebElement(textBoxDescribeLostProperty.get(lostItemsCommonFieldsIndex), _retrieveTestData.extractDataOffDataFile("lostItem.describeLostItem"));
    }

    public void keyInDescriptionOfItemLost(String lostItemRootObjectXpath) {
        int lostItemsCommonFieldsIndex = addAndRetrieveLostItemsCommonFieldsIndex();
        sendKeysToWebElement(textBoxDescribeLostProperty.get(lostItemsCommonFieldsIndex), _retrieveTestData.extractDataOffDataFile(lostItemRootObjectXpath + ".describeLostItem"));
    }

    public void keyInDescriptionOfItemLostWithJavaScript() {
        int lostItemsCommonFieldsIndex = addAndRetrieveLostItemsCommonFieldsIndex();
        String xpath = xpathDescribeLostProperty.replace("$index$", Integer.toString(lostItemsCommonFieldsIndex + 1));
        updateFieldValueUsingJavaScript(xpath, _retrieveTestData.extractDataOffDataFile("lostItem.describeLostItem"));
    }

    public void clickOnButtonAddLostItems() {
        waitAndclickElementUsingJS(buttonAddLostItem);
        int lostItemsCommonFieldsIndex = addAndRetrieveLostItemsCommonFieldsIndex();
        _persistentData.setContext("lostItemsCommonFieldsIndex", lostItemsCommonFieldsIndex + 1);
    }

    private void keyInLostItemOwner() {
        selectLostItemOwnerFromDropDown(_retrieveTestData.extractDataOffDataFile("lostItem.whoOwnsIt"));
    }

    public void keyInLostItemSection() {
        clickOnButtonAddLostItems();
        keyInLostItemOwner();
        keyInWhatWasLost();
        keyInLostItemID();
        keyInLostItemValue();
        keyInDescriptionOfItemLostWithJavaScript();
    }

    public List<Map<String, String>> getCucumberDataAsList(DataTable dataTable) {
        return getCucumberDataTableAsList(dataTable);
    }

}
