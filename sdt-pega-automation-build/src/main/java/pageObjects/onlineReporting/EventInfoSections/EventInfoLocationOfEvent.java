package pageObjects.onlineReporting.EventInfoSections;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import libs.ExecutionDeviceConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.util.List;
import java.util.Set;

public class EventInfoLocationOfEvent extends EventInfo {

    private @FindBy(xpath = "//div[@data-test-id='201905221104240976846']")
    WebElement sectionWhereDidItHappen = null;

    private @FindBy(xpath = "//select[@data-test-id='2019041210453607233329']")
    WebElement dropDownLocationType = null;

    private @FindBy(xpath = "//table[contains(@pl_prop_class, 'Police-Data-NIA-MasterLocation')]//tr[contains(@oaargs,'Police-Data-NIA-MasterLocation')]")
    List<WebElement> addressAutoCompleteList = null;
    private @FindBy(xpath = "//div[@class='autocomplete-results']//li[contains(@class,'ac-item')]")
    List<WebElement> addressAutoCompleteListMobile = null;

    //A shop/business
    private @FindBy(xpath = "//label[@data-test-id='20190412125223095522377-Label']")

    WebElement labelLocationNameShopBusinessSection = null;
    private @FindBy(xpath = "//input[@data-test-id='20190412125223095522377']")
    WebElement textBoxLocationNameShopBusinessSection = null;
    //private @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.widget.Spinner")
    //WebElement textBoxLocationNameShopBusinessSectionAndroid = null;


    private @FindBy(xpath = "//div[@data-test-id='201904121302190541754']//label")
    WebElement labelAddressShopBusinessSection = null;
    private @FindBy(xpath = "//input[@data-test-id='2019031415200802003627']")
    WebElement textBoxAddressShopBusinessSection = null;
    private @FindBy(xpath = "//span[@data-test-id='2019031416193707997247']")
    WebElement labelAddressShopAddressSelected = null;
    private @FindBy(xpath = "//select[@data-test-id='20191004154734078935100']")
    WebElement dropDownHowCloseToThisShopAddress = null;
    private @FindBy(xpath = "//label[@data-test-id='20190412132543093548630-Label']")
    WebElement labelCantFindAddressShopBusinessSection = null;
    private @FindBy(xpath = "//input[@data-test-id='20190412132543093548630' and @type='checkbox']")
    WebElement checkboxCantFindAddressShopBusinessSection = null;
    private @FindBy(xpath = "//label[@data-test-id='2019051015242407606536-Label']")
    WebElement labelAdditionalInformationShopBusinessSection = null;
    private @FindBy(xpath = "//input[@data-test-id='2019051015242407606536']")
    WebElement textBoxAdditionalInformationShopBusinessSection = null;
    private @FindBy(xpath = "//textarea[@data-test-id='2019051015242407606536']")
    WebElement textAreaAdditionalInformation = null;
    private @FindBy(xpath = "//*[@data-test-id='20190906123211025027801']")
    WebElement removeChoosenShopAddress = null;
    private By eventLocationShopBusinessAndroid = MobileBy.xpath("//*[@class='android.widget.CheckedTextView'][2]");
    private By dropDownHowCloseToAddressAndroid = MobileBy.xpath("//*[@resource-id='53f0915c']");
    private By valueHowCloseToAddressAndroid = MobileBy.xpath("//*[@resource-id='android:id/text1'][3]");

    /*private @FindBy(xpath = "//*[@class='android.widget.CheckedTextView'][2]")
    WebElement eventLocationShopBusinessAndroid = null;*/

