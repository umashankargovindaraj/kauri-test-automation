Feature: Login to app

  @first
  Scenario: login to application
    Given user launch the application
    When user enter credentials
    Then the Before School home page should be displayed

