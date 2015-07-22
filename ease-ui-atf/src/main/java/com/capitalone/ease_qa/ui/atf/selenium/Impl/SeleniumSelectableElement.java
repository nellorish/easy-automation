package com.capitalone.ease_qa.ui.atf.selenium.Impl;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.error.FixtureError;
import com.capitalone.ease_qa.ui.atf.selenium.Element;
import com.capitalone.ease_qa.ui.atf.selenium.MatchCallback;
import com.capitalone.ease_qa.ui.atf.selenium.SelectableElement;

public class SeleniumSelectableElement extends SeleniumWebElement implements
		SelectableElement {

	public SeleniumSelectableElement(ExtUiDriver driver) {
		super(driver);
		
	}

	@Override
	public Element selectItemByValue(final String value) throws FixtureError {
		setSelectorObject(new MatchCallback() {

	    	@Override
				public boolean isMatchFound(Object webObject, String selector) {
					WebElement element = (WebElement) webObject;
					return (element.getAttribute("value").equalsIgnoreCase(value));
				}
			});
			getSelectorObject().click();
			Element element = new SeleniumSubElement(m_driver);
			element.setSelectorObject(getSelectorObject());
			return element;
	
	}

	@Override
	public boolean isSelected() throws FixtureError {
		// TODO Auto-generated method stub
		return getSelectorObject().isSelected();
	}

	@Override
	public List<String> getTextList() throws FixtureError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSelectedValue() throws FixtureError {
		// TODO Auto-generated method stub
		return null;
	}

}