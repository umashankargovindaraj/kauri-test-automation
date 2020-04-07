package pageObjects.Automation105.EventInfoSections;

import libs.BasePage;
import libs.ExecutionDeviceConfiguration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EventInfoStolen105 extends BasePage {

    private @FindBy(xpath = "//div[@data-test-id='20190529125238064630968']//label[text()='Yes']")
    WebElement toggleVehicleStolenYes = null;
    private @FindBy(xpath = "//div[@data-test-id='20190529125238064630968']//label[text()='No']")
    WebElement toggleVehicleStolenNo = null;
    private @FindBy(xpath = "//select[@data-test-id='2019052815573606417934']")
    List<WebElement> dropDownWhoOwnsStolenVehicle = null;
    private @FindBy(xpath = "//div[@data-test-id='201905291056310808355']//input[@data-test-id='20190528170032047648357']")
    List<WebElement> textBoxStolenVehicleOrganisationName = null;
    private @FindBy(xpath = "//input[@data-test-id='2019052812011802836297']")
    List<WebElement> textStolenVehicleLicensePlate = null;
    private @FindBy(xpath = "//input[@data-test-id='20190528165035096140686']")
    List<WebElement> textBoxStolenVehicleOwnerFirstName = null;
    private @FindBy(xpath = "//input[@data-test-id='20190528165035096241769']")
    List<WebElement> textBoxStolenVehicleOwnerMiddleName = null;
    private @FindBy(xpath = "//input[@data-test-id='20190528165035096242736']")
    List<WebElement> textBoxStolenVehicleOwnerLastName = null;
    private @FindBy(xpath = "//div[@data-test-id='201905291238370005488']//select[@data-test-id='2019052812011802847278']")
    List<WebElement> dropDownWherewasVehicleStolen = null;
    private @FindBy(xpath = "//div[@data-test-id='20190826124913024875']//select[@data-test-id='2019052812011802847278']")
    List<WebElement> dropDownWherewasVehicleStolenMobile = null;
    private @FindBy(xpath = "//div[@data-test-id='201912022305400881965']//select[@data-test-id='201911271545550462296319']")
    List<WebElement> dropDownStolenVehicleType = null;
    private @FindBy(xpath = "//div[@data-test-id='201912022305400881965']//input[@data-test-id='20191128133941070122729']")
    List<WebElement> textAreaVehicleMake = null;
    private @FindBy(xpath = "//table[contains(@pl_prop_class, 'Police-Data-NIA-Reference')]//tr[contains(@oaargs,'Make')]")
    List<WebElement> autoCompleteListVehicleMake = null;
    private @FindBy(xpath = "//button[@data-test-id='2019052912591803879285']")
    WebElement buttonAddStolenVehicle = null;
    private @FindBy(xpath = "//button[@data-test-id='20190530083556032970862']")
    WebElement buttonDeleteStolenVehicle = null;
    private @FindBy(xpath = "//div[@data-test-id='201905291056310808355']//label[text()='Yes']")
    List<WebElement> toggleAgreeTowingCostYes = null;
    private @FindBy(xpath = "//div[@data-test-id='201905291056310808355']//label[text()='No']")
    List<WebElement> toggleAgreeTowingCostNo = null;
    private @FindBy(xpath = "//div[@data-test-id='201912022305400881965']//textarea[@data-test-id='201911271720490196184103']")
    List<WebElement> textAreaIdentifyingFeatures = null;
    private @FindBy(xpath = "//select[@data-test-id='20190513125205099561874']")
    List<WebElement> dropDownWhoOwnsStolenItem = null;
    private @FindBy(xpath = "//div[@data-test-id='201905221626590301705']//input[@data-test-id='2019050711100204154647']")
    List<WebElement> textBoxWhatWasStolen = null;
    private @FindBy(xpath = "//input[@data-test-id='20190528170032047648357' and contains(@name, 'Item')]")
    List<WebElement> textBoxStolenItemOrganisationName = null;
    private @FindBy(xpath = "//input[@data-test-id='2019041209454504561735']")
    List<WebElement> textBoxSerialOrId = null;
    private @FindBy(xpath = "//input[@data-test-id='201905081628560147410699']")
    List<WebElement> textBoxStolenItemOwnerFirstName = null;
    private @FindBy(xpath = "//input[@data-test-id='201905081628560148411401']")
    List<WebElement> textBoxStolenItemOwnerMiddleName = null;
    private @FindBy(xpath = "//input[@data-test-id='201905081628560149412135']")
    List<WebElement> textBoxStolenItemOwnerLastName = null;
    private @FindBy(xpath = "//table[contains(@pl_prop,'D_ItemsList')]//tr[contains(@oaargs, 'Police-SDW-Data-Items')]")
    List<WebElement> whatwasStolenAutoComplete = null;
    private @FindBy(xpath = "//div[@class='autocomplete-results']//li[contains(@class,'ac-item')]")
    List<WebElement> whatwasStolenAutoCompleteMobile = null;
    private @FindBy(xpath = "//input[@data-test-id='20190619153612088912683']")
    List<WebElement> textBoxValueOfItem = null;
    private @FindBy(xpath = "//textarea[@data-test-id='20190619153620048213980']")
    List<WebElement> textBoxPleaseDescribe = null;
    private @FindBy(xpath = "//button[@data-test-id='20190522164128092867750']")
    WebElement buttonAddStolenItem = null;
    private @FindBy(xpath = "//button[@data-test-id='201905131659270025240472']")
    WebElement buttonDeleteStolenItem = null;
    private @FindBy(xpath = "//div[@data-test-id='201905221626590301705']//input[@data-test-id='20190919151250052142317']")
    List<WebElement> checkBoxStolenItemManualEntry = null;

    public void clickOnStolenVehicleToggleNo() {
        waitAndclickElementUsingJS(toggleVehicleStolenNo);
    }

    public void clickOnStolenVehicleToggleYes() {
        waitAndclickElementUsingJS(toggleVehicleStolenYes);
        _persistentData.setContext("stolenVehicleIndicator", "yes");
    }

    public void selectStolenVehicleOwner(String owner) {
        int stolenVehiclesCommonFieldsIndex = addAndRetrieveStolenVehiclesCommonFieldsIndex();
        selectFromDropDownbyValue(dropDownWhoOwnsStolenVehicle.get(stolenVehiclesCommonFieldsIndex), owner);
    }

    public void clickOnStolenItemManualEntry(int index) {
        waitAndclickElementUsingJS(checkBoxStolenItemManualEntry.get(index));
    }

    public void keyInRelevantAnswersForStolenVehicleOwner(String owner, String dataSet) {
        int stolenVehiclesCommonFieldsIndex = addAndRetrieveStolenVehiclesCommonFieldsIndex();
        int stolenVehiclesOwnerSomeOneElseIndex = addAndRetrieveStolenVehicleOwnerSomeOneElseIndex();
        switch (owner) {
            case "An organisation does":
                String organisation = _retrieveTestData.extractDataOffDataFile(dataSet + ".owner.organisationName");
                keyInStolenVehicleOwnerOrganisationName(organisation);
                waitAndClickElement(textStolenVehicleLicensePlate.get(stolenVehiclesCommonFieldsIndex));
                //waitForOwnerNameToLoadInDropDown(dropDownWhoOwnsStolenVehicle.get(stolenVehiclesCommonFieldsIndex), organisation);
                break;
            case "Somebody else does":
                String firstName = _retrieveTestData.extractDataOffDataFile(dataSet + ".owner.firstName");
                keyInStolenVehicleOwnerFirstName(firstName);
                waitAndClickElement(textBoxStolenVehicleOwnerMiddleName.get(stolenVehiclesOwnerSomeOneElseIndex));
                //waitForOwnerNameToLoadInDropDown(dropDownWhoOwnsStolenVehicle.get(stolenVehiclesCommonFieldsIndex), firstName);
                keyInStolenVehicleOwnerMiddleName(_retrieveTestData.extractDataOffDataFile(dataSet + ".owner.middleName"));
                keyInStolenVehicleOwnerLastName(_retrieveTestData.extractDataOffDataFile(dataSet + ".owner.lastName"));
                waitAndClickElement(textBoxStolenVehicleOwnerMiddleName.get(stolenVehiclesOwnerSomeOneElseIndex));
                waitForOwnerLastNameToTurnCaps(textBoxStolenVehicleOwnerLastName.get(stolenVehiclesOwnerSomeOneElseIndex));
                break;
        }
    }

    private void keyInStolenVehicleOwnerLastName(String lastName) {
        int stolenVehiclesOwnerSomeOneElseIndex = addAndRetrieveStolenVehicleOwnerSomeOneElseIndex();
        sendKeysToWebElement(textBoxStolenVehicleOwnerLastName.get(stolenVehiclesOwnerSomeOneElseIndex), lastName);
        _persistentData.setContext("stolenVehiclesOwnerSomeOneElseIndex", stolenVehiclesOwnerSomeOneElseIndex + 1);
    }

    private void keyInStolenVehicleOwnerMiddleName(String middleName) {
        int stolenVehiclesOwnerSomeOneElseIndex = addAndRetrieveStolenVehicleOwnerSomeOneElseIndex();
        sendKeysToWebElement(textBoxStolenVehicleOwnerMiddleName.get(stolenVehiclesOwnerSomeOneElseIndex), middleName);
    }

    private void keyInStolenVehicleOwnerFirstName(String firstName) {
        int stolenVehiclesOwnerSomeOneElseIndex = addAndRetrieveStolenVehicleOwnerSomeOneElseIndex();
        sendKeysToWebElement(textBoxStolenVehicleOwnerFirstName.get(stolenVehiclesOwnerSomeOneElseIndex), firstName);
    }

    public void keyInStolenVehicleOwnerOrganisationName(String organisationName) {
        int stolenVehiclesOrganisationOwnerIndex = addAndRetrieveStolenVehicleOrganisationOwnerIndex();
        sendKeysToWebElement(textBoxStolenVehicleOrganisationName.get(stolenVehiclesOrganisationOwnerIndex), organisationName);
        _persistentData.setContext("stolenVehiclesOrganisationOwnerIndex", stolenVehiclesOrganisationOwnerIndex + 1);
    }

    public void keyInStolenVehicleLicensePlate(String dataSet) {
        int stolenVehiclesCommonFieldsIndex = addAndRetrieveStolenVehiclesCommonFieldsIndex();
        sendKeysToWebElement(textStolenVehicleLicensePlate.get(stolenVehiclesCommonFieldsIndex), _retrieveTestData.extractDataOffDataFile(dataSet + ".licencePlate"));
    }

    public void selectStolenVehicleType(String dataSet) {
        int stolenVehiclesCommonFieldsIndex = addAndRetrieveStolenVehiclesCommonFieldsIndex();
        selectFromDropDownbyValue(dropDownStolenVehicleType.get(stolenVehiclesCommonFieldsIndex), _retrieveTestData.extractDataOffDataFile(dataSet + ".vehicleType"));
    }

    public void selectStolenVehicleMake(String dataSet) {
        int stolenVehiclesCommonFieldsIndex = addAndRetrieveStolenVehiclesCommonFieldsIndex();
        selectLookupValue(textAreaVehicleMake.get(stolenVehiclesCommonFieldsIndex), autoCompleteListVehicleMake, _retrieveTestData.extractDataOffDataFile(dataSet + ".vehicleMake"), false);
    }

    public void selectWhereWasTheVehicleStolenFrom(String dataSet) {

        int stolenVehiclesCommonFieldsIndex = addAndRetrieveStolenVehiclesCommonFieldsIndex();
        if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
            selectFromDropDownbyValue(dropDownWherewasVehicleStolenMobile.get(stolenVehiclesCommonFieldsIndex), _retrieveTestData.extractDataOffDataFile(dataSet + ".stolenLocation"));
        } else {
            selectFromDropDownbyValue(dropDownWherewasVehicleStolen.get(stolenVehiclesCommonFieldsIndex), _retrieveTestData.extractDataOffDataFile(dataSet + ".stolenLocation"));
        }
    }

    public List<WebElement> indicateAddAdditionalStolenVehicle() {
        waitAndclickElementUsingJS(buttonAddStolenVehicle);
        isElementDisplayed(buttonDeleteStolenVehicle);
        int stolenVehiclesCommonFieldsIndex = addAndRetrieveStolenVehiclesCommonFieldsIndex();
        _persistentData.setContext("stolenVehiclesCommonFieldsIndex", stolenVehiclesCommonFieldsIndex + 1);
        return textStolenVehicleLicensePlate;
    }

    public void setToggleAgreeTowingCostYes() {
        int stolenVehiclesCommonFieldsIndex = addAndRetrieveStolenVehiclesCommonFieldsIndex();
        waitAndclickElementUsingJS(toggleAgreeTowingCostYes.get(stolenVehiclesCommonFieldsIndex));
    }

    public void setToggleAgreeTowingCostNo() {
        int stolenVehiclesCommonFieldsIndex = addAndRetrieveStolenVehiclesCommonFieldsIndex();
        waitAndclickElementUsingJS(toggleAgreeTowingCostNo.get(stolenVehiclesCommonFieldsIndex));
    }

    public void keyInIdentifyingFeatures(String dataSet) {
        int damagedVehiclesCommonFieldsIndex = addAndRetrieveStolenVehiclesCommonFieldsIndex();
        sendKeysToWebElement(textAreaIdentifyingFeatures.get(damagedVehiclesCommonFieldsIndex), _retrieveTestData.extractDataOffDataFile(dataSet + ".identifyingFeatures"));
    }

    public void selectStolenItemOwnerFromDropDown(String owner) {
        int stolenItemsCommonFieldsIndex = addAndRetrieveStolenItemsCommonFieldsIndex();
        selectFromDropDownbyValue(dropDownWhoOwnsStolenItem.get(stolenItemsCommonFieldsIndex), owner);
        waitAndClickElement(textBoxWhatWasStolen.get(stolenItemsCommonFieldsIndex));
    }

    public void keyInRelevantAnswersForStolenItemOwner(String owner, String dataSet) {
        int stolenItemsCommonFieldsIndex = addAndRetrieveStolenItemsCommonFieldsIndex();
        int stolenItemsOwnerSomeOneElseIndex = addAndRetrieveStolenItemOwnerSomeOneElseIndex();
        switch (owner) {
            case "An organisation does":
                String organisation = _retrieveTestData.extractDataOffDataFile(dataSet + ".owner.organisationName");
                keyInStolenItemOwnerOrganisationName(organisation);
                waitAndClickElement(textBoxSerialOrId.get(stolenItemsCommonFieldsIndex));
                //waitForOwnerNameToLoadInDropDown(dropDownWhoOwnsStolenItem.get(stolenItemsCommonFieldsIndex), organisation);
                break;
            case "Somebody else does":
                String firstName = _retrieveTestData.extractDataOffDataFile(dataSet + ".owner.firstName");
                keyInStolenItemOwnerFirstName(firstName);
                waitAndClickElement(textBoxStolenItemOwnerMiddleName.get(stolenItemsOwnerSomeOneElseIndex));
                //waitForOwnerNameToLoadInDropDown(dropDownWhoOwnsStolenItem.get(stolenItemsCommonFieldsIndex), firstName);
                keyInStolenItemOwnerMiddleName(_retrieveTestData.extractDataOffDataFile(dataSet + ".owner.middleName"));
                keyInStolenItemOwnerLastName(_retrieveTestData.extractDataOffDataFile(dataSet + ".owner.lastName"));
                break;
        }
    }

    private void keyInStolenItemOwnerOrganisationName(String organisationName) {
        int stolenItemsOrganisationOwnerIndex = addAndRetrieveStolenItemOrganisationOwnerIndex();
        sendKeysToWebElement(textBoxStolenItemOrganisationName.get(stolenItemsOrganisationOwnerIndex), organisationName);
        _persistentData.setContext("stolenItemsOrganisationOwnerIndex", stolenItemsOrganisationOwnerIndex + 1);
    }

    private void keyInStolenItemOwnerFirstName(String firstName) {
        int stolenItemsOwnerSomeOneElseIndex = addAndRetrieveStolenItemOwnerSomeOneElseIndex();
        sendKeysToWebElement(textBoxStolenItemOwnerFirstName.get(stolenItemsOwnerSomeOneElseIndex), firstName);
    }

    private void keyInStolenItemOwnerMiddleName(String middleName) {
        int stolenItemsOwnerSomeOneElseIndex = addAndRetrieveStolenItemOwnerSomeOneElseIndex();
        sendKeysToWebElement(textBoxStolenItemOwnerMiddleName.get(stolenItemsOwnerSomeOneElseIndex), middleName);
    }

    public void keyInStolenItemOwnerLastName(String lastName) {
        int stolenItemsOwnerSomeOneElseIndex = addAndRetrieveStolenItemOwnerSomeOneElseIndex();
        sendKeysToWebElement(textBoxStolenItemOwnerLastName.get(stolenItemsOwnerSomeOneElseIndex), lastName);
        waitAndClickElement(textBoxStolenItemOwnerMiddleName.get(stolenItemsOwnerSomeOneElseIndex));
        waitForOwnerLastNameToTurnCaps(textBoxStolenItemOwnerLastName.get(stolenItemsOwnerSomeOneElseIndex));
        _persistentData.setContext("stolenItemsOwnerSomeOneElseIndex", stolenItemsOwnerSomeOneElseIndex + 1);
    }

    public void keyInDataOnWhatWasStolen(String dataSet) {
        executionDeviceConfiguration = new ExecutionDeviceConfiguration(getDeviceKey());
        String deviceType = executionDeviceConfiguration.getDeviceParameters("DEVICE");
        if (deviceType.toLowerCase().contains("tab") || deviceType.equalsIgnoreCase("Google Nexus 9") || deviceType.toLowerCase().contains("ipad")) {
            whatwasStolenAutoCompleteMobile = whatwasStolenAutoComplete;
        }
        int stolenItemsCommonFieldsIndex = addAndRetrieveStolenItemsCommonFieldsIndex();
        if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
            selectLookupValue(textBoxWhatWasStolen.get(stolenItemsCommonFieldsIndex), whatwasStolenAutoCompleteMobile, _retrieveTestData.extractDataOffDataFile(dataSet + ".stolenItem"), false);
        } else {
            if (_retrieveTestData.extractDataOffDataFile(dataSet + ".stolenItem").equalsIgnoreCase("not found")) {
                clickOnStolenItemManualEntry(stolenItemsCommonFieldsIndex);
                sendKeysToWebElement(textBoxWhatWasStolen.get(stolenItemsCommonFieldsIndex), _retrieveTestData.extractDataOffDataFile(dataSet + ".stolenItemManual"));
            } else {
                selectLookupValue(textBoxWhatWasStolen.get(stolenItemsCommonFieldsIndex), whatwasStolenAutoComplete, _retrieveTestData.extractDataOffDataFile(dataSet + ".stolenItem"), false);
            }
        }
    }

    public void keyInSerialNumberOfStolenItem(String dataSet) {
        int stolenItemsCommonFieldsIndex = addAndRetrieveStolenItemsCommonFieldsIndex();
        sendKeysToWebElement(textBoxSerialOrId.get(stolenItemsCommonFieldsIndex), _retrieveTestData.extractDataOffDataFile(dataSet + ".itemID"));
    }

    public void keyInValueOfStolenItem(String dataSet) {
        int stolenItemsCommonFieldsIndex = addAndRetrieveStolenItemsCommonFieldsIndex();
        sendKeysToWebElement(textBoxValueOfItem.get(stolenItemsCommonFieldsIndex), _retrieveTestData.extractDataOffDataFile(dataSet + ".itemValue"));
    }

    public void keyInDescribeOfStolenItem(String dataSet) {
        int stolenItemsCommonFieldsIndex = addAndRetrieveStolenItemsCommonFieldsIndex();
        sendKeysToWebElement(textBoxPleaseDescribe.get(stolenItemsCommonFieldsIndex), _retrieveTestData.extractDataOffDataFile(dataSet + ".description"));
    }

    public List<WebElement> indicateAddAdditionalStolenItems() {
        waitAndclickElementUsingJS(buttonAddStolenItem);
        isElementDisplayed(buttonDeleteStolenItem);
        int stolenItemsCommonFieldsIndex = addAndRetrieveStolenItemsCommonFieldsIndex();
        _persistentData.setContext("stolenItemsCommonFieldsIndex", stolenItemsCommonFieldsIndex + 1);
        return textBoxWhatWasStolen;
    }

    private int addAndRetrieveStolenItemOrganisationOwnerIndex() {
        int stolenItemsOrganisationOwnerIndex = 0;
        try {
            stolenItemsOrganisationOwnerIndex = (int) _persistentData.getContext("stolenItemsOrganisationOwnerIndex");
        } catch (Exception e) {
            _persistentData.setContext("stolenItemsOrganisationOwnerIndex", stolenItemsOrganisationOwnerIndex);
        }
        return stolenItemsOrganisationOwnerIndex;
    }

    private int addAndRetrieveStolenItemOwnerSomeOneElseIndex() {
        int stolenItemsOwnerSomeOneElseIndex = 0;
        try {
            stolenItemsOwnerSomeOneElseIndex = (int) _persistentData.getContext("stolenItemsOwnerSomeOneElseIndex");
        } catch (Exception e) {
            _persistentData.setContext("stolenItemsOwnerSomeOneElseIndex", stolenItemsOwnerSomeOneElseIndex);
        }
        return stolenItemsOwnerSomeOneElseIndex;
    }

    private int addAndRetrieveStolenItemsCommonFieldsIndex() {
        int stolenItemsCommonFieldsIndex = 0;
        try {
            stolenItemsCommonFieldsIndex = (int) _persistentData.getContext("stolenItemsCommonFieldsIndex");
        } catch (Exception e) {
            _persistentData.setContext("stolenItemsCommonFieldsIndex", stolenItemsCommonFieldsIndex);
        }
        return stolenItemsCommonFieldsIndex;
    }

    private int addAndRetrieveStolenVehicleOrganisationOwnerIndex() {
        int stolenVehiclesOrganisationOwnerIndex = 0;
        try {
            stolenVehiclesOrganisationOwnerIndex = (int) _persistentData.getContext("stolenVehiclesOrganisationOwnerIndex");
        } catch (Exception e) {
            _persistentData.setContext("stolenVehiclesOrganisationOwnerIndex", stolenVehiclesOrganisationOwnerIndex);
        }
        return stolenVehiclesOrganisationOwnerIndex;
    }

    private int addAndRetrieveStolenVehicleOwnerSomeOneElseIndex() {
        int stolenVehiclesOwnerSomeOneElseIndex = 0;
        try {
            stolenVehiclesOwnerSomeOneElseIndex = (int) _persistentData.getContext("stolenVehiclesOwnerSomeOneElseIndex");
        } catch (Exception e) {
            _persistentData.setContext("stolenVehiclesOwnerSomeOneElseIndex", stolenVehiclesOwnerSomeOneElseIndex);
        }
        return stolenVehiclesOwnerSomeOneElseIndex;
    }

    private int addAndRetrieveStolenVehiclesCommonFieldsIndex() {
        int stolenVehiclesCommonFieldsIndex = 0;
        try {
            stolenVehiclesCommonFieldsIndex = (int) _persistentData.getContext("stolenVehiclesCommonFieldsIndex");
        } catch (Exception e) {
            _persistentData.setContext("stolenVehiclesCommonFieldsIndex", stolenVehiclesCommonFieldsIndex);
        }
        return stolenVehiclesCommonFieldsIndex;
    }
}
