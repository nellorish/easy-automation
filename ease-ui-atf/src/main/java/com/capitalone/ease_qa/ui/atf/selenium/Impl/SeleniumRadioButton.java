package com.capitalone.ease_qa.ui.atf.selenium.Impl;

import java.util.List;

import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.error.FixtureError;
import com.capitalone.ease_qa.ui.atf.error.UnImplementedException;
import com.capitalone.ease_qa.ui.atf.selenium.Element;
import com.capitalone.ease_qa.ui.atf.selenium.SelectableElement;

public class SeleniumRadioButton extends SeleniumWebElement implements
		SelectableElement {

	public SeleniumRadioButton(ExtUiDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public SeleniumRadioButton(ExtUiDriver driver, String selector) {
		// TODO Auto-generated constructor stub
		super(driver);
		setSelector(selector);
	}

	public Element selectItemByValue(String value) throws FixtureError {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isSelected() throws FixtureError {
		// TODO Auto-generated method stub
		return false;
	}

	public String getText() throws FixtureError {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getTextList() throws FixtureError {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSelectedValue() throws FixtureError {
		throw new UnImplementedException("Implementation Pending ",null);
	}
}
