package org.qa_automation.ui.ease_ui_atf;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import org.qa_automation.ui.atf.driver.ExtUiDriver;
import org.qa_automation.ui.atf.error.FixtureError;
import org.qa_automation.ui.atf.error.MatchValueError;
import org.qa_automation.ui.atf.selenium.Element;
import org.qa_automation.ui.atf.selenium.Impl.SeleniumDropDown;
import org.qa_automation.ui.atf.selenium.Impl.SeleniumElementFactory;
import org.qa_automation.ui.atf.selenium.SelectableElement;
import org.qa_automation.ui.atf.selenium.WebPage;
import org.qa_automation.ui.atf.selenium.Impl.SeleniumWebPage;

public class SeleniumDropDownTest {


	private ExtUiDriver m_driver;


	@Test
	public void testFindOptionByValue() throws FixtureError {
		gotoTestPage();
		SelectableElement dropdown = new SeleniumDropDown(m_driver, "myDropdown");
		Assert.assertNotNull(dropdown.selectItemByValue("item1"));
	}

	@Test
	public void testOptionMatch() throws FixtureError {
		gotoTestPage();
		
		SelectableElement dropdown = new SeleniumDropDown(m_driver, "myDropdown");
		dropdown.selectItemByValue("item1");
		Assert.assertTrue(dropdown.isSelected());
	}

	@Test(expected = MatchValueError.class)
	public void testOptionNonMatch() throws FixtureError {
		gotoTestPage();
		SelectableElement dropdown = new SeleniumElementFactory(m_driver).createDropDown("myDropdown");
		dropdown.selectItemByValue("item3");
	}

	@Test
	public void testSelectItemInsanceType() throws FixtureError {
		gotoTestPage();
		SelectableElement dropdown = new SeleniumDropDown(m_driver, "myDropdown");
		Assert.assertTrue(dropdown.selectItemByValue("item1") instanceof Element);
	}

	@Test
	public void testElementNotExist() throws FixtureError {
		gotoTestPage();

		SelectableElement dropdown = new SeleniumElementFactory(m_driver).createDropDown("testme");

		Assert.assertFalse(dropdown.isElementExists());

		// dropdown.selectItemByValue("item3");
	}
	@Test(expected = MatchValueError.class)
	public void testElementExistOptionnotMatch() throws FixtureError {
		gotoTestPage();
		SelectableElement dropdown = new SeleniumElementFactory(m_driver)
				.createDropDown("myDropdown");
		Assert.assertTrue(dropdown.isElementExists());
		 dropdown.selectItemByValue("item3");

	}
	@Test(expected = MatchValueError.class)
	public void testElementNotExistOptionMatch() throws FixtureError {
		gotoTestPage();
		SelectableElement dropdown = new SeleniumElementFactory(m_driver)
				.createDropDown("testme");
		Assert.assertFalse(dropdown.isElementExists());
		Element e= dropdown.selectItemByValue("item3");
		Assert.assertNull(e);
	}
	private void gotoTestPage() {
		m_driver = TestDriver.getDriver();
		WebPage page = new SeleniumWebPage(m_driver);
		page.goToPage(m_driver.getLocalResource("UnitTestPage.html"));
	}
	
	@After
	public void shutdownDriver(){
		m_driver.shutdown();
	}

}
