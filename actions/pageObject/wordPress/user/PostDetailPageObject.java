package pageObject.wordPress.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.AbstractWordPressPageUIs;
import commons.PageGeneratorManager;
import pageUIs.wordPress.user.PostDetailPageUI;

public class PostDetailPageObject extends AbstractPage {
	private WebDriver driver;
	
	
	public PostDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}


	public boolean isPostDetailTitleNameDisplayed(String titlename) {
		waitElementVisible(driver,PostDetailPageUI.DETAIL_POST_TITLE, titlename);
		return isElementDisplayed(driver,PostDetailPageUI.DETAIL_POST_TITLE, titlename);
	}


	public boolean isPostDetailCategoryNameDisplayed(String categoryName) {
		waitElementVisible(driver,PostDetailPageUI.DETAIL_POST_CATEGORY, categoryName);
		return isElementDisplayed(driver,PostDetailPageUI.DETAIL_POST_CATEGORY, categoryName);
	}


	public boolean isPostDetailImageNameDisplayed(String imageName) {
		String[] file= imageName.split("\\.");
		waitElementVisible(driver,PostDetailPageUI.DETAIL_POST_IMAGE, file[0].toLowerCase());
		return isElementDisplayed(driver,PostDetailPageUI.DETAIL_POST_IMAGE, file[0].toLowerCase());
	}


	public boolean isPostDetailContentDisplayed(String contentValue) {
		waitElementVisible(driver,PostDetailPageUI.DETAIL_POST_CONTENT, contentValue);
		return isElementDisplayed(driver,PostDetailPageUI.DETAIL_POST_CONTENT, contentValue);
	}


	public boolean isPostDetailDateCreatedDisplayed(String dateCreated) {
		waitElementVisible(driver,PostDetailPageUI.DETAIL_POST_DATE_CREATED, dateCreated);
		return isElementDisplayed(driver,PostDetailPageUI.DETAIL_POST_DATE_CREATED, dateCreated);
	}


	public boolean isPostDetailAuthorDisplayed(String authorName) {
		waitElementVisible(driver,PostDetailPageUI.DETAIL_POST_AUTHOR, authorName);
		return isElementDisplayed(driver,PostDetailPageUI.DETAIL_POST_AUTHOR, authorName);
	}


	public SearchResultPageObject inputToSearchTexboxAtEndUserPage(WebDriver driver, String titleValue) {
		waitElementClickable(driver,AbstractWordPressPageUIs.SEARCH_POST_ACTIVE_BUTTON_USER_PAGE );
		clickToElement(driver,AbstractWordPressPageUIs.SEARCH_POST_ACTIVE_BUTTON_USER_PAGE);
		waitElementVisible(driver,AbstractWordPressPageUIs.SEARCH_POST_BY_TITLE_USER_PAGE,titleValue );
		sendkeyToElement(driver,AbstractWordPressPageUIs.SEARCH_POST_BY_TITLE_USER_PAGE, titleValue);
		waitElementClickable(driver, AbstractWordPressPageUIs.SEARCH_POST_BUTTON_USER_PAGE);
		clickToElement(driver, AbstractWordPressPageUIs.SEARCH_POST_BUTTON_USER_PAGE);
		// TODO Auto-generated method stub
		return PageGeneratorManager.getSearchRultUserPage(driver);
	}


}
