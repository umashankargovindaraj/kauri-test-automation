package features.OnlineReporting.StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libs.DriverFactory;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDetailsSteps extends DriverFactory {

    @Then("I should see additional fields with owner details in Personal details page")
    public void i_should_see_additional_fields_with_owner_details_in_Personal_details_page() {
        int actualCountOfSections = _contactDetails.getPrePopulatedOwnerSomeOneElseDoesDetailsSectionsCount();
        int expectedCountofSections = _contactDetails.expectedCountOfOwnerSections();
        Assert.assertEquals(actualCountOfSections, expectedCountofSections, "Count of sections displayed for details from previous screen when user selects 'Someone else does' is incorrect");
    }

    @Then("I should see additional fields with Organisation owner details in Personal details page")
    public void i_should_see_additional_fields_with_organisation_owner_details_in_Personal_details_page() {
        int actualCountOfSections = _contactDetails.getPrePopulatedOwnerOrganisationDetailsSectionsCount();
        Assert.assertEquals(actualCountOfSections, 4, "Count of sections displayed for details from previous screen when user selects 'Organisation Does' is incorrect");
    }

    @Then("I should be able to key in details of the owner")
    public void I_should_be_able_to_key_in_details_of_the_owner() {
        _contactDetails.keyInAgeOfOwnerSomeOneElse(0);
        String[] ownerGenderList = _generateTestData.generateListData("ownerInformation.ownerGender1");
        _contactDetails.validateSomeOneElseOwnerGender(ownerGenderList);
        _contactDetails.selectInGenderOfOwnerSomeOneElse(0);
        _contactDetails.keyInEmailAddressOfOwnerSomeOneElse(0);
        String[] phoneTypeList = _generateTestData.generateListData("ownerInformation.ownerPhoneType1");
        _contactDetails.validateSomeOneElseOwnerPhoneType(phoneTypeList);
        _contactDetails.selectPhoneTypeOfOwnerOwnerSomeOneElse(0);
        _contactDetails.keyInPhoneNumberOfOwnerSomeOneElse(0);
        _contactDetails.keyInAddressOfOwnerSomeOneElse(0);
    }

    @Then("I should be able to add additional email address along with default option")
    public void I_should_be_able_to_add_additional_email_address_along_with_default_option() {
        _contactDetails.addOwnerSomeOneElseEmailAddress();
    }

    @Then("I should be able to delete the extra email address created")
    public void I_should_be_able_to_delete_the_extra_email_address_created() {
        _contactDetails.deleteOwnerSomeOneElseEmailAddress();
    }

    @Then("I should be able to add additional phone number along with default option")
    public void I_should_be_able_to_add_additional_phone_number_along_with_default_option() {
        _contactDetails.addOwnerSomeOneElsePhoneNumber();
    }

    @Then("I should be able to delete the extra phone number created")
    public void And_I_should_be_able_to_delete_the_extra_phone_number_created() {
        _contactDetails.deleteOwnerSomeOneElsePhoneNumber();
    }

    @Then("I should see their names correctly prepopulated")
    public void their_First_Name_and_Last_name_prepopulated() {
        List<String> firstNamesOfOwners = new ArrayList<>();
        firstNamesOfOwners.add((String) _persistentData.getContext("damagedVehicles.owner.firstName"));
        firstNamesOfOwners.add((String) _persistentData.getContext("whatWasDamaged.owner.firstName"));
        firstNamesOfOwners.add((String) _persistentData.getContext("stolenVehicles.owner.firstName"));
        firstNamesOfOwners.add((String) _persistentData.getContext("whatWasStolen.owner.firstName"));
        List<WebElement> ownerDetailsPrepopulatedList = _contactDetails.getTextOfSomeoneElseDoesOwnerFirstNameHeaderInContactDetailsPage();
        int ownerListArray = 0;
        for (String firstName : firstNamesOfOwners) {
            int elementInApplicationIndex = 0;
            boolean found = false;
            for (WebElement ownerFirstNameElement : ownerDetailsPrepopulatedList) {
                String actualFirstnameIndicatorInApplication = ownerFirstNameElement.getText();
                String expectedFirstNameIndicatorKeyedInLastScreen = "Please provide " + firstName + "'s details";
                if (actualFirstnameIndicatorInApplication.equalsIgnoreCase(expectedFirstNameIndicatorKeyedInLastScreen)) {
                    found = true;
                    switch (ownerListArray) {
                        case 0:
                            verifydamagedVehicleOwnerNamesPrePopulatedInContactDetailsSection(elementInApplicationIndex);
                            break;
                        case 1:
                            verifydamagedItemOwnerNamesPrePopulatedInContactDetailsSection(elementInApplicationIndex);
                            break;
                        case 2:
                            verifyStolenVehicleOwnerNamesPrePopulatedInContactDetailsSection(elementInApplicationIndex);
                            break;
                        case 3:
                            verifyStolenItemOwnerNamesPrePopulatedInContactDetailsSection(elementInApplicationIndex);
                            break;
                    }
                    break;
                }
                elementInApplicationIndex++;
            }
            if (!found) {
                Assert.assertTrue(false, "Owner section for Owner : " + firstName + " does not exist");
            } else {
                ownerListArray++;
            }
        }


    }

    public void verifydamagedVehicleOwnerNamesPrePopulatedInContactDetailsSection(int index) {
        Assert.assertEquals(_contactDetails.getValueFromOwnerFirstNameField(index), _persistentData.getContext("damagedVehicles.owner.firstName"));
        Assert.assertEquals(_contactDetails.getValueFromOwnerMiddleNameField(index), _persistentData.getContext("damagedVehicles.owner.middleName"));
        Assert.assertEquals(_contactDetails.getValueFromOwnerLastNameField(index), _persistentData.getContext("damagedVehicles.owner.lastName").toString().toUpperCase());
    }

    public void verifydamagedItemOwnerNamesPrePopulatedInContactDetailsSection(int index) {
        Assert.assertEquals(_contactDetails.getValueFromOwnerFirstNameField(index), _persistentData.getContext("whatWasDamaged.owner.firstName"));
        Assert.assertEquals(_contactDetails.getValueFromOwnerMiddleNameField(index), _persistentData.getContext("whatWasDamaged.owner.middleName"));
        Assert.assertEquals(_contactDetails.getValueFromOwnerLastNameField(index), _persistentData.getContext("whatWasDamaged.owner.lastName").toString().toUpperCase());
    }

    public void verifyStolenVehicleOwnerNamesPrePopulatedInContactDetailsSection(int index) {
        Assert.assertEquals(_contactDetails.getValueFromOwnerFirstNameField(index), _persistentData.getContext("stolenVehicles.owner.firstName"));
        Assert.assertEquals(_contactDetails.getValueFromOwnerMiddleNameField(index), _persistentData.getContext("stolenVehicles.owner.middleName"));
        Assert.assertEquals(_contactDetails.getValueFromOwnerLastNameField(index), _persistentData.getContext("stolenVehicles.owner.lastName").toString().toUpperCase());
    }

    public void verifyStolenItemOwnerNamesPrePopulatedInContactDetailsSection(int index) {
        Assert.assertEquals(_contactDetails.getValueFromOwnerFirstNameField(index), _persistentData.getContext("whatWasStolen.owner.firstName"));
        Assert.assertEquals(_contactDetails.getValueFromOwnerMiddleNameField(index), _persistentData.getContext("whatWasStolen.owner.middleName"));
        Assert.assertEquals(_contactDetails.getValueFromOwnerLastNameField(index), _persistentData.getContext("whatWasStolen.owner.lastName").toString().toUpperCase());
    }


    @Then("I should see the organisation name correctly prepopulated")
    public void I_should_see_the_name_of_the_organisation_correctly_prepopulated() {
        List<String> organisationNameOfOwners = new ArrayList<>();
        organisationNameOfOwners.add((String) _persistentData.getContext("damagedVehicles.owner.organisationName"));
        organisationNameOfOwners.add((String) _persistentData.getContext("whatWasDamaged.owner.organisationName"));
        organisationNameOfOwners.add((String) _persistentData.getContext("stolenVehicles.owner.organisationName"));
        organisationNameOfOwners.add((String) _persistentData.getContext("whatWasStolen.owner.organisationName"));
        List<WebElement> ownerDetailsPrepopulatedList = _contactDetails.getTextOfOrganisationDoesOwnerFirstNameHeaderInContactDetailsPage();
        int ownerListArray = 0;
        for (String organisationName : organisationNameOfOwners) {
            int elementInApplicationIndex = 0;
            boolean found = false;
            for (WebElement ownerFirstNameElement : ownerDetailsPrepopulatedList) {
                String actualOrganisationNameIndicatorInApplication = ownerFirstNameElement.getText();
                String expectedOrganisationNameKeyedInLastScreen = "Please provide " + organisationName + "'s details";
                if (actualOrganisationNameIndicatorInApplication.equalsIgnoreCase(expectedOrganisationNameKeyedInLastScreen)) {
                    found = true;
                    switch (ownerListArray) {
                        case 0:
                            verifydamagedVehicleOrganisationOwnerName(elementInApplicationIndex);
                            break;
                        case 1:
                            verifydamagedItemOrganisationOwnerName(elementInApplicationIndex);
                            break;
                        case 2:
                            verifyStolenVehicleOrganisationOwnerName(elementInApplicationIndex);
                            break;
                        case 3:
                            verifyStolenItemOrganisationOwnerName(elementInApplicationIndex);
                            break;
                    }
                    break;
                }
                elementInApplicationIndex++;
            }
            if (!found) {
                Assert.assertTrue(false, "Owner section for organisation : " + organisationName + " does not exist");
            } else {
                ownerListArray++;
            }
        }
    }

    public void verifydamagedVehicleOrganisationOwnerName(int index) {
        Assert.assertEquals(_contactDetails.getValueFromOwnerOrganisationName(index), _persistentData.getContext("damagedVehicles.owner.organisationName"));
    }

    public void verifydamagedItemOrganisationOwnerName(int index) {
        Assert.assertEquals(_contactDetails.getValueFromOwnerOrganisationName(index), _persistentData.getContext("whatWasDamaged.owner.organisationName"));
    }

    public void verifyStolenVehicleOrganisationOwnerName(int index) {
        Assert.assertEquals(_contactDetails.getValueFromOwnerOrganisationName(index), _persistentData.getContext("stolenVehicles.owner.organisationName"));
    }

    public void verifyStolenItemOrganisationOwnerName(int index) {
        Assert.assertEquals(_contactDetails.getValueFromOwnerOrganisationName(index), _persistentData.getContext("whatWasStolen.owner.organisationName"));
    }


    @Then("the system should indicate users about mandatory fields in Please provide your details section and throw appropriate error message when any mandatory fields are not keyed in")
    public void the_system_should_indicate_users_about_mandatory_fields_in_Please_provide_your_details_section_and_throw_appropriate_error_message_when_any_mandatory_fields_are_not_keyed_in() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I should be able to key in valid data e.g. field length, alphanumeric etc on fields in Please provide your details section and throw appropriate error message otherwise")
    public void i_should_be_able_to_key_in_valid_data_e_g_field_length_alphanumeric_etc_on_fields_in_Please_provide_your_details_section_and_throw_appropriate_error_message_otherwise() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("the text displayed on fields in Please provide your details section should be as expected")
    public void the_text_displayed_on_fields_in_Please_provide_your_details_section_should_be_as_expected() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("the system should indicate users about mandatory fields in Owner details section and throw appropriate error message when any mandatory fields are not keyed in")
    public void the_system_should_indicate_users_about_mandatory_fields_in_Owner_details_section_and_throw_appropriate_error_message_when_any_mandatory_fields_are_not_keyed_in() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I should be able to key in valid data e.g. field length, alphanumeric etc on fields in Owner details section section and throw appropriate error message otherwise")
    public void i_should_be_able_to_key_in_valid_data_e_g_field_length_alphanumeric_etc_on_fields_in_Owner_details_section_section_and_throw_appropriate_error_message_otherwise() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("the text displayed on fields in Owner details should be as expected")
    public void the_text_displayed_on_fields_in_Owner_details_should_be_as_expected() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();

    }

    @Then("I am able to add additional email addresses")
    public void i_am_able_to_add_additional_email_addresses() throws InterruptedException {
        _contactDetails.addOwnerSomeOneElseEmailAddress();
    }

    @Then("I am able to delete additional email addresses")
    public void i_am_able_to_delete_additional_email_addresses() throws InterruptedException {
        _contactDetails.deleteOwnerSomeOneElseEmailAddress();
    }

    @Then("I am able to add additional phone numbers")
    public void i_am_able_to_add_additional_phone_numbers() throws InterruptedException {
        _contactDetails.addOwnerSomeOneElsePhoneNumber();
    }

    @Then("I am able to delete additional phone numbers")
    public void i_am_able_to_delete_additional_phone_numbers() throws InterruptedException {
        _contactDetails.deleteOwnerSomeOneElsePhoneNumber();
    }

    @Given("that I am on the person details page")
    public void that_I_am_on_the_person_details_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Given("I have indicated that I want to be contacted by Victim support")
    public void i_have_indicated_that_I_want_to_be_contacted_by_Victim_support() {
        _contactDetails.selectVictimSupportFlag("yes");
    }

    @When("I submit my report")
    public void i_submit_my_report() {
        System.out.println("To be implemented");
    }

    @Then("my details will be emailed to victim support")
    public void my_details_will_be_emailed_to_victim_support() {
        System.out.println("To be implemented");
    }


    @When("I key in my personal information")
    public void i_key_in_my_personal_information() throws InterruptedException {
        _contactDetails.keyInDataOnFieldsRelatedToReporterContactDetails();
    }



    @When("I key in my personal information with future date as Reporter DOB")
    public void i_key_in_my_personal_information_futureDate_ReporterDOB() {
        _contactDetails.keyInDataOnFieldsRelatedToReporterContactDetailsFutureDate();
    }

    @When("I key in my personal information with current date as Reporter DOB")
    public void i_key_in_my_personal_information_current_ReporterDOB() {
        _contactDetails.keyInDataOnFieldsRelatedToReporterContactDetailsCurrentDate();
    }

    @When("I key in my personal information with manually keyed in address")
    public void i_key_in_my_personal_information_with_manually_keyed_in_address() {
        _contactDetails.keyInDataOnFieldsRelatedToReporterContactDetails(true, false);
    }

    @When("I key in my personal information with manually keyed in international address")
    public void i_key_in_my_personal_information_with_manually_keyed_in_internationa_address() {
        _contactDetails.keyInDataOnFieldsRelatedToReporterContactDetails(true, true);
    }

    @When("I key data into all fields in reporter personal information")
    public void i_key_in_my_personal_information_all_fields() throws InterruptedException {
        _contactDetails.keyInDataOnFieldsRelatedToReporterContactDetailsAllFields();
    }

    @When("I key in my {string}")
    public void i_key_in_my(String string) {

    }

    @Then("I can validate that phone number is a mandatory field")
    public void iCanValidateThatPhoneNumberIsAMandatoryField() {
        _genericControls.clickOnCloseButtonInPopup();
        Assert.assertEquals(_contactDetails.waitandGetText(_contactDetails.getPhoneNumberErrorMessage()),
                _generateTestData.generateValidData("personalInformation.mandatoryFieldErrorMessage"));
    }

    @When("I key in my work phone {string}")
    public void i_key_in_my_work_phone(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("I am able to key in home phone {string}")
    public void i_am_able_to_key_in_home_phone(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("I set preferred contact details as {string}")
    public void i_set_preferred_contact_details_as(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("I indicate i need victim support")
    public void i_indicate_victim_support_as() {
        String victimSupport = _contactDetails.getVictimSupportIndicator();
        _contactDetails.selectVictimSupportFlag(victimSupport);
    }


    @Then("I should be able to add details of the owner of second stolen Item")
    public void i_should_be_able_to_add_details_of_the_owner_of_second_stolen_Item() {
        int index = (int) _persistentData.getContext("someBodyElseOwnerElementIndex");
        _contactDetails.keyInAgeOfOwnerSomeOneElse(index);
        _contactDetails.selectInGenderOfOwnerSomeOneElse(index);
        _contactDetails.selectRelationsShipOfOwnerSomeOneElse(index);
        _contactDetails.selectAddressTypeSomeOneElseOwner(index);
        _contactDetails.keyInEmailAddressOfOwnerSomeOneElse(index);
        _contactDetails.selectPhoneTypeOfOwnerOwnerSomeOneElse(index);
        _contactDetails.keyInPhoneNumberOfOwnerSomeOneElse(index);
        _contactDetails.selectSomeElseOwnerVictimSupportFlag("Yes", index);
    }

    @Then("I should be able to add details of the owner of second damaged Item")
    public void i_should_be_able_to_add_details_of_the_owner_of_second_damaged_Item() {
        int index = (int) _persistentData.getContext("someBodyElseOwnerElementIndex");
        _contactDetails.keyInAgeOfOwnerSomeOneElse(index);
        _contactDetails.selectInGenderOfOwnerSomeOneElse(index);
        _contactDetails.selectRelationsShipOfOwnerSomeOneElse(index);
        _contactDetails.selectAddressTypeSomeOneElseOwner(index);
        _contactDetails.keyInEmailAddressOfOwnerSomeOneElse(index);
        _contactDetails.selectPhoneTypeOfOwnerOwnerSomeOneElse(index);
        _contactDetails.keyInPhoneNumberOfOwnerSomeOneElse(index);
        _contactDetails.selectSomeElseOwnerVictimSupportFlag("Yes", index);
    }

    @Then("I should be able to add details of the owner of second damaged Item and enter a future date to Owner DOB")
    public void i_should_be_able_to_add_details_of_the_owner_of_second_damaged_Item_Future_Date() {
        int index = (int) _persistentData.getContext("someBodyElseOwnerElementIndex");
        _contactDetails.keyInAgeOfOwnerSomeOneElseFutureDate(index);
        _contactDetails.selectInGenderOfOwnerSomeOneElse(index);
        _contactDetails.selectRelationsShipOfOwnerSomeOneElse(index);
        _contactDetails.selectAddressTypeSomeOneElseOwner(index);
        _contactDetails.keyInEmailAddressOfOwnerSomeOneElse(index);
        _contactDetails.selectPhoneTypeOfOwnerOwnerSomeOneElse(index);
        _contactDetails.keyInPhoneNumberOfOwnerSomeOneElse(index);
        _contactDetails.selectSomeElseOwnerVictimSupportFlag("Yes", index);
    }

    @Then("I should be able to add details of the owner of second damaged Item and enter age greater than 125")
    public void i_should_be_able_to_add_details_of_the_owner_of_second_damaged_Item_Age_GreaterThan_125() {
        int index = (int) _persistentData.getContext("someBodyElseOwnerElementIndex");
        _contactDetails.keyInAgeOfOwnerSomeOneElseAgeGreaterThan125(index);
        _contactDetails.selectInGenderOfOwnerSomeOneElse(index);
        _contactDetails.selectRelationsShipOfOwnerSomeOneElse(index);
        _contactDetails.selectAddressTypeSomeOneElseOwner(index);
        _contactDetails.keyInEmailAddressOfOwnerSomeOneElse(index);
        _contactDetails.selectPhoneTypeOfOwnerOwnerSomeOneElse(index);
        _contactDetails.keyInPhoneNumberOfOwnerSomeOneElse(index);
        _contactDetails.selectSomeElseOwnerVictimSupportFlag("Yes", index);
    }


    @Then("I should be able to see details of the owner of second stolen Item prepopulated")
    public void i_should_be_able_to_see_details_of_the_owner_of_second_stolen_Item_prepopulated() {
        String stolenItemOwnerFirstName = (String) _persistentData.getContext("whatWasStolen.owner.firstName");
        List<WebElement> ownerDetailsPrepopulatedList = _contactDetails.getTextOfSomeoneElseDoesOwnerFirstNameHeaderInContactDetailsPage();
        int someBodyElseOwnerElementIndex = 0;
        boolean found = false;
        for (WebElement ownerFirstNameElement : ownerDetailsPrepopulatedList) {
            String actualFirstnameIndicatorInApplication = ownerFirstNameElement.getText();
            String expectedFirstNameIndicatorKeyedInLastScreen = "Please provide " + stolenItemOwnerFirstName + "'s details";
            if (actualFirstnameIndicatorInApplication.equalsIgnoreCase(expectedFirstNameIndicatorKeyedInLastScreen)) {
                found = true;
                keyInAddressOfSomebodyElseOwner(someBodyElseOwnerElementIndex);
                _persistentData.setContext("someBodyElseOwnerElementIndex", someBodyElseOwnerElementIndex);
                someBodyElseOwnerElementIndex = someBodyElseOwnerElementIndex + 1;
                break;
            }

        }
        if (!found) {
            Assert.assertTrue(false, "Owner section for Owner : " + stolenItemOwnerFirstName + " does not exist");
        }
    }

    @Then("I should be able to see details of the owner of second stolen Item prepopulated and key in manually entered address")
    public void i_should_be_able_to_see_details_of_the_owner_of_second_stolen_Item_prepopulated_manually_entered_address() {
        String stolenItemOwnerFirstName = (String) _persistentData.getContext("whatWasStolen.owner.firstName");
        List<WebElement> ownerDetailsPrepopulatedList = _contactDetails.getTextOfSomeoneElseDoesOwnerFirstNameHeaderInContactDetailsPage();
        int elementInApplicationIndex = 0;
        boolean found = false;
        for (WebElement ownerFirstNameElement : ownerDetailsPrepopulatedList) {
            String actualFirstnameIndicatorInApplication = ownerFirstNameElement.getText();
            String expectedFirstNameIndicatorKeyedInLastScreen = "Please provide " + stolenItemOwnerFirstName + "'s details";
            if (actualFirstnameIndicatorInApplication.equalsIgnoreCase(expectedFirstNameIndicatorKeyedInLastScreen)) {
                found = true;
                _contactDetails.clickSomeOneElseOwnerCantFindAddressCheckBox(elementInApplicationIndex);
                keyInAddressOfSomebodyElseOwnerManually(elementInApplicationIndex, false);
                _persistentData.setContext("someBodyElseOwnerElementIndex", elementInApplicationIndex);
                break;
            }
            elementInApplicationIndex++;
        }
        if (!found) {
            Assert.assertTrue(false, "Owner section for Owner : " + stolenItemOwnerFirstName + " does not exist");
        }
    }

    @Then("I should be able to see details of the owner of second damaged Item prepopulated")
    public void i_should_be_able_to_see_details_of_the_owner_of_second_damaged_Item_prepopulated() {
        String stolenItemOwnerFirstName = (String) _persistentData.getContext("whatWasDamaged.owner.firstName");
        List<WebElement> ownerDetailsPrepopulatedList = _contactDetails.getTextOfSomeoneElseDoesOwnerFirstNameHeaderInContactDetailsPage();
        int elementInApplicationIndex = 0;
        boolean found = false;
        for (WebElement ownerFirstNameElement : ownerDetailsPrepopulatedList) {
            String actualFirstnameIndicatorInApplication = ownerFirstNameElement.getText();
            String expectedFirstNameIndicatorKeyedInLastScreen = "Please provide " + stolenItemOwnerFirstName + "'s details";
            if (actualFirstnameIndicatorInApplication.equalsIgnoreCase(expectedFirstNameIndicatorKeyedInLastScreen)) {
                found = true;
                keyInAddressOfSomebodyElseOwner(elementInApplicationIndex);
                _persistentData.setContext("someBodyElseOwnerElementIndex", elementInApplicationIndex);
                break;
            }
            elementInApplicationIndex++;
        }
        if (!found) {
            Assert.assertTrue(false, "Owner section for Owner : " + stolenItemOwnerFirstName + " does not exist");
        }
    }

    @Then("I should be able to see details of the owner of second damaged Item prepopulated and key in manually entered address")
    public void i_should_be_able_to_see_details_of_the_owner_of_second_damaged_Item_prepopulated_and_key_in_manually_entered_address() {
        String stolenItemOwnerFirstName = (String) _persistentData.getContext("whatWasDamaged.owner.firstName");
        List<WebElement> ownerDetailsPrepopulatedList = _contactDetails.getTextOfSomeoneElseDoesOwnerFirstNameHeaderInContactDetailsPage();
        int elementInApplicationIndex = 0;
        boolean found = false;
        for (WebElement ownerFirstNameElement : ownerDetailsPrepopulatedList) {
            String actualFirstnameIndicatorInApplication = ownerFirstNameElement.getText();
            String expectedFirstNameIndicatorKeyedInLastScreen = "Please provide " + stolenItemOwnerFirstName + "'s details";
            if (actualFirstnameIndicatorInApplication.equalsIgnoreCase(expectedFirstNameIndicatorKeyedInLastScreen)) {
                found = true;
                _contactDetails.clickSomeOneElseOwnerCantFindAddressCheckBox(elementInApplicationIndex);
                keyInAddressOfSomebodyElseOwnerManually(elementInApplicationIndex, false);
                _persistentData.setContext("someBodyElseOwnerElementIndex", elementInApplicationIndex);
                break;
            }
            elementInApplicationIndex++;
        }
        if (!found) {
            Assert.assertTrue(false, "Owner section for Owner : " + stolenItemOwnerFirstName + " does not exist");
        }
    }


    @Then("I should be able to see details of the owner of second damaged Item prepopulated and key in manually entered International address")
    public void i_should_be_able_to_see_details_of_the_owner_of_second_damaged_Item_prepopulated_and_key_in_manually_entered_international_address() {
        String stolenItemOwnerFirstName = (String) _persistentData.getContext("whatWasDamaged.owner.firstName");
        List<WebElement> ownerDetailsPrepopulatedList = _contactDetails.getTextOfSomeoneElseDoesOwnerFirstNameHeaderInContactDetailsPage();
        int elementInApplicationIndex = 0;
        boolean found = false;
        for (WebElement ownerFirstNameElement : ownerDetailsPrepopulatedList) {
            String actualFirstnameIndicatorInApplication = ownerFirstNameElement.getText();
            String expectedFirstNameIndicatorKeyedInLastScreen = "Please provide " + stolenItemOwnerFirstName + "'s details";
            if (actualFirstnameIndicatorInApplication.equalsIgnoreCase(expectedFirstNameIndicatorKeyedInLastScreen)) {
                found = true;
                _contactDetails.clickSomeOneElseOwnerCantFindAddressCheckBox(elementInApplicationIndex);
                keyInAddressOfSomebodyElseOwnerManually(elementInApplicationIndex, true);
                _persistentData.setContext("someBodyElseOwnerElementIndex", elementInApplicationIndex);
                break;
            }
            elementInApplicationIndex++;
        }
        if (!found) {
            Assert.assertTrue(false, "Owner section for Owner : " + stolenItemOwnerFirstName + " does not exist");
        }
    }

    @Then("I should be able to see details of the owner of second damaged vehicle prepopulated")
    public void i_should_be_able_to_see_details_of_the_owner_of_second_damaged_vehicle_prepopulated() {
        String damagedVehicleOwnerFirstName = (String) _persistentData.getContext("damagedVehicles.owner.firstName");
        List<WebElement> ownerDetailsPrepopulatedList = _contactDetails.getTextOfSomeoneElseDoesOwnerFirstNameHeaderInContactDetailsPage();
        int elementInApplicationIndex = 0;
        boolean found = false;
        for (WebElement ownerFirstNameElement : ownerDetailsPrepopulatedList) {
            String actualFirstnameIndicatorInApplication = ownerFirstNameElement.getText();
            String expectedFirstNameIndicatorKeyedInLastScreen = "Please provide " + damagedVehicleOwnerFirstName + "'s details";
            if (actualFirstnameIndicatorInApplication.equalsIgnoreCase(expectedFirstNameIndicatorKeyedInLastScreen)) {
                found = true;
                keyInAddressOfSomebodyElseOwner(0);
                _persistentData.setContext("someBodyElseOwnerElementIndex", elementInApplicationIndex);
                break;
            }
            elementInApplicationIndex++;
        }
        if (!found) {
            Assert.assertTrue(false, "Owner section for Owner : " + damagedVehicleOwnerFirstName + " does not exist");
        }
    }

    @Then("I should be able to see details of the owner of second damaged vehicle prepopulated and key in manually entered address")
    public void i_should_be_able_to_see_details_of_the_owner_of_second_damaged_vehicle_prepopulated_and_key_in_manually_entered_address() {
        String damagedVehicleOwnerFirstName = (String) _persistentData.getContext("damagedVehicles.owner.firstName");
        List<WebElement> ownerDetailsPrepopulatedList = _contactDetails.getTextOfSomeoneElseDoesOwnerFirstNameHeaderInContactDetailsPage();
        int elementInApplicationIndex = 0;
        boolean found = false;
        for (WebElement ownerFirstNameElement : ownerDetailsPrepopulatedList) {
            String actualFirstnameIndicatorInApplication = ownerFirstNameElement.getText();
            String expectedFirstNameIndicatorKeyedInLastScreen = "Please provide " + damagedVehicleOwnerFirstName + "'s details";
            if (actualFirstnameIndicatorInApplication.equalsIgnoreCase(expectedFirstNameIndicatorKeyedInLastScreen)) {
                found = true;
                _contactDetails.clickSomeOneElseOwnerCantFindAddressCheckBox(0);
                keyInAddressOfSomebodyElseOwnerManually(0, false);
                _persistentData.setContext("someBodyElseOwnerElementIndex", elementInApplicationIndex);
                break;
            }
            elementInApplicationIndex++;
        }
        if (!found) {
            Assert.assertTrue(false, "Owner section for Owner : " + damagedVehicleOwnerFirstName + " does not exist");
        }
    }

    @Then("I should be able to see details of the owner of second lost item prepopulated")
    public void i_should_be_able_to_see_details_of_the_owner_of_second_lost_item_prepopulated() {
        String lostItemOwnerFirstName = (String) _persistentData.getContext("whatWasLost.owner.firstName");
        List<WebElement> ownerDetailsPrepopulatedList = _contactDetails.getTextOfSomeoneElseDoesOwnerFirstNameHeaderInContactDetailsPage();
        int elementInApplicationIndex = 0;
        boolean found = false;
        for (WebElement ownerFirstNameElement : ownerDetailsPrepopulatedList) {
            String actualFirstnameIndicatorInApplication = ownerFirstNameElement.getText();
            String expectedFirstNameIndicatorKeyedInLastScreen = "Please provide " + lostItemOwnerFirstName + "'s details";
            if (actualFirstnameIndicatorInApplication.equalsIgnoreCase(expectedFirstNameIndicatorKeyedInLastScreen)) {
                found = true;
                keyInAddressOfSomebodyElseOwner(0);
                _persistentData.setContext("someBodyElseOwnerElementIndex", elementInApplicationIndex);
                break;
            }
            elementInApplicationIndex++;
        }
        if (!found) {
            Assert.assertTrue(false, "Owner section for Owner : " + lostItemOwnerFirstName + " does not exist");
        }
    }

    @Then("I should be able to see details of the owner of second lost item prepopulated and address keyed in manually")
    public void i_should_be_able_to_see_details_of_the_owner_of_second_lost_item_prepopulated_manual_address() {
        String lostItemOwnerFirstName = (String) _persistentData.getContext("whatWasLost.owner.firstName");
        List<WebElement> ownerDetailsPrepopulatedList = _contactDetails.getTextOfSomeoneElseDoesOwnerFirstNameHeaderInContactDetailsPage();
        int elementInApplicationIndex = 0;
        boolean found = false;
        for (WebElement ownerFirstNameElement : ownerDetailsPrepopulatedList) {
            String actualFirstnameIndicatorInApplication = ownerFirstNameElement.getText();
            String expectedFirstNameIndicatorKeyedInLastScreen = "Please provide " + lostItemOwnerFirstName + "'s details";
            if (actualFirstnameIndicatorInApplication.equalsIgnoreCase(expectedFirstNameIndicatorKeyedInLastScreen)) {
                found = true;
                _eventLost.clickOnCheckBoxCantFindAddressSomeOneElseOwner(elementInApplicationIndex);
                keyInAddressOfSomebodyElseOwnerManually(elementInApplicationIndex, false);
                _persistentData.setContext("someBodyElseOwnerElementIndex", elementInApplicationIndex);
                break;
            }
            elementInApplicationIndex++;
        }
        if (!found) {
            Assert.assertTrue(false, "Owner section for Owner : " + lostItemOwnerFirstName + " does not exist");
        }
    }

    @Then("I should be able to see details of the owner of second lost item prepopulated and key in manually entered address")
    public void i_should_be_able_to_see_details_of_the_owner_of_second_lost_item_prepopulated_and_key_in_manually_entered_address() {
        String lostItemOwnerFirstName = (String) _persistentData.getContext("whatWasLost.owner.firstName");
        List<WebElement> ownerDetailsPrepopulatedList = _contactDetails.getTextOfSomeoneElseDoesOwnerFirstNameHeaderInContactDetailsPage();
        int elementInApplicationIndex = 0;
        boolean found = false;
        for (WebElement ownerFirstNameElement : ownerDetailsPrepopulatedList) {
            String actualFirstnameIndicatorInApplication = ownerFirstNameElement.getText();
            String expectedFirstNameIndicatorKeyedInLastScreen = "Please provide " + lostItemOwnerFirstName + "'s details";
            if (actualFirstnameIndicatorInApplication.equalsIgnoreCase(expectedFirstNameIndicatorKeyedInLastScreen)) {
                found = true;
                _contactDetails.clickSomeOneElseOwnerCantFindAddressCheckBox(0);
                keyInAddressOfSomebodyElseOwnerManually(0, false);
                _persistentData.setContext("someBodyElseOwnerElementIndex", elementInApplicationIndex);
                break;
            }
            elementInApplicationIndex++;
        }
        if (!found) {
            Assert.assertTrue(false, "Owner section for Owner : " + lostItemOwnerFirstName + " does not exist");
        }
    }

    @Then("I should be able to add details of the owner of second damaged vehicle")
    public void i_should_be_able_to_add_phone_number_of_the_owner_of_second_damaged_vehicle() {
        _contactDetails.keyInAgeOfOwnerSomeOneElse(0);
        _contactDetails.selectInGenderOfOwnerSomeOneElse(0);
        _contactDetails.selectRelationsShipOfOwnerSomeOneElse(0);
        _contactDetails.selectAddressTypeSomeOneElseOwner(0);
        _contactDetails.keyInEmailAddressOfOwnerSomeOneElse(0);
        _contactDetails.selectPhoneTypeOfOwnerOwnerSomeOneElse(0);
        _contactDetails.keyInPhoneNumberOfOwnerSomeOneElse(0);
        _contactDetails.selectSomeElseOwnerVictimSupportFlag("Yes", 0);
    }

    @Then("I should be able to add details of the owner of second lost item")
    public void i_should_be_able_to_add_details_of_the_owner_of_second_lost_item() {
        _contactDetails.keyInAgeOfOwnerSomeOneElse(0);
        _contactDetails.selectInGenderOfOwnerSomeOneElse(0);
        _contactDetails.selectRelationsShipOfOwnerSomeOneElse(0);
        _contactDetails.selectAddressTypeSomeOneElseOwner(0);
        _contactDetails.keyInEmailAddressOfOwnerSomeOneElse(0);
        _contactDetails.selectPhoneTypeOfOwnerOwnerSomeOneElse(0);
        _contactDetails.keyInPhoneNumberOfOwnerSomeOneElse(0);
    }


    @Then("I should be able to see details of the owner of third damaged vehicle prepopulated and key in address of Organisation")
    public void i_should_be_able_to_see_details_of_the_owner_of_third_damaged_vehicle_prepopulated() {
        String damagedVehicleOwnerOrganisationName = (String) _persistentData.getContext("damagedVehicles.owner.organisationName");
        List<WebElement> ownerDetailsPrepopulatedList = _contactDetails.getTextOfOrganisationDoesOwnerFirstNameHeaderInContactDetailsPage();
        int elementInApplicationIndex = 0;
        boolean found = false;
        for (WebElement ownerFirstNameElement : ownerDetailsPrepopulatedList) {
            String actualFirstnameIndicatorInApplication = ownerFirstNameElement.getText();
            String expectedFirstNameIndicatorKeyedInLastScreen = "Please provide " + damagedVehicleOwnerOrganisationName + "'s details";
            if (actualFirstnameIndicatorInApplication.equalsIgnoreCase(expectedFirstNameIndicatorKeyedInLastScreen)) {
                found = true;
                keyInAddressOfOrganisationOwner(0);
                _persistentData.setContext("someBodyElseOwnerElementIndex", elementInApplicationIndex);
                break;
            }
            elementInApplicationIndex++;
        }
        if (!found) {
            Assert.assertTrue(false, "Owner section for Owner : " + damagedVehicleOwnerOrganisationName + " does not exist");
        }
    }

    @Then("I should be able to see details of the owner of third damaged vehicle prepopulated and key in address of Organisation manually")
    public void i_should_be_able_to_see_details_of_the_owner_of_third_damaged_vehicle_prepopulated_manually() {
        String damagedVehicleOwnerOrganisationName = (String) _persistentData.getContext("damagedVehicles.owner.organisationName");
        List<WebElement> ownerDetailsPrepopulatedList = _contactDetails.getTextOfOrganisationDoesOwnerFirstNameHeaderInContactDetailsPage();
        int elementInApplicationIndex = 0;
        boolean found = false;
        for (WebElement ownerFirstNameElement : ownerDetailsPrepopulatedList) {
            String actualFirstnameIndicatorInApplication = ownerFirstNameElement.getText();
            String expectedFirstNameIndicatorKeyedInLastScreen = "Please provide " + damagedVehicleOwnerOrganisationName + "'s details";
            if (actualFirstnameIndicatorInApplication.equalsIgnoreCase(expectedFirstNameIndicatorKeyedInLastScreen)) {
                found = true;
                keyInaddressOfOrganisationOwnerManually(elementInApplicationIndex);
                _persistentData.setContext("someBodyElseOwnerElementIndex", elementInApplicationIndex);
                break;
            }
            elementInApplicationIndex++;
        }
        _contactDetails.selectInOrganisationOwnerPhoneType(0);
        _contactDetails.keyInOrganisationOwnerPhoneNumber(0);
        if (!found) {
            Assert.assertTrue(false, "Owner section for Owner : " + damagedVehicleOwnerOrganisationName + " does not exist");
        }
    }


    @Then("I should be able to see details of the owner of third lost item prepopulated and key in address of Organisation")
    public void i_should_be_able_to_see_details_of_the_owner_of_third_lost_item_prepopulated_and_key_in_address_of_Organisation() {
        String lostItemOwnerOrganisationName = (String) _persistentData.getContext("whatWasLost.owner.organisationName");
        List<WebElement> ownerDetailsPrepopulatedList = _contactDetails.getTextOfOrganisationDoesOwnerFirstNameHeaderInContactDetailsPage();
        int elementInApplicationIndex = 0;
        boolean found = false;
        for (WebElement ownerFirstNameElement : ownerDetailsPrepopulatedList) {
            String actualFirstnameIndicatorInApplication = ownerFirstNameElement.getText();
            String expectedFirstNameIndicatorKeyedInLastScreen = "Please provide " + lostItemOwnerOrganisationName + "'s details";
            if (actualFirstnameIndicatorInApplication.equalsIgnoreCase(expectedFirstNameIndicatorKeyedInLastScreen)) {
                found = true;
                keyInAddressOfOrganisationOwner(0);
                _persistentData.setContext("someBodyElseOwnerElementIndex", elementInApplicationIndex);
                break;
            }
            elementInApplicationIndex++;
        }
        if (!found) {
            Assert.assertTrue(false, "Owner section for Owner : " + lostItemOwnerOrganisationName + " does not exist");
        }
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
        _contactDetails.selectInOrganisationOwnerPhoneType(0);
        _contactDetails.keyInOrganisationOwnerPhoneNumber(0);
        if (!found) {
            Assert.assertTrue(false, "Owner section for Owner : " + lostItemOwnerOrganisationName + " does not exist");
        }
    }

    public void keyInAddressOfSomebodyElseOwner(int index) {
        _contactDetails.keyInAddressOfOwnerSomeOneElse(index);
    }

    public void keyInAddressOfSomebodyElseOwnerManually(int index, boolean isAddressInternational) {
        if (isAddressInternational) {
            _contactDetails.keyInAddressOfOwnerSomeOneElse(index, true, true);
        } else {
            _contactDetails.keyInAddressOfOwnerSomeOneElse(index, true, false);
        }
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
        List<WebElement> ownerDetailsPrepopulatedList = _contactDetails.getTextOfOrganisationDoesOwnerFirstNameHeaderInContactDetailsPage();
        int organisationOwnerNameElementIndex = 0;
        boolean found = false;
        for (WebElement organisationName : ownerDetailsPrepopulatedList) {
            String actualOrganisationNameInApplication = organisationName.getText();
            String expectedOrganisationNameKeyedInLastScreen = "Please provide " + stolenItemOwnerOrganisationName + "'s details";
            if (actualOrganisationNameInApplication.equalsIgnoreCase(expectedOrganisationNameKeyedInLastScreen)) {
                found = true;
                _persistentData.setContext("organisationOwnerNameElementIndex", organisationOwnerNameElementIndex);
                organisationOwnerNameElementIndex = organisationOwnerNameElementIndex + 1;
                break;
            }
        }
        if (!found) {
            Assert.assertTrue(false, "Owner section for Owner : " + stolenItemOwnerOrganisationName + " does not exist");
        }
    }

    @Then("I should be able to see details of the owner of third damaged Item prepopulated")
    public void i_should_be_able_to_see_details_of_the_owner_of_third_damaged_Item_prepopulated() {
        String stolenItemOwnerOrganisationName = (String) _persistentData.getContext("whatWasDamaged.owner.organisationName");
        List<WebElement> ownerDetailsPrepopulatedList = _contactDetails.getTextOfOrganisationDoesOwnerFirstNameHeaderInContactDetailsPage();
        int elementInApplicationIndex = 0;
        boolean found = false;
        for (WebElement organisationName : ownerDetailsPrepopulatedList) {
            String actualOrganisationNameInApplication = organisationName.getText();
            String expectedOrganisationNameKeyedInLastScreen = "Please provide " + stolenItemOwnerOrganisationName + "'s details";
            if (actualOrganisationNameInApplication.equalsIgnoreCase(expectedOrganisationNameKeyedInLastScreen)) {
                found = true;
                _persistentData.setContext("organisationOwnerNameElementIndex", elementInApplicationIndex);
                break;
            }
            elementInApplicationIndex++;
        }
        if (!found) {
            Assert.assertTrue(false, "Owner section for Owner : " + stolenItemOwnerOrganisationName + " does not exist");
        }
    }


    @Then("I should be able to see details of the owner of second stolen vehicle prepopulated")
    public void i_should_be_able_to_see_details_of_the_owner_of_second_stolen_vehicle_prepopulated() {
        String stolenVehicleOwnerFirstName = (String) _persistentData.getContext("stolenVehicles.owner.firstName");
        List<WebElement> ownerDetailsPrepopulatedList = _contactDetails.getTextOfSomeoneElseDoesOwnerFirstNameHeaderInContactDetailsPage();
        int someBodyElseOwnerElementIndex = 0;
        boolean found = false;
        for (WebElement ownerFirstNameElement : ownerDetailsPrepopulatedList) {
            String actualFirstnameIndicatorInApplication = ownerFirstNameElement.getText();
            String expectedFirstNameIndicatorKeyedInLastScreen = "Please provide " + stolenVehicleOwnerFirstName + "'s details";
            if (actualFirstnameIndicatorInApplication.equalsIgnoreCase(expectedFirstNameIndicatorKeyedInLastScreen)) {
                found = true;
                keyInAddressOfSomebodyElseOwner(0);
                someBodyElseOwnerElementIndex = (int) _persistentData.getContext("someBodyElseOwnerElementIndex");
                someBodyElseOwnerElementIndex = someBodyElseOwnerElementIndex + 1;
                _persistentData.setContext("someBodyElseOwnerElementIndex", someBodyElseOwnerElementIndex);
                break;
            }

        }
        if (!found) {
            Assert.assertTrue(false, "Owner section for Owner : " + stolenVehicleOwnerFirstName + " does not exist");
        }
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
                keyInAddressOfSomebodyElseOwnerManually(elementInApplicationIndex, false);
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
        List<WebElement> ownerDetailsPrepopulatedList = _contactDetails.getTextOfOrganisationDoesOwnerFirstNameHeaderInContactDetailsPage();
        int organisationOwnerNameElementIndex = 0;
        boolean found = false;
        for (WebElement organisationName : ownerDetailsPrepopulatedList) {
            String actualOrganisationNameInApplication = organisationName.getText();
            String expectedOrganisationNameKeyedInLastScreen = "Please provide " + stolenItemOwnerOrganisationName + "'s details";
            if (actualOrganisationNameInApplication.equalsIgnoreCase(expectedOrganisationNameKeyedInLastScreen)) {
                found = true;
                organisationOwnerNameElementIndex = (int) _persistentData.getContext("organisationOwnerNameElementIndex");
                organisationOwnerNameElementIndex = organisationOwnerNameElementIndex + 1;
                _persistentData.setContext("organisationOwnerNameElementIndex", organisationOwnerNameElementIndex);
                break;
            }
        }
        if (!found) {
            Assert.assertTrue(false, "Owner section for Owner : " + stolenItemOwnerOrganisationName + " does not exist");
        }
    }

    @Then("I click on Continue to navigate to Summary Page")
    public void I_click_on_Continue_to_navigate_to_Summary_Page() {
        _contactDetails.clickOnContinueToNavigateToSummaryPage();
    }


    @Then("I should be able to add address of the organisation of stolen Item Owner")
    public void i_should_be_able_to_add_address_of_the_organisation_of_stolen_Item_owner() {
        int index = (int) _persistentData.getContext("organisationOwnerNameElementIndex");
        _contactDetails.keyInAddressOfOrganisationOwner(index);
    }

    @Then("I should be able to add address of the organisation of stolen Item Owner manually")
    public void i_should_be_able_to_add_address_of_the_organisation_of_stolen_Item_owner_manually() {
        int index = (int) _persistentData.getContext("organisationOwnerNameElementIndex");
        _contactDetails.keyInAddressOfOrganisationOwner(index, true);
    }

    @Then("I should be able to add address of the organisation of damaged Item Owner")
    public void i_should_be_able_to_add_address_of_the_organisation_of_damaged_Item_owner() {
        int index = (int) _persistentData.getContext("organisationOwnerNameElementIndex");
        _contactDetails.keyInAddressOfOrganisationOwner(index);
    }

    @Then("I should be able to add address of the organisation of damaged Item Owner manually")
    public void i_should_be_able_to_add_address_of_the_organisation_of_damaged_Item_owner_manually() {
        int index = (int) _persistentData.getContext("organisationOwnerNameElementIndex");
        _contactDetails.keyInAddressOfOrganisationOwner(index, true);
    }


    @Then("I should be able to add address of the organisation of damaged Vehicle Owner")
    public void i_should_be_able_to_add_address_of_the_organisation_of_damaged_Vehicle_owner() {

    }

    @Then("I should be able to add address of the organisation of stolen Vehicle Owner")
    public void i_should_be_able_to_add_address_of_the_organisation_of_stolen_Vehicle_owner() {
        int index = (int) _persistentData.getContext("organisationOwnerNameElementIndex");
        _contactDetails.keyInAddressOfOrganisationOwner(index);
    }

    @Then("I should be able to add address of the organisation of stolen Vehicle Owner manually")
    public void i_should_be_able_to_add_address_of_the_organisation_of_stolen_Vehicle_owner_manually() {
        _contactDetails.keyInAddressOfOrganisationOwner(1, true);
    }

    //*********************************************

    @When("I have already selected the address of the reporter from the search bar")
    public void i_have_already_selected_the_address_of_the_reporter_from_the_search_bar() {
        _contactDetails.keyInReporterAddress();
    }

    @Then("I should not be allowed to choose 'can't find the address' checkbox to key in reporter's address")
    public void i_should_not_be_allowed_to_choose_can_s_address() {
        _contactDetails.checkReporterCantFindAddressIsInvisible();
    }

    @When("I have intend to choose reporters address manually by selecting 'cant find address' checkbox")
    public void i_have_intend_to_choose_reporter_cant_find_address_checkbox() {
        _contactDetails.checkReporterCantFindAddressIsVisible();
        _contactDetails.clickReporterCantFindAddressCheckBox();
    }

    @Then("I should not be allowed to use autocomplete field to key in reporter's address")
    public void i_should_not_be_allowed_to_use_autocomplete_field_to_key_in_reporter_s_address() {
        _contactDetails.checkReporterAddressAutoCompleteFieldIsInvisible();
    }

    @When("I have already selected the address of the Somebody else does owner from the search bar")
    public void i_have_already_selected_the_address_of_the_Somebody_else_does_owner_from_the_search_bar() {
        Assert.assertTrue(_contactDetails.checkSomeOneElseOwnerCantFindAddressIsVisible());
        _contactDetails.keyInAddressOfOwnerSomeOneElse(0);
    }

    @Then("I should not be allowed to choose 'cant find address' checkbox to key in Somebody else does owners address")
    public void i_should_not_be_allowed_to_choose_t_find_address_checkbox_to_key_in_Somebody_else_does_owners_address() {
        Assert.assertTrue(_contactDetails.checkSomeOneElseOwnerCantFindAddressIsInvisible());
    }

    @When("I have already selected the address of the Organisation owner from the search bar")
    public void i_have_already_selected_the_address_of_the_Organisation_owner_from_the_search_bar() {
        Assert.assertTrue(_contactDetails.checkOrganisationOwnerCantFindAddressIsVisible());
        _contactDetails.keyInAddressOfOrganisationOwner(0);
    }

    @Then("I should not be allowed to choose 'cant find address' checkbox to key in Organisation owners address")
    public void i_should_not_be_allowed_to_choose_t_find_address_checkbox_to_key_in_Organisation_owners_address() {
        Assert.assertTrue(_contactDetails.checkOrganisationOwnerCantFindAddressIsInvisible());
    }

    @When("I have intend to choose Somebody else does owners address manually by selecting cant find address checkbox")
    public void i_have_intend_to_choose_Somebody_else_does_owners_address_manually_by_selecting_checkbox() {
        _contactDetails.clickSomeOneElseOwnerCantFindAddressCheckBox();
    }

    @Then("I should not be allowed to use autocomplete field to key in Somebody else does owner address")
    public void i_should_not_be_allowed_to_use_autocomplete_field_to_key_in_Somebody_else_does_owner_address() {
        Assert.assertTrue(_contactDetails.checkSomeOneElseOwnerAddressAutoCompleteFieldIsInvisible());
    }

    @When("I have intend to choose Organisation owner address manually by selecting cant find address checkbox")
    public void i_have_intend_to_choose_Organisation_owner_address_manually_by_selecting_checkbox() {
        _contactDetails.clickOrganisationOwnerCantFindAddressCheckBox();
    }

    @Then("I should not be allowed to use autocomplete field to key in Somebody else does Organisation owner address")
    public void i_should_not_be_allowed_to_use_autocomplete_field_to_key_in_Somebody_else_does_Organisation_owner_address() {
        Assert.assertTrue(_contactDetails.checkOrganisationOwnerAddressAutoCompleteFieldIsInvisible());
    }

    @And("I key in my personal information without phone type and phone number")
    public void iKeyInMyPersonalInformationWithoutPhoneTypeAndPhoneNumber() {
        _contactDetails.enterPersonInformationWithoutPhoneAndType();
    }

    @Then("I can validate that phone type is a mandatory field")
    public void iCanValidateThatPhoneTypeIsAMandatoryField() {
        Assert.assertEquals(_contactDetails.waitandGetText(_contactDetails.getPhoneTypeErrorMessage()),
                _generateTestData.generateValidData("personalInformation.mandatoryFieldErrorMessage"));
    }

    @And("I click on Continue to navigate to Summary Page and close the alert")
    public void iClickOnContinueToNavigateToSummaryPageAndCloseTheAlert() throws InterruptedException, AWTException {
        _contactDetails.continueAndCloseAlert();
    }


    @When("I select a phone Type")
    public void iSelectAPhoneType() {
        _contactDetails.selectPhoneType();
    }


    @Then("I should not be allowed to proceed to next page and see the error {string}")
    public void iShouldBeAbleToSeeTheErrorMessageThatSaysTheDateIsInFuture(String message) {
        Assert.assertEquals(_contactDetails.getReporterFutureDateError(), message);
    }

    @Then("I should not be allowed to proceed to next page and see the error message that says the date is current")
    public void iShouldBeAbleToSeeTheErrorMessageThatSaysTheDateIsInCurrentDate() {
        Assert.assertEquals(_contactDetails.getReporterFutureDateError(), "DOB: The current date as a date of birth cannot be accepted");
    }

    @And("I should be able to navigate to the summary page when i use a valid Reporter DOB")
    public void iShouldBeAbleToNavigateToTheSummaryPageWhenIUseAValidReporterDOB() {
        _contactDetails.keyInReporterDOB();
        _contactDetails.clickOnContinueToNavigateToSummaryPage();
    }

    @And("I should be able to navigate to the summary page when i use a valid Item Owner DOB in ddmmYYYY format")
    public void iShouldBeAbleToNavigateToTheSummaryPageWhenIUseAValidOwnerDOBinddmmYYYY() {
        int index = (int) _persistentData.getContext("someBodyElseOwnerElementIndex");
        _contactDetails.keyInAgeOfOwnerSomeOneElseInDDMMYYYY(index);
        _contactDetails.clickOnContinueToNavigateToSummaryPage();
    }

    @And("I should be able to navigate to the summary page when i use a valid Item Owner DOB as age in years")
    public void iShouldBeAbleToNavigateToTheSummaryPageWhenIUseAValidOwnerDOBasAgeInYears() {
        int index = (int) _persistentData.getContext("someBodyElseOwnerElementIndex");
        _contactDetails.keyInAgeOfOwnerSomeOneElse(index);
        _contactDetails.clickOnContinueToNavigateToSummaryPage();
    }
}
