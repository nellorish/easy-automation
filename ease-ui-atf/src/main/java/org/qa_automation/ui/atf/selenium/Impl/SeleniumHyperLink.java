package org.qa_automation.ui.atf.selenium.Impl;

import org.qa_automation.ui.atf.driver.ExtUiDriver;
import org.qa_automation.ui.atf.error.FixtureError;
import org.qa_automation.ui.atf.selenium.ActionElement;


/**
 * 
 * @author gtg716
 *
 */
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

