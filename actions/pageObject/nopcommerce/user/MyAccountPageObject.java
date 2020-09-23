package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopcommerce.user.MyAccountPageUI;

public class MyAccountPageObject extends AbstractPage {
	WebDriver driver;

	public MyAccountPageObject(WebDriver driver) {
		this.driver=driver;
	}


}
