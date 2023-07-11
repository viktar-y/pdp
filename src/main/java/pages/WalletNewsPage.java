package pages;

import core.elements.Link;
import org.openqa.selenium.By;

public class WalletNewsPage extends BasePage{
	Link belarusianLanguageNewsButton = new Link(By.cssSelector(".project-navigation__tooltip"), "Belarusian language news");

	public WalletNewsPage() {
		super(By.xpath("//a[@href = '/ceny']"), "Wallet news page");
	}

	public void clickOnBelarusianLanguageNewsButton() {
		belarusianLanguageNewsButton.followLink();
	}

}
