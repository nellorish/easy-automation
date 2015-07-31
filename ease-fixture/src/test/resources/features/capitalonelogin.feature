
@demo
Feature: Sample Login for the UI Driver Demo
Scenario: Just Login
    Given I`m on the easy login page
    When Enter the Username "" and password ""
    And Click login
    Then I should be on account summary page
    Then click on Checking account tile 