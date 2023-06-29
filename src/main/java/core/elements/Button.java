package core.elements;

import org.openqa.selenium.By;


public class Button extends BaseElement {
	public Button(By locator, String name) {
		super(locator, name);
	}

	public void clickOnButton() {
		waitForIsElementPresent();
		element.click();
	}

	public String getTextFromButton() {
		waitForIsElementPresent();
		return element.getText();
	}

}
