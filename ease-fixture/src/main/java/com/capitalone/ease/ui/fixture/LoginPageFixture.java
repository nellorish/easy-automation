/**
 * 
 */
package com.capitalone.ease.ui.fixture;

import com.capitalone.ease.ui.pages.LoginPage;
import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.error.ElementTimeoutError;
import com.capitalone.ease_qa.ui.atf.error.FixtureError;
import com.capitalone.ease_qa.ui.atf.selenium.WaitforConditionTimer;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

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
		
//		 driver.waitUntil(new WaitforConditionTimer() {
//			
//			  @Override
//				public boolean ensure() {
//					try {
//						
//						if(!getLoginPage().getLoginPageTitle().equalsIgnoreCase("EASE | Login")){
//						return true;
//						}else{
//							getLoginPage().submitbutton().click();
//						}
//					} catch (FixtureError e) {
//					  
//					}
//				return false;
//				}
//			    });
	 }
	 public void goToBankPage() throws FixtureError{
		 getLoginPage().getBankTile().click();
	 }
	 
	 public String getTitle(){
		 return driver.getElementFactory().createWebPage().browserCaption();
	}
	 
	 public boolean isLoginPage(){
		 
		try {
			driver.waitUntil(new WaitforConditionTimer() {
				@Override
				public boolean ensure() {
					// TODO Auto-generated method stub
					return getTitle().contains("EASE | Login");
				}
			});
		} catch (ElementTimeoutError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return true;
	 }
}
