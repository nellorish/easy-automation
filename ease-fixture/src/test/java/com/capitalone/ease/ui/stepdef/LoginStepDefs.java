package com.capitalone.ease.ui.stepdef;

import org.springframework.context.support.AbstractApplicationContext;

import com.capitalone.ease.ui.fixture.LoginPageFixture;
import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.error.FixtureError;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.StepDefAnnotation;




@StepDefAnnotation
//@ContextConfiguration({"cucumber.xml" })
public class LoginStepDefs {
	
	
	//@Resource(name="uidriver")
	private ExtUiDriver driver;
	 
	//@Resource(name="loginfixture")
	private LoginPageFixture login;
	public AbstractApplicationContext context = null;
	 
	 public LoginStepDefs() throws FixtureError{
	   // context = new ClassPathXmlApplicationContext("spring-chrome.xml");
	  //  driver = (ExtUIDriver) ctx.getBean("uidriver");
		//login =new LoginPageFixture(driver);
		 
		// driver = DriverManager.getInstance().getNewSession("browser","/localproperties/firefox.properties");
	 }
	 
	 @Given("^I`m on the easy login page$")
	 public void i_m_on_the_easy_login_page() throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
		 driver.getElementFactory().createWebPage().goToPage("http://awseasedev11web1.kdc.capitalone.com:8080/ease-ui/#/login"); 
	 }

	 @When("^Enter the Username \"(.*?)\" and password \"(.*?)\"$")
	 public void enter_the_Username_and_password(String arg1, String arg2) throws Throwable {
		     login.enterUsername("easeweb_113");
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

}
