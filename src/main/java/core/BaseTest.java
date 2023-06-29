package core;

import org.testng.annotations.*;

import static properties.Properties.BASE_URL;

public class BaseTest {
	private static final Logger logger = Logger.getInstance();
	private static Browser browser = Browser.getInstance();

	@BeforeTest
	public void beforeTest() {
		Class<? extends BaseTest> currentClass = this.getClass();
		logger.logTestName(currentClass.getName());
	}

	@BeforeMethod
	public void beforeMethod() {
		browser = Browser.getInstance();
		browser.navigate(BASE_URL);
	}

	@AfterTest
	public void afterTest() {
		Class<? extends BaseTest> currentClass = this.getClass();
		logger.logTestEnd(currentClass.getName());
	}

	@AfterMethod
	public void afterMethod() {
		browser.exit();
	}
}
