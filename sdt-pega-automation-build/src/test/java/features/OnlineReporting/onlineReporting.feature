@ALL_SCENARIO
Feature: Scenarios to be tested for reporting an incident

  Background: Navigate to form
    Given I’m on the Police website
    When I’m on the online form

  @unit @upgrade @smoke @TusharDone
  Scenario: Triage Emergency events
    When I don’t indicate that the event is not an emergency
    Then I won’t be able to proceed on the form

  @unit @upgrade @TusharDone
  Scenario: Non-emergency event
    When I indicate that the event is not an emergency
    Then I will be able to proceed on the form

  @unit @upgrade @TusharDone
  Scenario: Check the logic to select checkboxes in What happened screen
    Given I indicate that the event is not an emergency
    And select continue
    Then I should be able to select Lost Property checkbox only when damaged, hurt, stolen or Something else checkbox is not selected
    And I should be able to select Something else checkbox only when damaged, hurt, stolen or Lost Property checkbox is not selected
    And I should be able to select damaged, hurt or stolen only when Lost property or Something else checkbox is not selected


  @unit @upgrade @TusharDone
  Scenario Outline: Validate different Event type questions
    Given I'm on the options screens on a non-emergency incident
    When I select the checkboxes in SelectOptions page "<Damaged>", "<Stolen>", "<Hurt>", "<Lost>", "<SomethingElse>"
    And select continue
    Then I should be navigated to the Questions Page
    And I should see the relevant "<DamagedSection>", "<StolenSection>", "<HurtSection>", "<LostSection>", "<SomethingElseSection>" based on the selection made on the checkboxes
    And I should see the sections EVENT LOCATION DETAILS, ATTACHMENTS and ANYTHING ELSE for all combinations of events except something else
    And I should see only sections WHAT HAPPENED and ATTACHMENTS for something else
    Examples:
      | Damaged | Stolen | Hurt | Lost | SomethingElse | DamagedSection | StolenSection | HurtSection | LostSection | SomethingElseSection |
      | Yes     | Yes    | Yes  | No   | No            | Yes            | Yes           | Yes         | No          | No                   |
      | Yes     | Yes    | No   | No   | No            | Yes            | Yes           | No          | No          | No                   |
      | Yes     | No     | Yes  | No   | No            | Yes            | No            | Yes         | No          | No                   |
      | No      | Yes    | Yes  | No   | No            | No             | Yes           | Yes         | No          | No                   |
      | Yes     | No     | No   | No   | No            | Yes            | No            | No          | No          | No                   |
      | No      | Yes    | No   | No   | No            | No             | Yes           | No          | No          | No                   |
      | No      | No     | Yes  | No   | No            | No             | No            | Yes         | No          | No                   |
      | No      | No     | No   | Yes  | No            | No             | No            | No          | Yes         | No                   |
      | No      | No     | No   | No   | Yes           | No             | No            | No          | No          | Yes                  |

  @unit @upgrade @currentTest @TusharDone
  Scenario Outline: Provide location type
    Given I am on the Event Info Page after selecting the events "stolen" to report
    When I select the Event "<Location>" from a dropdown in the Where did it happen section
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


  @unit @upgrade @TusharDone @stolen
  Scenario: Stolen Items details from vehicle is asked only for stolen event type
    Given I am on the Event Info Page after selecting the events "stolen" to report
    When I select the Event Location from a dropdown in the Where did it happen section
    And I should see sections relevant to Location Type
    And I should be able to key in the required data on to the fields
    Then I should be able to see fields to key in stolen item details from vehicle
    And a dropdown to select it's location


  @unit @upgrade @TusharDone @hurt
  Scenario: Remove address choosen in error
    Given I am on the Event Info Page after selecting the events "hurt" to report
    When I wish to remove the address choosen for any event
    Then I should be able to remove the choosen address

  @unit @upgrade @TusharDone @hurt
  Scenario: Not allowing user to manually enter event location address if address is already selected
    Given I am on the Event Info Page after selecting the events "hurt" to report
    When I have already selected the address from the search bar
    Then I should not be allowed to choose can't find the address checkbox

  @unit @upgrade @TusharDone @hurt
  Scenario: Not allowing user to key in event location address using autocomplete field if the user intends to choose address manually
    Given I am on the Event Info Page after selecting the events "hurt" to report
    When I have intend to choose the address manually by selecting 'cant find address' checkbox
    Then I should not be allowed to use autocomplete field to key in address

  @unit @upgrade @TusharDone @damaged
  Scenario: Provide offender information
    Given I am on the Event Info Page after selecting the events "damaged" to report
    And I indicate that I know who the offender is
    Then I should be able to key in the required data on to the Offender section
    And I should be able to verify list values of offender relationship


  @unit @upgrade @TusharDone @stolen
  Scenario: Specify offender relationship
    Given I am on the Event Info Page after selecting the events "stolen" to report
    And I indicate that I know who the offender is
    And I have selected relationship type "Other"
    Then I am able to key in the required data into the ‘Other Specify’ field

  @unit @upgrade @TusharDone @hurt
  Scenario: Provide offender description
    Given I am on the Event Info Page after selecting the events "hurt" to report
    And I indicate that I have a description of the offender
    Then I should be able to key in the required data on to the Offender Description

  @unit @upgrade @TusharDone @stolen
  Scenario: Provide offender vehicle info
    Given I am on the Event Info Page after selecting the events "stolen" to report
    And I indicate that I have a description of a vehicle
    Then I should see sections relevant to vehicle description
    And I should be able to key in the required data on to the Offender Vehicle section

  @unit @upgrade @TusharDone @damaged
  Scenario: Provide witness details
    Given I am on the Event Info Page after selecting the events "damaged" to report
    And I indicate that I have a witnesses contact details
    Then I should see sections relevant to witness contact details
    And I should be able to key in the required data on to the witness section


  @unit @upgrade @TusharDone @damaged
  Scenario: Damaged vehicles
    Given I am on the Event Info Page after selecting the events "damaged" to report
    When I have to indicate that one or more vehicles has been damaged
    Then I am presented with fields to give details of the damaged vehicle
    And I am able to add additional damaged vehicle
    And delete additional damaged vehicles

  @unit @upgrade @TusharDone @damaged
  Scenario Outline: Define owner of damaged vehicle
    Given I am on the Event Info Page after selecting the events "damaged" to report
    And I have to indicate that one or more vehicles has been damaged
    When I have selected the damaged vehicle "<owner>" from the dropdown as
    Then I should be able to key in the required data on the details of damaged vehicle owner
    Examples:
      | owner                |
      | Somebody else does   |
      | An organisation does |

  @unit @upgrade @TusharDone @damaged
  Scenario: Damaged items
    Given I am on the Event Info Page after selecting the events "damaged" to report
    When I have to report about or more damaged items
    Then I am able to add details of damaged Items
    And I am able to multiple damaged items to report
    And delete additional damaged items

  @unit @upgrade @TusharDone @damaged
  Scenario Outline: Define owner of damaged items
    Given I am on the Event Info Page after selecting the events "damaged" to report
    When I have to report about or more damaged items
    And I have selected the damaged item "<owner>" from the dropdown as
    Then I should be able to key in the required data on to the fields of damaged item owner
    Examples:
      | owner                |
      | Somebody else does   |
      | An organisation does |

  @unit @upgrade @TusharDone @damaged
  Scenario: Mandatory Damaged Items when there are not vehicles damaged
    Given I am on the Event Info Page after selecting the events "damaged" to report
    When I select "no" for Damaged vehicles
    Then I should see the Damaged Item turns into a mandatory field

  @unit @upgrade @TusharDone @stolen
  Scenario: Mandatory Stolen Items
    Given I am on the Event Info Page after selecting the events "stolen" to report
    When I select "no" for Stolen vehicles
    Then I should see the Stolen Item turns into a mandatory field

  @unit @upgrade @TusharDone @stolen
  Scenario: Stolen vehicle
    Given I am on the Event Info Page after selecting the events "stolen" to report
    And I have indicated a vehicle was stolen
    Then I am presented with fields to give details of a stolen vehicle
    And I am able to add additional stolen vehicles
    And delete additional stolen vehicles

  @unit @upgrade @TusharDone @stolen
  Scenario Outline: Stolen vehicle towing agreement
    Given I am on the Event Info Page after selecting the events "stolen" to report
    And I have indicated a vehicle was stolen
    When I have answered "<owner>" to the question Who owns it
    Then I should be allowed to proceed until I indicate whether I wish to pay, or not, for the vehicle to be towed if it is found
    Examples:
      | owner                |
      | I do                 |
      | Somebody else does   |
      | An organisation does |


  @unit @upgrade @TusharDone @stolen
  Scenario Outline: Define owner of stolen vehicles
    Given I am on the Event Info Page after selecting the events "stolen" to report
    And I have indicated a vehicle was stolen
    When I will be presented with the relevant questions of stolen Vehicles
    And I have selected the stolen vehicle "<owner>" from the dropdown
    Then I should be able to key in the Owner details of Stolen Vehicle
    Examples:
      | owner                |
      | Somebody else does   |
      | An organisation does |

  @unit @upgrade @TusharDone @stolen
  Scenario: Stolen item
    Given I am on the Event Info Page after selecting the events "stolen" to report
    And I have to key in the details of stolen item
    Then I am presented with fields to give details of a stolen item
    And I am able to add additional stolen items
    And delete additional stolen items

  @unit @upgrade @TusharDone @stolen
  Scenario Outline: Define owner of stolen Items
    Given I am on the Event Info Page after selecting the events "stolen" to report
    And I have indicated somethings been stolen
    When I have selected the stolen item "<owner>" from the dropdown as
    Then I should be able to key in the required data on to the fields related to owner of stolen item
    Examples:
      | owner                |
      | Somebody else does   |
      | An organisation does |

  @unit @upgrade @TusharDone @hurt
  Scenario: Hurt Related fields
    Given I am on the Event Info Page after selecting the events "hurt" to report
    Then I am able to view the fields to enter details related to someone being hurt
    And I am able to key in data on to those fields

  @unit @upgrade @TusharDone
  Scenario: Description of what happened
    Given I am on the Event Info Page after selecting the events "hurt|damaged|stolen" to report
    Then I am able to view the fields to enter description of what happened
    And I am able to key in data related to description of what happened


  @unit @upgrade @fail1
  Scenario: Attaching a valid documents in the case
    Given I am on the Event Info Page after selecting the events "hurt|damaged|stolen" to report
    And I have a document to attach
    Then I can attach any acceptable document types

  @unit @upgrade
  Scenario: Attaching invalid file types
    Given I am on the Event Info Page after selecting the events "hurt|damaged|stolen" to report
    And I have a document to attach
    When I select to upload a file of a non-permissible file type
    Then I will see an error message that indicates it's a non supported file format

  @unit @upgrade
  Scenario: Attaching a file more than 5MB
    Given I am on the Event Info Page after selecting the events "hurt|damaged|stolen" to report
    And I have a document to attach
    When I select to upload a file of a size that is larger than 10MB
    Then I will see an error message that indicates it's a file larger than 10MB

  @unit @upgrade @post-go-live-22
  Scenario: Deleting the attached documents
    Given I am on the Event Info Page after selecting the events "hurt|damaged|stolen" to report
    And I am viewing the files attached to my report
    When I select to delete one of the files
    Then I will see that it is no longer attached to my report

  @unit @upgrade @TusharDone @hurt
  Scenario: Provide reporter details
    Given I am on the Event Info Page after selecting the events "hurt" to report
    And I enter the date and time of the event
    And I key in the details of event location
    And I key in details of the offender
    And I key in the details of the person being hurt
    And I click on Continue to navigate to Reporter information screen
    And I key data into all fields in reporter personal information

  @unit @upgrade @TusharDone
  Scenario: Provide owners details
    Given I am on the Event Info Page after selecting the events "damaged|stolen" to report
    And I enter the date and time of the event
    And I key in the details of event location
    And I key in details of the offender
    And I select "yes" for Damaged vehicles
    When I have indicated "Somebody else does" is the owner of damaged vehicle and keyed in owner's name
    And I have entered required details of damaged vehicle
    And I indicate "No" for a question asking if an vehicle has been stolen
    And I have indicated "I do" is the owner of a stolen item and keyed in owner's name
    And I have entered required details of stolen item
    And I click on Continue to navigate to Reporter information screen
    Then I should see additional fields with owner details in Personal details page
    And I should be able to key in details of the owner
    And I should be able to add additional email address along with default option
    And I should be able to delete the extra email address created
    And I should be able to add additional phone number along with default option
    And I should be able to delete the extra phone number created

  @unit @upgrade @TusharTODO
  Scenario: Provide owners details and verify if the details are pre-populated in the Contact details page
    Given I am on the Event Info Page after selecting the events "damaged|stolen" to report
    And I enter the date and time of the event
    And I key in the details of event location
    And I key in details of the offender
    And I select "yes" for Damaged vehicles
    When I have indicated "Somebody else does" is the owner of damaged vehicle and keyed in owner's name
    And I have entered required details of damaged vehicle
    And I have indicated "Somebody else does" is the owner of damaged item and keyed in owner's name
    And I have entered required details of damaged item
    And I select "yes" for Stolen vehicles
    And I have indicated "Somebody else does" is the owner of a stolen vehicle and keyed in owner's name
    And I have entered required details of stolen vehicle
    And I have indicated "Somebody else does" is the owner of a stolen item and keyed in owner's name
    And I have entered required details of stolen item
    And I click on Continue to navigate to Reporter information screen
    Then I should see additional fields with owner details in Personal details page
    And I should see their names correctly prepopulated

  @unit @upgrade @fail
  Scenario: Provide organisations details and verify if the details are pre-populated in the Contact details page
    Given I am on the Event Info Page after selecting the events "damaged|stolen" to report
    And I enter the date and time of the event
    And I key in the details of event location
    And I key in details of the offender
    And I select "yes" for Damaged vehicles
    When I have indicated "An organisation does" is the owner of damaged vehicle and keyed in owner's name
    And I have entered required details of damaged vehicle
    And I have indicated "An organisation does" is the owner of damaged item and keyed in owner's name
    And I have entered required details of damaged item
    And I select "yes" for Stolen vehicles
    And I have indicated "An organisation does" is the owner of a stolen vehicle and keyed in owner's name
    And I have entered required details of stolen vehicle
    And I have indicated "An organisation does" is the owner of a stolen item and keyed in owner's name
    And I have entered required details of stolen item
    And I click on Continue to navigate to Reporter information screen
    Then I should see additional fields with Organisation owner details in Personal details page
    And I should see the organisation name correctly prepopulated

  @e2e @upgrade @TusharRun @e2eHurtWeb
  Scenario: Submit an online report when someone is hurt
    Given I am on the Event Info Page after selecting the events "hurt" to report
    And I enter the date and time of the event
    And I key in the details of event location
    And I key in details of the offender
    And I key in the details of the person being hurt
    And I key in more information about what happened
    And I attach any relevant attachment of the incident
    And I click on Continue to navigate to Reporter information screen
    And I key in my personal information
    And I indicate i need victim support
    And I click on Continue to navigate to Summary Page
    Then I should be able to verify all the keyed in data in the summary screen
    And I should be able to navigate to the next page from summary
    And I select "yes" in the section to choose that I want to do survey
    Then I should be able to view all survey questions and select opinion as appropriate
    And I should be able to submit the application successfully
    And I should be able to see a summary email with correct data
    And I should receive an email from NZ Police with the summary of the report


  @e2e @deployment @upgrade @e2eStolenWeb
  Scenario: Submit an online report when some vehicles and items has been stolen
    Given I am on the Event Info Page after selecting the events "stolen" to report
    When I enter the date and time of the event
    And I key in the details of event location
    And I key in details of the offender
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
    And I key in more information about what happened regarding stolen items and vehicles
    And I attach any relevant attachment of the incident
    And I click on Continue to navigate to Reporter information screen
    And I key in my personal information
    And I indicate i need victim support
    Then I should be able to see details of the owner of second stolen Item prepopulated
    And I should be able to add details of the owner of second stolen Item
    And I should be able to see details of the owner of third stolen Item prepopulated
    And I should be able to add address of the organisation of stolen Item Owner
    And I should be able to see details of the owner of second stolen vehicle prepopulated
    And I should be able to add details of the owner of second stolen vehicle
    And I should be able to see details of the owner of third stolen vehicle prepopulated
    And I should be able to add address of the organisation of stolen Vehicle Owner
    And I click on Continue to navigate to Summary Page
    And I should be able to verify all the keyed in data in the summary screen
    And I should be able to navigate to the next page from summary
    And I select "yes" in the section to choose that I want to do survey
    Then I should be able to view all survey questions and select opinion as appropriate
    And I should be able to submit the application successfully
    And I should be able to see a summary email with correct data
    And I should receive an email from NZ Police with the summary of the report


  @e2e @upgrade @e2eDamagedWeb
  Scenario: Submit an online report when some item has been damaged
    Given I am on the Event Info Page after selecting the events "damaged" to report
    When I enter the date and time of the event
    And I key in the details of event location
    And I key in details of the offender
    And I select "No" for Damaged vehicles
    And I have indicated "I do" is the owner of damaged item and keyed in owner's name
    And I have entered required details of damaged item
    And I add another damaged Item
    And I have indicated "Somebody else does" is the owner of damaged item and keyed in owner's name
    And I have entered required details of damaged item
    And I add another damaged Item
    And I have indicated "An organisation does" is the owner of damaged item and keyed in owner's name
    And I have entered required details of damaged item
    And I key in more information about what happened
    And I attach any relevant attachment of the incident
    And I click on Continue to navigate to Reporter information screen
    And I key in my personal information
    And I indicate i need victim support
    Then I should be able to see details of the owner of second damaged Item prepopulated
    And I should be able to add details of the owner of second damaged Item
    And I should be able to see details of the owner of third damaged Item prepopulated
    And I should be able to add address of the organisation of damaged Item Owner
    And I click on Continue to navigate to Summary Page
    And I should be able to verify all the keyed in data in the summary screen
    And I should be able to navigate to the next page from summary
    And I select "yes" in the section to choose that I want to do survey
    Then I should be able to view all survey questions and select opinion as appropriate
    And I should be able to submit the application successfully
    And I should be able to see a summary email with correct data
    And I should receive an email from NZ Police with the summary of the report


  @e2e @upgrade @e2eDamagedWeb
  Scenario: Submit an online report when some vehicle has been damaged
    Given I am on the Event Info Page after selecting the events "damaged" to report
    When I enter the date and time of the event
    And I key in the details of event location
    And I key in details of the offender
    And I select "yes" for Damaged vehicles
    And I have indicated "I do" is the owner of damaged vehicle and keyed in owner's name
    And I have entered required details of damaged vehicle
    And I add another damaged vehicle
    And I have indicated "Somebody else does" is the owner of damaged vehicle and keyed in owner's name
    And I have entered required details of damaged vehicle
    And I add another damaged vehicle
    And I have indicated "An organisation does" is the owner of damaged vehicle and keyed in owner's name
    And I have entered required details of damaged vehicle
    And I key in more information about what happened
    And I attach any relevant attachment of the incident
    And I click on Continue to navigate to Reporter information screen
    And I key in my personal information
    And I indicate i need victim support
    Then I should be able to see details of the owner of second damaged vehicle prepopulated
    And I should be able to add details of the owner of second damaged vehicle
    And I should be able to see details of the owner of third damaged vehicle prepopulated and key in address of Organisation
    And I click on Continue to navigate to Summary Page
    And I should be able to verify all the keyed in data in the summary screen
    And I should be able to navigate to the next page from summary
    And I select "yes" in the section to choose that I want to do survey
    Then I should be able to view all survey questions and select opinion as appropriate
    And I should be able to submit the application successfully
    And I should be able to see a summary email with correct data
    And I should receive an email from NZ Police with the summary of the report


  @e2e @upgrade @e2eHurtWeb
  Scenario: Submit an online report when someone is hurt with manual entry in all address fields
    Given I am on the Event Info Page after selecting the events "hurt" to report
    And I enter the date and time of the event
    And I key in the details of event location with manually keyed in address
    And I key in details of the offender
    And I key in the details of the person being hurt
    And I key in more information about what happened
    And I attach any relevant attachment of the incident
    And I click on Continue to navigate to Reporter information screen
    And I key in my personal information with manually keyed in address
    And I indicate i need victim support
    And I click on Continue to navigate to Summary Page
    Then I should be able to verify all the keyed in data in the summary screen
    And I should be able to navigate to the next page from summary
    And I select "yes" in the section to choose that I want to do survey
    Then I should be able to view all survey questions and select opinion as appropriate
    And I should be able to submit the application successfully
    And I should be able to see a summary email with correct data
    And I should receive an email from NZ Police with the summary of the report


  @e2e @deployment @upgrade @e2eStolenWeb
  Scenario: Submit an online report when some vehicles and items has been stolen with manual entry in all address fields
    Given I am on the Event Info Page after selecting the events "stolen" to report
    When I enter the date and time of the event
    And I key in the details of event location with manually keyed in address
    And I key in details of the offender
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
    And I key in more information about what happened regarding stolen items and vehicles
    And I attach any relevant attachment of the incident
    And I click on Continue to navigate to Reporter information screen
    And I key in my personal information with manually keyed in address
    And I indicate i need victim support
    Then I should be able to see details of the owner of second stolen Item prepopulated and key in manually entered address
    And I should be able to add details of the owner of second stolen Item
    And I should be able to see details of the owner of third stolen Item prepopulated
    And I should be able to add address of the organisation of stolen Item Owner manually
    And I should be able to see details of the owner of second stolen vehicle prepopulated and key in manually entered address
    And I should be able to add details of the owner of second stolen vehicle
    And I should be able to see details of the owner of third stolen vehicle prepopulated
    And I should be able to add address of the organisation of stolen Vehicle Owner manually
    And I click on Continue to navigate to Summary Page
    And I should be able to verify all the keyed in data in the summary screen
    And I should be able to navigate to the next page from summary
    And I select "yes" in the section to choose that I want to do survey
    Then I should be able to view all survey questions and select opinion as appropriate
    And I should be able to submit the application successfully
    And I should be able to see a summary email with correct data
    And I should receive an email from NZ Police with the summary of the report


  @e2e @upgrade @1 @e2eDamagedWeb
  Scenario: Submit an online report when some item has been damaged with manual entry in all address fields
    Given I am on the Event Info Page after selecting the events "damaged" to report
    When I enter the date and time of the event
    And I key in the details of event location with manually keyed in address
    And I key in details of the offender
    And I select "No" for Damaged vehicles
    And I have indicated "I do" is the owner of damaged item and keyed in owner's name
    And I have entered required details of damaged item
    And I add another damaged Item
    And I have indicated "Somebody else does" is the owner of damaged item and keyed in owner's name
    And I have entered required details of damaged item
    And I add another damaged Item
    And I have indicated "An organisation does" is the owner of damaged item and keyed in owner's name
    And I have entered required details of damaged item
    And I key in more information about what happened
    And I attach any relevant attachment of the incident
    And I click on Continue to navigate to Reporter information screen
    And I key in my personal information with manually keyed in address
    And I indicate i need victim support
    Then I should be able to see details of the owner of second damaged Item prepopulated and key in manually entered address
    And I should be able to add details of the owner of second damaged Item
    And I should be able to see details of the owner of third damaged Item prepopulated
    And I should be able to add address of the organisation of damaged Item Owner manually
    And I click on Continue to navigate to Summary Page
    And I should be able to verify all the keyed in data in the summary screen
    And I should be able to navigate to the next page from summary
    And I select "yes" in the section to choose that I want to do survey
    Then I should be able to view all survey questions and select opinion as appropriate
    And I should be able to submit the application successfully
    And I should be able to see a summary email with correct data
    And I should receive an email from NZ Police with the summary of the report


  @e2e @upgrade @e2eDamagedWeb
  Scenario: Submit an online report when some vehicle has been damaged with manual entry in all address fields
    Given I am on the Event Info Page after selecting the events "damaged" to report
    When I enter the date and time of the event
    And I key in the details of event location with manually keyed in address
    And I key in details of the offender
    And I select "yes" for Damaged vehicles
    And I have indicated "I do" is the owner of damaged vehicle and keyed in owner's name
    And I have entered required details of damaged vehicle
    And I add another damaged vehicle
    And I have indicated "Somebody else does" is the owner of damaged vehicle and keyed in owner's name
    And I have entered required details of damaged vehicle
    And I add another damaged vehicle
    And I have indicated "An organisation does" is the owner of damaged vehicle and keyed in owner's name
    And I have entered required details of damaged vehicle
    And I key in more information about what happened
    And I attach any relevant attachment of the incident
    And I click on Continue to navigate to Reporter information screen
    And I key in my personal information with manually keyed in address
    And I indicate i need victim support
    Then I should be able to see details of the owner of second damaged vehicle prepopulated and key in manually entered address
    And I should be able to add details of the owner of second damaged vehicle
    And I should be able to see details of the owner of third damaged vehicle prepopulated and key in address of Organisation manually
    And I click on Continue to navigate to Summary Page
    And I should be able to verify all the keyed in data in the summary screen
    And I should be able to navigate to the next page from summary
    And I select "yes" in the section to choose that I want to do survey
    Then I should be able to view all survey questions and select opinion as appropriate
    And I should be able to submit the application successfully
    And I should be able to see a summary email with correct data
    And I should receive an email from NZ Police with the summary of the report

