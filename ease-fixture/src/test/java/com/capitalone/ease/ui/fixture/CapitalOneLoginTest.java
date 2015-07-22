package com.capitalone.ease.ui.fixture;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.driver.SessionManager;
import com.capitalone.ease_qa.ui.atf.error.FixtureError;
import com.capitalone.ease_qa.ui.atf.selenium.ActionElement;
import com.capitalone.ease_qa.ui.atf.selenium.WaitforConditionTimer;





public class CapitalOneLoginTest  {
	
	private ExtUiDriver driver;
	
    @Before
	public void intializrDriver() throws Exception{
    	
	}

	@Test
	public void doLogin() throws Exception{
	    driver=SessionManager.getInstance().getNewSession("client","chrome.properties");;
	    driver.getElementFactory().createWebPage().goToPage("https://ease-qa.kdc.capitalone.com/");
	    //driver.pauseFor(2);
	    final LoginPageFixture login = new LoginPageFixture(driver);
	    login.enterUsername("al_user21");
	    login.enterPassword("abcd12345");
	    driver.waitUntil(new WaitforConditionTimer() {
			public boolean ensure() {
				try {
					ActionElement element = driver.getElementFactory().createButton("xpath://button[@type='submit']");
					String flag = element.getHtmlAttribute("aria-disabled");
					System.out.println(flag);
					element.click();
					return flag.equalsIgnoreCase("false");
				} catch (FixtureError e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// TODO Auto-generated method stub
				return false;
			}
		});
	   
	    
	    login.clickLogin();
	    driver.waitUntil(new WaitforConditionTimer() {
			
			public boolean ensure() {
				
				return login.getTitle().equalsIgnoreCase("EASE | Account Summary");
			}
		});
	    
	    //driver.pauseFor(10);
	    assertEquals("EASE | Account Summary", login.getTitle());
	}
	
	
	
	@After
	public void shutdownBrowser(){
		driver.shutdown();
	}
	
/*	//@Test
	public void testFirefox() throws Exception{
		ExtUiDriver driver = SessionManager.getInstance().getNewSession("client","firefox.properties");
	    driver.getElementFactory().createWebPage().goToPage("https://ease-qa.kdc.capitalone.com/ease-ui/#/login");
	    LoginPageFixture login = new LoginPageFixture(driver);
	    login.enterUsername("al_user21");
	    login.enterPassword("abcd12345");
	    login.clickLogin();
	   // driver.shutdown();
		
	}*/
	
	
	
	
	
	public static void main(String args[]) throws FixtureError{
		
		
		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/spring-chrome.xml");
		
	     //driver =(ExtUIDriver)ctx.getBean("uidriver");
		/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\gtg716\\Documents\\driver\\chromedriver.exe");
		
		System.out.println(System.getProperty("webdriver.chrome.driver"));
		driver = DriverUtils.getDriver();
		CapitalOneLoginTest cap = new CapitalOneLoginTest();
		LoginPageFixture login = new LoginPageFixture(driver);
		driver.getElementFactory().createWebPage().goToPage("http://awseasedev11web1.kdc.capitalone.com:8080/ease-ui/#/login");
		login.enterUsername("al_user21");
		login.enterPassword("abcd12345");
		login.clickLogin();*/
			
	}
	
	
}
