package com.capitalone.ease_qa.ui.atf.Util;

import org.openqa.selenium.WebDriver;

import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.selenium.Impl.SeleniumDriver;

public class SeleniumUtility {

	public static WebDriver getInternalDriver(ExtUiDriver m_driver) {
		if (m_driver instanceof SeleniumDriver)
			return ((SeleniumDriver) m_driver).getWebDriver();
		return null;
	}

}
