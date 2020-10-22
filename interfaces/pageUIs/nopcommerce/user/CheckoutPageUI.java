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
	public static final String CART_TOTAL_INFOR_TEXT="//label[contains(text(),'%s')]//parent::td//following-sibling::td//span[text()='%s']";
	public static final String CONFIRM_BUTTON="//input[@value='Confirm']";
	public static final String MESSAGE_ORDER_SUCCESS_TEXT="//strong[contains(text(),'%s')]";
	public static final String ORDER_NUMBER_TEXT="//div[@class='order-number']//strong";
	
	public static final String CREDIT_CARD_DOPDOWN="//select[@id='CreditCardType']";
	public static final String CARDHOLDER_NAME_TEXTBOX="//input[@id='CardholderName']";
	public static final String CARD_NUMBER_TEXTBOX="//input[@id='CardNumber']";
	public static final String EXPIRATION_MONTH_DROPDOWN="//select[@id='ExpireMonth']";
	public static final String EXPIRATION_YEAR_DROPDOWN="//select[@id='ExpireYear']";
	public static final String CARD_CODE_TEXTBOX="//input[@id='CardCode']";
	

}
