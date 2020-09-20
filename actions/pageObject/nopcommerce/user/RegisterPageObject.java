package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopcommerce.user.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver=driver;
		
	}
	public void clickToRegisterButton() {
		waitElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElementByJS(driver, RegisterPageUI.REGISTER_BUTTON);
		sleepInSecond(2);
		
	}
	public boolean isErrorMesageAtValueNameTextboxtDisplayed(String valueName, String textMessage) {
		waitElementVisible(driver,RegisterPageUI.ERROR_MESSAGE_AT_TEXTBOX,valueName, textMessage);
		return isElementDisplayed(driver,RegisterPageUI.ERROR_MESSAGE_AT_TEXTBOX,valueName, textMessage);
		
	}
	
	public void inputToEmailTextbox(String emailValue) {
		waitElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver,RegisterPageUI.EMAIL_TEXTBOX, emailValue);
	}
	public void inputToFirstNameTextbox(String firstName) {
		waitElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver,RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
		
	}
	public void inputToLastNameTextbox(String lastName) {
		waitElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver,RegisterPageUI.LASTNAME_TEXTBOX, lastName);
	}
	public void inputToPasswordTextbox(String passValue) {
		waitElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver,RegisterPageUI.PASSWORD_TEXTBOX, passValue);
		
	}
	public void inputToConfirmPasswordTextbox(String confirmPass) {
		waitElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver,RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPass);
		
	}
	public boolean isErrorMesageAtEmailAlreadyExistsDisplayed(String errorMail) {
		waitElementVisible(driver, RegisterPageUI.MESSAGE_EMAIL_ALREADY_EXISTS,errorMail);
		return isElementDisplayed(driver, RegisterPageUI.MESSAGE_EMAIL_ALREADY_EXISTS,errorMail);
	}
	public boolean isErrorMesageMustHaveLeastCharstDisplayed() {
		waitElementVisible(driver, RegisterPageUI.ERROR_MESSAGE_LESS_6_CHARS);
		return isElementDisplayed(driver, RegisterPageUI.ERROR_MESSAGE_LESS_6_CHARS);
	}
	public boolean isMessageRegisterSuccessDisplayed() {
		waitElementVisible(driver, RegisterPageUI.MESSAGE_REGISTER_SUCCESS_TEXT);
		return isElementDisplayed(driver, RegisterPageUI.MESSAGE_REGISTER_SUCCESS_TEXT);
		
	}

	
	
}