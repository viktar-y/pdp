package pages;

import core.elements.Button;
import core.elements.Image;
import core.elements.Link;
import core.elements.TextField;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static properties.Properties.DEFAULT_TIMEOUT;

public class MainPage extends BasePage{
	TextField searchField = new TextField(By.xpath("//input[contains(@class, 'fast-search__input')]"), "Search field");
	Link loginLink = new Link(By.xpath("//div[contains(text(), 'Вход')]"), " Login ");
	Button userMenuButton = new Button(By.xpath("$x(//a[@class = 'b-top-profile__preview js-toggle-bar'])"), "User's menu ");
	Link basketLink = new Link(By.xpath("//a[@title = 'Корзина']"), "Shopping basket ");
	Link catalogLink = new Link(By.xpath("//a[@class='b-main-navigation__link' and @href='https://catalog.onliner.by']"), "Catalog page ");
	Button profileButton = new Button(By.xpath("//a[@href = 'https://profile.onliner.by' and contains(@class, 'b-top-profile__link b-top-profile__link_alter')])"), "User's profile ");
	Link walletNewsLink = new Link(By.xpath("//h2/a[@href = 'https://money.onliner.by' and contains(text(), 'Кошелек')]"), "Wallet news page ");
	Image usersAvatarImage = new Image(By.xpath("//div[@class = 'b-top-profile__image js-header-user-avatar']"), "User's avatar");
	Button logoutButton = new Button(By.xpath("//a[contains(text(), 'Выйти')]"), "Logout ");
	Link weatherPageLink = new Link(By.xpath("//a[@href='https://pogoda.onliner.by/']"), "Weather page");
	Button itemsButton = new Button(By.xpath("//div[@class = 'result__item result__item_product']"), "Items");

	public MainPage() {
		super(By.xpath("//img[@alt='Onlíner']"), "Onlíner's mainpage");
	}

	public void searchItem(String value) {
		searchField.typeInField(value);

	}

	public void openLoginForm() {
		loginLink.followLink();
	}

	public void openUserMenu() {
		userMenuButton.click();
	}

	public void openBasket() {
		basketLink.followLink();
	}

	public void openCatalog() {
		catalogLink.followLink();
	}

	public void openUsersProfile() {
		profileButton.click();
	}

	public boolean isAvatarShown() {
		return usersAvatarImage.isEnabled();
	}

	public void logout() {
		openUserMenu();
		logoutButton.clickOnButton();
	}

	public boolean isLoginButtonShown() {
		return loginLink.isEnabled();
	}

	public void openWeatherPage() {
		weatherPageLink.followLink();
	}

	public void openWalletNews() {
		walletNewsLink.followLink();
	}

	public void openFirstItem() {
		if (itemsButton.isPresent(DEFAULT_TIMEOUT)) {
			itemsButton.clickOnButton();
		} else {
			searchField.typeInField(Keys.DOWN);
			searchField.typeInField(Keys.ENTER);
		}
	}

}
