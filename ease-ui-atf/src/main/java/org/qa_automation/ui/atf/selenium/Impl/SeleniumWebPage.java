package org.qa_automation.ui.atf.selenium.Impl;



import org.qa_automation.ui.atf.driver.ExtUiDriver;
import org.qa_automation.ui.atf.selenium.WebPage;

/**
 * 
 * @author gtg716
 *
 */
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
		
		getInternalDriver().manage().window().maximize();
	
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
