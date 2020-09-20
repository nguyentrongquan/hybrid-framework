package pageObjects.wordPress.admin;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorWordPressManager;
import pageUIs.wordPress.admin.DashboardPageUI;

public class DashboardPageObject extends AbstractPage {
	private WebDriver driver;
	
	
	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}


	public boolean isDashboardHeaderDisplayed() {
		waitElementVisible(driver,DashboardPageUI.HEADER_DASHBOARD);
		return isElementDisplayed(driver,DashboardPageUI.HEADER_DASHBOARD);
	}




}
