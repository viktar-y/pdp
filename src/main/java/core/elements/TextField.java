package core.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class TextField extends BaseElement {
	public TextField(By locator, String name) {
		super(locator, name);
	}

	public void typeInField(Keys key) {
		waitForIsElementPresent();
		element.sendKeys(key);
	}

	public void typeInField(String value) {
		waitForIsElementPresent();
		element.sendKeys(value);
	}

}
