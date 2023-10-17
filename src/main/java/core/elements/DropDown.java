package core.elements;

import org.openqa.selenium.By;

public class DropDown extends BaseElement{
	public DropDown(By locator, String elementName) {
		super(locator, elementName);
	}

	public void expandDropDown() {
		waitForIsElementPresent();
		element.click();
	}

}
