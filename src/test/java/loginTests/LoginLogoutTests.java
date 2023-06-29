package loginTests;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;


import static properties.Properties.CORRECT_LOGIN;
import static properties.Properties.CORRECT_PASSWORD;

public class LoginLogoutTests extends BaseTest {

	@Test
	public void loginTest() {
		MainPage mainPage = new MainPage();
		mainPage.openLoginForm();
		LoginPage loginPage = new LoginPage();
		loginPage.enterLogin(CORRECT_LOGIN);
		loginPage.enterPassword(CORRECT_PASSWORD);
		loginPage.confirmLogin();
		loginPage.iAmNotRobot();
		Assertions.assertTrue(mainPage.isAvatarShown());
	}

	@Test
	public void logoutTest() {
		loginTest();
		MainPage mainPage = new MainPage();
		mainPage.openUsersProfile();
		mainPage.logout();
		Assertions.assertTrue(mainPage.isLoginButtonShown());
	}

}
