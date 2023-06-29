package newsTests;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import pages.BelarusianLanguageNewsPage;
import pages.MainPage;
import pages.WalletNewsPage;

public class WalletNewsTests extends BaseTest {

	@Test
	public void openWalletNewsOnBelarusianLanguageTest() {
		MainPage mainPage = new MainPage();
		mainPage.openWalletNews();
		WalletNewsPage walletNewsPage = new WalletNewsPage();
		walletNewsPage.openBelarusianLanguageNews();
		BelarusianLanguageNewsPage belarusianLanguageNewsPage = new BelarusianLanguageNewsPage();
		Assertions.assertTrue(belarusianLanguageNewsPage.isYShown());
	}

}
