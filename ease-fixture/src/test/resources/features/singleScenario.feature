
Feature: Single End to End Flow
@single
Scenario: Validate the Account details page Hero section for Checking, Savings, KSA and Money accounts
    Given browser to use is "android"
    Given I'm logged in to Ease on domain "QA" with user "QA0_Chk458202779" and password "abcd12345"
    And click on the Bank Account tile "checking"
    Then I should be navigated to the Account details page
    And should be able to see account name, account balance title, transfer button and view details link
    Then click on view details link
    When view details modal windows is visible
    Then verify "36000128837"and "031176110"and "BRENDA KKNZKLY" and "3.00%"and"$0.00"
    Then close view details
    Then I should be navigated to the Account details page
    And go back to account summary page
    When I`m on account summary page
    Then signout
    Then I should be on login page