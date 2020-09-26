package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorNopcommerceManager;
import pageUIs.nopcommerce.user.ComputerPageUI;
import pageUIs.nopcommerce.user.SearchPageUI;

public class SearchPageObject extends AbstractPage{
	private WebDriver driver;

	public SearchPageObject(WebDriver driver) {
		this.driver=driver;
	}


	public void clickToSearchButton() {
		waitElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
	}
	
	public boolean isErrorMessageDisplayed(String message) {
	waitElementVisible(driver, SearchPageUI.ERROR_MESSAGE,message);
	return isElementDisplayed(driver,SearchPageUI.ERROR_MESSAGE,message);
	}


	public void inputToSearchKeywordTextbox(String text) {
		waitElementVisible(driver, SearchPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver,  SearchPageUI.SEARCH_TEXTBOX, text);
		
	}


}
