package com.capitalone.ease_qa.ui.atf.driver.Impl;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.PropertiesConfigurationLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sourceforge.htmlunit.corejs.javascript.GeneratedClassLoader;

/**
 * Enables storage of and access to driver and browser configuration.
 *
 */
public class ClientProperties {
    private final Logger logger = LoggerFactory.getLogger(ClientProperties.class);

    private InputStream client;

    private final PropertiesConfiguration config;
    private final PropertiesConfigurationLayout propertiesConfigurationLayout;

    private final String browser;
    private final String browserVersion;
    private final String proxy;
    private final String proxyHttps;

    private int browserInitPositionX = 0;
    private int browserInitPositionY = 0;

    private final String os;
    private final String osVersion;
    

    private final String maxRequestTimeoutString; // For backwards-compatibility
    private int maxRequestTimeout = 18000;
    private String maxPageWaitString;
    private int maxPageWait = 18000;
    private final String appearWaitTimeString;
    private int appearWaitTime;
    private final String webDriverIEDriver;
    private final String webDriverChromeDriver;
    private final List<String> firefoxExtensions = new ArrayList<String>();
    private int numberOfDaysToKeepTempFolders = 7;
    private final boolean doTaskKill;
   // Selenium Grid or Sauce labs
    private final boolean useGrid;
    private final String gridUrl;
    public String getProxyHttps() {
		return proxyHttps;
	}

	public boolean isDoTaskKill() {
		return doTaskKill;
	}

	public boolean isUseGrid() {
		return useGrid;
	}

	public String getGridUrl() {
		return gridUrl;
	}

	public String getGridPlatform() {
		return gridPlatform;
	}

	public String getGridProperties() {
		return gridProperties;
	}

	private final String gridPlatform;
    private final String gridProperties;

    /**
     * Constructs a {@code ClientProperties} from the given file.
     *
     * @param filePath
     *            the file to be loaded
     */
    public ClientProperties(String filePath) {
    	
    	
       // URL clientPath = this.getClass().getClassLoader().getResource(filePath);
        
        InputStream clientPath = this.getClass().getClassLoader().getResourceAsStream(filePath);
         logger.debug("Inside Client Properties"+clientPath);
        this.config = new PropertiesConfiguration();
        this.config.setDelimiterParsingDisabled(true);
        try {
            client = clientPath;
            // Disable delimiting values (default is comma delimited)
            this.config.load(client);
        } catch (ConfigurationException e) {
            String message = "Client configuration could not be loaded from file: \""
                    + filePath + "\"";
            this.logger.error(message, e);
            throw new RuntimeException(message, e);
        }
        propertiesConfigurationLayout = config.getLayout();

        browser = load("browser", "htmlunit", "Browser name. See browsers supported by WebDriver.");
        browserVersion = load("browser.version", null, "Version of the browser");
        proxy = load("proxy", null, null);
        proxyHttps = load("proxy.https", null, null);

  
        os = load("os", "mac", null);
        osVersion = load("os.version", null, null);
        maxPageWaitString = load("maxPageWait", "30000",
                "Standard maximum page wait timeout throughout your automation project (in milliseconds)");
        try {
            maxPageWait = Integer.parseInt(maxPageWaitString);
        } catch (Exception e) {
        }

        appearWaitTimeString = load("appearWaitTime", "5000",
                "Maximum time for waiting of element appear (in milliseconds)");
        try {
            appearWaitTime = Integer.parseInt(appearWaitTimeString);
        } catch (Exception e) {
        }

        maxRequestTimeoutString = load("maxRequestTimeout", "30000",
                "Standard maximum request wait timeout throughout your automation project (in milliseconds)");
        try {
            maxRequestTimeout = Integer.parseInt(maxRequestTimeoutString);
        } catch (Exception e) {
        }

          webDriverIEDriver = load("webdriver.ie.driver", null, "Path to IEDriverServer.exe");
        webDriverChromeDriver = load("webdriver.chrome.driver", null,
                "Path to chromedriver executable");

  
        // Check before 'webdriver.doTaskKill'
        String useGridStr = load("useGrid", "false",
                "Setting for running tests against Selenium Grid or Sauce Labs");
        if (useGridStr != null && useGridStr.equalsIgnoreCase("true")) {
            useGrid = true;
        } else {
            useGrid = false;
        }

        // Check after 'useGrid'
        String taskCheck = load("webdriver.doTaskKill", "true",
                "Gracefully kill all the driver server processes at the beginning of execution");
        if (taskCheck != null) {
            if (taskCheck.equalsIgnoreCase("false") || taskCheck.equalsIgnoreCase("0")
                    || taskCheck.equalsIgnoreCase("no") || useGrid) {
                doTaskKill = false;
            } else if ((taskCheck.equalsIgnoreCase("true") || taskCheck.equalsIgnoreCase("1") || taskCheck
                    .equalsIgnoreCase("yes"))) {
                doTaskKill = true;
            } else {
                logger.error("Property 'doTaskKill' is not within range of accepted values.");
                doTaskKill = true;
            }
        } else {
            // Default value
            doTaskKill = true;
        }

          gridUrl = load("grid.url",
                "http://geldhaus_team:68b692e4-4547-49ee-a200-e79d2eb8b7a8@ondemand.saucelabs.com:80/wd/hub",
                "Sauce labs URL (e.g. 'http://username-string:access-key-string@ondemand.saucelabs.com:80/wd/hub')");
        gridPlatform = load("grid.platform", "Windows 7",
                "Selenium Grid OS Platform name (e.g. 'Windows 7')");
        gridProperties = load("grid.properties", "record-screenshots=true",
                "Space separated Selenium Grid properties (e.g. 'record-screenshots=true')");
    }

