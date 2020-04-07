package features.OnlineReporting.StepDefinitions;

import cucumber.api.java.en.Then;
import libs.DriverFactory;
import org.testng.Assert;

public class SummarySteps extends DriverFactory {

    @Then("I should be able to verify all the keyed in data in the summary screen")
    public void i_should_be_able_to_verify_all_the_keyed_in_data_in_the_summary_screen() {
        /*validateEventTimeSectionDetails();
        String location = (String) _persistentData.getContext("whereDidItHappen.location");
        validateLocationSectionDetails(location);
        validateOffenderSectionDetails();
        validateDetailsInHurtSectionDetails();
        validateWhatHappendSectionDetails();
        validateAttachmentSectionDetails();
        validateReporterSectionDetails();*/
    }

    public void validateEventTimeSectionDetails() {
        String formattedStartDate = _summary.summaryformatDate("dd/MM/yyyy", "dd MMMM, yyyy", _persistentData.getStringPersistentData("whenDidItHappen.startDate"));
        String formattedEndDate = _summary.summaryformatDate("dd/MM/yyyy", "dd MMMM, yyyy", _persistentData.getStringPersistentData("whenDidItHappen.endDate"));
        Assert.assertTrue(_summary.getWhenDidItHappenSectionDisplayed());
        Assert.assertEquals(_summary.getStartDate(), formattedStartDate, "Mismatch in Start date in summary page");
        Assert.assertEquals(_summary.getStartTime(), _persistentData.getStringPersistentData("whenDidItHappen.startTime"), "Mismatch in Start time in summary page");
        Assert.assertEquals(_summary.getEndDate(), formattedEndDate, "Mismatch in End date in summary page");
        Assert.assertEquals(_summary.getEndTime(), _persistentData.getStringPersistentData("whenDidItHappen.endTime"), "Mismatch in End time in summary page");

    }

    private void validateLocationSectionDetails(String locationSelected) {
        Assert.assertTrue(_summary.getLocationSectionDisplayed());
        switch (locationSelected) {
            case "A shop/business":
                validateLocationShopBusinessDetails();
                break;
            case "An organisation":
                validateLocationOrganisationDetails();
                break;
            case "A home":
                validateLocationHomeDetails();
                break;
            case "A public place":
                validateLocationPublicPlaceDetails();
                break;
            case "On a journey":
                validateLocationJourneyDetails();
                break;
            case "Place of worship":
                validateLocationPlaceOfWorshipDetails();
                break;
            case "Educational Facility":
                validateLocationEducationalFacilityDetails();
                break;
            case "Other":
                validateLocationOtherDetails();
                break;
            default:
                System.out.println("Location : " + locationSelected + " not found in the list. Test failed");
                Assert.assertTrue(false, "Location value entered through the feature files not present in the application");

        }
        validateStolenItemInVehicleSectionDetails();
    }

    public void validateStolenItemInVehicleSectionDetails() {
        if (_persistentData.getStringPersistentData("isStolenItemsTakenFromVehicle").equalsIgnoreCase("yes")) {
            Assert.assertEquals(_summary.getLocationStolenItemsInsideVehicle(), _persistentData.getStringPersistentData("stolenFromVehicle.value"));
            Assert.assertEquals(_summary.getLocationStolenItemsInsideVehicleLicensePlace(), _persistentData.getStringPersistentData("stolenFromVehicle.licencePlate"));
            Assert.assertEquals(_summary.getLocationStolenItemsInsideVehicleVehicleLocation(), _persistentData.getStringPersistentData("stolenFromVehicle.vehicleLocation"));
        }
    }

    public void validateLocationShopBusinessDetails() {
        Assert.assertEquals(_summary.getLocationShopBusinessName(), _persistentData.getStringPersistentData("whereDidItHappen.locationShop.shopName"));
        Assert.assertEquals(_summary.getLocationShopBusinessAddress(), _persistentData.getStringPersistentData("whereDidItHappen.locationShop.shopAddress"));
        Assert.assertEquals(_summary.getLocationShopBusinessAdditionalInformation(), _persistentData.getStringPersistentData("whereDidItHappen.locationShop.shopAdditionalInformation"));
    }

    public void validateLocationOrganisationDetails() {
        Assert.assertEquals(_summary.getLocationOrganisationName(), _persistentData.getStringPersistentData("whereDidItHappen.locationOrganisation.organisationName"));
        Assert.assertEquals(_summary.getLocationOrganisationAddress(), _persistentData.getStringPersistentData("whereDidItHappen.locationOrganisation.organisationAddress"));
        Assert.assertEquals(_summary.getLocationOrganisationAdditionalInformation(), _persistentData.getStringPersistentData("whereDidItHappen.locationOrganisation.organisationAdditionalInformation"));
    }

    public void validateLocationHomeDetails() {
        Assert.assertEquals(_summary.getLocationHomeAddress(), _persistentData.getStringPersistentData("whereDidItHappen.locationHome.homeAddress"));
        Assert.assertEquals(_summary.getLocationHomeAdditionalInformation(), _persistentData.getStringPersistentData("whereDidItHappen.locationHome.homeAdditionalInformation"));
    }

