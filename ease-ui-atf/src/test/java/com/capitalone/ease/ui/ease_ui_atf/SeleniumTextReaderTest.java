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
import com.capitalone.ease_qa.ui.atf.selenium.Element;
import com.capitalone.ease_qa.ui.atf.selenium.TextElement;
import com.capitalone.ease_qa.ui.atf.selenium.WebPage;
import com.capitalone.ease_qa.ui.atf.selenium.Impl.SeleniumElementFactory;
import com.capitalone.ease_qa.ui.atf.selenium.Impl.SeleniumTextReader;
import com.capitalone.ease_qa.ui.atf.selenium.Impl.SeleniumWebPage;

/**
 * @author gtg716
 *
 */
public class SeleniumTextReaderTest {

	private ExtUiDriver m_driver;

	@Before
	public void setUpClass() throws FixtureError {
		m_driver = TestDriver.getDriver();
		gotoTestPage();
	}

	@Test
	public void testCheckGetSelector() throws FixtureError {
		//gotoTestPage();
		Element divTag = new SeleniumTextReader(m_driver, "css:div.username_display");
		Assert.assertNotNull(divTag.getSelector(), "css:div.username_display");
	}

	@Test
	public void testRead_A_Div_Text_withCss_Selector() throws FixtureError {
		//gotoTestPage();
		TextElement divTag = new SeleniumTextReader(m_driver, "css:div.username_display");
		Assert.assertNotNull(divTag.getSelectorObject());
		Assert.assertEquals(divTag.getText(), "ease_checking360");

	}

	@Test
	public void testRead_A_Div_Text_withClassName_Selector() throws FixtureError {
		//gotoTestPage();
		TextElement divTag = new SeleniumTextReader(m_driver, "class:username_display");
		Assert.assertEquals(divTag.getText(), "ease_checking360");
	}

	@Test
	public void testRead_A_Div_Text_containText() throws FixtureError {
		//gotoTestPage();
		TextElement divTag = new SeleniumTextReader(m_driver, "class:username_display");
		Assert.assertTrue(divTag.containsText("checking360"));
	}

	@Test
	public void testIgnoreErrorOnFind() throws FixtureError {
		//gotoTestPage();
		Element divTag = new SeleniumTextReader(m_driver, "class:username1234");
		divTag.setIgnoreElementIfNotExist(true);
		Assert.assertNull(divTag.getSelectorObject());
	}

	
	@Test
	public void testWaitUntilToFindElement() throws FixtureError {
		//gotoTestPage();
		Element divTag = new SeleniumTextReader(m_driver, "css:div.username_display");
		//divTag.pauseFor(3);
		Assert.assertNotNull(divTag.getSelectorObject());
	}


	@Test
	public void testGetTexts() throws FixtureError {
		//gotoTestPage();
		TextElement reader = new SeleniumTextReader(m_driver, "css:div#rn_Multiline2WithAnsVars_6_Content ol > li > span.rn_Element2");
		Assert.assertEquals(reader.getTextList().size(), 3);
		Assert.assertEquals(reader.getTextList().get(2), "Temporary authorizations can remain on your account for up to 10 days. In the event of an error, only the merchant can remove the authorization.");
	}

	private void gotoTestPage() {
		WebPage page = new SeleniumWebPage(m_driver);
		page.goToPage(m_driver.getLocalResource("UnitTestPage.html"));
	}

	@Test
	public void testGetFormattedText() throws FixtureError {
		//gotoTestPage();
		TextElement e = new SeleniumElementFactory(m_driver).createTextReader("testPara");
		Assert.assertEquals(e.getFormattedText(), "This text is to Test the Formatted text tag");
	}
	
	@Test
	public void testIsElement_Visible() throws FixtureError {
		//gotoTestPage();
		TextElement divTag = new SeleniumTextReader(m_driver, "class:username_display");
		Assert.assertTrue(divTag.isElementVisible());
	}
	
	@After
	public void shutdownDriver(){
	  m_driver.shutdown();
	}
	
}
