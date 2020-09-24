package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorNopcommerceManager;
import pageObject.nopcommerce.user.ComputerPageObject;
import pageObject.nopcommerce.user.HomePageObject;
import pageObject.nopcommerce.user.LoginPageObject;
import pageObject.nopcommerce.user.MyAccountPageObject;
import pageObject.nopcommerce.user.NotebooksPageObject;
import pageObject.nopcommerce.user.RegisterPageObject;

public class User_05_Sort_Display_Paging extends AbstractTest {
	Actions action;
	WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	MyAccountPageObject myAccountPage;
	NotebooksPageObject notebooksPage;
	ComputerPageObject computerPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorNopcommerceManager.getHomePage(driver);
		homePage.clickToDynamicSubMenuByName(driver,"Computers","Notebooks");
		notebooksPage =PageGeneratorNopcommerceManager.getNotebooksPage(driver);
	}

	@Test
	public void TC_01_Sort_With_Name_A_To_Z() {
		notebooksPage.SelecItemSortDropDownByName("Name: A to Z");
		verifyTrue(notebooksPage.isNameSortAscending());
	}
	@Test
	public void TC_02_Sort_With_Name_Z_To_A() {
		notebooksPage.SelecItemSortDropDownByName("Name: Z to A");
		verifyTrue(notebooksPage.isNameSortDecending());
	}	
	@Test
	public void TC_03_Sort_With_Price_Low_To_High() {
		notebooksPage.SelecItemSortDropDownByName("Price: Low to High");
		verifyTrue(notebooksPage.isPriceSortAscending());
	}
	@Test
	public void TC_04_Sort_With_Price_High_To_Low() {
		notebooksPage.SelecItemSortDropDownByName("Price: High to Low");
		verifyTrue(notebooksPage.isPriceSortDecending());
	}
	@Test
	public void TC_05_Display_With_3_Products_In_One_Page() {
		notebooksPage.SelecItemDisplayDropDownBySize("3");
		
		verifyTrue(notebooksPage.isPageActiveByIndex("1"));
		
		verifyTrue(notebooksPage.isHaveLessThanOrEqual3ProductsInPageDisplayed());
		
		verifyTrue(notebooksPage.isPagingNextIconInPageDisplayed());
		
		notebooksPage.navigateToPageNumberByIndex("2");
		
		verifyTrue(notebooksPage.isPageActiveByIndex("2"));
		
		verifyTrue(notebooksPage.isHaveLessThanOrEqual3ProductsInPageDisplayed());
		
		verifyTrue(notebooksPage.isPagingPreviousIconInPageDisplayed());
		
	}
	@Test
	public void TC_06_Display_With_6_Products_In_One_Page() {
		notebooksPage.SelecItemDisplayDropDownBySize("6");
		
		verifyTrue(notebooksPage.isHaveLessThanOrEqual6ProductsInPageDisplayed());
		verifyTrue(notebooksPage.isPagingUnDisplayed());
	}
	@Test
	public void TC_07_Display_With_9_Products_In_One_Page() {
		notebooksPage.SelecItemDisplayDropDownBySize("9");
		
		verifyTrue(notebooksPage.isHaveLessThanOrEqual9ProductsInPageDisplayed());
		verifyTrue(notebooksPage.isPagingUnDisplayed());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}