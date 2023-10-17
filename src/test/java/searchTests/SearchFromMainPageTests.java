package searchTests;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import static properties.Properties.ITEM;

public class SearchFromMainPageTests extends BaseTest {

	@Test
	public void checkSearchingItemFromMainPageTest() {
		mainPage.typeItemNameIntoSearchField(ITEM);
		mainPage.switchToOfferList();
		mainPage.clickOnFirstOffer();
		itemPage.waitForPageOpen();
		Assertions.assertTrue(itemPage.isItemImageShown());
	}
}
