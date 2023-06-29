package core;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class Browser {
	private static Browser instance;
	private static RemoteWebDriver driver;

	private Browser(){}

	public static Browser getInstance() {
		if (instance == null) {
			try {
				System.setProperty("webdriver.http.factory", "jdk-http-client");
				System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver");
				driver = new ChromeDriver();
				driver.manage().window().maximize();

			} catch (Exception e) {
				e.printStackTrace();
			}
			instance = new Browser();
		}
		return instance;
	}

	public RemoteWebDriver getDriver() {
		return driver;
	}

	public void navigate(String url) {
		driver.get(url);
	}

	public void exit() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			instance = null;
		}
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}
}
