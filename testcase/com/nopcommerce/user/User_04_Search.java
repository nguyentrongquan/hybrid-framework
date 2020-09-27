package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorNopcommerceManager;
import pageObject.nopcommerce.user.HomePageObject;
import pageObject.nopcommerce.user.LoginPageObject;
import pageObject.nopcommerce.user.RegisterPageObject;
import pageObject.nopcommerce.user.SearchPageObject;

public class User_04_Search extends AbstractTest {
	WebDriver driver;
	SearchPageObject searchPage;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	String firstName="Automatic";
	String lastName="FC";
	String email="automation"+randomEmail()+".vn@gmail.com";
	String company="auto FC";
	String password="123456";
	String confirmpassword="123456";
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorNopcommerceManager.getHomePage(driver);
		homePage.openMenuHeaderPageByPageName(driver, "Register");
		registerPage = PageGeneratorNopcommerceManager.getRegisterPage(driver);
		registerPage.inputToDynamicByValueNameTextbox(driver,"FirstName",firstName);
		registerPage.inputToDynamicByValueNameTextbox(driver,"LastName",lastName);
		registerPage.inputToDynamicByValueNameTextbox(driver,"Email",email);
		registerPage.inputToDynamicByValueNameTextbox(driver,"Password",password);
		registerPage.inputToDynamicByValueNameTextbox(driver,"ConfirmPassword",confirmpassword);
		registerPage.clickToRegisterButton();
		verifyTrue(registerPage.isMessageRegisterSuccessDisplayed());
	}
	@BeforeMethod
	public void BeforeMethod() {
		registerPage.openMenuFooterPageByPageName(driver, "Search");
		searchPage = PageGeneratorNopcommerceManager.getSearchPage(driver);
	}
	@Test
	public void Search_01_Empty_Data() {
		searchPage.clickToSearchButton();
		verifyTrue(searchPage.isErrorMessageDisplayed("Search term minimum length is 3 characters"));
	}
	@Test
	public void Search_02_Data_Not_Exist() {
		searchPage.inputToSearchKeywordTextbox("Macbook Pro 2050");
		searchPage.clickToSearchButton();
		verifyTrue(searchPage.isErrorMessageDisplayed("No products were found that matched your criteria."));
	}
	@Test
	public void Search_03_Products_Name_Relative() {
		searchPage.inputToSearchKeywordTextbox("Lenovo");
		searchPage.clickToSearchButton();
		verifyTrue(searchPage.isTwoProductNameDisplayed("Lenovo IdeaCentre 600 All-in-One PC"));
		verifyTrue(searchPage.isTwoProductNameDisplayed("Lenovo Thinkpad X1 Carbon Laptop"));
	}
	@Test
	public void Search_04_Products_Name_Absolute() {
		searchPage.inputToSearchKeywordTextbox("Lenovo Thinkpad X1 Carbon Laptop");
		searchPage.clickToSearchButton();
		verifyTrue(searchPage.isOneProductNameDisplayed("Lenovo Thinkpad X1 Carbon Laptop"));
	}
	@Test
	public void Search_05_Advenced_Search_Parent_Categories() {
		searchPage.inputToSearchKeywordTextbox("Apple Macbook Pro");
		searchPage.clickToAdvancedSearchCheckbox();
		searchPage.SelectToCategoryDropdown("Computers");
		searchPage.AutomaticallySearchSubCategoriesUnChecked();
		searchPage.clickToSearchButton();
		verifyTrue(searchPage.isErrorMessageDisplayed("No products were found that matched your criteria."));
		
	}
	@Test
	public void Search_06_Advenced_Search_Sub_Categories() {
		searchPage.inputToSearchKeywordTextbox("Apple Macbook Pro");
		searchPage.clickToAdvancedSearchCheckbox();
		searchPage.SelectToCategoryDropdown("Computers");
		searchPage.AutomaticallySearchSubCategoriesChecked();
		searchPage.clickToSearchButton();
		verifyTrue(searchPage.isOneProductNameDisplayed("Apple MacBook Pro 13-inch"));
		
	}
	@Test
	public void Search_07_Advenced_Search_Incorrect_Manufacturer() {
		searchPage.inputToSearchKeywordTextbox("Apple Macbook Pro");
		searchPage.clickToAdvancedSearchCheckbox();
		searchPage.SelectToCategoryDropdown("Computers");
		searchPage.AutomaticallySearchSubCategoriesChecked();
		searchPage.SelectToManufacturerDropdown("HP");
		searchPage.clickToSearchButton();
		verifyTrue(searchPage.isErrorMessageDisplayed("No products were found that matched your criteria."));
	}
	@Test
	public void Search_08_Advenced_Search_Correct_Manufacturer() {
		searchPage.inputToSearchKeywordTextbox("Apple Macbook Pro");
		searchPage.clickToAdvancedSearchCheckbox();
		searchPage.SelectToCategoryDropdown("Computers");
		searchPage.AutomaticallySearchSubCategoriesChecked();
		searchPage.SelectToManufacturerDropdown("Apple");
		searchPage.clickToSearchButton();
		verifyTrue(searchPage.isOneProductNameDisplayed("Apple MacBook Pro 13-inch"));
	}
	@Test
	public void Search_09_Advenced_Search_Wihtin_Price_Range() {
		searchPage.inputToSearchKeywordTextbox("Apple Macbook Pro");
		searchPage.clickToAdvancedSearchCheckbox();
		searchPage.SelectToCategoryDropdown("Computers");
		searchPage.AutomaticallySearchSubCategoriesChecked();
		searchPage.SelectToManufacturerDropdown("Apple");
		searchPage.inputToPriceFromRange("1000");
		searchPage.inputToPriceToRange("2000");
		searchPage.clickToSearchButton();
		verifyTrue(searchPage.isOneProductNameDisplayed("Apple MacBook Pro 13-inch"));
	}
	@Test
	public void Search_10_Advenced_Search_Price_Range_Less_Product_Price() {
		searchPage.inputToSearchKeywordTextbox("Apple Macbook Pro");
		searchPage.clickToAdvancedSearchCheckbox();
		searchPage.SelectToCategoryDropdown("Computers");
		searchPage.AutomaticallySearchSubCategoriesChecked();
		searchPage.SelectToManufacturerDropdown("Apple");
		searchPage.inputToPriceFromRange("1000");
		searchPage.inputToPriceToRange("1700");
		searchPage.clickToSearchButton();
		verifyTrue(searchPage.isErrorMessageDisplayed("No products were found that matched your criteria."));
	}
	@Test
	public void Search_11_Advenced_Search_Price_Range_Than_Product_Price() {
		searchPage.inputToSearchKeywordTextbox("Apple Macbook Pro");
		searchPage.clickToAdvancedSearchCheckbox();
		searchPage.SelectToCategoryDropdown("Computers");
		searchPage.AutomaticallySearchSubCategoriesChecked();
		searchPage.SelectToManufacturerDropdown("Apple");
		searchPage.inputToPriceFromRange("1900");
		searchPage.inputToPriceToRange("5000");
		searchPage.clickToSearchButton();
		verifyTrue(searchPage.isErrorMessageDisplayed("No products were found that matched your criteria."));
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
