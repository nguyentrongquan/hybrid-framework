package pageObject.wordPress.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.wordPress.admin.DashboardPageUI;
import pageUIs.wordPress.user.SearchReSultPageUI;

public class SearchResultPageObject extends AbstractPage {
	private WebDriver driver;
	
	
	public SearchResultPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPostTitleDisplayedOnHeader(String newPostTitle) {
		waitElementVisible(driver, SearchReSultPageUI.POST_TITLE_ON_HEADER, newPostTitle);
		return isElementDisplayed(driver, SearchReSultPageUI.POST_TITLE_ON_HEADER, newPostTitle);
	}

	public boolean isMessagePostNoFoundDisplayed() {
		waitElementVisible(driver, SearchReSultPageUI.POST_NO_FOUND_MESSAGE);
		return isElementDisplayed(driver, SearchReSultPageUI.POST_NO_FOUND_MESSAGE);
	}


}
