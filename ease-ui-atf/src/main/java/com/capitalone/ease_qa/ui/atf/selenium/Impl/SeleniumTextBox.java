/**
 * 
 */
package com.capitalone.ease_qa.ui.atf.selenium.Impl;

import java.util.List;

import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.error.FixtureError;
import com.capitalone.ease_qa.ui.atf.selenium.ActionElement;
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
	
}
