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
	String firstName="Automatic";
	String lastName="FC";
	String email="automation"+randomEmail()+".vn@gmail.com";
	String company="auto FC";
	String password="123456";
	String confirmpassword="123456";

	@Parameters({ "browser", "url" })
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
		homePage = PageGeneratorNopcommerceManager.getHomePage(driver);
		homePage.openMenuHeaderPageByPageName(driver, "Log out");
		homePage.openMenuHeaderPageByPageName(driver, "Log in");
		loginPage = PageGeneratorNopcommerceManager.getLoginPage(driver);
	}

	@BeforeMethod
	public void beforeMethod() {

	}
	@Test
	public void Login_01_Empty_Data() {
		loginPage.clickToLoginButton();
		verifyTrue(loginPage.isErrorMessageEnterYourEmailDisplayed("Please enter your email"));
	}
	@Test
	public void Login_02_Invalid_Email() {
		loginPage.inputToDynamicByValueNameTextbox(driver, "Email", "123@123");
		loginPage.clickToLoginButton();
		verifyTrue(loginPage.isErrorMessageInvalidEmailDisplayed("Wrong email"));
	}
	@Test
	public void Login_03_Incorrect_Email() {
		loginPage.inputToDynamicByValueNameTextbox(driver, "Email", "quan123@gmail.com");
		loginPage.clickToLoginButton();
		verifyTrue(loginPage.isErrorMessageIncorrectEmailDisplayed("Login was unsuccessful. Please correct the errors and try again.","No customer account found"));
	}
	@Test
	public void Login_04_Valid_Email_And_Not_Enter_Password() {
		loginPage.inputToDynamicByValueNameTextbox(driver, "Email",email);
		loginPage.clickToLoginButton();
		verifyTrue(loginPage.isErrorDataIncorrectMessageDisplayed("Login was unsuccessful. Please correct the errors and try again.","The credentials provided are incorrect"));
	}
	@Test
	public void Login_05_Valid_Email_And_Incorrect_Password() {
		loginPage.inputToDynamicByValueNameTextbox(driver, "Email",email);
		loginPage.inputToDynamicByValueNameTextbox(driver,"Password","1234");
		loginPage.clickToLoginButton();
		verifyTrue(loginPage.isErrorDataIncorrectMessageDisplayed("Login was unsuccessful. Please correct the errors and try again.","The credentials provided are incorrect"));
	}
	@Test
	public void Login_05_Valid_Email_And_Password() {
		loginPage.inputToDynamicByValueNameTextbox(driver, "Email",email);
		loginPage.inputToDynamicByValueNameTextbox(driver,"Password",password);
		loginPage.clickToLoginButton();
		homePage =PageGeneratorNopcommerceManager.getHomePage(driver);
		homePage.isHomePageDisplayed();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}

