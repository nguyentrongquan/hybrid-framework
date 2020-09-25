package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopcommerce.user.LoginPageUI;

public class LoginPageObject extends AbstractPage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public void clickToLoginButton() {
		waitElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}


	public boolean isErrorMessageEnterYourEmailDisplayed(String message) {
		waitElementVisible(driver, LoginPageUI.MESSAGE_ENTER_YOUR_MAIL_TEXT, message);
		return isElementDisplayed(driver, LoginPageUI.MESSAGE_ENTER_YOUR_MAIL_TEXT, message);
	}

	public String getErrorMessageInvalidEmailDisplayed() {
		waitElementVisible(driver,  LoginPageUI.GET_MESSAGE_INVALID_MAIL_TEXT);
		return getTextElement(driver, LoginPageUI.GET_MESSAGE_INVALID_MAIL_TEXT);
	
	}
	public boolean isErrorMessageInvalidEmailDisplayed(String message) {
		
		
		waitElementVisible(driver, LoginPageUI.GET_MESSAGE_INVALID_MAIL_TEXT, message);
		return isElementDisplayed(driver, LoginPageUI.MESSAGE_INVALID_MAIL_TEXT, message);
	}

	public boolean isErrorMessageIncorrectEmailDisplayed(String message1, String message2) {
		waitElementVisible(driver, LoginPageUI.MESSAGE_INCORRECT_MAIL_TEXT,message1, message2);
		return isElementDisplayed(driver, LoginPageUI.MESSAGE_INCORRECT_MAIL_TEXT,message1, message2);
	}

	public boolean isErrorDataIncorrectMessageDisplayed(String message1, String message2) {
		waitElementVisible(driver, LoginPageUI.DATA_INCORRECT_TEXT,message1, message2);
		return isElementDisplayed(driver, LoginPageUI.DATA_INCORRECT_TEXT,message1, message2);
	}
	

}
