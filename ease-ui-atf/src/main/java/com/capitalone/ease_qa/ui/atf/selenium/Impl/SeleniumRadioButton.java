package com.capitalone.ease_qa.ui.atf.selenium.Impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.error.FixtureError;
import com.capitalone.ease_qa.ui.atf.error.UnImplementedException;
import com.capitalone.ease_qa.ui.atf.selenium.MatchCallback;
import com.capitalone.ease_qa.ui.atf.selenium.SelectableElement;


/**
 * 
 * @author gtg716
 *
 */
public class SeleniumRadioButton extends SeleniumSelectableElement implements
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

	@Override
	public List<String> getTextList() throws FixtureError {
		final List<String> text= new ArrayList<String>();
		try{
		setIgnoreElementIfNotExist(true);
		setSelectorObject(new MatchCallback() {

			@Override
			public boolean isMatchFound(Object webObject, String selector) {
				WebElement element = (WebElement) webObject;
				text.add(element.getAttribute("value"));
				return false;
			}
		});
		}finally{
			setIgnoreElementIfNotExist(false);
		}

		return text;

	}
}