#  @e2e @deployment
#  Scenario Outline: Submit an online report when some vehicles and items has been damaged
#    When I want to use online forms to submit "<details>" of an incident where some vehicles and items has been damaged
#    And I enter the date and time of the event
#    And I indicate that the something is damaged at a location and key in it's details
#    And I key in details of the offender who damaged vehicles and items
#    And I indicate that a vehicle has been damaged
#    And I key in the details of first damaged vehicle
#    And I select the owner of first damaged as I do
#    And I add another damaged vehicle
#    And I key in the details of second damaged vehicle
#    And I select the owner of the second damaged vehicle as Somebody else does
#    And I key in the owner details of the second damaged vehicle
#    And I add another damaged vehicle
#    And I key in the details of third damaged vehicle
#    And I select the owner of the third damaged vehicle as An Organisation does
#    And I key in the owner details of the third damaged vehicle
#    And I key in what was the first damaged item
#    And I select the owner of first damaged item as I do
#    And I key in how was it damaged for first damaged item
#    And I add another damaged Item
#    And I key in what was the second damaged item
#    And I select the owner of the second damaged item as Somebody else does
#    And I key in the owner details of the second damaged item
#    And I key in how was it damaged for second damaged item
#    And I add another damaged Item
#    And I key in what was the third damaged item
#    And I select the owner of the third damaged item as An Organisation does
#    And I key in the owner details of the third damaged item
#    And I key in how was it damaged for third damaged item
#    And I key in more information about what happened regarding damaged items and vehicles
#    And I attach any relevant attachment of the incident
#    And I key in my personal information
#    And I indicate i need victim support
#    Then I should be able to see details of the owner of second damaged Item prepopulated
#    And I should be able to add details of the owner of second damaged Item
#    And I should be able to see details of the owner of third damaged Item prepopulated
#    And I should be able to add address of the organisation of damaged Item Owner
#    And I should be able to see details of the owner of second damaged vehicle prepopulated
#    And I should be able to add details of the owner of second damaged vehicle
#    And I should be able to see details of the owner of third damaged vehicle prepopulated
#    And I should be able to add address of the organisation of damaged Vehicle Owner
#    And I should be able to verify all the keyed in data in the summary screen
#    And I should be able to see a summary email with correct data
#    And I should receive an email from NZ Police with the summary of the report
#    Examples:
#      | details                                                             |
#      | onlineReporting~~OnlineReporting_Data.json~~damagedVehiclesAndItems |

