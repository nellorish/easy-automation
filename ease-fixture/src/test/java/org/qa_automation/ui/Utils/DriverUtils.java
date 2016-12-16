package org.qa_automation.ui.Utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class DriverUtils {

	private static String remotePerfectoURL = "https://qa_automation.perfectomobile.com/nexperience/perfectomobile/wd/hub";
	private static Properties systemProperties;

	@SuppressWarnings("rawtypes")
	public static WebDriver getDroidChromeDriver() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("automationName", "Appium");
		capabilities.setCapability("platformName", "Android");
		//capabilities.setCapability("platformVersion","5.0");
		capabilities.setCapability("deviceName", "SCH-I545");
		//capabilities.setCapability("deviceName","SM-G900V");
		//capabilities.setCapability("chrome.chromedriverVersion","39.0.2171.59");
		capabilities.setCapability("newCommandTimeout", "200");
		capabilities.setCapability("appPackage", "com.android.chrome");
		//capabilities.setCapability("appPackage","com.sec.android.app.sbrowser");
		//capabilities.setCapability("appActivity","SBrowserMainActivity");

		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		return driver;
	}

	public static WebDriver getPerfectoDriver(String device) throws MalformedURLException {

		WebDriver driver;
		DesiredCapabilities capabilities = new DesiredCapabilities();

//        String user = "pranab.mohanty@qa_automation.com";
//         String password="Perfecto123";
//         String host="qa_automation.perfectomobile.com";
		capabilities = new DesiredCapabilities();
		URL perfecto = new URL(remotePerfectoURL);
		capabilities.setCapability("max-duration", 2700);
		capabilities.setCapability("command-timeout", 2700);
		capabilities.setCapability("user", "team42@qa_automation.com");
		capabilities.setCapability("password", "Perfecto123");
		// capabilities.setBrowserName(browser);
		//capabilities.setVersion(version);

		if (device.equals("andriod")) {
			capabilities.setCapability("automationName", "Appium");
			// capabilities.setCapability("platformName", "Android");
			//capabilities.setCapability("platformVersion", "5.1");
			capabilities.setCapability("browserName", "chrome");
			//capabilities.setCapability("version", "4.4.2");
			// capabilities.setCapability("device", "Android");
			// capabilities.setCapability("os.name","Android");
			//capabilities.setCapability("os.version","5.1");
			// capabilities.setCapability("appPackage","com.android.chrome");

			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("platformVersion", "5.0");
			capabilities.setCapability("manufacturer", "Samsung");
			capabilities.setCapability("model", "Galaxy S5");
			capabilities.setCapability("location", "NA-US-BOS");
			capabilities.setCapability("resolution", "1080 x 1920");
			capabilities.setCapability("deviceName", "A7925701");
			// capabilities.setCapability("deviceName","0607365DF0EA8E49");
		}

		if (device.equals("ios")) {

			capabilities.setCapability("platformName", "iOS");
			capabilities.setCapability("platformVersion", "8.4");
			capabilities.setCapability("manufacturer", "Apple");
			capabilities.setCapability("model", "iPhone-6");
			capabilities.setCapability("location", "NA-US-BOS");
			capabilities.setCapability("resolution", "750 x 1334");
			capabilities.setCapability("network", "Sprint-United States of America");
			capabilities.setCapability("deviceName", "C0F275076BB66ED1AEC00FF25012DBDC6E3F92EE");

		}

		systemProperties = System.getProperties();
		systemProperties.setProperty("http.proxyHost", "proxy.kdc.qa_automation.com");
		systemProperties.setProperty("http.proxyPort", "8099");
		driver = new RemoteWebDriver(perfecto, capabilities);


		return driver;


  }
}