    //An organisation
    private @FindBy(xpath = "//label[@data-test-id='20190412125223095522377-Label']")
    WebElement labelLocationNameOrganisationSection = null;
    private @FindBy(xpath = "//input[@data-test-id='20190412125223095522377']")
    WebElement textBoxLocationNameOrganisationSection = null;
    private @FindBy(xpath = "//div[@data-test-id='201904121302190541754']//label")
    WebElement labelAddressOrganisationSection = null;
    private @FindBy(xpath = "//input[@data-test-id='2019031415200802003627']")
    WebElement textBoxAddressOrganisationSection = null;
    private @FindBy(xpath = "//select[@data-test-id='20191004154734078935100']")
    WebElement dropDownHowCloseToThisOrganisationAddress = null;
    private @FindBy(xpath = "//label[@data-test-id='20190412132543093548630-Label']")
    WebElement labelCantFindAddressOrganisationSection = null;
    private @FindBy(xpath = "//input[@data-test-id='20190412132543093548630' and @type='checkbox']")
    WebElement checkboxCantFindAddressOrganisationSection = null;
    private @FindBy(xpath = "//label[@data-test-id='2019051015242407606536-Label']")
    WebElement labelAdditionalInformationOrganisationSection = null;
    private @FindBy(xpath = "//input[@data-test-id='2019051015242407606536']")
    WebElement textBoxAdditionalInformationOrganisationSection = null;

    //A home
    private @FindBy(xpath = "//div[@data-test-id='201904121633030492784']//label")
    WebElement labelAddressHomeSection = null;
    private @FindBy(xpath = "//input[@data-test-id='2019031415200802003627']")
    WebElement textBoxAddressHomeSection = null;
    private @FindBy(xpath = "//select[@data-test-id='20191004154734078935100']")
    WebElement dropDownHowCloseToThisHomeAddress = null;
    private @FindBy(xpath = "//label[@data-test-id='20190412164020086823954-Label']")
    WebElement labelCantFindAddressHomeSection = null;
    private @FindBy(xpath = "//input[@data-test-id='20190412164020086823954' and @type='checkbox']")
    WebElement checkboxCantFindAddressHomeSection = null;
    private @FindBy(xpath = "//label[@data-test-id='20190513132454037421702-Label']")
    WebElement labelAdditionalInformationHomeSection = null;
    private @FindBy(xpath = "//textarea[@data-test-id='20190513132454037421702']")
    WebElement textBoxAdditionalInformationHomeSection = null;

    //A public place
    private @FindBy(xpath = "//div[@data-test-id='201904121701150535251']//label")
    WebElement labelAddressPublicPlaceSection = null;
    private @FindBy(xpath = "//input[@data-test-id='2019031415200802003627']")
    WebElement textBoxAddressPublicPlaceSection = null;
    private @FindBy(xpath = "//select[@data-test-id='20191004154734078935100']")
    WebElement dropDownHowCloseToThisPublicPlaceAddress = null;
    private @FindBy(xpath = "//label[@data-test-id='20190412170115053619669-Label']")
    WebElement labelCantFindAddressPublicPlaceSection = null;
    private @FindBy(xpath = "//input[@data-test-id='20190412170115053619669' and @type='checkbox']")
    WebElement checkboxCantFindAddressPublicPlaceSection = null;
    private @FindBy(xpath = "//label[@data-test-id='20190510152238060910455-Label']")
    WebElement labelAdditionalInformationPublicPlaceSection = null;
    private @FindBy(xpath = "//textarea[@data-test-id='20190510152238060910455']")
    WebElement textBoxAdditionalInformationPublicPlaceSection = null;

    //On a journey
    private @FindBy(xpath = "(//div[@data-test-id='201904050032080727903']/../preceding-sibling::label)[1]")
    WebElement labelBeginJourneySection = null;
    private @FindBy(xpath = "//input[@data-test-id='2019031415200802003627' and contains(@name, 'Start')]")
    WebElement textBoxBeginJourneySection = null;
    private @FindBy(xpath = "//label[@data-test-id='20190424150009096074749-Label']")
    WebElement labelCantFindAddressBeginJourneySection = null;
    private @FindBy(xpath = "//input[@data-test-id='20190424150009096074749' and @type='checkbox']")
    WebElement checkBoxCantFindAddressBeginJourneySection = null;
    private @FindBy(xpath = "(//div[@data-test-id='201904050032080727903']/../preceding-sibling::label)[2]")
    WebElement labelEndJourneySection = null;
    private @FindBy(xpath = "//input[@data-test-id='2019031415200802003627' and contains(@name, 'End')]")
    WebElement textBoxEndJourneySection = null;
    private @FindBy(xpath = "//label[@data-test-id='20190424150009096179154-Label']")
    WebElement labelCantFindAddressEndJourneySection = null;
    private @FindBy(xpath = "//input[@data-test-id='20190424150009096179154' and @type='checkbox']")
    WebElement checkBoxCantFindAddressEndJourneySection = null;
    private @FindBy(xpath = "//label[@data-test-id='20190513131445075645871-Label']")
    WebElement labelAdditionalInformationJourneySection = null;
    private @FindBy(xpath = "//textarea[@data-test-id='20190513131445075645871']")
    WebElement textBoxAdditionalInformationJourneySection = null;

