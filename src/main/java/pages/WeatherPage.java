package pages;

import core.elements.Button;
import core.elements.Label;
import org.openqa.selenium.By;

public class WeatherPage extends BasePage{
	Label morningTempLabel = new Label(By.xpath("//*[text()='утром']/following-sibling::*/*[@class='value']"), "Morning temperature");
	Label afternoonTempLabel = new Label(By.xpath("//*[text()='днем']/following-sibling::*/*[@class='value']"), "Afternoon temperature");
	Label eveningTempLabel = new Label(By.xpath("//*[text()='вечером']/following-sibling::*/*[@class='value']"), "Evening temperature");
	Label nightTempLabel = new Label(By.xpath("//*[text()='ночью']/following-sibling::*/*[@class='value']"), "Night temperature");
	Label currentTempLabel = new Label(By.xpath("//*[@class = 'grad']"), "Current temperature");
	Button weatherCityButton = new Button((By.xpath("//a[@class = 'js-weather-city']")), "City of shown weather");

	public WeatherPage() {
		super(By.xpath("//p[contains(text(), 'Сейчас в')]"), "Weather page");
	}

	public String getCurrentTemperatureValue() {
		return currentTempLabel.getLabelText().replaceAll("[^-+0-9]", "");
	}

	public boolean isCurrentTemperatureShown() {
		return currentTempLabel.isPresent();
	}

	public boolean areDailyTemperaturesShown() {
		return morningTempLabel.isPresent() &&
				afternoonTempLabel.isPresent() &&
				eveningTempLabel.isPresent() &&
				nightTempLabel.isPresent();
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
