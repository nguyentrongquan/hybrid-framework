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
		imageName= imageName.split("\\.")[0].toLowerCase();
		waitElementVisible(driver,PostDetailPageUI.DETAIL_POST_IMAGE,imageName);
		return isElementDisplayed(driver,PostDetailPageUI.DETAIL_POST_IMAGE,imageName)
				&& isImageLoaded(driver,PostDetailPageUI.DETAIL_POST_IMAGE,imageName);
		
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


	public boolean isPostDetailTagDisplayed(String postTag) {
		waitElementVisible(driver,PostDetailPageUI.DETAIL_POST_TAG, postTag);
		return isElementDisplayed(driver,PostDetailPageUI.DETAIL_POST_TAG, postTag);
	}


	public boolean isPostDetailTitleNameUnDisplayed(String newPostTitle) {
		return isElementUndisplayed(driver, PostDetailPageUI.DETAIL_POST_TITLE, newPostTitle);
	}


	public boolean isPostDetailCategoryNameUnDisplayed(String newPostCategory) {
		return isElementUndisplayed(driver, PostDetailPageUI.DETAIL_POST_CATEGORY, newPostCategory);
	}


	public boolean isPostDetailTagUnDisplayed(String postTag) {
		return isElementUndisplayed(driver,PostDetailPageUI.DETAIL_POST_TAG, postTag);
	}


	


}