    public void validateLocationPublicPlaceDetails() {
        Assert.assertEquals(_summary.getLocationPublicPlaceAddress(), _persistentData.getStringPersistentData("whereDidItHappen.locationPublicPlace.publicAddress"));
        Assert.assertEquals(_summary.getLocationPublicPlaceAdditionalInformation(), _persistentData.getStringPersistentData("whereDidItHappen.locationPublicPlace.publicAddtionalInformation"));
    }

    public void validateLocationJourneyDetails() {
        Assert.assertEquals(_summary.getLocationBeginJourneyAddress(), _persistentData.getStringPersistentData("whereDidItHappen.locationJourney.journeyStartAddress"));
        Assert.assertEquals(_summary.getLocationEndJourneyAddress(), _persistentData.getStringPersistentData("whereDidItHappen.locationJourney.journeyEndAddress"));
        Assert.assertEquals(_summary.getLocationJourneyAdditionalInformation(), _persistentData.getStringPersistentData("whereDidItHappen.locationJourney.journeyAdditionalInformation"));
    }

    public void validateLocationPlaceOfWorshipDetails() {
        Assert.assertEquals(_summary.getLocationPlaceOfWorshipName(), _persistentData.getStringPersistentData("whereDidItHappen.locationPlaceOfWorship.placeOfWorshipPlace"));
        Assert.assertEquals(_summary.getLocationPlaceOfWorshipAddress(), _persistentData.getStringPersistentData("whereDidItHappen.locationPlaceOfWorship.placeOfWorshipAddress"));
        Assert.assertEquals(_summary.getLocationPlaceOfWorshipAdditionalInformation(), _persistentData.getStringPersistentData("whereDidItHappen.locationPlaceOfWorship.placeOfWorshipAdditionalInformation"));
    }

    public void validateLocationEducationalFacilityDetails() {
        Assert.assertEquals(_summary.getLocationPlaceOfEducationalFacilityName(), _persistentData.getStringPersistentData("whereDidItHappen.locationEducationalFacility.educationalFacilityName"));
        Assert.assertEquals(_summary.getLocationPlaceOfEducationalFacilityAddress(), _persistentData.getStringPersistentData("whereDidItHappen.locationEducationalFacility.educationalFacilityAddress"));
        Assert.assertEquals(_summary.getLocationPlaceOfEducationalFacilityAdditionalInformation(), _persistentData.getStringPersistentData("whereDidItHappen.locationEducationalFacility.eductionalFacilityInformation"));
    }

    public void validateLocationOtherDetails() {
        Assert.assertEquals(_summary.getLocationOtherAdditionalInformation(), _persistentData.getStringPersistentData("whereDidItHappen.locationOther.otherAdditionalInformation"));
    }

    private void validateOffenderSectionDetails() {
        Assert.assertTrue(_summary.getOffenderInformationSectionDisplayed());
        String knowOffenderFlag = _persistentData.getStringPersistentData("whoWasInvolved.whoHasDoneThis.value");
        if (knowOffenderFlag.equalsIgnoreCase("yes")) {
            Assert.assertEquals(_summary.getOffenderKnowOffenderFlag(), knowOffenderFlag, "Mismatch in End time in summary page");
            Assert.assertEquals(_summary.getOffenderDetails(), _persistentData.getStringPersistentData("whoWasInvolved.whoHasDoneThis.detailAboutOffender"));
            Assert.assertEquals(_summary.getRelationShipOfPerson(), _persistentData.getStringPersistentData("whoWasInvolved.whoHasDoneThis.personIs"));
        } else {
            Assert.assertEquals(_summary.getOffenderKnowOffenderFlag(), knowOffenderFlag, "Mismatch in End time in summary page");
        }

        String describeOffenderFlag = _persistentData.getStringPersistentData("whoWasInvolved.describePerson.value");
        if (describeOffenderFlag.equalsIgnoreCase("yes")) {
            Assert.assertEquals(_summary.getOffenderDescribeFlag(), describeOffenderFlag);
            Assert.assertEquals(_summary.getOffenderDescription(), _persistentData.getStringPersistentData("whoWasInvolved.describePerson.descriptionOfOffender"));
        } else {
            Assert.assertEquals(_summary.getOffenderDescribeFlag(), describeOffenderFlag);
        }

        String offenderVehicleFlag = _persistentData.getStringPersistentData("whoWasInvolved.offenderVehicle.value");
        if (offenderVehicleFlag.equalsIgnoreCase("yes")) {
            Assert.assertEquals(_summary.getOffenderUsedAVehicleFlag(), offenderVehicleFlag);
            Assert.assertEquals(_summary.getOffenderVehicleLicensePlate(), _persistentData.getStringPersistentData("whoWasInvolved.offenderVehicle.licencePlate"));
            Assert.assertEquals(_summary.getOffenderVehicleDescription(), _persistentData.getStringPersistentData("whoWasInvolved.offenderVehicle.vehicleLooks"));
        } else {
            Assert.assertEquals(_summary.getOffenderUsedAVehicleFlag(), offenderVehicleFlag);
        }

        String witnessFlag = _persistentData.getStringPersistentData("whoWasInvolved.witnessInformation.value");
        if (witnessFlag.equalsIgnoreCase("yes")) {
            Assert.assertEquals(_summary.getWitnessFlag(), witnessFlag);
            Assert.assertEquals(_summary.getWitnessDetails(), _persistentData.getStringPersistentData("whoWasInvolved.witnessInformation.witnessDetails"));
        } else {
            Assert.assertEquals(_summary.getWitnessFlag(), witnessFlag);
        }

    }

