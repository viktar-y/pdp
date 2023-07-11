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
		super(By.xpath("//div[text()='Вход']"), "Login Page");
	}

	public void typeLoginIntoField(String value) {
		loginField.typeInField(value);
	}

	public void typePasswordIntoField(String value) {
		passwordField.typeInField(value);
	}

	public void clickOnConfirmLoginButton() {
		loginButton.clickOnButton();
	}

	public void checkThatIAmNotRobot() {
		recaptchaCheckbox.check();
	}

}
