package com.capitalone.ease.ui.pages;

import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.selenium.ActionElement;

public class AccountSummaryPage {
	
	private ExtUiDriver m_driver;
	
	public AccountSummaryPage(ExtUiDriver driver){
		m_driver=driver;
	}

	public ActionElement getCheckingAccountTitle(){
		
	return m_driver.getElementFactory().createButton("class:atddAccountType");
	}
	
	public ActionElement getSavingAccountTitle(){
		
		return m_driver.getElementFactory().createButton("");
	}
	
	public ActionElement getBankTileOnNumber(String titleNumber){
		
		return m_driver.getElementFactory().createButton("xpath://ul[@id='summaryParent']/li["+titleNumber+"]");
	}
}
