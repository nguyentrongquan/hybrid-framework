package pageObject.liveguru.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageObject.liveGuru.user.LoginPageUI;

public class LoginPageObject extends AbstractPage {
    WebDriver driver;	
    public LoginPageObject( WebDriver driver) {
	this.driver= driver;
    }
    public void clickToCreateAnAccountButton() {
	waitElementClickable(driver, LoginPageUI.CREATE_AN_ACCOUNT_BUTTON);
	clickToElement(driver,LoginPageUI.CREATE_AN_ACCOUNT_BUTTON);
	
    }
    public void inputToEmailTextbox(String email) {
	waitElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
	sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
    }
    public void inputToPasswordTextbox(String password) {
	waitElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
	sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }
    

}
