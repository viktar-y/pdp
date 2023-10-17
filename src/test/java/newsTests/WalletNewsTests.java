package newsTests;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class WalletNewsTests extends BaseTest {

	@Test
	public void checkOpeningWalletNewsOnBelarusianLanguageTest() {
		mainPage.clickOnWalletNewsLink();
		walletNewsPage.waitForPageOpen();
		walletNewsPage.clickOnBelarusianLanguageNewsButton();
		belarusianLanguageNewsPage.waitForPageOpen();
		Assertions.assertTrue(belarusianLanguageNewsPage.isYNeskladovajeEnabled());
	}

}
