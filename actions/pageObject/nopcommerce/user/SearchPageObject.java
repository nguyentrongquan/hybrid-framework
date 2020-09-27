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

	public boolean isTwoProductNameDisplayed(String nameProduct) {
		waitElementVisible(driver, SearchPageUI.NAME_PRODUCT_TEXT, nameProduct);
		int productNumber = finds(driver, SearchPageUI.PRODUCT_NUMBER).size();
		return isElementDisplayed(driver,  SearchPageUI.NAME_PRODUCT_TEXT, nameProduct)
				&& productNumber == 2;
	}

	public boolean isOneProductNameDisplayed(String nameProduct) {
		waitElementVisible(driver, SearchPageUI.NAME_PRODUCT_TEXT, nameProduct);
		int productNumber = finds(driver, SearchPageUI.PRODUCT_NUMBER).size();
		return isElementDisplayed(driver,  SearchPageUI.NAME_PRODUCT_TEXT, nameProduct)
				&& productNumber == 1;
	}
	public void clickToAdvancedSearchCheckbox() {
		waitElementClickable(driver, SearchPageUI.ADVANCED_SEARCH_CHECKBOX);
		checkTheCheckbox(driver, SearchPageUI.ADVANCED_SEARCH_CHECKBOX);
	}


	public void SelectToCategoryDropdown(String itemValue) {
		waitElementClickable(driver, SearchPageUI.CATEGORY_DROPDOWN);
		selectItemInDropdown(driver, SearchPageUI.CATEGORY_DROPDOWN, itemValue);
		
	}


	public void AutomaticallySearchSubCategoriesUnChecked() {
		waitElementClickable(driver, SearchPageUI.AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX);
		uncheckToTheCheckbox(driver, SearchPageUI.AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX);
		
	}


	public void AutomaticallySearchSubCategoriesChecked() {
		waitElementClickable(driver, SearchPageUI.AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX);
		checkTheCheckbox(driver, SearchPageUI.AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX);
	}


	public void SelectToManufacturerDropdown(String itemValue) {
		waitElementClickable(driver, SearchPageUI.MANUFACTURER_DROPDOWN);
		selectItemInDropdown(driver, SearchPageUI.MANUFACTURER_DROPDOWN, itemValue);
	}

	public void inputToPriceFromRange(String price) {
		waitElementVisible(driver, SearchPageUI.PRICE_RANGE_FROM);
		sendkeyToElement(driver, SearchPageUI.PRICE_RANGE_FROM, price);
	}

	public void inputToPriceToRange(String price) {
		waitElementVisible(driver, SearchPageUI.PRICE_RANGE_TO);
		sendkeyToElement(driver, SearchPageUI.PRICE_RANGE_TO, price);
		
	}


}
