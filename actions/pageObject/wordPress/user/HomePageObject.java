package pageObject.wordPress.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUIs.wordPress.admin.DashboardPageUI;
import pageUIs.wordPress.admin.NewEditPostPageUI;
import pageUIs.wordPress.user.HomePageUI;

public class HomePageObject extends AbstractPage {
	private WebDriver driver;
	
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}


	public PostDetailPageObject clickToDetailWithTitleName(String titleValue) {
		
		waitElementVisible(driver, HomePageUI.TITLE_POST_LINK,titleValue) ;
		clickToElement(driver, HomePageUI.TITLE_POST_LINK, titleValue);
		
		return PageGeneratorManager.getDetailPostUserPage(driver);
	}


	public boolean isPostDisplayedOnLatestPost(String titleValue,String categoryValue,String dateValue) {
		waitElementVisible(driver, HomePageUI.NEW_LATEST_POST, titleValue,categoryValue,dateValue);
		return isElementDisplayed(driver, HomePageUI.NEW_LATEST_POST,titleValue,categoryValue,dateValue);
	}


	public boolean isPostImageDisplayedAtPostTitleName(String imageValue) {
		String[] file= imageValue.split("\\.");
		waitElementVisible(driver, HomePageUI.FEATURE_IMAGE_NEW_POST,file[0].toLowerCase());
		return isElementDisplayed(driver, HomePageUI.FEATURE_IMAGE_NEW_POST,file[0].toLowerCase());
	}


}
