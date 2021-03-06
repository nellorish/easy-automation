/**
 * 
 */
package org.qa_automation.ui.ease_ui_atf;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.qa_automation.ui.atf.driver.ExtUiDriver;
import org.qa_automation.ui.atf.error.MatchValueError;
import org.qa_automation.ui.atf.selenium.Element;
import org.qa_automation.ui.atf.selenium.Impl.SeleniumElementFactory;
import org.qa_automation.ui.atf.selenium.Impl.SeleniumRadioButton;
import org.qa_automation.ui.atf.selenium.WebPage;
import org.qa_automation.ui.atf.error.FixtureError;
import org.qa_automation.ui.atf.selenium.SelectableElement;
import org.qa_automation.ui.atf.selenium.Impl.SeleniumWebPage;

/**
 * @author gtg716
 *
 */
public class SeleniumRadioButtonTest {



	private ExtUiDriver m_driver;

	@Before
	public void setUpClass() throws FixtureError {
		m_driver = TestDriver.getDriver();
	}

	@Test
	public void testFindRadioOptionByValue() throws FixtureError {
		gotoTestPage();
		SelectableElement radioGroup = new SeleniumRadioButton(m_driver, "status");
		Assert.assertNotNull(radioGroup.selectItemByValue("closed"));
	}

	@Test
	public void testOptionGetValueNoMatch() throws FixtureError {
		gotoTestPage();
		SelectableElement radioGroup = new SeleniumRadioButton(m_driver, "status");
		Assert.assertNull(radioGroup.getSelectedValue());
	}

	@Test
	public void testOptionMatch() throws FixtureError {
		gotoTestPage();
		SelectableElement radioGroup = new SeleniumRadioButton(m_driver, "status");
		radioGroup.selectItemByValue("closed");
		Assert.assertTrue(radioGroup.isSelected());
		Assert.assertEquals(radioGroup.getSelectedValue(), "closed");

	}

	@Test(expected = MatchValueError.class)
	public void testOptionNonMatch() throws FixtureError {
		gotoTestPage();
		SelectableElement radioGroup = new SeleniumElementFactory(m_driver).createRadioButton("status");
		radioGroup.selectItemByValue("closed12");
	}

	@Test
	public void testSelectItemInsanceType() throws FixtureError {
		gotoTestPage();
		SelectableElement radioGroup = new SeleniumRadioButton(m_driver, "status");
		Assert.assertTrue(radioGroup.selectItemByValue("open") instanceof Element);
	}

	private void gotoTestPage() {
		WebPage page = new SeleniumWebPage(m_driver);
		page.goToPage(m_driver.getLocalResource("UnitTestPage.html"));
	}

	@Test
	public void testGetTextList() throws FixtureError {
		gotoTestPage();
		SelectableElement radioGroup = new SeleniumRadioButton(m_driver, "status");
		Assert.assertEquals(2,radioGroup.getTextList().size());
	}

	@After
	public void shutdownDriver(){
		m_driver.shutdown();
	}
	
	
	
}
