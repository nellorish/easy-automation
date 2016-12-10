/**
 * 
 */
package org.qa_automation.ui.ease_ui_atf;

import org.qa_automation.ui.atf.driver.ExtUiDriver;
import org.qa_automation.ui.atf.error.UnImplementedException;
import org.qa_automation.ui.atf.selenium.Element;
import org.qa_automation.ui.atf.selenium.Impl.SeleniumWebElement;
import org.qa_automation.ui.atf.error.FixtureError;
import org.qa_automation.ui.atf.error.InvalidSelectorError;
import org.qa_automation.ui.atf.selenium.Impl.SeleniumDriver;
import org.qa_automation.ui.atf.selenium.MatchCallback;
import org.qa_automation.ui.atf.selenium.WaitforConditionTimer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author gtg716
 *
 */
@RunWith(value = BlockJUnit4ClassRunner.class)
public class SeleniumDriverTest {
	
	@Rule
	public ExpectedException selectorthrown = ExpectedException.none();

	ExtUiDriver driver;
	@Before
	public void setUp() {
		driver = new SeleniumDriver(new HtmlUnitDriver());
	}

	@Test
	public void testActualWebDriver() throws FixtureError {
		Assert.assertNotNull(driver );

	}

	@Test(expected = InvalidSelectorError.class)
	public void testFindSelectorNull() throws FixtureError {
		driver.findElement(new SeleniumWebElement(driver));
	}

	@SuppressWarnings("deprecation")
	//@Test
	public void testCheckDefaultWaitTime() {
		Element element = new SeleniumWebElement(driver);
		//Assert.assertEquals(element.getWaitTime(), -1);
	}

	@Test
	public void testFindElementWithSelector() throws FixtureError {
		final Element aTestElement = new SeleniumWebElement(driver);
		ExtUiDriver driver = new SeleniumDriver(new HtmlUnitDriver()) {
			@Override
			protected Object getElement(String selector) {
				Assert.assertEquals(selector, "myselector");
				return Mockito.mock(WebElement.class);
			}
		};

		aTestElement.setSelector("myselector");
		Assert.assertNotNull(driver.findElement(aTestElement));
	}

	@Test(expected = FixtureError.class)
	public void testFindElementWithSeleniumException() throws FixtureError {
		final Element aTestElement = new SeleniumWebElement(driver);
		ExtUiDriver driver = new SeleniumDriver(new HtmlUnitDriver()) {
			@Override
			protected Object getElement(String selector) {
				throw new org.openqa.selenium.TimeoutException();
			}

		};

		aTestElement.setSelector("myselector");

		driver.findElement(aTestElement);
	}

	@Test
	public void testFindElementsListWithSelector() throws FixtureError {
		  driver = new SeleniumDriver(new HtmlUnitDriver()) {

			@SuppressWarnings("rawtypes")
			protected List getElements(String selector) {
				List<WebElement> aList = new ArrayList<WebElement>();
				aList.add(Mockito.mock(WebElement.class));
				aList.add(Mockito.mock(WebElement.class));
				aList.add(Mockito.mock(WebElement.class));
				Mockito.when(aList.get(0).getText()).thenReturn("1");
				Mockito.when(aList.get(1).getText()).thenReturn("2");
				Mockito.when(aList.get(2).getText()).thenReturn("3");
				return aList;
			}
		};
		MatchCallback callBack = new MatchCallback() {

			public boolean isMatchFound(Object webObject, String selector) {
				WebElement we = (WebElement) webObject;
				return we.getText().equals(selector);
			}
		};
		Element aTestElement = new SeleniumWebElement(driver);
		aTestElement.setSelector("2");
		WebElement we = (WebElement) driver.findElement(aTestElement, callBack);
		Assert.assertNotNull(we);
		Assert.assertEquals(we.getText(), "2");
	}

    @Test(expected = MockitoException.class)
        public void testClose() {
	     WebDriver aWebDriver = Mockito.mock(WebDriver.class);
		Mockito.doThrow(new UnImplementedException()).when(aWebDriver).close();
		ExtUiDriver driver = new SeleniumDriver(aWebDriver);
		driver.close();
	}

	@Test
	public void testWaitUntil() throws FixtureError {
		final Element aTestElement = new SeleniumWebElement(driver);
		  driver = new SeleniumDriver(new HtmlUnitDriver()) {
			@Override
			protected Object getElement(String selector) {
				Assert.assertEquals(selector, "myselector");
				return Mockito.mock(WebElement.class);
			}
		};

		aTestElement.setSelector("myselector");
		driver.waitUntil(  new WaitforConditionTimer() {


			public boolean ensure()  {

				return aTestElement!=null;
			}
		} );


	}

        @Test
	public void testCloseActiveWindow() {
		WebDriver aWebDriver = Mockito.mock(WebDriver.class);
		ExtUiDriver driver = new SeleniumDriver(aWebDriver);

                Mockito.when(aWebDriver.getWindowHandle()).thenReturn("mainHandle");
                WebDriver.TargetLocator targetLocator=Mockito.mock( WebDriver.TargetLocator.class);
                Mockito.when(aWebDriver.switchTo()).thenReturn(targetLocator);
                Set<String> handles= new HashSet<String>();
                handles.add("activeHandle");

                Mockito.when(aWebDriver.getWindowHandles()).thenReturn(handles);
                Mockito.when(targetLocator.window("mainHandle")).thenReturn(aWebDriver );
                Mockito.when(targetLocator.window("activeHandle")).thenReturn(aWebDriver );

		driver.closeActiveWindow();
                Assert.assertEquals(aWebDriver.getWindowHandle(),"mainHandle" );
	}
        @Test
	public void testSwithcToActiveWindow() throws InterruptedException {
		WebDriver aWebDriver = Mockito.mock(WebDriver.class);
		ExtUiDriver driver = new SeleniumDriver(aWebDriver);

                WebDriver.TargetLocator targetLocator=Mockito.mock( WebDriver.TargetLocator.class);
                WebDriver.Options options=Mockito.mock( WebDriver.Options.class);
                WebDriver.Window window=Mockito.mock( WebDriver.Window.class);

                Mockito.when(aWebDriver.switchTo()).thenReturn(targetLocator);
                Set<String> handles= new HashSet<String>();
                handles.add("firstHandle");
                handles.add("secondHandle");
                Mockito.when(aWebDriver.getWindowHandles()).thenReturn(handles);
                Mockito.when(aWebDriver.manage()).thenReturn(options);
                Mockito.when(options.window()).thenReturn(window );
                Mockito.when(targetLocator.window(Mockito.anyString())).thenReturn(aWebDriver );
                Mockito.doNothing().when(window).maximize();

		driver.switchToActiveWindow();
	}
        

	

}
