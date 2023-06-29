package core.elements;

import core.Browser;
import core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;
import static properties.Properties.*;

public class BaseElement {
	public static Browser browser = Browser.getInstance();
	private static final Logger logger = Logger.getInstance();
	RemoteWebElement element;
	private final By locator;
	private final String name;

	public BaseElement(By locator, String elementName) {
		this.locator = locator;
		name = elementName;
	}

	public void waitForIsElementPresent() {
		isPresent(DEFAULT_TIMEOUT);
		if (!element.isEnabled()) {
			new WebDriverWait(browser.getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT))
					.until(ExpectedConditions.visibilityOf(element));
		}
		assertTrue(element.isDisplayed(), "Element is not presented");
	}

	public By getLocator() {
		return locator;
	}

	public void click() {
		waitForIsElementPresent();
		logger.info(String.format("Click on %s element", name));
		element.click();
	}

	public List<WebElement> getElements() {
		return browser.getDriver().findElements(locator);
	}

	public boolean isEnabled() {
		return browser.getDriver()
					  .findElement(locator)
					  .isEnabled();
	}

	public boolean isPresent(int timeout) {
		WebDriverWait wait = new WebDriverWait(Browser.getInstance().getDriver(), Duration.ofSeconds(timeout));
		browser.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			wait.until((ExpectedCondition<Boolean>) driver -> {
				try {
					List<WebElement> list = driver.findElements(locator);
					for (WebElement el : list) {
						if (el instanceof RemoteWebElement && el.isDisplayed()) {
							element = (RemoteWebElement) el;
							return element.isDisplayed();
						}
					}
					element = (RemoteWebElement) driver.findElement(locator);
				} catch (Exception e) {
					logger.warn(String.format("Element %s is not presented", name));
					return false;
				}
				return element.isDisplayed();
			});
		} catch (Exception e) {
			return false;
		}
		try {
			browser.getDriver().manage()
				   .timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
			return element.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
