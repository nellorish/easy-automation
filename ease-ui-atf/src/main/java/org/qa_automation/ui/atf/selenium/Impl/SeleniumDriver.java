package org.qa_automation.ui.atf.selenium.Impl;

import org.qa_automation.ui.atf.driver.ExtUiDriver;
import org.qa_automation.ui.atf.error.UnImplementedException;
import org.qa_automation.ui.atf.selenium.Element;
import org.qa_automation.ui.atf.error.ElementTimeoutError;
import org.qa_automation.ui.atf.error.FixtureError;
import org.qa_automation.ui.atf.error.InvalidSelectorError;
import org.qa_automation.ui.atf.selenium.ElementFactory;
import org.qa_automation.ui.atf.selenium.MatchCallback;
import org.qa_automation.ui.atf.selenium.WaitforConditionTimer;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 * 
 * @author gtg716
 *
 */

public class SeleniumDriver implements ExtUiDriver {


	    private final Logger LOG = LoggerFactory.getLogger(SeleniumDriver.class);
		private final static int MAX_RETRY = 2000;
		private final static int GRACE_RETRY = 10;
		private final static int POLLING_INTERVAL_MILLI_SEC = 10;// 15*500=7500=7.5sec
		private final WebDriver m_webDriver;
		private String m_defaultFileResourceLocation;

		public SeleniumDriver(WebDriver driver) {
			m_webDriver = driver;
		}
		

		/**
		 * Returns the internal selenium driver instance.
		 *
		 * @return
		 */
		public WebDriver getWebDriver() {
			return m_webDriver;
		}

