package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopcommerce.user.OrderPageUI;

public class OrderPageObject extends AbstractPage{
	private WebDriver driver;

	public OrderPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public boolean isOrderNumberDisplayed(String orderNumber) {
		waitElementVisible(driver,OrderPageUI.ORDER_NUMBER_TEXT,orderNumber);
		return isElementDisplayed(driver, OrderPageUI.ORDER_NUMBER_TEXT, orderNumber);
	}

	public void clicktoDetailsLink() {
		waitElementClickable(driver, OrderPageUI.DETAIL_LINK);
		clickToElement(driver, OrderPageUI.DETAIL_LINK);
		
	}
}
