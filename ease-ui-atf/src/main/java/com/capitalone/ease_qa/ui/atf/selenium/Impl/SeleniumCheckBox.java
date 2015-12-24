package com.capitalone.ease_qa.ui.atf.selenium.Impl;

import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;

/**
 * 
 * @author gtg716
 *
 */
public class SeleniumCheckBox extends SeleniumSelectableElement {

	public SeleniumCheckBox(ExtUiDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public SeleniumCheckBox(ExtUiDriver m_driver, String selector) {
		 super(m_driver);
		 setSelector(selector);
		// TODO Auto-generated constructor stub
	}
   
}
