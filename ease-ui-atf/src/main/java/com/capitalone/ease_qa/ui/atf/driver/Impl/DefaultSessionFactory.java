package com.capitalone.ease_qa.ui.atf.driver.Impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
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
            	if ((browser.equalsIgnoreCase("firefox") || browser.equalsIgnoreCase("*firefox"))) {
            		FirefoxProfile firefoxProfile = new FirefoxProfile();
					firefoxProfile.setAcceptUntrustedCertificates(true);
					firefoxProfile.setPreference("pdfjs.disabled", true);
					firefoxProfile.setPreference("pdfjs.firstRun", false);
					firefoxProfile.setPreference("plugin.scan.plid.all", false);
					firefoxProfile
							.setPreference("plugins.click_to_play", false);
					firefoxProfile.setPreference("plugin.default.state", 2);
					firefoxProfile.setPreference("plugin.state.java", 2);
					firefoxProfile.setPreference("security.enable_java", true);
					firefoxProfile.setPreference("plugin.scan.Acrobat", "9.0");
					firefoxProfile.setPreference(
							"network.automatic-ntlm-auth.allow-proxies", true);
					
					firefoxProfile.setPreference(
							"network.proxy.autoconfig_url",
							"http://proxy.kdc.capitalone.com:3133/proxy.pac");
					firefoxProfile.setPreference("network.proxy.no_proxies_on",
							"localhost, 127.0.0.1");
					desiredCapabilities.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
					
					wd = new FirefoxDriver(desiredCapabilities);
            	} else try {
					throw new Exception("Unsupported browser type: " + browser
					        + ". Supported browser types: IE, Firefox, Chrome, Safari, HtmlUnit.");
				} catch (Exception e) {
					// TODO Auto-generated catch blockmvn 
					e.printStackTrace();
				}
            }

            // move browser windows to specific position. It's useful for
            // debugging...
//            final int browserInitPositionX = properties.getBrowserInitPositionX();
//            final int browserInitPositionY = properties.getBrowserInitPositionY();
//            if (browserInitPositionX != 0 || browserInitPositionY != 0) {
//                wd.manage().window().setSize(new Dimension(1280, 1024));
//                wd.manage().window().setPosition(new Point(browserInitPositionX, browserInitPositionY));
//            }
        
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
    
    private static void addExtensionsToFirefoxProfile(FirefoxProfile ffp, List<String> extensions)
            throws IOException {
        for (String s : extensions) {
            ffp.addExtension(new File(s));
        }
    }
    
    private static FirefoxBinary getFFBinary(String filePath) {
        File[] possibleLocations = { new File(filePath != null ? filePath : ""),
                new File("/Applications/firefox.app"),
                new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"), };

        File ffbinary = null;

        for (File curr : possibleLocations) {
            if (curr.exists()) {
                ffbinary = curr;
                break;
            }
        }

        if (ffbinary == null) {
            throw new RuntimeException(
                    "Unable to find firefox binary, please ensure that firefox is installed "
                            + "on your system. If it is then please determine the path to your firefox.exe and set it as "
                            + "binaryPath=<FIREFOX PATH HERE>");
        } else {
            return new FirefoxBinary(ffbinary);
        }
    }
    
    private static void addPreferences(FirefoxProfile ffp) {
        ffp.setPreference("capability.policy.default.HTMLDocument.readyState", "allAccess");
        ffp.setPreference("capability.policy.default.HTMLDocument.compatMode", "allAccess");
        ffp.setPreference("capability.policy.default.Document.compatMode", "allAccess");
        ffp.setPreference("capability.policy.default.Location.href", "allAccess");
        ffp.setPreference("capability.policy.default.Window.pageXOffset", "allAccess");
        ffp.setPreference("capability.policy.default.Window.pageYOffset", "allAccess");
        ffp.setPreference("capability.policy.default.Window.frameElement", "allAccess");
        ffp.setPreference("capability.policy.default.Window.frameElement.get", "allAccess");
        ffp.setPreference("capability.policy.default.Window.QueryInterface", "allAccess");
        ffp.setPreference("capability.policy.default.Window.mozInnerScreenY", "allAccess");
        ffp.setPreference("capability.policy.default.Window.mozInnerScreenX", "allAccess");
    }
    
    private static void addPreferences(FirefoxProfile ffp, String propertiesFile) {
        Properties firefoxProfile = new Properties();

        try {
            firefoxProfile.load(new FileInputStream(propertiesFile));
        } catch (Throwable th) {
            throw new RuntimeException("Could not load firefox profile", th);
        }

        for (Object o : firefoxProfile.keySet()) {
            String key = (String) o;
            String getVal = null;
            if (key.endsWith(".type")) {
                getVal = key.substring(0, key.lastIndexOf("."));
            }

            if (getVal != null) {
                String type = firefoxProfile.getProperty(key);
                String value = firefoxProfile.getProperty(getVal + ".value");

                if (value.contains("${PROJECT_PATH}")) {
                    String projectPath = (new File("")).getAbsolutePath();
                    value = projectPath + value.replaceAll("\\$\\{PROJECT_PATH\\}", "");
                }

                if (type.equalsIgnoreCase("BOOLEAN")) {
                    ffp.setPreference(getVal, Boolean.parseBoolean(value));
                } else if (type.equalsIgnoreCase("STRING")) {
                    ffp.setPreference(getVal, value);
                } else if (type.equalsIgnoreCase("INTEGER") || type.equalsIgnoreCase("INT")) {
                    ffp.setPreference(getVal, Integer.parseInt(value));
                }
            }
        }
    }

  
   
      
	

	
}
