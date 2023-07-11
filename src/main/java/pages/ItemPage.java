package pages;

import core.elements.Button;
import core.elements.Image;
import core.elements.Label;
import org.openqa.selenium.By;

public class ItemPage extends BasePage{
	Button addToBasketButton = new Button(By.xpath("//a[contains(text(), 'В корзину')]"), "Add to Basket");
	Label descriptionLabel = new Label(By.xpath("//div[@class='offers-description__specs']"), "Item description");
	Image itemImage = new Image(By.xpath("//img[@id = 'device-header-image']"), "Item image");

	public ItemPage() {
		super(By.xpath("//span[text()='Описание и фото']"), "Item page");
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
