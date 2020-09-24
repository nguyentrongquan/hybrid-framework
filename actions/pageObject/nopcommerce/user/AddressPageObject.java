package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorNopcommerceManager;
import pageUIs.nopcommerce.user.AddressPageUI;
import pageUIs.nopcommerce.user.ComputerPageUI;

public class AddressPageObject extends AbstractPage{
	private WebDriver driver;

	public AddressPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public void clickToAddNewButton() {
		waitElementClickable(driver, AddressPageUI.ADD_NEW_ADDRESS_BUTTON);
		clickToElement(driver, AddressPageUI.ADD_NEW_ADDRESS_BUTTON);
	}

	public void selectItemCountryDropDown(String country) {
		waitElementClickable(driver, AddressPageUI.COUNTRY_DROPDOWN);
		selectItemInDropdown(driver,  AddressPageUI.COUNTRY_DROPDOWN, country);
		
	}
	public void clickToSaveButton() {
		waitElementClickable(driver, AddressPageUI.SAVE_ADDRESS_BUTTON);
		clickToElement(driver, AddressPageUI.SAVE_ADDRESS_BUTTON);
		
	}

	public boolean isNameAddressDisplayed(String nameValue) {
		waitElementVisible(driver, AddressPageUI.NAME_ADDRESS, nameValue);
		return isElementDisplayed(driver, AddressPageUI.NAME_ADDRESS, nameValue);
	}

	public boolean isEmailAddressDisplayed(String mailvalue) {
		waitElementVisible(driver, AddressPageUI.EMAIL_ADDRESS, mailvalue);
		return isElementDisplayed(driver, AddressPageUI.EMAIL_ADDRESS, mailvalue);
	}

	public boolean isPhoneNumberAddressDisplayed(String phoneNumber) {
		waitElementVisible(driver, AddressPageUI.PHONE_ADDRESS, phoneNumber);
		return isElementDisplayed(driver, AddressPageUI.PHONE_ADDRESS, phoneNumber);
	}

	public boolean isFaxAddressDisplayed(String faxNumber) {
		waitElementVisible(driver, AddressPageUI.FAX_ADDRESS, faxNumber);
		return isElementDisplayed(driver, AddressPageUI.FAX_ADDRESS, faxNumber);
	}

	public boolean isAddress1Displayed(String address1) {
		waitElementVisible(driver, AddressPageUI.ADDRESS1_ADDRESS, address1);
		return isElementDisplayed(driver, AddressPageUI.ADDRESS1_ADDRESS, address1);
	}

	public boolean isAddress2Displayed(String address2) {
		waitElementVisible(driver, AddressPageUI.ADDRESS2_ADDRESS, address2);
		return isElementDisplayed(driver, AddressPageUI.ADDRESS2_ADDRESS, address2);
	}

	public boolean isCityZipCodeAddressDisplayed(String cityZip) {
		waitElementVisible(driver, AddressPageUI.CITY_ZIP_ADDRESS, cityZip);
		return isElementDisplayed(driver, AddressPageUI.CITY_ZIP_ADDRESS, cityZip);
	}

	public boolean isCountryAddressDisplayed(String countryValue) {
		waitElementVisible(driver, AddressPageUI.COUNTRY_ADDRESS, countryValue);
		return isElementDisplayed(driver, AddressPageUI.COUNTRY_ADDRESS, countryValue);
	}

	public boolean isCompanyAddressDisplayed(String companyValue) {
		waitElementVisible(driver, AddressPageUI.COMPANY_ADDRESS, companyValue);
		return isElementDisplayed(driver, AddressPageUI.COMPANY_ADDRESS, companyValue);
	}

	


}
