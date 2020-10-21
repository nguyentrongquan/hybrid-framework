package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopcommerce.user.OrderDetailPageUI;

public class OrderDetailPageObject extends AbstractPage{
	private WebDriver driver;

	public OrderDetailPageObject(WebDriver driver) {
		this.driver=driver;
	}

	
	public boolean isOrderDateDisplayed(String orderDate) {
		waitElementVisible(driver, OrderDetailPageUI.ORDER_DATE_TEXT,orderDate);
		return isElementDisplayed(driver, OrderDetailPageUI.ORDER_DATE_TEXT, orderDate);
	}

	public boolean isOrderStatusDisplayed(String orderStatus) {
		waitElementVisible(driver, OrderDetailPageUI.ORDER_STATUS_TEXT,orderStatus);
		return isElementDisplayed(driver, OrderDetailPageUI.ORDER_STATUS_TEXT, orderStatus);
	}

	public boolean isOrderTotalDisplayed(String orderTotal) {
		waitElementVisible(driver, OrderDetailPageUI.ORDER_TOTAL_TEXT,orderTotal);
		return isElementDisplayed(driver, OrderDetailPageUI.ORDER_TOTAL_TEXT, orderTotal);
	}
	public boolean isDynamicBilldingInfodisplayed(String attributesValue, String textValue) {
		waitElementVisible(driver, OrderDetailPageUI.DYNAMIC_BILLDING_ADDRESS_INFO_TEXT, attributesValue,textValue);
		return isElementDisplayed(driver, OrderDetailPageUI.DYNAMIC_BILLDING_ADDRESS_INFO_TEXT, attributesValue,textValue);
		
	}
	public boolean isPaymentMethodNameDisplayed(String paymentMethod) {
		waitElementVisible(driver, OrderDetailPageUI.PAYMENT_METHOD_TEXT, paymentMethod);
		return isElementDisplayed(driver, OrderDetailPageUI.PAYMENT_METHOD_TEXT, paymentMethod);
	}
	public boolean isDynamicShippingInfodisplayed(String attributesValue, String textValue) {
		waitElementVisible(driver, OrderDetailPageUI.DYNAMIC_SHIPPING_ADDRESS_INFO_TEXT, attributesValue,textValue);
		return isElementDisplayed(driver, OrderDetailPageUI.DYNAMIC_SHIPPING_ADDRESS_INFO_TEXT, attributesValue,textValue);
	}
	public boolean isShippingMethodGroundDisplayed(String shippingtMethod) {
		waitElementVisible(driver, OrderDetailPageUI.SHIPPING_METHOD_TEXT, shippingtMethod);
		return isElementDisplayed(driver, OrderDetailPageUI.SHIPPING_METHOD_TEXT, shippingtMethod);
	}
	
	public boolean isConfirmOrderProductInfoDisplayed(String attributesValue, String textValue) {
		waitElementVisible(driver, OrderDetailPageUI.CONFIRM_ORDER_PRODUCT_INFO, attributesValue,textValue);
		return isElementDisplayed(driver, OrderDetailPageUI.CONFIRM_ORDER_PRODUCT_INFO, attributesValue,textValue);
	}
	public boolean isConfirmOrderProductNameInfoDisplayed(String attributesValue, String textValue) {
		waitElementVisible(driver, OrderDetailPageUI.CONFIRM_ORDER_PRODUCT_NAME_INFO, attributesValue,textValue);
		return isElementDisplayed(driver, OrderDetailPageUI.CONFIRM_ORDER_PRODUCT_NAME_INFO, attributesValue,textValue);
	}
	public boolean isDynamicCartTotalInforDisplayed(String fielName, String textValue) {
		waitElementVisible(driver,OrderDetailPageUI.CART_TOTAL_INFOR_TEXT ,fielName,textValue );
		return isElementDisplayed(driver,OrderDetailPageUI.CART_TOTAL_INFOR_TEXT ,fielName,textValue);
	}


}
