package com.capitalone.ease.ui.pages;

import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.selenium.ActionElement;
import com.capitalone.ease_qa.ui.atf.selenium.TextElement;

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
		return driver.getElementFactory().createTextElement("pw");
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
