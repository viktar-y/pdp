package pages;

import core.elements.Button;
import core.elements.Image;
import core.elements.TextField;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static properties.Properties.DEFAULT_TIMEOUT;

public class MainPage extends BasePage{
	TextField searchField = new TextField(By.xpath("//input[contains(@class, 'fast-search__input')]"), "Search field");
	Button loginButton = new Button(By.xpath("//div[contains(text(), 'Вход')]"), " Login button");
	Button userMenuButton = new Button(By.xpath("$x(//a[@class = 'b-top-profile__preview js-toggle-bar'])"), "User's menu button");
	Button basketButton = new Button(By.xpath("//a[@title = 'Корзина']"), "Shopping basket button");
	Button catalogButton = new Button(By.xpath("//a[@class='b-main-navigation__link' and @href='https://catalog.onliner.by']"), "Catalog page button");
	Button profileButton = new Button(By.xpath("//a[@href = 'https://profile.onliner.by' and contains(@class, 'b-top-profile__link b-top-profile__link_alter')])"), "User's profile button");
	Button walletNewsButton = new Button(By.xpath("//h2/a[@href = 'https://money.onliner.by' and contains(text(), 'Кошелек')]"), "Wallet news page button");
	Image usersAvatarImage = new Image(By.xpath("//div[@class = 'b-top-profile__image js-header-user-avatar']"), "User's avatar");
	Button logoutButton = new Button(By.xpath("//a[contains(text(), 'Выйти')]"), "Logout button");
	Button weatherPageButton = new Button(By.xpath("//a[@href='https://pogoda.onliner.by/']"), "Weather page");
	Button items = new Button(By.xpath("//div[@class = 'result__item result__item_product']"), "Items");

	public MainPage() {
		super(By.xpath("//img[@alt='Onlíner']"), "Onlíner's mainpage");
	}

	public void searchItem(String value) {
		searchField.typeInField(value);

	}

	public void openLoginForm() {
		loginButton.click();
	}

	public void openUserMenu() {
		userMenuButton.click();
	}

	public void openBasket() {
		basketButton.click();
	}

	public void openCatalog() {
		catalogButton.click();
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
		return loginButton.isEnabled();
	}

	public void openWeatherPage() {
		weatherPageButton.clickOnButton();
	}

	public void openWalletNews() {
		walletNewsButton.clickOnButton();
	}

	public void openFirstItem() {
		if (items.isPresent(DEFAULT_TIMEOUT)) {
			items.clickOnButton();
		} else {
			searchField.typeInField(Keys.DOWN);
			searchField.typeInField(Keys.ENTER);
		}
	}

}
