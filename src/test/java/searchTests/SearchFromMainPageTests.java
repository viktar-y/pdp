package searchTests;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import pages.*;

public class SearchFromMainPageTests extends BaseTest {

	@Test
	public void searchItemFromMainPageTest() {
		MainPage mainPage = new MainPage();
		mainPage.searchItem("iPhone 14");
		mainPage.openFirstItem();
//		mainPage.openFirstItem();
		ItemPage itemPage = new ItemPage();
		Assertions.assertTrue(itemPage.isItemImageShown());
	}
}
