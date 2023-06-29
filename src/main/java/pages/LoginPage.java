package pages;

import core.elements.Button;
import core.elements.CheckBox;
import core.elements.TextField;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
	TextField loginField = new TextField(By.xpath("//input[@placeholder = 'Ник или e-mail']"), "Login field");
	TextField passwordField = new TextField(By.xpath("//input[@type = 'password']"), "Password field");
	Button loginButton = new Button(By.xpath("//button[contains(text(), 'Войти')]"), "Login button");
	CheckBox recaptchaCheckbox = new CheckBox(By.xpath("//div[@class = 'recaptcha-checkbox-border']"), "Recaptcha checkbox");

	public LoginPage() {
		super(By.xpath("//div[@class = 'auth-form__title auth-form__title_big auth-form__title_condensed-default']"), "Login Page");
	}

	public void enterLogin(String value) {
		loginField.typeInField(value);
	}

	public void enterPassword(String value) {
		passwordField.typeInField(value);
	}

	public void confirmLogin() {
		loginButton.clickOnButton();
	}

	public void iAmNotRobot() {
		recaptchaCheckbox.check();
	}

}
