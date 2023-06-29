package core.elements;

import org.openqa.selenium.By;


public class Tag extends BaseElement {
	public Tag(By locator, String name) {
		super(locator, name);
	}

	public void clickOnTag() {
		waitForIsElementPresent();
		element.click();
	}

	public String getTextFromTag() {
		waitForIsElementPresent();
		return element.getText();
	}

}