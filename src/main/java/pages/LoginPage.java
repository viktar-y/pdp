package pages;

import core.elements.Button;
import core.elements.CheckBox;
import core.elements.TextField;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
	TextField loginField = new TextField(By.xpath("//*[@placeholder = 'Ник или e-mail']"), "Login field");
	TextField passwordField = new TextField(By.xpath("//*[@type = 'password']"), "Password field");
	Button loginButton = new Button(By.xpath("//*[contains(text(), 'Войти')]"), "Login button");
	CheckBox recaptchaCheckbox = new CheckBox(By.xpath("//*[@class = 'recaptcha-checkbox-border']"), "Recaptcha checkbox");

	public LoginPage() {
		super(By.xpath("//*[text()='Вход']"), "Login Page");
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
