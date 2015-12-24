
package com.capitalone.ease_qa.ui.atf.driver;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author gtg716
 * Interface for DefaultSessionsFactory
 *
 */
public interface SessionFactory {
    /**
     *
     * @return a map of strings
     */
    public Map<String, String> createDefaultOptions();

    /**
     * Cleans up the session - closed all tasks
     * @param options
     *            the options for cleaning up
     * @throws Exception
     */
    public void cleanup(Map<String, String> options) throws Exception;

    /**
     *
     * @param options
     *            the options you want the capabilities instance to have
     * @return the capabilities of webdriver
     * @throws Exception
     */
    public DesiredCapabilities createCapabilities(Map<String, String> options) throws Exception;

    

    /**
     *
     * @param options
     *            the options you want the capabilities instance to have
     * @return the capabilities of webdriver
     * @throws Exception
     */

	public ExtUiDriver createNewSession(Map<String, String> options,
			 DesiredCapabilities capabilities);

	
    
}
