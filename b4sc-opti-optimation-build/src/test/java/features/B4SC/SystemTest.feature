@ST_All
Feature: System Testcases for B4 School Application

  @ST_one
  Scenario: System Testcase1_Edit child information
    Given user is logged in as "provider"
    Then the Before School home page should be displayed
    When user search all DHB for non existing NHI number and click searchAllDHB button
    When User select the new child button
    And user enter mandatory child information and save
    And click Management tab
    And search with the NHI Number obtained
    And user search all DHB for search results
    And click surName link
    And user edit mandatory child information and save
    And click Management tab
    And search with the NHI Number obtained
    And user search all DHB for search results
    Then confirm the previous child information removed from the user record
    And logout from current user

  @ST_two
  Scenario: System Testcase2_Upload child record inside BeforeSchool tab Documents link
    Given user is logged in as "provider"
    Then the Before School home page should be displayed
    When user search all DHB for non existing NHI number and click searchAllDHB button
    When User select the new child button
    And user enter mandatory child information and save
    And click Management tab
    And search with the NHI Number obtained
    And user search all DHB for search results
    And click assign provider link
    And click surName link
    And click B4SCHOOL tab
    And click Documents Page link
    And click upload document link
    And user attach the file by clicking choose file button
    Then click upload button

@ST_three
Scenario: System Testcase3_Export partial child
  Given user is logged in as "provider"
  Then the Before School home page should be displayed
  When user search all DHB for non existing NHI number and click searchAllDHB button
  When User select the new child button
  And user enter mandatory child information and save
  And click Export tab
  Then click Export button to export partial child

  @ST_four
  Scenario: System Testcase4_deceased child
  Given user is logged in as "provider"
  Then the Before School home page should be displayed
  When user search all DHB for non existing NHI number and click searchAllDHB button
  When User select the new child button
  And user enter mandatory child information and save
  And click Management tab
  And search with the NHI Number obtained
  And user search all DHB for search results
  And click surName link
  And enter child date of death and click save button and then confirm the child record is deceased
    And logout from current user


  @ST_five
    Scenario: System Testcase5_provider notes against child record
      Given user is logged in as "provider"
      Then the Before School home page should be displayed
      When user search all DHB for non existing NHI number and click searchAllDHB button
      When User select the new child button
      And user enter mandatory child information and save
      And click Management tab
      And search with the NHI Number obtained
      And user search all DHB for search results
      And click assign provider link
      And click surName link
      And click B4SCHOOL tab
      And click Provider Notes link and provide a standard note and click save button
      And logout from current user


  @ST_six
    Scenario: System Testcase6_Add Event
      Given user is logged in as "provider"
      Then the Before School home page should be displayed
      When user search all DHB for non existing NHI number and click searchAllDHB button
      When User select the new child button
      And user enter mandatory child information and save
      And click Add Event tab
      Then provide values for the fields in add event popup window and click SaveEvent button and assert saved values
      And logout from current user