#  @e2e
#  Scenario Outline: Submit an online report when some item has been stolen
#    When I indicate that something has been stolen
#    And I enter the date and time of the event
#    And I indicate that the event happened at a "<location>" and key in it's details
#    And I key in details of the offender
#    And I key in the details of stolen item
#    And I select the owner of first stolen item as "I do"
#    And I add another stolen Item
#    And I select the owner of the second stolen item as "Somebody else does"
#    And I add another stolen Item
#    And I select the owner of the third stolen item as "An Organisation does"
#    And I key in more information about what happened
#    And I attach any relevant attachment of the incident
#    And I key in my personal information
#    And I key in my "<emailaddress>"
#    And I key in an additional "<additonalemailaddress>"
#    And I am able to key in home phone "<homephone>"
#    And I set preferred contact details as "Email"
#    And I indicate victim support as "No"
#    Then I should be able to see details of the owner of second stolen item prepopulated
#    And I should be able to add phone number of the owner of second stolen item
#    And I should be able to see details of the owner of third stolen item prepopulated
#    And I should be able to add address of the organisation
#    And I should be able to verify all the keyed in data in the summary screen
#    And I should be able to see a summary email with correct data
#    And I should receive an email from NZ Police with the summary of the report
#    Examples:
#      | location | emailaddress   | additonalemailaddress    | homephone |
#      | At home  | auto@gmail.com | autoadditional@gmail.com | 021021000 |

