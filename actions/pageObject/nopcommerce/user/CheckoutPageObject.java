package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopcommerce.user.CheckoutPageUI;

public class CheckoutPageObject extends AbstractPage{
	private WebDriver driver;
	public CheckoutPageObject(WebDriver driver) {
		this.driver = driver;
		
	}
	public void deselectToShipToTheSameAddressCheckbox() {
		waitElementClickable(driver, CheckoutPageUI.SHIP_TO_THE_SAME_ADDRESS_CHECKBOX);
		clickToElement(driver, CheckoutPageUI.SHIP_TO_THE_SAME_ADDRESS_CHECKBOX);
	}
	public void inputToDynamicBilldingAddressTextbox(String fieldName,String inputvalue) {
		waitElementVisible(driver, CheckoutPageUI.DYNAMIC_BIILDING_TEXTBOX, fieldName);
		sendkeyToElement(driver, CheckoutPageUI.DYNAMIC_BIILDING_TEXTBOX, inputvalue,fieldName);
		
	}
	
	public void inputToDynamicShippingAddressTextbox(String fieldName,String inputvalue) {
		waitElementVisible(driver, CheckoutPageUI.DYNAMIC_SHIPPING_TEXTBOX, fieldName);
		sendkeyToElement(driver, CheckoutPageUI.DYNAMIC_SHIPPING_TEXTBOX, inputvalue,fieldName);
		
	}
	
	public void selectToCountryBillAddressDropdown(String fieldName, String ValueDropdown) {
		waitElementClickable(driver, CheckoutPageUI.COUNTRY_BILLDING_DROPDOWN, fieldName);
		selectItemInDropdown(driver, CheckoutPageUI.COUNTRY_BILLDING_DROPDOWN,ValueDropdown,fieldName);
		
	}
	public void selectToCountryShippingAddressDropdown(String fieldName, String ValueDropdown) {
		waitElementClickable(driver, CheckoutPageUI.COUNTRY_SHIPPING_DROPDOWN, fieldName);
		selectItemInDropdown(driver, CheckoutPageUI.COUNTRY_SHIPPING_DROPDOWN,ValueDropdown,fieldName);
		
	}
	public void clickToDynamicCheckoutContineButton(String fieldName) {
		waitElementClickable(driver,CheckoutPageUI.DYNAMIC_CONTINUE_BUTTON,fieldName);
		clickToElement(driver, CheckoutPageUI.DYNAMIC_CONTINUE_BUTTON,fieldName);
		
	}
	public void selectToNewAddressShippingDropdown(String dropDownValue) {
		waitElementClickable(driver,CheckoutPageUI.SHIPPING_NEW_ADDRESS_DROPDOWN);
		selectItemInDropdown(driver, CheckoutPageUI.SHIPPING_NEW_ADDRESS_DROPDOWN, dropDownValue);
		
	}
	public void selectToDynamicNameShippingMethodRadioButton(String nameMethod) {
		waitElementClickable(driver, CheckoutPageUI.DYNAMIC_NAME_SHIPPING_METHOD_RADIO_BUTTON,nameMethod);
		clickToElement(driver, CheckoutPageUI.DYNAMIC_NAME_SHIPPING_METHOD_RADIO_BUTTON,nameMethod);
	}
	public void selectToDynamicPaymentMethodRadioButton(String paymentMethod) {
		waitElementClickable(driver, CheckoutPageUI.DYNAMIC_NAME_PAYMENT_METHOD_RADIO_BUTTON,paymentMethod);
		clickToElement(driver, CheckoutPageUI.DYNAMIC_NAME_PAYMENT_METHOD_RADIO_BUTTON,paymentMethod);
		
	}
	public boolean isPaymentInformationDisplayed() {
		waitElementVisible(driver, CheckoutPageUI.PAYMENT_INFORMATION_MESSAGE_TEXT);
		return isElementDisplayed(driver, CheckoutPageUI.PAYMENT_INFORMATION_MESSAGE_TEXT);
		
	}
	public boolean isDynamicBilldingInfodisplayed(String attributesValue, String textValue) {
		waitElementVisible(driver, CheckoutPageUI.DYNAMIC_BILLDING_ADDRESS_INFO_TEXT, attributesValue,textValue);
		return isElementDisplayed(driver, CheckoutPageUI.DYNAMIC_BILLDING_ADDRESS_INFO_TEXT, attributesValue,textValue);
		
	}
	public boolean isPaymentMethodNameDisplayed(String paymentMethod) {
		waitElementVisible(driver, CheckoutPageUI.PAYMENT_METHOD_TEXT, paymentMethod);
		return isElementDisplayed(driver, CheckoutPageUI.PAYMENT_METHOD_TEXT, paymentMethod);
	}
	public boolean isDynamicShippingInfodisplayed(String attributesValue, String textValue) {
		waitElementVisible(driver, CheckoutPageUI.DYNAMIC_SHIPPING_ADDRESS_INFO_TEXT, attributesValue,textValue);
		return isElementDisplayed(driver, CheckoutPageUI.DYNAMIC_SHIPPING_ADDRESS_INFO_TEXT, attributesValue,textValue);
	}
	public boolean isShippingMethodGroundDisplayed(String shippingtMethod) {
		waitElementVisible(driver, CheckoutPageUI.SHIPPING_METHOD_TEXT, shippingtMethod);
		return isElementDisplayed(driver, CheckoutPageUI.SHIPPING_METHOD_TEXT, shippingtMethod);
	}
	
	public boolean isConfirmOrderProductInfoDisplayed(String attributesValue, String textValue) {
		waitElementVisible(driver, CheckoutPageUI.CONFIRM_ORDER_PRODUCT_INFO, attributesValue,textValue);
		return isElementDisplayed(driver, CheckoutPageUI.CONFIRM_ORDER_PRODUCT_INFO, attributesValue,textValue);
	}
	public boolean isConfirmOrderProductNameInfoDisplayed(String attributesValue, String textValue) {
		waitElementVisible(driver, CheckoutPageUI.CONFIRM_ORDER_PRODUCT_NAME_INFO, attributesValue,textValue);
		return isElementDisplayed(driver, CheckoutPageUI.CONFIRM_ORDER_PRODUCT_NAME_INFO, attributesValue,textValue);
	}
	public boolean isDynamicCartTotalInforDisplayed(String fielName, String textValue) {
		waitElementVisible(driver,CheckoutPageUI.CART_TOTAL_INFOR_TEXT ,fielName,textValue );
		return isElementDisplayed(driver,CheckoutPageUI.CART_TOTAL_INFOR_TEXT ,fielName,textValue);
	}
	public void clickToConfirmButton() {
		waitElementClickable(driver, CheckoutPageUI.CONFIRM_BUTTON);
		clickToElement(driver, CheckoutPageUI.CONFIRM_BUTTON);
	}
	public boolean isMessageOrderSuccessDisplayed(String textValue) {
		waitElementVisible(driver, CheckoutPageUI.MESSAGE_ORDER_SUCCESS_TEXT,textValue);
		return isElementDisplayed(driver, CheckoutPageUI.MESSAGE_ORDER_SUCCESS_TEXT,textValue);
	}
	public String getOrderNumber() {
		waitElementVisible(driver, CheckoutPageUI.ORDER_NUMBER_TEXT);
		return getTextElement(driver,  CheckoutPageUI.ORDER_NUMBER_TEXT);
	}
	
	
	
	


}
