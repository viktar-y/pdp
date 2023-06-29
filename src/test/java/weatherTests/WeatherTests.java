package weatherTests;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.WeatherPage;
import utils.FileProcessor;

import static properties.Properties.AVG_TEMP_FILE_PATH;
import static properties.Properties.CURRENT_TEMP_FILE_PATH;

public class WeatherTests extends BaseTest {

	@Test
	public void openWeatherPage() {
		MainPage mainPage = new MainPage();
		mainPage.openWeatherPage();
		WeatherPage weatherPage = new WeatherPage();
		Assertions.assertTrue(weatherPage.isCityShown());
	}

	@Test
	public void getCurrentTemperature() {
		openWeatherPage();
		WeatherPage weatherPage = new WeatherPage();
		String currentTemperature = weatherPage.getCurrentTemperatureText();
		FileProcessor.writeValueToFile(currentTemperature, CURRENT_TEMP_FILE_PATH);
	}

	@Test
	public void getAVGTemperature() {
		openWeatherPage();
		WeatherPage weatherPage = new WeatherPage();
		double currentTemperature = weatherPage.getAVGTemperatureValue();
		FileProcessor.writeValueToFile(String.valueOf(currentTemperature), AVG_TEMP_FILE_PATH);
	}

}