    public void validateDetailsInHurtSectionDetails() {
        if (_persistentData.getStringPersistentData("hurtIndicator").equalsIgnoreCase("yes")) {
            Assert.assertTrue(_summary.getHurtSectionDisplayed());
            Assert.assertEquals(_summary.getWhowasHurtOrThreatened(), _persistentData.getStringPersistentData("whoWasHurt.whoWasHurt"));
            Assert.assertEquals(_summary.getHowWereTheyHurtOrThreatened(), _persistentData.getStringPersistentData("whoWasHurt.howWasHurt"));
        }
    }

    public void validateWhatHappendSectionDetails() {
        Assert.assertTrue(_summary.getWhatHappenedSectionDisplayed());
        Assert.assertEquals(_summary.getDescribeWhatHappened(), _persistentData.getStringPersistentData("eventInfoGeneric.describeWhatHappened"));
        Assert.assertEquals(_summary.getReasonOfWhyTheyDidThis(), _persistentData.getStringPersistentData("eventInfoGeneric.reason"));
    }

    public void validateAttachmentSectionDetails() {
        Assert.assertTrue(_summary.getIsAttachmentSectionsDisplayed());
        //ToDo - Filename validation
        // Assert.assertEquals(_summary.getAttachmentName(0), _persistentData.getStringPersistentData("fileName"));
        Assert.assertEquals(_summary.getAttachmentFileName(0), _persistentData.getStringPersistentData("fileName"));
        Assert.assertEquals(_summary.getAttachmentDescription(), _persistentData.getStringPersistentData("eventInfoGeneric.describeAttachment"));
    }

    public void validateReporterSectionDetails() {
        String formattedDOB = _summary.summaryformatDate("dd/MM/yyyy", "d/MM/yy", _persistentData.getStringPersistentData("personalInformation.dob"));
        Assert.assertTrue(_summary.getPersonalDetailsSectionDisplayed());
        Assert.assertEquals(_summary.getReporterFirstname(), _persistentData.getStringPersistentData("personalInformation.firstName"));
        Assert.assertEquals(_summary.getReporterMiddlename(), _persistentData.getStringPersistentData("personalInformation.middleName"));
        Assert.assertEquals(_summary.getReporterLastname(), _persistentData.getStringPersistentData("personalInformation.lastName").toUpperCase());
        Assert.assertEquals(_summary.getReporterDOB(), formattedDOB);
        Assert.assertEquals(_summary.getReporterGender(), _persistentData.getStringPersistentData("personalInformation.gender"));
        Assert.assertEquals(_summary.getReporterDriverLicenceNumber(), _persistentData.getStringPersistentData("personalInformation.driverLicense"));
        String previousNameFlag = _persistentData.getStringPersistentData("personalInformation.previousNameIndicator");
        if (previousNameFlag.equalsIgnoreCase("yes")) {
            Assert.assertEquals(_summary.getReporterPreviouslyUsedFirstname(), _persistentData.getStringPersistentData("personalInformation.previousFirstName"));
            Assert.assertEquals(_summary.getReporterPreviouslyUsedMiddlename(), _persistentData.getStringPersistentData("personalInformation.previousMiddleName"));
            Assert.assertEquals(_summary.getReporterPreviouslyUsedLastname(), _persistentData.getStringPersistentData("personalInformation.previousLastName").toUpperCase());
        }

        Assert.assertEquals(_summary.getReporterEmailAddress(), _persistentData.getStringPersistentData("personalInformation.emailAddress"));
        Assert.assertEquals(_summary.getReporterPhoneType(), _persistentData.getStringPersistentData("personalInformation.phoneType"));
        Assert.assertEquals(_summary.getReporterPhoneNumber(), _persistentData.getStringPersistentData("personalInformation.phoneNumber"));
        Assert.assertEquals(_summary.getPreferredContactMethod(), _persistentData.getStringPersistentData("personalInformation.preferredContact"));
        Assert.assertEquals(_summary.getReporterHomeAddress(), _persistentData.getStringPersistentData("personalInformation.homeAddress"));
        Assert.assertEquals(_summary.getVictimSupport(), _persistentData.getStringPersistentData("personalInformation.victimSupportIndicator"));
    }


}



