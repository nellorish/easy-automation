/**
 * 
 */
package org.qa_automation.ui.atf.selenium.Impl;

import org.qa_automation.ui.atf.driver.ExtUiDriver;
import org.qa_automation.ui.atf.error.FixtureError;
import org.openqa.selenium.Keys;

//import qa_automation.ease.ui.testframework.selenium.SelectableElement;
import org.qa_automation.ui.atf.selenium.ActionElement;

/**
 * @author mnellore
 *
 * 
 */
public class SeleniumButton extends SeleniumWebElement implements ActionElement {
      
	public SeleniumButton(ExtUiDriver driver, String selector){
		super(driver);
		setSelector(selector);
	}
	public SeleniumButton(ExtUiDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void pressEnter() throws FixtureError {
		// TODO Auto-generated method stub
	    getSelectorObject().sendKeys(Keys.ENTER);;	
	}

	public String getText() throws FixtureError {
		// TODO Auto-generated method stub
		return getSelectorObject().getAttribute("value");
	}

	public String getFormattedText() throws FixtureError {
		// TODO Auto-generated method stub
		return getSelectorObject().getText().replace("/n","");
	}
	
	
}
