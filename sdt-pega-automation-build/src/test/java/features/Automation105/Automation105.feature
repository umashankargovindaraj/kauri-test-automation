@all
Feature: Test scenarios related to 105 Automation with Onduty integration

  Background: Navigate to form
    Given I’m on the Online form

  @Scenario_1
  Scenario: Scenario 1: Report with 16000+ character Narrative, plus 3 attachments, 5MB each
    Given I am on the Event Info Page after selecting the events "lost" to report
    When I enter the date and time of the event
    And I key in the details of event location
    And I have indicated that the owner of lost item is "I do"
    And I key in the details of lost items
    When I add multiple lost items into the reports
      | lostItemCount | eventType |
      | 1            | lost      |
    And I key in more information about what happened and how the item was lost - 5000 characters
    And I click on Continue to navigate to Reporter information screen
    And I key in my personal information
    And I click on Continue to navigate to Summary Page
    And I should be able to navigate to the next page from summary
    And I select "No" in the section to choose that I want to do survey
    And I should be able to submit the application successfully
    Then I should be able to verify that the narrative is truncated when it's length is greater than 16000


  @Scenario_2
  Scenario: Scenario 2: Report with 16000+ character Narrative, plus 3 attachments, 5MB each
    Given I am on the Event Info Page after selecting the events "lost" to report
    When I enter the date and time of the event
    And I key in the details of event location
    And I have indicated that the owner of lost item is "I do"
    And I key in the details of lost items
    When I add multiple lost items into the reports
      | lostItemCount | eventType |
      | 20            | lost      |
    And I key in more information about what happened and how the item was lost - 5000 characters
    And I attach files related to the incident
      | files           |
      | attachmentsDOC  |
      | attachmentsJPEG |
      | attachmentsPDF  |
    And I key in description of any other evidence that exists
    And I click on Continue to navigate to Reporter information screen
    And I key in my personal information
    And I click on Continue to navigate to Summary Page
    And I should be able to navigate to the next page from summary
    And I select "No" in the section to choose that I want to do survey
    And I should be able to submit the application successfully
    Then I should be able to verify that the narrative is truncated when it's length is greater than 16000

  @Scenario_3
  Scenario: Scenario 3: Multiple events with all answers as yes and different owners involved with special characters in names and text fields
    Given I am on the Event Info Page after selecting the events "damaged|stolen|hurt" to report
    When I enter the date and time of the event
    When I key in the details of event location
    And I key in details of the offender
    And I have indicated "yes" to add damaged vehicle where ownerType is the owner of damaged vehicle and keyed in details from damagedVehicleDataSet object in datafile
      | ownerType     | damagedVehicleDataSet |
      | I do          | damagedVehicles_1     |
      | Somebody else | damagedVehicles_2     |
      | Organisation  | damagedVehicles_3     |
    And I have indicated ownerType is the owner of damaged item and keyed in owner's name from damagedItemDataSet object in datafile
      | ownerType     | damagedItemDataSet |
      | I do          | damagedItem_1      |
      | Somebody else | damagedItem_2      |
      | Organisation  | damagedItem_3      |
    And I have indicated "yes" to add stolen vehicle where ownerType is the owner of stolen vehicle and keyed in details from stolenVehicleDataSet object in datafile
      | ownerType     | stolenVehicleDataSet |
      | I do          | stolenVehicles_1     |
      | Somebody else | stolenVehicles_2     |
      | Organisation  | stolenVehicles_3     |
    And I have indicated ownerType is the owner of stolen item and keyed in owner's name from stolenItemDataSet object in datafile
      | ownerType            | stolenItemDataSet |
      | I do                 | stolenItem_1      |
      | Somebody else does   | stolenItem_2      |
      | An organisation does | stolenItem_3      |
    And I key in the details of the person being hurt
    And I key in more information about the event and reason for why they did this
    And I key in description of any other evidence that exists
    And I click on Continue to navigate to Reporter information screen
    And I key in my personal information
    And answer for victim support
    Then I can enter organisation details and select address from lookup
    Then I should be able to key in details of the owner
    And I click on Continue to navigate to Summary Page
    And I should be able to navigate to the next page from summary
    And I select "No" in the section to choose that I want to do survey
    And I should be able to submit the application successfully

  @Scenario_4
  Scenario: Scenario 4: Hurt (Priority 1)
    Given I am on the Event Info Page after selecting the events "hurt" to report
    When I enter the date and time of the event
    And I key in the details of event location with manually keyed in address
      | manualAddress               |
      | eventLocation.manualAddress |
    And I key in details of the offender
    And I key in the details of the person being hurt
    And I key in more information about the event and reason for why they did this
    And I attach files related to the incident
      | files           |
      | attachmentsPNG  |
      | attachmentsJPG  |
      | attachmentsJPEG |
    And I key in description of any other evidence that exists
    And I click on Continue to navigate to Reporter information screen
    And I key in my personal information
    And answer for victim support
    And I click on Continue to navigate to Summary Page
    And I should be able to navigate to the next page from summary
    And I select "No" in the section to choose that I want to do survey
    And I should be able to submit the application successfully
    And I should be able to verify that the priority of submitted report is "P1"

  @Scenario_5
  Scenario: Scenario 5: Something Else Report (Priority 2)
    Given I am on the Event Info Page after selecting the events "somethingElse" to report
    When I enter selected fields in event time section
    And I key in the details of event location with manually keyed in address
      | manualAddress               |
      | eventLocation.manualAddress |
    And I key in more information about what happened and how the item was lost - 5000 characters
    And I attach files related to the incident
      | files          |
      | attachmentsJPE |
      | attachmentsGIF |
      | attachmentsDOC |
    And I key in description of any other evidence that exists
    And I click on Continue to navigate to Reporter information screen
    And I key in my personal information
    And answer for victim support
    And I click on Continue to navigate to Summary Page
    And I should be able to navigate to the next page from summary
    And I select "No" in the section to choose that I want to do survey
    Then I should be able to submit the application successfully
    And I should be able to verify that the priority of submitted report is "P2"

  @Scenario_6
  Scenario: Scenario 6: Damaged (Priority 1 - Family Member Offender)
    Given I am on the Event Info Page after selecting the events "damaged" to report
    When I enter the date and time of the event
    And I key in the details of event location
    And I key in details of the offender
    And I have indicated "yes" to add damaged vehicle where ownerType is the owner of damaged vehicle and keyed in details from damagedVehicleDataSet object in datafile
      | ownerType     | damagedVehicleDataSet |
      | I do          | damagedVehicles_1     |
      | Somebody else | damagedVehicles_2     |
      | Organisation  | damagedVehicles_3     |
    And I have indicated ownerType is the owner of damaged item and keyed in owner's name from damagedItemDataSet object in datafile
      | ownerType     | damagedItemDataSet |
      | I do          | damagedItem_1      |
      | Somebody else | damagedItem_2      |
      | Organisation  | damagedItem_3      |
    And I key in more information about the event and reason for why they did this
    And I attach files related to the incident
      | files           |
      | attachmentsXLSX |
      | attachmentsCSV  |
      | attachmentsPPT  |
    And I key in description of any other evidence that exists
    And I click on Continue to navigate to Reporter information screen
    And I key in my personal information
    And answer for victim support
    And I can enter owner organisation details and key in manual address
      | organisationOwnerDataSet | manualAddressDataSet | isInternationalAddress |
      | damagedVehicles_3        | damagedVehicles_3    | No                     |
      | damagedItem_3            | damagedItem_3        | No                     |
    And I can enter somebody else owner details and key in manual address
      | somebodyElseOwnerDataSet | manualAddressDataSet | isInternationalAddress |
      | damagedVehicles_2        | damagedVehicles_2    | No                     |
      | damagedItem_2            | damagedItem_2        | No                     |
    And I click on Continue to navigate to Summary Page
    And I should be able to navigate to the next page from summary
    And I select "No" in the section to choose that I want to do survey
    Then I should be able to submit the application successfully
    And I should be able to verify that the priority of submitted report is "P1"

  @Scenario_7
  Scenario: Scenario 7: Stolen (Priority 1 - Stolen from home by unknown person) with proximity outside and 3 large attachments
    Given I am on the Event Info Page after selecting the events "stolen" to report
    When I enter the date and time of the event
    And I key in the details of event location
    And I key in details of the offender
    And I have indicated "No" to add stolen vehicle where ownerType is the owner of stolen vehicle and keyed in details from stolenVehicleDataSet object in datafile
      | ownerType | stolenVehicleDataSet |
    And I have indicated ownerType is the owner of stolen item and keyed in owner's name from stolenItemDataSet object in datafile
      | ownerType | stolenItemDataSet |
      | I do      | stolenItem_1      |
    And I attach files related to the incident
      | files           |
      | attachmentsPPTX |
      | attachmentsRTF  |
      | attachmentsXML  |
    And I key in description of any other evidence that exists
    And I click on Continue to navigate to Reporter information screen
    And I key in my personal information
    And answer for victim support
    And I click on Continue to navigate to Summary Page
    And I should be able to navigate to the next page from summary
    And I select "No" in the section to choose that I want to do survey
    And I should be able to submit the application successfully
    And I should be able to verify that the priority of submitted report is "P1"

  @Scenario_8
  Scenario: Scenario 8: Lost Property Report (Priority 1 - Firearm)
    Given I am on the Event Info Page after selecting the events "lost" to report
    When I enter the date and time of the event
    And I key in the details of event location
    And I have indicated the owner of lost item and keyed in owner's name from the datatable
      | ownerType     | lostItemDataSet |
      | I do          | lostItem_1      |
      | Somebody else | lostItem_2      |
      | Organisation  | lostItem_3      |
    And I key in more information about what happened and how the item was lost - 5000 characters
    And I attach files related to the incident
      | files          |
      | attachmentsPDF |
    And I key in description of any other evidence that exists
    And I click on Continue to navigate to Reporter information screen
    And I key in my personal information
    And I can enter owner organisation details and key in manual address
      | organisationOwnerDataSet | manualAddressDataSet | isInternationalAddress |
      | lostItem_3               | lostItem_3           | No                     |
    And I can enter somebody else owner details and key in manual address
      | somebodyElseOwnerDataSet | manualAddressDataSet | isInternationalAddress |
      | lostItem_2               | lostItem_2           | No                     |
    And I click on Continue to navigate to Summary Page
    And I should be able to navigate to the next page from summary
    And I select "No" in the section to choose that I want to do survey
    And I should be able to submit the application successfully
    And I should be able to verify that the priority of submitted report is "P1"

  @Scenario_9
  Scenario: Scenario 9: Damaged (Priority 2 - non Family Member Offender) and reporter nz address manually
    Given I am on the Event Info Page after selecting the events "damaged" to report
    When I enter the date and time of the event
    And I key in the details of event location
    And I key in details of the offender
    And I have indicated "yes" to add damaged vehicle where ownerType is the owner of damaged vehicle and keyed in details from damagedVehicleDataSet object in datafile
      | ownerType | damagedVehicleDataSet |
      | I do      | damagedVehicles_1     |
    And I have indicated ownerType is the owner of damaged item and keyed in owner's name from damagedItemDataSet object in datafile
      | ownerType | damagedItemDataSet |
      | I do      | damagedItem_1      |
    And I key in more information about the event and reason for why they did this
    And I click on Continue to navigate to Reporter information screen
    And I key in my personal information with address keyed in manually and is address international "no"
    And answer for victim support
    And I click on Continue to navigate to Summary Page
    And I should be able to navigate to the next page from summary
    And I select "No" in the section to choose that I want to do survey
    And I should be able to submit the application successfully
    And I should be able to verify that the priority of submitted report is "P2"

  @Scenario_10
  Scenario: Scenario 10: Stolen (Priority 1 - firearms) and foreign address for reporter,oganisation and someone else owner
    Given I am on the Event Info Page after selecting the events "stolen" to report
    When I enter the date and time of the event
    And I key in the details of event location
    And I key in details of the offender
    And I have indicated "No" to add stolen vehicle where ownerType is the owner of stolen vehicle and keyed in details from stolenVehicleDataSet object in datafile
      | ownerType | stolenVehicleDataSet |
    And I have indicated ownerType is the owner of stolen item and keyed in owner's name from stolenItemDataSet object in datafile
      | ownerType            | stolenItemDataSet |
      | Somebody else does   | stolenItem_1      |
      | An organisation does | stolenItem_2      |
    And I click on Continue to navigate to Reporter information screen
    And I key in my personal information with address keyed in manually and is address international "yes"
    And answer for victim support
    And I can enter somebody else owner details and key in manual address
      | somebodyElseOwnerDataSet | manualAddressDataSet | isInternationalAddress |
      | stolenItem_1             | stolenItem_1         | Yes                    |
    Then I can enter owner organisation details and key in manual address
      | organisationOwnerDataSet | manualAddressDataSet | isInternationalAddress |
      | stolenItem_2             | stolenItem_2         | yes                    |
    And I click on Continue to navigate to Summary Page
    And I should be able to navigate to the next page from summary
    And I select "No" in the section to choose that I want to do survey
    And I should be able to submit the application successfully
    And I should be able to verify that the priority of submitted report is "P1"

  @Scenario_11
  Scenario: Scenario 11: Lost Property Report (Priority 3)
    Given I am on the Event Info Page after selecting the events "lost" to report
    When I enter the date and time of the event
    And I key in the details of event location
    And I have indicated that the owner of lost item is "I do"
    And I key in the details of lost items
    And I key in more information about what happened and how the item was lost - 5000 characters
    And I attach files related to the incident
      | files           |
      | attachmentsDOCX |
      | attachmentsTXT  |
      | attachmentsXLS  |
    And I key in description of any other evidence that exists
    And I click on Continue to navigate to Reporter information screen
    And I key in my personal information
    And I click on Continue to navigate to Summary Page
    And I should be able to navigate to the next page from summary
    And I select "No" in the section to choose that I want to do survey
    And I should be able to submit the application successfully
    And I should be able to verify that the priority of submitted report is "P3"

  @Scenario_12
  Scenario: Scenario 12: Stolen Priority 1 Vehicle
    Given I am on the Event Info Page after selecting the events "stolen" to report
    When I enter the date and time of the event
    And I key in the details of event location
    And I key in details of the offender
    And I have indicated "yes" to add stolen vehicle where ownerType is the owner of stolen vehicle and keyed in details from stolenVehicleDataSet object in datafile
      | ownerType | stolenVehicleDataSet |
      | I do      | stolenVehicles_1     |
    And I click on Continue to navigate to Reporter information screen
    And I key in my personal information
    And answer for victim support
    And I click on Continue to navigate to Summary Page
    And I should be able to navigate to the next page from summary
    And I select "No" in the section to choose that I want to do survey
    And I should be able to submit the application successfully
    And I should be able to verify that the priority of submitted report is "P1"

  @Scenario_13
  Scenario: Scenario 13: Stolen Priority 2 other
    Given I am on the Event Info Page after selecting the events "stolen" to report
    When I enter the date and time of the event
    And I key in the details of event location
    And I key in details of the offender
    And I have indicated "No" to add stolen vehicle where ownerType is the owner of stolen vehicle and keyed in details from stolenVehicleDataSet object in datafile
      | ownerType | stolenVehicleDataSet |
    And I have indicated ownerType is the owner of stolen item and keyed in owner's name from stolenItemDataSet object in datafile
      | ownerType | stolenItemDataSet |
      | I do      | stolenItem_1      |
    And I click on Continue to navigate to Reporter information screen
    And I key in my personal information
    And answer for victim support
    And I click on Continue to navigate to Summary Page
    And I should be able to navigate to the next page from summary
    And I select "No" in the section to choose that I want to do survey
    And I should be able to submit the application successfully
    And I should be able to verify that the priority of submitted report is "P2"


