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
		// wait click able
		waitElementClickable(driver, NewEditPostPageUI.PUBLISH_BUTTON);
		clickToElement(driver,NewEditPostPageUI.PUBLISH_BUTTON);
		// click

	}

	public void clickToUpdateButton() {

		// wait click able
		// click
		// wait invisible icon
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
		scrollToElement(driver, NewEditPostPageUI.CATEGORY_CHECKBOX, categoryValue);
		waitElementClickable(driver,NewEditPostPageUI.CATEGORY_CHECKBOX, categoryValue);
		clickToElement(driver, NewEditPostPageUI.CATEGORY_CHECKBOX, categoryValue);
		
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
		waitElementVisible(driver, NewEditPostPageUI.FEATURE_IMAGE_THUMNAIL,file[0]);
		return isElementDisplayed(driver, NewEditPostPageUI.FEATURE_IMAGE_THUMNAIL,file[0]);
	}

}
