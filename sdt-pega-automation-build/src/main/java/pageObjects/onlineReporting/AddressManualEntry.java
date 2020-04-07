package pageObjects.onlineReporting;

import libs.BasePage;
import libs.ExecutionDeviceConfiguration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class AddressManualEntry extends BasePage {

    private @FindBy(xpath = "//input[@data-test-id='201904111522500376683985']")
    List<WebElement> dropDownunitType = null;
    private @FindBy(xpath = "//table[@pl_prop_class='Police-Data-NIA-Reference' and contains(@grid_ref_page, 'FreeFormAddress')]//tr[contains(@oaargs, 'Police-Data-NIA-Reference') and contains(@oaargs,'UnitType')]")
    List<WebElement> unitTypeAutoCompleteList = null;
    private @FindBy(xpath = "//input[@data-test-id='201904111522500377684750']")
    List<WebElement> textBoxunitNumber = null;
    private @FindBy(xpath = "//input[@data-test-id='201904111522500378687291']")
    List<WebElement> textBoxstreetNumber = null;
    private @FindBy(xpath = "//input[@data-test-id='201904111522500379688406']")
    List<WebElement> textBoxstreetName = null;
    private @FindBy(xpath = "//input[@data-test-id='201904111522500380689446' and contains(@name,'StreetType')]")
    List<WebElement> textBoxstreetType = null;
    private @FindBy(xpath = "//table[@pl_prop_class='Police-Data-NIA-Reference' and contains(@grid_ref_page, 'FreeFormAddress')]//tr[contains(@oaargs,'StreetType')]")
    List<WebElement> streetTypeAutoCompleteList = null;
    private @FindBy(xpath = "//input[@data-test-id='201904111522500380689446' and contains(@name,'StreetDirection')]")
    List<WebElement> textBoxStreetDirection = null;
    private @FindBy(xpath = "//table[@pl_prop_class='Police-Data-NIA-Reference' and contains(@grid_ref_page, 'FreeFormAddress')]//tr[contains(@oaargs,'StreetDirection')]")
    List<WebElement> streetDirectionAutoCompleteList = null;
    private @FindBy(xpath = "//input[@data-test-id='201904111527000430464605']")
    List<WebElement> textBoxtownSuburb = null;
    private @FindBy(xpath = "//table[@pl_prop_class='Police-Data-NIA-Reference' and contains(@grid_ref_page, 'FreeFormAddress')]//tr[contains(@oaargs, 'TownSuburb')]")
    List<WebElement> townSuburbAutoCompleteList = null;
    private @FindBy(xpath = "//div[@class='autocomplete-results']//li[contains(@class,'ac-item')]")
    List<WebElement> townSuburbAutoCompleteListMobile = null;
    private @FindBy(xpath = "//span[@data-test-id='201904111527000431465607']")
    List<WebElement> dropDownNonEditableCountry = null;
    private @FindBy(xpath = "//select[@data-test-id='201904111527000431465607']")
    List<WebElement> dropDownEditableCountry = null;
    private @FindBy(xpath = "//select[@data-test-id='20191004154734078935100']")
    List<WebElement> dropDownCloseToThisAddress = null;


    //Reporter
    private @FindBy(xpath = "//div[@data-test-id='201904241255380732246']//input[@data-test-id='201904111522500376683985']")
    List<WebElement> dropDownReporterUnitType = null;
    private @FindBy(xpath = "//div[@data-test-id='201904241255380732246']//input[@data-test-id='201904111522500377684750']")
    List<WebElement> textBoxReporterUnitNumber = null;
    private @FindBy(xpath = "//div[@data-test-id='201904241255380732246']//input[@data-test-id='201904111522500378687291']")
    List<WebElement> textBoxReporterStreetNumber = null;
    private @FindBy(xpath = "//div[@data-test-id='201904241255380732246']//input[@data-test-id='201904111522500379688406']")
    List<WebElement> textBoxReporterStreetName = null;
    private @FindBy(xpath = "//div[@data-test-id='201904241255380732246']//input[@data-test-id='201904111522500380689446']")
    List<WebElement> textBoxReporterStreetType = null;
    private @FindBy(xpath = "//div[@data-test-id='201904241255380732246']//input[@data-test-id='201904111527000430464605']")
    List<WebElement> textBoxReporterTownSuburb = null;
    private @FindBy(xpath = "//table[@pl_prop_class='Police-Data-NIA-Reference' and contains(@grid_ref_page, 'FreeFormAddress')]//tr[contains(@oaargs, 'Police-Data-NIA-Reference')]")
    List<WebElement> townSuburbReporterAutoCompleteList = null;
    private @FindBy(xpath = "//div[@class='autocomplete-results']//li[contains(@class,'ac-item')]")
    List<WebElement> townSuburbReporterAutoCompleteListMobile = null;
    private @FindBy(xpath = "//div[@data-test-id='201904241255380732246']//span[@data-test-id='201904111527000431465607']")
    List<WebElement> dropDownReporterNonEditableCountry = null;
    private @FindBy(xpath = "//div[@data-test-id='201904241255380732246']//select[@data-test-id='201904111527000431465607']")
    List<WebElement> dropDownReporterEditableCountry = null;
    private @FindBy(xpath = "//div[@data-test-id='20190827120614093039571']//input[@value='International']")
    List<WebElement> tabReporterInternational = null;
    private @FindBy(xpath = "//input[@data-test-id='20190726160046054615911']")
    List<WebElement> textBoxReporterInternationalTownSuburb = null;

    //SomeOneElseDoesOwner
    private @FindBy(xpath = "//div[@data-test-id='20190603123222031840']//input[@data-test-id='201904111522500376683985']")
    List<WebElement> dropDownSomeOneElseDoesOwnerUnitType = null;
    private @FindBy(xpath = "//div[@data-test-id='20190603123222031840']//input[@data-test-id='201904111522500377684750']")
    List<WebElement> textBoxSomeOneElseDoesOwnerUnitNumber = null;
    private @FindBy(xpath = "//div[@data-test-id='20190603123222031840']//input[@data-test-id='201904111522500378687291']")
    List<WebElement> textBoxSomeOneElseDoesOwnerStreetNumber = null;
    private @FindBy(xpath = "//div[@data-test-id='20190603123222031840']//input[@data-test-id='201904111522500379688406']")
    List<WebElement> textBoxSomeOneElseDoesOwnerStreetName = null;
    private @FindBy(xpath = "//div[@data-test-id='20190603123222031840']//input[@data-test-id='201904111522500380689446']")
    List<WebElement> textBoxSomeOneElseDoesOwnerStreetType = null;
    private @FindBy(xpath = "//div[@data-test-id='20190603123222031840']//input[@data-test-id='201904111527000430464605']")
    List<WebElement> textBoxSomeOneElseDoesOwnerTownSuburb = null;
    private @FindBy(xpath = "//table[@pl_prop_class='Police-Data-NIA-Reference' and contains(@grid_ref_page, 'FreeFormAddress')]//tr[contains(@oaargs, 'Police-Data-NIA-Reference')]")
    List<WebElement> townSuburbSomeOneElseDoesOwnerAutoCompleteList = null;
    private @FindBy(xpath = "//div[@data-test-id='20190603123222031840']//span[@data-test-id='201904111527000431465607']")
    List<WebElement> dropDownSomeOneElseDoesOwnerNonEditableCountry = null;
    private @FindBy(xpath = "//div[@data-test-id='20190603123222031840']//select[@data-test-id='201904111527000431465607']")
    List<WebElement> dropDownSomeOneElseDoesOwnerEditableCountry = null;
    private @FindBy(xpath = "//div[@data-test-id='20190603123222031840']//input[@data-test-id='201904111522500380689446' and contains(@name,'StreetDirection')]")
    List<WebElement> textBoxStreetDirectionSomeoneElse = null;

    //OrganisationDoesOwner
    private @FindBy(xpath = "//div[@data-test-id='201905091206250186440']//input[@data-test-id='201904111522500376683985']")
    List<WebElement> dropDownOrganisationDoesOwnerUnitType = null;
    private @FindBy(xpath = "//div[@data-test-id='201905091206250186440']//input[@data-test-id='201904111522500377684750']")
    List<WebElement> textBoxOrganisationDoesOwnerUnitNumber = null;
    private @FindBy(xpath = "//div[@data-test-id='201905091206250186440']//input[@data-test-id='201904111522500378687291']")
    List<WebElement> textBoxOrganisationDoesOwnerStreetNumber = null;
    private @FindBy(xpath = "//div[@data-test-id='201905091206250186440']//input[@data-test-id='201904111522500379688406']")
    List<WebElement> textBoxOrganisationDoesOwnerStreetName = null;
    private @FindBy(xpath = "//div[@data-test-id='201905091206250186440']//input[@data-test-id='201904111522500380689446']")
    List<WebElement> textBoxOrganisationDoesOwnerStreetType = null;
    private @FindBy(xpath = "//div[@data-test-id='201905091206250186440']//input[@data-test-id='201904111527000430464605']")
    List<WebElement> textBoxOrganisationDoesOwnerTownSuburb = null;
    private @FindBy(xpath = "//table[@pl_prop_class='Police-Data-NIA-Reference' and contains(@grid_ref_page, 'FreeFormAddress')]//tr[contains(@oaargs, 'Police-Data-NIA-Reference')]")
    List<WebElement> townSuburbOrganisationDoesOwnerAutoCompleteList = null;
    private @FindBy(xpath = "//div[@data-test-id='201905091206250186440']//span[@data-test-id='201904111527000431465607']")
    List<WebElement> dropDownOrganisationDoesOwnerNonEditableCountry = null;
    private @FindBy(xpath = "//div[@data-test-id='201905091206250186440']//select[@data-test-id='201904111527000431465607']")
    List<WebElement> dropDownOrganisationDoesOwnerEditableCountry = null;
    private @FindBy(xpath = "//div[@data-test-id='201905091206250186440']//input[@data-test-id='201904111522500380689446' and contains(@name,'StreetDirection')]")
    List<WebElement> textBoxStreetDirectionOrganisation = null;


    public void selectLocationUnitType(int index) {
        selectLookupValue(dropDownunitType.get(index), unitTypeAutoCompleteList, _generateTestData.generateValidData("cantFindAddress.unitType"),false);
    }

    public void validateLocationUnitTypeList(int index, String[] expectedList) {
        List<WebElement> dropDownValues = getAllListValuesInDropDown(dropDownunitType.get(index));
        validateDropDownListValues(dropDownValues, expectedList);
    }

    public void keyInLocationUnitNumber(int index) {
        sendKeysToWebElement(textBoxunitNumber.get(index), _generateTestData.generateValidData("cantFindAddress.unitNumber"));
    }

    public void keyInLocationStreetNumber(int index) {
        sendKeysToWebElement(textBoxstreetNumber.get(index), _generateTestData.generateValidData("cantFindAddress.streetNumber"));
    }

    public void keyInLocationStreetName(int index) {
        sendKeysToWebElement(textBoxstreetName.get(index), _generateTestData.generateValidData("cantFindAddress.streetName"));
    }

    public void keyInLocationStreetType(int index) {
        selectLookupValue(textBoxstreetType.get(index),streetTypeAutoCompleteList,_generateTestData.generateValidData("cantFindAddress.streetType"),false);
    }

    public void keyInLocationStreetDirection(int index) {
        selectLookupValue(textBoxStreetDirection.get(index),streetDirectionAutoCompleteList,_generateTestData.generateValidData("cantFindAddress.streetDirection"),false);
    }


    public void keyInLocationTownSuburb(int index) {
        executionDeviceConfiguration = new ExecutionDeviceConfiguration(getDeviceKey());
        String deviceType = executionDeviceConfiguration.getDeviceParameters("DEVICE");
        if (deviceType.toLowerCase().contains("tab") || deviceType.equalsIgnoreCase("Google Nexus 9") || deviceType.toLowerCase().contains("ipad")) {
            townSuburbAutoCompleteListMobile = townSuburbAutoCompleteList;
        }
        if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
            selectLookupValue(textBoxtownSuburb.get(index), townSuburbAutoCompleteListMobile, _generateTestData.generateValidData("cantFindAddress.townSuburb"), false);
        } else {
            selectLookupValue(textBoxtownSuburb.get(index), townSuburbAutoCompleteList, _generateTestData.generateValidData("cantFindAddress.townSuburb"), false);
        }
    }

    public void checkCountryFieldIsPopulatedByDefaultLocation(int index) {
        isElementDisplayed(dropDownNonEditableCountry.get(index));
        Assert.assertEquals(waitandGetText(dropDownNonEditableCountry.get(index)), "New Zealand", "Invalid country populated by default");
    }

    public void keyInLocationAddressManually(int index) {
        String addressUnitList[] = _generateTestData.generateListData("cantFindAddress.unitType");
        //_addressManualEntry.validateLocationUnitTypeList(index, addressUnitList);//Removed as it is now a lookup
        _addressManualEntry.selectLocationUnitType(index);
        _addressManualEntry.keyInLocationUnitNumber(index);
        _addressManualEntry.keyInLocationStreetNumber(index);
        _addressManualEntry.keyInLocationStreetName(index);
        _addressManualEntry.keyInLocationStreetType(index);
        _addressManualEntry.keyInLocationStreetDirection(index);
        _addressManualEntry.keyInLocationTownSuburb(index);
    }



    //Reporter

    public void selectReporterUnitType(int index) {
        selectLookupValue(dropDownReporterUnitType.get(index), unitTypeAutoCompleteList, _generateTestData.generateValidData("cantFindAddress.unitType"),false);
    }

    public void validateReporterUnitTypeList(int index, String[] expectedList) {
        List<WebElement> dropDownValues = getAllListValuesInDropDown(dropDownReporterUnitType.get(index));
        validateDropDownListValues(dropDownValues, expectedList);
    }

    public void keyInReporterUnitNumber(int index) {
        sendKeysToWebElement(textBoxReporterUnitNumber.get(index), _generateTestData.generateValidData("cantFindAddress.unitNumber"));
    }

    public void keyInReporterStreetNumber(int index) {
        sendKeysToWebElement(textBoxReporterStreetNumber.get(index), _generateTestData.generateValidData("cantFindAddress.streetNumber"));
    }

    public void keyInReporterStreetName(int index) {
        sendKeysToWebElement(textBoxReporterStreetName.get(index), _generateTestData.generateValidData("cantFindAddress.streetName"));
    }

    public void keyInReporterStreetType(int index) {
        selectLookupValue(textBoxReporterStreetType.get(index),streetTypeAutoCompleteList, _generateTestData.generateValidData("cantFindAddress.streetType"),false);
    }


    public void keyInReporterTownSuburb(int index) {
        executionDeviceConfiguration = new ExecutionDeviceConfiguration(getDeviceKey());
        String deviceType = executionDeviceConfiguration.getDeviceParameters("DEVICE");
        if (deviceType.toLowerCase().contains("tab") || deviceType.equalsIgnoreCase("Google Nexus 9") || deviceType.toLowerCase().contains("ipad")) {
            townSuburbReporterAutoCompleteListMobile = townSuburbReporterAutoCompleteList;
        }
        if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
            selectLookupValue(textBoxReporterTownSuburb.get(index), townSuburbReporterAutoCompleteListMobile, _generateTestData.generateValidData("cantFindAddress.townSuburb"), false);
        } else {
            selectLookupValue(textBoxReporterTownSuburb.get(index), townSuburbReporterAutoCompleteList, _generateTestData.generateValidData("cantFindAddress.townSuburb"), false);
        }
    }

    public void keyInReporterTownSuburbInternationalAddress(int index) {
        _addressManualEntry.keyInReporterInternationalTownSuburb(index);
    }

    public void keyInReporterAddressManually(int index, boolean isAddressInternational) {
        String addressUnitList[] = _generateTestData.generateListData("cantFindAddress.unitType");
        //_addressManualEntry.validateReporterUnitTypeList(index, addressUnitList);//Unit Type is no longer drop down
        _addressManualEntry.selectReporterUnitType(index);
        _addressManualEntry.keyInReporterUnitNumber(index);
        _addressManualEntry.keyInReporterStreetNumber(index);
        _addressManualEntry.keyInReporterStreetName(index);
        _addressManualEntry.keyInReporterStreetType(index);
        _addressManualEntry.keyInLocationStreetDirection(index);
        if (isAddressInternational) {
            _addressManualEntry.keyInReporterTownSuburbInternationalAddress(index);
            _addressManualEntry.verifyCountryFieldIsEditableForReporterAndOwner(index);
        } else {
            _addressManualEntry.keyInReporterTownSuburb(index);
        }

    }

    //SomeOneElseDoes Owner

    public void selectSomeOneElseDoesOwnerUnitType(int index) {
        selectLookupValue(dropDownSomeOneElseDoesOwnerUnitType.get(index),unitTypeAutoCompleteList, _generateTestData.generateValidData("cantFindAddress.unitType"),false);
    }

    public void validateSomeOneElseDoesOwnerUnitTypeList(int index, String[] expectedList) {
        List<WebElement> dropDownValues = getAllListValuesInDropDown(dropDownSomeOneElseDoesOwnerUnitType.get(index));
        validateDropDownListValues(dropDownValues, expectedList);
    }

    public void keyInSomeOneElseDoesOwnerUnitNumber(int index) {
        sendKeysToWebElement(textBoxSomeOneElseDoesOwnerUnitNumber.get(index), _generateTestData.generateValidData("cantFindAddress.unitNumber"));
    }

    public void keyInSomeOneElseDoesOwnerStreetNumber(int index) {
        sendKeysToWebElement(textBoxSomeOneElseDoesOwnerStreetNumber.get(index), _generateTestData.generateValidData("cantFindAddress.streetNumber"));
    }

    public void keyInSomeOneElseDoesOwnerStreetName(int index) {
        sendKeysToWebElement(textBoxSomeOneElseDoesOwnerStreetName.get(index), _generateTestData.generateValidData("cantFindAddress.streetName"));
    }

    public void keyInSomeOneElseDoesOwnerStreetType(int index) {
        selectLookupValue(textBoxSomeOneElseDoesOwnerStreetType.get(index),streetTypeAutoCompleteList, _generateTestData.generateValidData("cantFindAddress.streetType"),false);
    }

    public void keyInSomeOneElseDoesOwnerTownSuburb(int index) {
        selectLookupValue(textBoxSomeOneElseDoesOwnerTownSuburb.get(index), townSuburbSomeOneElseDoesOwnerAutoCompleteList, _generateTestData.generateValidData("cantFindAddress.townSuburb"), false);
    }
    public void keyInSomeOneElseStreetDirection(int index) {
        selectLookupValue(textBoxStreetDirectionSomeoneElse.get(index),streetDirectionAutoCompleteList,_generateTestData.generateValidData("cantFindAddress.streetDirection"),false);
    }

    public void keyInSomeOneElseDoesOwnerAddressManually(int index) {
        String addressUnitList[] = _generateTestData.generateListData("cantFindAddress.unitType");
        //_addressManualEntry.validateSomeOneElseDoesOwnerUnitTypeList(index, addressUnitList);//unit type no longer dropdown
        _addressManualEntry.selectSomeOneElseDoesOwnerUnitType(index);
        _addressManualEntry.keyInSomeOneElseDoesOwnerUnitNumber(index);
        _addressManualEntry.keyInSomeOneElseDoesOwnerStreetNumber(index);
        _addressManualEntry.keyInSomeOneElseDoesOwnerStreetName(index);
        _addressManualEntry.keyInSomeOneElseDoesOwnerStreetType(index);
        _addressManualEntry.keyInSomeOneElseStreetDirection(index);
        _addressManualEntry.keyInSomeOneElseDoesOwnerTownSuburb(index);
    }

    public void keyInSomeOneElseDoesOwnerAddressManually(int index, boolean isAddressInternational) {
        String addressUnitList[] = _generateTestData.generateListData("cantFindAddress.unitType");
        //_addressManualEntry.validateSomeOneElseDoesOwnerUnitTypeList(index, addressUnitList);
        _addressManualEntry.selectSomeOneElseDoesOwnerUnitType(index);
        _addressManualEntry.keyInSomeOneElseDoesOwnerUnitNumber(index);
        _addressManualEntry.keyInSomeOneElseDoesOwnerStreetNumber(index);
        _addressManualEntry.keyInSomeOneElseDoesOwnerStreetName(index);
        _addressManualEntry.keyInSomeOneElseDoesOwnerStreetType(index);
        _addressManualEntry.keyInSomeOneElseStreetDirection(index);
        if (isAddressInternational) {
            sendKeysToWebElement(textBoxSomeOneElseDoesOwnerTownSuburb.get(index), _generateTestData.generateValidData("cantFindAddress.townSuburb"));
            _addressManualEntry.verifyCountryFieldIsEditableForReporterAndOwner(index);
        } else {
            _addressManualEntry.keyInSomeOneElseDoesOwnerTownSuburb(index);
        }
    }


    //Organisation Owner

    public void selectOrganisationDoesOwnerUnitType(int index) {
        selectLookupValue(dropDownOrganisationDoesOwnerUnitType.get(index),unitTypeAutoCompleteList, _generateTestData.generateValidData("cantFindAddress.unitType"),false);
    }

    public void validateOrganisationDoesOwnerUnitTypeList(int index, String[] expectedList) {
        List<WebElement> dropDownValues = getAllListValuesInDropDown(dropDownOrganisationDoesOwnerUnitType.get(index));
        validateDropDownListValues(dropDownValues, expectedList);
    }

    public void keyInOrganisationDoesOwnerUnitNumber(int index) {
        sendKeysToWebElement(textBoxOrganisationDoesOwnerUnitNumber.get(index), _generateTestData.generateValidData("cantFindAddress.unitNumber"));
    }

    public void keyInOrganisationDoesOwnerStreetNumber(int index) {
        sendKeysToWebElement(textBoxOrganisationDoesOwnerStreetNumber.get(index), _generateTestData.generateValidData("cantFindAddress.streetNumber"));
    }

    public void keyInOrganisationDoesOwnerStreetName(int index) {
        sendKeysToWebElement(textBoxOrganisationDoesOwnerStreetName.get(index), _generateTestData.generateValidData("cantFindAddress.streetName"));
    }

    public void keyInOrganisationDoesOwnerStreetType(int index) {
        selectLookupValue(textBoxOrganisationDoesOwnerStreetType.get(index),streetTypeAutoCompleteList, _generateTestData.generateValidData("cantFindAddress.streetType"),false);
    }

    public void keyInOrganisationDoesOwnerTownSuburb(int index) {
        selectLookupValue(textBoxOrganisationDoesOwnerTownSuburb.get(index), townSuburbOrganisationDoesOwnerAutoCompleteList, _generateTestData.generateValidData("cantFindAddress.townSuburb"), false);
    }

    public void validateReporterInternationalCountry(String[] expectedList) {
        List<WebElement> dropDownValues = getAllListValuesInDropDown(dropDownReporterEditableCountry.get(0));
        validateDropDownListValues(dropDownValues, expectedList);
    }

    public void keyInOrganisationStreetDirection(int index) {
        selectLookupValue(textBoxStreetDirectionOrganisation.get(index),streetDirectionAutoCompleteList,_generateTestData.generateValidData("cantFindAddress.streetDirection"),false);
    }

    public void keyInOrganisationDoesOwnerAddressManually(int index) {
        String addressUnitList[] = _generateTestData.generateListData("cantFindAddress.unitType");
        //_addressManualEntry.validateOrganisationDoesOwnerUnitTypeList(index, addressUnitList);
        _addressManualEntry.selectOrganisationDoesOwnerUnitType(index);
        _addressManualEntry.keyInOrganisationDoesOwnerUnitNumber(index);
        _addressManualEntry.keyInOrganisationDoesOwnerStreetNumber(index);
        _addressManualEntry.keyInOrganisationDoesOwnerStreetName(index);
        _addressManualEntry.keyInOrganisationDoesOwnerStreetType(index);
        _addressManualEntry.keyInOrganisationStreetDirection(index);
        _addressManualEntry.keyInOrganisationDoesOwnerTownSuburb(index);
        //_addressManualEntry.verifyCountryFieldIsEditableForReporterAndOwner(index);
    }

    public void verifyCountryFieldIsEditableForReporterAndOwner(int index) {
        Select select = new Select(dropDownEditableCountry.get(index));
        Assert.assertTrue(isElementDisplayed(dropDownEditableCountry.get(index)), "Cannot select values in country field in reporter and owner address");
        Assert.assertTrue(select.getOptions().size() > 1);
        String[] country = _generateTestData.generateListData("cantFindAddress.country");
        _addressManualEntry.validateReporterInternationalCountry(country);
        selectFromDropDownbyValue(dropDownEditableCountry.get(index), _generateTestData.generateValidData("cantFindAddress.country"));
    }

    public void validateManualAddressFields() {
        isElementDisplayed(dropDownunitType.get(0));
        isElementDisplayed(textBoxunitNumber.get(0));
        isElementDisplayed(textBoxstreetNumber.get(0));
        isElementDisplayed(textBoxstreetName.get(0));
        isElementDisplayed(textBoxstreetType.get(0));
        isElementDisplayed(textBoxtownSuburb.get(0));
    }

    public void selectReporterManualAddressTab(int index) {
        waitAndclickElementUsingJS(tabReporterInternational.get(index));
    }

    public void keyInReporterInternationalTownSuburb(int index) {
        sendKeysToWebElement(textBoxReporterInternationalTownSuburb.get(index), "townSuburb");
    }

}
