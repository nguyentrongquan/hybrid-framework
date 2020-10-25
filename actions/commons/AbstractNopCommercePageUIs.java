package commons;

public class AbstractNopCommercePageUIs {
	public static final String DYNAMIC_HEADER_PAGE_BY_PAGE_NAME="//div[@class='header-links']//a[text()='%s']";
	public static final String DYNAMIC_FOOTER_PAGE_BY_PAGE_NAME="//div[@class='footer']//a[text()='%s']";
	public static final String DYNAMIC_MENU_OR_SUB_MENU_HEADER_NAME="//ul[@class='top-menu notmobile']//a[contains(text(),'%s')]";
	public static final String DYNAMIC_TEXTBOX="//input[@name='%s']";
	public static final String DYNAMIC_MENU_LIST_MYACCOUNT="//div[@class='listbox']//a[text()='%s']";
	public static final String DYNAMIC_SUB_MENU_LINK="//ul[@class='top-menu notmobile']//a[contains(text(),'%s')]";
	public static final String DYNAMIC_PRODUCT_DETAIL_NAME="//h2[@class='product-title']//a[contains(text(),'%s')]";
	public static final String GO_TO_CART_BUTTON="//input[@value='Go to cart']";
	public static final String SHOPPING_CART_LINK="//span[text()='Shopping cart']";
	
	public static final String COUNT_ITEM_IN_SHOPPING_MINI_CART_TEXT="//div[@class='mini-shopping-cart']//div[@class='count']//a[text()='%s']";
	public static final String PRODUCT_NAME_IN_SHOPPING_MINI_CART_TEXT="//div[@class='mini-shopping-cart']//div[@class='name']//a[contains(text(),'%s')]";
	public static final String PRODUCT_DETAIL_PROCESSOR_IN_SHOPPING_MINI_CART_TEXT="//div[@class='mini-shopping-cart']//div[@class='attributes' and contains(text(),'%s')]";
	public static final String PRODUCT_DETAIL_IN_SHOPPING_MINI_CART_TEXT="//div[@class='mini-shopping-cart']//div[@class='attributes' and contains(string(),'%s')]";
	public static final String PRODUCT_UNIT_PRICE_IN_SHOPPING_MINI_CART_TEXT="//div[@class='mini-shopping-cart']//div[@class='price' and contains(text(),'Unit price:')]//span[text()='%s']";
	public static final String PRODUCT_QUANTITY_IN_SHOPPING_MINI_CART_TEXT="//div[@class='mini-shopping-cart']//div[@class='quantity']//span[text()='%s']";
	public static final String PRODUCT_SUB_TOTAL_IN_SHOPPING_MINI_CART_TEXT="//div[@class='mini-shopping-cart']//div[@class='totals']//strong[text()='%s']";
}
