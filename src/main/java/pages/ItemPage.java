package pages;

import core.elements.Button;
import core.elements.Image;
import core.elements.Label;
import org.openqa.selenium.By;

public class ItemPage extends BasePage{
	Button addToBasketButton = new Button(By.xpath("//*[contains(text(), 'В корзину')]"), "Add to Basket");
	Label descriptionLabel = new Label(By.xpath("//*[@class='offers-description__specs']"), "Item description");
	Image itemImage = new Image(By.xpath("//*[@id = 'device-header-image']"), "Item image");

	public ItemPage() {
		super(By.xpath("//*[text()='Описание и фото']"), "Item page");
	}

	public void clickOnAddItemToBasketButton() {
		addToBasketButton.clickOnButton();
	}

	public String getItemDescription() {
		return descriptionLabel.getLabelText();
	}

	public boolean isItemImageShown() {
		return itemImage.isEnabled();
	}

}
