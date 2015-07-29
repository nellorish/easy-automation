package com.capitalone.ease.ui.fixture;

import java.util.List;

import com.capitalone.ease.ui.pages.AccountDetailsPage;
import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.error.FixtureError;
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
}
