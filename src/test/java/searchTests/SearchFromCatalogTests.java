package searchTests;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import pages.*;

public class SearchFromCatalogTests extends BaseTest {

	@Test
	public void openCatalogTest() {
		new MainPage().openCatalog();
		CatalogPage catalogPage = new CatalogPage();
		Assertions.assertTrue(catalogPage.isElectronicSectionShown());
	}

	@Test
	public void openSmartphonesPageTest() {
		openCatalogTest();
		CatalogPage catalogPage = new CatalogPage();
		catalogPage.openElectronicSections();
		catalogPage.openMobileSection();
		catalogPage.openSmartphonesPage();
		MobilePhonesPage mobilePhonesPage = new MobilePhonesPage();
		Assertions.assertTrue(mobilePhonesPage.isSmartphoneTagShown());
	}

	@Test
	public void addToBasketMostExpensivePhoneTest() {
		openSmartphonesPageTest();
		MobilePhonesPage mobilePhonesPage = new MobilePhonesPage();
		mobilePhonesPage.expandSortingMenu();
		mobilePhonesPage.chooseMostExpensiveSortingOption();
		mobilePhonesPage.openItem();
		ItemPage itemPage = new ItemPage();
		String descriptionItemPage = itemPage.getItemDescription();
		itemPage.addItemToBasket();
		itemPage.refreshPage();
		new MainPage().openBasket();
		BasketPage basketPage = new BasketPage();
		String descriptionBasketPage = basketPage.getBasketItemDescription();
		Assertions.assertEquals(descriptionBasketPage, descriptionItemPage);
	}

	@Test
	public void changeDeliveryDestinationTest() {
		openSmartphonesPageTest();
		MobilePhonesPage mobilePhonesPage = new MobilePhonesPage();
		mobilePhonesPage.openChangeDestinationWindow();
		String city = "Бобруйск";
		mobilePhonesPage.enterNewDestination(city);
		Assertions.assertEquals(city, mobilePhonesPage.getTextDelivery());

	}

	@Test
	public void searchPrimeItemsTest() {
		openSmartphonesPageTest();
		MobilePhonesPage mobilePhonesPage = new MobilePhonesPage();
		int countOfDealsBeforeChanging = mobilePhonesPage.getCountOfDeals();
		mobilePhonesPage.choosePrimeItems();
		int countOfDealsAfterChanging = mobilePhonesPage.getCountOfDeals();
		Assertions.assertTrue(mobilePhonesPage.isPrimeLabelShown());
		Assertions.assertNotEquals(countOfDealsAfterChanging, countOfDealsBeforeChanging);
	}

	@Test
	public void removePrimeSearchOptionTest() {
		searchPrimeItemsTest();
		MobilePhonesPage mobilePhonesPage = new MobilePhonesPage();
		int countOfDealsBeforeChanging = mobilePhonesPage.getCountOfDeals();
		mobilePhonesPage.removePrimeLabel();
		int countOfDealsAfterChanging = mobilePhonesPage.getCountOfDeals();
		Assertions.assertFalse(mobilePhonesPage.isPrimeLabelShown());
		Assertions.assertNotEquals(countOfDealsBeforeChanging, countOfDealsAfterChanging);
	}

	@Test
	public void resetAllSearchCriteriaTest() {
		openSmartphonesPageTest();
		MobilePhonesPage mobilePhonesPage = new MobilePhonesPage();
		int countDealsBefore = mobilePhonesPage.getCountOfDeals();
		mobilePhonesPage.resetAllSearchCriteria();
		Assertions.assertFalse(mobilePhonesPage.isSmartphoneTagShown());
		int countDealsAfter = mobilePhonesPage.getCountOfDeals();
		Assertions.assertNotEquals(countDealsAfter, countDealsBefore);
	}

	@Test
	public void choosePhoneInPriceRangeTest() {
		resetAllSearchCriteriaTest();
		MobilePhonesPage mobilePhonesPage = new MobilePhonesPage();
		int countDealsBefore = mobilePhonesPage.getCountOfDeals();
		int priceFrom = 1000;
		int priceTo = 2000;
		mobilePhonesPage.choosePriceFrom(priceFrom);
		mobilePhonesPage.choosePriceTo(priceTo);
		Assertions.assertEquals(priceFrom + "" + priceTo, mobilePhonesPage.getTagText());
		int countDealsAfter = mobilePhonesPage.getCountOfDeals();
		Assertions.assertNotEquals(countDealsBefore, countDealsAfter);
	}

}
