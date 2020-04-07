package pageObjects.onlineReporting;

import libs.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Summary extends BasePage {

    //Event Info Generic
    private @FindBy(xpath = "//li[@id='current']")
    WebElement linkCurrentPageHeader = null;

    //When did it happen
    private @FindBy(xpath = "//div[@data-test-id='201905210946100436907']")
    WebElement sectionWhenDidItHappen = null;
    private @FindBy(xpath = "//span[@data-test-id='2019050714545402381390-Label']")
    WebElement summaryDatadatePickerStartTimeLabel = null;
    private @FindBy(xpath = "//span[@data-test-id='2019050714545402381390']")
    WebElement summaryDatadatePickerStartTime = null;
    private @FindBy(xpath = "//span[@data-test-id='20190507154245086822959-Label']")
    WebElement summaryDatadatePickerEndTimeLabel = null;
    private @FindBy(xpath = "//span[@data-test-id='20190507154245086822959']")
    WebElement summaryDatadatePickerEndTime = null;
    private @FindBy(xpath = "//span[@data-test-id='2019041808432401367411-Label']")
    WebElement summaryDataStartDateLabel = null;
    private @FindBy(xpath = "//span[@data-test-id='2019041808432401367411']")
    WebElement summaryDatadatePickerStartDate = null;
    private @FindBy(xpath = "//span[@data-test-id='2019041808432401378849-Label']")
    WebElement summaryDatadatePickerEndDateLabel = null;
    private @FindBy(xpath = "//span[@data-test-id='2019041808432401378849']")
    WebElement summaryDatadatePickerEndDate = null;

    //Where did it happen

    //Location of Event
    private @FindBy(xpath = "//div[@data-test-id='201905221104240976846']")
    WebElement sectionWhereDidItHappen = null;
    private @FindBy(xpath = "//span[@data-test-id='2019041210453607233329-Label']")
    WebElement summaryDataLabelLocationTypeLabel = null;
    private @FindBy(xpath = "//span[@data-test-id='2019041210453607233329']")
    WebElement summaryDatadropDownLocationType = null;

    //A shop/business
    private @FindBy(xpath = "//span[@data-test-id='20190412125223095522377-Label']")
    WebElement summaryDataLocationShopBusinessSectionLabel = null;
    private @FindBy(xpath = "//span[@data-test-id='20190412125223095522377']")
    WebElement summaryDataLocationNameShopBusinessName = null;
    private @FindBy(xpath = "//div[@data-test-id='201905221104240976846']//div[@data-test-id='201904121252230955272']//label")
    WebElement summaryDataAddressShopBusinessSectionLabel = null;
    private @FindBy(xpath = "//div[@data-test-id='201905221104240976846']//span[@data-test-id='2019031416193707997247']")
    WebElement summaryDataLocationShopBusinessAddress = null;
    private @FindBy(xpath = "//span[@data-test-id='2019051015242407606536-Label']")
    WebElement summaryDataAdditionalInformationShopBusinessSectionLabel = null;
    private @FindBy(xpath = "//span[@data-test-id='2019051015242407606536']")
    WebElement summaryDataLocationShopBusinessAdditionalInformation = null;


    //An organisation
    private @FindBy(xpath = "//span[@data-test-id='20190412125223095522377']")
    WebElement summaryDataLocationNameOrganisationName = null;
    private @FindBy(xpath = "//div[@data-test-id='201905221104240976846']//span[@data-test-id='2019031416193707997247']")
    WebElement summaryDataLocationOrganisationAddress = null;
    private @FindBy(xpath = "//span[@data-test-id='2019051015242407606536']")
    WebElement summaryDataLocationOrganisationAdditionalInformation = null;

    //A home
    private @FindBy(xpath = "//div[@data-test-id='201905221104240976846']//span[@data-test-id='2019031416193707997247']")
    WebElement summaryDataLocationHomeAddress = null;
    private @FindBy(xpath = "//span[@data-test-id='20190513132454037421702']")
    WebElement summaryDataLocationHomeAdditionalInformation = null;

    //A public place
    private @FindBy(xpath = "//div[@data-test-id='201905221104240976846']//span[@data-test-id='2019031416193707997247']")
    WebElement summaryDataLocationPublicPlaceAddress = null;
    private @FindBy(xpath = "//span[@data-test-id='20190510152238060910455']")
    WebElement summaryDataLocationPublicPlaceAdditionalInformation = null;

    //On a journey
    private @FindBy(xpath = "(//div[@data-test-id='201905221104240976846']//span[@data-test-id='2019031416193707997247'])[1]")
    WebElement summaryDataLocationBeginJourneyAddress = null;
    private @FindBy(xpath = "(//div[@data-test-id='201905221104240976846']//span[@data-test-id='2019031416193707997247'])[2]")
    WebElement summaryDataLocationEndJourneyAddress = null;
    private @FindBy(xpath = "//span[@data-test-id='20190513131445075645871']")
    WebElement summaryDataLocationJourneyAdditionalInformation = null;

    //Place of worship
    private @FindBy(xpath = "//span[@data-test-id='20190412125223095522377']")
    WebElement summaryDataLocationPlaceOfWorshipName = null;
    private @FindBy(xpath = "//div[@data-test-id='201905221104240976846']//span[@data-test-id='2019031416193707997247']")
    WebElement summaryDataLocationPlaceOfWorshipAddress = null;
    private @FindBy(xpath = "//span[@data-test-id='2019051015242407606536']")
    WebElement summaryDataLocationPlaceOfWorshipAdditionalInformation = null;

    //Educational Facility
    private @FindBy(xpath = "//span[@data-test-id='20190412125223095522377']")
    WebElement summaryDataLocationPlaceOfEducationalFacilityName = null;
    private @FindBy(xpath = "//div[@data-test-id='201905221104240976846']//span[@data-test-id='2019031416193707997247']")
    WebElement summaryDataLocationPlaceOfEducationalFacilityAddress = null;
    private @FindBy(xpath = "//span[@data-test-id='2019051015242407606536']")
    WebElement summaryDataLocationPlaceOfEducationalFacilityAdditionalInformation = null;

    //Other
    private @FindBy(xpath = "//span[@data-test-id='20190430151354052969445']")
    WebElement summaryDataLocationOtherAdditionalInformation = null;

    //Vehicle
    private @FindBy(xpath = "//span[@data-test-id='201905161605300538131819']")
    WebElement summaryDataLocationStolenItemsInsideVehicle = null;
    private @FindBy(xpath = "//span[@data-test-id='201905161612340544705376']")
    WebElement summaryDataLocationStolenItemsInsideVehicleLicensePlace = null;
    private @FindBy(xpath = "//span[@data-test-id='201905161612340545706279']")
    WebElement summaryDataLocationStolenItemsInsideVehicleVehicleLocation = null;


    //Offender
    private @FindBy(xpath = "//div[@data-test-id='201905221412290348702']")
    WebElement summaryDataOffenderInformationSection = null;
    //Information of Offender
    private @FindBy(xpath = "//span[@data-test-id='2019041610483800415866-Label']")
    WebElement summaryDataIknowWhoOffenderIsLabel = null;
    private @FindBy(xpath = "//span[@data-test-id='2019041610483800415866']")
    WebElement summaryDataOffenderKnowOffenderFlag = null;
    private @FindBy(xpath = "//span[@data-test-id='201904161055010164243-Label']")
    WebElement summaryDataProvideMoreDetailsofOffenderLabel = null;
    private @FindBy(xpath = "//span[@data-test-id='201904161055010164243']")
    WebElement summaryDataOffenderDetailsOfOffender = null;
    private @FindBy(xpath = "//span[@data-test-id='2019041613010605623564-Label']")
    WebElement summaryDataOffenderRelationshipLabel = null;
    private @FindBy(xpath = "//span[@data-test-id='2019041613010605623564']")
    WebElement summaryDataOffenderRelationship = null;

    //Offender Description
    private @FindBy(xpath = "//span[@data-test-id='20190527150224046730366-Label']")
    WebElement summaryDataDescribeOffenderLabel = null;
    private @FindBy(xpath = "//span[@data-test-id='20190527150224046730366']")
    WebElement summaryDataOffenderDescribeFlag = null;
    private @FindBy(xpath = "//span[@data-test-id='20190527150617081032305-Label']")
    WebElement summaryDataOffenderDescriptionLabel = null;
    private @FindBy(xpath = "//span[@data-test-id='20190527150617081032305']")
    WebElement summaryDataOffenderDescription = null;


    //Offender Vehicle
    private @FindBy(xpath = "//div[@data-test-id='201906111838370460213']//span[@data-test-id='20190418114941075437388-Label']")
    WebElement summaryDataOffenderUsedAVehicleIndicatorLabel = null;
    private @FindBy(xpath = "//div[@data-test-id='201906111838370460213']//span[@data-test-id='20190418114941075437388']")
    WebElement summaryDataOffenderUsedAVehicleFlag = null;
    private @FindBy(xpath = "//div[@data-test-id='201906111838370460213']//span[@data-test-id='20190418120056069645281-Label']")
    WebElement summaryDataOffenderVehicleLicensePlateLabel = null;
    private @FindBy(xpath = "//div[@data-test-id='201906111838370460213']//span[@data-test-id='20190418120056069645281']")
    WebElement summaryDataOffenderVehicleLicensePlate = null;
    private @FindBy(xpath = "//div[@data-test-id='201906111838370460213']//span[@data-test-id='2019041812005606974628-Label']")
    WebElement summaryDataOffenderVehicleDescriptionLabel = null;
    private @FindBy(xpath = "//div[@data-test-id='201906111838370460213']//span[@data-test-id='2019041812005606974628']")
    WebElement summaryDataOffenderVehicleDescription = null;


    //Contact Witness
    private @FindBy(xpath = "//div[@data-test-id='201906111838370460213']//span[@data-test-id='20190417104848064415634-Label']")
    WebElement summaryDataWitnessIndicatorLabel = null;
    private @FindBy(xpath = "//div[@data-test-id='201906111838370460213']//span[@data-test-id='20190417104848064415634']")
    WebElement summaryDataWitnessFlag = null;
    private @FindBy(xpath = "//div[@data-test-id='201906111838370460213']//span[@data-test-id='20190416103351098619556-Label']")
    WebElement textBoxProvideWitnessDetailsLabel = null;
    private @FindBy(xpath = "//div[@data-test-id='201906111838370460213']//span[@data-test-id='20190416103351098619556']")
    WebElement summaryDataWitnessDetails = null;


    //Damaged

    private @FindBy(xpath = "//div[@data-test-id='201906071148590229985']")
    List<WebElement> sectionDamagedVehicles = null;
    private @FindBy(xpath = "//div[@data-test-id='201905221458400688672']")
    List<WebElement> sectionWhatWasDamaged = null;

    private @FindBy(xpath = "//span[@data-test-id='20190611143117012945883']")
    WebElement summaryDataVehicleDamagedIndicator = null;

    private @FindBy(xpath = "//span[@data-test-id='2019060710262406478129']")
    List<WebElement> summaryDataLicencePlateDetails = null;
    private @FindBy(xpath = "//span[@data-test-id='2019060711284408547626']")
    List<WebElement> summaryDataWhoOwnsVehicle = null;
    private @FindBy(xpath = "//span[@data-test-id='201906071026240649981']")
    List<WebElement> textHowWasVehicleDamaged = null;

    private @FindBy(xpath = "//span[@data-test-id='20190618112359011330469']")
    List<WebElement> summaryDataWasVehicleMovedIndicator = null;
    private @FindBy(xpath = "//span[@data-test-id='20190618113315048532498']")
    List<WebElement> summaryDataIgnitionTamperedIndicator = null;
    private @FindBy(xpath = "//span[@data-test-id='20190607114859023079571']")
    List<WebElement> summaryDataVehicleOwnerFirstName = null;
    private @FindBy(xpath = "//span[@data-test-id='20190607114859023180130']")
    List<WebElement> summaryDataVehicleOwnerMiddleName = null;
    private @FindBy(xpath = "//span[@data-test-id='20190607114859023181434']")
    List<WebElement> summaryDataVehicleOwnerLastName = null;
    private @FindBy(xpath = "//span[@data-test-id='20190607115104030755847']")
    List<WebElement> summaryDataVehicleOrganisationName = null;

    private @FindBy(xpath = "//div[@data-test-id='201904121025390954598']")
    List<WebElement> sectionDamagedItems = null;
    private @FindBy(xpath = "//span[@data-test-id='20190412103124008161486']")
    List<WebElement> summaryDataWhatwasDamaged = null;
    private @FindBy(xpath = "//span[@data-test-id='20190412103124008057146']")
    List<WebElement> summaryDataHowWasitDamaged = null;
    private @FindBy(xpath = "//span[@data-test-id='20190517154701027415986']")
    List<WebElement> summaryDataWhoOwnsIt = null;
    private @FindBy(xpath = "//span[@data-test-id='201905171613100818271397']")
    List<WebElement> summaryDataDamagedItemOwnerFirstName = null;
    private @FindBy(xpath = "//span[@data-test-id='201905171613100819272551']")
    List<WebElement> summaryDataDamagedItemOwnerMiddleName = null;
    private @FindBy(xpath = "//span[@data-test-id='201905171613100819273605']")
    List<WebElement> summaryDataDamagedItemOwnerLastName = null;
    private @FindBy(xpath = "//span[@data-test-id='201905171613100817267950']")
    List<WebElement> summaryDataDamagedItemOrganisationName = null;


    //Stolen
    private @FindBy(xpath = "//div[@data-test-id='201905291056310808355']")
    List<WebElement> sectionStolenVehicles = null;
    private @FindBy(xpath = "//div[@data-test-id='201905221626590301705']")
    List<WebElement> sectionWhatWasStolen = null;

    private @FindBy(xpath = "//span[@data-test-id='20190529125238064630968']")
    WebElement summaryDataVehicleStolenIndicator = null;
    private @FindBy(xpath = "//span[@data-test-id='2019052812011802836297']")
    List<WebElement> summaryDataLicensePlate = null;
    private @FindBy(xpath = "//span[@data-test-id='2019052812011802847278']")
    List<WebElement> summaryDataWherewasVehicleStolen = null;
    private @FindBy(xpath = "//span[@data-test-id='2019052815573606417934']")
    List<WebElement> summaryDataWhoOwnsStolenVehicle = null;

    private @FindBy(xpath = "//span[@data-test-id='20190528165035096140686']")
    List<WebElement> summaryDataStolenVehicleOwnerFirstName = null;
    private @FindBy(xpath = "//span[@data-test-id='20190528165035096241769']")
    List<WebElement> summaryDataStolenVehicleOwnerMiddleName = null;
    private @FindBy(xpath = "//input[@data-test-id='20190528165035096242736']")
    List<WebElement> summaryDataStolenVehicleOwnerLastName = null;
    private @FindBy(xpath = "//span[@data-test-id='20190528170032047648357']")
    List<WebElement> summaryDataStolenehicleOrganisationName = null;

    private @FindBy(xpath = "//div[contains(@data-test-id,'201905221637410260564-')]")
    List<WebElement> sectionStolenItem = null;
    private @FindBy(xpath = "//span[@data-test-id='2019050711100204154647']")
    List<WebElement> summaryDataWhatWasStolen = null;
    private @FindBy(xpath = "//span[@data-test-id='20190513125205099561874']")
    List<WebElement> summaryDataWhoOwnsStolenItem = null;
    private @FindBy(xpath = "//span[@data-test-id='2019041209454504561735']")
    List<WebElement> summaryDataSerialOrId = null;
    private @FindBy(xpath = "//span[@data-test-id='20190619153612088912683']")
    List<WebElement> summaryDataValueOfItem = null;
    private @FindBy(xpath = "//span[@data-test-id='20190619153620048213980']")
    List<WebElement> summaryDataPleaseDescribe = null;

    private @FindBy(xpath = "//span[@data-test-id='201905081628560147410699']")
    List<WebElement> summaryDataStolenItemOwnerFirstName = null;
    private @FindBy(xpath = "//span[@data-test-id='201905081628560148411401']")
    List<WebElement> summaryDataStolenItemOwnerMiddleName = null;
    private @FindBy(xpath = "//span[@data-test-id='201905081628560149412135']")
    List<WebElement> summaryDataStolenItemOwnerLastName = null;
    private @FindBy(xpath = "//span[@data-test-id='201905081713090843222728']")
    List<WebElement> summaryDataStolenItemOrganisationName = null;


    //Hurt
    private @FindBy(xpath = "//div[@data-test-id='201905231724330528583']")
    WebElement sectionHurtOrThreatened = null;
    private @FindBy(xpath = "//span[@data-test-id='20190412152847098116814-Label']")
    WebElement summaryDataWhowasThreatenedLabel = null;
    private @FindBy(xpath = "//span[@data-test-id='20190412152847098116814']")
    WebElement summaryDataWhowasThreatened = null;
    private @FindBy(xpath = "//span[@data-test-id='2019062010301008638475-Label']")
    WebElement summaryDataHowtheywereThreatenedOrHurtLabel = null;
    private @FindBy(xpath = "//span[@data-test-id='2019062010301008638475']")
    WebElement summaryDataHowtheywereThreatenedOrHurt = null;


    private @FindBy(xpath = "//button[@data-test-id='20161017110917023277518']")
    WebElement buttonSubmit = null;

    //what happened
    private @FindBy(xpath = "//div[@data-test-id='201905241028350100241']")
    WebElement sectionWhatHappenedDetails = null;
    private @FindBy(xpath = "//span[@data-test-id='2019042916543401455481-Label']")
    WebElement summaryDataDescriptionOfWhatHappenedLabel = null;
    private @FindBy(xpath = "//span[@data-test-id='2019042916543401455481']")
    WebElement summaryDataDescriptionOfWhatHappened = null;
    private @FindBy(xpath = "//span[@data-test-id='20190611154423034813476-Label']")
    WebElement summaryDataReasonWhyTheyDidThisLabel = null;
    private @FindBy(xpath = "//span[@data-test-id='20190611154423034813476']")
    WebElement summaryDataReasonWhyTheyDidThis = null;
    private @FindBy(xpath = "//button[@data-test-id='2014121601304102071215']")
    WebElement buttonAttachment = null;

    //Attachments
    private @FindBy(xpath = "//div[@data-test-id='201905240905040227530']")
    WebElement sectionAttachments = null;
    private @FindBy(xpath = "//input[@data-test-id='20170515091207074851281']")
    List<WebElement> attachmentDescription = null;
    private @FindBy(xpath = "//*[@data-test-id='20170515091207074852176']")
    List<WebElement> attachmentFileName = null;
    private @FindBy(xpath = "//span[@data-test-id='201905240911030172924']")
    WebElement summaryDataAttachmentDescription = null;


    //Contact Details Page

    private @FindBy(xpath = "//div[@data-test-id='201905241135120567201']")
    WebElement sectionProvideYourDetails = null;
    private @FindBy(xpath = "//div[@data-test-id='201905241135120567201']//span[@data-test-id='20190410181138020711901-Label']")
    WebElement summaryDataFirstNameLabel = null;
    private @FindBy(xpath = "//div[@data-test-id='201905241135120567201']//span[@data-test-id='20190410181138020711901']")
    WebElement summaryDataReporterFirstName = null;
    private @FindBy(xpath = "//div[@data-test-id='201905241135120567201']//span[@data-test-id='20190410181138020812743-Label']")
    WebElement summaryDataReporterMiddleNameLabel = null;
    private @FindBy(xpath = "//div[@data-test-id='201905241135120567201']//span[@data-test-id='20190410181138020812743']")
    WebElement summaryDataReporterMiddleName = null;
    private @FindBy(xpath = "//div[@data-test-id='201905241135120567201']//span[@data-test-id='20190410181138020813443-Label']")
    WebElement summaryDataLastNameLabel = null;
    private @FindBy(xpath = "//div[@data-test-id='201905241135120567201']//span[@data-test-id='20190410181138020813443']")
    WebElement summaryDataReporterLastName = null;
    private @FindBy(xpath = "//span[@data-test-id='2019041018133200689996-Label']")
    WebElement summaryDataDateOfBirthLabel = null;
    private @FindBy(xpath = "//span[@data-test-id='2019041018133200689996']")
    WebElement summaryDataReporterDateOfBirth = null;
    private @FindBy(xpath = "//div[@data-test-id='201905241135120567201']//span[@data-test-id='20190411110011006313687-Label']")
    WebElement summaryDataGenderLabel = null;
    private @FindBy(xpath = "//div[@data-test-id='201905241135120567201']//span[@data-test-id='20190411110011006313687']")
    WebElement summaryDataReporterGender = null;
    private @FindBy(xpath = "//div[@data-test-id='201905241135120567201']//span[@data-test-id='201905021537390692213367-Label']")
    WebElement summaryDataDriverLicenseNumberLabel = null;
    private @FindBy(xpath = "//div[@data-test-id='201905241135120567201']//span[@data-test-id='201905021537390692213367']")
    WebElement summaryDataReporterDriverLicenseNumber = null;

    private @FindBy(xpath = "//span[@data-test-id='201905151317120458182775-Label']")
    WebElement summaryDataAlternateFirstNameLabel = null;
    private @FindBy(xpath = "//span[@data-test-id='201905151317120458182775']")
    WebElement summaryDataReporterAlternateFirstName = null;
    private @FindBy(xpath = "//span[@data-test-id='201905151317120459183533-Label']")
    WebElement summaryDataAlternateMiddleNameLabel = null;
    private @FindBy(xpath = "//span[@data-test-id='201905151317120459183533']")
    WebElement summaryDataReporterAlternateMiddleName = null;
    private @FindBy(xpath = "//span[@data-test-id='201905151317120459184761-Label']")
    WebElement summaryDataAlternateLastNameLabel = null;
    private @FindBy(xpath = "//span[@data-test-id='201905151317120459184761']")
    WebElement summaryDataAlternateLastName = null;

    private @FindBy(xpath = "//div[@data-test-id='201904241255380732246']//label")
    WebElement summaryDataHomeAddressLabel = null;
    private @FindBy(xpath = "//div[@data-test-id='201905241135120567201']//span[@data-test-id='2019031416193707997247']")
    WebElement summaryDataReporterHomeAddress = null;
    private @FindBy(xpath = "//div[@data-test-id='201905140840180682537']//span[@data-test-id='2019050216083907625630-Label']")
    List<WebElement> summaryDataEmailAddressLabel = null;
    private @FindBy(xpath = "//div[@data-test-id='201905140840180682537']//span[@data-test-id='2019050216083907625630']")
    List<WebElement> summaryDataReporterEmailAddress = null;
    private @FindBy(xpath = "//div[@data-test-id='201905140840180682537']//span[@data-test-id='20190411125517041712957-Label']")
    List<WebElement> summaryDataPhoneTypeLabel = null;
    private @FindBy(xpath = "//div[@data-test-id='201905140840180682537']//span[@data-test-id='20190411125517041712957']")
    List<WebElement> summaryDataReporterPhoneType = null;
    private @FindBy(xpath = "//div[@data-test-id='201905140840180682537']//span[@data-test-id='20190411125517041713446-Label']")
    List<WebElement> summaryDataPhoneNumberLabel = null;
    private @FindBy(xpath = "//div[@data-test-id='201905140840180682537']//span[@data-test-id='20190411125517041713446']")
    List<WebElement> summaryDataReporterPhoneNumber = null;
    private @FindBy(xpath = "//div[@data-test-id='201905140840180682537']//span[@data-test-id='201905021504530372228423-Label']")
    WebElement summaryDataPreferredContactMethodLabel = null;
    private @FindBy(xpath = "//div[@data-test-id='201905021504530372827']//span[@data-test-id='201905021504530372228423']")
    WebElement summaryDataReporterPreferredContactMethod = null;
    private @FindBy(xpath = "//div[@data-test-id='201905271519550811197']//span[@data-test-id='20190418114941075437388-Label']")
    WebElement summaryDataVictimSupportIndicatorLabel = null;
    private @FindBy(xpath = "//div[@data-test-id='201905271519550811197']//span[@data-test-id='20190418114941075437388']")
    WebElement summaryDataVictimSupportIndicator = null;

    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']")
    List<WebElement> someoneElseDoesSection = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//input[contains(@name, 'FirstName')]")
    List<WebElement> someOneElseDoesTextBoxFirstName = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//input[contains(@name, 'MiddleName')]")
    List<WebElement> someOneElseDoesTextBoxMiddleName = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//input[contains(@name, 'SurName')]")
    List<WebElement> someOneElseDoesTextBoxLastName = null;
    private String xpathSomeOneElseDoesTextBoxAgeOrDOB = "(//div[@data-test-id='201904111102500743434'])[1]//input[contains(@name, 'InputBox')]";
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//input[contains(@name, 'InputBox')]")
    List<WebElement> someOneElseDoesTextBoxAgeOrDOB = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//input[contains(@name, 'Gender')]")
    List<WebElement> someOneElseDoesDropDownGender = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//input[contains(@name, 'EmailAddress')]")
    List<WebElement> someOneElseDoesTextBoxEmailAddress = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//input[contains(@name, 'PhoneType')]")
    List<WebElement> someOneElseDoesDropDownPhoneType = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//input[contains(@name, 'PhoneNUmber')]")
    List<WebElement> someOneElseDoesTextBoxPhoneNumber = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//input[contains(@name, 'TempText')]")
    List<WebElement> someOneElseDoesTextBoxAddress = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//div[contains(text(), 'Please provide')]")
    List<WebElement> labelOwnerDetailsSection = null;
    private @FindBy(xpath = "//div[@data-test-id='201905091206250186440']")
    List<WebElement> organisationDoesSection = null;
    private @FindBy(xpath = "//div[@data-test-id='201905091206250186440']//div[contains(text(),'Please provide')]")
    List<WebElement> labelOrganisationOwnerDetailsSection = null;
    private @FindBy(xpath = "//div[@data-test-id='201905091206250186440']//input[contains(@name, 'OrganisationName')]")
    List<WebElement> textBoxOrganisationName = null;
    private @FindBy(xpath = "//div[@data-test-id='201905091206250186440']//input[contains(@name, 'TempText')]")
    List<WebElement> textBoxOrganisationAddress = null;
    private @FindBy(xpath = "//img[@data-test-id='2019041018133200689996-DatePicker']")
    WebElement datePicker = null;
    private @FindBy(xpath = "//a[@class='today-link']")
    WebElement dateToday = null;




    private @FindBy(xpath = "//button[@data-test-id='20161017110917023277518']")
    WebElement buttonContinue = null;

    public void clickOnContinueButtonFromSummaryPage(){
        waitAndclickElementUsingJS(buttonContinue);
    }


    public boolean getWhenDidItHappenSectionDisplayed() {
        return isElementDisplayed(sectionWhenDidItHappen);
    }

    public String getStartDateLabel() {
        return waitandGetText(summaryDataStartDateLabel);
    }

    public String getStartDate() {
        return waitandGetText(summaryDatadatePickerStartDate);
    }

    public String getStartTimeLabel() {
        return waitandGetText(summaryDatadatePickerStartTimeLabel);
    }

    public String getStartTime() {
        return waitandGetText(summaryDatadatePickerStartTime);
    }

    public String getEndDateLabel() {
        return waitandGetText(summaryDatadatePickerEndDateLabel);
    }

    public String getEndDate() {
        return waitandGetText(summaryDatadatePickerEndDate);
    }

    public String getEndTimeLabel() {
        return waitandGetText(summaryDatadatePickerEndTimeLabel);
    }

    public String getEndTime() {
        return waitandGetText(summaryDatadatePickerEndTime);
    }

    public boolean getLocationSectionDisplayed() {
        return isElementDisplayed(sectionWhereDidItHappen);
    }

    public String getLocationShopBusinessTypeLabel() {
        return waitandGetText(summaryDataLabelLocationTypeLabel);
    }

    public String getLocationShopBusinessType() {
        return waitandGetText(summaryDatadropDownLocationType);
    }

    public String getLocationShopBusinessNameLabel() {
        return waitandGetText(summaryDataLocationShopBusinessSectionLabel);
    }

    public String getLocationShopBusinessName() {
        return waitandGetText(summaryDataLocationNameShopBusinessName);
    }

    public String getLocationShopBusinessAddressLabel() {
        return waitandGetText(summaryDataAddressShopBusinessSectionLabel);
    }

    public String getLocationShopBusinessAddress() {
        return waitandGetText(summaryDataLocationShopBusinessAddress);
    }

    public String getLocationShopBusinessAdditionalInformationLabel() {
        return waitandGetText(summaryDataAdditionalInformationShopBusinessSectionLabel);
    }

    public String getLocationShopBusinessAdditionalInformation() {
        return waitandGetText(summaryDataLocationShopBusinessAdditionalInformation);
    }

    public String getLocationOrganisationName() {
        return waitandGetText(summaryDataLocationNameOrganisationName);
    }

    public String getLocationOrganisationAddress() {
        return waitandGetText(summaryDataLocationOrganisationAddress);
    }

    public String getLocationOrganisationAdditionalInformation() {
        return waitandGetText(summaryDataLocationOrganisationAdditionalInformation);
    }

    public String getLocationHomeAddress() {
        return waitandGetText(summaryDataLocationHomeAddress);
    }

    public String getLocationHomeAdditionalInformation() {
        return waitandGetText(summaryDataLocationHomeAdditionalInformation);
    }

    public String getLocationPublicPlaceAddress() {
        return waitandGetText(summaryDataLocationPublicPlaceAddress);
    }

    public String getLocationPublicPlaceAdditionalInformation() {
        return waitandGetText(summaryDataLocationPublicPlaceAdditionalInformation);
    }


    public String getLocationBeginJourneyAddress() {
        return waitandGetText(summaryDataLocationBeginJourneyAddress);
    }

    public String getLocationEndJourneyAddress() {
        return waitandGetText(summaryDataLocationEndJourneyAddress);
    }

    public String getLocationJourneyAdditionalInformation() {
        return waitandGetText(summaryDataLocationJourneyAdditionalInformation);
    }

    public String getLocationPlaceOfWorshipName() {
        return waitandGetText(summaryDataLocationPlaceOfWorshipName);
    }

    public String getLocationPlaceOfWorshipAddress() {
        return waitandGetText(summaryDataLocationPlaceOfWorshipAddress);
    }

    public String getLocationPlaceOfWorshipAdditionalInformation() {
        return waitandGetText(summaryDataLocationPlaceOfWorshipAdditionalInformation);
    }


    public String getLocationPlaceOfEducationalFacilityName() {
        return waitandGetText(summaryDataLocationPlaceOfEducationalFacilityName);
    }

    public String getLocationPlaceOfEducationalFacilityAddress() {
        return waitandGetText(summaryDataLocationPlaceOfEducationalFacilityAddress);
    }

    public String getLocationPlaceOfEducationalFacilityAdditionalInformation() {
        return waitandGetText(summaryDataLocationPlaceOfEducationalFacilityAdditionalInformation);
    }

    public String getLocationOtherAdditionalInformation() {
        return waitandGetText(summaryDataLocationOtherAdditionalInformation);
    }

    public String getLocationStolenItemsInsideVehicle() {
        return waitandGetText(summaryDataLocationStolenItemsInsideVehicle);
    }

    public String getLocationStolenItemsInsideVehicleLicensePlace() {
        return waitandGetText(summaryDataLocationStolenItemsInsideVehicleLicensePlace);
    }

    public String getLocationStolenItemsInsideVehicleVehicleLocation() {
        return waitandGetText(summaryDataLocationStolenItemsInsideVehicleVehicleLocation);
    }

    public boolean getOffenderInformationSectionDisplayed() {
        return isElementDisplayed(summaryDataOffenderInformationSection);
    }

    public String getKnowTheOffenderFlagLabel() {
        return waitandGetText(summaryDataIknowWhoOffenderIsLabel);
    }

    public String getOffenderKnowOffenderFlag() {
        return waitandGetText(summaryDataOffenderKnowOffenderFlag);
    }

    public String getOffenderDetailsLabel() {
        return waitandGetText(summaryDataProvideMoreDetailsofOffenderLabel);
    }

    public String getOffenderDetails() {
        return waitandGetText(summaryDataOffenderDetailsOfOffender);
    }

    public String getRelationShipOfPersonLabel() {
        return waitandGetText(summaryDataOffenderRelationshipLabel);
    }

    public String getRelationShipOfPerson() {
        return waitandGetText(summaryDataOffenderRelationship);
    }

    public String getCanYouDescribePersonWhoDidThisLabel() {
        return waitandGetText(summaryDataDescribeOffenderLabel);
    }

    public String getOffenderDescribeFlag() {
        return waitandGetText(summaryDataOffenderDescribeFlag);
    }

    public String getIncludeAgeBuildClothingOfOffenderLabel() {
        return waitandGetText(summaryDataOffenderDescriptionLabel);
    }

    public String getOffenderDescription() {
        return waitandGetText(summaryDataOffenderDescription);
    }

    public String getIfPersonUsedAVehicleLabel() {
        return waitandGetText(summaryDataOffenderUsedAVehicleIndicatorLabel);
    }

    public String getOffenderUsedAVehicleFlag() {
        return waitandGetText(summaryDataOffenderUsedAVehicleFlag);
    }

    public String getOffenderLicencePlateLabel() {
        return waitandGetText(summaryDataOffenderVehicleLicensePlateLabel);
    }

    public String getOffenderVehicleLicensePlate() {
        return waitandGetText(summaryDataOffenderVehicleLicensePlate);
    }

    public String getOffenderVehicleLookLikeLabel() {
        return waitandGetText(summaryDataOffenderVehicleDescriptionLabel);
    }

    public String getOffenderVehicleDescription() {
        return waitandGetText(summaryDataOffenderVehicleDescription);
    }

    public String getContactWhoSawIthappenLabel() {
        return waitandGetText(summaryDataWitnessIndicatorLabel);
    }

    public String getWitnessFlag() {
        return waitandGetText(summaryDataWitnessFlag);
    }

    public String getProvideNameandContactDetailsOfDetailsLabel() {
        return waitandGetText(textBoxProvideWitnessDetailsLabel);
    }

    public String getWitnessDetails() {
        return waitandGetText(summaryDataWitnessDetails);
    }

    public boolean getHurtSectionDisplayed() {
        return isElementDisplayed(sectionHurtOrThreatened);
    }

    public String getWhowasHurtOrThreatenedLabel() {
        return waitandGetText(summaryDataWhowasThreatenedLabel);
    }

    public String getWhowasHurtOrThreatened() {
        return waitandGetText(summaryDataWhowasThreatened);
    }

    public String getHowWereTheyHurtOrThreatenedLabel() {
        return waitandGetText(summaryDataHowtheywereThreatenedOrHurtLabel);
    }

    public String getHowWereTheyHurtOrThreatened() {
        return waitandGetText(summaryDataHowtheywereThreatenedOrHurt);
    }

    public boolean getWhatHappenedSectionDisplayed() {
        return isElementDisplayed(sectionWhatHappenedDetails);
    }

    public String getDescribeWhatHappenedLabel() {
        return waitandGetText(summaryDataDescriptionOfWhatHappenedLabel);
    }

    public String getDescribeWhatHappened() {
        return waitandGetText(summaryDataDescriptionOfWhatHappened);
    }

    public String getReasonOfWhyTheyDidThisLabel() {
        return waitandGetText(summaryDataReasonWhyTheyDidThisLabel);
    }

    public String getReasonOfWhyTheyDidThis() {
        return waitandGetText(summaryDataReasonWhyTheyDidThis);
    }

    public boolean getIsAttachmentSectionsDisplayed() {
        return isElementDisplayed(sectionAttachments);
    }

    public String getAttachmentName(int index) {
        return waitandGetText(attachmentDescription.get(index));
    }

    public String getAttachmentFileName(int index) {
        return waitandGetText(attachmentFileName.get(index));
    }

    public String getAttachmentDescription() {
        return waitandGetText(summaryDataAttachmentDescription);
    }

    public boolean getPersonalDetailsSectionDisplayed() {
        return isElementDisplayed(sectionProvideYourDetails);
    }

    public String getReporterFirstnameLabel() {
        return waitandGetText(summaryDataFirstNameLabel);
    }

    public String getReporterFirstname() {
        return waitandGetText(summaryDataReporterFirstName);
    }

    public String getReporterMiddlenameLabel() {
        return waitandGetText(summaryDataReporterMiddleNameLabel);
    }

    public String getReporterMiddlename() {
        return waitandGetText(summaryDataReporterMiddleName);
    }

    public String getReporterLastnameLabel() {
        return waitandGetText(summaryDataLastNameLabel);
    }

    public String getReporterLastname() {
        return waitandGetText(summaryDataReporterLastName);
    }

    public String getReporterDOBLabel() {
        return waitandGetText(summaryDataDateOfBirthLabel);
    }

    public String getReporterDOB() {
        return waitandGetText(summaryDataReporterDateOfBirth);
    }

    public String getReporterGenderLabel() {
        return waitandGetText(summaryDataGenderLabel);
    }

    public String getReporterGender() {
        return waitandGetText(summaryDataReporterGender);
    }

    public String getReporterDriverLicenceNumberLabel() {
        return waitandGetText(summaryDataDriverLicenseNumberLabel);
    }

    public String getReporterDriverLicenceNumber() {
        return waitandGetText(summaryDataReporterDriverLicenseNumber);
    }


    public String getReporterPreviouslyUsedFirstnameLabel() {
        return waitandGetText(summaryDataAlternateFirstNameLabel);
    }

    public String getReporterPreviouslyUsedFirstname() {
        return waitandGetText(summaryDataReporterAlternateFirstName);
    }

    public String getReporterPreviouslyUsedMiddlenameLabel() {
        return waitandGetText(summaryDataAlternateMiddleNameLabel);
    }

    public String getReporterPreviouslyUsedMiddlename() {
        return waitandGetText(summaryDataReporterAlternateMiddleName);
    }

    public String getReporterPreviouslyUsedLastnameLabel() {
        return waitandGetText(summaryDataAlternateLastNameLabel);
    }

    public String getReporterPreviouslyUsedLastname() {
        return waitandGetText(summaryDataAlternateLastName);
    }

    public String getReporterHomeAddressLabel() {
        return waitandGetText(summaryDataHomeAddressLabel);
    }

    public String getReporterHomeAddress() {
        return waitandGetText(summaryDataReporterHomeAddress);
    }

    public String getReporterEmailAddressLabel() {
        return waitandGetText(summaryDataEmailAddressLabel.get(0));
    }

    public String getReporterEmailAddress() {
        return waitandGetText(summaryDataReporterEmailAddress.get(0));
    }

    public String getReporterPhoneTypeLabel() {
        return waitandGetText(summaryDataPhoneTypeLabel.get(0));
    }

    public String getReporterPhoneType() {
        return waitandGetText(summaryDataReporterPhoneType.get(0));
    }

    public String getReporterPhoneNumberLabel() {
        return waitandGetText(summaryDataPhoneNumberLabel.get(0));
    }

    public String getReporterPhoneNumber() {
        return waitandGetText(summaryDataReporterPhoneNumber.get(0));
    }


    public String getPreferredContactMethodLabel() {
        return waitandGetText(summaryDataPreferredContactMethodLabel);
    }

    public String getPreferredContactMethod() {
        return waitandGetText(summaryDataReporterPreferredContactMethod);
    }

    public String getVictimSupportLabel() {
        return waitandGetText(summaryDataVictimSupportIndicatorLabel);
    }

    public String getVictimSupport() {
        return waitandGetText(summaryDataVictimSupportIndicator);
    }

    public void clickOnSubmit() {
        waitAndclickElementUsingJS(buttonSubmit);
    }

    public String summaryformatDate(String currentFormat, String expectedFormat, String data) {
        return formatDate(currentFormat, expectedFormat, data);
    }



}
