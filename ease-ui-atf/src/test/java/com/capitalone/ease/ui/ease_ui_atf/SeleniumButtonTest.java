/**
 * 
 */
package com.capitalone.ease.ui.ease_ui_atf;




import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.error.FixtureError;
import com.capitalone.ease_qa.ui.atf.selenium.TextElement;
import com.capitalone.ease_qa.ui.atf.selenium.WebPage;
import com.capitalone.ease_qa.ui.atf.selenium.Impl.SeleniumButton;
import com.capitalone.ease_qa.ui.atf.selenium.Impl.SeleniumTextBox;
import com.capitalone.ease_qa.ui.atf.selenium.Impl.SeleniumWebPage;

/**
 * @author gtg716
 *
 */
public class SeleniumButtonTest {
	
	private ExtUiDriver m_driver;
	
	@Before
	public void intializeDriver(){
	m_driver = TestDriver.getDriver();
	}
	
	@Test
	public void testSeleniumButtonGetText() throws FixtureError{
	  defaultTextBox();
	  Assert.assertEquals("Log in",new SeleniumButton(m_driver,"loginButton-button").getText());
	}
	
	@Test
	public void testSeleniumButtonClick() throws FixtureError{
		TextElement textBox = defaultTextBox();		 
		Assert.assertEquals( "testing button",textBox.getText());
		new SeleniumButton(m_driver, "loginButton-button").click();
		Assert.assertEquals( "clicked!",textBox.getText());
	 
	}
	@Test
	public void testButtonPressEnter() throws FixtureError {
		TextElement textBox = defaultTextBox();		 
		Assert.assertEquals(textBox.getText(), "testing button");
		new SeleniumButton(m_driver, "loginButton-button").pressEnter();
		Assert.assertEquals(textBox.getText(), "clicked!");
	}
	
	private TextElement defaultTextBox() throws FixtureError{
		WebPage page = new SeleniumWebPage(m_driver);
		page.goToPage(m_driver.getLocalResource("UnitTestPage.html"));
		TextElement textBox = new SeleniumTextBox(m_driver, "username_id");
		textBox.setText("testing button");
		return textBox;
	}
	
	@After
	public void shutDowndriver(){
		m_driver.shutdown();
	}
	
	
}
