package org.qa_automation.ui.atf.Util;

import org.qa_automation.ui.atf.driver.ExtUiDriver;
import org.qa_automation.ui.atf.selenium.Impl.SeleniumDriver;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author gtg716
 *
 */
public class SeleniumUtility {

	public static WebDriver getInternalDriver(ExtUiDriver m_driver) {
		if (m_driver instanceof SeleniumDriver)
			return ((SeleniumDriver) m_driver).getWebDriver();
		return null;
	}

}
