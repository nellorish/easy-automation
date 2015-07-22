/**
 * 
 */
package com.capitalone.ease_qa.ui.atf.selenium;

import com.capitalone.ease_qa.ui.atf.error.FixtureError;

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
