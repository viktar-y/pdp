package pages;

import core.elements.Label;
import org.openqa.selenium.By;

public class BasketPage extends BasePage{
	Label basketItemDescriptionLabel = new Label(By.cssSelector(".cart-form__description_condensed-other.helpers_hide_tablet"), "Basket item description");

	public BasketPage() {
		super(By.cssSelector(".cart-form__title"), "Basket page");
	}

	public String getBasketItemDescription() {
		return basketItemDescriptionLabel.getLabelText();
	}

}
