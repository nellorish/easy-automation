package com.capitalone.ease_qa.ui.atf.selenium.Impl;

import org.openqa.selenium.Keys;

import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.error.FixtureError;
import com.capitalone.ease_qa.ui.atf.selenium.ActionElement;

public class SeleniumActionElement extends SeleniumWebElement implements ActionElement {
	
     
	public SeleniumActionElement(ExtUiDriver driver, String selector){
		super(driver);
		setSelector(selector);
	}

	public SeleniumActionElement(ExtUiDriver m_uiDriver) {
	      super(m_uiDriver);
		//driver = m_uiDriver;
		// TODO Auto-generated constructor stub
	}


	@Override
	public String getText() throws FixtureError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFormattedText() throws FixtureError {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void pressEnter() throws FixtureError {
		// TODO Auto-generated method stub
		getSelectorObject().sendKeys(Keys.ENTER);
	}

}
