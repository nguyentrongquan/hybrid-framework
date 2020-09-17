package pageObjects.wordPress.admin;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUIs.wordPress.admin.NewEditPostPageUI;

public class NewEditPostPageObject extends AbstractPage {
	private WebDriver driver;

	public NewEditPostPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToPublishButton() {
		waitElementClickable(driver, NewEditPostPageUI.PUBLISH_BUTTON);
		clickToElementByJS(driver,NewEditPostPageUI.PUBLISH_BUTTON);

	}

	public void clickToUpdateButton() {
		waitElementClickable(driver, NewEditPostPageUI.PUBLISH_BUTTON);
		clickToElementByJS(driver,NewEditPostPageUI.PUBLISH_BUTTON);
	}

	public PostPageObject clickToMoveTrashButton() {
		// TODO Auto-generated method stub
		return PageGeneratorManager.getPostAdminPage(driver);
	}

	public void inputToPostTitleTextbox(String titleValue) {
		waitElementVisible(driver, NewEditPostPageUI.POST_TITLE_TEXTBOX);
		sendkeyToElement(driver, NewEditPostPageUI.POST_TITLE_TEXTBOX, titleValue);
	}

	public void inputToPostContentTextbox(String contentValue) {
		switchToFrameOrIframe(driver, NewEditPostPageUI.TINY_MCE_IFRAME);
		waitElementVisible(driver, NewEditPostPageUI.POST_CONTENT_TEXTBOX);
		sendkeyToElement(driver, NewEditPostPageUI.POST_CONTENT_TEXTBOX, contentValue);
		switchToDefaultContent(driver);
		
	}

	public void selectCategoryCheckbox(String categoryValue) {
		waitElementClickable(driver,NewEditPostPageUI.CATEGORY_CHECKBOX, categoryValue);
		sleepInSecond(1);
		checkTheCheckbox(driver,  NewEditPostPageUI.CATEGORY_CHECKBOX, categoryValue);
		//clickToElementByJS(driver, NewEditPostPageUI.CATEGORY_CHECKBOX, categoryValue);
		
	}
	public void deSelectCategoryCheckbox(String categoryValue) {
		waitElementClickable(driver,NewEditPostPageUI.CATEGORY_CHECKBOX, categoryValue);
		sleepInSecond(1);
		uncheckToTheCheckbox(driver,NewEditPostPageUI.CATEGORY_CHECKBOX, categoryValue);
		//clickToElementByJS(driver, NewEditPostPageUI.CATEGORY_CHECKBOX, categoryValue);
	}

	public void inputToTagTextbox(String tagValue) {
		waitElementVisible(driver, NewEditPostPageUI.TAG_TEXTBOX);
		sendkeyToElement(driver, NewEditPostPageUI.TAG_TEXTBOX, tagValue);
	}

	public void clickToTagButton() {
		waitElementClickable(driver, NewEditPostPageUI.ADD_TAG_BUTTON);
		clickToElement(driver, NewEditPostPageUI.ADD_TAG_BUTTON);
		
	}

	public void clickToSetFeatureImageLink() {
		waitElementClickable(driver, NewEditPostPageUI.SET_FEATURED_IMAGE_LINK);
		clickToElement(driver, NewEditPostPageUI.SET_FEATURED_IMAGE_LINK);
	}


	public void clickToUploadFilesTab() {
		waitElementClickable(driver, NewEditPostPageUI.UPLOAD_FILES_TAB);
		clickToElement(driver,  NewEditPostPageUI.UPLOAD_FILES_TAB);
	}

	public void clickToSetFeaturedImageButton() {
		waitElementClickable(driver, NewEditPostPageUI.FEATURED_IMAGE_UPLOAD_BUTTON);
		clickToElement(driver,  NewEditPostPageUI.FEATURED_IMAGE_UPLOAD_BUTTON);
		
	}

	public boolean isPostSuccessMessageDisplayedWithValue(String textMessageValue) {
		waitElementVisible(driver, NewEditPostPageUI.POST_SUCCESS_MESSAGE, textMessageValue);
		return isElementDisplayed(driver,NewEditPostPageUI.POST_SUCCESS_MESSAGE, textMessageValue);
	}

	public boolean isUploadFilesImageDisplayed(String imageValue) {
		String[] file= imageValue.split("\\.");
		waitElementVisible(driver, NewEditPostPageUI.FEATURE_IMAGE_THUMNAIL,file[0].toLowerCase());
		return isElementDisplayed(driver, NewEditPostPageUI.FEATURE_IMAGE_THUMNAIL,file[0].toLowerCase());
	}

	

	public void clickToDeleteWithTagName(String newPostTag) {
		waitElementClickable(driver, NewEditPostPageUI.REMOVE_TAG_BUTTON_BY_NAME,newPostTag);
		clickToElement(driver,  NewEditPostPageUI.REMOVE_TAG_BUTTON_BY_NAME,newPostTag);
	}

}
