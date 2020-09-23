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


}
