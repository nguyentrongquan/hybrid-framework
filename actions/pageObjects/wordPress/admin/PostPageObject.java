package pageObjects.wordPress.admin;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorWordPressManager;
import pageUIs.wordPress.admin.NewEditPostPageUI;
import pageUIs.wordPress.admin.PostPageUI;

public class PostPageObject extends AbstractPage {
	private WebDriver driver;
	
	
	public PostPageObject(WebDriver driver) {
		this.driver = driver;
	}


	public NewEditPostPageObject clickToAddNewButton() {
		waitElementVisible(driver, PostPageUI.ADD_NEW_POST_BUTTON);
		clickToElement(driver, PostPageUI.ADD_NEW_POST_BUTTON);
		return PageGeneratorWordPressManager.getNewEditPostAdminPage(driver);
	}


	public void inputToSearchPostTextbox(String searchTitleValue) {
		waitElementVisible(driver, PostPageUI.SEARCH_POST_TEXTBOX);
		sendkeyToElement(driver, PostPageUI.SEARCH_POST_TEXTBOX, searchTitleValue);
		
	}


	public void clickToSearchPostButton() {
		waitElementVisible(driver, PostPageUI.SEARCH_POST_BUTTON);
		clickToElement(driver, PostPageUI.SEARCH_POST_BUTTON);
		
	}

	public boolean isOnlyOneRowDisplayed(String titleValue, String authorValue , String categoryValue, String tagValue) {
		waitElementVisible(driver, PostPageUI.SEARCH_ONLY_ONE_ROW, titleValue,authorValue,categoryValue,tagValue);
		int rowNumber = countElementNumber(driver,PostPageUI.SEARCH_ONLY_ONE_ROW, titleValue,authorValue,categoryValue,tagValue);
		return rowNumber == 1 && isElementDisplayed(driver,PostPageUI.SEARCH_ONLY_ONE_ROW, titleValue,authorValue,categoryValue,tagValue);
	}

	public NewEditPostPageObject clickToPostWithTitleName(String editPostTitle) {
		waitElementClickable(driver, PostPageUI.EDIT_POST_BY_TITLE_NAME, editPostTitle);
		clickToElement(driver, PostPageUI.EDIT_POST_BY_TITLE_NAME, editPostTitle);
		return PageGeneratorWordPressManager.getNewEditPostAdminPage(driver);
	}


	public boolean isPostSuccessMessageDisplayedWithValue(String textMessageValue) {
		waitElementVisible(driver, PostPageUI.POST_SUCCESS_MESSAGE, textMessageValue);
		return isElementDisplayed(driver,PostPageUI.POST_SUCCESS_MESSAGE, textMessageValue);
	}


	public boolean isNoPostFoundMessageDisplayed(String textMessage) {
		waitElementVisible(driver, PostPageUI.POST_SEARCH_NO_FOUND, textMessage);
		return isElementDisplayed(driver,PostPageUI.POST_SEARCH_NO_FOUND, textMessage);
		
	}


	public boolean isPostDeletedUnDisplayedOnSearchPost(String titleValue, String authorValue, String categoryValue,
			String tagValue) {
		
		return isElementUndisplayed(driver,PostPageUI.SEARCH_ONLY_ONE_ROW, titleValue,authorValue,categoryValue,tagValue);
	}

	
}
