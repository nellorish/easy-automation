/**
 * 
 */
package com.capitalone.ease.ui.fixture;

import com.capitalone.ease.ui.pages.LoginPage;
import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.error.FixtureError;

/**
 * @author gtg716
 *
 */
public class LoginPageFixture {
	
//	@Resource(name="uidriver")
	private ExtUiDriver driver;
	private LoginPage login;
	
	public LoginPageFixture(){
		
	}
	
	 public LoginPageFixture(ExtUiDriver driver){
		 this.driver = driver;
	 }
	 
	public LoginPage getLoginPage(){
		if(login==null){
			login = new LoginPage(driver);
		}
		return login;
	}

	 
	 public void enterUsername(String userName) throws FixtureError{
		 
	       getLoginPage().getUsernameTextBox().setText(userName);
		 
	}
	 
	 public void enterPassword(String password) throws FixtureError{
		 getLoginPage().getPasswordTextBox().setText(password);
	 }
	 
	 public void clickLogin() throws FixtureError{
		 getLoginPage().submitbutton().click();
	 }
	 public void goToBankPage() throws FixtureError{
		 getLoginPage().getBankTile().click();
	 }
	 
	 public String getTitle(){
		 return driver.getElementFactory().createWebPage().browserCaption();
	}
}
