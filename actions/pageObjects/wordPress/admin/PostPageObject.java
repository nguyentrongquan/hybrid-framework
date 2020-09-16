package pageObjects.wordPress.admin;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUIs.wordPress.admin.PostPageUI;

public class PostPageObject extends AbstractPage {
	private WebDriver driver;
	
	
	public PostPageObject(WebDriver driver) {
		this.driver = driver;
	}


	public NewEditPostPageObject clickToAddNewButton() {
		waitElementVisible(driver, PostPageUI.ADD_NEW_POST_BUTTON);
		clickToElement(driver, PostPageUI.ADD_NEW_POST_BUTTON);
		return PageGeneratorManager.getNewEditPostAdminPage(driver);
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
		return PageGeneratorManager.getNewEditPostAdminPage(driver);
	}

	
}
