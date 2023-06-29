package pages;

import core.elements.Button;
import org.openqa.selenium.By;

public class WalletNewsPage extends BasePage{
	Button belarusianLanguageNewsButton = new Button(By.xpath("//a[@href = 'https://sp.onliner.by/in_belarusian/']"), "Belarusian language news");

	public WalletNewsPage() {
		super(By.xpath("//a[@href = '/ceny']"), "Wallet news page");
	}

	public void openBelarusianLanguageNews() {
		belarusianLanguageNewsButton.clickOnButton();
	}

}
