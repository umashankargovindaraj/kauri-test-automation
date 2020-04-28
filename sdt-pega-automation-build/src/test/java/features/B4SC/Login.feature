Feature: End to End Scenarios for B4 School Application

  @first
  Scenario: login as Provider to application
    Given user is logged in as "UmaProvider"
#    Then the Before School home page should be displayed
#    When user search all DHB for non existing NHI number and click searchAllDHB button
#    When User select the new child button
#    And user enter mandatory child information and save
    And click Management tab
    And search with the NHI Number obtained
    And user search all DHB for search results
#    And click assign provider link
    And click surName link
#    And click caregiver link in child information page
#    When enter caregiver details and click save button
#   Then the caregiver entry should be available in the child information page
    And click B4SCHOOL tab
#    And provide Consent details
#    And fill Child Health Questionnaire and save then confirm status is completed in B4 School Checks Overview Page
#    And fill Dental details and save then confirm status is completed in B4 School Checks Overview Page
#    And fill Growth details and save then confirm status is completed in B4 School Checks Overview Page
#    And fill Immunisation details and save then confirm status is completed in B4 School Checks Overview Page
#    And fill PEDS details and save then confirm status is completed in B4 School Checks Overview Page
#    And fill SDQ Parent details and save then confirm status is completed in B4 School Checks Overview Page
    And fill SDQ Teacher details and save then confirm status is completed in B4 School Checks Overview Page
    And fill Vision and Hearing Checks details and save then confirm status is completed in B4 School Checks Overview Page
    And fill Hearing details and save then confirm status is completed in B4 School Checks Overview Page
    And fill Distance Vision details and save then confirm status is completed in B4 School Checks Overview Page
      Then close Childs B4School Check Record from B4School Application

#      Examples:
#      | userType  |
#      | UmaProvider  |
#      | Midcentral DHB |
#      | Auckland DHB |

#  Scenario Outline: login as Provider to application
#    Given user is logged in as "<userType>"
#    Then the Before School home page should be displayed
#    When user search with firstname and surname
#    Then user search all DHB for search results
#    Then click assign provider link
#
#    Examples:
#      | userType  |
#      | Auckland DHB |