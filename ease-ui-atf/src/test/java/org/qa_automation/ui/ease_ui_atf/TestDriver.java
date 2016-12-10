/**
 * 
 */
package org.qa_automation.ui.ease_ui_atf;

import org.qa_automation.ui.atf.driver.ExtUiDriver;
import org.qa_automation.ui.atf.selenium.Impl.SeleniumDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author gtg716
 *
 */
public class TestDriver {
	
	public static ExtUiDriver getDriver(){
	  ExtUiDriver driver = new SeleniumDriver(new ChromeDriver());
	 // ExtUiDriver driver = new SeleniumDriver(new HtmlUnitDriver(true));
		driver.setLocalResourcePath("file://" + driver.getClass().getClassLoader().getResource("").getPath());
		
        return driver;	
	}
	
	

}
