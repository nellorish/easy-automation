package com.capitalone.ease_qa.ui.atf.selenium.Impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.error.FixtureError;
import com.capitalone.ease_qa.ui.atf.selenium.ActionElement;
import com.capitalone.ease_qa.ui.atf.selenium.MatchCallback;
import com.capitalone.ease_qa.ui.atf.selenium.TextElement;

public class SeleniumTextReader extends SeleniumWebElement implements TextElement {

	
	private final Logger LOG = LoggerFactory.getLogger(SeleniumDriver.class);
	
	public SeleniumTextReader(ExtUiDriver m_uiDriver) {
		super(m_uiDriver);
		
	}

	public void setSelector(String selector) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getSelector() {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public Object getSelectorObject() throws FixtureError {
		// TODO Auto-generated method stub
		return null;
	}
*/
	@Override
	public void setSelectorObject(MatchCallback matchElement)
			throws FixtureError {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSelectorObject(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() throws FixtureError {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void click() throws FixtureError {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isIgnoreElementIfNotExist() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getHtmlAttribute(String attributeName) throws FixtureError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCssValue(String attributeName) throws FixtureError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIgnoreElementIfNotExist(boolean value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isElementExists() throws FixtureError {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ExtUiDriver getDriver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFocus(Keys k) throws FixtureError {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isElementVisible() throws FixtureError {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getText() throws FixtureError {
		
		return getSelectorObject().getText();
	}

	
	@Override
	public boolean containsText(String txt) throws FixtureError {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> getTextList() throws FixtureError {
		LOG.debug("Entering into the getTextList method");
		List<TextElement> t=getList();
		List<String> textList=new ArrayList<String>();
		for(int i=0;i<t.size();i++){
			String s= t.get(i).getText();
			if(null==s || s.isEmpty()){
				textList.add("");
			}else{
				textList.add(s);
			}
		}
		LOG.debug("Exiting from the getTextList method");
		return textList;
	}
	

	@Override
	public TextElement get() throws FixtureError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TextElement> getList() throws FixtureError {
		// TODO Auto-generated method stub
		LOG.debug("Entering into the getList method");
		final List<TextElement> items = new ArrayList<TextElement>();
		m_driver.findElement(this, new MatchCallback() {

	@Override
	public boolean isMatchFound(Object webObject, String selector) {
				TextElement element = new SeleniumTextReader(m_driver);
				element.setSelectorObject(webObject);
				items.add(element);
				return  false;
		        	}
         		});
		LOG.debug("Exiting from the getList method");
		return items;
	}

	@Override
	public String getFormattedText() throws FixtureError {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionElement asLink() throws FixtureError {
		ActionElement a = new SeleniumHyperLink(m_driver);
		a.setSelectorObject(getSelectorObject());
		return a;
	}

}
