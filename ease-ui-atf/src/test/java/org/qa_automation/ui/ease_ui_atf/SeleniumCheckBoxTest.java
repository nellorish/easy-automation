/**
 * 
 */
package org.qa_automation.ui.ease_ui_atf;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.qa_automation.ui.atf.driver.ExtUiDriver;
import org.qa_automation.ui.atf.error.UnImplementedException;
import org.qa_automation.ui.atf.error.FixtureError;
import org.qa_automation.ui.atf.error.MatchValueError;
import org.qa_automation.ui.atf.selenium.Element;
import org.qa_automation.ui.atf.selenium.SelectableElement;
import org.qa_automation.ui.atf.selenium.WebPage;
import org.qa_automation.ui.atf.selenium.Impl.SeleniumCheckBox;
import org.qa_automation.ui.atf.selenium.Impl.SeleniumWebPage;

/**
 * @author gtg716
 *
 */
public class SeleniumCheckBoxTest {


	private static ExtUiDriver m_driver;

	@Before
	public void setUpClass() throws FixtureError {
		m_driver = TestDriver.getDriver();
		
	}

	@Test
	public void testFindCheckBoxOptionByValue() throws FixtureError {
		gotoTestPage();
		SelectableElement checkBox = new SeleniumCheckBox(m_driver, "alert");
		Assert.assertNotNull(checkBox.selectItemByValue("true"));
	}

	@Test
	public void testOptionMatch() throws FixtureError {
		gotoTestPage();
		SelectableElement checkBox = new SeleniumCheckBox(m_driver, "alert");
		checkBox.selectItemByValue("true");
		Assert.assertTrue(checkBox.isSelected());
		Assert.assertEquals(checkBox.getSelectedValue(), "true");

	}

	@Test(expected = MatchValueError.class)
	public void testOptionNonMatch() throws FixtureError {
		gotoTestPage();
		SelectableElement checkBox = new SeleniumCheckBox(m_driver, "alert");
		checkBox.selectItemByValue("false");
	}

	@Test
	public void testSelectItemInsanceType() throws FixtureError {
		gotoTestPage();
		SelectableElement checkBox = new SeleniumCheckBox(m_driver, "alert");
		Assert.assertTrue(checkBox.selectItemByValue("true") instanceof Element);
	}

	private  void gotoTestPage() {
		WebPage page = new SeleniumWebPage(m_driver);
		page.goToPage(m_driver.getLocalResource("UnitTestPage.html"));
	}

	@Test(expected = UnImplementedException.class)
	public void testGetTextList() throws FixtureError {
		gotoTestPage();
		SelectableElement checkBox = new SeleniumCheckBox(m_driver, "alert");
		checkBox.getTextList();
	}

	
	@After
	public void shutdownDriver(){
		m_driver.shutdown();
	}
	
	

}
