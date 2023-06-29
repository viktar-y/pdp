package core.elements;

import org.openqa.selenium.By;

public class Link extends BaseElement {
	public Link(By locator, String name) {
		super(locator, name);
	}

	public void followLink() {
		waitForIsElementPresent();
		element.click();
	}

	public String getTextFromLink() {
		waitForIsElementPresent();
		return element.getText();
	}
}