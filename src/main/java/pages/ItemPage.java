package pages;

import core.elements.Button;
import core.elements.Image;
import core.elements.Label;
import org.openqa.selenium.By;

public class ItemPage extends BasePage{
	Button addToBasketButton = new Button(By.xpath("//a[@class='button-style button-style_base-alter offers-list__button offers-list__button_cart button-style_expletive']"), "Add to Basket");
	Label descriptionLabel = new Label(By.xpath("//div[@class='offers-description__specs']"), "Item description");
	Image itemImage = new Image(By.xpath("//img[@id = 'device-header-image']"), "Item image");

	public ItemPage() {
		super(By.xpath("//span[text()='Описание и фото']"), "Item page");
	}

	public void addItemToBasket() {
		addToBasketButton.clickOnButton();
	}

	public String getItemDescription() {
		return descriptionLabel.getLabelText();
	}

	public boolean isItemImageShown() {
		return itemImage.isEnabled();
	}

}
