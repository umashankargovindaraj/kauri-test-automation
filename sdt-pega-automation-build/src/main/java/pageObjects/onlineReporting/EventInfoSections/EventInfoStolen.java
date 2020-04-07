package pageObjects.onlineReporting.EventInfoSections;

import libs.ExecutionDeviceConfiguration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class EventInfoStolen extends EventInfo {

    private @FindBy(xpath = "//div[@data-test-id='201905291238370005488']")
    List<WebElement> sectionStolenVehicles = null;
    private @FindBy(xpath = "//div[@data-test-id='201905221626590301705']")
    List<WebElement> sectionWhatWasStolen = null;

    private @FindBy(xpath = "//div[@data-test-id='20190529125238064630968']//label[text()='Yes']")
    WebElement toggleVehicleStolenYes = null;
    private @FindBy(xpath = "//div[@data-test-id='20190529125238064630968']//label[text()='No']")
    WebElement toggleVehicleStolenNo = null;
    private @FindBy(xpath = "//label[@data-test-id='2019052812011802836297-Label']")
    List<WebElement> labelLicensePlate = null;
    private @FindBy(xpath = "//input[@data-test-id='2019052812011802836297']")
    List<WebElement> textStolenVehicleLicensePlate = null;
    private @FindBy(xpath = "//label[@data-test-id='2019052812011802847278-Label']")
    List<WebElement> labelWherewasVehicleStolen = null;
    private @FindBy(xpath = "//div[@data-test-id='201905291238370005488']//select[@data-test-id='2019052812011802847278']")
    List<WebElement> dropDownWherewasVehicleStolen = null;
    private @FindBy(xpath = "//div[@data-test-id='20190826124913024875']//select[@data-test-id='2019052812011802847278']")
    List<WebElement> dropDownWherewasVehicleStolenMobile = null;
    private @FindBy(xpath = "//label[@data-test-id='2019052815573606417934-Label']")
    List<WebElement> labelWhoOwnsStolenVehicle = null;
    private @FindBy(xpath = "//select[@data-test-id='2019052815573606417934']")
    List<WebElement> dropDownWhoOwnsStolenVehicle = null;

    private @FindBy(xpath = "//label[@data-test-id='20190528165035096140686-Label']")
    List<WebElement> labelStolenVehicleOwnerFirstName = null;
    private @FindBy(xpath = "//input[@data-test-id='20190528165035096140686']")
    List<WebElement> textBoxStolenVehicleOwnerFirstName = null;
    private @FindBy(xpath = "//label[@data-test-id='20190528165035096241769-Label']")
    List<WebElement> labelStolenVehicleOwnerMiddleName = null;
    private @FindBy(xpath = "//input[@data-test-id='20190528165035096241769']")
    List<WebElement> textBoxStolenVehicleOwnerMiddleName = null;
    private @FindBy(xpath = "//label[@data-test-id='20190528165035096242736-Label']")
    List<WebElement> labelStolenVehicleOwnerLastName = null;
    private @FindBy(xpath = "//input[@data-test-id='20190528165035096242736']")
    List<WebElement> textBoxStolenVehicleOwnerLastName = null;
    private @FindBy(xpath = "//label[@data-test-id='20190528170032047648357-Label']")
    List<WebElement> labelStolenVehicleOrganisationName = null;
    private @FindBy(xpath = "//div[@data-test-id='201905291056310808355']//input[@data-test-id='20190528170032047648357']")
    List<WebElement> textBoxStolenVehicleOrganisationName = null;
    private @FindBy(xpath = "//button[@data-test-id='2019052912591803879285']")
    WebElement buttonAddStolenVehicle = null;
    private @FindBy(xpath = "//button[@data-test-id='20190530083556032970862']")
    WebElement buttonDeleteStolenVehicle = null;


    private @FindBy(xpath = "//div[contains(@data-test-id,'201905221637410260564-')]")
    List<WebElement> sectionStolenItem = null;
    private @FindBy(xpath = "//label[@data-test-id='2019050711100204154647-Label']")
    List<WebElement> labelWhatWasStolen = null;
    private @FindBy(xpath = "//input[@data-test-id='2019050711100204154647' and @placeholder='Start typing Item to search']")
    List<WebElement> textBoxWhatWasStolen = null;
    private @FindBy(xpath = "//table[contains(@pl_prop,'D_ItemsList')]//tr[contains(@oaargs, 'Police-SDW-Data-Items')]")
    List<WebElement> whatwasStolenAutoComplete = null;
    private @FindBy(xpath = "//div[@class='autocomplete-results']//li[contains(@class,'ac-item')]")
    List<WebElement> whatwasStolenAutoCompleteMobile = null;
    private @FindBy(xpath = "//table[@pl_prop_class='Police-SDW-Data-Items']//tr")
    List<WebElement> itemAutoCompleteList = null;
    private @FindBy(xpath = "//label[@data-test-id='20190513125205099561874-Label']")
    List<WebElement> labelWhoOwnsStoleItem = null;
    private @FindBy(xpath = "//select[@data-test-id='20190513125205099561874']")
    List<WebElement> dropDownWhoOwnsStolenItem = null;
    private @FindBy(xpath = "//label[@data-test-id='2019041209454504561735-Label']")
    List<WebElement> labelSerialOrId = null;
    private @FindBy(xpath = "//input[@data-test-id='2019041209454504561735']")
    List<WebElement> textBoxSerialOrId = null;
    private @FindBy(xpath = "//label[@data-test-id='20190619153612088912683-Label']")
    List<WebElement> labelValueOfItem = null;
    private @FindBy(xpath = "//input[@data-test-id='20190619153612088912683']")
    List<WebElement> textBoxValueOfItem = null;
    private @FindBy(xpath = "//label[@data-test-id='20190619153620048213980-Label']")
    List<WebElement> labelPleaseDescribe = null;
    private @FindBy(xpath = "//textarea[@data-test-id='20190619153620048213980']")
    List<WebElement> textBoxPleaseDescribe = null;

    private @FindBy(xpath = "//label[@data-test-id='201905081628560147410699-Label']")
    List<WebElement> labelStolenItemOwnerFirstName = null;
    private @FindBy(xpath = "//input[@data-test-id='201905081628560147410699']")
    List<WebElement> textBoxStolenItemOwnerFirstName = null;
    private @FindBy(xpath = "//label[@data-test-id='201905081628560148411401-Label']")
    List<WebElement> labelStolenItemOwnerMiddleName = null;
    private @FindBy(xpath = "//input[@data-test-id='201905081628560148411401']")
    List<WebElement> textBoxStolenItemOwnerMiddleName = null;
    private @FindBy(xpath = "//label[@data-test-id='201905081628560149412135-Label']")
    List<WebElement> labelStolenItemOwnerLastName = null;
    private @FindBy(xpath = "//input[@data-test-id='201905081628560149412135']")
    List<WebElement> textBoxStolenItemOwnerLastName = null;
    private @FindBy(xpath = "//label[@data-test-id='201905081713090843222728-Label']")
    List<WebElement> labelStolenItemOrganisationName = null;
    private @FindBy(xpath = "//input[@data-test-id='20190528170032047648357' and contains(@name, 'Item')]")
    List<WebElement> textBoxStolenItemOrganisationName = null;

    private @FindBy(xpath = "//button[@data-test-id='20190522164128092867750']")
    WebElement buttonAddStolenItem = null;
    private @FindBy(xpath = "//button[@data-test-id='201905131659270025240472']")
    WebElement buttonDeleteStolenItem = null;

    private @FindBy(xpath = "//div[@data-test-id='201905291056310808355']//label[text()='Yes']")
    List<WebElement> toggleAgreeTowingCostYes = null;
    private @FindBy(xpath = "//div[@data-test-id='201905291056310808355']//label[text()='No']")
    List<WebElement> toggleAgreeTowingCostNo = null;

    private @FindBy(xpath = "//button[@data-test-id='20161017110917023176385']")
    WebElement buttonContinueFromStolenPage = null;

    private @FindBy(xpath = "//input[@data-test-id='2019050711100204154647']/following-sibling::div/span[contains(text(),'blank')]")
    WebElement stolenItemErrorMessage = null;
    private @FindBy(xpath = "//div[@id='$PpyWorkPage$pStolenVehicle$l1$pVehicleLocationError']")
    WebElement errorMessageWhereWasitStolenFrom = null;

    private @FindBy(xpath = "//i[contains(text(), 'What was stolen')]")
    WebElement labelFirstElementStolen = null;

    public void clickOnContinueButtonFromStolenPage() {
        waitAndclickElementUsingJS(buttonContinueFromStolenPage);
    }

    public void clickOnStolenVehicleToggleYes() {
        waitAndclickElementUsingJS(toggleVehicleStolenYes);
        _persistentData.setContext("stolenVehicleIndicator", "yes");
    }

    public void clickOnStolenVehicleToggleNo() {
        waitAndclickElementUsingJS(toggleVehicleStolenNo);
    }

    public boolean checkIfStolenDetailsSectionIsDisplayed() {
        int stolenVehiclesCommonFieldsIndex = addAndRetrieveStolenVehiclesCommonFieldsIndex();
        boolean check1 = isElementDisplayed(sectionStolenVehicles.get(stolenVehiclesCommonFieldsIndex));
        boolean check2 = isElementDisplayed(sectionWhatWasStolen.get(stolenVehiclesCommonFieldsIndex));
        return check1 && check2;
    }

    public boolean checkFieldsToReportStolenVehicleExists() {
        int stolenVehiclesCommonFieldsIndex = addAndRetrieveStolenVehiclesCommonFieldsIndex();
        isElementDisplayed(sectionStolenVehicles.get(stolenVehiclesCommonFieldsIndex));
        isElementDisplayed(labelLicensePlate.get(stolenVehiclesCommonFieldsIndex));
        isElementDisplayed(textStolenVehicleLicensePlate.get(stolenVehiclesCommonFieldsIndex));
        isElementDisplayed(labelWherewasVehicleStolen.get(stolenVehiclesCommonFieldsIndex));
        isElementDisplayed(dropDownWherewasVehicleStolen.get(stolenVehiclesCommonFieldsIndex));
        isElementDisplayed(labelWhoOwnsStolenVehicle.get(stolenVehiclesCommonFieldsIndex));
        isElementDisplayed(dropDownWhoOwnsStolenVehicle.get(stolenVehiclesCommonFieldsIndex));

        return true;
    }

    public void clickAndTabOutOfStolenItemField() {
        int stolenItemsCommonFieldsIndex = addAndRetrieveStolenItemsCommonFieldsIndex();
        waitAndClickElement(textBoxWhatWasStolen.get(stolenItemsCommonFieldsIndex));
        sendTABKey(textBoxWhatWasStolen.get(stolenItemsCommonFieldsIndex));
        Assert.assertEquals(stolenItemErrorMessage.getText(), "Value cannot be blank");
    }

    public List<WebElement> indicateAddAdditionalStolenVehicle() {
        waitAndclickElementUsingJS(buttonAddStolenVehicle);
        isElementDisplayed(buttonDeleteStolenVehicle);
        int stolenVehiclesCommonFieldsIndex = addAndRetrieveStolenVehiclesCommonFieldsIndex();
        _persistentData.setContext("stolenVehiclesCommonFieldsIndex", stolenVehiclesCommonFieldsIndex + 1);
        return textStolenVehicleLicensePlate;
    }

    public void clickOnDeleteStolenVehicle() {
        waitAndclickElementUsingJS(buttonDeleteStolenVehicle);
    }


    public void selectStolenVehicleOwner(String owner) {
        int stolenVehiclesCommonFieldsIndex = addAndRetrieveStolenVehiclesCommonFieldsIndex();
        selectFromDropDownbyValue(dropDownWhoOwnsStolenVehicle.get(stolenVehiclesCommonFieldsIndex), owner);
    }

    public void keyInStolenVehicleOwnerFirstName(String firstName) {
        int stolenVehiclesOwnerSomeOneElseIndex = addAndRetrieveStolenVehicleOwnerSomeOneElseIndex();
        sendKeysToWebElement(textBoxStolenVehicleOwnerFirstName.get(stolenVehiclesOwnerSomeOneElseIndex), firstName);
    }

    public void keyInStolenItemOwnerFirstName(String firstName) {
        int stolenItemsOwnerSomeOneElseIndex = addAndRetrieveStolenItemOwnerSomeOneElseIndex();
        sendKeysToWebElement(textBoxStolenItemOwnerFirstName.get(stolenItemsOwnerSomeOneElseIndex), firstName);
    }


    public void keyInStolenVehicleOwnerMiddleName(String middleName) {
        int stolenVehiclesOwnerSomeOneElseIndex = addAndRetrieveStolenVehicleOwnerSomeOneElseIndex();
        sendKeysToWebElement(textBoxStolenVehicleOwnerMiddleName.get(stolenVehiclesOwnerSomeOneElseIndex), middleName);
    }

    public void keyInStolenItemOwnerMiddleName(String middleName) {
        int stolenItemsOwnerSomeOneElseIndex = addAndRetrieveStolenItemOwnerSomeOneElseIndex();
        sendKeysToWebElement(textBoxStolenItemOwnerMiddleName.get(stolenItemsOwnerSomeOneElseIndex), middleName);
    }

    public void keyInStolenVehicleOwnerLastName(String lastName) {
        int stolenVehiclesOwnerSomeOneElseIndex = addAndRetrieveStolenVehicleOwnerSomeOneElseIndex();
        sendKeysToWebElement(textBoxStolenVehicleOwnerLastName.get(stolenVehiclesOwnerSomeOneElseIndex), lastName);
        _persistentData.setContext("stolenVehiclesOwnerSomeOneElseIndex", stolenVehiclesOwnerSomeOneElseIndex + 1);
    }


    public void keyInStolenItemOwnerLastName(String lastName) {
        int stolenItemsOwnerSomeOneElseIndex = addAndRetrieveStolenItemOwnerSomeOneElseIndex();
        sendKeysToWebElement(textBoxStolenItemOwnerLastName.get(stolenItemsOwnerSomeOneElseIndex), lastName);
        waitAndClickElement(textBoxStolenItemOwnerMiddleName.get(stolenItemsOwnerSomeOneElseIndex));
        waitForOwnerLastNameToTurnCaps(textBoxStolenItemOwnerLastName.get(stolenItemsOwnerSomeOneElseIndex));
        _persistentData.setContext("stolenItemsOwnerSomeOneElseIndex", stolenItemsOwnerSomeOneElseIndex + 1);
    }


    public void keyInStolenVehicleOwnerOrganisationName(String organisationName) {
        int stolenVehiclesOrganisationOwnerIndex = addAndRetrieveStolenVehicleOrganisationOwnerIndex();
        sendKeysToWebElement(textBoxStolenVehicleOrganisationName.get(stolenVehiclesOrganisationOwnerIndex), organisationName);
        _persistentData.setContext("stolenVehiclesOrganisationOwnerIndex", stolenVehiclesOrganisationOwnerIndex + 1);
    }


    public void keyInStolenItemOwnerOrganisationName(String organisationName) {
        int stolenItemsOrganisationOwnerIndex = addAndRetrieveStolenItemOrganisationOwnerIndex();
        sendKeysToWebElement(textBoxStolenItemOrganisationName.get(stolenItemsOrganisationOwnerIndex), organisationName);
        _persistentData.setContext("stolenItemsOrganisationOwnerIndex", stolenItemsOrganisationOwnerIndex + 1);
    }


    public void keyInRelevantAnswersForStolenVehicleOwner(String owner) {
        int stolenVehiclesCommonFieldsIndex = addAndRetrieveStolenVehiclesCommonFieldsIndex();
        int stolenVehiclesOwnerSomeOneElseIndex = addAndRetrieveStolenVehicleOwnerSomeOneElseIndex();
        switch (owner) {
            case "An organisation does":
                String organisation = _generateTestData.generateValidData("stolenVehicles.owner.organisationName");
                keyInStolenVehicleOwnerOrganisationName(organisation);
                waitAndClickElement(textStolenVehicleLicensePlate.get(stolenVehiclesCommonFieldsIndex));
                //waitForOwnerNameToLoadInDropDown(dropDownWhoOwnsStolenVehicle.get(stolenVehiclesCommonFieldsIndex), organisation);
                break;
            case "Somebody else does":
                String firstName = _generateTestData.generateValidData("stolenVehicles.owner.firstName");
                keyInStolenVehicleOwnerFirstName(firstName);
                waitAndClickElement(textBoxStolenVehicleOwnerMiddleName.get(stolenVehiclesOwnerSomeOneElseIndex));
                //waitForOwnerNameToLoadInDropDown(dropDownWhoOwnsStolenVehicle.get(stolenVehiclesCommonFieldsIndex), firstName);
                keyInStolenVehicleOwnerMiddleName(_generateTestData.generateValidData("stolenVehicles.owner.middleName"));
                keyInStolenVehicleOwnerLastName(_generateTestData.generateValidData("stolenVehicles.owner.lastName"));
                waitAndClickElement(textBoxStolenVehicleOwnerMiddleName.get(stolenVehiclesOwnerSomeOneElseIndex));
                waitForOwnerLastNameToTurnCaps(textBoxStolenVehicleOwnerLastName.get(stolenVehiclesOwnerSomeOneElseIndex));
                break;
        }
    }

    public List<WebElement> getRemainingStolenVehiclesSectionAfterDeletion() {
        return sectionStolenVehicles;
    }


    public boolean checkFieldsToReportStolenItemExists() {
        int stolenItemsCommonFieldsIndex = addAndRetrieveStolenItemsCommonFieldsIndex();
        isElementDisplayed(sectionStolenItem.get(stolenItemsCommonFieldsIndex));
        isElementDisplayed(labelWhatWasStolen.get(stolenItemsCommonFieldsIndex));
        isElementDisplayed(textBoxWhatWasStolen.get(stolenItemsCommonFieldsIndex));
        isElementDisplayed(labelWhoOwnsStoleItem.get(stolenItemsCommonFieldsIndex));
        isElementDisplayed(dropDownWhoOwnsStolenItem.get(stolenItemsCommonFieldsIndex));
        isElementDisplayed(labelSerialOrId.get(stolenItemsCommonFieldsIndex));
        isElementDisplayed(textBoxSerialOrId.get(stolenItemsCommonFieldsIndex));
        isElementDisplayed(labelValueOfItem.get(stolenItemsCommonFieldsIndex));
        isElementDisplayed(textBoxValueOfItem.get(stolenItemsCommonFieldsIndex));
        isElementDisplayed(labelPleaseDescribe.get(stolenItemsCommonFieldsIndex));
        isElementDisplayed(textBoxPleaseDescribe.get(stolenItemsCommonFieldsIndex));
        return true;
    }

    public void validateStolenItemOwnerDropDownValues(String[] expectedList) {
        int stolenItemsCommonFieldsIndex = addAndRetrieveStolenItemsCommonFieldsIndex();
        List<WebElement> dropDownValues = getAllListValuesInDropDown(dropDownWhoOwnsStolenItem.get(stolenItemsCommonFieldsIndex));
        validateDropDownListValues(dropDownValues, expectedList);
    }


    public List<WebElement> getRemainingStolenItemsSectionAfterDeletion() {
        return sectionStolenItem;
    }

    public List<WebElement> indicateAddAdditionalStolenItems() {
        waitAndclickElementUsingJS(buttonAddStolenItem);
        isElementDisplayed(buttonDeleteStolenItem);
        int stolenItemsCommonFieldsIndex = addAndRetrieveStolenItemsCommonFieldsIndex();
        _persistentData.setContext("stolenItemsCommonFieldsIndex", stolenItemsCommonFieldsIndex + 1);
        return textBoxWhatWasStolen;
    }

    public void clickOnDeleteStolenItem() {
        waitAndclickElementUsingJS(buttonDeleteStolenItem);
    }

    public void selectStolenItemOwnerFromDropDown(String owner) {
        int stolenItemsCommonFieldsIndex = addAndRetrieveStolenItemsCommonFieldsIndex();
        selectFromDropDownbyValue(dropDownWhoOwnsStolenItem.get(stolenItemsCommonFieldsIndex), owner);
        waitAndClickElement(textBoxWhatWasStolen.get(stolenItemsCommonFieldsIndex));
    }

    public void keyInRelevantAnswersForStolenItemOwner(String owner) {
        int stolenItemsCommonFieldsIndex = addAndRetrieveStolenItemsCommonFieldsIndex();
        int stolenItemsOwnerSomeOneElseIndex = addAndRetrieveStolenItemOwnerSomeOneElseIndex();
        switch (owner) {
            case "An organisation does":
                String organisation = _generateTestData.generateValidData("whatWasStolen.owner.organisationName");
                keyInStolenItemOwnerOrganisationName(organisation);
                waitAndClickElement(textBoxSerialOrId.get(stolenItemsCommonFieldsIndex));
                //waitForOwnerNameToLoadInDropDown(dropDownWhoOwnsStolenItem.get(stolenItemsCommonFieldsIndex), organisation);
                break;
            case "Somebody else does":
                String firstName = _generateTestData.generateValidData("whatWasStolen.owner.firstName");
                keyInStolenItemOwnerFirstName(firstName);
                waitAndClickElement(textBoxStolenItemOwnerMiddleName.get(stolenItemsOwnerSomeOneElseIndex));
                //waitForOwnerNameToLoadInDropDown(dropDownWhoOwnsStolenItem.get(stolenItemsCommonFieldsIndex), firstName);
                keyInStolenItemOwnerMiddleName(_generateTestData.generateValidData("whatWasStolen.owner.middleName"));
                keyInStolenItemOwnerLastName(_generateTestData.generateValidData("whatWasStolen.owner.lastName"));

                break;
        }
    }

    public void keyInStolenVehicleLicensePlate() {
        int stolenVehiclesCommonFieldsIndex = addAndRetrieveStolenVehiclesCommonFieldsIndex();
        sendKeysToWebElement(textStolenVehicleLicensePlate.get(stolenVehiclesCommonFieldsIndex), _generateTestData.generateValidData("stolenVehicles.licencePlate"));
    }

    public void validateStolenVehicleLocationDropDownValues(String[] expectedList) {
        int stolenVehiclesCommonFieldsIndex = addAndRetrieveStolenVehiclesCommonFieldsIndex();
        List<WebElement> dropDownValues = getAllListValuesInDropDown(dropDownWherewasVehicleStolen.get(stolenVehiclesCommonFieldsIndex));
        validateDropDownListValues(dropDownValues, expectedList);
    }

    public void validateStolenVehicleOwnerDropDownValues(String[] expectedList) {
        List<WebElement> dropDownValues = getAllListValuesInDropDown(dropDownWhoOwnsStolenVehicle.get(0));
        validateDropDownListValues(dropDownValues, expectedList);
    }

    public void selectWhereWasTheVehicleStolenFrom() {

        int stolenVehiclesCommonFieldsIndex = addAndRetrieveStolenVehiclesCommonFieldsIndex();
        if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
            selectFromDropDownbyValue(dropDownWherewasVehicleStolenMobile.get(stolenVehiclesCommonFieldsIndex), _generateTestData.generateValidData("stolenVehicles.stolenLocation"));
        } else {
            selectFromDropDownbyValue(dropDownWherewasVehicleStolen.get(stolenVehiclesCommonFieldsIndex), _generateTestData.generateValidData("stolenVehicles.stolenLocation"));
        }

    }

    public void setToggleAgreeTowingCostYes() {
        int stolenVehiclesCommonFieldsIndex = addAndRetrieveStolenVehiclesCommonFieldsIndex();
        waitAndclickElementUsingJS(toggleAgreeTowingCostYes.get(stolenVehiclesCommonFieldsIndex));
    }

    public void setToggleAgreeTowingCostNo() {
        int stolenVehiclesCommonFieldsIndex = addAndRetrieveStolenVehiclesCommonFieldsIndex();
        waitAndclickElementUsingJS(toggleAgreeTowingCostNo.get(stolenVehiclesCommonFieldsIndex));
    }

    public void chooseTowingAuthority() {
        String towingFlag = _generateTestData.generateValidData("stolenVehicles.towingAuthority");
        if (towingFlag.equalsIgnoreCase("yes")) {
            setToggleAgreeTowingCostYes();
        } else if (towingFlag.equalsIgnoreCase("no")) {
            setToggleAgreeTowingCostNo();
        } else {
            System.out.println("TOWING AUTHORITY DATA :::::::::::::: " + _generateTestData.generateValidData("stolenVehicles.towingAuthority"));
        }
    }

    public void chooseTowingAuthority(String choice) {
        if (choice.equalsIgnoreCase("yes")) {
            setToggleAgreeTowingCostYes();
        } else if (choice.equalsIgnoreCase("no")) {
            setToggleAgreeTowingCostNo();
        } else {
            System.out.println("TOWING AUTHORITY DATA :::::::::::::: " + _generateTestData.generateValidData("stolenVehicles.towingAuthority"));
        }
    }

    public void selectStolenItemOwner(String owner) {
        int stolenItemsCommonFieldsIndex = addAndRetrieveStolenItemsCommonFieldsIndex();
        selectFromDropDownbyValue(dropDownWhoOwnsStolenItem.get(stolenItemsCommonFieldsIndex), owner);
    }

    public void keyInDataOnStolenVehicleOwnerField(String owner) {
        int stolenVehiclesOwnerSomeOneElseIndex = addAndRetrieveStolenVehicleOwnerSomeOneElseIndex();
        int stolenVehiclesCommonFieldsIndex = addAndRetrieveStolenVehiclesCommonFieldsIndex();
        switch (owner) {
            case "An organisation does":
                String organisation = _generateTestData.generateValidData("stolenVehicles.owner.organisationName");
                keyInStolenVehicleOwnerOrganisationName(organisation);
                waitAndClickElement(textStolenVehicleLicensePlate.get(stolenVehiclesCommonFieldsIndex));
                //waitForOwnerNameToLoadInDropDown(dropDownWhoOwnsStolenVehicle.get(stolenVehiclesCommonFieldsIndex), organisation);
                break;
            case "Somebody else does":
                String firstName = _generateTestData.generateValidData("stolenVehicles.owner.firstName");
                keyInStolenVehicleOwnerFirstName(firstName);
                waitAndClickElement(textBoxStolenVehicleOwnerMiddleName.get(stolenVehiclesOwnerSomeOneElseIndex));
                //waitForOwnerNameToLoadInDropDown(dropDownWhoOwnsStolenVehicle.get(stolenVehiclesCommonFieldsIndex), firstName);
                keyInStolenVehicleOwnerMiddleName(_generateTestData.generateValidData("stolenVehicles.owner.middleName"));
                keyInStolenVehicleOwnerLastName(_generateTestData.generateValidData("stolenVehicles.owner.lastName"));
                waitAndClickElement(textBoxStolenVehicleOwnerMiddleName.get(stolenVehiclesOwnerSomeOneElseIndex));
                waitForOwnerLastNameToTurnCaps(textBoxStolenVehicleOwnerLastName.get(stolenVehiclesOwnerSomeOneElseIndex));
                break;
        }
    }

    public void keyInDataOnStolenVehicleOwnerFieldMobile(String owner) {
        switch (owner) {
            case "An organisation does":
                String organisation = _generateTestData.generateValidData("stolenVehicles.owner.organisationName");
                keyInStolenVehicleOwnerOrganisationName(organisation);
                break;
            case "Somebody else does":
                String firstName = _generateTestData.generateValidData("stolenVehicles.owner.firstName");
                keyInStolenVehicleOwnerFirstName(firstName);
                keyInStolenVehicleOwnerMiddleName(_generateTestData.generateValidData("stolenVehicles.owner.middleName"));
                keyInStolenVehicleOwnerLastName(_generateTestData.generateValidData("stolenVehicles.owner.lastName"));
                break;
        }
    }


    public void keyInDataOnStolenItemOwnerField(String owner) {
        int stolenItemsOwnerSomeOneElseIndex = addAndRetrieveStolenItemOwnerSomeOneElseIndex();
        int stolenItemsCommonFieldsIndex = addAndRetrieveStolenItemsCommonFieldsIndex();
        switch (owner) {
            case "An organisation does":
                String organisation = _generateTestData.generateValidData("whatWasStolen.owner.organisationName");
                keyInStolenItemOwnerOrganisationName(organisation);
                waitAndClickElement(textBoxWhatWasStolen.get(stolenItemsCommonFieldsIndex));
                //waitForOwnerNameToLoadInDropDown(dropDownWhoOwnsStolenItem.get(stolenItemsCommonFieldsIndex), organisation);
                break;
            case "Somebody else does":
                String firstName = _generateTestData.generateValidData("whatWasStolen.owner.firstName");
                keyInStolenItemOwnerFirstName(firstName);
                waitAndClickElement(textBoxStolenItemOwnerMiddleName.get(stolenItemsOwnerSomeOneElseIndex));
                //waitForOwnerNameToLoadInDropDown(dropDownWhoOwnsStolenItem.get(stolenItemsCommonFieldsIndex), firstName);
                keyInStolenItemOwnerMiddleName(_generateTestData.generateValidData("whatWasStolen.owner.middleName"));
                keyInStolenItemOwnerLastName(_generateTestData.generateValidData("whatWasStolen.owner.lastName"));
                break;
        }
    }

    public void keyInDataOnStolenItemOwnerFieldMobile(String owner) {
        switch (owner) {
            case "An organisation does":
                String organisation = _generateTestData.generateValidData("whatWasStolen.owner.organisationName");
                keyInStolenItemOwnerOrganisationName(organisation);
                break;
            case "Somebody else does":
                String firstName = _generateTestData.generateValidData("whatWasStolen.owner.firstName");
                keyInStolenItemOwnerFirstName(firstName);
                keyInStolenItemOwnerMiddleName(_generateTestData.generateValidData("whatWasStolen.owner.middleName"));
                keyInStolenItemOwnerLastName(_generateTestData.generateValidData("whatWasStolen.owner.lastName"));
                break;
        }
    }

    public void keyInDataOnWhatWasStolen() {
        executionDeviceConfiguration = new ExecutionDeviceConfiguration(getDeviceKey());
        String deviceType = executionDeviceConfiguration.getDeviceParameters("DEVICE");
        if (deviceType.toLowerCase().contains("tab") || deviceType.equalsIgnoreCase("Google Nexus 9") || deviceType.toLowerCase().contains("ipad")) {
            whatwasStolenAutoCompleteMobile = whatwasStolenAutoComplete;
        }
        int stolenItemsCommonFieldsIndex = addAndRetrieveStolenItemsCommonFieldsIndex();
        if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
            selectLookupValue(textBoxWhatWasStolen.get(stolenItemsCommonFieldsIndex), whatwasStolenAutoCompleteMobile, _generateTestData.generateValidData("whatWasStolen.stolenItem"), false);
        } else {
            selectLookupValue(textBoxWhatWasStolen.get(stolenItemsCommonFieldsIndex), whatwasStolenAutoComplete, _generateTestData.generateValidData("whatWasStolen.stolenItem"), false);
        }
    }

    public void selectWhoOwnsStolenItem(String owner) {
        int stolenItemsCommonFieldsIndex = addAndRetrieveStolenItemsCommonFieldsIndex();
        selectFromDropDownbyValue(dropDownWhoOwnsStolenItem.get(stolenItemsCommonFieldsIndex), owner);
    }

    public void keyInSerialNumberOfStolenItem() {
        int stolenItemsCommonFieldsIndex = addAndRetrieveStolenItemsCommonFieldsIndex();
        sendKeysToWebElement(textBoxSerialOrId.get(stolenItemsCommonFieldsIndex), _generateTestData.generateValidData("whatWasStolen.itemID"));
    }

    public void keyInValueOfStolenItem() {
        int stolenItemsCommonFieldsIndex = addAndRetrieveStolenItemsCommonFieldsIndex();
        sendKeysToWebElement(textBoxValueOfItem.get(stolenItemsCommonFieldsIndex), _generateTestData.generateValidData("whatWasStolen.itemValue"));
    }

    public void keyInDescribeOfStolenItem() {
        int stolenItemsCommonFieldsIndex = addAndRetrieveStolenItemsCommonFieldsIndex();
        sendKeysToWebElement(textBoxPleaseDescribe.get(stolenItemsCommonFieldsIndex), _generateTestData.generateValidData("whatWasStolen.description"));
    }

    public int addAndRetrieveStolenVehiclesCommonFieldsIndex() {
        int stolenVehiclesCommonFieldsIndex = 0;
        try {
            stolenVehiclesCommonFieldsIndex = (int) _persistentData.getContext("stolenVehiclesCommonFieldsIndex");
        } catch (Exception e) {
            _persistentData.setContext("stolenVehiclesCommonFieldsIndex", stolenVehiclesCommonFieldsIndex);
        }
        return stolenVehiclesCommonFieldsIndex;
    }

    public int addAndRetrieveStolenVehicleOwnerSomeOneElseIndex() {
        int stolenVehiclesOwnerSomeOneElseIndex = 0;
        try {
            stolenVehiclesOwnerSomeOneElseIndex = (int) _persistentData.getContext("stolenVehiclesOwnerSomeOneElseIndex");
        } catch (Exception e) {
            _persistentData.setContext("stolenVehiclesOwnerSomeOneElseIndex", stolenVehiclesOwnerSomeOneElseIndex);
        }
        return stolenVehiclesOwnerSomeOneElseIndex;
    }

    public int addAndRetrieveStolenVehicleOrganisationOwnerIndex() {
        int stolenVehiclesOrganisationOwnerIndex = 0;
        try {
            stolenVehiclesOrganisationOwnerIndex = (int) _persistentData.getContext("stolenVehiclesOrganisationOwnerIndex");
        } catch (Exception e) {
            _persistentData.setContext("stolenVehiclesOrganisationOwnerIndex", stolenVehiclesOrganisationOwnerIndex);
        }
        return stolenVehiclesOrganisationOwnerIndex;
    }

    public int addAndRetrieveStolenItemsCommonFieldsIndex() {
        int stolenItemsCommonFieldsIndex = 0;
        try {
            stolenItemsCommonFieldsIndex = (int) _persistentData.getContext("stolenItemsCommonFieldsIndex");
        } catch (Exception e) {
            _persistentData.setContext("stolenItemsCommonFieldsIndex", stolenItemsCommonFieldsIndex);
        }
        return stolenItemsCommonFieldsIndex;
    }

    public int addAndRetrieveStolenItemOwnerSomeOneElseIndex() {
        int stolenItemsOwnerSomeOneElseIndex = 0;
        try {
            stolenItemsOwnerSomeOneElseIndex = (int) _persistentData.getContext("stolenItemsOwnerSomeOneElseIndex");
        } catch (Exception e) {
            _persistentData.setContext("stolenItemsOwnerSomeOneElseIndex", stolenItemsOwnerSomeOneElseIndex);
        }
        return stolenItemsOwnerSomeOneElseIndex;
    }

    public int addAndRetrieveStolenItemOrganisationOwnerIndex() {
        int stolenItemsOrganisationOwnerIndex = 0;
        try {
            stolenItemsOrganisationOwnerIndex = (int) _persistentData.getContext("stolenItemsOrganisationOwnerIndex");
        } catch (Exception e) {
            _persistentData.setContext("stolenItemsOrganisationOwnerIndex", stolenItemsOrganisationOwnerIndex);
        }
        return stolenItemsOrganisationOwnerIndex;
    }

    public void mandatoryFieldErrorForwhereWasTheVehicleStolenFrom() {
        waitForPageComponentLoadFluentWait();
        isElementDisplayed(errorMessageWhereWasitStolenFrom);
    }
}
