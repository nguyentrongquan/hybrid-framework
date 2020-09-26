package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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
		
	}
	@Test
	public void Search_04_Products_Name_Absolute() {
		
	}
	@Test
	public void Advenced_Search_05_Parent_Categories() {
		
	}
	@Test
	public void Advenced_Search_06_Sub_Categories() {
		
	}
	@Test
	public void Advenced_Search_07_Incorrect_Manufacturer() {
		
	}
	@Test
	public void Advenced_Search_08_Correct_Manufacturer() {
		
	}
	@Test
	public void Advenced_Search_09_Wihtin_Price_Range() {
		
	}
	@Test
	public void Advenced_Search_10_Price_Range_Less_Product_Price() {
		
	}
	@Test
	public void Advenced_Search_11_Price_Range_Than_Product_Price() {
		
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
