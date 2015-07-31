package com.capitalone.ease.ui.stepdef;

import org.junit.Assert;
import org.springframework.context.support.AbstractApplicationContext;

import com.capitalone.ease.ui.fixture.AccountDetailsFixture;
import com.capitalone.ease.ui.fixture.AccountSummaryFixture;
import com.capitalone.ease.ui.fixture.LoginPageFixture;
import com.capitalone.ease.ui.pages.AccountDetailsPage;
import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.driver.SessionManager;
import com.capitalone.ease_qa.ui.atf.error.FixtureError;
import com.capitalone.ease_qa.ui.atf.selenium.WaitforConditionTimer;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.StepDefAnnotation;




@StepDefAnnotation
//@ContextConfiguration({"cucumber.xml" })
public class LoginStepDefs {
	
	
	
	//@Resource(name="uidriver")
	private ExtUiDriver driver;
	
	private AccountSummaryFixture accountSummary;
	private AccountDetailsFixture accountDetails;
	 
	//@Resource(name="loginfixture")
	private LoginPageFixture login;
	private AccountDetailsPage accountDetailsPage;
	public AbstractApplicationContext context = null;
	 
	 public LoginStepDefs() throws Exception{
	   // context = new ClassPathXmlApplicationContext("spring-chrome.xml");
	  //  driver = (ExtUIDriver) ctx.getBean("uidriver");
		  
		// driver = DriverManager.getInstance().getNewSession("browser","/localproperties/firefox.properties");
		 driver = SessionManager.getInstance().getNewSession("client","chrome.properties");
		 login =new LoginPageFixture(driver);
		 accountSummary = new AccountSummaryFixture(driver);
		 accountDetails = new AccountDetailsFixture(driver);
		 accountDetailsPage = new AccountDetailsPage(driver);
	 }
	 
	 @Given("^I`m on the easy login page$")
	 public void i_m_on_the_easy_login_page() throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
		 
		// http://awseasedev11web1.kdc.capitalone.com:8080/ease-ui/#/login");
		 
		 driver.getElementFactory().createWebPage().goToPage("https://ease-qa.kdc.capitalone.com/"); 
	 }

	 @When("^Enter the Username \"(.*?)\" and password \"(.*?)\"$")
	 public void enter_the_Username_and_password(String arg1, String arg2) throws Throwable {
		     login.enterUsername("al_user21");
		    login.enterPassword("abcd12345");
	 }

	 @When("^Click login$")
	 public void click_login() throws Throwable {
		 login.clickLogin();
	 }

	/* @Then("^I should be on account summary page$")
	 public void i_should_be_on_account_summary_page() throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
	     throw new PendingException();
	 }
	
	@Given("^I`m on the easy login page$")
	public void i_m_on_the_easy_login_page() throws Throwable {
	   
	
		
		// Write code here that turns the phrase above into concrete actions
	}

	@When("^Enter the Username \"(.*?)\" and password \"(.*?)\"$")
	public void enter_the_Username_and_password(String arg1, String arg2) throws Throwable {
	   
		
		// Write code here that turns the phrase above into concrete actions
    }

	@When("^Click login$")
	public void click_login() throws Throwable {
	    
		
		// Write code here that turns the phrase above into concrete actions
	  
	}*/

	@Then("^I should be on account summary page$")
	public void i_should_be_on_account_summary_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
/**
 *  Account Detials Step Def Begins 
 * 
 * 
 */


	
	    
	

	@Then("^I should be navigated to the Account details page$")
	public void i_should_be_navigated_to_the_Account_details_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(accountDetails.isAccountDetailsPage());
		
	    
	}

	@Then("^should be able to see account name, account balance title, transfer button and view details link$")
	public void should_be_able_to_see_account_name_account_balance_title_transfer_button_and_view_details_link() throws Throwable {
	  
		//Assert.assertTrue(accountDetailsPage.getAccountNumberOnHero().isElementExists());
		//Assert.assertTrue(accountDetailsPage.getTranferButtonOnHero().isElementExists());
		//Assert.assertTrue(accountDetailsPage.getViewDetailsHyperLink().isElementExists());
		//Assert.assertTrue(accountDetailsPage.getAccountNumberOnHero().isElementExists());
	}
  
	@Given("^I'm logged in to Ease on domain \"(.*?)\" with user \"(.*?)\" and password \"(.*?)\"$")
	public void i_m_logged_in_to_Ease_on_domain_with_user_and_password(String arg1, String arg2, String arg3) throws Throwable {
		  driver.getElementFactory().createWebPage().goToPage("https://ease-qa.kdc.capitalone.com/");
		   login.enterUsername(arg2);
		   login.enterPassword(arg3);
		   Thread.sleep(3000);
		   login.clickLogin();
	}

	@Given("^click on the Bank Account tile \"(.*?)\"$")
	public void click_on_the_Bank_Account_tile(String arg1) throws Throwable {
		 //Assert.assertTrue(accountSummary.isAccountSummary());
		   // if(arg1.equalsIgnoreCase("checking")){
		        Thread.sleep(3000);
		    	accountSummary.goToCheckingAccount();
		    
	}

	@Then("^click on view details link$")
	public void click_on_view_details_link() throws Throwable {
	   
		driver.waitUntil(new WaitforConditionTimer() {
			
			@Override
			public boolean ensure() {
				// TODO Auto-generated method stub
				try {
					return driver.getElementFactory().createHyperLink("viewDetailLink").isElementExists();
				} catch (FixtureError e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			}
		});
		driver.getElementFactory().createHyperLink("viewDetailLink").click();
		
		Thread.sleep(8000);
		
	}
	
	@After
	public void shutdowndriver(){
		driver.shutdown();
	}
	
	

}
