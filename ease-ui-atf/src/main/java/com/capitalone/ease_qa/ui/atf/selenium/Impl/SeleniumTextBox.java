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
public class SeleniumTextBox extends SeleniumWebElement implements TextElement {

	
	public SeleniumTextBox(ExtUiDriver driver){
	    super(driver);
	}
	public SeleniumTextBox(ExtUiDriver driver,String selector) {
		super(driver);
		setSelector(selector);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<String> getTextList() throws FixtureError {
	
		return null;
	}

	@Override
	public TextElement get() throws FixtureError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TextElement> getList() throws FixtureError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionElement asLink() throws FixtureError {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setText(String txt) throws FixtureError {
		getSelectorObject().sendKeys(txt);
		
	}
	@Override
	public boolean containsText(String txt) throws FixtureError {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String getFormattedText() throws FixtureError {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	}
