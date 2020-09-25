package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopcommerce.user.ProductDetailPageUI;

public class ProductDetailPageObject extends AbstractPage {
	private WebDriver driver;

	public ProductDetailPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public void clickToAddYourReview() {
		waitElementClickable(driver, ProductDetailPageUI.ADD_NEW_REVIEW_LINK);
		clickToElement(driver, ProductDetailPageUI.ADD_NEW_REVIEW_LINK);
	}

	

	



}
