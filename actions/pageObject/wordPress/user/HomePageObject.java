package pageObject.wordPress.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUIs.wordPress.admin.DashboardPageUI;
import pageUIs.wordPress.user.HomePageUI;

public class HomePageObject extends AbstractPage {
	private WebDriver driver;
	
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}


	public PostDetailPageObject clickToDetailWithTitleName() {
		
		return PageGeneratorManager.getDetailPostUserPage(driver);
	}


	public boolean isNewPostDisplayedOnLatestPost(String categoryValue, String titleValue, String dateValue) {
		waitElementVisible(driver, HomePageUI.NEW_LATEST_POST, categoryValue,titleValue,dateValue);
		return isElementDisplayed(driver, HomePageUI.NEW_LATEST_POST, categoryValue,titleValue,dateValue);
	}


	public boolean isPostImageDisplayedAtPostTitleName(String string, String string2) {
		// TODO Auto-generated method stub
		return false;
	}


}
