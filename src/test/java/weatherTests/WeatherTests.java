package weatherTests;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import utils.FileProcessor;

import static properties.Properties.AVG_TEMP_FILE_PATH;
import static properties.Properties.CURRENT_TEMP_FILE_PATH;

public class WeatherTests extends BaseTest {

	@Test
	public void checkWeatherPageOpeningTest() {
		mainPage.clickOnWeatherPageLink();
		weatherPage.waitForPageOpen();
		Assertions.assertTrue(weatherPage.isCityShown());
	}

	@Test
	public void checkCurrentTemperatureIsShownTest() {
		checkWeatherPageOpeningTest();
		String currentTemperature = weatherPage.getCurrentTemperatureValue();
		FileProcessor.writeValueToFile(currentTemperature, CURRENT_TEMP_FILE_PATH);
		Assertions.assertTrue(weatherPage.isCurrentTemperatureShown());
	}

	@Test
	public void checkWeeklyTemperatureIsShownTest() {
		checkWeatherPageOpeningTest();
		double currentTemperature = weatherPage.getAVGTemperatureValue();
		FileProcessor.writeValueToFile(String.valueOf(currentTemperature), AVG_TEMP_FILE_PATH);
		Assertions.assertTrue(weatherPage.areDailyTemperaturesShown());
	}

}
