package com.capitalone.ease_qa.ui.atf.selenium.Impl;



import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.selenium.WebPage;

public class SeleniumWebPage extends SeleniumWebElement implements WebPage {

	public SeleniumWebPage(ExtUiDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String goToPage(String url) {
		getInternalDriver().get(url);
          return browserCaption();
          
	}

	public String browserCaption() {
		
		return getInternalDriver().getTitle();
	}

	
	@Override
	public void maximizeWindow() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCurrentUrl() {
		// TODO Auto-generated method stub
		return getInternalDriver().getCurrentUrl();
	}

    @Override
	public String getCurrentWindowName() {
		// TODO Auto-generated method stub
		return null;
	}
}
