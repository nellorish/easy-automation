/**
 * 
 */
package com.capitalone.ease_qa.ui.atf.selenium.Impl;

import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.error.FixtureError;
import com.capitalone.ease_qa.ui.atf.selenium.TextElement;

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
	
	   getSelectorObject().sendKeys(txt);	
	}
	
}
