package pageUIs.nopcommerce.user;

public class CheckoutPageUI {
	public static final String DYNAMIC_BIILDING_TEXTBOX="//label[contains(text(),'%s')]//following-sibling::input";
	public static final String DYNAMIC_SHIPPING_TEXTBOX="//div[@class='shipping-addresses']//label[contains(text(),'%s')]//following-sibling::input";
	public static final String COUNTRY_BILLDING_DROPDOWN="//select[@id='BillingNewAddress_CountryId']";
	public static final String COUNTRY_SHIPPING_DROPDOWN="//select[@id='ShippingNewAddress_CountryId']";
	public static final String DYNAMIC_CONTINUE_BUTTON="//h2[text()='%s']//parent::div//following-sibling::div//input[@value='Continue']";
	public static final String DYNAMIC_NAME_SHIPPING_METHOD_RADIO_BUTTON="//label[contains(text(),'%s')]//preceding-sibling::input";
	public static final String DYNAMIC_NAME_PAYMENT_METHOD_RADIO_BUTTON="//label[contains(text(),'%s')]//preceding-sibling::input";
	public static final String DYNAMIC_BILLDING_ADDRESS_INFO_TEXT="//div[@class='billing-info']//li[@class='%s' and contains(text(),'%s')]";
	public static final String DYNAMIC_SHIPPING_ADDRESS_INFO_TEXT="//div[@class='shipping-info']//li[@class='%s' and contains(text(),'%s')]";
	public static final String SHIPPING_NEW_ADDRESS_DROPDOWN="//select[@id='shipping-address-select']";
	public static final String PAYMENT_METHOD_TEXT="//li[@class='payment-method']//span[@class='value' and contains(text(),'%s')]";
	public static final String SHIPPING_METHOD_TEXT="//li[@class='shipping-method']//span[@class='value' and contains(text(),'%s')]";
	public static final String CONFIRM_ORDER_PRODUCT_INFO="//td[@class='%s']//span[text()='%s']";
	public static final String CONFIRM_ORDER_PRODUCT_NAME_INFO="//td[@class='%s']//a[text()='%s']";
	public static final String SHIP_TO_THE_SAME_ADDRESS_CHECKBOX="//input[@id='ShipToSameAddress']";
	public static final String PAYMENT_INFORMATION_MESSAGE_TEXT="//b[contains(text(),'NOP SOLUTIONS')]";

}
