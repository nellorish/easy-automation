package org.qa_automation.ui.ease_ui_atf;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.qa_automation.ui.atf.driver.ExtUiDriver;
import org.qa_automation.ui.atf.error.FixtureError;
import org.qa_automation.ui.atf.selenium.ActionElement;
import org.qa_automation.ui.atf.selenium.Impl.SeleniumTextBox;
import org.qa_automation.ui.atf.selenium.TextElement;
import org.qa_automation.ui.atf.selenium.WaitforConditionTimer;
import org.qa_automation.ui.atf.selenium.WebPage;
import org.openqa.selenium.Keys;

import org.qa_automation.ui.atf.selenium.Impl.SeleniumWebPage;

public class SeleniumTextBoxTest {


	private ExtUiDriver m_driver;

	@Before
	public void setUpClass() throws FixtureError {
		m_driver = TestDriver.getDriver();
		WebPage page = new SeleniumWebPage(m_driver);
		page.goToPage(m_driver.getLocalResource("UnitTestPage.html"));
	}

	

	@Test
	public void testGetText() throws FixtureError {

		TextElement textBox = new SeleniumTextBox(m_driver, "username1");
		Assert.assertNotNull(textBox.getSelectorObject());
		Assert.assertEquals(textBox.getText(), "username1");

		textBox.setSelector("username2");
		Assert.assertNotNull(textBox.getSelectorObject());
		Assert.assertEquals(textBox.getText(), "username2");
	}

	@Test
	public void testSetText() throws FixtureError {
		TextElement textBox = new SeleniumTextBox(m_driver, "username1");
		textBox.setText("martin");
		Assert.assertEquals(textBox.getText(), "martin");
	}

	@Test//(expected=FixtureError.class)
	public void testFocus() throws FixtureError {
		TextElement textBox = new SeleniumTextBox(m_driver, "username1");
        textBox.setFocus(Keys.ENTER);
		textBox.setText("martin");

	}

	@Test
	public void testTextBoxPlaceHolder() throws FixtureError {
		TextElement textBox = new SeleniumTextBox(m_driver, "username1");
		Assert.assertEquals(textBox.getHtmlAttribute("placeholder"),
				"Enter your username");
	}

	@Test
	public void testThrowExceptionIfElementNotExist() throws FixtureError {
		TextElement textBox = new SeleniumTextBox(m_driver, "username1232323");

		try {
			Assert.assertNull(textBox.getSelectorObject());
		} catch (FixtureError e) {

		}
	}

	@Test
	public void testIgnoreElementIfNotExist() throws FixtureError {
		TextElement textBox = new SeleniumTextBox(m_driver, "username1232323");
		textBox.setIgnoreElementIfNotExist(true);
		Assert.assertNull(textBox.getSelectorObject());
	}

	@Test
	public void testIsElementExists_InvalidId() throws FixtureError {
		TextElement textBox = new SeleniumTextBox(m_driver, "username1232323");
		Assert.assertFalse(textBox.isElementExists());
	}

	@Test
	public void testIsElementExists_ValidId() throws FixtureError {
		TextElement textBox = new SeleniumTextBox(m_driver, "username1");
		Assert.assertTrue(textBox.isElementExists());
	}

	@Test
	public void testElementCssValue() throws FixtureError {
		TextElement textBox = new SeleniumTextBox(m_driver, "username1");
		Assert.assertEquals(textBox.getCssValue("font-size"), "12px");
	}

	@Test
	public void testElementHtmlAttribute() throws FixtureError {
		TextElement textBox = new SeleniumTextBox(m_driver, "username1");
		Assert.assertEquals(textBox.getHtmlAttribute("name"), "username1");
	}
	@Test
	public void testAsLink() throws FixtureError {
		TextElement textBox = new SeleniumTextBox(m_driver, "username1");
		Assert.assertNotNull(textBox.getSelectorObject());
		ActionElement clickableText = textBox.asLink();
		Assert.assertNotNull(clickableText.getSelectorObject());
		clickableText.click();

	}

	@Test
	public void testWaitUntil() throws FixtureError {
		TextElement textBox = new SeleniumTextBox(m_driver, "username1");
		Assert.assertNotNull(textBox.getSelectorObject());
		final ActionElement clickableText = textBox.asLink();
		Assert.assertNotNull(clickableText.getSelectorObject());

		m_driver.waitUntil(new WaitforConditionTimer() {
			
			@Override
			public boolean ensure() {

				try {
					return clickableText.isElementExists();
				} catch (FixtureError e) {
 
					e.printStackTrace();
				}
				return false;
			}
		});
	}
	@Test(expected=FixtureError.class)
	public void testWaitUntil_Timeout() throws FixtureError {
		TextElement textBox = new SeleniumTextBox(m_driver, "username1");
		Assert.assertNotNull(textBox.getSelectorObject());
		final ActionElement clickableText = textBox.asLink();
		Assert.assertNotNull(clickableText.getSelectorObject());

		m_driver.waitUntil(new WaitforConditionTimer() {
			@Override
			public boolean ensure() {
				System.out.println("Trying...");
				return false;
			}
		});

	}
	
	
	@After
	public void shutdownDriver(){
		m_driver.shutdown();
	}


}
