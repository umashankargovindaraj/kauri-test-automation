package features.OnlineReportingMobile.StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libs.DriverFactory;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ContactDetailsMobileSteps extends DriverFactory {

    @When("I key in the details of the reporter")
    public void i_key_in_the_details_of_the_reporter() {
        _contactDetails.keyInReporterFirstName();
        _contactDetails.keyInReporterMiddleName();
        _contactDetails.keyInReporterLastName();
        _contactDetails.keyInReporterDOBMobile();
        _contactDetails.selectReporterGenderMobile();
        _contactDetails.keyInReporterDriverLicenceNumber();
        _contactDetails.selectReporterPreviousNameIndicator();
        _contactDetails.keyInReporterPreviousFirstName();
        _contactDetails.keyInReporterPreviousMiddleName();
        _contactDetails.keyInReporterPreviousLastName();
        _contactDetails.keyInReporterEmailAddress();
        _contactDetails.selectReporterPhoneTypeMobile();
        _contactDetails.keyInReporterPhoneNumber(0);
        _contactDetails.selectPreferredContactMethodMobile();
        _contactDetails.selectAddressTypeMethodMobile();
        _contactDetails.keyInReporterAddress();
    }

    @When("I indicate i need victim support")
    public void i_indicate_victim_support_as() {
        String victimSupport = _contactDetails.getVictimSupportIndicator();
        _contactDetails.selectVictimSupportIndicatorMobile(victimSupport);
    }

    @When("I click on continue in Reporter page to navigate to Summary Page")
    public void I_click_on_continue_in_Reporter_page() {
        _contactDetails.clickOnContinueButtonFromReporterPage();
    }

    @When("I click on continue in Reporter page to navigate to Owner details page")
    public void I_click_on_continue_in_Reporter_page_Owner_details_page() {
        _contactDetails.clickOnContinueButtonFromReporterPage();
    }

    @When("I key in my personal information with manually keyed in address")
    public void i_key_in_my_personal_information_with_manually_keyed_in_address() {
        _contactDetails.keyInDataOnFieldsRelatedToReporterContactDetails(true, false);
    }

    @Then("I should be able to see details of the owner of second lost item prepopulated")
    public void i_should_be_able_to_see_details_of_the_owner_of_second_lost_item_prepopulated() {
        String lostItemOwnerFirstName = (String) _persistentData.getContext("whatWasLost.owner.firstName");
        String expectedLostItemOwnerFirstName = lostItemOwnerFirstName + "'s details";// this is how it's displayed in app
        String actualLostItemOwnerFirstName = _contactDetails.getSomeOneElseOwnerDetailsHeaderMobile();
        Assert.assertEquals(actualLostItemOwnerFirstName, expectedLostItemOwnerFirstName, "Owner first name displayed is incorrect");
    }


    @Then("I should be able to see details of the owner of second damaged Item prepopulated")
    public void i_should_be_able_to_see_details_of_the_owner_of_second_damaged_Item_prepopulated() {
        String damagedItemOwner = (String) _persistentData.getContext("whatWasDamaged.owner.firstName");
        String expectedDamagedItemOwner = damagedItemOwner + "'s details";// this is how it's displayed in app
        String actualDamagedItemOwnerFirstName = _contactDetails.getSomeOneElseOwnerDetailsHeaderMobile();
        Assert.assertEquals(actualDamagedItemOwnerFirstName, expectedDamagedItemOwner, "Owner first name displayed is incorrect");
    }

    public void keyInAddressOfSomebodyElseOwner(int index) {
        _contactDetails.keyInAddressOfOwnerSomeOneElse(index);
    }

    public void keyInAddressOfSomebodyElseOwnerManually(int index) {
        _contactDetails.keyInAddressOfOwnerSomeOneElse(index, true);
    }

    public void keyInAddressOfOrganisationOwner(int index) {
        _contactDetails.keyInAddressOfOrganisationOwner(index);
    }

    public void keyInaddressOfOrganisationOwnerManually(int index) {
        _contactDetails.keyInAddressOfOrganisationOwner(index, true);
    }

    @Then("I should be able to see details of the owner of third stolen Item prepopulated")
    public void i_should_be_able_to_see_details_of_the_owner_of_third_stolen_Item_prepopulated() {
        String stolenItemOwnerOrganisationName = (String) _persistentData.getContext("whatWasStolen.owner.organisationName");
        String expectedStolenOrganisationname = stolenItemOwnerOrganisationName + "'s details"; // this is how it's displayed in app
        String actualStolenOrganisationName = _contactDetails.getOrganisationOwnerDetailsHeaderMobile();
        Assert.assertEquals(actualStolenOrganisationName, expectedStolenOrganisationname, "Organisation owner name is incorrect in contact details page");
    }

    @Then("I should be able to see details of the owner of third damaged Item prepopulated")
    public void i_should_be_able_to_see_details_of_the_owner_of_third_damaged_Item_prepopulated() {
        String damagedItemOwnerOrganisationName = (String) _persistentData.getContext("whatWasDamaged.owner.organisationName");
        String expectedDamagedOrganisationname = damagedItemOwnerOrganisationName + "'s details"; // this is how it's displayed in app
        String actualDamagedOrganisationName = _contactDetails.getOrganisationOwnerDetailsHeaderMobile();
        Assert.assertEquals(actualDamagedOrganisationName, expectedDamagedOrganisationname, "Organisation owner name is incorrect in contact details page");
    }


    @Then("I should be able to see details of the owner of second stolen vehicle prepopulated")
    public void i_should_be_able_to_see_details_of_the_owner_of_second_stolen_vehicle_prepopulated() {
        String stolenVehicleOwnerFirstName = (String) _persistentData.getContext("stolenVehicles.owner.firstName");
        String expectedStolenVehicleOwner = stolenVehicleOwnerFirstName + "'s details";// this is how it's displayed in app
        String actualStolenVehicleOwnerFirstName = _contactDetails.getSomeOneElseOwnerDetailsHeaderMobile();
        Assert.assertEquals(actualStolenVehicleOwnerFirstName, expectedStolenVehicleOwner, "Owner first name displayed is incorrect");
    }

    @Then("I should be able to see details of the owner of second stolen vehicle prepopulated and key in manually entered address")
    public void i_should_be_able_to_see_details_of_the_owner_of_second_stolen_vehicle_prepopulated_and_key_in_manually_entered_address() {
        String stolenVehicleOwnerFirstName = (String) _persistentData.getContext("stolenVehicles.owner.firstName");
        List<WebElement> ownerDetailsPrepopulatedList = _contactDetails.getTextOfSomeoneElseDoesOwnerFirstNameHeaderInContactDetailsPage();
        int elementInApplicationIndex = 0;
        boolean found = false;
        for (WebElement ownerFirstNameElement : ownerDetailsPrepopulatedList) {
            String actualFirstnameIndicatorInApplication = ownerFirstNameElement.getText();
            String expectedFirstNameIndicatorKeyedInLastScreen = "Please provide " + stolenVehicleOwnerFirstName + "'s details";
            if (actualFirstnameIndicatorInApplication.equalsIgnoreCase(expectedFirstNameIndicatorKeyedInLastScreen)) {
                found = true;
                _contactDetails.clickSomeOneElseOwnerCantFindAddressCheckBox(elementInApplicationIndex);
                keyInAddressOfSomebodyElseOwnerManually(elementInApplicationIndex);
                _persistentData.setContext("someBodyElseOwnerElementIndex", elementInApplicationIndex);
                break;
            }
            elementInApplicationIndex++;
        }
        if (!found) {
            Assert.assertTrue(false, "Owner section for Owner : " + stolenVehicleOwnerFirstName + " does not exist");
        }
    }

    @Then("I should be able to see details of the owner of third stolen vehicle prepopulated")
    public void i_should_be_able_to_see_details_of_the_owner_of_third_stolen_vehicle_prepopulated() {
        String stolenItemOwnerOrganisationName = (String) _persistentData.getContext("stolenVehicles.owner.organisationName");
        String expectedStolenOrganisationname = stolenItemOwnerOrganisationName + "'s details"; // this is how it's displayed in app
        String actualStolenOrganisationName = _contactDetails.getOrganisationOwnerDetailsHeaderMobile();
        Assert.assertEquals(actualStolenOrganisationName, expectedStolenOrganisationname, "Organisation owner name is incorrect in contact details page");
    }

    @Then("I should be able to add details of the owner of second lost item")
    public void i_should_be_able_to_add_details_of_the_owner_of_second_lost_item() {
        _contactDetails.keyInSomeOneOwnerAgeOrDOBMobile();
        _contactDetails.selectDropDownRelationShipToOwnerMobile();
        _contactDetails.selectOwnerPhoneTypeMobile();
        _contactDetails.keyInOwnerPhoneNumberMobile();
        _contactDetails.selectAddressTypeMethodMobile();
        _contactDetails.keyInOwnerAddressMobile();
    }

    @Then("I should be able to add details of the owner of second damaged Item")
    public void i_should_be_able_to_add_details_of_the_owner_of_second_damaged_Item() {
        _contactDetails.keyInSomeOneOwnerAgeOrDOBMobile();
        _contactDetails.selectDropDownRelationShipToOwnerMobile();
        _contactDetails.selectOwnerPhoneTypeMobile();
        _contactDetails.keyInOwnerPhoneNumberMobile();
        _contactDetails.selectAddressTypeMethodMobile();
        _contactDetails.keyInOwnerAddressMobile();
        _contactDetails.selectSomethingElseOwnerSupportFlagMobile("Yes");
    }

    @When("I click on continue in Owner details page to navigate to next owner details")
    public void I_click_on_continue_in_Owner_details() {
        _contactDetails.clickOnContinueButtonFromReporterPage();
    }

    @Then("I should be able to see details of the owner of third lost item prepopulated and key in address of Organisation")
    public void i_should_be_able_to_see_details_of_the_owner_of_third_lost_item_prepopulated_and_key_in_address_of_Organisation() {
        String lostItemOwnerOrganisationName = (String) _persistentData.getContext("whatWasLost.owner.organisationName");
        String expectedLostItemOrganisationname = lostItemOwnerOrganisationName + "'s details"; // this is how it's displayed in app
        String actualLostItemOrganisationName = _contactDetails.getOrganisationOwnerDetailsHeaderMobile();
        Assert.assertEquals(actualLostItemOrganisationName, expectedLostItemOrganisationname, "Organisation owner name is incorrect in contact details page");
        _contactDetails.selectOwnerPhoneTypeMobile();
        _contactDetails.keyInOwnerPhoneNumberMobile();
        _contactDetails.keyInOwnerAddressMobile();
    }

    @Then("I should be able to see details of the owner of third lost item prepopulated and key in address of Organisation manually")
    public void i_should_be_able_to_see_details_of_the_owner_of_third_lost_item_prepopulated_and_key_in_address_of_Organisation_manually() {
        String lostItemOwnerOrganisationName = (String) _persistentData.getContext("whatWasLost.owner.organisationName");
        List<WebElement> ownerDetailsPrepopulatedList = _contactDetails.getTextOfOrganisationDoesOwnerFirstNameHeaderInContactDetailsPage();
        int elementInApplicationIndex = 0;
        boolean found = false;
        for (WebElement ownerFirstNameElement : ownerDetailsPrepopulatedList) {
            String actualFirstnameIndicatorInApplication = ownerFirstNameElement.getText();
            String expectedFirstNameIndicatorKeyedInLastScreen = "Please provide " + lostItemOwnerOrganisationName + "'s details";
            if (actualFirstnameIndicatorInApplication.equalsIgnoreCase(expectedFirstNameIndicatorKeyedInLastScreen)) {
                found = true;
                keyInaddressOfOrganisationOwnerManually(elementInApplicationIndex);
                _persistentData.setContext("someBodyElseOwnerElementIndex", elementInApplicationIndex);
                break;
            }
            elementInApplicationIndex++;
        }
        if (!found) {
            Assert.assertTrue(false, "Owner section for Owner : " + lostItemOwnerOrganisationName + " does not exist");
        }
    }

    @Then("I should be able to see details of the owner of second damaged vehicle prepopulated")
    public void i_should_be_able_to_see_details_of_the_owner_of_second_damaged_vehicle_prepopulated() {
        String damagedVehicleOwnerFirstName = (String) _persistentData.getContext("damagedVehicles.owner.firstName");
        String expectedDamagedVehicleOwner = damagedVehicleOwnerFirstName + "'s details";// this is how it's displayed in app
        String actualDamagedVehicleOwnerFirstName = _contactDetails.getSomeOneElseOwnerDetailsHeaderMobile();
        Assert.assertEquals(actualDamagedVehicleOwnerFirstName, expectedDamagedVehicleOwner, "Owner first name displayed is incorrect");
    }

    @Then("I should be able to add details of the owner of second damaged vehicle")
    public void i_should_be_able_to_add_phone_number_of_the_owner_of_second_damaged_vehicle() {
        _contactDetails.keyInSomeOneOwnerAgeOrDOBMobile();
        _contactDetails.selectDropDownRelationShipToOwnerMobile();
        _contactDetails.keyInOwnerPhoneNumberMobile();
        _contactDetails.selectOwnerPhoneTypeMobile();
        _contactDetails.keyInOwnerAddressMobile();
        _contactDetails.selectAddressTypeMethodMobile();
        _contactDetails.selectSomethingElseOwnerSupportFlagMobile("Yes");
    }

    @Then("I should be able to see details of the owner of third damaged vehicle prepopulated and key in address of Organisation")
    public void i_should_be_able_to_see_details_of_the_owner_of_third_damaged_vehicle_prepopulated() {
        String damagedVehicleOwnerOrganisationName = (String) _persistentData.getContext("damagedVehicles.owner.organisationName");
        String expectedDamagedVehicleOrganisationname = damagedVehicleOwnerOrganisationName + "'s details"; // this is how it's displayed in app
        String actualDamagedVehicleOrganisationName = _contactDetails.getOrganisationOwnerDetailsHeaderMobile();
        Assert.assertEquals(actualDamagedVehicleOrganisationName, expectedDamagedVehicleOrganisationname, "Organisation owner name is incorrect in contact details page");
        _contactDetails.selectOwnerPhoneTypeMobile();
        _contactDetails.keyInOwnerPhoneNumberMobile();
        _contactDetails.keyInOwnerAddressMobile();
    }


    @Then("I can validate the previous name prompt")
    public void iCanValidateThePreviousNamePrompt() {
        _contactDetails.validatePreviousNamePrompt();
    }

    @When("I key in details of reporter without phone type and phone number")
    public void iKeyInDetailsOfReporterWithoutAddressTypePhoneTypeAndPhoneNumber() {
        _contactDetails.keyInReporterFirstName();
        _contactDetails.keyInReporterMiddleName();
        _contactDetails.keyInReporterLastName();
        _contactDetails.keyInReporterDOBMobile();
        _contactDetails.selectReporterGenderMobile();
        _contactDetails.keyInReporterDriverLicenceNumber();
        _contactDetails.keyInReporterEmailAddress();
        _contactDetails.selectPreferredContactMethodMobile();
        _contactDetails.selectReporterPhoneTypeMobile();
        _contactDetails.selectAddressTypeMethodMobile();
        _contactDetails.keyInReporterAddress();
    }

    @And("i should be able to validate the options for address type and phone type fields")
    public void iShouldBeAbleToValidateTheOptionsForAddressTypeAndPhoneTypeFields() {
        String[] reporterPreferredContactMethodLIst = _generateTestData.generateListData("personalInformation.phoneType");
        String[] reporterAdressTypeList = _generateTestData.generateListData("personalInformation.addressType");
        _contactDetails.validateReporterPhoneType(reporterPreferredContactMethodLIst);
        _contactDetails.validateReporterAddressType(reporterAdressTypeList);
    }

    @When("i key in phone number")
    public void iKeyInPhoneNumber() {
        _contactDetails.keyInReporterPhoneNumber(0);
    }

    @And("I should be able to add details of the owner of second damaged Item without phone number")
    public void iShouldBeAbleToAddDetailsOfTheOwnerOfSecondDamagedItemWithoutPhoneNumber() {
        _contactDetails.keyInSomeOneOwnerAgeOrDOBMobile();
        _contactDetails.selectDropDownRelationShipToOwnerMobile();
        _contactDetails.selectOwnerPhoneTypeMobile();
        _contactDetails.selectAddressTypeMethodMobile();
        _contactDetails.keyInOwnerAddressMobile();
        _contactDetails.selectVictimSupportFlag("Yes");
    }

    @Then("I can validate that phone number is a mandatory field")
    public void iCanValidateThatPhoneNumberIsAMandatoryField() {
        _genericControls.clickOnCloseButtonInPopup();
        Assert.assertEquals(_contactDetails.waitandGetText(_contactDetails.getPhoneNumberErrorMessage()),
                _generateTestData.generateValidData("personalInformation.mandatoryFieldErrorMessage"));
    }

    @Then("I can validate that phone number is a mandatory field for someone else owner")
    public void iCanValidateThatPhoneNumberIsAMandatoryFieldForSomeoneElseOwner() {
        _genericControls.clickOnCloseButtonInPopup();
        Assert.assertEquals(_contactDetails.waitandGetText(_contactDetails.getPhoneNumberErrorMessageOwner()),
                _generateTestData.generateValidData("personalInformation.mandatoryFieldErrorMessage"));
    }

    @Then("I can validate that phone number is a mandatory field for organisation")
    public void iCanValidateThatPhoneNumberIsAMandatoryFieldForOrganisation() {
        Assert.assertEquals(_contactDetails.waitandGetText(_contactDetails.getPhoneNumberErrorMessageOrganisation()),
                _generateTestData.generateValidData("personalInformation.mandatoryFieldErrorMessage"));
    }

    @And("i should be able to validate the options for address type and phone type fields for owner")
    public void iShouldBeAbleToValidateTheOptionsForAddressTypeAndPhoneTypeFieldsForOwner() {
        String[] reporterPreferredContactMethodLIst = _generateTestData.generateListData("personalInformation.phoneType");
        String[] reporterAdressTypeList = _generateTestData.generateListData("personalInformation.addressType");
        _contactDetails.validateOwnerPhoneType(reporterPreferredContactMethodLIst);
        _contactDetails.validateReporterAddressType(reporterAdressTypeList);
    }

    @When("i key in phone number for Owner")
    public void iKeyInPhoneNumberForOwner() {
        _contactDetails.keyInOwnerPhoneNumberMobile();
    }

    @And("I should be able to add address of the organisation of damaged Item Owner without phone number")
    public void iShouldBeAbleToAddAddressOfTheOrganisationOfDamagedItemOwnerWithoutPhoneNumber() {
        _contactDetails.selectOwnerPhoneTypeMobile();
        //_contactDetails.keyInOwnerPhoneNumberMobile();
        //_contactDetails.keyInOwnerAddressMobile();
    }

    @And("i should be able to validate the options for phone type fields for organisation")
    public void iShouldBeAbleToValidateTheOptionsForPhoneTypeFieldsForOrganisation() {
        String[] reporterPreferredContactMethodLIst = _generateTestData.generateListData("personalInformation.phoneType");
        _contactDetails.validateOwnerPhoneType(reporterPreferredContactMethodLIst);
    }

    @Then("I should be able to see details of the owner of second stolen Item prepopulated")
    public void i_should_be_able_to_see_details_of_the_owner_of_second_stolen_Item_prepopulated() {
        String stolenItemOwnerFirstName = (String) _persistentData.getContext("whatWasStolen.owner.firstName");
        String expectedStolenItemOwner = stolenItemOwnerFirstName + "'s details";// this is how it's displayed in app
        String actualStolenItemOwnerFirstName = _contactDetails.getSomeOneElseOwnerDetailsHeaderMobile();
        Assert.assertEquals(actualStolenItemOwnerFirstName, expectedStolenItemOwner, "Owner first name displayed is incorrect");
    }

    @Then("I should be able to add details of the owner of second stolen Item")
    public void i_should_be_able_to_add_details_of_the_owner_of_second_stolen_Item() {
        _contactDetails.keyInSomeOneOwnerAgeOrDOBMobile();
        _contactDetails.selectDropDownRelationShipToOwnerMobile();
        _contactDetails.keyInOwnerPhoneNumberMobile();
        _contactDetails.selectOwnerPhoneTypeMobile();
        _contactDetails.keyInOwnerAddressMobile();
        _contactDetails.selectAddressTypeMethodMobile();
        _contactDetails.selectSomethingElseOwnerSupportFlagMobile("Yes");
    }

    @Then("I should be able to add address of the organisation of stolen Item Owner")
    public void i_should_be_able_to_add_address_of_the_organisation_of_stolen_Item_owner() {
        _contactDetails.selectOwnerPhoneTypeMobile();
        _contactDetails.keyInOwnerPhoneNumberMobile();
        _contactDetails.keyInOwnerAddressMobile();
    }

    @Then("I should be able to add details of the owner of second stolen vehicle")
    public void i_should_be_able_to_add_phone_number_of_the_owner_of_second_stolen_vehicle() {
        _contactDetails.keyInSomeOneOwnerAgeOrDOBMobile();
        _contactDetails.selectDropDownRelationShipToOwnerMobile();
        _contactDetails.keyInOwnerPhoneNumberMobile();
        _contactDetails.selectOwnerPhoneTypeMobile();
        _contactDetails.keyInOwnerAddressMobile();
        _contactDetails.selectAddressTypeMethodMobile();
        _contactDetails.selectSomethingElseOwnerSupportFlagMobile("Yes");
    }

    @Then("I should be able to add address of the organisation of stolen Vehicle Owner")
    public void i_should_be_able_to_add_address_of_the_organisation_of_stolen_Vehicle_owner() {
        _contactDetails.selectOwnerPhoneTypeMobile();
        _contactDetails.keyInOwnerPhoneNumberMobile();
        _contactDetails.keyInOwnerAddressMobile();
    }

    @Then("I can select use the address I entered earlier and validate details")
    public void iCanSelectUseTheAddressIEnteredEarlier() {
        String address = (String) _persistentData.getContext("homeAddress");
        _contactDetails.selectUseTheAddressIEnteredEarlier();
        _contactDetails.validateEarlierAddressValueOnReporter(address);
        _contactDetails.validateReporterHomeAddressType();
    }

    @And("I cannot select reporter dob as future or current date")
    public void iCannnotSelectReporterDobAsFutureOrCurrentDate() {
        String currentDateErrorMessage = _generateTestData.generateValidData("personalInformation.reporterDOBCurrentError");
        String futureDateErrorMessage = _generateTestData.generateValidData("personalInformation.reporterDOBInFutureError");
        _contactDetails.keyInSpecificReporterDOBMobile("current");
        _contactDetails.validateErrorMessage(currentDateErrorMessage);
        _contactDetails.keyInSpecificReporterDOBMobile("future");
        _contactDetails.validateErrorMessage(futureDateErrorMessage);
    }

    @And("I key in the details of the reporter without address")
    public void iKeyInTheDetailsOfTheReporterWithoutAddress() {
        _contactDetails.keyInReporterFirstName();
        _contactDetails.keyInReporterMiddleName();
        _contactDetails.keyInReporterLastName();
//        _contactDetails.keyInReporterDOB();
        _contactDetails.keyInReporterDOBMobile();
        _contactDetails.selectReporterGenderMobile();
        _contactDetails.keyInReporterDriverLicenceNumber();
        _contactDetails.keyInReporterEmailAddress();
        _contactDetails.selectReporterPhoneTypeMobile();
        _contactDetails.keyInReporterPhoneNumber(0);
        _contactDetails.selectPreferredContactMethodMobile();
    }

    @And("I should not see option to select for earlier address")
    public void iShouldNotSeeOptionToSelectForEarlierAddress() {
        _contactDetails.validateEarlierAddressEnteredOptionIsNotAvailable();
    }

    @And("I should not be able to enter owner dob as future or current date")
    public void iShouldNotBeAbleToEnterOwnerDobAsFutureOrCurrentDate() {
        String currentDateErrorMessage = _generateTestData.generateValidData("personalInformation.reporterDOBCurrentError");
        String futureDateErrorMessage = _generateTestData.generateValidData("personalInformation.reporterDOBInFutureError");
        _contactDetails.keyInSpecificOwnerDOBMobile("current");
        _contactDetails.clickOnContinueButtonFromReporterPage();
        _contactDetails.validateErrorMessage(currentDateErrorMessage);
        _contactDetails.keyInSpecificOwnerDOBMobile("future");
        _contactDetails.clickOnContinueButtonFromReporterPage();
        _contactDetails.validateErrorMessage(futureDateErrorMessage);
    }

    @And("I should not be able to continue without owners age or dob")
    public void iShouldNotBeAbleToContinueWithoutOwnersAgeOrDob() {
        _contactDetails.clearOwnerDOBandvalidateError();
    }
}
