package pages;

import core.elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static properties.Properties.DEFAULT_TIMEOUT;

public class MobilePhonesPage extends BasePage {
	DropDown sortMenuDropDown = new DropDown(By.xpath("//a[@class = 'schema-order__link']"), "Sort button");
	Button mostExpensiveOptionButton = new Button(By.xpath("//span[contains(text(), 'Дорогие')]"), "Most Expensive ");
	Button resetFiltersButton = new Button(By.xpath("//span[@data-bind = 'click: $root.doMoved.bind($root)']"), "Reset all filters");
	Button addPrime = new Button(By.xpath("//label[@class='schema-filter__bonus-item schema-filter__bonus-item_primary']"), "Button add Prime");
	Tag primeTag = new Tag(By.xpath("//span[@class='schema-tags__text' and text()='Príme']"), "Prime label");
	Link chooseDeliveryDestinationLink = new Link(By.xpath("//span[@class = 'schema-filter__link schema-filter__link_secondary schema-filter__link_small']"), "Delivery destination");
	Link changedCity = new Link(By.xpath("//a[@class = 'schema-filter__link schema-filter__link_primary-alter schema-filter__link_small-alter schema-filter__link_nodecor']"), "Changed city");
	TextField inputCityField = new TextField(By.xpath("//input[@placeholder = 'Укажите ваш населенный пункт']"), "City input");
	Button confirmChangeDestination = new Button(By.xpath("//button[contains(@class, 'auth-button')]"), "Change destination");
	TextField priceFromField = new TextField(By.xpath("//input[contains(@placeholder, 'от') and contains(@class, 'schema-filter__number-input_price')]"), "Price from field");
	TextField priceToField = new TextField(By.xpath("//input[contains(@data-bind, 'до') and contains(@class, 'number-input_price')]"), "Price to field");
	Tag searchTag = new Tag(By.xpath("//span[@class = 'schema-tags__text']"), "search tag");
	Tag smartphoneTag = new Tag(By.xpath("//span[@class='schema-tags__text' and text()='смартфон']"), "Smartphone tag");
	Label countOfItems = new Label(By.xpath("//span[@class = 'schema-filter-button__sub schema-filter-button__sub_main']"), "Count of deals");
	Button openItemButton = new Button(By.xpath("//a[@class='schema-product__button button button_orange js-product-price-link']"), "Open item button");
	Button confirmFilterReset = new Button(By.xpath("//span[@class='schema-filter-button__sub']"), "Confirm reset");
	MenuButton cityOfferedMenuButton = new MenuButton(By.xpath("//div[@class = 'auth-dropdown_container']"), "City offered");
	Image countOfItemsUploading = new Image(By.xpath("//div[contains(@class, 'schema-filter-button__state_animated')]"), "Count of deals with uploading");

	public MobilePhonesPage() {
		super(By.xpath("//h1"), "Mobile phones page");
	}

	public boolean isSmartphoneTagShown() {
		return smartphoneTag.isPresent(DEFAULT_TIMEOUT);
	}

	public void expandSortingMenu() {
		sortMenuDropDown.expandDropDown();
	}

	public void chooseMostExpensiveSortingOption() {
		mostExpensiveOptionButton.clickOnButton();
	}

	public void openItem() {
		openItemButton.clickOnButton();
	}

	public void openChangeDestinationWindow() {
		chooseDeliveryDestinationLink.followLink();
	}

	public void enterNewDestination(String value) {
		inputCityField.typeInField(value);
		if (cityOfferedMenuButton.isPresent(DEFAULT_TIMEOUT)) {
			cityOfferedMenuButton.clickMenuButton();
		} else {
			inputCityField.typeInField(Keys.DOWN);
			inputCityField.typeInField(Keys.ENTER);
			confirmChangeDestination.clickOnButton();
		}
	}

	public void choosePrimeItems() {
		addPrime.clickOnButton();
	}

	public boolean isPrimeLabelShown() {
		return primeTag.isPresent(DEFAULT_TIMEOUT);
	}

	public void removePrimeLabel() {
		primeTag.clickOnTag();
	}

	public String getTextDelivery() {
		return changedCity.getTextFromLink();
	}

	public int getCountOfDeals() {
		if (countOfItemsUploading.isPresent(DEFAULT_TIMEOUT)) {
			countOfItems.waitForIsElementPresent();
		}
		String count;
		do {
			 count = countOfItems.getLabelText().replaceAll("[^0-9]", "");
		} while (count.equals(""));
		return Integer.parseInt(count);
	}

	public void resetAllSearchCriteria() {
		resetFiltersButton.clickOnButton();
		confirmFilterReset.clickOnButton();
	}

	public void choosePriceFrom(int value) {
		priceFromField.typeInField(String.valueOf(value));
	}

	public void choosePriceTo(int value) {
		priceToField.typeInField(String.valueOf(value));
	}

	public String getTagText() {
		return searchTag.getTextFromTag().replaceAll("[^0-9]", "");
	}

}
