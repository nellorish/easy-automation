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
import com.capitalone.ease_qa.ui.atf.selenium.WebPage;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class LoginStepDefs {
	
	private ExtUiDriver driver;
	private AccountSummaryFixture accountSummary;
	private AccountDetailsFixture accountDetails;
	private LoginPageFixture login;
	private AccountDetailsPage accountDetailsPage;
	public AbstractApplicationContext context = null;
	private static final String QA ="https://ease-qa6.kdc.capitalone.com/";
	private static final String DEV="http://awseasedev14web1.kdc.capitalone.com:8080/ease-ui/#/login";
	
	
	 
	 public LoginStepDefs() throws Exception{
	  
		 driver = SessionManager.getInstance().getNewSession("client","chrome.properties");
		 login =new LoginPageFixture(driver);
		 accountSummary = new AccountSummaryFixture(driver);
		 accountDetails = new AccountDetailsFixture(driver);
		 accountDetailsPage = new AccountDetailsPage(driver);
	 }
	 
	 @Given("^I`m on the easy login page$")
	 public void i_m_on_the_easy_login_page() throws Throwable {
		 driver.maximizeWindow();
	     WebPage page = driver.getElementFactory().createWebPage();
	     page.goToPage(DEV); 
	 }

	 @When("^Enter the Username \"(.*?)\" and password \"(.*?)\"$")
	 public void enter_the_Username_and_password(String uname, String password) throws FixtureError {
		     login.enterUsername(uname);
		    login.enterPassword(password);
	 }

	 @When("^Click login$")
	 public void click_login() throws Throwable {
		 login.clickLogin();
	 }

	@Then("^I should be on account summary page$")
	public void i_should_be_on_account_summary_page() throws FixtureError {
		
		Assert.assertTrue(accountSummary.isAccountSummaryPage());
	   
	}

/**
 *  Account Detials Step Def Begins 
 * 
 * 
 */
    @Then("^I should be navigated to the Account details page$")
	public void i_should_be_navigated_to_the_Account_details_page() throws FixtureError {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(accountDetails.isAccountDetailsPage());
		
	    
	}

	@Then("^should be able to see account name, account balance title, transfer button and view details link$")
	public void should_be_able_to_see_account_name_account_balance_title_transfer_button_and_view_details_link() throws FixtureError {
	  
		//Assert.assertTrue(accountDetailsPage.getAccountNumberOnHero().isElementExists());
		Assert.assertTrue(accountDetailsPage.getTranferButtonOnHero().isElementExists());
		Assert.assertTrue(accountDetailsPage.getViewDetailsHyperLink().isElementExists());
		//Assert.assertTrue(accountDetailsPage.getAccountNumberOnHero().isElementExists());
	}
  
	@Given("^I'm logged in to Ease on domain \"(.*?)\" with user \"(.*?)\" and password \"(.*?)\"$")
	public void i_m_logged_in_to_Ease_on_domain_with_user_and_password(String arg1, String arg2, String arg3) throws FixtureError {
		  driver.getElementFactory().createWebPage().goToPage(DEV);
		   login.enterUsername(arg2);
		   login.enterPassword(arg3);
		   login.clickLogin();
		  
	}

	@Given("^click on the Bank Account tile \"(.*?)\"$")
	public void click_on_the_Bank_Account_tile(String arg1) throws FixtureError {
		//Assert.assertTrue(accountSummary.isAccountSummaryPage());
		if(arg1.equalsIgnoreCase("checking")){
		       accountSummary.goToCheckingAccount();
          }else {
        	  accountSummary.goToSavingAccount();
          }
	}

	@Then("^click on view details link$")
	public void click_on_view_details_link() throws Throwable {
		accountDetails.clickOnViewDetails();
	}
	
	@When("^view details modal windows is visible$")
	public void view_details_modal_windows_is_visible() throws Throwable {
	  
		Assert.assertTrue(accountDetails.isViewDetialsPageVisible());
	    
	}

	@Then("^verify \"(.*?)\"and \"(.*?)\"and \"(.*?)\" and \"(.*?)\"and\"(.*?)\"$")
	public void verify_and_and_and_and(String accountNumber, String routingNumber, String primaryAccountHolderName, String APY, String YearInterest) throws Throwable {
	   Assert.assertEquals(accountDetails.getAccountNumberOnViewDetailsModal(),accountNumber);
	   Assert.assertEquals(accountDetails.getRoutingNumberOnViewDetailsModal(),routingNumber);
	   Assert.assertEquals(accountDetails.getPrimaryAccountNameOnViewDetailsPage(),primaryAccountHolderName);
	   Assert.assertEquals(accountDetails.getAnnualAPROnViewDetails(),APY);
	   Assert.assertEquals(accountDetails.getYearlyInterestOnViewDetails(),YearInterest);
	    
	}

	@Then("^close view details$")
	public void close_view_details() throws FixtureError, InterruptedException {
	    accountDetails.closeViewDetials();

	   
	}

	@Then("^go to other account from account details\"(.*?)\"$")
	public void go_to_other_account_from_account_details(String accountType) throws Throwable {
	   accountDetails.gotoOtherAccountFromAccountDetails(accountType);
	   
	}
	
	@And("^go to \"(.*?)\" account from account details$")
	public void go_to_account_from_account_details(String accountType) throws Throwable {
		 accountDetails.gotoOtherAccountFromAccountDetails(accountType);
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	@Then("^go back to account summary page$")
	public void go_back_to_account_summary_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   accountDetails.clickOnBackButtonOnAccountDetails();
	}

	@When("^I`m on account summary page$")
	public void i_m_on_account_summary_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertTrue(accountSummary.isAccountSummaryPage());
	}

	@Then("^signout$")
	public void signout() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  // accountSummary.ClickOnProfileInformation();
	   accountSummary.signOutfromAccountDetails();
	}
	
	@Then("^I should be on login page$")
	public void i_should_be_on_login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertTrue(login.isLoginPage());
	}

	@After
	public void shutdowndriver(){
		driver.shutdown();
	}
	
	

}
