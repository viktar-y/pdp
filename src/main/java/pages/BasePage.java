package pages;

import core.Browser;
import core.Logger;
import core.elements.Label;
import org.openqa.selenium.By;


abstract class BasePage {
	private final By locator;
	private final String name;
	private static final Logger logger = Logger.getInstance();

	BasePage(By locator, String name) {
		this.locator = locator;
		this.name = name;
	}

	public void waitForPageOpen() {
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

}
