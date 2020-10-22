package pageUIs.nopcommerce.user;

public class OrderDetailPageUI {
	public static final String ORDER_DATE_TEXT="//li[@class='order-date' and contains(text(),'%s)]";
	public static final String ORDER_STATUS_TEXT="//li[@class='order-status' and contains(text(),'%s')]";
	public static final String ORDER_TOTAL_TEXT="//li[@class='order-total']//strong[text()='$3,600.00']";
	public static final String DYNAMIC_BILLDING_ADDRESS_INFO_TEXT="//div[@class='billing-info']//li[@class='%s' and contains(text(),'%s')]";
	public static final String DYNAMIC_SHIPPING_ADDRESS_INFO_TEXT="//div[@class='shipping-info']//li[@class='%s' and contains(text(),'%s')]";
	public static final String SHIPPING_NEW_ADDRESS_DROPDOWN="//select[@id='shipping-address-select']";
	public static final String PAYMENT_METHOD_TEXT="//li[@class='payment-method']//span[@class='value' and contains(text(),'%s')]";
	public static final String SHIPPING_METHOD_TEXT="//li[@class='shipping-method']//span[@class='value' and contains(text(),'%s')]";
	public static final String CONFIRM_ORDER_PRODUCT_INFO="//td[@class='%s']//span[text()='%s']";
	public static final String CONFIRM_ORDER_PRODUCT_NAME_INFO="//td[@class='%s']//a[text()='%s']";
	public static final String SHIP_TO_THE_SAME_ADDRESS_CHECKBOX="//input[@id='ShipToSameAddress']";
	public static final String PAYMENT_INFORMATION_MESSAGE_TEXT="//b[contains(text(),'NOP SOLUTIONS')]";
	public static final String CART_TOTAL_INFOR_TEXT="//label[contains(text(),'%s')]//parent::td//following-sibling::td//span[text()='%s']";
	public static final String CART_ORDER_TOTAL_PRICE="//label[contains(text(),'%s')]//parent::td//following-sibling::td//strong[text()='%s']";

}
