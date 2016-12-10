package org.qa_automation.ui.atf.selenium.Impl;

import java.util.ArrayList;
import java.util.List;

import org.qa_automation.ui.atf.driver.ExtUiDriver;
import org.qa_automation.ui.atf.error.FixtureError;
import org.qa_automation.ui.atf.selenium.ActionElement;
import org.qa_automation.ui.atf.selenium.MatchCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.qa_automation.ui.atf.selenium.TextElement;

/**
 * 
 * @author gtg716
 *
 */

public class SeleniumTextReader extends SeleniumWebElement implements TextElement {

	
	private final Logger LOG = LoggerFactory.getLogger(SeleniumDriver.class);
	
	public SeleniumTextReader(ExtUiDriver m_uiDriver) {
		super(m_uiDriver);
		
	}

	public SeleniumTextReader(ExtUiDriver driver, String selector) {
		// TODO Auto-generated constructor stub
		super(driver);
		setSelector(selector);
	}

	@Override
	public String getText() throws FixtureError {
		
		return getSelectorObject().getText();
	}

	
	@Override
	public boolean containsText(String txt) throws FixtureError {
		// TODO Auto-generated method stub
		return getText().contains(txt);
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
		return getText().replace("\n"," ");
	}

	@Override
	public ActionElement asLink() throws FixtureError {
		ActionElement a = new SeleniumHyperLink(m_driver);
		a.setSelectorObject(getSelectorObject());
		return a;
	}

	@Override
	public void setText(String txt) throws FixtureError {
		// TODO Auto-generated method stub
		
	}
}
