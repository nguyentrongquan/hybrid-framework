package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorNopcommerceManager;
import pageUIs.nopcommerce.user.ComputerPageUI;

public class ChangePasswordPageObject extends AbstractPage{
	private WebDriver driver;

	public ChangePasswordPageObject(WebDriver driver) {
		this.driver=driver;
	}


}
