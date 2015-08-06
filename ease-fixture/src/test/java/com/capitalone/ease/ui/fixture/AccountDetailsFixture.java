package com.capitalone.ease.ui.fixture;

import java.util.List;

import com.capitalone.ease.ui.pages.AccountDetailsPage;
import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.error.FixtureError;
import com.capitalone.ease_qa.ui.atf.selenium.ActionElement;
import com.capitalone.ease_qa.ui.atf.selenium.TextElement;

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
		getAccountDetailsPage().getViewDetailsHyperLink().click();
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
		return element.isElementExists();
	}
	
	//** View Details Modal Actions Go here 
	
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

}
