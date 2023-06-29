package pages;

import core.elements.MenuButton;
import org.openqa.selenium.By;

public class CatalogPage extends BasePage{
	MenuButton electronicSection = new MenuButton(By.xpath("//span[contains(@class, 'catalog-navigation-classifier__item-title-wrapper') and text()='Электроника']"), "Electronic sections button");
	MenuButton mobilePhonesSection = new MenuButton(By.xpath("//div[contains(text(), 'Мобильные')]"), "Mobile phone's section button");
	MenuButton smartphonesPage = new MenuButton(By.xpath("//span[@class='catalog-navigation-list__dropdown-title' and text()=' Смартфоны ']"), "Smartphones page button");

	public CatalogPage() {
		super(By.xpath("//div[@class = 'catalog-navigation__title']"), "Onliner's catalog page");
	}

	public void openElectronicSections() {
		electronicSection.click();
	}

	public void openMobileSection() {
		mobilePhonesSection.click();
	}

	public void openSmartphonesPage() {
		smartphonesPage.click();
	}

	public boolean isElectronicSectionShown() {
		return electronicSection.isEnabled();
	}

}
