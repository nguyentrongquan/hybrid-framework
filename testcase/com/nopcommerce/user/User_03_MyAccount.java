package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorNopcommerceManager;
import pageObject.nopcommerce.user.LoginPageObject;
import pageObject.nopcommerce.user.MyAccountPageObject;
import pageObject.nopcommerce.user.RegisterPageObject;
import pageObject.wordPress.user.HomePageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class User_03_MyAccount extends AbstractTest {
	WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	MyAccountPageObject myAccountPage;
	String firstName="Auto";
	String lastName="Fc";
	String email="automationfc12.vn@gmail.com";
	String company="auto FC";
	String password="123456";
	String confirmpassword="123456";
	String editFirstName="Automation";
	String editLastName = "FC";
	String editEmail = "automationfc1231.vn@gmail.com";
	String dateOfBirthDay="1";
	String dateOfBirthMonth="January";
	String dateOfBirthYear="1999";
	
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorNopcommerceManager.getHomePage(driver);
		homePage.openMenuHeaderPageByPageName(driver, "Register");
		registerPage = PageGeneratorNopcommerceManager.getRegisterPage(driver);
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmpassword);
		registerPage.clickToRegisterButton();
		verifyTrue(registerPage.isMessageRegisterSuccessDisplayed());

		registerPage.openMenuHeaderPageByPageName(driver, "My account");
		myAccountPage = PageGeneratorNopcommerceManager.getMyAccountPage(driver);
	}

	@Test
	public void MyAccount_01_Customer_Info() {
		myAccountPage.clickToFemaleRadioButon();
		myAccountPage.inputToFirstNameTextbox(editFirstName);
		myAccountPage.inputToLastNameTextbox(editLastName);
		myAccountPage.selectToDateOfBirthDayDropdown(dateOfBirthDay);
		myAccountPage.selectToDateOfBirthMonthDropdown(dateOfBirthMonth);
		myAccountPage.selectToDateOfBirthYearDropdown(dateOfBirthYear);
		myAccountPage.inputToEmailTextbox(editEmail);
		myAccountPage.inputToCompanyTextbox(company);
		myAccountPage.clickToSaveButton();
		verifyTrue(myAccountPage.isFemaleRadioButtonSelected());
		verifyEquals(myAccountPage.getFirstNameUpdateText("value"),editFirstName);
		verifyEquals(myAccountPage.getLastNameUpdateText("value"),editLastName);
		verifyEquals(myAccountPage.getDateOfBirthDayUpdateDropdown(),dateOfBirthDay);
		verifyEquals(myAccountPage.getDateOfBirthMonthUpdateDropdown(),dateOfBirthMonth);
		verifyEquals(myAccountPage.getDateOfBirthYearUpdateDropdown(),dateOfBirthYear);
		verifyEquals(myAccountPage.getEmailUpdateText("value"),editEmail);
		verifyEquals(myAccountPage.getCompanyNameUpdateText("value"),company);
	}
	@Test
	public void MyAccount_02_Address() {
		myAccountPage.clickToAddressPageMenu();//li[@class='customer-addresses active']//a[contains(text(),'Addresses')]
		myAccountPage.clickToAddNewButton();//input[@class='button-1 add-address-button']
		myAccountPage.inputToFirstNameTextbox();//input[@id='Address_FirstName']
		myAccountPage.intputToLastNameTextbox();
		
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