#  @e2e
#  Scenario Outline: Submit an online report when some vehicle has been stolen
#    When I indicate that something has been stolen
#    And I enter the date and time of the event
#    And I indicate that the event happened at a "<location>" and key in it's details
#    And I key in details of the offender
#    And I key in the details of stolen vehicle
#    And I select the owner of first stolen vehicle as "I do"
#    And I add another stolen vehicle
#    And I select the owner of the second stolen vehicle as "Somebody else does"
#    And I add another stolen vehicle
#    And I select the owner of the third stolen vehicle as "An Organisation does"
#    And I key in more information about what happened
#    And I attach any relevant attachment of the incident
#    And I key in my personal information
#    And I key in my "<emailaddress>"
#    And I key in an additional "<additonalemailaddress>"
#    And I am able to key in home phone "<homephone>"
#    And I set preferred contact details as "Email"
#    And I indicate victim support as "No"
#    Then I should be able to see details of the owner of second stolen vehicle prepopulated
#    And I should be able to add phone number of the owner of second stolen vehicle
#    And I should be able to see details of the owner of third stolen vehicle prepopulated
#    And I should be able to add address of the organisation
#    And I should be able to verify all the keyed in data in the summary screen
#    And I should be able to see a summary email with correct data
#    And I should receive an email from NZ Police with the summary of the report
#    Examples:
#      | location | emailaddress   | additonalemailaddress    | homephone |
#      | At home  | auto@gmail.com | autoadditional@gmail.com | 021021000 |


