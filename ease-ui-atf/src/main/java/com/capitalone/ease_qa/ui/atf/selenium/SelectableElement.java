/**
 * 
 */
package com.capitalone.ease_qa.ui.atf.selenium;

import java.util.List;

import com.capitalone.ease_qa.ui.atf.error.FixtureError;

/**
 * @author gtg716
 *
 * 
 */
public interface SelectableElement extends Element {

	Element selectItemByValue(final String value) throws FixtureError;
	boolean isSelected() throws FixtureError;
	String getText() throws FixtureError;
	List<String> getTextList() throws FixtureError;
	String getSelectedValue() throws FixtureError ;


}
