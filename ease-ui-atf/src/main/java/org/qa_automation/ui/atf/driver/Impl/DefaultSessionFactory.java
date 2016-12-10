package org.qa_automation.ui.atf.driver.Impl;

import org.qa_automation.ui.atf.driver.ExtUiDriver;
import org.qa_automation.ui.atf.driver.SessionFactory;
import org.qa_automation.ui.atf.selenium.Impl.SeleniumDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author gtg716
 * 
 * SessionPool functionality used by SessionManager instances.
 * 
 * 
 */

public class DefaultSessionFactory implements SessionFactory {
	private static Properties systemProperties = null;
    private static final long MILLISECONDS_IN_DAY = 86400000;
    private static final Object lock = new Object();
    private static final Log log = LogFactory.getLog(DefaultSessionFactory.class);
    private static boolean executedTaskKill = false;

  

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

  


    public ExtUiDriver createNewSession(Map<String, String> options, DesiredCapabilities capabilities)  {

        ClientProperties properties = new ClientProperties(options.get("client"));

        WebDriver wd = null;
        ExtUiDriver selenium=null;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities(capabilities);
        String browser = properties.getBrowser();

        if (properties.isUseGrid()) {
        	try{
        		
        		systemProperties = System.getProperties();
				systemProperties.setProperty("http.proxyHost",
						"proxy.kdc.capitalone.com");
				systemProperties.setProperty("http.proxyPort", "8099");


				//URL sauceURL =  new URL(properties.getGridUrl());
				desiredCapabilities.setBrowserName(properties.getBrowser());
				desiredCapabilities.setVersion(properties.getBrowserVersion());
				desiredCapabilities.setCapability("platform", properties.getOS());
				desiredCapabilities.setCapability("parent-tunnel", "ease_team");
				desiredCapabilities.setCapability("name", browser + "_" + properties.getBrowserVersion() + "_" + properties.getOS());
				desiredCapabilities.setCapability("max-duration", 2700);
				desiredCapabilities.setCapability("command-timeout", 600);

//				systemProperties = System.getProperties();
//				systemProperties.setProperty("http.proxyHost",
//						"proxy.kdc.capitalone.com");
//				systemProperties.setProperty("http.proxyPort", "8099");
				
			if (browser.equalsIgnoreCase("chrome")) {
				 
					ChromeOptions chromeoptions = new ChromeOptions();
					chromeoptions.addArguments("test-type");
					chromeoptions.addArguments("--disable-extensions");
					desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeoptions);
			}else{
				if(browser.equalsIgnoreCase("firefox")){
					FirefoxProfile firefoxProfile = new FirefoxProfile();
				     addPreferences(firefoxProfile);
					desiredCapabilities.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
			}
				
		}			
          // RemoteWebDriver remoteWebDriver = new RemoteWebDriver(new URL(properties.getGridUrl()),desiredCapabilities);
           // remoteWebDriver.setFileDetector(new LocalFileDetector());
			
            
           wd = new RemoteWebDriver(new URL(properties.getGridUrl()),desiredCapabilities);
			
        	}catch(MalformedURLException e){
        		e.printStackTrace();
        	}
        }else { 
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
            		FirefoxBinary ffb = getFFBinary("/Applications/Firefox.app/contents/MacOS/firefox-bin");
            		addPreferences(firefoxProfile);
					
				    wd = new FirefoxDriver();
					//wd = new FirefoxDriver();
            	} else try {
					throw new Exception("Unsupported browser type: " + browser
					        + ". Supported browser types: IE, Firefox, Chrome, Safari, HtmlUnit.");
				} catch (Exception e) {
					// TODO Auto-generated catch blockmvn 
					e.printStackTrace();
				}
            }
        }
        
            selenium = new SeleniumDriver(wd);
            return selenium;
    }
                                                                                                                             
    

    public Map<String, String> createDefaultOptions() {
        HashMap<String, String> ret = new HashMap<String, String>();
        // Add any default options needed here (like path to default properties)

        ret.put("client", "client.properties");

        return ret;
    }
    
//    private static void addExtensionsToFirefoxProfile(FirefoxProfile ffp, List<String> extensions)
//            throws IOException {
//        for (String s : extensions) {
//            ffp.addExtension(new File(s));
//        }
//    }
//    
    private static FirefoxBinary getFFBinary(String filePath) {
        File[] possibleLocations = { new File(filePath != null ? filePath : ""),
                new File("/Applications/Firefox.app/Contents/MacOS/firefox-bin"),
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
//    
    private static void addPreferences(FirefoxProfile firefoxProfile) {
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
    }

	
}
