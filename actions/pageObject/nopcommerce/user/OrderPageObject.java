package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorNopcommerceManager;
import pageUIs.nopcommerce.user.OrderPageUI;

public class OrderPageObject extends AbstractPage{
	private WebDriver driver;

	public OrderPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public String getOrderNumberInMyaccount( ) {
		
		waitElementVisible(driver,OrderPageUI.ORDER_NUMBER_TEXT);
		String	orderNumber = getTextElement(driver, OrderPageUI.ORDER_NUMBER_TEXT);
		return orderNumber.toLowerCase();
	}

	public OrderDetailPageObject clicktoDetailsLink() {
		waitElementClickable(driver, OrderPageUI.DETAIL_LINK);
		clickToElement(driver, OrderPageUI.DETAIL_LINK);
		return PageGeneratorNopcommerceManager.getOrderDetailPage(driver);
	}
}
