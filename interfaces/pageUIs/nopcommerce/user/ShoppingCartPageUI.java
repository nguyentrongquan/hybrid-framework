package pageUIs.nopcommerce.user;

public class ShoppingCartPageUI {
	public static final String EDIT_PRODUCT_CART_LINK="//a[text()='Edit']";
	public static final String PRODUCT_NAME="//a[@class='product-name' and text()='%s']";
	public static final String PRODUCT_UNIT_PRICE="//td[@class='unit-price']//span[text()='%s']";
	public static final String PRODUCT_DETAIL="//td//div[@class='attributes' and text()='%s']";
	public static final String PRODUCT_QUANTITY="//input[@class='qty-input']";
	public static final String PRODUCT_PRICE_TOTAL="//td[@class='subtotal']//span[text()='%s']";
	
	public static final String REMOVE_CHECKBOX="//input[@name='removefromcart']";
	public static final String UPDATE_CART_BUTTON="//input[@name='updatecart']";
	public static final String MESSAGE_EMPTY_TEXT="//div[@class='no-data' and contains(text(),'%s')]";
	public static final String TERM_OF_SERVICE_CHECKBOX="//input[@id='termsofservice']";
	public static final String CHECK_OUT_BUTTON="//button[@id='checkout']";

}
