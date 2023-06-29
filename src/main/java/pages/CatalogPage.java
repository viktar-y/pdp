package pages;

import core.elements.Button;
import org.openqa.selenium.By;

public class CatalogPage extends BasePage{
	Button electronicSection = new Button(By.xpath("//span[contains(@class, 'catalog-navigation-classifier__item-title-wrapper') and text()='Электроника']"), "Electronic sections button");
	Button mobilePhonesSection = new Button(By.xpath("//div[contains(text(), 'Мобильные')]"), "Mobile phone's section button");
	Button smartphonesPage = new Button(By.xpath("//span[@class='catalog-navigation-list__dropdown-title' and text()=' Смартфоны ']"), "Smartphones page button");

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
