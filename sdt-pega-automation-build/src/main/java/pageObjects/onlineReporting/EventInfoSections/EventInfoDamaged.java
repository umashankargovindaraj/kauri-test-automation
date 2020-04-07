package pageObjects.onlineReporting.EventInfoSections;

import com.fasterxml.jackson.databind.JsonNode;
import cucumber.api.java.en_lol.WEN;
import libs.ExecutionDeviceConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class EventInfoDamaged extends EventInfo {

    private @FindBy(xpath = "//div[@data-test-id='201906111428240778478']")
    List<WebElement> sectionDamagedVehicles = null;
    private @FindBy(xpath = "//div[@data-test-id='201905221458400688672']")
    List<WebElement> sectionWhatWasDamaged = null;

    private @FindBy(xpath = "//div[@data-test-id='20190611143117012945883']//label[text()='Yes']")
    WebElement toggleVehicleDamagedYes = null;
    private @FindBy(xpath = "//div[@data-test-id='20190611143117012945883']//label[text()='No']")
    WebElement toggleVehicleDamagedNo = null;

    private @FindBy(xpath = "//label[@data-test-id='2019060710262406478129-Label']")
    List<WebElement> labelLicencePlateDetails = null;
    private @FindBy(xpath = "//input[@data-test-id='2019060710262406478129']")
    List<WebElement> textBoxLicencePlateDetails = null;
    private @FindBy(xpath = "//label[@data-test-id='201906071026240649981-Label']")
    List<WebElement> labelHowwasVehicleDamaged = null;
    private @FindBy(xpath = "//textarea[@data-test-id='201906071026240649981']")
    List<WebElement> textHowWasVehicleDamaged = null;
    private @FindBy(xpath = "//label[@data-test-id='2019060711284408547626-Label']")
    List<WebElement> labelWhoOwnsVehicle = null;
    private @FindBy(xpath = "//select[@data-test-id='2019060711284408547626']")
    List<WebElement> dropDownWhoOwnsDamagedVehicle = null;
    private @FindBy(xpath = "//label[@data-test-id='20190618112359011330469-Label']")
    List<WebElement> labelWasVehicleMoved = null;
    private @FindBy(xpath = "//div[@data-test-id='20190618112359011330469']//label[text()='Yes']")
    List<WebElement> toggleWasVehicleMovedYes = null;
    private @FindBy(xpath = "//div[@data-test-id='20190618112359011330469']//label[text()='No']")
    List<WebElement> toggleWasVehicleMovedNo = null;
    private @FindBy(xpath = "//label[@data-test-id='20190618113315048532498-Label']")
    List<WebElement> labelWasIgnitionTampered = null;
    private @FindBy(xpath = "//div[@data-test-id='20190618113315048532498']//label[text()='Yes']")
    List<WebElement> toggleWasIgnitionTamperedYes = null;
    private @FindBy(xpath = "//div[@data-test-id='201906111428240778478']//select[@data-test-id='2019052812011802847278']")
    List<WebElement> dropDownWhereWasVehicleWhenDamaged = null;
    private @FindBy(xpath = "//div[@data-test-id='20190618113315048532498']//label[text()='No']")
    List<WebElement> toggleWasIgnitionTamperedNo = null;
    private @FindBy(xpath = "//label[@data-test-id='20190607114859023079571-Label']")
    List<WebElement> labelVehicleOwnerFirstName = null;
    private @FindBy(xpath = "//input[@data-test-id='20190607114859023079571']")
    List<WebElement> textBoxDamagedVehicleOwnerFirstName = null;
    private @FindBy(xpath = "//label[@data-test-id='20190607114859023180130-Label']")
    List<WebElement> labelVehicleOwnerMiddleName = null;
    private @FindBy(xpath = "//input[@data-test-id='20190607114859023180130']")
    List<WebElement> textBoxDamagedVehicleOwnerMiddleName = null;
    private @FindBy(xpath = "//label[@data-test-id='20190607114859023181434-Label']")
    List<WebElement> labelVehicleOwnerLastName = null;
    private @FindBy(xpath = "//input[@data-test-id='20190607114859023181434']")
    List<WebElement> textBoxDamagedVehicleOwnerLastName = null;
    private @FindBy(xpath = "//label[@data-test-id='20190607115104030755847-Label']")
    List<WebElement> labelVehicleOrganisationName = null;
    private @FindBy(xpath = "//input[@data-test-id='20190528170032047648357']")
    List<WebElement> textBoxDamagedVehicleOrganisationName = null;
    private @FindBy(xpath = "//button[@data-test-id='20190611143620043533376']")
    WebElement buttonAddDamagedVehicle = null;
    private @FindBy(xpath = "//button[@data-test-id='2019060711442402219937']")
    WebElement buttonDeleteVehicle = null;

    private @FindBy(xpath = "//div[@data-test-id='201904121025390954598']")
    List<WebElement> sectionDamagedItems = null;
    private @FindBy(xpath = "//label[@data-test-id='20190412103124008161486-Label']")
    List<WebElement> labelWhatwasDamaged = null;
    private @FindBy(xpath = "//input[@data-test-id='20190412103124008161486' and contains(@placeholder, 'Start typing')]")
    List<WebElement> textBoxWhatwasDamaged = null;
    private @FindBy(xpath = "//table[contains(@pl_prop,'D_ItemsList')]//tr[contains(@oaargs, 'Police-SDW-Data-Items')]")
    List<WebElement> whatwasDamagedAutoComplete = null;
    private @FindBy(xpath = "//div[@class='autocomplete-results']//li[contains(@class,'ac-item')]")
    List<WebElement> whatwasDamagedAutoCompleteMobile = null;
    private @FindBy(xpath = "//label[@data-test-id='20190412103124008057146-Label']")
    List<WebElement> labelHowwasitDamaged = null;
    private @FindBy(xpath = "//label[@data-test-id='201906071026240649981-Label']")
    List<WebElement> labelHowAndWhereWasItDamaged = null;
    private @FindBy(xpath = "//textarea[@data-test-id='20190412103124008057146']")
    List<WebElement> textBoxHowWasitDamaged = null;
    private @FindBy(xpath = "//label[@data-test-id='20190517154701027415986-Label']")
    List<WebElement> labelWhoOwnsIt = null;
    private @FindBy(xpath = "//select[@data-test-id='20190517154701027415986']")
    List<WebElement> dropDownWhoOwnsDamagedItem = null;
    private @FindBy(xpath = "//label[@data-test-id='201905171613100818271397-Label']")
    List<WebElement> labelDamagedItemOwnerFirstName = null;
    private @FindBy(xpath = "//input[@data-test-id='201905171613100818271397']")
    List<WebElement> textBoxDamagedItemOwnerFirstName = null;
    private @FindBy(xpath = "//label[@data-test-id='201905171613100819272551-Label']")
    List<WebElement> labelDamagedItemOwnerMiddleName = null;
    private @FindBy(xpath = "//input[@data-test-id='201905171613100819272551']")
    List<WebElement> textBoxDamagedItemOwnerMiddleName = null;
    private @FindBy(xpath = "//label[@data-test-id='201905171613100819273605-Label']")
    List<WebElement> labelDamagedItemOwnerLastName = null;
    private @FindBy(xpath = "//input[@data-test-id='201905171613100819273605']")
    List<WebElement> textBoxDamagedItemOwnerLastName = null;
    private @FindBy(xpath = "//label[@data-test-id='201905171613100817267950-Label']")
    List<WebElement> labelDamagedItemOrganisationName = null;
    private @FindBy(xpath = "//input[@data-test-id='20190528170032047648357']")
    List<WebElement> textBoxDamagedItemOrganisationName = null;
    private @FindBy(xpath = "//input[@data-test-id='20190528170032047648357']")
    List<WebElement> getTextBoxDamagedItemOrganisationNameMobile = null;

    private @FindBy(xpath = "//button[@data-test-id='20190524132600096441931']")
    WebElement buttonAddDamagedItem = null;
    private @FindBy(xpath = "//button[@data-test-id='201905171504270189117173']")
    WebElement buttonDeleteItem = null;
    private @FindBy(xpath = "//input[@data-test-id='20190412103124008161486']/following-sibling::div/span[contains(text(),'blank')]")
    WebElement damagedItemErrorMessage = null;
    private @FindBy(xpath = "//select[@data-test-id='2019052812011802847278']")
    WebElement dropDownWhereWasDamagedVehicle = null;
    private @FindBy(xpath = "//div[@id='$PpyWorkPage$pDamagedVehicle$l1$pVehicleLocationError']/span")
    WebElement whereWasDamagedVehicleError = null;

    private @FindBy(xpath = "//button[@data-test-id='20161017110917023176385']")
    WebElement buttonContinueFromDamagedPage = null;

    public void clickOnContinueFromDamagedPageMobile() {
        waitAndclickElementUsingJS(buttonContinueFromDamagedPage);
    }

    public void clickOnToggleVehicleDamagedYes() {
        waitAndclickElementUsingJS(toggleVehicleDamagedYes);
    }

    public void clickOnToggleVehicleDamagedNo() {
        waitAndclickElementUsingJS(toggleVehicleDamagedNo);
    }


    public void clickAndTabOutOfDamagedItemField() {
        int damagedItemsCommonFieldsIndex = addAndRetrieveDamagedItemsCommonFieldsIndex();
        waitAndClickElement(textBoxWhatwasDamaged.get(damagedItemsCommonFieldsIndex));
        sendTABKey(textBoxWhatwasDamaged.get(damagedItemsCommonFieldsIndex));
        Assert.assertEquals(damagedItemErrorMessage.getText(), "Value cannot be blank");
    }

    public boolean checkDamagedItemSectionExists() {
        waitForPageComponentLoadFluentWait();
        WebElement ele = sectionDamagedItems.get(0);
        return isElementDisplayed(ele);
    }

    public boolean checkIfDamagedDetailsSectionIsDisplayed() {
        int damagedVehiclesCommonFieldsIndex = addAndRetrieveDamagedVehiclesCommonFieldsIndex();
        boolean check1 = isElementDisplayed(sectionDamagedVehicles.get(damagedVehiclesCommonFieldsIndex));
        boolean check2 = isElementDisplayed(sectionWhatWasDamaged.get(damagedVehiclesCommonFieldsIndex));
        return check1 && check2;
    }


    public boolean checkFieldsToReportDamagedVehicleExists() {
        int damagedVehiclesCommonFieldsIndex = addAndRetrieveDamagedVehiclesCommonFieldsIndex();
        isElementDisplayed(sectionDamagedVehicles.get(damagedVehiclesCommonFieldsIndex));
        isElementDisplayed(labelLicencePlateDetails.get(damagedVehiclesCommonFieldsIndex));
        isElementDisplayed(labelLicencePlateDetails.get(damagedVehiclesCommonFieldsIndex));
        isElementDisplayed(textBoxLicencePlateDetails.get(damagedVehiclesCommonFieldsIndex));
        isElementDisplayed(labelHowwasVehicleDamaged.get(damagedVehiclesCommonFieldsIndex));
        isElementDisplayed(textHowWasVehicleDamaged.get(damagedVehiclesCommonFieldsIndex));
        isElementDisplayed(labelWhoOwnsVehicle.get(damagedVehiclesCommonFieldsIndex));
        isElementDisplayed(dropDownWhoOwnsDamagedVehicle.get(damagedVehiclesCommonFieldsIndex));
        isElementDisplayed(labelWasVehicleMoved.get(damagedVehiclesCommonFieldsIndex));
        isElementDisplayed(toggleWasVehicleMovedYes.get(damagedVehiclesCommonFieldsIndex));
        isElementDisplayed(toggleWasVehicleMovedNo.get(damagedVehiclesCommonFieldsIndex));
        isElementDisplayed(labelWasIgnitionTampered.get(damagedVehiclesCommonFieldsIndex));
        isElementDisplayed(toggleWasIgnitionTamperedYes.get(damagedVehiclesCommonFieldsIndex));
        isElementDisplayed(toggleWasIgnitionTamperedNo.get(damagedVehiclesCommonFieldsIndex));
        return true;
    }

    public void keyInDamagedVehicleLicensePlate() {
        int damagedVehiclesCommonFieldsIndex = addAndRetrieveDamagedVehiclesCommonFieldsIndex();
        sendKeysToWebElement(textBoxLicencePlateDetails.get(damagedVehiclesCommonFieldsIndex), _generateTestData.generateValidData("damagedVehicles.licencePlate"));
    }

    public void selectDamagedVehicleMovedIndicator() {
        int damagedVehiclesCommonFieldsIndex = addAndRetrieveDamagedVehiclesCommonFieldsIndex();
        String value = _generateTestData.generateValidData("damagedVehicles.vehicleMoved");
        if (value.equalsIgnoreCase("yes")) {
            waitAndclickElementUsingJS(toggleWasVehicleMovedYes.get(damagedVehiclesCommonFieldsIndex));
        } else {
            waitAndclickElementUsingJS(toggleWasVehicleMovedNo.get(damagedVehiclesCommonFieldsIndex));
        }
    }

    public void selectDamagedVehicleIgnitionTamperedIndicator() {
        int damagedVehiclesCommonFieldsIndex = addAndRetrieveDamagedVehiclesCommonFieldsIndex();
        String value = _generateTestData.generateValidData("damagedVehicles.ignitionTampered");
        if (value.equalsIgnoreCase("yes")) {
            waitAndclickElementUsingJS(toggleWasIgnitionTamperedYes.get(damagedVehiclesCommonFieldsIndex));
        } else {
            waitAndclickElementUsingJS(toggleWasIgnitionTamperedNo.get(damagedVehiclesCommonFieldsIndex));
        }
    }

    public void selectWhereWasVehicleWhenItWasDamaged() {
        int damagedVehiclesCommonFieldsIndex = addAndRetrieveDamagedVehiclesCommonFieldsIndex();
        String value = _generateTestData.generateValidData("damagedVehicles.whereWasVehicleWhenDamaged");
        selectFromDropDownbyValue(dropDownWhereWasVehicleWhenDamaged.get(damagedVehiclesCommonFieldsIndex), value);
    }

    public void keyInHowWasVehicleDamaged() {
        int damagedVehiclesCommonFieldsIndex = addAndRetrieveDamagedVehiclesCommonFieldsIndex();
        sendKeysToWebElement(textHowWasVehicleDamaged.get(damagedVehiclesCommonFieldsIndex), _generateTestData.generateValidData("damagedVehicles.howWasItDamaged"));
    }

    public void clickOnButtonAddDamagedVehicle() {
        waitAndclickElementUsingJS(buttonAddDamagedVehicle);
        int damagedVehiclesCommonFieldsIndex = addAndRetrieveDamagedVehiclesCommonFieldsIndex();
        _persistentData.setContext("damagedVehiclesCommonFieldsIndex", damagedVehiclesCommonFieldsIndex + 1);
    }

    public List<WebElement> indicateAddAdditionalDamagedVehicle() {
        clickOnButtonAddDamagedVehicle();
        isElementDisplayed(buttonDeleteVehicle);
        return textBoxLicencePlateDetails;
    }

    public void clickOnDeleteVehicle() {
        waitAndclickElementUsingJS(buttonDeleteVehicle);
    }


    public void selectDamagedVehicleOwnerFromDropDown(String owner) {
        int damagedVehiclesCommonFieldsIndex = addAndRetrieveDamagedVehiclesCommonFieldsIndex();
        waitForPageComponentLoadFluentWait();
        WebElement ele = dropDownWhoOwnsDamagedVehicle.get(damagedVehiclesCommonFieldsIndex);
        selectFromDropDownbyValue(ele, owner);
    }

    public void selectDamagedVehicleOwnerFromDropDown() {
        int damagedVehiclesCommonFieldsIndex = addAndRetrieveDamagedVehiclesCommonFieldsIndex();
        selectFromDropDownbyValue(dropDownWhoOwnsDamagedVehicle.get(damagedVehiclesCommonFieldsIndex), _generateTestData.generateValidData("damagedVehicles.owner.value"));
    }

    public void keyInDamagedVehicleOwnerFirstName(String firstName) {
        int damagedVehiclesOwnerSomeOneElseIndex = addAndRetrieveDamagedVehicleOwnerSomeOneElseIndex();
        sendKeysToWebElement(textBoxDamagedVehicleOwnerFirstName.get(damagedVehiclesOwnerSomeOneElseIndex), firstName);
    }

    public void keyInDamagedVehicleOwnerMiddleName(String middleName) {
        int damagedVehiclesOwnerSomeOneElseIndex = addAndRetrieveDamagedVehicleOwnerSomeOneElseIndex();
        sendKeysToWebElement(textBoxDamagedVehicleOwnerMiddleName.get(damagedVehiclesOwnerSomeOneElseIndex), middleName);
    }

    public void keyInDamagedVehicleOwnerLastName(String lastName) {
        int damagedVehiclesOwnerSomeOneElseIndex = addAndRetrieveDamagedVehicleOwnerSomeOneElseIndex();
        sendKeysToWebElement(textBoxDamagedVehicleOwnerLastName.get(damagedVehiclesOwnerSomeOneElseIndex), lastName);
        waitAndClickElement(textBoxDamagedVehicleOwnerMiddleName.get(damagedVehiclesOwnerSomeOneElseIndex));
        waitForOwnerLastNameToTurnCaps(textBoxDamagedVehicleOwnerLastName.get(damagedVehiclesOwnerSomeOneElseIndex));
        _persistentData.setContext("damagedVehiclesOwnerSomeOneElseIndex", damagedVehiclesOwnerSomeOneElseIndex + 1);
    }

    public void keyInDamagedVehicleOwnerOrganisationName(String organisationName) {
        int damagedVehiclesOrganisationOwnerIndex = addAndRetrieveDamagedVehicleOrganisationOwnerIndex();
        sendKeysToWebElement(textBoxDamagedVehicleOrganisationName.get(damagedVehiclesOrganisationOwnerIndex), organisationName);
        _persistentData.setContext("damagedVehiclesOrganisationOwnerIndex", damagedVehiclesOrganisationOwnerIndex + 1);
    }


    public void keyInDataOnDamagedVehicleOwnerField(String owner) {
        int damagedVehiclesCommonFieldsIndex = addAndRetrieveDamagedVehiclesCommonFieldsIndex();
        int damagedVehiclesOwnerSomeOneElseIndex = addAndRetrieveDamagedVehicleOwnerSomeOneElseIndex();

        switch (owner) {
            case "An organisation does":
                String organisation = _generateTestData.generateValidData("damagedVehicles.owner.organisationName");
                keyInDamagedVehicleOwnerOrganisationName(organisation);
                waitAndClickElement(textHowWasVehicleDamaged.get(damagedVehiclesCommonFieldsIndex));
                //waitForOwnerNameToLoadInDropDown(dropDownWhoOwnsDamagedVehicle.get(damagedVehiclesCommonFieldsIndex), organisation);
                break;
            case "Somebody else does":
                String firstName = _generateTestData.generateValidData("damagedVehicles.owner.firstName");
                keyInDamagedVehicleOwnerFirstName(firstName);
                waitAndClickElement(textBoxDamagedVehicleOwnerMiddleName.get(damagedVehiclesOwnerSomeOneElseIndex));
                //waitForOwnerNameToLoadInDropDown(dropDownWhoOwnsDamagedVehicle.get(damagedVehiclesCommonFieldsIndex), firstName);
                keyInDamagedVehicleOwnerMiddleName(_generateTestData.generateValidData("damagedVehicles.owner.middleName"));
                keyInDamagedVehicleOwnerLastName(_generateTestData.generateValidData("damagedVehicles.owner.lastName"));
                break;
        }
    }

    public void keyInDataOnDamagedVehicleOwnerFieldMobile(String owner) {
        switch (owner) {
            case "An organisation does":
                String organisation = _generateTestData.generateValidData("damagedVehicles.owner.organisationName");
                keyInDamagedVehicleOwnerOrganisationName(organisation);
                break;
            case "Somebody else does":
                String firstName = _generateTestData.generateValidData("damagedVehicles.owner.firstName");
                keyInDamagedVehicleOwnerFirstName(firstName);
                keyInDamagedVehicleOwnerMiddleName(_generateTestData.generateValidData("damagedVehicles.owner.middleName"));
                keyInDamagedVehicleOwnerLastName(_generateTestData.generateValidData("damagedVehicles.owner.lastName"));
                break;
        }
    }

    public void keyInDataOnDamagedItemOwnerField(String owner) {
        int damagedVehiclesCommonFieldsIndex = addAndRetrieveDamagedItemsCommonFieldsIndex();
        int damagedItemsOwnerSomeOneElseIndex = addAndRetrieveDamagedItemOwnerSomeOneElseIndex();
        switch (owner) {
            case "An organisation does":
                String organisation = _generateTestData.generateValidData("whatWasDamaged.owner.organisationName");
                keyInDamagedItemOwnerOrganisationName(organisation);
                waitAndClickElement(textBoxHowWasitDamaged.get(damagedVehiclesCommonFieldsIndex));
                //waitForOwnerNameToLoadInDropDown(dropDownWhoOwnsDamagedItem.get(damagedVehiclesCommonFieldsIndex), organisation);
                break;
            case "Somebody else does":
                String firstName = _generateTestData.generateValidData("whatWasDamaged.owner.firstName");
                keyInDamagedItemOwnerFirstName(firstName);
                waitAndClickElement(textBoxDamagedItemOwnerMiddleName.get(damagedItemsOwnerSomeOneElseIndex));
                //waitForOwnerNameToLoadInDropDown(dropDownWhoOwnsDamagedItem.get(damagedVehiclesCommonFieldsIndex), firstName);
                keyInDamagedItemOwnerMiddleName(_generateTestData.generateValidData("whatWasDamaged.owner.middleName"));
                keyInDamagedItemOwnerLastName(_generateTestData.generateValidData("whatWasDamaged.owner.lastName"));
                waitAndClickElement(textBoxDamagedItemOwnerMiddleName.get(damagedItemsOwnerSomeOneElseIndex));
                waitForOwnerLastNameToTurnCaps(textBoxDamagedItemOwnerLastName.get(damagedItemsOwnerSomeOneElseIndex));
                break;
        }
    }

    public void keyInDataOnDamagedItemOwnerFieldMobile(String owner) {
        switch (owner) {
            case "An organisation does":
                String organisation = _generateTestData.generateValidData("whatWasDamaged.owner.organisationName");
                keyInDamagedItemOwnerOrganisationNameMobile(organisation);
                break;
            case "Somebody else does":
                String firstName = _generateTestData.generateValidData("whatWasDamaged.owner.firstName");
                keyInDamagedItemOwnerFirstName(firstName);
                keyInDamagedItemOwnerMiddleName(_generateTestData.generateValidData("whatWasDamaged.owner.middleName"));
                keyInDamagedItemOwnerLastName(_generateTestData.generateValidData("whatWasDamaged.owner.lastName"));
                break;
        }
    }

    public List<WebElement> getRemainingDamagedVehiclesSectionAfterDeletion() {
        return sectionDamagedItems;
    }

    public boolean checkFieldsToReportDamagedItemExists() {
        int damagedItemsCommonFieldsIndex = addAndRetrieveDamagedItemsCommonFieldsIndex();
        isElementDisplayed(sectionDamagedItems.get(damagedItemsCommonFieldsIndex));
        //isElementDisplayed(labelWhatwasDamaged.get(damagedItemsCommonFieldsIndex));
        isElementDisplayed(textBoxWhatwasDamaged.get(damagedItemsCommonFieldsIndex));
        isElementDisplayed(labelHowwasitDamaged.get(damagedItemsCommonFieldsIndex));
        isElementDisplayed(textBoxHowWasitDamaged.get(damagedItemsCommonFieldsIndex));
        isElementDisplayed(labelWhoOwnsIt.get(damagedItemsCommonFieldsIndex));
        isElementDisplayed(dropDownWhoOwnsDamagedItem.get(damagedItemsCommonFieldsIndex));
        return true;
    }

    public void keyInDataOnWhatWasDamaged() {
        executionDeviceConfiguration = new ExecutionDeviceConfiguration(getDeviceKey());
        String deviceType = executionDeviceConfiguration.getDeviceParameters("DEVICE");
        if (deviceType.toLowerCase().contains("tab") || deviceType.equalsIgnoreCase("Google Nexus 9") || deviceType.toLowerCase().contains("ipad")) {
            whatwasDamagedAutoCompleteMobile = whatwasDamagedAutoComplete;
        }
        int damagedItemsCommonFieldsIndex = addAndRetrieveDamagedItemsCommonFieldsIndex();
        if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
            selectLookupValue(textBoxWhatwasDamaged.get(damagedItemsCommonFieldsIndex), whatwasDamagedAutoCompleteMobile, _generateTestData.generateValidData("whatWasDamaged.damagedItem"), false);
        } else {
            selectLookupValue(textBoxWhatwasDamaged.get(damagedItemsCommonFieldsIndex), whatwasDamagedAutoComplete, _generateTestData.generateValidData("whatWasDamaged.damagedItem"), false);
        }

    }

    public void clickOnAddDamagedItem() {
        waitAndclickElementUsingJS(buttonAddDamagedItem);
        int damagedItemsCommonFieldsIndex = addAndRetrieveDamagedItemsCommonFieldsIndex();
        _persistentData.setContext("damagedItemsCommonFieldsIndex", damagedItemsCommonFieldsIndex + 1);
    }

    public void selectDamagedItemOwnerFromDropDown() {
        int damagedItemsCommonFieldsIndex = addAndRetrieveDamagedItemsCommonFieldsIndex();
        selectFromDropDownbyValue(dropDownWhoOwnsDamagedItem.get(damagedItemsCommonFieldsIndex), _generateTestData.generateValidData("whatWasDamaged.owner.value"));
    }

    public void selectDamagedItemOwnerFromDropDown(String owner) {
        int damagedItemsCommonFieldsIndex = addAndRetrieveDamagedItemsCommonFieldsIndex();
        selectFromDropDownbyValue(dropDownWhoOwnsDamagedItem.get(damagedItemsCommonFieldsIndex), owner);
        waitAndClickElement(textBoxWhatwasDamaged.get(damagedItemsCommonFieldsIndex));
    }

    public void selectDamagedItemOwnerFromDropDownMobile(String owner) {
        int damagedItemsCommonFieldsIndex = addAndRetrieveDamagedItemsCommonFieldsIndex();
        selectFromDropDownbyValue(dropDownWhoOwnsDamagedItem.get(damagedItemsCommonFieldsIndex), owner);
    }

    public List<WebElement> getRemainingDamagedItemsSectionAfterDeletion() {
        return sectionDamagedItems;
    }

    public List<WebElement> indicateAddAdditionalDamagedItems() {
        waitAndclickElementUsingJS(buttonAddDamagedItem);
        isElementDisplayed(buttonDeleteItem);
        int damagedItemsCommonFieldsIndex = addAndRetrieveDamagedItemsCommonFieldsIndex();
        _persistentData.setContext("damagedItemsCommonFieldsIndex", damagedItemsCommonFieldsIndex + 1);
        return textBoxHowWasitDamaged;
    }

    public void clickOnDeleteDamagedItem() {
        waitAndclickElementUsingJS(buttonDeleteItem);
        waitForPageComponentLoadFluentWait();
    }


    public void validateDamagedVehicleOwnerDetails(String[] expectedList) {
        int damagedVehiclesCommonFieldsIndex = addAndRetrieveDamagedVehiclesCommonFieldsIndex();
        List<WebElement> dropDownValues = getAllListValuesInDropDown(dropDownWhoOwnsDamagedVehicle.get(damagedVehiclesCommonFieldsIndex));
        validateDropDownListValues(dropDownValues, expectedList);
    }

    public void validateDamagedItemsOwnerDetails(String[] expectedList) {
        int damagedVehiclesCommonFieldsIndex = addAndRetrieveDamagedVehiclesCommonFieldsIndex();
        List<WebElement> dropDownValues = getAllListValuesInDropDown(dropDownWhoOwnsDamagedItem.get(damagedVehiclesCommonFieldsIndex));
        validateDropDownListValues(dropDownValues, expectedList);
    }


    public void keyInHowWasItDamagedData() {

        int damagedItemsCommonFieldsIndex = addAndRetrieveDamagedItemsCommonFieldsIndex();
        sendKeysToWebElement(textBoxHowWasitDamaged.get(damagedItemsCommonFieldsIndex), _generateTestData.generateValidData("whatWasDamaged.howWasItDamaged"));
    }

    public void keyInDamagedItemOwnerFirstName(String firstName) {
        int damagedItemsOwnerSomeOneElseIndex = addAndRetrieveDamagedItemOwnerSomeOneElseIndex();
        sendKeysToWebElement(textBoxDamagedItemOwnerFirstName.get(damagedItemsOwnerSomeOneElseIndex), firstName);
    }

    public void keyInDamagedItemOwnerMiddleName(String middleName) {
        int damagedItemsOwnerSomeOneElseIndex = addAndRetrieveDamagedItemOwnerSomeOneElseIndex();
        sendKeysToWebElement(textBoxDamagedItemOwnerMiddleName.get(damagedItemsOwnerSomeOneElseIndex), middleName);
    }

    public void keyInDamagedItemOwnerLastName(String lastName) {
        int damagedItemsOwnerSomeOneElseIndex = addAndRetrieveDamagedItemOwnerSomeOneElseIndex();
        sendKeysToWebElement(textBoxDamagedItemOwnerLastName.get(damagedItemsOwnerSomeOneElseIndex), lastName);
        _persistentData.setContext("damagedItemsOwnerSomeOneElseIndex", damagedItemsOwnerSomeOneElseIndex + 1);
    }

    public void keyInDamagedItemOwnerOrganisationName(String organisationName) {
        int damagedItemsOrganisationOwnerIndex = addAndRetrieveDamagedItemOrganisationOwnerIndex();
        sendKeysToWebElement(textBoxDamagedItemOrganisationName.get(damagedItemsOrganisationOwnerIndex), organisationName);
        _persistentData.setContext("damagedItemsOrganisationOwnerIndex", damagedItemsOrganisationOwnerIndex + 1);
    }

    public void keyInDamagedItemOwnerOrganisationNameMobile(String organisationName) {
        int damagedItemsOrganisationOwnerIndex = addAndRetrieveDamagedItemOrganisationOwnerIndex();
        sendKeysToWebElement(getTextBoxDamagedItemOrganisationNameMobile.get(damagedItemsOrganisationOwnerIndex), organisationName);
        _persistentData.setContext("damagedItemsOrganisationOwnerIndex", damagedItemsOrganisationOwnerIndex + 1);
    }


    public int addAndRetrieveDamagedVehiclesCommonFieldsIndex() {
        int damagedVehiclesCommonFieldsIndex = 0;
        try {
            damagedVehiclesCommonFieldsIndex = (int) _persistentData.getContext("damagedVehiclesCommonFieldsIndex");
        } catch (Exception e) {
            _persistentData.setContext("damagedVehiclesCommonFieldsIndex", damagedVehiclesCommonFieldsIndex);
        }
        return damagedVehiclesCommonFieldsIndex;
    }

    public int addAndRetrieveDamagedVehicleOwnerSomeOneElseIndex() {
        int damagedVehiclesOwnerSomeOneElseIndex = 0;
        try {
            damagedVehiclesOwnerSomeOneElseIndex = (int) _persistentData.getContext("damagedVehiclesOwnerSomeOneElseIndex");
        } catch (Exception e) {
            _persistentData.setContext("damagedVehiclesOwnerSomeOneElseIndex", damagedVehiclesOwnerSomeOneElseIndex);
        }
        return damagedVehiclesOwnerSomeOneElseIndex;
    }

    public int addAndRetrieveDamagedVehicleOrganisationOwnerIndex() {
        int damagedVehiclesOrganisationOwnerIndex = 0;
        try {
            damagedVehiclesOrganisationOwnerIndex = (int) _persistentData.getContext("damagedVehiclesOrganisationOwnerIndex");
        } catch (Exception e) {
            _persistentData.setContext("damagedVehiclesOrganisationOwnerIndex", damagedVehiclesOrganisationOwnerIndex);
        }
        return damagedVehiclesOrganisationOwnerIndex;
    }

    public int addAndRetrieveDamagedItemsCommonFieldsIndex() {
        int damagedItemsCommonFieldsIndex = 0;
        try {
            damagedItemsCommonFieldsIndex = (int) _persistentData.getContext("damagedItemsCommonFieldsIndex");
        } catch (Exception e) {
            _persistentData.setContext("damagedItemsCommonFieldsIndex", damagedItemsCommonFieldsIndex);
        }
        return damagedItemsCommonFieldsIndex;
    }

    public int addAndRetrieveDamagedItemOwnerSomeOneElseIndex() {
        int damagedItemsOwnerSomeOneElseIndex = 0;
        try {
            damagedItemsOwnerSomeOneElseIndex = (int) _persistentData.getContext("damagedItemsOwnerSomeOneElseIndex");
        } catch (Exception e) {
            _persistentData.setContext("damagedItemsOwnerSomeOneElseIndex", damagedItemsOwnerSomeOneElseIndex);
        }
        return damagedItemsOwnerSomeOneElseIndex;
    }

    public int addAndRetrieveDamagedItemOrganisationOwnerIndex() {
        int damagedItemsOrganisationOwnerIndex = 0;
        try {
            damagedItemsOrganisationOwnerIndex = (int) _persistentData.getContext("damagedItemsOrganisationOwnerIndex");
        } catch (Exception e) {
            _persistentData.setContext("damagedItemsOrganisationOwnerIndex", damagedItemsOrganisationOwnerIndex);
        }
        return damagedItemsOrganisationOwnerIndex;
    }

    public void selectDamagedVehicleWherewasIt() {
        selectFromDropDownbyValue(dropDownWhereWasDamagedVehicle, _generateTestData.generateValidData("damagedVehicles.damagedVehicleLocation"));
    }

    public void mandatoryFieldErrorForWhereWasDamamgedVehicle() {
        waitForPageComponentLoadFluentWait();
        isElementDisplayed(whereWasDamagedVehicleError);
    }

    public void validateDropDownWhereWasDamagedvehicleValues(String[] expectedList) {
        List<WebElement> dropDownValues = getAllListValuesInDropDown(dropDownWhereWasDamagedVehicle);
        validateDropDownListValues(dropDownValues, expectedList);
    }

    public void validatePlaceholderTextAndLabelForHowAndWhereVehicleDamaged(String placeholderText, String labelText) {
        Assert.assertEquals(labelHowAndWhereWasItDamaged.get(0).getText().trim(), labelText);
        Assert.assertEquals(getAttributeValue(textHowWasVehicleDamaged.get(0), "placeholder"), placeholderText);
    }
}






