package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorNopcommerceManager;
import pageObject.nopcommerce.user.HomePageObject;
import pageObject.nopcommerce.user.RegisterPageObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class User_01_Register extends AbstractTest {
	WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorNopcommerceManager.getHomePage(driver);

	}

	@BeforeMethod
	public void beforeMethod() {
		homePage.openMenuHeaderPageByPageName(driver, "Register");
		registerPage = PageGeneratorNopcommerceManager.getRegisterPage(driver);
	}

	@Test
	public void Register_01_Empty_Data() {
		registerPage.clickToRegisterButton();
		verifyTrue(registerPage.isErrorMesageAtValueNameTextboxtDisplayed("First name", "First name is required."));
		verifyTrue(registerPage.isErrorMesageAtValueNameTextboxtDisplayed("Last name", "Last name is required."));
		verifyTrue(registerPage.isErrorMesageAtValueNameTextboxtDisplayed("Email", "Email is required."));
		verifyTrue(registerPage.isErrorMesageAtValueNameTextboxtDisplayed("Password", "Password is required."));
		verifyTrue(registerPage.isErrorMesageAtValueNameTextboxtDisplayed("Confirm password", "Password is required."));

	}

	@Test
	public void Register_02_Invalid_Email() {
		registerPage.inputToEmailTextbox("123@.123");
		registerPage.clickToRegisterButton();
		verifyTrue(registerPage.isErrorMesageAtValueNameTextboxtDisplayed("First name", "First name is required."));
		verifyTrue(registerPage.isErrorMesageAtValueNameTextboxtDisplayed("Last name", "Last name is required."));
		verifyTrue(registerPage.isErrorMesageAtValueNameTextboxtDisplayed("Email", "Wrong email"));
		verifyTrue(registerPage.isErrorMesageAtValueNameTextboxtDisplayed("Password", "Password is required."));
		verifyTrue(registerPage.isErrorMesageAtValueNameTextboxtDisplayed("Confirm password", "Password is required."));

	}

	@Test
	public void Register_03_Email_Already_Exists() {
		registerPage.inputToFirstNameTextbox("quan");
		registerPage.inputToLastNameTextbox("nguyen");
		registerPage.inputToEmailTextbox("automationfc.vn@gmail.com");
		registerPage.inputToPasswordTextbox("123456");
		registerPage.inputToConfirmPasswordTextbox("123456");
		registerPage.clickToRegisterButton();
		verifyTrue(registerPage.isErrorMesageAtEmailAlreadyExistsDisplayed("The specified email already exists"));

	}

	@Test
	public void Register_04_Password_Less_Than_6_Chars() {
		registerPage.inputToPasswordTextbox("12345");
		registerPage.clickToRegisterButton();
		verifyTrue(registerPage.isErrorMesageAtValueNameTextboxtDisplayed("First name", "First name is required."));
		verifyTrue(registerPage.isErrorMesageAtValueNameTextboxtDisplayed("Last name", "Last name is required."));
		verifyTrue(registerPage.isErrorMesageAtValueNameTextboxtDisplayed("Email", "Email is required."));
		verifyTrue(registerPage.isErrorMesageMustHaveLeastCharstDisplayed());
		verifyTrue(registerPage.isErrorMesageAtValueNameTextboxtDisplayed("Confirm password", "Password is required."));
		
	}
	@Test
	public void Register_05_Password_And_Confirm_Password_Not_Matching() {
		registerPage.inputToPasswordTextbox("123458");
		registerPage.inputToConfirmPasswordTextbox("123456");
		registerPage.clickToRegisterButton();
		verifyTrue(registerPage.isErrorMesageAtValueNameTextboxtDisplayed("First name", "First name is required."));
		verifyTrue(registerPage.isErrorMesageAtValueNameTextboxtDisplayed("Last name", "Last name is required."));
		verifyTrue(registerPage.isErrorMesageAtValueNameTextboxtDisplayed("Email", "Email is required."));
		verifyTrue(registerPage.isErrorMesageAtValueNameTextboxtDisplayed("Confirm password", "The password and confirmation password do not match."));
		
	}
	@Test
	public void Register_06_Valid_Data() {
		
		registerPage.inputToFirstNameTextbox("Automation");
		registerPage.inputToLastNameTextbox("Fc");
		registerPage.inputToEmailTextbox("automationfc123.vn@gmail.com");
		registerPage.inputToPasswordTextbox("123456");
		registerPage.inputToConfirmPasswordTextbox("123456");
		registerPage.clickToRegisterButton();
		verifyTrue(registerPage.isMessageRegisterSuccessDisplayed());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
