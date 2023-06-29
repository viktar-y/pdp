package core.elements;

import org.openqa.selenium.By;

public class MenuButton extends BaseElement {
	public MenuButton(By locator, String name) {
		super(locator, name);
	}

	public void clickMenuButton() {
		waitForIsElementPresent();
		element.click();
	}

}