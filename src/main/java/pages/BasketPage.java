package pages;

import core.elements.Label;
import org.openqa.selenium.By;

public class BasketPage extends BasePage{
	Label basketItemDescriptionLabel = new Label(By.xpath("//div[@class  = 'cart-form__description cart-form__description_primary cart-form__description_base cart-form__description_condensed-other helpers_hide_tablet']"), "Basket item description");

	public BasketPage() {
		super(By.xpath("//div[@class  = 'cart-form__title cart-form__title_base cart-form__title_nocondensed cart-form__title_condensed-special']"), "Basket page");
	}

	public String getBasketItemDescription() {
		return basketItemDescriptionLabel.getLabelText();
	}

}
