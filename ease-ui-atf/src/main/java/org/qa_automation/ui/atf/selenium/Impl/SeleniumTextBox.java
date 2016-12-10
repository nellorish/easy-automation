/**
 * 
 */
package org.qa_automation.ui.atf.selenium.Impl;

import org.qa_automation.ui.atf.driver.ExtUiDriver;
import org.qa_automation.ui.atf.error.FixtureError;
import org.qa_automation.ui.atf.selenium.TextElement;

/**
 * @author gtg716
 *
 * 
 */
public class SeleniumTextBox extends SeleniumTextReader implements TextElement {

	
	public SeleniumTextBox(ExtUiDriver driver){
	    super(driver);
	}
	public SeleniumTextBox(ExtUiDriver driver,String selector) {
		super(driver);
		setSelector(selector);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void setText(String txt) throws FixtureError {
	   clear();
	   getSelectorObject().sendKeys(txt);	
	}
	
	@Override
	public String getText() throws FixtureError {
		
		return getSelectorObject().getAttribute("value");
	}
	
	
}
