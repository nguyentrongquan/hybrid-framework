package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorNopcommerceManager;
import pageUIs.nopcommerce.user.CustomerInfoPageUI;
import pageUIs.wordPress.user.HomePageUI;

public class CustomerInfoPageObject extends AbstractPage {
	private WebDriver driver;

	public CustomerInfoPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public void clickToFemaleRadioButon() {
		waitElementClickable(driver, CustomerInfoPageUI.GENDER_FEMALE_RADIO_BUTTON);
		clickToElement(driver, CustomerInfoPageUI.GENDER_FEMALE_RADIO_BUTTON);
	}

	public void selectToDateOfBirthDayDropdown(String valueDay) {
		waitElementClickable(driver, CustomerInfoPageUI.DATE_OF_BIRTH_DAY_DROPDOWN);
		selectItemInDropdown(driver, CustomerInfoPageUI.DATE_OF_BIRTH_DAY_DROPDOWN, valueDay);
	}

	public void selectToDateOfBirthMonthDropdown(String valueMonth) {
		waitElementClickable(driver, CustomerInfoPageUI.DATE_OF_BIRTH_MONTH_DROPDOWN);
		selectItemInDropdown(driver, CustomerInfoPageUI.DATE_OF_BIRTH_MONTH_DROPDOWN, valueMonth);
		
	}

	public void selectToDateOfBirthYearDropdown(String valueYear) {
		waitElementClickable(driver, CustomerInfoPageUI.DATE_OF_BIRTH_YEAR_DROPDOWN);
		selectItemInDropdown(driver, CustomerInfoPageUI.DATE_OF_BIRTH_YEAR_DROPDOWN, valueYear);
	}

	public void clickToSaveButton() {
		waitElementClickable(driver, CustomerInfoPageUI.SAVE_BUTTON);
		clickToElement(driver, CustomerInfoPageUI.SAVE_BUTTON);
	}

	public void inputToCompanyTextbox(String company) {
		waitElementVisible(driver, CustomerInfoPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver,  CustomerInfoPageUI.COMPANY_TEXTBOX, company);
		
	}

	public void inputToFirstNameTextbox(String editFirstName) {
		waitElementVisible(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver,  CustomerInfoPageUI.FIRSTNAME_TEXTBOX, editFirstName);
		
	}

	public void inputToLastNameTextbox(String editLastName) {
		waitElementVisible(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver,  CustomerInfoPageUI.LASTNAME_TEXTBOX, editLastName);
		
	}

	public void inputToEmailTextbox(String editEmail) {
		waitElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver,  CustomerInfoPageUI.EMAIL_TEXTBOX, editEmail);
		
	}

	public boolean isFemaleRadioButtonSelected() {
		waitElementVisible(driver, CustomerInfoPageUI.GENDER_FEMALE_RADIO_BUTTON);
		return isElementSelected(driver, CustomerInfoPageUI.GENDER_FEMALE_RADIO_BUTTON);
	}

	public String getFirstNameUpdateText(String attributeName ) {
		waitElementVisible(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX);
		return getAtributeValue(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX,attributeName);
	}

	public String getLastNameUpdateText(String attributeName) {
		waitElementVisible(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX);
		return getAtributeValue(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX,attributeName);
	}

	public String getDateOfBirthDayUpdateDropdown() {
		waitElementVisible(driver, CustomerInfoPageUI.DATE_OF_BIRTH_DAY_DROPDOWN);
		return getSelectedItemInDropdown(driver, CustomerInfoPageUI.DATE_OF_BIRTH_DAY_DROPDOWN);
	}

	public String getDateOfBirthMonthUpdateDropdown() {
		waitElementVisible(driver, CustomerInfoPageUI.DATE_OF_BIRTH_MONTH_DROPDOWN);
		return getSelectedItemInDropdown(driver, CustomerInfoPageUI.DATE_OF_BIRTH_MONTH_DROPDOWN);
	}

	public String getDateOfBirthYearUpdateDropdown() {
		waitElementVisible(driver, CustomerInfoPageUI.DATE_OF_BIRTH_YEAR_DROPDOWN);
		return getSelectedItemInDropdown(driver, CustomerInfoPageUI.DATE_OF_BIRTH_YEAR_DROPDOWN);
	}

	public String getEmailUpdateText(String attributeName) {
		waitElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
		return getAtributeValue(driver, CustomerInfoPageUI.EMAIL_TEXTBOX,attributeName);
	}

	public String getCompanyNameUpdateText(String attributeName) {
		waitElementVisible(driver, CustomerInfoPageUI.COMPANY_TEXTBOX);
		return getAtributeValue(driver, CustomerInfoPageUI.COMPANY_TEXTBOX,attributeName);
	}
	

}
