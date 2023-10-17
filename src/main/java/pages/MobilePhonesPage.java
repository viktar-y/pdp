package pages;

import core.elements.*;
import org.openqa.selenium.By;


public class MobilePhonesPage extends BasePage {
	DropDown sortMenuDropDown = new DropDown(By.xpath("//a[@class = 'schema-order__link']"), "Sort button");
	Button mostExpensiveOptionButton = new Button(By.xpath("//*[contains(text(), 'Дорогие')]"), "Most Expensive ");
	Button resetFiltersButton = new Button(By.cssSelector(".schema-filter-button__sub_control"), "Reset all filters");
	Button addPrime = new Button(By.cssSelector(".schema-filter__bonus-item_primary"), "Button add Prime");
	Tag primeTag = new Tag(By.xpath("//*[@class='schema-tags__text' and text()='Príme']"), "Prime label");
	Link chooseDeliveryDestinationLink = new Link(By.cssSelector(".schema-filter__link_secondary"), "Delivery destination");
	Link changedCity = new Link(By.cssSelector(".schema-filter__link_nodecor"), "Changed city");
	TextField inputCityField = new TextField(By.cssSelector(".auth-input"), "City input");
	Button confirmChangeDestination = new Button(By.xpath("//*[contains(@class, 'auth-button')]"), "Change destination");
	TextField priceFromField = new TextField(By.cssSelector("input.schema-filter__number-input[placeholder='от']"), "Price from field");
	TextField priceToField = new TextField(By.cssSelector("input.schema-filter__number-input[placeholder='до']"), "Price to field");
	Tag searchTag = new Tag(By.xpath("//*[@class = 'schema-tags__text']"), "search tag");
	Tag smartphoneTag = new Tag(By.xpath("//*[contains(@class, 'schema-tags__text') and text()='смартфон']"), "Smartphone tag");
	Label countOfItems = new Label(By.cssSelector(".schema-filter-button__sub_main"), "Count of deals");
	Button openItemButton = new Button(By.cssSelector(".button.js-product-price-link"), "Open item button");
	Button confirmFilterReset = new Button(By.xpath("//*[@class='schema-filter-button__sub']"), "Confirm reset");
	Image countOfItemsUploading = new Image(By.cssSelector(".schema-filter-button__state_animated"), "Count of deals with uploading");
	Button cityFromList = new Button(By.cssSelector(".auth-dropdown__container"), "Cty from list");

	public MobilePhonesPage() {
		super(By.xpath("//h1"), "Mobile phones page");
	}

	public boolean isSmartphoneTagShown() {
		return smartphoneTag.isPresent();
	}

	public void expandSortingMenuDropdown() {
		sortMenuDropDown.expandDropDown();
	}

	public void clickOnMostExpensiveSortingOption() {
		mostExpensiveOptionButton.clickOnButton();
	}

	public void clickOnOpenItemButton() {
		openItemButton.clickOnButton();
	}

	public void clickOnChangeDestinationWindow() {
		chooseDeliveryDestinationLink.followLink();
	}

	public void enterNewDestination(String value) {
		inputCityField.typeInField(value);
	}

	public void clickOnCityFromList() {
		cityFromList.clickOnButton();
	}

	public void clickConfirmChoiceCityFromList() {
		confirmChangeDestination.clickOnButton();
	}

	public void clickOnPrimeItemsButton() {
		addPrime.clickOnButton();
	}

	public boolean isPrimeLabelShown() {
		return primeTag.isPresent();
	}

	public void clickOnRemovePrimeTag() {
		primeTag.clickOnTag();
	}

	public String getTextDelivery() {
		return changedCity.getTextFromLink();
	}

	public int getCountOfDeals() {
		if (countOfItemsUploading.isPresent()) {
			countOfItems.waitForIsElementPresent();
		}
		String count;
		do {
			 count = countOfItems.getLabelText().replaceAll("[^0-9]", "");
		} while (count.equals(""));
		return Integer.parseInt(count);
	}

	public void clickOnResetAllSearchCriteriaButton() {
		resetFiltersButton.clickOnButton();
		confirmFilterReset.clickOnButton();
	}

	public void typeValueIntoPriceFromField(String value) {
		priceFromField.typeInField(value);
	}

	public void typeValueIntoPriceToField(String value) {
		priceToField.typeInField(value);
	}

	public String getTagText() {
		return searchTag.getTextFromTag().replaceAll("[^0-9]", "");
	}

	public void openSmartphonePageInNewTab() {
		openItemButton.openElementInNewTab();
	}

}
