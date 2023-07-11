package pages;

import core.elements.Image;
import org.openqa.selenium.By;

public class BelarusianLanguageNewsPage extends BasePage{
	Image yNeskladovajeImage = new Image(By.xpath("//div[@class = 'banner-content-img']"), " Y neskladovaje image");

	public BelarusianLanguageNewsPage() {
		super(By.xpath("//h1[text()='Onliner па-беларуску']"), "Onliner on Belarusian");
	}

	public boolean isYShown() {
		return yNeskladovajeImage.isEnabled();
	}

}
