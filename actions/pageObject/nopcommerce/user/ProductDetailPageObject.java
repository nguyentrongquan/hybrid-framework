package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopcommerce.user.ProductDetailPageUI;

public class ProductDetailPageObject extends AbstractPage {
	private WebDriver driver;

	public ProductDetailPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public void clickToAddYourReview() {
		waitElementClickable(driver, ProductDetailPageUI.ADD_NEW_REVIEW_LINK);
		clickToElement(driver, ProductDetailPageUI.ADD_NEW_REVIEW_LINK);
	}

	public void selectItemInProcessorDropdown(String itemValue) {
		waitElementClickable(driver, ProductDetailPageUI.PROCESSOR_DROPDOWN);
		selectItemInDropdown(driver,  ProductDetailPageUI.PROCESSOR_DROPDOWN, itemValue);
		
	}

	public void selectItemInRAMDropdown(String ramValue) {
		waitElementClickable(driver, ProductDetailPageUI.RAM_DROPDOWN);
		selectItemInDropdown(driver,  ProductDetailPageUI.RAM_DROPDOWN, ramValue);
	}

	public void selectItemInHDDRadioButton(String hddValue) {
		waitElementClickable(driver, ProductDetailPageUI.HDD_RADIO_BUTTON,hddValue);
		clickToElement(driver, ProductDetailPageUI.HDD_RADIO_BUTTON, hddValue);
	}

	public void selectItemInOSRadioButton(String osValue) {
		waitElementClickable(driver, ProductDetailPageUI.OS_RADIO_BUTTON, osValue);
		clickToElement(driver, ProductDetailPageUI.OS_RADIO_BUTTON, osValue);
		
	}

	public void selectItemInSoftwareCheckbox(String softwareValue) {
		waitElementClickable(driver, ProductDetailPageUI.SOFTWARE_CHECKBOX,softwareValue);
		checkTheCheckbox(driver, ProductDetailPageUI.SOFTWARE_CHECKBOX,softwareValue);
		
	}

	public void clickToADDTOCARTButton() {
		waitElementClickable(driver, ProductDetailPageUI.UPDATE_AND_ADD_TO_CART_BUTTON);
		clickToElement(driver, ProductDetailPageUI.UPDATE_AND_ADD_TO_CART_BUTTON);
		
	}

	public boolean isMessageProductAddedCartSuccessDisplayed() {
		waitElementVisible(driver, ProductDetailPageUI.MESSAGE_PRODUCT_ADD_SUCCESS);
		return isElementDisplayed(driver, ProductDetailPageUI.MESSAGE_PRODUCT_ADD_SUCCESS);
	}

	public void clickToCloseMessageProdoductAddedSuccessButton() {
		waitElementClickable(driver, ProductDetailPageUI.CLOSE_MESSAGE_BUTTON);
		clickToElement(driver, ProductDetailPageUI.CLOSE_MESSAGE_BUTTON);
	}

	public void deselectItemInSoftwareCheckbox(String itemVlue) {
		waitElementClickable(driver, ProductDetailPageUI.SOFTWARE_CHECKBOX, itemVlue);
		uncheckToTheCheckbox(driver, ProductDetailPageUI.SOFTWARE_CHECKBOX, itemVlue);
	}

	public boolean isProductPriceDisplayed(String priceValue) {
		waitElementClickable(driver, ProductDetailPageUI.PRICE_TEXT, priceValue);
		return isElementDisplayed(driver,ProductDetailPageUI.PRICE_TEXT, priceValue);
	}

	public void inputQuantityTextbox(String value) {
		waitElementVisible(driver, ProductDetailPageUI.QUANTITY_TEXTBOX);
		sendkeyToElement(driver,  ProductDetailPageUI.QUANTITY_TEXTBOX, value);
		
	}

	public void clickToUPDATEButton() {
		waitElementClickable(driver, ProductDetailPageUI.UPDATE_AND_ADD_TO_CART_BUTTON);
		clickToElement(driver, ProductDetailPageUI.UPDATE_AND_ADD_TO_CART_BUTTON);
	}

	



}
