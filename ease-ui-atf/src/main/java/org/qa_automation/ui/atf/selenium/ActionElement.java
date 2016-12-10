/**
 * 
 */
package org.qa_automation.ui.atf.selenium;

import org.qa_automation.ui.atf.error.FixtureError;

/**
 * @author mnellore
 *
 * 
 */
public interface ActionElement extends Element {

	
	void click() throws FixtureError;
    void pressEnter() throws FixtureError;
	String getText() throws FixtureError;
	String getFormattedText() throws FixtureError;
	
	
}
