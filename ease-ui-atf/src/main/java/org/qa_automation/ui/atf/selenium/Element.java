/**
 * 
 */
package org.qa_automation.ui.atf.selenium;

import org.qa_automation.ui.atf.driver.ExtUiDriver;
import org.openqa.selenium.Keys;

import org.qa_automation.ui.atf.error.FixtureError;

/**
 * @author mnellore
 *
 * Jun 17, 2015
 */
public interface Element {
	
	void setSelector(String selector);

	String getSelector();

	Object getSelectorObject() throws FixtureError;

	void setSelectorObject(MatchCallback matchElement) throws FixtureError;

	void setSelectorObject(Object object);

	void clear() throws FixtureError;

	void click() throws FixtureError;
	
	boolean isIgnoreElementIfNotExist();

	String getHtmlAttribute(String attributeName) throws FixtureError;

	String getCssValue(String attributeName) throws FixtureError;

	void setIgnoreElementIfNotExist(boolean value);

	boolean isElementExists() throws FixtureError;

    ExtUiDriver getDriver();

	void setFocus(Keys k) throws FixtureError;

	boolean isElementVisible() throws FixtureError;

}
