package pages;

import core.elements.*;
import org.openqa.selenium.By;

public class MainPage extends BasePage{
	TextField searchField = new TextField(By.xpath("//*[contains(@class, 'fast-search__input')]"), "Search field");
	Link loginLink = new Link(By.xpath("//*[contains(text(), 'Вход')]"), " Login ");
	Button userMenuButton = new Button(By.cssSelector(".b-top-profile__image"), "User's menu ");
	Link basketLink = new Link(By.xpath("//a[@title = 'Корзина']"), "Shopping basket ");
	Link catalogLink = new Link(By.xpath("//*[text()='Каталог']"), "Catalog page ");
	Button profileButton = new Button(By.xpath("//*[@class='b-top-profile__name']"), "User's profile ");
	Link walletNewsLink = new Link(By.xpath("//a[text()='Кошелек']"), "Wallet news page ");
	Image usersAvatarImage = new Image(By.cssSelector(".js-header-user-avatar"), "User's avatar");
	Button logoutButton = new Button(By.xpath("//a[contains(text(), 'Выйти')]"), "Logout ");
	Link weatherPageLink = new Link(By.cssSelector(".js-weather-icon"), "Weather page");
	IFrame listOfOffersIframe = new IFrame(By.xpath("//*[@class = 'modal-iframe']"), "List of offers");
	Link firstOfferLink = new Link(By.xpath("//*[@class = 'result__wrapper']"), "First offer");

	public MainPage() {
		super(By.xpath("//img[@alt='Onlíner']"), "Onlíner's mainpage");
		waitForPageOpen();
	}

	public void typeItemNameIntoSearchField(String value) {
		searchField.typeInField(value);
	}

	public void clickOnLoginFormLink() {
		loginLink.followLink();
	}

	public void clickOnUserMenuButton() {
		userMenuButton.click();
	}

	public void clickOnBasketPageLink() {
		basketLink.followLink();
	}

	public void clickOnCatalogLink() {
		catalogLink.followLink();
	}

	public void clickOnUsersProfileButton() {
		profileButton.click();
	}

	public boolean isAvatarShown() {
		return usersAvatarImage.isEnabled();
	}

	public void logout() {
		clickOnUserMenuButton();
		logoutButton.clickOnButton();
	}

	public boolean isLoginButtonShown() {
		return loginLink.isEnabled();
	}

	public void clickOnWeatherPageLink() {
		weatherPageLink.followLink();
	}

	public void clickOnWalletNewsLink() {
		walletNewsLink.followLink();
	}

	public void clickOnFirstOffer() {
		firstOfferLink.click();
	}

	public void switchToOfferList() {
		listOfOffersIframe.switchToIframe();
	}

}
