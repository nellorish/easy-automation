package com.capitalone.ease.ui.pages;

import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.selenium.ActionElement;
import com.capitalone.ease_qa.ui.atf.selenium.TextElement;

public class AccountDetailsPage {
	
	private ExtUiDriver m_driver;
	
	public AccountDetailsPage(ExtUiDriver driver){
	   m_driver=driver;	
	}

	
	public ActionElement getViewDetailsHyperLink(){
		return m_driver.getElementFactory().createHyperLink("viewDetailLink");
	}
	
	public TextElement getAccountDetailsAreaOnHero(){
		return m_driver.getElementFactory().createTextReader("class=title");
	}
	
	public TextElement getAccountNumberOnHero(){
		return m_driver.getElementFactory().createTextReader("class:account-additional");
	}
	
	public TextElement getBalanceAmountOnHero(){
		return m_driver.getElementFactory().createTextReader("class:dollar");
	}
	public TextElement getDollarSymbolforAvailableBal(){
		return m_driver.getElementFactory().createTextReader("class:symbol");
	}
	
	public ActionElement getTranferButtonOnHero(){
		return m_driver.getElementFactory().createButton("transferMoney");
	}
	
	public TextElement getTransactionsList(){
		return m_driver.getElementFactory().createTextElement("xpath://ul[class='transactionList']/li");
	}
}
