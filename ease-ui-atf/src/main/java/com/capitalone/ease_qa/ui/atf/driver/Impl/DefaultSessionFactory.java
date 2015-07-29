package com.capitalone.ease_qa.ui.atf.driver.Impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.driver.SessionFactory;
import com.capitalone.ease_qa.ui.atf.selenium.Impl.SeleniumDriver;

/**
 * SessionPool functionality used by SessionManager instances.
 * 
 * 
 */

public class DefaultSessionFactory implements SessionFactory {
    private static final long MILLISECONDS_IN_DAY = 86400000;
    private static final Object lock = new Object();
    private static final Log log = LogFactory.getLog(DefaultSessionFactory.class);
    private static boolean executedTaskKill = false;

  
    @Override
    public void cleanup(Map<String, String> options) throws Exception {

        ClientProperties properties = new ClientProperties(options.get("client"));

        if (!executedTaskKill) {
            synchronized (lock) {
                if (properties.isKillTasksAtStartup()) {
                  if (properties.getBrowser().equalsIgnoreCase("chrome")) {
                        if (properties.getOS() == null
                                || properties.getOS().equalsIgnoreCase("windows")) {
                            try {
                                Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");

                            } catch (IOException e) {
                                log.warn("Taskkill failed to kill any rogue chromedriver.exe processes");
                            }
                            try {
                                Runtime.getRuntime().exec("taskkill /F /IM chrome.exe /T");
                            } catch (IOException e) {
                                log.warn("Taskkill failed to kill any rogue chrome browsers");

                            }
                        } if (properties.getOS().equalsIgnoreCase("mac")) {
                            try {
                                Runtime.getRuntime().exec("killall -KILL chromedriver");
                            } catch (IOException e) {
                                log.warn("Taskkill failed to kill any rogue chromedriver tasks");
                            }
                            try {
                                Runtime.getRuntime().exec("killall -KILL chrome");
                            } catch (IOException e) {
                                log.warn("Taskkill failed to kill any rogue chrome browsers");
                            }
                        } else {
                            log.warn("Taskkill failed to kill any rogue chromedriver or chrome tasks because the OS"
                                    + "provided is either incorrect or not supported");
                        }
                    } 
                }
                executedTaskKill = true;
            }
        }

       // removeWebDriverTempOldFolders(properties);
    }

   
    @Override
    public DesiredCapabilities createCapabilities(Map<String, String> options) throws Exception {

        ClientProperties properties = new ClientProperties(options.get("client"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
     //   final String browser = properties.getBrowser();

        if (properties.isUseGrid()) {
            
            return capabilities;
        } else {
        	
        	
        	
            return capabilities;
        }
		
    }

  

   
    @Override
    public ExtUiDriver createNewSession(Map<String, String> options,  DesiredCapabilities capabilities) {

        ClientProperties properties = new ClientProperties(options.get("client"));

        WebDriver wd = null;
        ExtUiDriver selenium=null;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities(capabilities);
        String browser = properties.getBrowser();

        
            if (browser == null || browser.equals("")) {
                throw new RuntimeException(
                        "Browser cannot be null. Please set 'browser' in client properties. Supported browser types: IE, Firefox, Chrome, Safari, HtmlUnit.");
            } else if (browser.equalsIgnoreCase("ie") || browser.equalsIgnoreCase("iexplore")
                    || browser.equalsIgnoreCase("*iexplore")) {
                String webdriverIEDriver = properties.getWebDriverIEDriver();

                if (webdriverIEDriver != null) {
                    System.setProperty("webdriver.ie.driver", webdriverIEDriver);
                }

                String browserVersion = properties.getBrowserVersion();

                if (browserVersion == null || browserVersion.equals("")) {
                    throw new RuntimeException(
                            "When using IE as the browser, please set 'browser.version' in client properties");
                } else {
                    if (browserVersion.startsWith("9")) {
                        desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                        desiredCapabilities
                                .setCapability(
                                        InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
                                        true);
                        wd = new InternetExplorerDriver(desiredCapabilities);
                    } else {
                        wd = new InternetExplorerDriver(desiredCapabilities);
                    }
                }
            } 
            if (browser.equalsIgnoreCase("chrome")) {

                String webdriverChromeDriver = properties.getWebDriverChromeDriver();

                if (webdriverChromeDriver != null) {
                    System.setProperty("webdriver.chrome.driver", webdriverChromeDriver);
                }

                wd = new ChromeDriver(desiredCapabilities);
            } else if (browser.equalsIgnoreCase("safari")) {
                wd = new SafariDriver(desiredCapabilities);
            } else if (browser.equalsIgnoreCase("htmlunit")) {
                wd = new HtmlUnitDriver(desiredCapabilities);
                ((HtmlUnitDriver) wd).setJavascriptEnabled(true);
            } else {
                try {
					throw new Exception("Unsupported browser type: " + browser
					        + ". Supported browser types: IE, Firefox, Chrome, Safari, HtmlUnit.");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }

            // move browser windows to specific position. It's useful for
            // debugging...
            final int browserInitPositionX = properties.getBrowserInitPositionX();
            final int browserInitPositionY = properties.getBrowserInitPositionY();
            if (browserInitPositionX != 0 || browserInitPositionY != 0) {
                wd.manage().window().setSize(new Dimension(1280, 1024));
                wd.manage().window().setPosition(new Point(browserInitPositionX, browserInitPositionY));
            }
        
            selenium = new SeleniumDriver(wd);
            return selenium;
    }
                                                                                                                             
    
    @Override
    public Map<String, String> createDefaultOptions() {
        HashMap<String, String> ret = new HashMap<String, String>();
        // Add any default options needed here (like path to default properties)

        ret.put("client", "client.properties");

        return ret;
    }

  
   
      
	

	
}
