/**
 * 
 */
package org.qa_automation.ui.atf.driver;

import org.qa_automation.ui.atf.error.ElementTimeoutError;
import org.qa_automation.ui.atf.error.FixtureError;
import org.qa_automation.ui.atf.selenium.Element;
import org.qa_automation.ui.atf.selenium.ElementFactory;
import org.qa_automation.ui.atf.selenium.MatchCallback;
import org.qa_automation.ui.atf.selenium.WaitforConditionTimer;

/**
 * @author gtg716
 *
 * 
 */
public interface ExtUiDriver {
	
	
	Object findElement(Element element) throws FixtureError;

	Object findElement(Element element, MatchCallback callBack)
			throws FixtureError;

	ElementFactory getElementFactory();

	void close();

	
	void shutdown();

	
	void pauseFor(int sec) throws InterruptedException;

	@Deprecated
	void captureScreen(String fullFilePath) throws FixtureError;


	void back();


	void forward();


	void refresh();

//	boolean supportsJavaScript();

	void waitUntil(WaitforConditionTimer callbackCondition)
		throws ElementTimeoutError;
   
	void switchToActiveWindow() throws InterruptedException;

    void closeActiveWindow();

	String getSessionId();

	void setSessionId(String sessionId);

	void windowScroll(int i, int j);

	void scrollToElement(Element element);

	void eval(String javascript);

	void setLocalResourcePath(String string);

	String getLocalResource(String fileName);

	void maximizeWindow();
	void testAccessibility();
	
	

}
