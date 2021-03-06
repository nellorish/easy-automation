package org.qa_automation.ui.pages;

import org.qa_automation.ui.atf.driver.ExtUiDriver;
import org.qa_automation.ui.atf.selenium.TextElement;
import org.qa_automation.ui.atf.selenium.ActionElement;

public class AccountDetailsPage {
	
	private ExtUiDriver m_driver;
	
	public AccountDetailsPage(ExtUiDriver driver){
	   m_driver=driver;	
	}

    public ActionElement getViewDetailsHyperLink(){
		//return m_driver.getElementFactory().createHyperLink("viewDetailLink"); //a[@id='viewDetailLink']
		return m_driver.getElementFactory().createHyperLink("xpath://a[@id='viewDetailLink']");
	}
	
	public TextElement getAccountDetailsAreaOnHero(){
		return m_driver.getElementFactory().createTextReader("xpath://li[@class='title']");
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
		return m_driver.getElementFactory().createTextElement("xpath://ul[@class='transactionList']/li");
	}
	
	public ActionElement getCaroselRightButton(){
		//return m_driver.getElementFactory().createActionElement("xpath://button[@alt:'Next account']"); //*[@id="mainAccountDetail"]/div[4]/button
		return m_driver.getElementFactory().createActionElement("xpath://*[@id='mainAccountDetail']/div[4]/button");	
	}
	
	public TextElement getTypeofAccount(){
		return m_driver.getElementFactory().createTextReader("class:title");
	}
	
	public ActionElement getBackButtonOnAccountDetails(){
		return m_driver.getElementFactory().createButton("xpath://*[@id='headerEaseC1']/div/div/div[1]/button");
		//return m_driver.getElementFactory().createButton("xpath://button[@class='back-to-summary']");
	}
	
	
	
	
	
	//  Details for the View Details Modal Page Element Start Here
	
	public TextElement getAccountNumberOnViewDetailsModal(){
		return m_driver.getElementFactory().createTextReader("accountNumber");
	}
	
//	public TextElement getAccountNickNameOnViewDetails(){
//		return m_driver.getElementFactory().createTextReader("NickName");
//	}
	public TextElement getAccountRoutingNumberOnViewDetials(){
		return m_driver.getElementFactory().createTextReader("routingNumber");
	}
	
	public TextElement getAccountBalanceOnViewDetials(){
		return m_driver.getElementFactory().createTextReader("class:balance-amount");
	}
	
	public TextElement getPrimaryAccountHolderNameOnViewDetials(){
		return m_driver.getElementFactory().createTextReader("primaryAccountHolder");
	}
	
	public TextElement getCurrentInterestOnViewDetails(){
		return m_driver.getElementFactory().createTextReader("interestPaidAmountCurrentMonth");
	}
	
	public TextElement getCurrentYearInterestOnViewDetails(){
		return m_driver.getElementFactory().createTextReader("interestCurrentYear");
	}
	
	public TextElement getCurrentAPYOnViewDetails(){
		return m_driver.getElementFactory().createTextReader("annualPercentageYield");
	}
    
	public ActionElement getCloseButtonOnViewDetails(){
		//return m_driver.getElementFactory().createButton("class:close-dialog"); //button[@class='close-dialog']
		//return m_driver.getElementFactory().createButton("xpath://button[@class='close-dialog']"); //*[@id="transactions"]/div[2]/div/div[2]/button
		return m_driver.getElementFactory().createButton("xpath://button[@class='close-dialog']");
	}

}
