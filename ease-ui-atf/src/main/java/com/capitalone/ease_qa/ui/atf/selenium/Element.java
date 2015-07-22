/**
 * 
 */
package com.capitalone.ease_qa.ui.atf.selenium;

import org.openqa.selenium.Keys;

import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.error.FixtureError;

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
