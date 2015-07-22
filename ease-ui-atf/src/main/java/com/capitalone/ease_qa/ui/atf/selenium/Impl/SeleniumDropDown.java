/**
 * 
 */
package com.capitalone.ease_qa.ui.atf.selenium.Impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.error.FixtureError;
import com.capitalone.ease_qa.ui.atf.selenium.Element;
import com.capitalone.ease_qa.ui.atf.selenium.MatchCallback;
import com.capitalone.ease_qa.ui.atf.selenium.SelectableElement;

/**
 * @author gtg716
 *
 * 
 */
public class SeleniumDropDown extends SeleniumWebElement implements SelectableElement {

	public SeleniumDropDown(ExtUiDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
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

	public boolean isSelected() throws FixtureError {
	
		List<WebElement> options = getOptionList();
		for (WebElement option : options) {

			if (option.isSelected()) {
				return true;
			}
		}
        return false;
	}
	private List<WebElement> getOptionList() throws FixtureError {
		
		WebElement element = getSelectorObject();
		Select dropdown = new Select(element);
		List<WebElement> options = dropdown.getOptions();
		return options;
	}

	public String getText() throws FixtureError {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getTextList() throws FixtureError {
		
		List<WebElement> tList = getOptionList();
		List<String> textList = new ArrayList<String>();
		for (WebElement t : tList) {
			String s = t.getText();
			if (null != s && !s.isEmpty()) {
				textList.add(s);
			}
		}
		return textList;
	}

	public String getSelectedValue() throws FixtureError {
		Select dropdown = new Select(getSelectorObject());
		return dropdown.getFirstSelectedOption().getText();
	}}
