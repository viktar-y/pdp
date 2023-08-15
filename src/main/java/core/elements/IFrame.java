package core.elements;

import org.openqa.selenium.By;

public class IFrame extends BaseElement {
	public IFrame(By locator, String name) {
		super(locator, name);
	}

	public void switchToIframe() {
		waitForIsElementPresent();
		browser.getDriver().switchTo().frame(element);
	}

}
