package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorNopcommerceManager;
import pageUIs.nopcommerce.user.ComputerPageUI;
import pageUIs.nopcommerce.user.MyProductReviewPageUI;

public class MyProductReviewPageObject extends AbstractPage{
	private WebDriver driver;

	public MyProductReviewPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public boolean isProductYourReviewNameDisplayed(String nameProduct) {
		waitElementVisible(driver, MyProductReviewPageUI.MY_PRODUCT_REVIEW_NAME,nameProduct);
		return isElementDisplayed(driver, MyProductReviewPageUI.MY_PRODUCT_REVIEW_NAME,nameProduct);
		
	}


}
