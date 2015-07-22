package com.capitalone.ease_qa.ui.atf.selenium.Impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.selenium.ActionElement;
import com.capitalone.ease_qa.ui.atf.selenium.Element;
import com.capitalone.ease_qa.ui.atf.selenium.ElementFactory;
import com.capitalone.ease_qa.ui.atf.selenium.SelectableElement;
import com.capitalone.ease_qa.ui.atf.selenium.TextElement;
import com.capitalone.ease_qa.ui.atf.selenium.WebPage;

public class SeleniumElementFactory implements ElementFactory {
	private final static Logger LOG = LoggerFactory.getLogger(SeleniumElementFactory.class);
	private final ExtUiDriver m_uiDriver;
	public SeleniumElementFactory(ExtUiDriver uidriver){
		m_uiDriver=uidriver;
	}

	
	public WebPage createWebPage() {
		return new SeleniumWebPage(m_uiDriver);
	}

	public ActionElement createButton(String selector) {
		LOG.debug("Entering into the createButton  method : "+ selector);
		SeleniumButton button = new SeleniumButton(m_uiDriver);
		button.setSelector(selector);
		return button;
	}

	@Override
	public TextElement createTextElement(String selector) {
		LOG.debug("Entering into the createTextElement  method : " + selector);
		SeleniumTextBox textBox = new SeleniumTextBox(m_uiDriver);
		textBox.setSelector(selector);
		return textBox;
	}

	@Override
	public SelectableElement createRadioButton(String selector)  {
		LOG.debug("Entering into the createRadioButton  method : " + selector);
		SelectableElement radioButton = new SeleniumRadioButton(m_uiDriver);
		radioButton.setSelector(selector);
		return radioButton;
	}

	@Override
	public ActionElement createHyperLink(String selector) {
		LOG.debug("Entering into the createHyperLink  method : " + selector);
		SeleniumHyperLink link = new SeleniumHyperLink(m_uiDriver);
		link.setSelector(selector);
		return link;
	}

	@Override
	public TextElement createTextReader(String selector) {
		LOG.debug("Entering into the createTextReader  method : " + selector);
		SeleniumTextReader reader = new SeleniumTextReader(m_uiDriver);
		reader.setSelector(selector);
		return reader;
	}

	@Override
	public SelectableElement createDropDown(String selector) {
		LOG.debug("Entering into the createDropDown  method : " + selector);
		SeleniumDropDown dropdown= new SeleniumDropDown(m_uiDriver);
		dropdown.setSelector(selector);
		return dropdown;
	}

	@Override
	public Element createElement(String selector) {
		LOG.debug("Entering into the createElement  method : " + selector);
		SeleniumWebElement webElement = new SeleniumWebElement(m_uiDriver);
		webElement.setSelector(selector);
		return webElement;
	}

	@Override
	public SelectableElement createCheckBox(String selector) {
		LOG.debug("Entering into the createCheckBox  method : " + selector);
		SeleniumCheckBox checkBox = new SeleniumCheckBox(m_uiDriver);
		checkBox.setSelector(selector);
		return checkBox;
	}

    @Override
	public ActionElement createActionElement(String selector) {
		LOG.debug("Entering into the createActionElement  method : " + selector);
		SeleniumActionElement actionElement = new SeleniumActionElement(m_uiDriver);
		actionElement.setSelector(selector);
		return actionElement;
	}

	@Override
	public TextElement createTextArea(String selector){
		LOG.debug("Entering into the createTextElement  method : " + selector);
		SeleniumTextArea textArea = new SeleniumTextArea(m_uiDriver);
		textArea.setSelector(selector);
		return textArea;
	} 

}
