package com.capitalone.ease_qa.ui.atf.selenium.Impl;

import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.error.FixtureError;
import com.capitalone.ease_qa.ui.atf.selenium.ActionElement;

public class SeleniumHyperLink extends SeleniumWebElement implements
		ActionElement {

	public SeleniumHyperLink(ExtUiDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pressEnter() throws FixtureError {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getFormattedText() throws FixtureError {
		// TODO Auto-generated method stub
		return getText().replace("\n", " ");
	}
	
	@Override
	public String getText() throws FixtureError{
		
		return getSelectorObject().getText();
	}
}

