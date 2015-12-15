package com.capitalone.ease.ui.fixture;

import java.util.List;

import com.capitalone.ease.ui.pages.AccountDetailsPage;
import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.error.FixtureError;
import com.capitalone.ease_qa.ui.atf.selenium.ActionElement;
import com.capitalone.ease_qa.ui.atf.selenium.TextElement;
import com.capitalone.ease_qa.ui.atf.selenium.WaitforConditionTimer;

public class AccountDetailsFixture {

	private ExtUiDriver driver;
	private AccountDetailsPage accountDetialsPage;
	public AccountDetailsFixture(ExtUiDriver driver){
		this.driver = driver;
	}
	
	public AccountDetailsPage getAccountDetailsPage(){
		if(accountDetialsPage==null){
			accountDetialsPage = new AccountDetailsPage(driver);
		}
	  return accountDetialsPage;
	}
	
	public void clickOnViewDetails() throws FixtureError{
		
	//	getAccountDetailsPage().getViewDetailsHyperLink().click();
		driver.waitUntil(new WaitforConditionTimer() {
			@Override
			public boolean ensure() {
				try {
					ActionElement element = getAccountDetailsPage().getViewDetailsHyperLink();
					
					if(element.isElementVisible()){
						element.click();
						return true;
					}
					//getAccountDetailsPage().getViewDetailsHyperLink().click();
					//System.out.println("View Details is Visible"+isViewDetialsPageVisible());
					//return isViewDetialsPageVisible();
					//return getAccountDetailsPage().getViewDetailsHyperLink().isElementVisible();
				} catch (FixtureError e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// TODO Auto-generated method stub
				return false;
			}
		});
		//getAccountDetailsPage().getViewDetailsHyperLink().click();
		//getAccountDetailsPage().getViewDetailsHyperLink().click();
	}
	
	public String getAccountNumberOnHero() throws FixtureError{
         String accountNumber = getAccountDetailsPage().getAccountNumberOnHero().getText();
		return accountNumber;
	}
	
	public void clickOnTranferMoneyButton() throws FixtureError{
		getAccountDetailsPage().getTranferButtonOnHero().click();
	}
	
	public String availableBalanceOnHero() throws FixtureError{
		return getAccountDetailsPage().getBalanceAmountOnHero().getText();
	}
	public List<TextElement> getListOfTransactions() throws FixtureError{
		return getAccountDetailsPage().getTransactionsList().getList();
	}

	public boolean isAccountDetailsPage() throws FixtureError {
		ActionElement element = getAccountDetailsPage().getViewDetailsHyperLink();
		driver.waitUntil(new WaitforConditionTimer() {
			
			@Override
			public boolean ensure() {
			ActionElement conditionelement = getAccountDetailsPage().getViewDetailsHyperLink();
				// TODO Auto-generated method stub
			  try {
				return conditionelement.isElementExists();
			} catch (FixtureError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
			}
		});
		
		return element.isElementExists();
	}
	
	
	public void gotoOtherAccountFromAccountDetails(String accountType) throws FixtureError{
		
		String accountname = getAccountDetailsPage().getAccountDetailsAreaOnHero().getText();
		int count =0;
		
		while(!accountname.contains(accountType)){
		   getAccountDetailsPage().getCaroselRightButton().click();
		   accountname = getAccountDetailsPage().getAccountDetailsAreaOnHero().getText();
		   count++;
		   if(count>5){
			 break;  
		   }
		}
	}
	
	
	public void clickOnBackButtonOnAccountDetails() throws FixtureError, InterruptedException{
		driver.pauseFor(1);
		driver.waitUntil(new WaitforConditionTimer() {
			
			@Override
			public boolean ensure() {
				ActionElement element = getAccountDetailsPage().getBackButtonOnAccountDetails();
				try {
					if(element.isElementExists()){
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
	
	
	
	//** View Details Modal Actions Go here 
	
	public boolean isViewDetialsPageVisible() throws FixtureError{
		
		driver.waitUntil(new WaitforConditionTimer() {
			@Override
			public boolean ensure() {
				TextElement element = getAccountDetailsPage().getAccountNumberOnViewDetailsModal();
				try {
					if(element.isElementVisible()){
						return true;
					}
				} catch (FixtureError e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// TODO Auto-generated method stub
				return false;
			}
		});
		
		return getAccountDetailsPage().getAccountNumberOnViewDetailsModal().isElementVisible();
	}
	
    public String getAccountNumberOnViewDetailsModal() throws FixtureError{
		return getAccountDetailsPage().getAccountNumberOnViewDetailsModal().getText();
	}
    
    public String getAccountNicknameOnViewDetails() throws FixtureError{
    	return getAccountDetailsPage().getAccountNickNameOnViewDetails().getText();
    }
    
    public String getRoutingNumberOnViewDetailsModal() throws FixtureError{
    	return getAccountDetailsPage().getAccountRoutingNumberOnViewDetials().getText();
    }
    
    public String getPrimaryAccountNameOnViewDetailsPage() throws FixtureError{
    	
    	return getAccountDetailsPage().getPrimaryAccountHolderNameOnViewDetials().getText();
    }
    
    public String getAnnualAPROnViewDetails() throws FixtureError{
    	return getAccountDetailsPage().getCurrentAPYOnViewDetails().getText();
    }
    
    public String getMonthsInterestOnViewDetails() throws FixtureError{
    	return getAccountDetailsPage().getCurrentInterestOnViewDetails().getText();
    }
    
    public String getYearlyInterestOnViewDetails() throws FixtureError{
    	return getAccountDetailsPage().getCurrentYearInterestOnViewDetails().getText();
    }
    
    public String getAccountBalanceOnViewDetails() throws FixtureError{
    	return getAccountDetailsPage().getAccountBalanceOnViewDetials().getText();
    }
    
    public void closeViewDetials() throws FixtureError {
    	
    	driver.waitUntil(new WaitforConditionTimer() {
			
			@Override
			public boolean ensure() {
				try {
					if(getAccountDetailsPage().getCloseButtonOnViewDetails().isElementVisible()){
						getAccountDetailsPage().getCloseButtonOnViewDetails().click();
						return true;
					}
					// TODO Auto-generated method stub
					
				} catch (FixtureError e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			}
		});
    }

}
