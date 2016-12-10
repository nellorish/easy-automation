/**
 * 
 */
package org.qa_automation.ui.ease_ui_atf;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.qa_automation.ui.atf.driver.ExtUiDriver;
import org.qa_automation.ui.atf.error.FixtureError;
import org.qa_automation.ui.atf.selenium.ActionElement;
import org.qa_automation.ui.atf.selenium.Impl.SeleniumElementFactory;
import org.qa_automation.ui.atf.selenium.Impl.SeleniumTextBox;
import org.qa_automation.ui.atf.selenium.TextElement;
import org.qa_automation.ui.atf.selenium.WebPage;
import org.qa_automation.ui.atf.selenium.Impl.SeleniumWebPage;

/**
 * @author gtg716
 *
 */
public class SeleniumHyperLinkTest {

	private ExtUiDriver m_driver;

	@Before
	public void setUpClass() throws FixtureError {
		m_driver = TestDriver.getDriver();		
	}

	@Test
	public void testHyperLinkClick() throws FixtureError {
		TextElement textBox = setDefaultText();
		Assert.assertEquals(textBox.getText(), "testing hyper link");
		new SeleniumElementFactory(m_driver).createHyperLink("myLink").click();
		Assert.assertEquals(textBox.getText(), "clicked!");
	}

	@Test
	public void testHyperLinkPressEnter() throws FixtureError {
		TextElement textBox = setDefaultText();
		Assert.assertEquals(textBox.getText(), "testing hyper link");
		new SeleniumElementFactory(m_driver).createHyperLink("myLink").click();
		Assert.assertEquals(textBox.getText(), "clicked!");
	}

	@Test
	public void testHyperLinkGetText() throws FixtureError {
		setDefaultText();
		ActionElement e = new SeleniumElementFactory(m_driver).createHyperLink("myLink");
		Assert.assertEquals(e.getText(), "link text");
	}

	@Test
	public void testHyperLinkGetTextUsingXpath() throws FixtureError {
		setDefaultText();
		ActionElement e = new SeleniumElementFactory(m_driver).createHyperLink("xpath://a[@id='myLink']");
		Assert.assertEquals(e.getText(), "link text");
	}
	
	@Test
	public void testGetHypeLinkWithPartialText() throws FixtureError {
		
		setDefaultText();
		ActionElement e = new SeleniumElementFactory(m_driver).createHyperLink("partiallink:partial");
		
		Assert.assertEquals(e.getHtmlAttribute("href"), "https://pulse.kdc.capitalone.com/welcome");
		Assert.assertEquals(e.isElementExists(), true);
		
	}

	private TextElement setDefaultText() throws FixtureError {
		WebPage page = new SeleniumWebPage(m_driver);
		page.goToPage(m_driver.getLocalResource("UnitTestPage.html"));
		TextElement textBox = new SeleniumTextBox(m_driver, "username_id");
		textBox.setText("testing hyper link");
		return textBox;
	}
	
	@Test
	public void testHyperLinkGetFormattedText() throws FixtureError {
		setDefaultText();
		ActionElement e = new SeleniumElementFactory(m_driver).createHyperLink("testLink");
		Assert.assertEquals(e.getFormattedText(), "Test Link");
	}
	
	@After
	public void shutDownDriver(){
		m_driver.shutdown();
	}
}
