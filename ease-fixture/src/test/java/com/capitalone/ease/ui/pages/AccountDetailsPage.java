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
	
	
	
	//  Details for the View Details Modal Page Element Start Here
	
	public TextElement getAccountNumberOnViewDetailsModal(){
		return m_driver.getElementFactory().createTextReader("AccountNumber");
	}
	
	public TextElement getAccountNickNameOnViewDetails(){
		return m_driver.getElementFactory().createTextReader("NickName");
	}
	public TextElement getAccountRoutingNumberOnViewDetials(){
		return m_driver.getElementFactory().createTextReader("RoutingNumber");
	}
	
	public TextElement getAccountBalanceOnViewDetials(){
		return m_driver.getElementFactory().createTextReader("class:balance-amount");
	}
	
	public TextElement getPrimaryAccountHolderNameOnViewDetials(){
		return m_driver.getElementFactory().createTextReader("PrimaryAccountHolder");
	}
	
	public TextElement getCurrentInterestOnViewDetails(){
		return m_driver.getElementFactory().createTextReader("InterestCurrentMonth");
	}
	
	public TextElement getCurrentYearInterestOnViewDetails(){
		return m_driver.getElementFactory().createTextReader("InterestCurrentYear");
	}
	
	public TextElement getCurrentAPYOnViewDetails(){
		return m_driver.getElementFactory().createTextReader("CurrentAPY");
	}


}
