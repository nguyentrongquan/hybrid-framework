package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorNopcommerceManager;
import pageUIs.nopcommerce.user.ShoppingCartPageUI;

public class ShoppingCartPageObject extends AbstractPage{
	private WebDriver driver;

	public ShoppingCartPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public ProductDetailPageObject clickToEditProductLink() {
		sleepInSecond(1);
		waitElementClickable(driver, ShoppingCartPageUI.EDIT_PRODUCT_CART_LINK);
		clickToElement(driver, ShoppingCartPageUI.EDIT_PRODUCT_CART_LINK);
		return PageGeneratorNopcommerceManager.getProductDetailPage(driver);
	}

	public boolean isProductNameInShoppingCartDisplayed(String name) {
		waitElementVisible(driver, ShoppingCartPageUI.PRODUCT_NAME, name);
		return isElementDisplayed(driver, ShoppingCartPageUI.PRODUCT_NAME, name);
	}

	public boolean isProductProcessorInShoppingCartDisplayed(String textValue) {
		waitElementVisible(driver, ShoppingCartPageUI.PRODUCT_DETAIL, textValue);
		return isElementDisplayed(driver, ShoppingCartPageUI.PRODUCT_DETAIL, textValue);
	}

	public boolean isProductRAMInShoppingCartDisplayed(String ramValue) {
		waitElementVisible(driver, ShoppingCartPageUI.PRODUCT_DETAIL, ramValue);
		return isElementDisplayed(driver, ShoppingCartPageUI.PRODUCT_DETAIL, ramValue);
	}

	public boolean isProductHDDInShoppingCartDisplayed(String hddValue) {
		waitElementVisible(driver, ShoppingCartPageUI.PRODUCT_DETAIL, hddValue);
		return isElementDisplayed(driver, ShoppingCartPageUI.PRODUCT_DETAIL, hddValue);
	}

	public boolean isProductOSInShoppingCartDisplayed(String osValue) {
		waitElementVisible(driver, ShoppingCartPageUI.PRODUCT_DETAIL, osValue);
		return isElementDisplayed(driver, ShoppingCartPageUI.PRODUCT_DETAIL, osValue);
	}

	public boolean isProductSoftwareInShoppingCartDisplayed(String softwaveValue) {
		waitElementVisible(driver, ShoppingCartPageUI.PRODUCT_DETAIL, softwaveValue);
		return isElementDisplayed(driver, ShoppingCartPageUI.PRODUCT_DETAIL, softwaveValue);
	}

	public boolean isProductUnitPriceInShoppingCartDisplayed(String price) {
		waitElementVisible(driver, ShoppingCartPageUI.PRODUCT_UNIT_PRICE, price);
		return isElementDisplayed(driver,ShoppingCartPageUI.PRODUCT_UNIT_PRICE,price);
	}
	public String isProductQuantityInShoppingCartDisplayed(String value) {
		waitElementVisible(driver, ShoppingCartPageUI.PRODUCT_QUANTITY);
		String qtyValue= getAtributeValue(driver, ShoppingCartPageUI.PRODUCT_QUANTITY, value);
		return qtyValue;
	}

	public boolean isProductToTalInYourCartDisplayed(String totalPrice) {
		waitElementVisible(driver, ShoppingCartPageUI.PRODUCT_PRICE_TOTAL, totalPrice);
		return isElementDisplayed(driver,ShoppingCartPageUI.PRODUCT_PRICE_TOTAL,totalPrice);
	}

	public void selectToRemoveCheckbox() {
		waitElementClickable(driver, ShoppingCartPageUI.REMOVE_CHECKBOX);
		checkTheCheckbox(driver, ShoppingCartPageUI.REMOVE_CHECKBOX);
	}

	public void clickToUpdateShoppingCartButton() {
		waitElementClickable(driver, ShoppingCartPageUI.UPDATE_CART_BUTTON);
		clickToElement(driver, ShoppingCartPageUI.UPDATE_CART_BUTTON);
	}

	public boolean isMessageCartEmptyDisplayed(String message) {
		waitElementVisible(driver, ShoppingCartPageUI.MESSAGE_EMPTY_TEXT,message);
		return isElementDisplayed(driver, ShoppingCartPageUI.MESSAGE_EMPTY_TEXT,message);
	}

	public boolean isProductNameInYourCartUndisplayed(String nameproduct) {
		return isElementUndisplayed(driver, ShoppingCartPageUI.PRODUCT_NAME, nameproduct);
	}

	public void inputToQtyValue(String qtyValue) {
		waitElementVisible(driver, ShoppingCartPageUI.PRODUCT_QUANTITY);
		sendkeyToElementByJS(driver, ShoppingCartPageUI.PRODUCT_QUANTITY, qtyValue);
	}
	public void clickToAgreeTermsOfServiceCheckbox() {
		waitElementClickable(driver, ShoppingCartPageUI.TERM_OF_SERVICE_CHECKBOX);
		clickToElement(driver, ShoppingCartPageUI.TERM_OF_SERVICE_CHECKBOX);
	}

	public CheckoutPageObject clickToCheckoutButton() {
		waitElementClickable(driver, ShoppingCartPageUI.CHECK_OUT_BUTTON);
		clickToElement(driver, ShoppingCartPageUI.CHECK_OUT_BUTTON);
		return PageGeneratorNopcommerceManager.getCheckoutPage(driver);
		
	}
	


}
