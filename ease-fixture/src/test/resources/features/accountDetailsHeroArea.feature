 @demo
 
 Feature: Verify Hero Area Attributes on AccountDetials Page
  
  Scenario Outline: Validate the Account details page Hero section for Checking, Savings, KSA and Money accounts
    Given I'm logged in to Ease on domain "QA" with user "<username>" and password "<password>"
    And click on the Bank Account tile "<Account>"
    Then I should be navigated to the Account details page
    And should be able to see account name, account balance title, transfer button and view details link
    Then click on view details link

    Examples: 
      | username         | password  | Account  |
      | ease_checking360 | abcd12345 | checking |
      | ease_savings360  | abcd12345 | savings  |
      | al_user23        | abcd12345 | ksa      |
      | test_tdm9899     | abcd12345 | money    |
