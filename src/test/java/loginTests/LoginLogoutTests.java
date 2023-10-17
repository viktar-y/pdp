package loginTests;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;


import static properties.Properties.CORRECT_LOGIN;
import static properties.Properties.CORRECT_PASSWORD;

public class LoginLogoutTests extends BaseTest {

	@Test
	public void checkLoginFlowTest() {
		mainPage.clickOnLoginFormLink();
		loginPage.waitForPageOpen();
		loginPage.typeLoginIntoField(CORRECT_LOGIN);
		loginPage.typePasswordIntoField(CORRECT_PASSWORD);
		loginPage.clickOnConfirmLoginButton();
		loginPage.checkThatIAmNotRobot();
		Assertions.assertTrue(mainPage.isAvatarShown());
	}

	@Test
	public void checkLogoutFlowTest() {
		checkLoginFlowTest();
		mainPage.clickOnUsersProfileButton();
		mainPage.logout();
		Assertions.assertTrue(mainPage.isLoginButtonShown());
	}

}
