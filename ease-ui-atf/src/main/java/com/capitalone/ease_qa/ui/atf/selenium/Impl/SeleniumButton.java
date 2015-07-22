/**
 * 
 */
package com.capitalone.ease_qa.ui.atf.selenium.Impl;

import org.openqa.selenium.Keys;

//import com.capitalone.ease.ui.testframework.selenium.SelectableElement;
import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.error.FixtureError;
import com.capitalone.ease_qa.ui.atf.selenium.ActionElement;

/**
 * @author mnellore
 *
 * 
 */
public class SeleniumButton extends SeleniumWebElement implements ActionElement {
      
	public SeleniumButton(ExtUiDriver driver,String selector){
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
