package pageObject.wordPress.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.wordPress.admin.DashboardPageUI;

public class SearchResultPageObject extends AbstractPage {
	private WebDriver driver;
	
	
	public SearchResultPageObject(WebDriver driver) {
		this.driver = driver;
	}


	public boolean isNewPostDisplayedOnLatestPost(String string, String string2, String string3) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean isPostImageDisplayedAtPostTitleName(String string, String string2) {
		// TODO Auto-generated method stub
		return false;
	}


}
