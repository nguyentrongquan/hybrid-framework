package pageUIs.nopcommerce.user;

public class RegisterPageUI {
	public static final String ERROR_MESSAGE_AT_TEXTBOX="//label[contains(text(),'%s')]/following-sibling::span[@class='field-validation-error']/span[text()='%s']";
	public static final String REGISTER_BUTTON="//div[@class='buttons']/input";
	public static final String EMAIL_TEXTBOX="//input[@id='Email']";
	public static final String FIRSTNAME_TEXTBOX="//input[@id='FirstName']";
	public static final String LASTNAME_TEXTBOX="//input[@id='LastName']";
	public static final String COMPANY_NAME_TEXTBOX="//input[@id='Company']";
	public static final String PASSWORD_TEXTBOX="//input[@id='Password']";
	public static final String CONFIRM_PASSWORD_TEXTBOX="//input[@id='ConfirmPassword']";
	public static final String MESSAGE_EMAIL_ALREADY_EXISTS="//div[contains(@class,'message-error')]//li[contains(text(),'%s')]";
	public static final String ERROR_MESSAGE_LESS_6_CHARS="//li[contains(text(),'must have at least 6 characters')]";
	public static final String MESSAGE_REGISTER_SUCCESS_TEXT="//div[@class='result' and text()='Your registration completed']";

}
