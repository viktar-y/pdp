package pages;

import core.elements.MenuButton;
import org.openqa.selenium.By;

public class CatalogPage extends BasePage{
	MenuButton electronicSection = new MenuButton(By.xpath("//span[text()='Электроника']"), "Electronic sections button");
	MenuButton mobilePhonesSection = new MenuButton(By.xpath("//div[contains(text(), 'Мобильные')]"), "Mobile phone's section button");
	MenuButton smartphonesPage = new MenuButton(By.xpath("//span[text()=' Смартфоны ']"), "Smartphones page button");

	public CatalogPage() {
		super(By.xpath("//div[@class = 'catalog-navigation__title']"), "Onliner's catalog page");
	}

	public void clickOnElectronicSections() {
		electronicSection.click();
	}

	public void clickOnMobileSection() {
		mobilePhonesSection.click();
	}

	public void clickOnSmartphonesPage() {
		smartphonesPage.click();
	}

	public boolean isElectronicSectionShown() {
		return electronicSection.isEnabled();
	}

}
