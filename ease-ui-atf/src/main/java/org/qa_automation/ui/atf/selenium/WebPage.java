/**
 * 
 */
package org.qa_automation.ui.atf.selenium;

/**
 * @author gtg716
 *
 * 
 */
public interface WebPage {
	
	String goToPage(String url);
	String browserCaption();
    String getCurrentWindowName();
   

	void maximizeWindow();

	String getCurrentUrl();

}
