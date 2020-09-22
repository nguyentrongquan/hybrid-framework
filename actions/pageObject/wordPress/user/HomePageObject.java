package pageObject.wordPress.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorWordPressManager;
import pageUIs.wordPress.user.HomePageUI;

public class HomePageObject extends AbstractPage {
	private WebDriver driver;
	
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}


	public PostDetailPageObject clickToDetailWithTitleName(String titleValue) {
		waitElementVisible(driver, HomePageUI.TITLE_POST_DETAIL_LINK,titleValue) ;
		clickToElementByJS(driver, HomePageUI.TITLE_POST_DETAIL_LINK, titleValue);
		sleepInSecond(2);
		return PageGeneratorWordPressManager.getDetailPostUserPage(driver);
		
	}


	

	

	


}
