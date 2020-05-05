Feature: End to End Scenarios for B4 School Application

  @first
#  Scenario: E2E Testcase1_Add new child and complete B4SC checks - All checks complete and no referrals
#    Given user is logged in as "UmaProvider"
#    Then the Before School home page should be displayed
#    When user search all DHB for non existing NHI number and click searchAllDHB button
#    When User select the new child button
#    And user enter mandatory child information and save
#    And click Management tab
#    And search with the NHI Number obtained
#    And user search all DHB for search results
#    And click assign provider link
#    And click surName link
#    And click caregiver link in child information page
#    When enter caregiver details and click save button
#   Then the caregiver entry should be available in the child information page
#    And click B4SCHOOL tab
#    And provide Consent details
#    And fill Child Health Questionnaire and save then confirm status is completed in B4 School Checks Overview Page
#    And fill Dental details and save then confirm status is completed in B4 School Checks Overview Page
#    And fill Growth details and save then confirm status is completed in B4 School Checks Overview Page
#    And fill Immunisation details and save then confirm status is completed in B4 School Checks Overview Page
#    And fill PEDS details and save then confirm status is completed in B4 School Checks Overview Page
#    And fill SDQ Parent details and save then confirm status is completed in B4 School Checks Overview Page
#    And fill SDQ Teacher details and save then confirm status is completed in B4 School Checks Overview Page
#    And fill Vision and Hearing Checks details and save then confirm status is completed in B4 School Checks Overview Page
#    And fill Hearing details and save then confirm status is completed in B4 School Checks Overview Page
#    And fill Distance Vision details and save then confirm status is completed in B4 School Checks Overview Page
#    Then close Childs Before School Check Record from Before School Application

#      Examples:
#      | userType  |
#      | UmaProvider  |
#      | Midcentral DHB |
#      | Auckland DHB |

#****************************************************************************************************************************************
#  Scenario: E2E Testcase2_Search existing child in your Org who requires parent consent and complete B4SC checks - All checks complete and some referrals outstanding
#    Given user is logged in as "UmaProvider"
##    Then the Before School home page should be displayed
##    When user search all DHB for non existing NHI number and click searchAllDHB button
##    When User select the new child button
##    And user enter mandatory child information and save
#    And click Management tab
#    And search with the NHI Number obtained
#    And user search all DHB for search results
##    And click assign provider link
#    And click surName link
##    And click caregiver link in child information page
##    When enter caregiver details and click save button
##   Then the caregiver entry should be available in the child information page
#    And click B4SCHOOL tab
##    And provide Consent details
##    And fill Child Health Questionnaire and save then confirm status is completed in B4 School Checks Overview Page
##    And fill Dental details and save then confirm status is completed in B4 School Checks Overview Page
#    And fill the Child Check Referrals to In progress status and save then verify referral status showing as In Progress
##    And fill Growth details and save then confirm status is completed in B4 School Checks Overview Page
##    And fill Immunisation details and save then confirm status is completed in B4 School Checks Overview Page
##    And fill PEDS details and save then confirm status is completed in B4 School Checks Overview Page
##    And fill SDQ Parent details and save then confirm status is completed in B4 School Checks Overview Page
##    And fill SDQ Teacher details and save then confirm status is completed in B4 School Checks Overview Page
##    And fill Vision and Hearing Checks details and save then confirm status is completed in B4 School Checks Overview Page
##    And fill Hearing details and save then confirm status is completed in B4 School Checks Overview Page
##    And fill Distance Vision details and save then confirm status is completed in B4 School Checks Overview Page
#    Then confirm that child record will not be closed since Dental Check referral is still in progress

