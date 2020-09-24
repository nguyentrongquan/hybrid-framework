package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorNopcommerceManager;
import pageObject.nopcommerce.user.HomePageObject;
import pageObject.nopcommerce.user.LoginPageObject;
import pageObject.nopcommerce.user.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class User_02_Login extends AbstractTest {
	WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorNopcommerceManager.getHomePage(driver);
	}

	@BeforeMethod
	public void beforeMethod() {
		homePage.openMenuHeaderPageByPageName(driver, "Login");
		loginPage = PageGeneratorNopcommerceManager.getLoginPage(driver);
	}
	@Test
	public void Login_01_Empty_Data() {
//		registerPage.openMenuHeaderPageByPageName(driver,"Log in");
//		loginPage= PageGeneratorNopcommerceManager.getLoginPage(driver);
//		loginPage.inputToEmailTextbox(email);
//		loginPage.inputToPasswordTextbox(password);
//		loginPage.clickToLoginButton();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}

