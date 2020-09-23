package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorNopcommerceManager;
import pageUIs.nopcommerce.user.ComputerPageUI;

public class MyProductReviewPageObject extends AbstractPage{
	private WebDriver driver;

	public MyProductReviewPageObject(WebDriver driver) {
		this.driver=driver;
	}


}