    //Place of worship
    private @FindBy(xpath = "//label[@data-test-id='20190412125223095522377-Label']")
    WebElement labelLocationNamePlaceOfWorshipSection = null;
    private @FindBy(xpath = "//input[@data-test-id='20190412125223095522377']")
    WebElement textBoxLocationNamePlaceOfWorshipSection = null;
    private @FindBy(xpath = "//div[@data-test-id='201904121302190541754']//label")
    WebElement labelAddressPlaceOfWorshipSection = null;
    private @FindBy(xpath = "//input[@data-test-id='2019031415200802003627']")
    WebElement textBoxAddressPlaceOfWorshipSection = null;
    private @FindBy(xpath = "//select[@data-test-id='20191004154734078935100']")
    WebElement dropDownHowCloseToThisPlaceOfWorshipAddress = null;
    private @FindBy(xpath = "//label[@data-test-id='20190412132543093548630-Label']")
    WebElement labelCantFindAddressPlaceOfWorshipSection = null;
    private @FindBy(xpath = "//input[@data-test-id='20190412132543093548630' and @type='checkbox']")
    WebElement checkboxCantFindAddressPlaceOfWorshipSection = null;
    private @FindBy(xpath = "//label[@data-test-id='2019051015242407606536-Label']")
    WebElement labelAdditionalInformationPlaceOfWorshipSection = null;
    private @FindBy(xpath = "//textarea[@data-test-id='2019051015242407606536']")
    WebElement textBoxAdditionalInformationPlaceOfWorshipSection = null;

    //Educational Facility
    private @FindBy(xpath = "//label[@data-test-id='20190412125223095522377-Label']")
    WebElement labelLocationNamePlaceOfEducationalFacilitySection = null;
    private @FindBy(xpath = "//input[@data-test-id='20190412125223095522377']")
    WebElement textBoxLocationNamePlaceOfEducationalFacilitySection = null;
    private @FindBy(xpath = "//div[@data-test-id='201904121302190541754']//label")
    WebElement labelAddressPlaceOfEducationalFacilitySection = null;
    private @FindBy(xpath = "//input[@data-test-id='2019031415200802003627']")
    WebElement textBoxAddressPlaceOfEducationalFacilitySection = null;
    private @FindBy(xpath = "//select[@data-test-id='20191004154734078935100']")
    WebElement dropDownHowCloseToThisEducationalFacilityAddress = null;
    private @FindBy(xpath = "//label[@data-test-id='20190412132543093548630-Label']")
    WebElement labelCantFindAddressPlaceOfEducationalFacilitySection = null;
    private @FindBy(xpath = "//input[@data-test-id='20190412132543093548630' and @type='checkbox']")
    WebElement checkboxCantFindAddressPlaceOfEducationalFacilitySection = null;
    private @FindBy(xpath = "//label[@data-test-id='2019051015242407606536-Label']")
    WebElement labelAdditionalInformationPlaceOfEducationalFacilitySection = null;
    private @FindBy(xpath = "//input[@data-test-id='2019051015242407606536']")
    WebElement textBoxAdditionalInformationPlaceOfEducationalFacilitySection = null;

    //Other
    private @FindBy(xpath = "//input[@data-test-id='2019031415200802003627']")
    WebElement textBoxAddressPlaceOfOther = null;
    private @FindBy(xpath = "//label[@data-test-id='20190430151354052969445-Label']")
    WebElement labelAdditionalInformationOtherSection = null;
    private @FindBy(xpath = "//textarea[@data-test-id='20190430151354052969445']")
    WebElement textBoxAdditionalInformationOtherSection = null;
    private @FindBy(xpath = "//select[@data-test-id='20191004154734078935100']")
    WebElement dropDownHowCloseToThisOtherAddress = null;