#  @e2e @deployment
#  Scenario Outline: Submit an online report when an incident involving hurt, stolen and damaged
#    When I indicate that something has been hurt, stolen and damaged
#    And I enter the date and time of the event
#    And I indicate that the event happened at a "<location>" and key in it's details
#    And I key in details of the offender
#    And I key in the details of the person being hurt
#    And I key in the details of stolen item
#    And I select the owner of first stolen item as "I do"
#    And I add another stolen item
#    And I select the owner of the second stolen item as "Somebody else does"
#    And I add another stolen item
#    And I select the owner of the third stolen item as "An Organisation does"
#    And I key in the details of stolen item
#    And I select the owner of first stolen as "I do"
#    And I add another stolen vehicle
#    And I select the owner of the second stolen vehicle as "Somebody else does"
#    And I add another stolen vehicle
#    And I select the owner of the third stolen vehicle as "An Organisation does"
#    And I key in more information about what happened
#    And I attach any relevant attachment of the incident
#    And I key in my personal information
#    And I key in my "<emailaddress>"
#    And I key in an additional "<additonalemailaddress>"
#    And I am able to key in home phone "<homephone>"
#    And I set preferred contact details as "Email"
#    And I indicate victim support as "No"
#    Then I should be able to see details of the owner of second stolen Item prepopulated
#    And I should be able to add phone number of the owner of second stolen Item
#    And I should be able to see details of the owner of third stolen Item prepopulated
#    And I should be able to add address of the organisation
#    And I should be able to see details of the owner of second stolen vehicle prepopulated
#    And I should be able to add phone number of the owner of second stolen vehicle
#    And I should be able to see details of the owner of third stolen vehicle prepopulated
#    And I should be able to add address of the organisation
#    And I should be able to verify all the keyed in data in the summary screen
#    And I should be able to see a summary email with correct data
#    And I should receive an email from NZ Police with the summary of the report
#    Examples:
#      | location | emailaddress   | additonalemailaddress    | homephone |
#      | At home  | auto@gmail.com | autoadditional@gmail.com | 021021000 |

  @e2e @deployment @upgrade @e2eSomethingElseWeb
  Scenario: Submit an online report for an incident by selecting Something else
    Given I am on the Event Info Page after selecting the events "somethingElse" to report
    When I enter the date and time of the event
    And I key in the details of event location
    And I key in more information about the event i want to report
    And I attach any relevant attachment of the incident
    And I click on Continue to navigate to Reporter information screen
    And I key in my personal information
    And I indicate i need victim support
    And I click on Continue to navigate to Summary Page
    Then I should be able to verify all the keyed in data in the summary screen
    And I should be able to navigate to the next page from summary
    And I select "yes" in the section to choose that I want to do survey
    Then I should be able to view all survey questions and select opinion as appropriate
    And I should be able to submit the application successfully
    And I should be able to see a summary email with correct data
    And I should receive an email from NZ Police with the summary of the report


  @e2e @deployment @upgrade @lost
  Scenario: Add multiple lost properties in the report
    Given I am on the Event Info Page after selecting the events "lost" to report
    When I enter the date and time of the event
    And I key in the details of event location
    And I have indicated "I do" is the owner of lost item and keyed in owner's name
    And I have entered required details of lost item
    And I add another lost item
    And I have indicated "Somebody else does" is the owner of lost item and keyed in owner's name
    And I have entered required details of lost item
    And I add another lost item
    And I have indicated "An organisation does" is the owner of lost item and keyed in owner's name
    And I have entered required details of lost item
    And I key in more information about the event i want to report

  @e2e @deployment @upgrade @lost
  Scenario: Add owner details to the report when the owner of lost item is some one else
    Given I am on the Event Info Page after selecting the events "lost" to report
    When I enter the date and time of the event
    And I key in the details of event location
    And I can see three options in the lost item owner dropdown
    And I have indicated "Somebody else does" is the owner of lost item and keyed in owner's name
    And I have entered required details of lost item

  @e2e @deployment @upgrade @lost
  Scenario: Add owner details to the report when the owner of lost item is Organisation
    Given I am on the Event Info Page after selecting the events "lost" to report
    When I enter the date and time of the event
    And I key in the details of event location
    And I can see three options in the lost item owner dropdown
    And I have indicated "An organisation does" is the owner of lost item and keyed in owner's name
    Then I have entered required details of lost item
    And I key in more information about the event i want to report

  @e2e @deployment @upgrade @e2eLostWeb1
  Scenario: Submit an online report for a lost property
    Given I am on the Event Info Page after selecting the events "lost" to report
    When I enter the date and time of the event
    And I key in the details of event location
    And I have indicated "I do" is the owner of lost item and keyed in owner's name
    And I have entered required details of lost item
    And I add another lost item
    And I have indicated "Somebody else does" is the owner of lost item and keyed in owner's name
    And I have entered required details of lost item
    And I add another lost item
    And I have indicated "An organisation does" is the owner of lost item and keyed in owner's name
    And I have entered required details of lost item
    And I key in more information about the event i want to report
    And I attach any relevant attachment of the incident
    And I click on Continue to navigate to Reporter information screen
    And I key in my personal information
    Then I should be able to see details of the owner of second lost item prepopulated
    And I should be able to add details of the owner of second lost item
    And I should be able to see details of the owner of third lost item prepopulated and key in address of Organisation
    And I click on Continue to navigate to Summary Page
    And I should be able to verify all the keyed in data in the summary screen
    And I should be able to navigate to the next page from summary
    And I select "yes" in the section to choose that I want to do survey
    Then I should be able to view all survey questions and select opinion as appropriate
    And I should be able to submit the application successfully
    And I should be able to see a summary email with correct data
    And I should receive an email from NZ Police with the summary of the report

  @e2e @deployment @ToBeUpdated @e2eLostWeb
  Scenario: Submit an online report for a lost property with manual entry in all address fields
    Given I am on the Event Info Page after selecting the events "lost" to report
    When I enter the date and time of the event
    And I key in the details of event location with manually keyed in address
    And I have indicated "I do" is the owner of lost item and keyed in owner's name
    And I have entered required details of lost item
    And I add another lost item
    And I have indicated "Somebody else does" is the owner of lost item and keyed in owner's name
    And I have entered required details of lost item
    And I add another lost item
    And I have indicated "An organisation does" is the owner of lost item and keyed in owner's name
    And I have entered required details of lost item
    And I key in more information about the event i want to report
    And I attach any relevant attachment of the incident
    And I click on Continue to navigate to Reporter information screen
    And I key in my personal information with manually keyed in address
    Then I should be able to see details of the owner of second lost item prepopulated and address keyed in manually
    And I should be able to add details of the owner of second lost item
    And I should be able to see details of the owner of third lost item prepopulated and key in address of Organisation manually
    And I click on Continue to navigate to Summary Page
    And I should be able to verify all the keyed in data in the summary screen
    And I should be able to navigate to the next page from summary
    And I select "yes" in the section to choose that I want to do survey
    Then I should be able to view all survey questions and select opinion as appropriate
    And I should be able to submit the application successfully
    And I should be able to see a summary email with correct data
    And I should receive an email from NZ Police with the summary of the report

  Scenario: Field Validations on Non Emergency Page as per the data dictionary

  @fieldValidation @fail
  Scenario: Field validations on Event Info page are applied as per the data dictionary
    Given I am on the Event Info Page after selecting the events "hurt|damaged|stolen" to report
    Then the system should indicate users about mandatory fields in When did it happen section and throw appropriate error message when any mandatory fields are not keyed in
    And I should be able to key in valid data e.g. field length, alphanumeric etc on fields in When did it happen section and throw appropriate error message otherwise
    And the text displayed on fields in When did it happen section should be as expected
    And the system should indicate users about mandatory fields in Where did it happen section and throw appropriate error message when any mandatory fields are not keyed in
    And I should be able to key in valid data e.g. field length, alphanumeric etc on fields in Where did it happen section and throw appropriate error message otherwise
    And the text displayed on fields in Where did it happen section should be as expected
    And the system should indicate users about mandatory fields in Who was involved section and throw appropriate error message when any mandatory fields are not keyed in
    And I should be able to key in valid data e.g. field length, alphanumeric etc on fields in Who was involved section and throw appropriate error message otherwise
    And the text displayed on fields in Who was involved section should be as expected
    And the system should indicate users about mandatory fields in Damaged Vehicles section and throw appropriate error message when any mandatory fields are not keyed in
    And I should be able to key in valid data e.g. field length, alphanumeric etc on fields in Damaged Vehicles section and throw appropriate error message otherwise
    And the text displayed on fields in Damaged Vehicles section should be as expected
    And the system should indicate users about mandatory fields in What was damaged section and throw appropriate error message when any mandatory fields are not keyed in
    And I should be able to key in valid data e.g. field length, alphanumeric etc on fields in What was damaged section and throw appropriate error message otherwise
    And the text displayed on fields in What was damaged section should be as expected
    And the system should indicate users about mandatory fields in Stolen Vehicles section and throw appropriate error message when any mandatory fields are not keyed in
    And I should be able to key in valid data e.g. field length, alphanumeric etc on fields in Stolen Vehicles section and throw appropriate error message otherwise
    And the text displayed on fields in Stolen Vehicles section should be as expected
    And the system should indicate users about mandatory fields in What was stolen section and throw appropriate error message when any mandatory fields are not keyed in
    And I should be able to key in valid data e.g. field length, alphanumeric etc on fields in What was stolen section and throw appropriate error message otherwise
    And the text displayed on fields in What was stolen section should be as expected
    And the system should indicate users about mandatory fields in Who was hurt of threatened section and throw appropriate error message when any mandatory fields are not keyed in
    And I should be able to key in valid data e.g. field length, alphanumeric etc on fields in Who was hurt of threatened section and throw appropriate error message otherwise
    And the text displayed on fields in What was hurt of threatened should be as expected
    And the system should indicate users about mandatory fields in What happened section and throw appropriate error message when any mandatory fields are not keyed in
    And I should be able to key in valid data e.g. field length, alphanumeric etc on fields in What happened section and throw appropriate error message otherwise
    And the text displayed on fields in What happened should be as expected
    And the system should indicate users about mandatory fields in Attachments section and throw appropriate error message when any mandatory fields are not keyed in
    And I should be able to key in valid data e.g. field length, alphanumeric etc on fields in Attachments section and throw appropriate error message otherwise
    And the text displayed on fields in Attachments should be as expected

  @fieldValidation @fail
  Scenario: Field validations on Contact Details page are applied as per the data dictionary
    Given I am on the Event Info Page after selecting the events "hurt|damaged|stolen" to report
    Then the system should indicate users about mandatory fields in Please provide your details section and throw appropriate error message when any mandatory fields are not keyed in
    And I should be able to key in valid data e.g. field length, alphanumeric etc on fields in Please provide your details section and throw appropriate error message otherwise
    And the text displayed on fields in Please provide your details section should be as expected
    And the system should indicate users about mandatory fields in Owner details section and throw appropriate error message when any mandatory fields are not keyed in
    And I should be able to key in valid data e.g. field length, alphanumeric etc on fields in Owner details section section and throw appropriate error message otherwise
    And the text displayed on fields in Owner details should be as expected

#  Scenario: Summary page with non-editable data
#    Given I am on Summary page after keying in data for relevant fields to report an incident
#    When I want to view the data already keyed in
#    Then I should be able to view data in non-editable mode before submitting
#
#  Scenario: Editing the data in summary page
#    Given I am on Summary page after keying in data for relevant fields to report an incident
#    When I want to edit the data already keyed in
#    Then I should be able to edit data and submit
#
#  Scenario: Save a copy of the summary page in pdf
#    Given I am on Summary page after keying in data for relevant fields to report an incident
#    When I want to view the data already keyed in
#    Then I should be able to view data in non-editable mode before submitting
#    And I should also be able to save a copy of summary page in pdf


  @todo @fail
  Scenario: Manually key in location when address drop down cannot find the intended address in hurt event flow
    Given I am on the Event Info Page after selecting the events "hurt|damaged|stolen" to report
    When I indicate I can't find the address from the address search bar
    Then I should be able to key in the address in the respective fields
    And I should see Country New Zealand as non-editable value.

  @unit @deployment @upgrade @damaged @TusharDone
  Scenario: Verify if the user is able to select damaged item from NIA table while reporting some item is damaged
    Given I am on the Event Info Page after selecting the events "damaged" to report
    When I enter the date and time of the event
    And I select "No" for Damaged vehicles
    Then I have indicated "I do" is the owner of damaged item and keyed in owner's name
    And I have entered required details of damaged item


  @unit @deployment @upgrade @stolen @TusharDone
  Scenario: Verify if the user is able to select stolen item from NIA table while reporting some item is stolen
    Given I am on the Event Info Page after selecting the events "stolen" to report
    When I enter the date and time of the event
    And I select "No" for Stolen vehicles
    And I have indicated "I do" is the owner of a stolen item and keyed in owner's name
    And I have entered required details of stolen item


  @unit @deployment @upgrade @lost @TusharDone
  Scenario: Verify if the user is able to select lost item from NIA table while reporting some item is lost
    Given I am on the Event Info Page after selecting the events "lost" to report
    When I enter the date and time of the event
    And I have indicated "I do" is the owner of lost item and keyed in owner's name
    And I have entered required details of lost item


#    @TusharFail @TusharFail
#  Scenario: Call 111 Indicator family violence
#    Given I am on the Event Info Page after selecting the events "hurt" to report
#    When I indicate a date and time that is not within the last 24 hours
#    And I choose Family member in offender details
#    Then I should see an indicator that says to reach out to 111 to report family violence


