package pages;

import core.elements.Button;
import core.elements.Label;
import org.openqa.selenium.By;

public class WeatherPage extends BasePage{
	Label morningTempLabel = new Label(By.xpath("//dt[text()='утром']/following-sibling::dd/span[@class='value']"), "Morning temperature");
	Label afternoonTempLabel = new Label(By.xpath("//dt[text()='днем']/following-sibling::dd/span[@class='value']"), "Afternoon temperature");
	Label eveningTempLabel = new Label(By.xpath("//dt[text()='вечером']/following-sibling::dd/span[@class='value']"), "Evening temperature");
	Label nightTempLabel = new Label(By.xpath("//dt[text()='ночью']/following-sibling::dd/span[@class='value']"), "Night temperature");
	Label currentTempLabel = new Label(By.xpath("//span[@class = 'grad']"), "Current temperature");
	Button weatherCityButton = new Button((By.xpath("//a[@class = 'js-weather-city']")), "City of shown weather");

	public WeatherPage() {
		super(By.xpath("//p[contains(text(), 'Сейчас в')]"), "Weather page");
	}

	public String getCurrentTemperatureText() {
		return currentTempLabel.getLabelText().replaceAll("[^-+0-9]", "");
	}

	public double getAVGTemperatureValue() {
		int intMorning = Integer.parseInt(morningTempLabel.getLabelText().replaceAll("[^-+0-9]", ""));
		int intAfternoon = Integer.parseInt(afternoonTempLabel.getLabelText().replaceAll("[^-+0-9]", ""));
		int intEvening = Integer.parseInt(eveningTempLabel.getLabelText().replaceAll("[^-+0-9]", ""));
		int intNight = Integer.parseInt(nightTempLabel.getLabelText().replaceAll("[^-+0-9]", ""));
		return (intMorning + intAfternoon + intEvening + intNight) / 4.0;
	}

	public boolean isCityShown() {
		return weatherCityButton.isEnabled();
	}

}
