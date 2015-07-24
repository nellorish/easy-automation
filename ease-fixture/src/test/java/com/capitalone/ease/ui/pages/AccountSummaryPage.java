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
	

	
}