#**********************************************************************************************************************************
#  Scenario: E2E Testcase3: Search existing child who has parent consent and complete B4SC checks - All checks not complete and some referrals outstanding
#    Given user is logged in as "UmaProvider"
#    Then the Before School home page should be displayed
#    When user search all DHB for non existing NHI number and click searchAllDHB button
#    When User select the new child button
#    And user enter mandatory child information and save
#    And click Management tab
#    And search with the NHI Number obtained
#    And user search all DHB for search results
#    And click assign provider link
#    And click surName link
#    And click caregiver link in child information page
#    When enter caregiver details and click save button
#   Then the caregiver entry should be available in the child information page
#    And click B4SCHOOL tab
#    And provide Consent details
#    And fill Child Health Questionnaire and save then confirm status is completed in B4 School Checks Overview Page
#    And fill Dental details and save then confirm status is In Progress in B4 School Checks Overview Page
#    And fill the dental Check Referrals to In progress status and save then verify referral status showing as In Progress
#    And fill Growth details and save then confirm status is completed in B4 School Checks Overview Page
#    And fill Immunisation details and save then confirm status is In Progress in B4 School Checks Overview Page
#    And fill PEDS details and save then confirm status is completed in B4 School Checks Overview Page
#    And fill SDQ Parent details and save then confirm status is In Progress in B4 School Checks Overview Page
#    And fill SDQ Teacher details and save then confirm status is completed in B4 School Checks Overview Page
#    And fill Vision and Hearing Checks details and save then confirm status is completed in B4 School Checks Overview Page
#    And fill Hearing details and save then confirm status is completed in B4 School Checks Overview Page
#    And fill Distance Vision details and save then confirm status is In Progress in B4 School Checks Overview Page
#    And fill the Vision Check Referrals to In progress status and save then verify referral status showing as In Progress
#    Then confirm that child record will not be closed since Dental Check referral is still in progress

#**********************************************************************************************************************************

#  Scenario: E2E Testcase4: Search existing child in your organisation and return child to Co-ordinator
#    Given user is logged in as "UmaProvider"
#    Then the Before School home page should be displayed
#    When user search all DHB for non existing NHI number and click searchAllDHB button
#    When User select the new child button
#    And user enter mandatory child information and save
#    And click Management tab
#    And search with the NHI Number obtained
#    And user search all DHB for search results
#    And click assign provider link
#    And click surName link
#    And click Allocation History link in Child Information page and fill Return Child to Coordinator fields
#    And logout from current user
#    Then login back as coordinator with organisation "Auckland DHB"
#    And search with the NHI Number obtained
#    Then user click search button and confirm the child record is returned to coordinator successfully

#**********************************************************************************************************************************
     #  Scenario: E2E Testcase5: Search existing child in your Org who requires parent consent and Parent consent not given
#    Given user is logged in as "UmaProvider"
#    Then the Before School home page should be displayed
#    When user search all DHB for non existing NHI number and click searchAllDHB button
#    When User select the new child button
#    And user enter mandatory child information and save
#    And click Management tab
#    And search with the NHI Number obtained
#    And user search all DHB for search results
#    And click assign provider link
#    And click surName link
#    And click caregiver link in child information page
#    When enter caregiver details and click save button
#    Then the caregiver entry should be available in the child information page
#    And click B4SCHOOL tab
#    And choose NO to Consent Given field
#    Then close the child record as No consent given and no health checks can be added

#**********************************************************************************************************************************

#  Scenario: E2E Testcase6_Search existing child who has parent consent and complete B4SC checks - Close outstanding referrals and then Close Check
#    Given user is logged in as "UmaProvider"
#    Then the Before School home page should be displayed
#    When user search all DHB for non existing NHI number and click searchAllDHB button
#    When User select the new child button
#    And user enter mandatory child information and save
#    And click Management tab
#    And search with the NHI Number obtained
#    And user search all DHB for search results
#    And click assign provider link
#    And click surName link
#    And click caregiver link in child information page
#    When enter caregiver details and click save button
#   Then the caregiver entry should be available in the child information page
#    And click B4SCHOOL tab
#    And provide Consent details
#    And fill Child Health Questionnaire and save then confirm status is completed in B4 School Checks Overview Page
#    And fill Dental details and save then confirm status is completed in B4 School Checks Overview Page
#    And fill the dental Check Referrals to In progress status and save then verify referral status showing as In Progress
#    And fill Growth details and save then confirm status is completed in B4 School Checks Overview Page
#    And fill Immunisation details and save then confirm status is completed in B4 School Checks Overview Page
#    And fill PEDS details and save then confirm status is completed in B4 School Checks Overview Page
#    And fill SDQ Parent details and save then confirm status is completed in B4 School Checks Overview Page
#    And fill SDQ Teacher details and save then confirm status is completed in B4 School Checks Overview Page
#    And fill Vision and Hearing Checks details and save then confirm status is completed in B4 School Checks Overview Page
#    And fill Hearing details and save then confirm status is completed in B4 School Checks Overview Page
#    And fill Distance Vision details and save then confirm status is completed in B4 School Checks Overview Page
#    And now go back to dental Check Referral and change the status from In Progress to Completed
#    And click B4SCHOOL tab
#    Then close Childs Before School Check Record from Before School Application

  #**********************************************************************************************************************************
