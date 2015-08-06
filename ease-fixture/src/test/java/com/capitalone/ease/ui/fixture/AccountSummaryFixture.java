package com.capitalone.ease.ui.fixture;

import com.capitalone.ease.ui.pages.AccountSummaryPage;
import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.error.FixtureError;

public class AccountSummaryFixture {

	
	private ExtUiDriver m_driver;
	private AccountSummaryPage accountsummarypage;
	
	public AccountSummaryFixture(ExtUiDriver driver){
	  m_driver=driver;	
	}
	
	public AccountSummaryPage getAccountSummaryPage(){
		if(accountsummarypage==null){
			accountsummarypage = new AccountSummaryPage(m_driver);
		}
	return accountsummarypage;
	}
	
	public void goToCheckingAccount() throws FixtureError{
		getAccountSummaryPage().getCheckingAccountTitle().click();
	}

	/**
	 * Lets you Click on the Position Number of the Title instead of the Product Name , Since IDS and
	 * Class name can`t be used.
	 * 
	 * Ex:     
	 * 
	 *    [Position 1]  [Position 2]
	 *    [Position 3]  [Position 4]         
	 * 
	 * @param titleno
	 * @throws FixtureError
	 */
	public void clickOnPositionNumberofTilte(String titleno) throws FixtureError{
		 getAccountSummaryPage().getBankTileOnNumber(titleno);
	}
	
	
}
