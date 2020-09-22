package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.AbstractPage;
import pageUIs.nopcommerce.user.NotebooksPageUI;

public class NotebooksPageObject extends AbstractPage{
	 WebDriver driver;
	public NotebooksPageObject(WebDriver driver) {
		this.driver= driver;
	}
	public void SelecItemSortDropDownByName(String itemValue) {
		waitElementClickable(driver, NotebooksPageUI.SORT_BY_ITEM_DROPDOWN);
		selectItemInDropdown(driver, NotebooksPageUI.SORT_BY_ITEM_DROPDOWN, itemValue);
		
	}
	public boolean isNameSortAscending() {
		waitElementVisible(driver, NotebooksPageUI.SORT_NAME);
		return isNameSortAscending(driver,NotebooksPageUI.SORT_NAME);
	}
	public boolean isNameSortDecending() {
			waitElementVisible(driver, NotebooksPageUI.SORT_NAME);
			return isNameSortDecending(driver, NotebooksPageUI.SORT_NAME);
	}
	public boolean isPriceSortAscending() {
		waitElementVisible(driver, NotebooksPageUI.SORT_PRICE);
		return isPriceSortAscending(driver, NotebooksPageUI.SORT_PRICE);
	}
	public boolean isPriceSortDecending() {
		waitElementVisible(driver, NotebooksPageUI.SORT_PRICE);
		return isPriceSortDecending(driver, NotebooksPageUI.SORT_PRICE);
	}
	public void SelecItemDisplayDropDownBySize(String sizeValue) {
		waitElementClickable(driver, NotebooksPageUI.DISPLAY_PAGE_SIZE);
		selectItemInDropdown(driver, NotebooksPageUI.DISPLAY_PAGE_SIZE, sizeValue);
		
	}
	public boolean isPageActiveByIndex(String pageValue) {
		waitElementVisible(driver, NotebooksPageUI.DYNAMIC_PAGE_ACTIVED_BY_INDEX, pageValue);
		return isElementDisplayed(driver, NotebooksPageUI.DYNAMIC_PAGE_ACTIVED_BY_INDEX, pageValue);
	}
	public boolean isHaveLessThanOrEqual3ProductsInPageDisplayed() {
		waitElementVisible(driver, NotebooksPageUI.PRODUCT_NAME);
		int productsNumber= finds(driver, NotebooksPageUI.PRODUCT_NAME).size();
		return isElementDisplayed(driver, NotebooksPageUI.PRODUCT_NAME) && productsNumber <=3;
	}
	public boolean isPagingNextIconInPageDisplayed() {
		waitElementVisible(driver, NotebooksPageUI.PAGGING_NEXT_ICON);
		return isElementDisplayed(driver, NotebooksPageUI.PAGGING_NEXT_ICON);
	}
	public void navigateToPageNumberByIndex(String pageIndex) {
		waitElementClickable(driver, NotebooksPageUI.DYNAMIC_NAVIGATE_PAGE_BY_INDEX, pageIndex);
		clickToElement(driver,  NotebooksPageUI.DYNAMIC_NAVIGATE_PAGE_BY_INDEX, pageIndex);
		
	}
	public boolean isPagingPreviousIconInPageDisplayed() {
		waitElementVisible(driver, NotebooksPageUI.PAGGING_PREVIOUS_ICON);
		return isElementDisplayed(driver, NotebooksPageUI.PAGGING_PREVIOUS_ICON);
	}
	public boolean isHaveLessThanOrEqual6ProductsInPageDisplayed() {
		waitElementVisible(driver, NotebooksPageUI.PRODUCT_NAME);
		int productsNumber= finds(driver, NotebooksPageUI.PRODUCT_NAME).size();
		return isElementDisplayed(driver, NotebooksPageUI.PRODUCT_NAME) && productsNumber <=6;
		
	}
	public boolean isPagingUnDisplayed() {
		
		return isElementUndisplayed(driver, NotebooksPageUI.PAGGING_UNDISPLAYED);
	}
	public boolean isHaveLessThanOrEqual9ProductsInPageDisplayed() {
		waitElementVisible(driver, NotebooksPageUI.PRODUCT_NAME);
		int productsNumber= finds(driver, NotebooksPageUI.PRODUCT_NAME).size();
		return isElementDisplayed(driver, NotebooksPageUI.PRODUCT_NAME) && productsNumber <=9;
	}

}
