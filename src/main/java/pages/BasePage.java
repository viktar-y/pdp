package pages;

import core.Browser;
import core.Logger;
import core.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static properties.Properties.DEFAULT_TIMEOUT;

abstract class BasePage {
	private final By locator;
	private final String name;
	private static final Logger logger = Logger.getInstance();

	BasePage(By locator, String name) {
		this.locator = locator;
		this.name = name;
		isPageOpen();
	}

	private void isPageOpen() {
		Label elem = new Label(locator, name);
		try {
			elem.waitForIsElementPresent();
		} catch (Throwable e) {
			logger.info(String.format("%s page was not opened", name));
		}
	}

	public void refreshPage() {
		Browser.getInstance().refreshPage();
	}

	public void waitForUploading() {
		Browser.getInstance().getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(DEFAULT_TIMEOUT));
	}

}