    //Vechicle
    private @FindBy(xpath = "//label[@data-test-id='201905161605300538131819-Label']")
    WebElement labelStolenItemsInsideVehicle = null;
    private @FindBy(xpath = "//div[@data-test-id='201905161605300538131819']//label[text()='Yes']")
    WebElement toggleStolenItemsInsideVehicleYes = null;
    private @FindBy(xpath = "//div[@data-test-id='201905161605300538131819']//label[text()='No']")
    WebElement toggleStolenItemsInsideVehicleNo = null;
    private @FindBy(xpath = "//label[@data-test-id='201905161612340544705376-Label']")
    WebElement labelStolenItemsInsideVehicleLicensePlace = null;
    private @FindBy(xpath = "//input[@data-test-id='201905161612340544705376']")
    WebElement textBoxStolenItemsInsideVehicleLicensePlace = null;
    private @FindBy(xpath = "//label[@data-test-id='201905161612340545706279-Label']")
    WebElement labelStolenItemsInsideVehicleVehicleLocation = null;
    private @FindBy(xpath = "//select[@data-test-id='201905161612340545706279']")
    WebElement dropDownStolenItemsInsideVehicleVecicleLocation = null;

    private @FindBy(xpath = "//button[@data-test-id='20161017110917023176385']")
    WebElement buttonContinueToOffenderInformationMobile = null;
    private By locationDropDown = MobileBy.xpath("//*[@resource-id='9c3fec2b']");
    private By pickersIOS = MobileBy.className("XCUIElementTypePickerWheel");
    private By nativeDoneButtonIOS = MobileBy.xpath("//XCUIElementTypeButton[@name='Done']");
    private By dropDownLocationIOS = MobileBy.xpath("//XCUIElementTypeOther[@name=\"Process Work Area, main\"]/XCUIElementTypeOther[4]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther");
    private By dropDownCloseToAddress = MobileBy.AccessibilityId("Please select how close to this location the event occurred");
    private @FindBy(xpath = "//*[@id='$PpyWorkPage$pLocationType$pLocationDetails$pFreeFormAddress$pTownSuburbError']")
    WebElement townSuburbMandatoryErrorMessage = null;

    public WebElement getTownSuburbMandatoryErrorMessage() {
        return townSuburbMandatoryErrorMessage;
    }

    private boolean addressKeyedInManually = false;

    public boolean checkIfWhereDidItHappenSectionIsDisplayed() {
        return isElementDisplayed(sectionWhereDidItHappen);
    }

    public void selectLocation(String value) {
        selectFromDropDownbyValue(dropDownLocationType, value);
    }

    public void checkLocationIsDisplayed() {
        isElementDisplayed(dropDownLocationType);
    }

    public WebElement getDropDownHowCloseToThisOtherAddress() {
        return dropDownHowCloseToThisOtherAddress;
    }

    public void keyInRequiredDataOnToWhereDidItHappenSection(String location) {
        keyInLocationDetails(location);
    }

    public void keyInRequiredDataOnToWhereDidItHappenSection(String location, boolean addressToKeyInManually) {
        this.addressKeyedInManually = addressToKeyInManually;
        keyInLocationDetails(location);
    }

    public void chooseShopAddress() {
        //if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
        selectLookupValue(textBoxAddressShopBusinessSection, addressAutoCompleteList, _generateTestData.generateValidData("whereDidItHappen.locationShop.shopAddress"), true);
        //}
    }

    public void removeChoosenShopAddress() {
        waitAndclickElementUsingJS(removeChoosenShopAddress);
    }

    public void clickCantFindAddressCheckBox() {
        waitAndclickElementUsingJS(checkboxCantFindAddressShopBusinessSection);
    }

    public boolean checkAddressAutoCompleteFieldIsInvisible() {
        return isElementNotDisplayed(textBoxAddressShopBusinessSection);
    }

    public boolean checkCantFindAddressIsInvisible() {
        return isElementNotDisplayed(checkboxCantFindAddressShopBusinessSection);
    }

