package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopcommerce.user.HomePageUI;

public class HomePageObject extends AbstractPage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver=driver;
	}

	public boolean isHomePageDisplayed() {
		waitElementVisible(driver, HomePageUI.LOG_OUT_TEXT);
		return isElementDisplayed(driver, HomePageUI.LOG_OUT_TEXT);
	}

	

	



}
