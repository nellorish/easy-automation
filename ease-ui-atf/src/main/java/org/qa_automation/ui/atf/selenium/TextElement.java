/**
 * 
 */
package org.qa_automation.ui.atf.selenium;

import java.util.List;

import org.qa_automation.ui.atf.error.FixtureError;

/**
 * @author gtg716
 *
 * 
 */
public interface TextElement extends Element {


	String getText() throws FixtureError;

	void setText(String txt) throws FixtureError;

	boolean containsText(String txt) throws FixtureError;

	List<String> getTextList() throws FixtureError;

	TextElement get() throws FixtureError;

	List<TextElement> getList() throws FixtureError;

	String getFormattedText() throws FixtureError;

	ActionElement asLink() throws FixtureError;


}
