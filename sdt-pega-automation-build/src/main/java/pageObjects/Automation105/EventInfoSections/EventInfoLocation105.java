package pageObjects.Automation105.EventInfoSections;

import libs.BasePage;
import libs.ExecutionDeviceConfiguration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class EventInfoLocation105 extends BasePage {

    private @FindBy(xpath = "//select[@data-test-id='2019041210453607233329']")
    WebElement dropDownLocationType = null;
    private @FindBy(xpath = "//div[@class='autocomplete-results']//li[contains(@class,'ac-item')]")
    List<WebElement> addressAutoCompleteListMobile = null;
    private @FindBy(xpath = "//table[contains(@pl_prop_class, 'Police-Data-NIA-MasterLocation')]//tr[contains(@oaargs,'Police-Data-NIA-MasterLocation')]")
    List<WebElement> addressAutoCompleteList = null;
    private @FindBy(xpath = "//input[@data-test-id='20190412125223095522377']")
    WebElement textBoxLocationNameShopBusinessSection = null;
    private @FindBy(xpath = "//input[@data-test-id='20190412132543093548630' and @type='checkbox']")
    WebElement checkboxCantFindAddressShopBusinessSection = null;
    private @FindBy(xpath = "//textarea[@data-test-id='2019051015242407606536']")
    WebElement textAreaAdditionalInformation = null;
    private @FindBy(xpath = "//input[@data-test-id='20190412125223095522377']")
    WebElement textBoxLocationNameOrganisationSection = null;
    private @FindBy(xpath = "//textarea[@data-test-id='20190513132454037421702']")
    WebElement textBoxAdditionalInformationHomeSection = null;
    private @FindBy(xpath = "//textarea[@data-test-id='20190510152238060910455']")
    WebElement textBoxAdditionalInformationPublicPlaceSection = null;
    private @FindBy(xpath = "//input[@data-test-id='20190412125223095522377']")
    WebElement textBoxLocationNamePlaceOfWorshipSection = null;
    private @FindBy(xpath = "//textarea[@data-test-id='2019051015242407606536']")
    WebElement textBoxAdditionalInformationPlaceOfWorshipSection = null;
    private @FindBy(xpath = "//input[@data-test-id='20190412125223095522377']")
    WebElement textBoxLocationNamePlaceOfEducationalFacilitySection = null;
    private @FindBy(xpath = "//textarea[@data-test-id='20190430151354052969445']")
    WebElement textBoxAdditionalInformationOtherSection = null;
    private @FindBy(xpath = "//div[@data-test-id='201905161605300538131819']//label[text()='Yes']")
    WebElement toggleStolenItemsInsideVehicleYes = null;
    private @FindBy(xpath = "//input[@data-test-id='201905161612340544705376']")
    WebElement textBoxStolenItemsInsideVehicleLicensePlace = null;
    private @FindBy(xpath = "//div[@data-test-id='201905161605300538131819']//label[text()='No']")
    WebElement toggleStolenItemsInsideVehicleNo = null;
    private @FindBy(xpath = "//select[@data-test-id='201905161612340545706279']")
    WebElement dropDownStolenItemsInsideVehicleVecicleLocation = null;

    private @FindBy(xpath = "//input[@data-test-id='2019031415200802003627']")
    WebElement textBoxEventLocationAddress = null;
    private @FindBy(xpath = "//select[@data-test-id='20191004154734078935100']")
    WebElement dropDownProximityHowCloseToThisAddress = null;
    private @FindBy(xpath = "//button[@data-test-id='20161017110917023176385']")
    WebElement buttonContinueToOffenderInformationMobile = null;

    private boolean addressKeyedInManually = false;

    public void selectEventLocation(String value) {
        selectFromDropDownbyValue(dropDownLocationType, value);
    }

    public void keyInEventLocationAdditionalInformationAndNameOfApplicableEventsTypes(String location) {
        executionDeviceConfiguration = new ExecutionDeviceConfiguration(getDeviceKey());
        String deviceType = executionDeviceConfiguration.getDeviceParameters("DEVICE");
        if (deviceType.toLowerCase().contains("tab") || deviceType.equalsIgnoreCase("Google Nexus 9") || deviceType.toLowerCase().contains("ipad")) {
            addressAutoCompleteListMobile = addressAutoCompleteList;
        }
        switch (location) {
            case "A shop/business":
                keyInDetailsForEventTypeShop();
                break;
            case "An organisation":
                keyInDetailsForEventTypeOrganisation();
                break;
            case "A home":
                keyInDetailsForEventTypeHome();
                break;
            case "A public place":
                keyInDetailsForEventTypePublicPlace();
                break;
            case "Place of worship":
                keyInDetailsForEventTypePlaceOfWorship();
                break;
            case "Educational Facility":
                keyInDetailsForEventTypeEducationalFacility();
                break;
            case "Other":
                keyInDetailsForEventTypeOther();
                break;
            default:
                System.out.println("Location : " + location + " not found in the list. Test failed");
                Assert.assertTrue(false, "Location value entered through the feature files not present in the application");
        }

        if (_persistentData.getStringPersistentData("stolenIndicator").equalsIgnoreCase("yes")) {
            stolenLocationIsVehicle();
        }
    }

    public void clickCantFindAddressCheckBox() {
        addressKeyedInManually = true;
        waitAndclickElementUsingJS(checkboxCantFindAddressShopBusinessSection);
    }

    private void selectHowCloseToThisAddressDidItHappen(WebElement element, String closeToLocation) {
        selectFromDropDownbyValue(element, closeToLocation);
    }

    private void selectDetailsOfStolenItemsFromAVehicle() {
        sendKeysToWebElement(textBoxStolenItemsInsideVehicleLicensePlace, _retrieveTestData.extractDataOffDataFile("eventLocation.stolenFromVehicle.licencePlate"));
        selectFromDropDownbyValue(dropDownStolenItemsInsideVehicleVecicleLocation, _retrieveTestData.extractDataOffDataFile("eventLocation.stolenFromVehicle.vehicleLocation"));
    }

    private void keyInDetailsForEventTypeShop() {
        sendKeysToWebElement(textBoxLocationNameShopBusinessSection, _retrieveTestData.extractDataOffDataFile("eventLocation.nameOfShop"));
        sendKeysToWebElement(textAreaAdditionalInformation, _retrieveTestData.extractDataOffDataFile("eventLocation.additionalDetails"));
    }

    private void keyInDetailsForEventTypeOrganisation() {
        sendKeysToWebElement(textBoxLocationNameOrganisationSection, _retrieveTestData.extractDataOffDataFile("eventLocation.nameOfOrganisation"));
        sendKeysToWebElement(textAreaAdditionalInformation, _retrieveTestData.extractDataOffDataFile("eventLocation.additionalDetails"));
    }

    public void keyInEventLocationAddressUsingLookUp() {
        if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
            selectLookupValue(textBoxEventLocationAddress, addressAutoCompleteListMobile, _retrieveTestData.extractDataOffDataFile("eventLocation.address"), true);
        } else {
            selectLookupValue(textBoxEventLocationAddress, addressAutoCompleteList, _retrieveTestData.extractDataOffDataFile("eventLocation.address"), true);
        }
    }

    /*public void keyInDetailsForEventTypeOrganisationWithSubburbOnly() {
        sendKeysToWebElement(textBoxLocationNameOrganisationSection, _retrieveTestData.extractDataOffDataFile("eventLocation.nameOfOrganisation"));
        clickCantFindAddressCheckBox();
        _addressManualEntry105.keyInLocationAddressManuallySubburbOnly(0);
        selectHowCloseToThisAddressDidItHappen(dropDownHowCloseToThisOrganisationAddress, _retrieveTestData.extractDataOffDataFile("eventLocation.proximity"));
        sendKeysToWebElement(textAreaAdditionalInformation, _retrieveTestData.extractDataOffDataFile("eventLocation.additionalDetails"));
    }*/

    private void keyInDetailsForEventTypeHome() {
        selectHowCloseToThisAddressDidItHappen(dropDownProximityHowCloseToThisAddress, _retrieveTestData.extractDataOffDataFile("eventLocation.proximity"));
        sendKeysToWebElement(textBoxAdditionalInformationHomeSection, _retrieveTestData.extractDataOffDataFile("eventLocation.additionalDetails"));
    }

    private void keyInDetailsForEventTypePublicPlace() {
        sendKeysToWebElement(textBoxAdditionalInformationPublicPlaceSection, _retrieveTestData.extractDataOffDataFile("eventLocation.additionalDetails"));
    }

    private void keyInDetailsForEventTypePlaceOfWorship() {
        sendKeysToWebElement(textBoxLocationNamePlaceOfWorshipSection, _retrieveTestData.extractDataOffDataFile("whereDidItHappen.locationPlaceOfWorship.placeOfWorshipPlace"));
        if (addressKeyedInManually) {
            clickCantFindAddressCheckBox();
            _addressManualEntry.keyInLocationAddressManually(0);
        } else {
            if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
                selectLookupValue(textBoxEventLocationAddress, addressAutoCompleteListMobile, _retrieveTestData.extractDataOffDataFile("whereDidItHappen.locationPlaceOfWorship.placeOfWorshipAddress"), true);
            } else {
                selectLookupValue(textBoxEventLocationAddress, addressAutoCompleteList, _retrieveTestData.extractDataOffDataFile("whereDidItHappen.locationPlaceOfWorship.placeOfWorshipAddress"), true);
            }
        }
        selectHowCloseToThisAddressDidItHappen(dropDownProximityHowCloseToThisAddress, _retrieveTestData.extractDataOffDataFile("whereDidItHappen.locationPlaceOfWorship.addressHowClose"));
        sendKeysToWebElement(textBoxAdditionalInformationPlaceOfWorshipSection, _retrieveTestData.extractDataOffDataFile("whereDidItHappen.locationPlaceOfWorship.placeOfWorshipAdditionalInformation"));
    }

    private void keyInDetailsForEventTypeEducationalFacility() {
        sendKeysToWebElement(textBoxLocationNamePlaceOfEducationalFacilitySection, _retrieveTestData.extractDataOffDataFile("eventLocation.nameOfEducationalFacility"));
        sendKeysToWebElement(textAreaAdditionalInformation, _retrieveTestData.extractDataOffDataFile("eventLocation.additionalDetails"));
    }

    private void keyInDetailsForEventTypeOther() {
        if (addressKeyedInManually) {
            clickCantFindAddressCheckBox();
            _addressManualEntry.keyInLocationAddressManually(0);
        } else {
            if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
                selectLookupValue(textBoxEventLocationAddress, addressAutoCompleteListMobile, _retrieveTestData.extractDataOffDataFile("whereDidItHappen.locationEducationalFacility.educationalFacilityAddress"), true);
            } else {
                selectLookupValue(textBoxEventLocationAddress, addressAutoCompleteList, _retrieveTestData.extractDataOffDataFile("whereDidItHappen.locationEducationalFacility.educationalFacilityAddress"), true);
            }
        }
        selectHowCloseToThisAddressDidItHappen(dropDownProximityHowCloseToThisAddress, _retrieveTestData.extractDataOffDataFile("whereDidItHappen.locationOther.addressHowClose"));
        sendKeysToWebElement(textBoxAdditionalInformationOtherSection, _retrieveTestData.extractDataOffDataFile("whereDidItHappen.locationOther.otherAdditionalInformation"));
    }

    private void stolenLocationIsVehicle() {
        String isStolenItemsTakenFromVehicle;
        isStolenItemsTakenFromVehicle = _retrieveTestData.extractDataOffDataFile("eventLocation.isVehicleStoleIndicator");
        _persistentData.setContext("isStolenItemsTakenFromVehicle", isStolenItemsTakenFromVehicle);
        if (isStolenItemsTakenFromVehicle.equalsIgnoreCase("yes")) {
            waitAndclickElementUsingJS(toggleStolenItemsInsideVehicleYes);
            selectDetailsOfStolenItemsFromAVehicle();
        } else {
            waitAndclickElementUsingJS(toggleStolenItemsInsideVehicleNo);
        }
    }

    public void selectProximityToEventLocation() {
        selectHowCloseToThisAddressDidItHappen(dropDownProximityHowCloseToThisAddress, _retrieveTestData.extractDataOffDataFile("eventLocation.proximity"));
    }

    public void clickOnContinueButtonFromEventLocationPage() {
        waitAndclickElementUsingJS(buttonContinueToOffenderInformationMobile);
    }


}
