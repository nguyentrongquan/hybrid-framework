package pageObject.liveguru.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageObject.liveGuru.user.RegisterPageUI;

public class RegisterPageObject extends AbstractPage  {
    WebDriver driver;	
    public RegisterPageObject( WebDriver driver) {
	this.driver= driver;
    }
    public void inputToFirstnameTextbox(String firstname) {
	waitElementVisible(driver,RegisterPageUI.FIRSTNAME_TEXTBOX );
	sendkeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX , firstname);
    }
    public void inputToLastnameTextbox(String lastname) {
	waitElementVisible(driver,RegisterPageUI.LASTNAME_TEXTBOX );
	sendkeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX , lastname);
    }
    public void inputToEmailTextbox(String email) {
	waitElementVisible(driver,RegisterPageUI.EMAIL_TEXTBOX );
	sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX , email);
    }
    public void inputToPasswordTextbox(String password) {
	waitElementVisible(driver,RegisterPageUI.PASSWORD_TEXTBOX );
	sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX , password);
    }
    public void inputToConfirmPasswordTextbox(String confirmPassword) {
	waitElementVisible(driver,RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX );
	sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX , confirmPassword);
    }
    public void clickToRegisterButton() {
	waitElementClickable(driver,RegisterPageUI.REGISTER_BUTTON);
	clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }
    

}