#  Scenario: Call 111 Indicator recent event
#    Given I am on Event Info Page after selecting the events "hurt|damaged|stolen| to report
#    When I choose a event time less than 24 hours
#    Then I should see an indicator that says to reach out to 111 to report

  @unit @deployment @upgrade @damaged @TusharDone
  Scenario Outline: Added owners should be prepopulated in the dropdown while reporting some vehicle is damaged
    Given I am on the Event Info Page after selecting the events "damaged" to report
    When I enter the date and time of the event
    And I key in the details of event location
    And I key in details of the offender
    And I select "yes" for Damaged vehicles
    And I have indicated "<owner>" is the owner of damaged vehicle and keyed in owner's name
    And I have entered required details of damaged vehicle
    Examples:
      | owner                |
      | Somebody else does   |
      | An organisation does |

  @unit @deployment @upgrade @damaged @TusharDone
  Scenario Outline: Added owners should be prepopulated in the dropdown while reporting some item is damaged
    Given I am on the Event Info Page after selecting the events "damaged" to report
    When I enter the date and time of the event
    And I key in the details of event location
    And I key in details of the offender
    And I select "No" for Damaged vehicles
    Then I have indicated "<owner>" is the owner of damaged item and keyed in owner's name
    And I have entered required details of damaged item
    Examples:
      | owner                |
      | Somebody else does   |
      | An organisation does |


  @unit @deployment @upgrade @regressionDone @stolen
  Scenario Outline: Added owners should be prepopulated in the dropdown while reporting some vehicle is stolen
    Given I am on the Event Info Page after selecting the events "stolen" to report
    When I enter the date and time of the event
    And I key in the details of event location
    And I key in details of the offender
    And I select "yes" for Stolen vehicles
    And I have indicated "<owner>" is the owner of a stolen vehicle and keyed in owner's name
    And I have entered required details of stolen vehicle
    Examples:
      | owner                |
      | Somebody else does   |
      | An organisation does |


  @unit @deployment @upgrade @regressionDone @stolen
  Scenario Outline: Added owners should be prepopulated in the dropdown while reporting some item is stolen
    Given I am on the Event Info Page after selecting the events "stolen" to report
    When I enter the date and time of the event
    And I key in the details of event location
    And I select "No" for Stolen vehicles
    And I have indicated "<owner>" is the owner of a stolen item and keyed in owner's name
    And I have entered required details of stolen item
    Examples:
      | owner                |
      | Somebody else does   |
      | An organisation does |


  @unit @deployment @upgrade @regressionDone @lost
  Scenario Outline: Added owners should be prepopulated in the dropdown while reporting some item is lost
    Given I am on the Event Info Page after selecting the events "lost" to report
    When I enter the date and time of the event
    And I key in the details of event location
    And I have indicated "<owner>" is the owner of lost item and keyed in owner's name
    And I have entered required details of lost item
    Examples:
      | owner                |
      | Somebody else does   |
      | An organisation does |

