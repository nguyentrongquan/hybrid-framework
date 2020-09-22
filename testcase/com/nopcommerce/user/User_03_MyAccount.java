package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorNopcommerceManager;
import pageObject.nopcommerce.user.CustomerInfoPageObject;
import pageObject.nopcommerce.user.HomePageObject;
import pageObject.nopcommerce.user.LoginPageObject;
import pageObject.nopcommerce.user.MyAccountPageObject;
import pageObject.nopcommerce.user.RegisterPageObject;

public class User_03_MyAccount extends AbstractTest {
	WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	MyAccountPageObject myAccountPage;
	CustomerInfoPageObject customerInfoPage;
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
		customerInfoPage = PageGeneratorNopcommerceManager.getCustomerInfoPage(driver);
	}

	@Test
	public void MyAccount_01_Customer_Info() {
		customerInfoPage.clickToFemaleRadioButon();
		customerInfoPage.inputToFirstNameTextbox(editFirstName);
		customerInfoPage.inputToLastNameTextbox(editLastName);
		customerInfoPage.selectToDateOfBirthDayDropdown(dateOfBirthDay);
		customerInfoPage.selectToDateOfBirthMonthDropdown(dateOfBirthMonth);
		customerInfoPage.selectToDateOfBirthYearDropdown(dateOfBirthYear);
		customerInfoPage.inputToEmailTextbox(editEmail);
		customerInfoPage.inputToCompanyTextbox(company);
		customerInfoPage.clickToSaveButton();
		verifyTrue(customerInfoPage.isFemaleRadioButtonSelected());
		verifyEquals(customerInfoPage.getFirstNameUpdateText("value"),editFirstName);
		verifyEquals(customerInfoPage.getLastNameUpdateText("value"),editLastName);
		verifyEquals(customerInfoPage.getDateOfBirthDayUpdateDropdown(),dateOfBirthDay);
		verifyEquals(customerInfoPage.getDateOfBirthMonthUpdateDropdown(),dateOfBirthMonth);
		verifyEquals(customerInfoPage.getDateOfBirthYearUpdateDropdown(),dateOfBirthYear);
		verifyEquals(customerInfoPage.getEmailUpdateText("value"),editEmail);
		verifyEquals(customerInfoPage.getCompanyNameUpdateText("value"),company);
	}
	@Test
	public void MyAccount_02_Address() {
//		myAccountPage.clickToAddressPageMenu();//li[@class='customer-addresses active']//a[contains(text(),'Addresses')]
//		myAccountPage.clickToAddNewButton();//input[@class='button-1 add-address-button']
//		myAccountPage.inputToFirstNameTextbox();//input[@id='Address_FirstName']
//		myAccountPage.intputToLastNameTextbox();
//		myAccountPage.intputToLastNameTextbox();
//		myAccountPage.intputToLastNameTextbox();
//		myAccountPage.intputToLastNameTextbox();
//		myAccountPage.intputToLastNameTextbox();
//		
		
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
