package core.elements;

import org.openqa.selenium.By;

public class Label extends BaseElement {
	public Label(By locator, String name) {
		super(locator, name);
	}

	public String getLabelText() {
		waitForIsElementPresent();
		return element.getText();
	}

}
