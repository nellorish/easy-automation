package com.capitalone.ease.ui.pages;

import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.selenium.ActionElement;

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
		return m_driver.getElementFactory().createButton("xpath://*[@id='headerEaseC1']/div/ul/li/ul/li[2]/a");
	}
	
	public ActionElement getSignOutLink(){
		//return m_driver.getElementFactory().createHyperLink("xpath://*[@id='name_drop']/li[5]/a");
		return m_driver.getElementFactory().createHyperLink("xpath://a[@href='#/login']");
	}
}
