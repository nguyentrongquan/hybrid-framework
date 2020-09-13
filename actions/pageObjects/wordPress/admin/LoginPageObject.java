package pageObjects.wordPress.admin;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUIs.wordPress.admin.LoginPageUI;

public class LoginPageObject extends AbstractPage {
	private WebDriver driver;
	
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}


	public void inputToEmailOrUsernameTextbox(String emailValue) {
		waitElementVisible(driver, LoginPageUI.USERNAME_OR_EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.USERNAME_OR_EMAIL_TEXTBOX, emailValue);
		
	}


	public void clickToContinueButton() {
		waitElementClickable(driver, LoginPageUI.CONTINUE_BUTTON);
		clickToElement(driver,LoginPageUI.CONTINUE_BUTTON);
		
	}


	public void inputToPasswordTextbox(String passwordValue) {
		waitElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX,passwordValue);
		
		
	}


	public DashboardPageObject clickToLoginButton(WebDriver driver) {
		waitElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getDashboardAdminPage(driver);
	}

}
