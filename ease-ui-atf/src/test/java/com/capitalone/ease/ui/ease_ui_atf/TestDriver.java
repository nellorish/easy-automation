/**
 * 
 */
package com.capitalone.ease.ui.ease_ui_atf;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.selenium.Impl.SeleniumDriver;

/**
 * @author gtg716
 *
 */
public class TestDriver {
	
	public static ExtUiDriver getDriver(){
	  ExtUiDriver driver = new SeleniumDriver(new ChromeDriver());
	   //ExtUiDriver driver = new SeleniumDriver(new HtmlUnitDriver(true));
		driver.setLocalResourcePath("file://" + driver.getClass().getClassLoader().getResource("").getPath());
        return driver;	
	}
	
	public static Capabilities buildCapabilities(){
		
		
		
		
		
		return null;
		
	}

}
