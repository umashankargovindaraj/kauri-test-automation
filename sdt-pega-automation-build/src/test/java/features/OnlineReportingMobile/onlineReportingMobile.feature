@ALL_MOBILE
Feature: Scenarios to be tested for reporting an incident

  Background: Load Online Reporting on mobile
    Given I’m on mobile view of Online Reporting

  @unit @iosDone
  Scenario: User selects emergency event
    When I indicate that the event is an emergency
    Then I won’t be able to proceed on the form and appropriate error message is displayed

  @unit @iosDone @TestAndroidSet
  Scenario: User does not indicate the event is an emergency or not
    When I don't indicate that the event is an emergency or not
    Then I won’t be able to proceed on the form and appropriate error message is displayed

  @unit @iosDone @TestAndroidSet
  Scenario: Check the logic to select checkboxes in What happened screen
    Given I indicate that the event is not an emergency
    Then I should be able to select Lost Property checkbox only when damaged, hurt, stolen or Something else checkbox is not selected
    And I should be able to select Something else checkbox only when damaged, hurt, stolen or Lost Property checkbox is not selected
    And I should be able to select damaged, hurt or stolen only when Lost property or Something else checkbox is not selected

  @unit @iosDone
  Scenario Outline: Provide location type
    Given I am on the Event Info Page after selecting the events "stolen" to report
    When I key in the details of Event time and continue to next page
    And I select the "<Location>" of the event
    Then I should see sections relevant to Location Type
    And I should be able to key in the required data on to the fields
    Examples:
      | Location             |
      | A shop/business      |
      | An organisation      |
      | A home               |
      | A public place       |
      | Place of worship     |
      | Educational Facility |
      | Other                |


  @e2e @iosDone @AndroidDone @e2eHurtMobile
  Scenario: Submit an online report when someone is hurt
    Given I am on the Event Info Page after selecting the events "hurt" to report
    When I key in the details of Event time and continue to next page
    And I select the location and key in the location details
    And I click on continue in the location page and navigate to the next page
    And I key in details of the offender
    And I click on continue in offender page to navigate to the next page
    And I key in the details of the person being hurt
    And I click on Continue to navigate to what happened page
    And I key in the details of what happened
    And I click on continue to navigate to attachment page
    And I attach any relevant attachment of the incident
    And I click on Continue to navigate to Reporter Page
    And I key in the details of the reporter
    And I indicate i need victim support
    And I click on continue in Reporter page to navigate to Summary Page
    Then I should be able to verify all the keyed in data in the summary screen
    And I should be able to navigate to the next page from summary
    And I select "no" in the section to choose that I want to do survey
    And I should be able to submit the application successfully
    And I should be able to see a summary email with correct data
    And I should receive an email from NZ Police with the summary of the report

  @e2e @iosDone @SamsungGalaxyTabS4_8.1_1.13.0
  Scenario: Submit an online report for a lost property that belongs to be reporter
    Given I am on the Event Info Page after selecting the events "lost" to report
    When I key in the details of Event time and continue to next page
    And I select the location and key in the location details
    And I click on continue in the location page and navigate to the next page
    And I have entered required details of lost item
    And I have indicated "I do" is the owner of lost item and keyed in owner's name
    And I click on continue in the lost item details page and navigate to the next page
    And I key in more information about the event i want to report
    And I click on continue to navigate to attachment page
    And I attach any relevant attachment of the incident
    And I click on Continue to navigate to Reporter Page
    And I key in the details of the reporter
    And I click on continue in Reporter page to navigate to Summary Page
    Then I should be able to verify all the keyed in data in the summary screen
    And I should be able to navigate to the next page from summary
    And I select "yes" in the section to choose that I want to do survey
    Then I should be able to view all survey questions and select opinion as appropriate
    And I should be able to submit the application successfully
    And I should be able to see a summary email with correct data
    And I should receive an email from NZ Police with the summary of the report

  @e2e @iosDone @AndroidDone @TestAndroidSet @e2eSomethingElseMobile @SamsungGalaxyS10_9.0_1.13.0
  Scenario: Submit an online report for an incident by selecting Something else
    Given I am on the Event Info Page after selecting the events "somethingElse" to report
    When I key in the details of Event time and continue to next page
    And I select the location and key in the location details
    And I click on continue in the location page and navigate to the next page
    And I key in more information about the event i want to report
    And I click on continue to navigate to attachment page
    And I attach any relevant attachment of the incident
    And I click on Continue to navigate to Reporter Page
    And I key in the details of the reporter
    And I indicate i need victim support
    And I click on continue in Reporter page to navigate to Summary Page
    Then I should be able to verify all the keyed in data in the summary screen
    And I should be able to navigate to the next page from summary
    And I select "yes" in the section to choose that I want to do survey
    Then I should be able to view all survey questions and select opinion as appropriate
    And I should be able to submit the application successfully
    And I should be able to see a summary email with correct data
    And I should receive an email from NZ Police with the summary of the report

  @e2e @iosDone @AndroidDone @TestAndroidSet @SamsungGalaxyS9Plus_9.0_1.13.0
  Scenario: Submit an online report when some item has been damaged that belongs to be reporter
    Given I am on the Event Info Page after selecting the events "damaged" to report
    When I key in the details of Event time and continue to next page
    And I select the location and key in the location details
    And I click on continue in the location page and navigate to the next page
    And I key in details of the offender
    And I click on continue in offender page to navigate to the next page
    And I select "No" for Damaged vehicles
    And I have entered required details of damaged item
    And I have indicated "I do" is the owner of damaged item and keyed in owner's name
    And I click on continue in the damaged details page and navigate to the next page
    And I key in more information about the event i want to report
    And I click on continue to navigate to attachment page
    And I attach any relevant attachment of the incident
    And I click on Continue to navigate to Reporter Page
    And I key in the details of the reporter
    And I indicate i need victim support
    And I click on continue in Reporter page to navigate to Summary Page
    Then I should be able to verify all the keyed in data in the summary screen
    And I should be able to navigate to the next page from summary
    And I select "yes" in the section to choose that I want to do survey
    Then I should be able to view all survey questions and select opinion as appropriate
    And I should be able to submit the application successfully
    And I should be able to see a summary email with correct data
    And I should receive an email from NZ Police with the summary of the report


  @e2e @done @damagedVehicleAndroid @AndroidDone @SamsungGalaxyS9_8.0_1.13.0
  Scenario: Submit an online report when some vehicle has been damaged that belongs to be reporter
    Given I am on the Event Info Page after selecting the events "damaged" to report
    When I key in the details of Event time and continue to next page
    And I select the location and key in the location details
    And I click on continue in the location page and navigate to the next page
    And I key in details of the offender
    And I click on continue in offender page to navigate to the next page
    And I select "yes" for Damaged vehicles
    And I have entered required details of damaged vehicle
    And I have indicated "I do" is the owner of damaged vehicle and keyed in owner's name
    And I click on continue in the damaged details page and navigate to the next page
    And I key in more information about the event i want to report
    And I click on continue to navigate to attachment page
    And I attach any relevant attachment of the incident
    And I click on Continue to navigate to Reporter Page
    And I key in the details of the reporter
    And I indicate i need victim support
    And I click on continue in Reporter page to navigate to Summary Page
    Then I should be able to verify all the keyed in data in the summary screen
    And I should be able to navigate to the next page from summary
    And I select "yes" in the section to choose that I want to do survey
    Then I should be able to view all survey questions and select opinion as appropriate
    And I should be able to submit the application successfully
    And I should be able to see a summary email with correct data
    And I should receive an email from NZ Police with the summary of the report


  @e2e @done @TestAndroidSet @SamsungGalaxyS9Plus_9.0_1.13.0
  Scenario: Submit an online report when some vehicles and items has been stolen that belongs to be reporter
    Given I am on the Event Info Page after selecting the events "stolen" to report
    When I key in the details of Event time and continue to next page
    And I select the location and key in the location details
    And I click on continue in the location page and navigate to the next page
    And I key in details of the offender
    And I click on continue in offender page to navigate to the next page
    And I indicate that a vehicle has been stolen
    And I key in the details of first stolen vehicle
    And I select the owner of first stolen as I do
    And I key in what was the first stolen item
    And I select the owner of first stolen item as I do
    And I click on continue in the stolen details page and navigate to the next page
    And I key in more information about the event i want to report
    And I click on continue to navigate to attachment page
    And I attach any relevant attachment of the incident
    And I click on Continue to navigate to Reporter Page
    And I key in the details of the reporter
    And I indicate i need victim support
    And I click on continue in Reporter page to navigate to Summary Page
    Then I should be able to verify all the keyed in data in the summary screen
    And I should be able to navigate to the next page from summary
    And I select "yes" in the section to choose that I want to do survey
    Then I should be able to view all survey questions and select opinion as appropriate
    And I should be able to submit the application successfully
    And I should be able to see a summary email with correct data
    And I should receive an email from NZ Police with the summary of the report


  @e2e @done @AndroidDone @TestAndroidSet @e2eHurtMobile
  Scenario: Submit an online report when someone is hurt with manual entry in all address fields
    Given I am on the Event Info Page after selecting the events "hurt" to report
    When I key in the details of Event time and continue to next page
    And I key in the details of event location with manually keyed in address
    And I click on continue in the location page and navigate to the next page
    And I key in details of the offender
    And I click on continue in offender page to navigate to the next page
    And I key in the details of the person being hurt
    And I click on Continue to navigate to what happened page
    And I key in the details of what happened
    And I click on continue to navigate to attachment page
    And I attach any relevant attachment of the incident
    And I click on Continue to navigate to Reporter Page
    And I key in my personal information with manually keyed in address
    And I indicate i need victim support
    And I click on continue in Reporter page to navigate to Summary Page
    Then I should be able to verify all the keyed in data in the summary screen
    And I should be able to navigate to the next page from summary
    And I select "yes" in the section to choose that I want to do survey
    Then I should be able to view all survey questions and select opinion as appropriate
    And I should be able to submit the application successfully
    And I should be able to see a summary email with correct data
    And I should receive an email from NZ Police with the summary of the report

  @e2e @done @TestAndroidSet @e2eLostMobile
  Scenario: Submit an online report for a lost property that belong to someone else and organisation owner
    Given I am on the Event Info Page after selecting the events "lost" to report
    When I key in the details of Event time and continue to next page
    And I select the location and key in the location details
    And I click on continue in the location page and navigate to the next page
    And I have entered required details of lost item
    And I have indicated "I do" is the owner of lost item and keyed in owner's name
    And I add another lost item
    And I have entered required details of lost item
    And I have indicated "Somebody else does" is the owner of lost item and keyed in owner's name
    And I add another lost item
    And I have entered required details of lost item
    And I have indicated "An organisation does" is the owner of lost item and keyed in owner's name
    And I click on continue in the lost item details page and navigate to the next page
    And I key in more information about the event i want to report
    And I click on continue to navigate to attachment page
    And I attach any relevant attachment of the incident
    And I click on Continue to navigate to Reporter Page
    And I key in the details of the reporter
    And I click on continue in Reporter page to navigate to Owner details page
    Then I should be able to see details of the owner of second lost item prepopulated
    And I should be able to add details of the owner of second lost item
    And I click on continue in Owner details page to navigate to next owner details
    And I should be able to see details of the owner of third lost item prepopulated and key in address of Organisation
    And I click on continue in Reporter page to navigate to Summary Page
    Then I should be able to verify all the keyed in data in the summary screen
    And I should be able to navigate to the next page from summary
    And I select "yes" in the section to choose that I want to do survey
    Then I should be able to view all survey questions and select opinion as appropriate
    And I should be able to submit the application successfully
    And I should be able to see a summary email with correct data
    And I should receive an email from NZ Police with the summary of the report

  @e2e @done @TusharMobileTest @TestAndroidSet @e2eDamagedMobile
  Scenario: Submit an online report when some item has been damaged that belong to someone else and organisation owner
    Given I am on the Event Info Page after selecting the events "damaged" to report
    When I key in the details of Event time and continue to next page
    And I select the location and key in the location details
    And I click on continue in the location page and navigate to the next page
    And I key in details of the offender
    And I click on continue in offender page to navigate to the next page
    And I select "No" for Damaged vehicles
    And I have entered required details of damaged item
    And I have indicated "I do" is the owner of damaged item and keyed in owner's name
    And I add another damaged Item
    And I have entered required details of damaged item
    And I have indicated "Somebody else does" is the owner of damaged item and keyed in owner's name
    And I add another damaged Item
    And I have indicated "An organisation does" is the owner of damaged item and keyed in owner's name
    And I have entered required details of damaged item
    And I click on continue in the damaged details page and navigate to the next page
    And I key in more information about the event i want to report
    And I click on continue to navigate to attachment page
    And I attach any relevant attachment of the incident
    And I click on Continue to navigate to Reporter Page
    And I key in the details of the reporter
    And I indicate i need victim support
    And I click on continue in Reporter page to navigate to Owner details page
    Then I should be able to see details of the owner of second damaged Item prepopulated
    And I should be able to add details of the owner of second damaged Item
    And I click on continue in Owner details page to navigate to next owner details
    And I should be able to see details of the owner of third damaged Item prepopulated
    And I should be able to add address of the organisation of damaged Item Owner
    And I click on continue in Reporter page to navigate to Summary Page
    Then I should be able to verify all the keyed in data in the summary screen
    And I should be able to navigate to the next page from summary
    And I select "yes" in the section to choose that I want to do survey
    Then I should be able to view all survey questions and select opinion as appropriate
    And I should be able to submit the application successfully
    And I should be able to see a summary email with correct data
    And I should receive an email from NZ Police with the summary of the report

  @e2e @iosDone @TestAndroidSet @e2eDamagedMobile @SamsungGalaxyS8_7.0_1.13.0
  Scenario: Submit an online report when some vehicle has been damaged that belong to someone else and organisation owner
    Given I am on the Event Info Page after selecting the events "damaged" to report
    When I key in the details of Event time and continue to next page
    And I select the location and key in the location details
    And I click on continue in the location page and navigate to the next page
    And I key in details of the offender
    And I click on continue in offender page to navigate to the next page
    And I select "yes" for Damaged vehicles
    And I have entered required details of damaged vehicle
    And I have indicated "I do" is the owner of damaged vehicle and keyed in owner's name
    And I add another damaged vehicle
    And I have entered required details of damaged vehicle
    And I have indicated "Somebody else does" is the owner of damaged vehicle and keyed in owner's name
    And I add another damaged vehicle
    And I have entered required details of damaged vehicle
    And I have indicated "An organisation does" is the owner of damaged vehicle and keyed in owner's name
    And I click on continue in the damaged details page and navigate to the next page
    And I key in more information about the event i want to report
    And I click on continue to navigate to attachment page
    And I attach any relevant attachment of the incident
    And I click on Continue to navigate to Reporter Page
    And I key in the details of the reporter
    And I indicate i need victim support
    And I click on continue in Reporter page to navigate to Owner details page
    Then I should be able to see details of the owner of second damaged vehicle prepopulated
    And I should be able to add details of the owner of second damaged vehicle
    And I click on continue in Owner details page to navigate to next owner details
    And I should be able to see details of the owner of third damaged vehicle prepopulated and key in address of Organisation
    And I click on continue in Reporter page to navigate to Summary Page
    Then I should be able to verify all the keyed in data in the summary screen
    And I should be able to navigate to the next page from summary
    And I select "yes" in the section to choose that I want to do survey
    Then I should be able to view all survey questions and select opinion as appropriate
    And I should be able to submit the application successfully
    And I should be able to see a summary email with correct data
    And I should receive an email from NZ Police with the summary of the report

  @e2e @iosDone @TestAndroidSet @e2eStolenMobile @GooglePixel2_9.0_1.13.0
  Scenario: Submit an online report when some vehicles has been stolen that belong to someone else and organisation owner
    Given I am on the Event Info Page after selecting the events "stolen" to report
    When I key in the details of Event time and continue to next page
    And I select the location and key in the location details
    And I click on continue in the location page and navigate to the next page
    And I key in details of the offender
    And I click on continue in offender page to navigate to the next page
    And I indicate that a vehicle has been stolen
    And I key in the details of first stolen vehicle
    And I select the owner of first stolen as I do
    And I add another stolen vehicle
    And I key in the details of second stolen vehicle
    And I select the owner of the second stolen vehicle as Somebody else does
    And I key in the owner details of the second stolen vehicle
    And I add another stolen vehicle
    And I key in the details of third stolen vehicle
    And I select the owner of the third stolen vehicle as An Organisation does
    And I key in the owner details of the third stolen vehicle
    And I click on continue in the stolen details page and navigate to the next page
    And I key in more information about the event i want to report
    And I click on continue to navigate to attachment page
    And I attach any relevant attachment of the incident
    And I click on Continue to navigate to Reporter Page
    And I key in the details of the reporter
    And I indicate i need victim support
    And I click on continue in Reporter page to navigate to Owner details page
    And I should be able to see details of the owner of second stolen vehicle prepopulated
    And I should be able to add details of the owner of second stolen vehicle
    And I click on continue in Owner details page to navigate to next owner details
    And I should be able to see details of the owner of third stolen vehicle prepopulated
    And I should be able to add address of the organisation of stolen Vehicle Owner
    And I click on continue in Reporter page to navigate to Summary Page
    Then I should be able to verify all the keyed in data in the summary screen
    And I should be able to navigate to the next page from summary
    And I select "yes" in the section to choose that I want to do survey
    Then I should be able to view all survey questions and select opinion as appropriate
    And I should be able to submit the application successfully
    And I should be able to see a summary email with correct data
    And I should receive an email from NZ Police with the summary of the report


  @e2e @iosDone @TestAndroidSet @e2eStolenMobile @SamsungGalaxyNote9_8.1_1.13.0
  Scenario: Submit an online report when some items has been stolen that belong to someone else and organisation owner
    Given I am on the Event Info Page after selecting the events "stolen" to report
    When I key in the details of Event time and continue to next page
    And I select the location and key in the location details
    And I click on continue in the location page and navigate to the next page
    And I key in details of the offender
    And I click on continue in offender page to navigate to the next page
    And I indicate that a vehicle has not been stolen
    And I key in what was the first stolen item
    And I select the owner of first stolen item as I do
    And I add another stolen Item
    And I key in what was the second stolen item
    And I select the owner of the second stolen item as Somebody else does
    And I key in the owner details of the second stolen item
    And I add another stolen Item
    And I key in what was the third stolen item
    And I select the owner of the third stolen item as An Organisation does
    And I key in the owner details of the third stolen item
    And I click on continue in the stolen details page and navigate to the next page
    And I key in more information about the event i want to report
    And I click on continue to navigate to attachment page
    And I attach any relevant attachment of the incident
    And I click on Continue to navigate to Reporter Page
    And I key in the details of the reporter
    And I indicate i need victim support
    And I click on continue in Reporter page to navigate to Owner details page
    Then I should be able to see details of the owner of second stolen Item prepopulated
    And I should be able to add details of the owner of second stolen Item
    And I click on continue in Owner details page to navigate to next owner details
    And I should be able to see details of the owner of third stolen Item prepopulated
    And I should be able to add address of the organisation of stolen Item Owner
    And I click on continue in Reporter page to navigate to Summary Page
    Then I should be able to verify all the keyed in data in the summary screen
    And I should be able to navigate to the next page from summary
    And I select "yes" in the section to choose that I want to do survey
    Then I should be able to view all survey questions and select opinion as appropriate
    And I should be able to submit the application successfully
    And I should be able to see a summary email with correct data
    And I should receive an email from NZ Police with the summary of the report

  @unit @AdndroidDone
  Scenario: Landing page text verification
    When i am on getting started page
    Then i should be able to verify getting started information

  @unit @AndroidDone @multiDeviceRun @TestAndroidSet
  Scenario: New mandatory field “Where was vehicle when…” fo damaged vehicle
    Given I am on the Event Info Page after selecting the events "damaged" to report
    When I key in the details of Event time and continue to next page
    And I select the location and key in the location details
    And I click on continue in the location page and navigate to the next page
    And I key in details of the offender
    And I click on continue in offender page to navigate to the next page
    And I select "Yes" for Damaged vehicles
    And I have indicated "I do" is the owner of damaged vehicle and keyed in owner's name
    Then i can validate the options available for Where was vehicle when field in damaged vehicle
    When I have entered required details of damaged vehicle without where was vehicle when field
    Then I can validate the placeholder text and label for how and where vehicle damaged text field
    And I click on continue to find an error popup that tells about validation errors
    Then i can verify that mandatory error message is displayed for Where was vehicle when field

  @unit @AndroidDone @multiDeviceRun @TestAndroidSet
  Scenario: New mandatory field “where was the vehicle stolen from” fo stolen vehicle
    Given I am on the Event Info Page after selecting the events "stolen" to report
    When I key in the details of Event time and continue to next page
    And I select the location and key in the location details
    And I click on continue in the location page and navigate to the next page
    And I key in details of the offender
    And I click on continue in offender page to navigate to the next page
    And I indicate that a vehicle has been stolen
    And I key in the details of first stolen vehicle without data for where was the vehicle stolen from
    Then i can validate the options available for Where was vehicle when field in damaged vehicle
    And I select the owner of first stolen as I do
    And I click on continue to find an error popup that tells about validation errors
    Then i can verify that mandatory error message is displayed for where was the vehicle stolen from
    When i key in details for Where was vehicle when field in damaged vehicle
    And I click on continue in the damaged details page and navigate to the next page
    And I key in more information about the event i want to report
    And I click on continue to navigate to attachment page
    And I attach any relevant attachment of the incident
    And I click on Continue to navigate to Reporter Page
    Then I can validate the previous name prompt

  @unit @AndroidDone @multiDeviceRun1 @TestAndroidSet
  Scenario: Address type,phone type and phone number field level validations for reporter owner and organistaion
    Given I am on the Event Info Page after selecting the events "damaged" to report
    When I key in the details of Event time and continue to next page
    And I select the location and key in the location details
    And I click on continue in the location page and navigate to the next page
    And I key in details of the offender
    And I click on continue in offender page to navigate to the next page
    And I select "No" for Damaged vehicles
    And I have entered required details of damaged item
    And I have indicated "I do" is the owner of damaged item and keyed in owner's name
    And I add another damaged Item
    And I have entered required details of damaged item
    And I have indicated "Somebody else does" is the owner of damaged item and keyed in owner's name
    And I add another damaged Item
    And I have entered required details of damaged item
    And I have indicated "An organisation does" is the owner of damaged item and keyed in owner's name
    And I click on continue in the damaged details page and navigate to the next page
    And I key in more information about the event i want to report
    And I click on continue to navigate to attachment page
    And I attach any relevant attachment of the incident
    And I click on Continue to navigate to Reporter Page
    When I key in details of reporter without phone type and phone number
    And I indicate i need victim support
    And I click on continue to find an error popup that tells about validation errors
    Then I can validate that phone number is a mandatory field
    And i should be able to validate the options for address type and phone type fields
    When i key in phone number
    And I click on continue in Reporter page to navigate to Owner details page
    And I should be able to add details of the owner of second damaged Item without phone number
    And I click on continue to find an error popup that tells about validation errors
    Then I can validate that phone number is a mandatory field for someone else owner
    And i should be able to validate the options for address type and phone type fields for owner
    When i key in phone number for Owner
    And I click on continue in Owner details page to navigate to next owner details
    And I should be able to add address of the organisation of damaged Item Owner without phone number
    And I click on continue to find an error popup that tells about validation errors
    Then I can validate that phone number is a mandatory field
    And i should be able to validate the options for phone type fields for organisation

  @unit @multiDeviceRun @TestAndroidSet
  Scenario: Other location type for event location, town field is mandatory and additional information field is optional
    Given I am on the Event Info Page after selecting the events "hurt" to report
    When I key in the details of Event time and continue to next page
    And select other location type for event location and i select to key in address manually
    Then address fields should be displayed
    When i key in how close to this address
    And I click on continue to find an error popup that tells about validation errors
    Then error message should be displayed for mandatory town and suburb field
    When i key in town and suburb
    And I click on continue in the location page and navigate to the next page
    And I key in details of the offender

  @unit @AndroidDone @TestAndroidSet
  Scenario: Home address option and date of birth(reporter and owner) validation for lost property
    Given I am on the Event Info Page after selecting the events "lost" to report
    When I key in the details of Event time and continue to next page
    And I select the location as "A home" and key in the location details
    And I click on continue in the location page and navigate to the next page
    And I have entered required details of lost item
    And I have indicated "Somebody else does" is the owner of lost item and keyed in owner's name
    And I click on continue in the lost item details page and navigate to the next page
    And I key in more information about the event i want to report
    And I click on continue to navigate to attachment page
    And I attach any relevant attachment of the incident
    And I click on Continue to navigate to Reporter Page
    Then I cannot select reporter dob as future or current date
    And I can select use the address I entered earlier and validate details
    And I key in the details of the reporter without address
    And I click on continue in Reporter page to navigate to Owner details page
    Then I should be able to see details of the owner of second lost item prepopulated
    And I should not see option to select for earlier address
    And I should be able to add details of the owner of second lost item
    And I should not be able to continue without owners age or dob
    And I should not be able to enter owner dob as future or current date


  @e2e @iosDone @TestAndroidSet
  Scenario: Verify questions in survey
    Given I am on the Event Info Page after selecting the events "hurt" to report
    When I key in the details of Event time and continue to next page
    And I key in the details of event location with manually keyed in address
    And I click on continue in the location page and navigate to the next page
    And I key in details of the offender
    And I click on continue in offender page to navigate to the next page
    And I key in the details of the person being hurt
    And I click on Continue to navigate to what happened page
    And I key in the details of what happened
    And I click on continue to navigate to attachment page
    And I attach any relevant attachment of the incident
    And I click on Continue to navigate to Reporter Page
    And I key in the details of the reporter
    And I indicate i need victim support
    And I click on continue in Reporter page to navigate to Summary Page
    And I should be able to submit the application successfully
    And I select "yes" in the section to choose that I want to do survey
    Then I should be able to view all survey questions and select opinion as appropriate


  @unit @mobileWIP @iosCurrentTest @TestAndroidSet
  Scenario: mandatory field “What did the vehicle look like” and back key funtion
    Given I am on the Event Info Page after selecting the events "stolen" to report
    When I key in the details of Event time and continue to next page
    And I select the location and key in the location details
    And I click on continue in the location page and navigate to the next page
    And I key in details of the offender details without vehicle description
    And I click on continue to find an error popup that tells about validation errors
    Then error message should be displayed for mandatory vehicle description
    When I key in offender vehicle description
    And I click on continue in offender page to navigate to the next page
    And I indicate that a vehicle has not been stolen
    And I key in what was the first stolen item
    And I select the owner of first stolen item as I do
    And I click on continue in the stolen details page and navigate to the next page
    And I key in more information about the event i want to report
    And I click on continue to navigate to attachment page
    And I attach any relevant attachment of the incident
    And I click on Continue to navigate to Reporter Page
    And I key in the details of the reporter
    And I indicate i need victim support
    And I should be able to navigate back to online reporting page

  @post-go-live-1
  #SDTDT-1448
  Scenario: Protection Order breached
    Given a Protection Order has been breached
    When I attempt to report this via an Online Form
    Then I  can see from the “Let’s get started” page, that I should call 111 instead.

