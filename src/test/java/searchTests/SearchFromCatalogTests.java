package searchTests;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import utils.StringUtils;


import static properties.Properties.*;

public class SearchFromCatalogTests extends BaseTest {

	@Test
	public void checkCatalogOpeningTest() {
		mainPage.clickOnCatalogLink();
		catalogPage.waitForPageOpen();
		Assertions.assertTrue(catalogPage.isElectronicSectionShown());
	}

	@Test
	public void checkSmartphonesPageOpeningTest() {
		checkCatalogOpeningTest();
		catalogPage.clickOnElectronicSections();
		catalogPage.clickOnMobileSection();
		catalogPage.clickOnSmartphonesPage();
		mobilePhonesPage.waitForPageOpen();
		Assertions.assertTrue(mobilePhonesPage.isSmartphoneTagShown());
	}

	@Test
	public void checkAdditionToBasketMostExpensivePhoneTest() {
		checkSmartphonesPageOpeningTest();
		mobilePhonesPage.expandSortingMenuDropdown();
		mobilePhonesPage.clickOnMostExpensiveSortingOption();
		mobilePhonesPage.clickOnOpenItemButton();
		itemPage.waitForPageOpen();
		String descriptionItemPage = itemPage.getItemDescription();
		itemPage.clickOnAddItemToBasketButton();
		itemPage.refreshPage();
		mainPage.clickOnBasketPageLink();
		basketPage.waitForPageOpen();
		Assertions.assertEquals(basketPage.getBasketItemDescription(), descriptionItemPage);
	}

	@Test
	public void checkDeliveryDestinationChangingTest() {
		checkSmartphonesPageOpeningTest();
		mobilePhonesPage.clickOnChangeDestinationWindow();
		mobilePhonesPage.enterNewDestination(CITY);
		mobilePhonesPage.clickOnCityFromList();
		mobilePhonesPage.clickConfirmChoiceCityFromList();
		Assertions.assertEquals(CITY, mobilePhonesPage.getTextDelivery());

	}

	@Test
	public void checkOnlyPrimeItemsSearchingTest() {
		checkSmartphonesPageOpeningTest();
		int countOfDealsBeforeChanging = mobilePhonesPage.getCountOfDeals();
		mobilePhonesPage.clickOnPrimeItemsButton();
		int countOfDealsAfterChanging = mobilePhonesPage.getCountOfDeals();
		Assertions.assertTrue(mobilePhonesPage.isPrimeLabelShown());
		Assertions.assertNotEquals(countOfDealsAfterChanging, countOfDealsBeforeChanging);
	}

	@Test
	public void checkPrimeSearchOptionRemovingTest() {
		checkOnlyPrimeItemsSearchingTest();
		int countOfDealsBeforeChanging = mobilePhonesPage.getCountOfDeals();
		mobilePhonesPage.clickOnRemovePrimeTag();
		int countOfDealsAfterChanging = mobilePhonesPage.getCountOfDeals();
		Assertions.assertFalse(mobilePhonesPage.isPrimeLabelShown());
		Assertions.assertNotEquals(countOfDealsBeforeChanging, countOfDealsAfterChanging);
	}

	@Test
	public void checkResetAllSearchCriteriaTest() {
		checkSmartphonesPageOpeningTest();
		int countDealsBefore = mobilePhonesPage.getCountOfDeals();
		mobilePhonesPage.clickOnResetAllSearchCriteriaButton();
		Assertions.assertFalse(mobilePhonesPage.isSmartphoneTagShown());
		int countDealsAfter = mobilePhonesPage.getCountOfDeals();
		Assertions.assertNotEquals(countDealsAfter, countDealsBefore);
	}

	@Test
	public void checkChoosingPhoneInPriceRangeTest() {
		checkResetAllSearchCriteriaTest();
		int countDealsBefore = mobilePhonesPage.getCountOfDeals();
		mobilePhonesPage.typeValueIntoPriceFromField(PRICE_FROM);
		mobilePhonesPage.typeValueIntoPriceToField(PRICE_TO);
		Assertions.assertEquals(StringUtils.getPriceRangeInString(), mobilePhonesPage.getTagText());
		int countDealsAfter = mobilePhonesPage.getCountOfDeals();
		Assertions.assertNotEquals(countDealsBefore, countDealsAfter);
	}

	@Test
	public void checkOpeningMostExpensivePhoneInNewTabTest() {
		checkSmartphonesPageOpeningTest();
		checkSmartphonesPageOpeningTest();
		mobilePhonesPage.expandSortingMenuDropdown();
		mobilePhonesPage.clickOnMostExpensiveSortingOption();
		mobilePhonesPage.openSmartphonePageInNewTab();
		Assertions.assertTrue(itemPage.isItemImageShown());
	}

}
