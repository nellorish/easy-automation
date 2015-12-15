package com.capitalone.ease.ui.run;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.capitalone.ease.ui.fixture.LoginPageFixture;
import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.driver.SessionManager;
import com.capitalone.ease_qa.ui.atf.error.FixtureError;
import com.capitalone.ease_qa.ui.atf.selenium.ActionElement;
import com.capitalone.ease_qa.ui.atf.selenium.TextElement;
import com.capitalone.ease_qa.ui.atf.selenium.WaitforConditionTimer;


public class CapitalOneLoginTest  {
	
	private ExtUiDriver driver;
	
	
	
    @Before
	public void intializrDriver() throws Exception{
    	
	}

	@Test
	public void doLogin() throws Exception{
	    driver=SessionManager.getInstance().getNewSession("client","chrome.properties");
	    //driver.getElementFactory().createWebPage().maximizeWindow();
	    
	    driver.eval("window.resizeTo(1024, 768);");
	    driver.getElementFactory().createWebPage().goToPage("https://ease-qamb.kdc.capitalone.com/ease-ui/#/login");
	    //driver.pauseFor(2);
//	    driver.waitUntil(new WaitforConditionTimer() {
//			@Override
//			public boolean ensure() {
//				TextElement element= driver.getElementFactory().createTextReader("xpath://*[@id='login-page']/div[1]/h1");
//				// TODO Auto-generated method stub
//				try {
//					return element.isElementExists();
//				} catch (FixtureError e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				return false;
//			}
//		});
	   
	   // System.out.println(" Print the text on Login "+element.getText());
	   final LoginPageFixture login = new LoginPageFixture(driver);
	    login.enterUsername("QA0_Chk458202779");
	    login.enterPassword("abcd12345");
	   
	    //wait for the Login button to be enabled
//	    driver.waitUntil(new WaitforConditionTimer() {
//	    	@Override
//			public boolean ensure() {
//				try {
//					ActionElement element = driver.getElementFactory().createButton("login-start-button");
//					String flag = element.getHtmlAttribute("aria-disabled");
//					System.out.println(flag);
//					element.click();
//					return flag.equalsIgnoreCase("false");
//				} catch (FixtureError e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				// TODO Auto-generated method stub
//				return false;
//			}
//		});
	    login.clickLogin();
//	    driver.waitUntil(new WaitforConditionTimer() {
//			public boolean ensure() {
//			return login.getTitle().equalsIgnoreCase("EASE | Account Summary");
//			}
//		});
	    
	    //driver.pauseFor(10);
	    
	    driver.waitUntil(new WaitforConditionTimer() {
			public boolean ensure() {
			return login.getTitle().equalsIgnoreCase("EASE | Account Summary");
			}
		});
      assertEquals("EASE | Account Summary", login.getTitle());
      
      driver.getElementFactory().createButton("class:_lob_DDA360").click();
      
     // driver.getElementFactory().createActionElement("class:atddAccountType").click(); 
      
//      driver.waitUntil(new WaitforConditionTimer() {
//		
//		@Override
//		public boolean ensure() {
//			// TODO Auto-generated method stub
//			try {
//				return driver.getElementFactory().createHyperLink("viewDetailLink").isElementExists();
//			} catch (FixtureError e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return false;
//		}
//	});
      //driver.windowScroll(0,1400);
     // driver.windowScroll(600,0);
      //driver.windowScroll(0,300);
     // driver.getElementFactory().createHyperLink("viewDetailLink").click();
      
    List<TextElement> elements = driver.getElementFactory().createTextReader("xpath://ul[@class='transactionsList']/li").getList();    
      
      //driver.switchToActiveWindow();
      //driver.windowScroll(250,0);
      //driver.scrollToElement(driver.getElementFactory().createElement("class:modal-container"));
      
    
      
//      driver.waitUntil(new WaitforConditionTimer() {
//		
//		@Override
//		public boolean ensure() {
//			TextElement element= driver.getElementFactory().createTextElement("ProductName");
//			try {
//				return element.isElementVisible();
//			} catch (FixtureError e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return false;
//		}
//	});
//      
//      driver.waitUntil(new WaitforConditionTimer() {
//		
//		@Override
//		public boolean ensure() {
//			ActionElement element = driver.getElementFactory().createButton("class:close-dialog");
//			// TODO Auto-generated method stub
//			try {
//				return element.isElementVisible();
//			} catch (FixtureError e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return false;
//		}
//	});
//      
       //driver.getElementFactory().createButton("class:close-dialog").click();
      // driver.getElementFactory().createButton("class:back-to-summary").click();
//      Assert.assertEquals("EASE | Account Summary",login.getTitle());
      
	}
	
	
	
	@After
	public void shutdownBrowser(){
	  //driver.shutdown();
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
