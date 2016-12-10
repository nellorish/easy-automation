package org.qa_automation.ui.pages;

import org.qa_automation.ui.atf.driver.ExtUiDriver;
import org.qa_automation.ui.atf.selenium.TextElement;
import org.qa_automation.ui.atf.selenium.ActionElement;

public class LoginPage {
	
	private ExtUiDriver driver;
	
	public LoginPage(ExtUiDriver driver){
		this.driver = driver;
	}
	
	
	public TextElement getUsernameTextBox(){
		return driver.getElementFactory().createTextElement("uname");
	}
    
	public TextElement getPasswordTextBox(){
		//return driver.getElementFactory().createTextElement("xpath://input[@id='formly_1_input_pw_1']");
		return driver.getElementFactory().createTextElement("pw_TLNPI");
	}
    
	public ActionElement submitbutton(){
		return driver.getElementFactory().createButton("login-start-button");
	}
	
	public ActionElement getBankTile(){
		return driver.getElementFactory().createButton("class:bal");
	}
	
	public String getLoginPageTitle(){
		
		return driver.getElementFactory().createWebPage().browserCaption();
	}
	
}
