package pageUIs.nopcommerce.user;

public class ProductDetailPageUI {
	public static final String ADD_NEW_REVIEW_LINK ="//div[@class='product-review-links']//a[contains(text(),'Add your review')]";
	public static final String MESSAGE_PRODUCT_ADD_SUCCESS ="//p[@class='content' and contains(text(),'The product has been added to your')]//a[text()='shopping cart']";
	public static final String PROCESSOR_DROPDOWN ="//select[@id='product_attribute_1']";
	public static final String RAM_DROPDOWN  ="//select[@id='product_attribute_2']";
	public static final String HDD_RADIO_BUTTON ="//label[contains(text(),'%s')]//preceding-sibling::input";
	public static final String OS_RADIO_BUTTON ="//label[contains(text(),'%s')]//preceding-sibling::input";
	public static final String SOFTWARE_CHECKBOX ="//label[contains(text(),'%s')]//preceding-sibling::input";
	public static final String PRICE_PRODUCT_TEXT ="//span[@id='price-value-1' and text()='%s']";
	public static final String UPDATE_AND_ADD_TO_CART_BUTTON="//div[@class='add-to-cart']//input[@type='button']";
	public static final String CLOSE_MESSAGE_BUTTON="//div[@id='bar-notification']//span[@class='close']";

	public static final String PRICE_TEXT="//span[@id='price-value-1' and text()='%s']";
	public static final String QUANTITY_TEXTBOX="//input[@id='product_enteredQuantity_1']";
}
