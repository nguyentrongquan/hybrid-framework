package commons;

import org.openqa.selenium.WebDriver;

import pageObject.wordPress.user.PostDetailPageObject;
import pageObject.wordPress.user.HomePageObject;
import pageObject.wordPress.user.SearchResultPageObject;
import pageObjects.wordPress.admin.DashboardPageObject;
import pageObjects.wordPress.admin.LoginPageObject;
import pageObjects.wordPress.admin.NewEditPostPageObject;
import pageObjects.wordPress.admin.PostPageObject;

public class PageGeneratorManager {
	public static LoginPageObject getLoginAdminPage(WebDriver driver) {
		return new LoginPageObject(driver);
		
	}
	public static DashboardPageObject getDashboardAdminPage(WebDriver driver) {
		return new DashboardPageObject(driver);
		
	}
	public static  PostPageObject getPostAdminPage(WebDriver driver) {
		return new  PostPageObject(driver);
		
	}
	public static NewEditPostPageObject getNewEditPostAdminPage(WebDriver driver) {
		return new NewEditPostPageObject(driver);
		
	}
	public static SearchResultPageObject getSearchRultUserPage(WebDriver driver) {
		return new SearchResultPageObject(driver);
		
	}
	public static HomePageObject getHomeUserPage(WebDriver driver) {
		return new HomePageObject(driver);
		
	}
	public static PostDetailPageObject getDetailPostUserPage(WebDriver driver) {
		return new PostDetailPageObject(driver);
		
	}

}
