package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorNopcommerceManager;
import pageUIs.wordPress.user.HomePageUI;

public class HomePageObject extends AbstractPage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver=driver;
	}

	public NotebooksPageObject clickToNotebooksSubMenu() {
		waitElementClickable(driver, HomePageUI.SUB_MENU_BY_NAME);
		clickToElement(driver, HomePageUI.SUB_MENU_BY_NAME);
		return PageGeneratorNopcommerceManager.getNotebooksPage(driver);
	}



}