#  @low
#  Scenario: Attaching virus attachment
#    Given I am on the Event Info Page after selecting the events "hurt|damaged|stolen" to report
#    And I have selected to upload a file to attach to my report
#    When I select to upload a file that contains a virus
#    Then I will see an error message that indicates that a virus has been uploaded
#
#  #Need to have the backend plugged in. Till then can't automate
#  @todo
#  Scenario Outline: Email Victim support
#    Given I am on the Person details page by keying the relevant "<Details>"
#    And I have indicated that I want to be contacted by Victim support
#    When I submit my report
#    Then my details will be emailed to victim support
#    Examples:
#      | Details                                                                |
#      | onlineReporting~~OnlineReporting_Data_All_Fields.json~~onlineReporting |
#
#  Scenario: Reporter phone number mandatory
#    Given I am on the Person details page
#    When I indicate that my prefered contact method is phone number
#    Then Reporter phone number should be mandatory


  @unit @upgrade @regressionDone @hurt
  Scenario: Verify system does not allow user to manually enter reporter address if address is already selected
    Given I am on the Event Info Page after selecting the events "hurt" to report
    And I enter the date and time of the event
    And I key in the details of event location
    And I key in details of the offender
    And I key in the details of the person being hurt
    And I click on Continue to navigate to Reporter information screen
    When I have already selected the address of the reporter from the search bar
    Then I should not be allowed to choose 'can't find the address' checkbox to key in reporter's address

  @unit @upgrade @regressionDone @hurt
  Scenario: Verify system does not allow user to key in reporter address using autocomplete field if the user intends to choose address manually
    Given I am on the Event Info Page after selecting the events "hurt" to report
    And I enter the date and time of the event
    And I key in the details of event location
    And I key in details of the offender
    And I key in the details of the person being hurt
    And I click on Continue to navigate to Reporter information screen
    When I have intend to choose reporters address manually by selecting 'cant find address' checkbox
    Then I should not be allowed to use autocomplete field to key in reporter's address

  @unit @upgrade @regressionDone @damaged
  Scenario: Verify system does not allow user to manually enter owner address if address is already selected
    Given I am on the Event Info Page after selecting the events "damaged" to report
    When I enter the date and time of the event
    And I key in the details of event location
    And I key in details of the offender
    And I select "yes" for Damaged vehicles
    And I have indicated "Somebody else does" is the owner of damaged vehicle and keyed in owner's name
    And I have entered required details of damaged vehicle
    And I add another damaged vehicle
    And I have indicated "An organisation does" is the owner of damaged vehicle and keyed in owner's name
    And I have entered required details of damaged vehicle
    And I click on Continue to navigate to Reporter information screen
    When I have already selected the address of the Somebody else does owner from the search bar
    Then I should not be allowed to choose 'cant find address' checkbox to key in Somebody else does owners address
    When I have already selected the address of the Organisation owner from the search bar
    Then I should not be allowed to choose 'cant find address' checkbox to key in Organisation owners address


  @unit @upgrade @regressionDone @damaged
  Scenario: Verify system does not allow user to key in owner address using autocomplete field if the user intends to choose address manually
    Given I am on the Event Info Page after selecting the events "damaged" to report
    When I enter the date and time of the event
    And I key in the details of event location
    And I key in details of the offender
    And I select "yes" for Damaged vehicles
    And I have indicated "Somebody else does" is the owner of damaged vehicle and keyed in owner's name
    And I have entered required details of damaged vehicle
    And I add another damaged vehicle
    And I have indicated "An organisation does" is the owner of damaged vehicle and keyed in owner's name
    And I have entered required details of damaged vehicle
    And I click on Continue to navigate to Reporter information screen
    When I have intend to choose Somebody else does owners address manually by selecting cant find address checkbox
    Then I should not be allowed to use autocomplete field to key in Somebody else does owner address
    When I have intend to choose Organisation owner address manually by selecting cant find address checkbox
    Then I should not be allowed to use autocomplete field to key in Somebody else does Organisation owner address

  @cr2 @regressionDone
  Scenario: Validate if the phone number is mandatory in reporter details section for all events
    Given I am on the Event Info Page after selecting the events "hurt|damaged|stolen" to report
    When I enter the date and time of the event
    And I key in the details of event location
    And I key in details of the offender
    And I select "yes" for Damaged vehicles
    And I have indicated "I do" is the owner of damaged vehicle and keyed in owner's name
    And I have entered required details of damaged vehicle
    And I select "No" for Stolen vehicles
    And I have indicated "I do" is the owner of a stolen item and keyed in owner's name
    And I have entered required details of stolen item
    And I key in the details of the person being hurt
    And I am able to key in data related to description of what happened
    When I click on Continue to navigate to Reporter information screen
    And I key in my personal information without phone type and phone number
    And I indicate i need victim support
    And I click on Continue to navigate to Summary Page and close the alert
    Then I can validate that phone type is a mandatory field
    And I can validate that phone number is a mandatory field
    When I select a phone Type
    And I click on Continue to navigate to Summary Page and close the alert
    Then I can validate that phone number is a mandatory field

  @testRun @regressionDone
  Scenario: Validate if the phone number is mandatory in owner details section for damaged event
    Given I am on the Event Info Page after selecting the events "damaged|stolen" to report
    When I enter the date and time of the event
    And I key in the details of event location
    And I key in details of the offender
    And I select "yes" for Damaged vehicles
    When I have indicated "Somebody else does" is the owner of damaged vehicle and keyed in owner's name
    And I have entered required details of damaged vehicle
    And I select "yes" for Stolen vehicles
    And I have indicated "Somebody else does" is the owner of a stolen vehicle and keyed in owner's name
    And I have entered required details of stolen vehicle
    When I click on Continue to navigate to Reporter information screen
    And I key in my personal information
    And I click on Continue to navigate to Summary Page and close the alert

  @post-go-live-1
  #SDTDT-1448
  Scenario: Protection Order breached
    Given a Protection Order has been breached
    When I attempt to report this via an Online Form
    Then I  can see from the “Let’s get started” page, that I should call 111 instead.

  @post-go-live-11
  #SDTDT-1449
  Scenario Outline: Verify if Reporter can't key in Future date as DOB
    Given I am on the Event Info Page after selecting the events "hurt" to report
    And I enter the date and time of the event
    And I key in the details of event location
    And I key in details of the offender
    And I key in the details of the person being hurt
    And I key in more information about what happened
    And I click on Continue to navigate to Reporter information screen
    And I key in my personal information with future date as Reporter DOB
    And I indicate i need victim support
    And I click on Continue to navigate to Summary Page
    Then I should not be allowed to proceed to next page and see the error "<errorMessage>"
    And I should be able to navigate to the summary page when i use a valid Reporter DOB
    Then I should be able to verify all the keyed in data in the summary screen
    And I should be able to navigate to the next page from summary
    And I select "yes" in the section to choose that I want to do survey
    Then I should be able to view all survey questions and select opinion as appropriate
    And I should be able to submit the application successfully
    And I should be able to see a summary email with correct data
    And I should receive an email from NZ Police with the summary of the report
    Examples:
      | errorMessage                  |
      | DOB: Future Date is not valid |

  @post-go-live-11
  #SDTDT-1449
  Scenario Outline: Verify if Reporter can't key in Current date as DOB
    Given I am on the Event Info Page after selecting the events "hurt" to report
    And I enter the date and time of the event
    And I key in the details of event location
    And I key in details of the offender
    And I key in the details of the person being hurt
    And I key in more information about what happened
    And I click on Continue to navigate to Reporter information screen
    And I key in my personal information with current date as Reporter DOB
    And I indicate i need victim support
    And I click on Continue to navigate to Summary Page
    Then I should not be allowed to proceed to next page and see the error "<errorMessage>"
    And I should be able to navigate to the summary page when i use a valid Reporter DOB
    Then I should be able to verify all the keyed in data in the summary screen
    And I should be able to navigate to the next page from summary
    And I select "yes" in the section to choose that I want to do survey
    Then I should be able to view all survey questions and select opinion as appropriate
    And I should be able to submit the application successfully
    And I should be able to see a summary email with correct data
    And I should receive an email from NZ Police with the summary of the report
    Examples:
      | errorMessage                                                |
      | DOB: The current date as a date of birth cannot be accepted |



  #SDTDT-1449
  @post-go-live-11
  Scenario Outline: Validate if the owner date birth field does not allow future date of birth in dd/mm/yyyy format
    Given I am on the Event Info Page after selecting the events "damaged" to report
    When I enter the date and time of the event
    And I key in the details of event location
    And I key in details of the offender
    And I select "No" for Damaged vehicles
    And I have indicated "I do" is the owner of damaged item and keyed in owner's name
    And I have entered required details of damaged item
    And I add another damaged Item
    And I have indicated "Somebody else does" is the owner of damaged item and keyed in owner's name
    And I have entered required details of damaged item
    And I add another damaged Item
    And I have indicated "An organisation does" is the owner of damaged item and keyed in owner's name
    And I have entered required details of damaged item
    And I key in more information about what happened
    And I click on Continue to navigate to Reporter information screen
    And I key in my personal information
    And I indicate i need victim support
    Then I should be able to see details of the owner of second damaged Item prepopulated
    And I should be able to add details of the owner of second damaged Item and enter a future date to Owner DOB
    And I should be able to see details of the owner of third damaged Item prepopulated
    And I should be able to add address of the organisation of damaged Item Owner
    And I click on Continue to navigate to Summary Page
    Then I should not be allowed to proceed to next page and see the error "<errorMessage>"
    And I should be able to navigate to the summary page when i use a valid Item Owner DOB in ddmmYYYY format
    And I should be able to verify all the keyed in data in the summary screen
    And I should be able to navigate to the next page from summary
    And I select "yes" in the section to choose that I want to do survey
    Then I should be able to view all survey questions and select opinion as appropriate
    And I should be able to submit the application successfully
    And I should be able to see a summary email with correct data
    And I should receive an email from NZ Police with the summary of the report
    Examples:
      | errorMessage                         |
      | AgeOrBirth: Future Date is not valid |


  #SDTDT-1449
  @post-go-live-11
  Scenario Outline: Validate if the owner date birth field does not allow future date of birth as age in years
    Given I am on the Event Info Page after selecting the events "damaged" to report
    When I enter the date and time of the event
    And I key in the details of event location
    And I key in details of the offender
    And I select "No" for Damaged vehicles
    And I have indicated "I do" is the owner of damaged item and keyed in owner's name
    And I have entered required details of damaged item
    And I add another damaged Item
    And I have indicated "Somebody else does" is the owner of damaged item and keyed in owner's name
    And I have entered required details of damaged item
    And I add another damaged Item
    And I have indicated "An organisation does" is the owner of damaged item and keyed in owner's name
    And I have entered required details of damaged item
    And I key in more information about what happened
    And I click on Continue to navigate to Reporter information screen
    And I key in my personal information
    And I indicate i need victim support
    Then I should be able to see details of the owner of second damaged Item prepopulated
    And I should be able to add details of the owner of second damaged Item and enter a future date to Owner DOB
    And I should be able to see details of the owner of third damaged Item prepopulated
    And I should be able to add address of the organisation of damaged Item Owner
    And I click on Continue to navigate to Summary Page
    Then I should not be allowed to proceed to next page and see the error "<errorMessage>"
    And I should be able to navigate to the summary page when i use a valid Item Owner DOB as age in years
    And I should be able to verify all the keyed in data in the summary screen
    And I should be able to navigate to the next page from summary
    And I select "yes" in the section to choose that I want to do survey
    Then I should be able to view all survey questions and select opinion as appropriate
    And I should be able to submit the application successfully
    And I should be able to see a summary email with correct data
    And I should receive an email from NZ Police with the summary of the report
    Examples:
      | errorMessage                         |
      | AgeOrBirth: Future Date is not valid |


  #SDTDT-1449
  @post-go-live-11
  Scenario Outline: Validate if the owner date birth field does not allow more than 125 years
    Given I am on the Event Info Page after selecting the events "damaged" to report
    When I enter the date and time of the event
    And I key in the details of event location
    And I key in details of the offender
    And I select "No" for Damaged vehicles
    And I have indicated "I do" is the owner of damaged item and keyed in owner's name
    And I have entered required details of damaged item
    And I add another damaged Item
    And I have indicated "Somebody else does" is the owner of damaged item and keyed in owner's name
    And I have entered required details of damaged item
    And I add another damaged Item
    And I have indicated "An organisation does" is the owner of damaged item and keyed in owner's name
    And I have entered required details of damaged item
    And I key in more information about what happened
    And I click on Continue to navigate to Reporter information screen
    And I key in my personal information
    And I indicate i need victim support
    Then I should be able to see details of the owner of second damaged Item prepopulated
    And I should be able to add details of the owner of second damaged Item and enter age greater than 125
    And I should be able to see details of the owner of third damaged Item prepopulated
    And I should be able to add address of the organisation of damaged Item Owner
    And I click on Continue to navigate to Summary Page
    Then I should not be allowed to proceed to next page and see the error "<errorMessage>"
    And I should be able to navigate to the summary page when i use a valid Item Owner DOB as age in years
    And I should be able to verify all the keyed in data in the summary screen
    And I should be able to navigate to the next page from summary
    And I select "yes" in the section to choose that I want to do survey
    Then I should be able to view all survey questions and select opinion as appropriate
    And I should be able to submit the application successfully
    And I should be able to see a summary email with correct data
    And I should receive an email from NZ Police with the summary of the report
    Examples:
      | errorMessage                                |
      | AgeOrBirth: Age must be less than 125 years |


  @post-go-live-11
  Scenario: Stop duplicate files uploaded
    Given I am on the Event Info Page after selecting the events "hurt|damaged|stolen" to report
    And I have a document to attach
    When I select two files with the same file name and extension
    Then I will see an error message that indicates the files attached are duplicates


  @post-go-live-22
  #SDTDT-1515
  Scenario: Attaching more than 10 files in a case
    Given I am on the Event Info Page after selecting the events "hurt|damaged|stolen" to report
    And I have a document to attach
    When I select to upload more than 10 files
    Then I will see an error message that indicates more than permitted number of files are uploaded

  @unit @upgrade @post-go-live-22
  Scenario: Attaching more than three files in a case
    Given I am on the Event Info Page after selecting the events "hurt" to report
    And I have a document to attach
    When I select to upload more than 3 files
    Then I will see an error message that indicates more than permitted number of files are uploaded


  @post-go-live-2
  #SDTDT-1528
  Scenario: Verify country dropdown menu for Reporter address is aligned with NIA
    Given I am on the Event Info Page after selecting the events "damaged" to report
    When I enter the date and time of the event
    And I key in the details of event location with manually keyed in address
    And I key in details of the offender
    And I select "No" for Damaged vehicles
    And I have indicated "I do" is the owner of damaged item and keyed in owner's name
    And I have entered required details of damaged item
    And I key in more information about what happened
    And I attach any relevant attachment of the incident
    And I click on Continue to navigate to Reporter information screen
    And I key in my personal information with manually keyed in international address
    And I indicate i need victim support
    And I click on Continue to navigate to Summary Page
    And I should be able to verify all the keyed in data in the summary screen
    And I should be able to navigate to the next page from summary
    And I select "yes" in the section to choose that I want to do survey
    Then I should be able to view all survey questions and select opinion as appropriate
    And I should be able to submit the application successfully
    And I should be able to see a summary email with correct data
    And I should receive an email from NZ Police with the summary of the report


  @todo
  #SDTDT-1528
  Scenario: Verify country dropdown menu for Somebody else owner address is aligned with NIA
    Given I am on the Event Info Page after selecting the events "damaged" to report
    When I enter the date and time of the event
    And I key in the details of event location with manually keyed in address
    And I key in details of the offender
    And I select "No" for Damaged vehicles
    And I have indicated "I do" is the owner of damaged item and keyed in owner's name
    And I have entered required details of damaged item
    And I add another damaged Item
    And I have indicated "Somebody else does" is the owner of damaged item and keyed in owner's name
    And I have entered required details of damaged item
    And I key in more information about what happened
    And I attach any relevant attachment of the incident
    And I click on Continue to navigate to Reporter information screen
    And I key in my personal information with manually keyed in international address
    And I indicate i need victim support
    Then I should be able to see details of the owner of second damaged Item prepopulated and key in manually entered International address
    And I should be able to add details of the owner of second damaged Item
    And I click on Continue to navigate to Summary Page
    And I should be able to verify all the keyed in data in the summary screen
    And I should be able to navigate to the next page from summary
    And I select "yes" in the section to choose that I want to do survey
    Then I should be able to view all survey questions and select opinion as appropriate
    And I should be able to submit the application successfully
    And I should be able to see a summary email with correct data
    And I should receive an email from NZ Police with the summary of the report

  @todo
  #SDTDT-1528
  Scenario: Verify country dropdown menu for Organisation owner address is aligned with NIA
    Given I am on the Event Info Page after selecting the events "damaged" to report
    When I enter the date and time of the event
    And I key in the details of event location with manually keyed in address
    And I key in details of the offender
    And I select "No" for Damaged vehicles
    And I have indicated "I do" is the owner of damaged item and keyed in owner's name
    And I have entered required details of damaged item
    And I add another damaged Item
    And I have indicated "Somebody else does" is the owner of damaged item and keyed in owner's name
    And I have entered required details of damaged item
    And I key in more information about what happened
    And I attach any relevant attachment of the incident
    And I click on Continue to navigate to Reporter information screen
    And I key in my personal information with manually keyed in international address
    And I indicate i need victim support
    Then I should be able to see details of the owner of second damaged Item prepopulated and key in manually entered International address
    And I should be able to add details of the owner of second damaged Item
    And I click on Continue to navigate to Summary Page
    And I should be able to verify all the keyed in data in the summary screen
    And I should be able to navigate to the next page from summary
    And I select "yes" in the section to choose that I want to do survey
    Then I should be able to view all survey questions and select opinion as appropriate
    And I should be able to submit the application successfully
    And I should be able to see a summary email with correct data
    And I should receive an email from NZ Police with the summary of the report


  @post-go-live-22
  #SDTDT-1377
  Scenario: Verify phone country dropdown menu for Reporter address
    Given I am on the Event Info Page after selecting the events "damaged" to report
    When I enter the date and time of the event
    And I key in the details of event location with manually keyed in address
    And I key in details of the offender
    And I select "No" for Damaged vehicles
    And I have indicated "I do" is the owner of damaged item and keyed in owner's name
    And I have entered required details of damaged item
    And I key in more information about what happened
    And I attach any relevant attachment of the incident
    And I click on Continue to navigate to Reporter information screen
    And I key in my personal information
    And I indicate i need victim support
    And I click on Continue to navigate to Summary Page
    And I should be able to verify all the keyed in data in the summary screen
    And I should be able to navigate to the next page from summary
    And I select "yes" in the section to choose that I want to do survey
    Then I should be able to view all survey questions and select opinion as appropriate
    And I should be able to submit the application successfully
    And I should be able to see a summary email with correct data
    And I should receive an email from NZ Police with the summary of the report

  @post-go-live-22 @not-automated
  Scenario: correct spelling mistake in confirmation email to public user
    Given I have submitted a report for "<event>" types
    Then I should see an acknowledge email as an user
    And the last line of the email should read This is an automatically generated email. Please do not reply

  @post-go-live-22
  Scenario: Accept special characters in Person's name

  @post-go-live-22
  Scenario: Accept special characters in Organisation name

  @post-go-live-22
  #SDTDT-951
  Scenario: Always display read-only report review before submitting

  @post-go-live-22
  #SDTDT-1420
  Scenario Outline: Change in label for event location public place
    Given I am on the Event Info Page after selecting the events "damaged" to report
    When I select the Event "A public place" from a dropdown in the Where did it happen section
    Then I should see the "<label>" in Additional information field
    Examples:
      | label                                                              |
      | Please provide any additional information about where it happened. |


  Scenario: Re-labelled fields in PDF
    Given I have uploaded <filename> as an attachment to the report
    And I have included <description>
    When I request a PDF download
    Then I expect <filename> and <description> to be included under the correct labels in the PDF

  Scenario: Re-labelled fields in Digital Services email
    Given I have uploaded <filename> as an attachment to the report
    And I have included <description>
    When the report is submitted
    Then I expect <filename> and <description> to be included under the correct labels in the Digital Services email

  Scenario: Additional information section
    Given I am on the “Additional information” section of the Online Form
    When I select the “ATTACH” button (as shown above)
    Then the “Additional information” section will be re-labelled as shown:

  Scenario: Attach file dialog box
    Given I am on the “Additional information” section of the Online Form
    When I select the “Upload images” box to start the upload procedure
    Then an “Attach file” dialog box will be rendered
    And the fields will be re-labelled as shown:


  #Scenario: Allow special characters in Item Identifier
  #  Given an <event> has occurred
  #  When I am in <section> of the Online Form
  #  And I enter an “Item ID” with at least one <special-char>
  #  Then the form will accept the “Item ID”
  #  Examples:
  #    | event            | section          | special-char |
  #    | lost property    | What was lost?   | “/”          |
  #    | lost property    | What was lost?   | “-”          |
  #    | something stolen | What was stolen? | “/”          |
  #    | something stolen | What was stolen? | “-”          |


  #Scenario: Person name using English alphabet characters
  #  Given I a <person-name-type>
  #  When I enter <name> in “First Name” “Middle Name” “Last Name” fields in <section> using the English alphabet
  #  Then the name is accepted
  #  Examples:
  #    | person-name-type | section                        | name         |
  #    | reporter         | “Please provide your details”  | John Smith   |
  #    | item owner       | “Please provide Jack's details | Jack C Black |

  #  When I enter <name> in “First Name” “Middle Name” “Last Name” fields in <section> NOT using the English alphabet
  #  Then the name is NOT accepted
  #  And I get an error message “Use characters based on the English alphabet”
  #  Examples:
  #    | person-name-type | section                         | name                    |
  #    | reporter         | “Please provide your details”   | 東海林賢蔵                   |
  #    | item owner       | “Please provide Борис's details | Борис Николаевич Ельцин |


  #Scenario: Person name using English alphabet characters with a diacritic
   # Given I a <person-name-type>
   # When I enter <name> in “First Name” “Middle Name” “Last Name” fields in <section> using the English alphabet with a diacritic
   # Then the name is accepted
   # Examples:
   #   | person-name-type | section                        | name                 |
   #   | reporter         | “Please provide your details”  | Björk Guðmundsdóttir |
   #   | item owner       | “Please provide José's details | José Eduardo Santos  |
   #   | reporter         | “Please provide your details”  | Nguyễn Tấn Dũng      |


  #Scenario: Person name using a hyphen, apostrophe or white space
   # Given I a <person-name-type>
   # When I enter <name> in “First Name” “Middle Name” “Last Name” fields in <section> using the English alphabet with a <special character>
   # Then the name is accepted
   # Examples:
   #  | reporter         | “Please provide your details”     | Thomas O’Leary        | apostrophe        |
   #  | reporter         | “Please provide your details”     | Dick van Djik         | white space       | ( as “van Djik” is the Last Name )
   #   | item owner       | “Please provide Camilla's details | Camilla Parker-Bowles | hyphen            |

  #Scenario: Person name using a hyphen, apostrophe or white space
  #GIVEN topic Something else is selected
  #WHEN the online form is submitted
  #THEN generate the Digital Services email
  #AND set Email Priority on the email subject line to 'Priority 1'