@demo
Feature: Regression End to End Flow

  Scenario Outline: Validate the Account details page Hero section for Checking, Savings, KSA and Money accounts
    Given browser to use is "chrome"
    Given I'm logged in to Ease on domain "QA" with user "<username>" and password "<password>"
    And click on the Bank Account tile "<account>"
    Then I should be navigated to the Account details page
    And should be able to see account name, account balance title, transfer button and view details link
    Then click on view details link
    When view details modal windows is visible
    Then verify "<accountNumber>"and "<routingNumber>"and "<primaryAccountHolderName>" and "<APY>"and"<YearInterest>"
    Then close view details
    Then I should be navigated to the Account details page
    And go back to account summary page
    When I`m on account summary page
    Then signout
    Then I should be on login page

    Examples: 
      | username         | password  | account  | accountNumber | routingNumber | primaryAccountHolderName | APY   | YearInterest | accountType |
      | QA0_Chk458202779 | abcd12345 | checking | 36000128837   | 031176110     | BRENDA KKNZKLY           | 5.25% | $12.63        | saving      |
