package pageUIs.nopcommerce.user;

public class LoginPageUI {
	public static final String LOGIN_BUTTON="//input[@value='Log in']";
	public static final String MESSAGE_ENTER_YOUR_MAIL_TEXT="//span[@id='Email-error' and text()='%s']";
	public static final String GET_MESSAGE_INVALID_MAIL_TEXT="//label[contains(text(),'Email')]/following-sibling::span[@class='field-validation-error']";
	public static final String MESSAGE_INVALID_MAIL_TEXT="//span[@class='field-validation-error' and contains(text(),'%s')]";
	public static final String MESSAGE_INCORRECT_MAIL_TEXT="//div[contains(@class,'message-error') and text()='%s']//li[text()='%s']";
	public static final String DATA_INCORRECT_TEXT="//div[contains(@class,'message-error') and text()='%s']//li[text()='%s']";

}
