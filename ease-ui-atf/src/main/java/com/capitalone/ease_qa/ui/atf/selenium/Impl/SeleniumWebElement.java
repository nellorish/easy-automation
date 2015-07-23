package com.capitalone.ease_qa.ui.atf.selenium.Impl;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.capitalone.ease_qa.ui.atf.Util.SeleniumUtility;
import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.error.FixtureError;
import com.capitalone.ease_qa.ui.atf.error.MatchValueError;
import com.capitalone.ease_qa.ui.atf.error.UnImplementedException;
import com.capitalone.ease_qa.ui.atf.selenium.Element;
import com.capitalone.ease_qa.ui.atf.selenium.MatchCallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeleniumWebElement implements Element{
	
	
	protected  ExtUiDriver m_driver;
	private String m_selector;
	private WebElement m_webElement;
	private boolean m_ignoreElementIfNotExists;
	private int m_waitForSeconds = -1;
	 private final static Logger LOG =  LoggerFactory.getLogger(SeleniumWebElement.class);
	protected final static int DEFAULT_WAIT_TIME=10;
	protected final static int DEFAULT_ELEMENT_WAIT=-1;


	public SeleniumWebElement(ExtUiDriver driver) {
		m_driver = driver;
	}

	public String getText() throws FixtureError  {
		
		throw new UnImplementedException(m_selector, null);
	}

	

	@Override
	public String getSelector() {
		return m_selector;
	}

	@Override
	public void setSelector(String selector) {
		m_selector = selector;
		m_webElement = null;
	}

	@Override
	public WebElement getSelectorObject() throws FixtureError {
		if (m_webElement == null) {
			m_webElement = (WebElement) m_driver.findElement(this);
		}
		return m_webElement;
	}

	@Override
	public void setSelectorObject(Object object) {
		m_webElement = (WebElement) object;
	}

	@Override
	public void setSelectorObject(MatchCallback matchElement) throws FixtureError {
		m_webElement = (WebElement) m_driver.findElement(this, matchElement);
		if (m_webElement == null && !m_ignoreElementIfNotExists) {
	      throw new MatchValueError(String.format(
					"can not select element by a match criteria value %s",
					matchElement.toString()));
		}
	}

	

	@Override
	public void clear() throws FixtureError {
		getSelectorObject().clear();
	}

	protected WebDriver getInternalDriver() {
		return SeleniumUtility.getInternalDriver(m_driver);
	}

	@Override
	public String getHtmlAttribute(String attributeName) throws FixtureError {
		
		return getSelectorObject().getAttribute(attributeName);
	}

	@Override
	public void setIgnoreElementIfNotExist(boolean value) {
		
		m_ignoreElementIfNotExists = value;
	}

	@Override
	public boolean isElementExists() throws FixtureError {
		boolean oldValue = m_ignoreElementIfNotExists;
		try {
			m_ignoreElementIfNotExists = true;
			if(getSelectorObject() != null){
				return (getSelectorObject() != null);
			}else{
				return false;
			}
		} finally {
			m_ignoreElementIfNotExists = oldValue;
		}


	}

	@Override
	public String getCssValue(String attributeName) throws FixtureError {
		return getSelectorObject().getCssValue(attributeName);
	}

	@Override
	public void setFocus(Keys k) throws FixtureError {
		
		getSelectorObject().sendKeys(k.toString());
	}

	@Override
	public boolean isIgnoreElementIfNotExist() {
		return m_ignoreElementIfNotExists;
	}

	@Override
	public ExtUiDriver getDriver() {
		return m_driver;
	}


	
	@Override
	public void click() throws FixtureError {
		
		getSelectorObject().click();

	}

	@Override
	public boolean isElementVisible() throws FixtureError {
		if(getSelectorObject() != null && getSelectorObject().isDisplayed()){
			return getSelectorObject().isDisplayed();
		}else{
			return false;
		}
	}

}