    /**
     * Loads the given key/value pair into the configuration.
     * <p>
     * If the configuration already contains the given key, no change is made to
     * the configuration.
     *
     * @param key
     *            the key to be put into the configuration
     * @param defaultValue
     *            the value to be put into the configuration; if {@code null},
     *            then no change is made to the configuration
     * @param comment
     *            a comment to be set for the key/value pair; {@code null}
     *            values permitted
     * @return the newly set value, or the current value if the configuration
     *         already contains the given key
     */
    private final String load(String key, String defaultValue, String comment) {
        if (config.getProperty(key) != null) {
            return config.getString(key);
        } else {
            if (defaultValue != null) {
                try {
                    config.addProperty(key, defaultValue);
                    if (comment != null) {
                        propertiesConfigurationLayout.setComment(key, comment);
                    } else {
                        propertiesConfigurationLayout
                                .setComment(
                                        key,
                                        "Automatically added default value");
                    }
                    config.save(config.getPath());
                } catch (ConfigurationException e) {
                    logger.error("Error saving updated property file ('" + config.getPath() + "')"
                            + e);
                }
            }
            return defaultValue;
        }
    }

	
    /**
     * Returns the name of the browser.
     *
     * @return the name of the browser
     */
    public final String getBrowser() {
        return browser;
    }

    /**
     * Returns the version of the browser.
     *
     * @return the version of the browser
     */
    public final String getBrowserVersion() {
        return browserVersion;
    }

    /**
     * Returns the proxy.
     *
     * @return the proxy
     */
    public final String getProxy() {
        return proxy;
    }

    /**
     * Returns the name of the operating system.
     *
     * @return the name of the operating system
     */
    public final String getOS() {
        return os;
    }

    /**
     * Returns the version of the operating system.
     *
     * @return the version of the operating system
     */
    public final String getOSVersion() {
        return osVersion;
    }

    public final String getMaxRequestTimeoutString() {
        return maxRequestTimeoutString;
    }

    /**
     * Returns the maximum time out for requests as an {@code int}.
     *
     * @return the maximum time out for requests as an {@code int}
     */
    public final int getMaxRequestTimeout() {
        return maxRequestTimeout;
    }

    /**
     * Returns the maximum wait time for pages.
     *
     * @return the maximum wait time for pages
     */
    public int getMaxPageWait() {
        return maxPageWait;
    }

    /**
     * Returns the maximum wait time for elements to appear.
     *
     * @return the maximum wait time for elements to appear
     */
    public int getAppearWaitTime() {
        return appearWaitTime;
    }

  
    /**
     * Returns the path to IEDriverServer.exe.
     *
     * @return the path to IEDriverServer.exe
     */
    public String getWebDriverIEDriver() {
        return webDriverIEDriver;
    }

    /**
     * Returns the path to chromedriver.exe.
     *
     * @return the path to chromedriver.exe
     */
    public String getWebDriverChromeDriver() {
        return webDriverChromeDriver;
    }

    /**
     * Returns a {@code List} of Firefox extensions.
     *
     * @return a {@code List} of Firefox extensions
     */
    public List<String> getFirefoxExtensions() {
        return firefoxExtensions;
    }

    /**
     * Returns the number of days temporary folders are kept.
     *
     * @return the number of days temporary folders are kept
     */
    public int getNumberOfDaysToKeepTempFolders() {
        return numberOfDaysToKeepTempFolders;
    }

    /**
     * Returns the initial horizontal offset of the browser window.
     *
     * @return the initial horizontal offset of the browser window
     */
    public int getBrowserInitPositionX() {
        return browserInitPositionX;
    }

    /**
     * Returns the initial vertical offset of the browser window.
     *
     * @return the initial vertical offset of the browser window
     */
    public int getBrowserInitPositionY() {
        return browserInitPositionY;
    }

    /**
     * Returns the URL represented by this {@code ClientProperties}.
     *
     * @return the URL represented by this {@code ClientProperties}
     */
    public InputStream getClient() {
        return client;
    }

	public boolean isKillTasksAtStartup() {
		// TODO Auto-generated method stub
		return true;
	}

	
}


