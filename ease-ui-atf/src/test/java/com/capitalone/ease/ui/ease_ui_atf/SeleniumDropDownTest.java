package com.capitalone.ease.ui.ease_ui_atf;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.capitalone.ease_qa.ui.atf.driver.ExtUiDriver;
import com.capitalone.ease_qa.ui.atf.error.FixtureError;
import com.capitalone.ease_qa.ui.atf.error.MatchValueError;
import com.capitalone.ease_qa.ui.atf.error.UnImplementedException;
import com.capitalone.ease_qa.ui.atf.selenium.Element;
import com.capitalone.ease_qa.ui.atf.selenium.SelectableElement;
import com.capitalone.ease_qa.ui.atf.selenium.WebPage;
import com.capitalone.ease_qa.ui.atf.selenium.Impl.SeleniumDropDown;
import com.capitalone.ease_qa.ui.atf.selenium.Impl.SeleniumElementFactory;
import com.capitalone.ease_qa.ui.atf.selenium.Impl.SeleniumRadioButton;
import com.capitalone.ease_qa.ui.atf.selenium.Impl.SeleniumWebPage;

public class SeleniumDropDownTest {


	private static ExtUiDriver m_driver;

	@BeforeClass
	public static void setUpClass() throws FixtureError {
		m_driver = TestDriver.getDriver();
		WebPage page = new SeleniumWebPage(m_driver);
		page.goToPage(m_driver.getLocalResource("UnitTestPage.html"));
	}

	@Test
	public void testFindOptionByValue() throws FixtureError {
		//gotoTestPage();
		SelectableElement dropdown = new SeleniumDropDown(m_driver, "myDropdown");
		Assert.assertNotNull(dropdown.selectItemByValue("item1"));
	}

	@Test
	public void testOptionMatch() throws FixtureError {
		//gotoTestPage();
		SelectableElement dropdown = new SeleniumDropDown(m_driver, "myDropdown");
		dropdown.selectItemByValue("item1");
		Assert.assertTrue(dropdown.isSelected());
	}

    @Test(expected = UnImplementedException.class)
	public void testOptionGetValueNoMatch() throws FixtureError {
		//gotoTestPage();
		SelectableElement radioGroup = new SeleniumRadioButton(m_driver, "nothing");
		radioGroup.getSelectedValue();	 		
	}
	
	
	@Test(expected = MatchValueError.class)
	public void testOptionNonMatch() throws FixtureError {
		//gotoTestPage();
		SelectableElement dropdown = new SeleniumElementFactory(m_driver).createDropDown("myDropdown");
		dropdown.selectItemByValue("item3");
	}

	@Test
	public void testSelectItemInsanceType() throws FixtureError {
		//gotoTestPage();
		SelectableElement dropdown = new SeleniumDropDown(m_driver, "myDropdown");
		Assert.assertTrue(dropdown.selectItemByValue("item1") instanceof Element);
	}

	@Test
	public void testElementNotExist() throws FixtureError {
		//gotoTestPage();

		SelectableElement dropdown = new SeleniumElementFactory(m_driver).createDropDown("testme");

		Assert.assertFalse(dropdown.isElementExists());

		// dropdown.selectItemByValue("item3");
	}
	@Test(expected = MatchValueError.class)
	public void testElementExistOptionnotMatch() throws FixtureError {
		//gotoTestPage();
		SelectableElement dropdown = new SeleniumElementFactory(m_driver)
				.createDropDown("myDropdown");
		Assert.assertTrue(dropdown.isElementExists());
		 dropdown.selectItemByValue("item3");

	}
	@Test(expected = MatchValueError.class)
	public void testElementNotExistOptionMatch() throws FixtureError {
		//gotoTestPage();
		SelectableElement dropdown = new SeleniumElementFactory(m_driver)
				.createDropDown("testme");
		Assert.assertFalse(dropdown.isElementExists());
		Element e= dropdown.selectItemByValue("item3");
		Assert.assertNull(e);
	}
	private void gotoTestPage() {
		WebPage page = new SeleniumWebPage(m_driver);
		page.goToPage(m_driver.getLocalResource("UnitTestPage.html"));
	}


}
