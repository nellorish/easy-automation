package org.qa_automation.ui.pages;

import org.qa_automation.ui.atf.driver.ExtUiDriver;
import org.qa_automation.ui.atf.selenium.ActionElement;

public class AccountSummaryPage {
	
	private ExtUiDriver m_driver;
	
	public AccountSummaryPage(ExtUiDriver driver){
		m_driver=driver;
	}

	public ActionElement getCheckingAccountTitle(){
		
	return m_driver.getElementFactory().createButton("class:_lob_DDA360");
	
	
	}
	
	public ActionElement getSavingAccountTitle(){
		
		return m_driver.getElementFactory().createButton("class:_lob_SA360");
	}
	
	public ActionElement getBankTileOnNumber(String titleNumber){
		
		return m_driver.getElementFactory().createButton("class:_lob_DDA360");
	}
	
	public String getAccountSummaryPageTitle(){
		
		return m_driver.getElementFactory().createWebPage().browserCaption();
	}
	
	public ActionElement getHeaderDropDown(){
		return m_driver.getElementFactory().createButton("xpath://a[@id='profileLink']");
	}
	
	public ActionElement getSignOutLink(){
		//return m_driver.getElementFactory().createHyperLink("xpath://*[@id='name_drop']/li[5]/a");
		return m_driver.getElementFactory().createHyperLink("xpath://a[@href='#/login']");
	}
}
