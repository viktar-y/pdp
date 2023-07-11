package core;

import org.testng.annotations.*;
import pages.*;

import static properties.Properties.BASE_URL;

public class BaseTest {
	private static final Logger logger = Logger.getInstance();
	private static Browser browser = Browser.getInstance();
	public BasketPage basketPage;
	public BelarusianLanguageNewsPage belarusianLanguageNewsPage;
	public CatalogPage catalogPage;
	public ItemPage itemPage;
	public LoginPage loginPage;
	public MainPage mainPage;
	public MobilePhonesPage mobilePhonesPage;
	public WalletNewsPage walletNewsPage;
	public WeatherPage weatherPage;

	@BeforeTest
	public void beforeTest() {
		Class<? extends BaseTest> currentClass = this.getClass();
		logger.logTestName(currentClass.getName());
	}

	@BeforeMethod
	public void beforeMethod() {
		browser = Browser.getInstance();
		browser.navigate(BASE_URL);
		basketPage = new BasketPage();
		belarusianLanguageNewsPage = new BelarusianLanguageNewsPage();
		catalogPage = new CatalogPage();
		itemPage = new ItemPage();
		loginPage = new LoginPage();
		mainPage = new MainPage();
		mobilePhonesPage = new MobilePhonesPage();
		walletNewsPage = new WalletNewsPage();
		weatherPage = new WeatherPage();
	}

	@AfterTest
	public void afterTest() {
		Class<? extends BaseTest> currentClass = this.getClass();
		logger.logTestEnd(currentClass.getName());
	}

	@AfterMethod
	public void afterMethod() {
		browser.exit();
	}
}
