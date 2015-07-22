/**
 * 
 */
package com.capitalone.ease_qa.ui.atf.selenium;

/**
 * @author gtg716
 *
 * 
 */
public interface ElementFactory {
	


	/**
	 * Creates a web page element
	 *
	 * @param m_uiDriver
	 * @return
	 */
	WebPage createWebPage();

	/**
	 * Creates a button  element
	 *
	 * @param m_uiDriver
	 * @return
	 */
	ActionElement createButton(String selector);

	/**
	 * Creates a text reader element
	 *
	 * @param m_uiDriver
	 * @return
	 */
	TextElement createTextElement(String selector);



	/**
	 * Creates a radio button element
	 *
	 * @param m_uiDriver
	 * @return
	 */
	SelectableElement createRadioButton(String selector);

	/**
	 * Creates a check box element
	 *
	 * @param m_uiDriver
	 * @return
	 */
	SelectableElement createCheckBox(String selector);

	/**
	 * Creates a hyper link  element
	 *
	 * @param m_uiDriver
	 * @return
	 */
	ActionElement createHyperLink(String selector);

	/**
	 * Creates a text reader
	 *
	 * @param m_uiDriver
	 * @return
	 */
	TextElement createTextReader(String selector);

	/**
	 * Creates a dropdown button element
	 *
	 * @param m_uiDriver
	 * @return
	 */
	SelectableElement createDropDown(String selector);
 
	Element createElement(String selector);
	
	/**
	 * Creates an Action element
	 *
	 * @param m_uiDriver
	 * @return ActionElement - any clickable element
	 */
	ActionElement createActionElement(String selector);

	TextElement createTextArea(String selector);


}