		/*
		 * Find a web element for the given selector of id/name
		 *
		 * @see
		 * 
		 */
		//@Override
		public WebElement findElement(Element element, MatchCallback callBack)
				throws FixtureError {
			try {
				return findElement(element.getSelector(),
						element.isIgnoreElementIfNotExist(), callBack);
			} catch (InvalidSelectorError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		
		
		
	  // @Override
		public WebElement findElement(Element element) throws FixtureError {
	    	
			try {
				return findElement(element.getSelector(),
						element.isIgnoreElementIfNotExist(), null);
			} catch (InvalidSelectorError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			throw new InvalidSelectorError(null);
		}

		
		@SuppressWarnings("rawtypes")
		private WebElement findElement(String selector, boolean ignoreIfNotExist,
				MatchCallback callBack) throws FixtureError, InvalidSelectorError {
			LOG.debug("Entering into the findElement method : " + selector);

			if (selector == null) {
				throw new InvalidSelectorError("selector is null");
			}

			Object element = null;
			int retryCount = 0;
			long diff_milles=0;
			 Date seconds = new Date();
			
			while (retryCount <= MAX_RETRY) {
                   retryCount++;
				try {

					if (callBack == null) {
						element = getElement(selector);
					} else {
						List elements = getElements(selector);
						for (Object webObject : elements) {
							if (callBack.isMatchFound(webObject, selector)) {
								element = webObject;
								break;
							}
						}
					}
				} catch (org.openqa.selenium.NoSuchElementException e) {

				} catch (org.openqa.selenium.WebDriverException e) {
					throw new FixtureError(e.getMessage());
				} catch (Exception e) {
					throw new FixtureError(e.getMessage());
				}

				if ((element != null) || (callBack != null)) {
					break;
				} else {
					diff_milles = new Date().getTime()/1000 % 60 - seconds.getTime()/1000 % 60;
					if ((ignoreIfNotExist)|| (diff_milles >= POLLING_INTERVAL_MILLI_SEC)) {
						break;
					}
				}
			}
			int totalTimeTaken = (retryCount * POLLING_INTERVAL_MILLI_SEC);
			if (totalTimeTaken != 0) {
				LOG.info("time taken to find element: +" + selector + " - "
						+ totalTimeTaken + " ms");
			}
			if (element == null) {
				String errorMsg = "findElement could not find selector: "
						+ selector;
				
				if ((!ignoreIfNotExist) && (callBack == null)) {
					throw new FixtureError(errorMsg);
				}
			}
			LOG.debug("Exiting from the findElement method.");
			return (WebElement) element;
		}

     protected Object getElement(String selector) {
     return getWebDriver().findElement(getBy(selector));
		}

		@SuppressWarnings("rawtypes")
		protected List getElements(String selector) {
			LOG.debug("Entering into the getElements method : " + selector);
			return getWebDriver().findElements(getBy(selector));
		}

		protected By getBy(String selector) {
			final String CSS_PRIFX = "css:";
			final String CLASS_PRIFX = "class:";
			final String LINK_PRIFX = "link:";
			final String XPATH_PRIFX = "xpath:";
			final String PARTIAL_LINK_PRIFX = "partiallink:";

			if (selector.startsWith(CSS_PRIFX)) {
				return By.cssSelector(selector.substring(CSS_PRIFX.length()));
			}
			if (selector.startsWith(CLASS_PRIFX)) {
				return By.className(selector.substring(CLASS_PRIFX.length()));
			}
			if (selector.startsWith(LINK_PRIFX)) {
				return By.linkText(selector.substring(LINK_PRIFX.length()));
			}
			if (selector.startsWith(PARTIAL_LINK_PRIFX)) {
				return By.partialLinkText(selector.substring(PARTIAL_LINK_PRIFX
						.length()));
			}
			if (selector.startsWith(XPATH_PRIFX)) {
				return By.xpath(selector.substring(XPATH_PRIFX.length()));
			}

			return new ByIdOrName(selector);
		}

		//@Override
		public ElementFactory getElementFactory() {

			return new SeleniumElementFactory(this);
		}

		//@Override
		public void close() {
			
			try {
				throw new UnImplementedException("Implementation Pending",null);
			} catch (UnImplementedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//getWebDriver().close();
		}

		/**
		 * {@inheritDoc}
		 */
		//@Override
		public void shutdown() {
			try {
				WebDriver d = getWebDriver();
				//d.close();
				d.quit();
			} catch (WebDriverException wde) {
				LOG.error("Exception While closing the Browser", wde);
			     }
		}

		
		//@Override
		public void captureScreen(String fullFilePath) throws FixtureError {
			try {
				File screenshot = ((TakesScreenshot) getWebDriver())
						.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot, new File(fullFilePath));
			} catch (IOException ioe) {
				LOG.error("Error while capturing the screen", ioe);
				throw new FixtureError("Error while capturing screenshot", ioe);
			}
		}
		
		
		
		//@Override
		public void scrollToElement(Element element){
			JavascriptExecutor jse = (JavascriptExecutor) getWebDriver();
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
		}
		
		/**
		 * Scrolls the current browser window to specific position
		 * 
		 * @param i
		 *            Horizontal position
		 * @param j
		 *            Vertical position
		 */
		//@Override
		public void windowScroll(int i, int j) {
			eval("window.scroll(" + i + "," + j + ");");
		}
	
	     //@Override
	      public void eval ( String javascript){
	         JavascriptExecutor jse = (JavascriptExecutor) getWebDriver();
		     jse.executeScript(javascript);
		  }

		/*
		 * Navigates back in the browser
		 *
		 *
		 */
		//@Override
		public void back() {
			getWebDriver().navigate().back();
		}

		/*
		 * Navigates forward in the browser
		 *
		 *
		 */
		//@Override
		public void forward() {
			getWebDriver().navigate().forward();
		}

		/**
		 * Navigates refresh in the browser
		 *
		 *
		 */
		//@Override
		public void refresh() {
			getWebDriver().navigate().refresh();
		}

		//@Override
		public void waitUntil(final WaitforConditionTimer callbackCondition)
				throws ElementTimeoutError {

			waitUntil(SeleniumWebElement.DEFAULT_WAIT_TIME, callbackCondition);

		}

		protected void waitUntil(int timeout,
				 final WaitforConditionTimer callbackCondition)
				throws ElementTimeoutError {
			Date time = new Date();
			long diffInMillies;
			try {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(m_webDriver)
						.withTimeout(timeout, TimeUnit.SECONDS)
						.pollingEvery(1, TimeUnit.SECONDS)
						.ignoring(NoSuchElementException.class);

				wait.until(new ExpectedCondition<Boolean>() {
				   // @Override
					public Boolean apply(WebDriver d) {

						return callbackCondition.ensure();

					}
				});
				diffInMillies = new Date().getTime() - time.getTime();
			} catch (TimeoutException e) {
				diffInMillies = new Date().getTime() - time.getTime();
				throw new ElementTimeoutError("Timed out after " + diffInMillies
						+ " ms");
			}
			LOG.info("Waited  " + diffInMillies + " ms to find element");
		}


		public void switchToActiveWindow() throws InterruptedException {
			Set<String> handles = getWebDriver().getWindowHandles();
			Iterator<String> itr = handles.iterator();

			String firstHandle = itr.next();
			String lastHandle = firstHandle;
			while (itr.hasNext()) {
				lastHandle = itr.next();
			}

			if (!firstHandle.equalsIgnoreCase(lastHandle)) {
				WebDriver activeWindow = getWebDriver().switchTo().window(
						lastHandle);
				activeWindow.manage().window().maximize();
			}
		}


		public void closeActiveWindow() {
			String activeWindowHandle = getWebDriver().getWindowHandle();
			WebDriver activeWindow = getWebDriver().switchTo().window(
					activeWindowHandle);
			activeWindow.close();
			// set main window as active
			Set<String> handles = getWebDriver().getWindowHandles();
			Iterator<String> itr = handles.iterator();
			String mainHandle = itr.next();
			getWebDriver().switchTo().window(mainHandle);
		}


		public void pauseFor(int sec) {
			try {
				Thread.sleep(sec*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}


		public String getSessionId() {
			// TODO Auto-generated method stub
			return null;
		}

		//@Override
		public void setSessionId(String sessionId) {
			// TODO Auto-generated method stub
			
		}
		

		/**
		 * it returns the test resource full accessible path
		 *
		 * @param fileName
		 *            local test file name eg. test.html
		 * @return
		 */
		public String getLocalResource(String fileName) {
			return String.format("%s%s", m_defaultFileResourceLocation, fileName);
		}

		//@Override
		public void setLocalResourcePath(String path) {
			m_defaultFileResourceLocation = path;

		}
		
		//@Override
		public void maximizeWindow(){
			getWebDriver().manage().window().maximize();
		}


		//@Override
		public void testAccessibility() {
			
			
		}



		
//
//		public String getM_defaultFileResourceLocation() {
//			return m_defaultFileResourceLocation;
//		}
//
//
//		public void setM_defaultFileResourceLocation(
//				String m_defaultFileResourceLocation) {
//			this.m_defaultFileResourceLocation = m_defaultFileResourceLocation;
//		}

	
}