    public String getLocationAdditionalInformationLabel() {
        return waitandGetText(labelAdditionalInformationPublicPlaceSection);
    }

    public boolean checkCantFindAddressIsVisible() {
        return isElementDisplayed(checkboxCantFindAddressShopBusinessSection);
    }

    public boolean checkAddressSuccessfullySelected() {
        boolean addressSelected = isElementDisplayed(labelAddressShopAddressSelected);
        boolean addressTextFieldNotDisplayed = isElementNotDisplayed(textBoxAddressShopBusinessSection);
        return addressSelected && addressTextFieldNotDisplayed;
    }

    public boolean checkAddressSuccessfullyRemoved() {
        boolean addressTextField = isElementDisplayed(textBoxAddressShopBusinessSection);
        boolean addressSelectedNotDisplayed = isElementNotDisplayed(labelAddressShopAddressSelected);
        return addressTextField && addressSelectedNotDisplayed;
    }

    public void keyInLocationDetails(String location) {
        executionDeviceConfiguration = new ExecutionDeviceConfiguration(getDeviceKey());
        String deviceType = executionDeviceConfiguration.getDeviceParameters("DEVICE");
        if (deviceType.toLowerCase().contains("tab") || deviceType.equalsIgnoreCase("Google Nexus 9") || deviceType.toLowerCase().contains("ipad")) {
            addressAutoCompleteListMobile = addressAutoCompleteList;
        }
        switch (location) {
            case "A shop/business":
                sendKeysToWebElement(textBoxLocationNameShopBusinessSection, _generateTestData.generateValidData("whereDidItHappen.locationShop.shopName"));
                if (addressKeyedInManually) {
                    clickCantFindAddressCheckBox();
                    _addressManualEntry.keyInLocationAddressManually(0);
                } else {
                    if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
                        selectLookupValue(textBoxAddressShopBusinessSection, addressAutoCompleteListMobile, _generateTestData.generateValidData("whereDidItHappen.locationShop.shopAddress"), true);
                    } else {
                        selectLookupValue(textBoxAddressShopBusinessSection, addressAutoCompleteList, _generateTestData.generateValidData("whereDidItHappen.locationShop.shopAddress"), true);
                    }
                }
                selectHowCloseToThisAddressDidItHappen(dropDownHowCloseToThisShopAddress, _generateTestData.generateValidData("whereDidItHappen.locationShop.addressHowClose"));
                sendKeysToWebElement(textAreaAdditionalInformation, _generateTestData.generateValidData("whereDidItHappen.locationShop.shopAdditionalInformation"));
                break;
            case "An organisation":
                sendKeysToWebElement(textBoxLocationNameOrganisationSection, _generateTestData.generateValidData("whereDidItHappen.locationOrganisation.organisationName"));
                if (addressKeyedInManually) {
                    clickCantFindAddressCheckBox();
                    _addressManualEntry.keyInLocationAddressManually(0);
                } else {
                    if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
                        selectLookupValue(textBoxAddressOrganisationSection, addressAutoCompleteListMobile, _generateTestData.generateValidData("whereDidItHappen.locationOrganisation.organisationAddress"), true);
                    } else {
                        selectLookupValue(textBoxAddressOrganisationSection, addressAutoCompleteList, _generateTestData.generateValidData("whereDidItHappen.locationOrganisation.organisationAddress"), true);
                    }
                }
                selectHowCloseToThisAddressDidItHappen(dropDownHowCloseToThisOrganisationAddress, _generateTestData.generateValidData("whereDidItHappen.locationOrganisation.addressHowClose"));
                sendKeysToWebElement(textAreaAdditionalInformation, _generateTestData.generateValidData("whereDidItHappen.locationOrganisation.organisationAdditionalInformation"));
                break;
            case "A home":
                if (addressKeyedInManually) {
                    clickCantFindAddressCheckBox();
                    _addressManualEntry.keyInLocationAddressManually(0);
                } else {
                    if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
                        selectLookupValue(textBoxAddressHomeSection, addressAutoCompleteListMobile, _generateTestData.generateValidData("whereDidItHappen.locationHome.homeAddress"), true);
                    } else {
                        selectLookupValue(textBoxAddressHomeSection, addressAutoCompleteList, _generateTestData.generateValidData("whereDidItHappen.locationHome.homeAddress"), true);
                    }
                }
                _persistentData.setContext("homeAddress", _generateTestData.generateValidData("whereDidItHappen.locationHome.homeAddress"));
                selectHowCloseToThisAddressDidItHappen(dropDownHowCloseToThisHomeAddress, _generateTestData.generateValidData("whereDidItHappen.locationHome.addressHowClose"));
                sendKeysToWebElement(textBoxAdditionalInformationHomeSection, _generateTestData.generateValidData("whereDidItHappen.locationHome.homeAdditionalInformation"));

                break;
            case "A public place":
                if (addressKeyedInManually) {
                    clickCantFindAddressCheckBox();
                    _addressManualEntry.keyInLocationAddressManually(0);
                } else {
                    if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
                        selectLookupValue(textBoxAddressPublicPlaceSection, addressAutoCompleteListMobile, _generateTestData.generateValidData("whereDidItHappen.locationPublicPlace.publicAddress"), true);
                    } else {
                        selectLookupValue(textBoxAddressPublicPlaceSection, addressAutoCompleteList, _generateTestData.generateValidData("whereDidItHappen.locationPublicPlace.publicAddress"), true);
                    }
                }
                selectHowCloseToThisAddressDidItHappen(dropDownHowCloseToThisPublicPlaceAddress, _generateTestData.generateValidData("whereDidItHappen.locationPublicPlace.addressHowClose"));
                sendKeysToWebElement(textBoxAdditionalInformationPublicPlaceSection, _generateTestData.generateValidData("whereDidItHappen.locationPublicPlace.publicAddtionalInformation"));
                break;
            case "Place of worship":
                sendKeysToWebElement(textBoxLocationNamePlaceOfWorshipSection, _generateTestData.generateValidData("whereDidItHappen.locationPlaceOfWorship.placeOfWorshipPlace"));
                if (addressKeyedInManually) {
                    clickCantFindAddressCheckBox();
                    _addressManualEntry.keyInLocationAddressManually(0);
                } else {
                    if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
                        selectLookupValue(textBoxAddressPlaceOfWorshipSection, addressAutoCompleteListMobile, _generateTestData.generateValidData("whereDidItHappen.locationPlaceOfWorship.placeOfWorshipAddress"), true);
                    } else {
                        selectLookupValue(textBoxAddressPlaceOfWorshipSection, addressAutoCompleteList, _generateTestData.generateValidData("whereDidItHappen.locationPlaceOfWorship.placeOfWorshipAddress"), true);
                    }
                }
                selectHowCloseToThisAddressDidItHappen(dropDownHowCloseToThisPlaceOfWorshipAddress, _generateTestData.generateValidData("whereDidItHappen.locationPlaceOfWorship.addressHowClose"));
                sendKeysToWebElement(textBoxAdditionalInformationPlaceOfWorshipSection, _generateTestData.generateValidData("whereDidItHappen.locationPlaceOfWorship.placeOfWorshipAdditionalInformation"));
                break;
            case "Educational Facility":
                sendKeysToWebElement(textBoxLocationNamePlaceOfEducationalFacilitySection, _generateTestData.generateValidData("whereDidItHappen.locationEducationalFacility.educationalFacilityName"));
                if (addressKeyedInManually) {
                    clickCantFindAddressCheckBox();
                    _addressManualEntry.keyInLocationAddressManually(0);
                } else {
                    if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
                        selectLookupValue(textBoxAddressPlaceOfEducationalFacilitySection, addressAutoCompleteListMobile, _generateTestData.generateValidData("whereDidItHappen.locationEducationalFacility.educationalFacilityAddress"), true);
                    } else {
                        selectLookupValue(textBoxAddressPlaceOfEducationalFacilitySection, addressAutoCompleteList, _generateTestData.generateValidData("whereDidItHappen.locationEducationalFacility.educationalFacilityAddress"), true);
                    }
                }
                selectHowCloseToThisAddressDidItHappen(dropDownHowCloseToThisEducationalFacilityAddress, _generateTestData.generateValidData("whereDidItHappen.locationEducationalFacility.addressHowClose"));
                sendKeysToWebElement(textAreaAdditionalInformation, _generateTestData.generateValidData("whereDidItHappen.locationEducationalFacility.eductionalFacilityInformation"));
                break;
            case "Other":
                if (addressKeyedInManually) {
                    clickCantFindAddressCheckBox();
                    _addressManualEntry.keyInLocationAddressManually(0);
                } else {
                    if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
                        selectLookupValue(textBoxAddressPlaceOfOther, addressAutoCompleteListMobile, _generateTestData.generateValidData("whereDidItHappen.locationEducationalFacility.educationalFacilityAddress"), true);
                    } else {
                        selectLookupValue(textBoxAddressPlaceOfOther, addressAutoCompleteList, _generateTestData.generateValidData("whereDidItHappen.locationEducationalFacility.educationalFacilityAddress"), true);
                    }
                }
                selectHowCloseToThisAddressDidItHappen(dropDownHowCloseToThisOtherAddress, _generateTestData.generateValidData("whereDidItHappen.locationOther.addressHowClose"));
                sendKeysToWebElement(textBoxAdditionalInformationOtherSection, _generateTestData.generateValidData("whereDidItHappen.locationOther.otherAdditionalInformation"));
                break;
            default:
                System.out.println("Location : " + location + " not found in the list. Test failed");
                Assert.assertTrue(false, "Location value entered through the feature files not present in the application");

        }

        if (_persistentData.getStringPersistentData("stolenIndicator").equalsIgnoreCase("yes")) {
            String isStolenItemsTakenFromVehicle;
            isStolenItemsTakenFromVehicle = _generateTestData.generateValidData("whereDidItHappen.stolenFromVehicle.value");
            _persistentData.setContext("isStolenItemsTakenFromVehicle", isStolenItemsTakenFromVehicle);
            if (isStolenItemsTakenFromVehicle.equalsIgnoreCase("yes")) {
                waitAndclickElementUsingJS(toggleStolenItemsInsideVehicleYes);
                selectDetailsOfStolenItemsFromAVehicle();
            } else {
                waitAndclickElementUsingJS(toggleStolenItemsInsideVehicleNo);
            }
        }


    }


    public void selectDetailsOfStolenItemsFromAVehicle() {
        sendKeysToWebElement(textBoxStolenItemsInsideVehicleLicensePlace, _generateTestData.generateValidData("whereDidItHappen.stolenFromVehicle.licencePlate"));
        selectFromDropDownbyValue(dropDownStolenItemsInsideVehicleVecicleLocation, _generateTestData.generateValidData("whereDidItHappen.stolenFromVehicle.vehicleLocation"));
    }

    public void selectDetailsOfStolenItemsFromAVehicle(String toggle) {
        if (toggle.equalsIgnoreCase("yes")) {
            waitAndclickElementUsingJS(toggleStolenItemsInsideVehicleYes);
            sendKeysToWebElement(textBoxStolenItemsInsideVehicleLicensePlace, _generateTestData.generateValidData("whereDidItHappen.stolenFromVehicle.licencePlate"));
            selectFromDropDownbyValue(dropDownStolenItemsInsideVehicleVecicleLocation, _generateTestData.generateValidData("whereDidItHappen.stolenFromVehicle.vehicleLocation"));
        } else {
            waitAndclickElementUsingJS(toggleStolenItemsInsideVehicleNo);
        }
    }

    public void verifyAllVehicleLocationList(String[] expectedLocationList) {
        List<WebElement> allValues = getAllListValuesInDropDown(dropDownStolenItemsInsideVehicleVecicleLocation);
        validateDropDownListValues(allValues, expectedLocationList);

    }

    public void selectHowCloseToThisAddressDidItHappen(WebElement element, String closeToLocation) {
        selectFromDropDownbyValue(element, closeToLocation);
    }

    public void clickOnButtonToContinueToOffenderInformationMobile() {
        waitAndclickElementUsingJS(buttonContinueToOffenderInformationMobile);
    }


}
