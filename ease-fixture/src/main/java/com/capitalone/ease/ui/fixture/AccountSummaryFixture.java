package com.capitalone.ease.ui.fixture;

import com.capitalone.ease.ui.pages.AccountSummaryPage;
import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.error.ElementTimeoutError;
import com.capitalone.ease_qa.ui.atf.error.FixtureError;
import com.capitalone.ease_qa.ui.atf.selenium.ActionElement;
import com.capitalone.ease_qa.ui.atf.selenium.WaitforConditionTimer;

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
		
//		m_driver.waitUntil(new WaitforConditionTimer() {
//			
//			@Override
//			public boolean ensure() {
//				try {
//					getAccountSummaryPage().getCheckingAccountTitle().click();
//					if(!getAccountSummaryPage().getCheckingAccountTitle().isElementVisible()){
//						return true;
//					}
//						
//					// TODO Auto-generated method stub
//					return false;
//				} catch (FixtureError e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				return false;
//			}
//		});
		
		
	}
	
	public void goToSavingAccount() throws FixtureError{
		getAccountSummaryPage().getSavingAccountTitle().click();
	}
	
	
	public boolean isAccountSummaryPage() throws ElementTimeoutError {
		
		m_driver.waitUntil(new WaitforConditionTimer() {
			ActionElement element = getAccountSummaryPage().getCheckingAccountTitle();
			@Override
			public boolean ensure() {
				try {
				     if(element.isElementVisible()){
						return true;
					}
				} catch (FixtureError e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			//return getAccountSummaryPage().getAccountSummaryPageTitle().equalsIgnoreCase("EASE | Account Summary");
				return false;
				
			}
		    });
		
		return true;
	}
	
	public void ClickOnProfileInformation() throws FixtureError{
		getAccountSummaryPage().getHeaderDropDown().click();
	}
	
	public void signOutfromAccountDetails() throws FixtureError, InterruptedException{
		ClickOnProfileInformation();
		//ActionElement element = getAccountSummaryPage().getSignOutLink();
		m_driver.pauseFor(1);
	    m_driver.waitUntil(new WaitforConditionTimer() {
			
			@Override
			public boolean ensure() {
				ActionElement element = getAccountSummaryPage().getSignOutLink();
				try {
					if(element.isElementExists()&& element.getText().contains("Sign Out")){
                         element.click();
						  return true;
					}
				} catch (FixtureError e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			}
			
		});	
	
	}

//	/**
//	 * Lets you Click on the Position Number of the Title instead of the Product Name , Since IDS and
//	 * Class name can`t be used.
//	 * 
//	 * Ex:     
//	 * 
//	 *    [Position 1]  [Position 2]
//	 *    [Position 3]  [Position 4]         
//	 * 
//	 * @param titleno
//	 * @throws FixtureError
//	 */
//	public void clickOnPositionNumberofTilte(String titleno) throws FixtureError{
//		 getAccountSummaryPage().getBankTileOnNumber(titleno);
//	}
	
	
}
