package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopcommerce.user.MyAccountPageUI;

public class MyAccountPageObject extends AbstractPage {
	WebDriver driver;

	public MyAccountPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public void clickToFemaleRadioButon() {
		waitElementClickable(driver, MyAccountPageUI.GENDER_FEMALE_RADIO_BUTTON);
		clickToElement(driver, MyAccountPageUI.GENDER_FEMALE_RADIO_BUTTON);
	}

	public void selectToDateOfBirthDayDropdown(String valueDay) {
		waitElementClickable(driver, MyAccountPageUI.DATE_OF_BIRTH_DAY_DROPDOWN);
		selectItemInDropdown(driver, MyAccountPageUI.DATE_OF_BIRTH_DAY_DROPDOWN, valueDay);
	}

	public void selectToDateOfBirthMonthDropdown(String valueMonth) {
		waitElementClickable(driver, MyAccountPageUI.DATE_OF_BIRTH_MONTH_DROPDOWN);
		selectItemInDropdown(driver, MyAccountPageUI.DATE_OF_BIRTH_MONTH_DROPDOWN, valueMonth);
		
	}

	public void selectToDateOfBirthYearDropdown(String valueYear) {
		waitElementClickable(driver, MyAccountPageUI.DATE_OF_BIRTH_YEAR_DROPDOWN);
		selectItemInDropdown(driver, MyAccountPageUI.DATE_OF_BIRTH_YEAR_DROPDOWN, valueYear);
	}

	public void clickToSaveButton() {
		waitElementClickable(driver, MyAccountPageUI.SAVE_BUTTON);
		clickToElement(driver, MyAccountPageUI.SAVE_BUTTON);
	}

	public void inputToCompanyTextbox(String company) {
		waitElementVisible(driver, MyAccountPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver,  MyAccountPageUI.COMPANY_TEXTBOX, company);
		
	}

	public void inputToFirstNameTextbox(String editFirstName) {
		waitElementVisible(driver, MyAccountPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver,  MyAccountPageUI.FIRSTNAME_TEXTBOX, editFirstName);
		
	}

	public void inputToLastNameTextbox(String editLastName) {
		waitElementVisible(driver, MyAccountPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver,  MyAccountPageUI.LASTNAME_TEXTBOX, editLastName);
		
	}

	public void inputToEmailTextbox(String editEmail) {
		waitElementVisible(driver, MyAccountPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver,  MyAccountPageUI.EMAIL_TEXTBOX, editEmail);
		
	}

	public boolean isFemaleRadioButtonSelected() {
		waitElementVisible(driver, MyAccountPageUI.GENDER_FEMALE_RADIO_BUTTON);
		return isElementSelected(driver, MyAccountPageUI.GENDER_FEMALE_RADIO_BUTTON);
	}

	public String getFirstNameUpdateText(String attributeName ) {
		waitElementVisible(driver, MyAccountPageUI.FIRSTNAME_TEXTBOX);
		return getAtributeValue(driver, MyAccountPageUI.FIRSTNAME_TEXTBOX,attributeName);
	}

	public String getLastNameUpdateText(String attributeName) {
		waitElementVisible(driver, MyAccountPageUI.LASTNAME_TEXTBOX);
		return getAtributeValue(driver, MyAccountPageUI.LASTNAME_TEXTBOX,attributeName);
	}

	public String getDateOfBirthDayUpdateDropdown() {
		waitElementVisible(driver, MyAccountPageUI.DATE_OF_BIRTH_DAY_DROPDOWN);
		return getSelectedItemInDropdown(driver, MyAccountPageUI.DATE_OF_BIRTH_DAY_DROPDOWN);
	}

	public String getDateOfBirthMonthUpdateDropdown() {
		waitElementVisible(driver, MyAccountPageUI.DATE_OF_BIRTH_MONTH_DROPDOWN);
		return getSelectedItemInDropdown(driver, MyAccountPageUI.DATE_OF_BIRTH_MONTH_DROPDOWN);
	}

	public String getDateOfBirthYearUpdateDropdown() {
		waitElementVisible(driver, MyAccountPageUI.DATE_OF_BIRTH_YEAR_DROPDOWN);
		return getSelectedItemInDropdown(driver, MyAccountPageUI.DATE_OF_BIRTH_YEAR_DROPDOWN);
	}

	public String getEmailUpdateText(String attributeName) {
		waitElementVisible(driver, MyAccountPageUI.EMAIL_TEXTBOX);
		return getAtributeValue(driver, MyAccountPageUI.EMAIL_TEXTBOX,attributeName);
	}

	public String getCompanyNameUpdateText(String attributeName) {
		waitElementVisible(driver, MyAccountPageUI.COMPANY_TEXTBOX);
		return getAtributeValue(driver, MyAccountPageUI.COMPANY_TEXTBOX,attributeName);
	}
	

}
