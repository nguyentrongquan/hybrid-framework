package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorNopcommerceManager;
import pageObject.nopcommerce.user.AddressPageObject;
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
	AddressPageObject addressPage;
	String firstName="Automat";
	String lastName="Fc";
	String email="automation"+randomEmail()+".vn@gmail.com";
	String company="auto FC";
	String password="123456";
	String confirmpassword="123456";
	String editFirstName="Automation";
	String editLastName = "FC";
	String editEmail = "automationfc"+randomEmail()+".vn@gmail.com";
	String dateOfBirthDay="1";
	String dateOfBirthMonth="January";
	String dateOfBirthYear="1999";
	String city="Ha Noi";
	String address1="Ha Noi";
	String zipCode="123456";
	String country="Viet Nam";
	String phone="0972655111";
	
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorNopcommerceManager.getHomePage(driver);
		homePage.openMenuHeaderPageByPageName(driver, "Register");
		registerPage = PageGeneratorNopcommerceManager.getRegisterPage(driver);
		registerPage.inputToDynamicTextbox(driver,"FirstName",firstName);
		registerPage.inputToDynamicTextbox(driver,"LastName",lastName);
		registerPage.inputToDynamicTextbox(driver,"Email",email);
		registerPage.inputToDynamicTextbox(driver,"Password",password);
		registerPage.inputToDynamicTextbox(driver,"ConfirmPassword",confirmpassword);
		registerPage.inputToConfirmPasswordTextbox(confirmpassword);
		registerPage.clickToRegisterButton();
		verifyTrue(registerPage.isMessageRegisterSuccessDisplayed());
		registerPage.openMenuHeaderPageByPageName(driver, "My account");
		customerInfoPage = PageGeneratorNopcommerceManager.getCustomerPage(driver);
	}

	@Test
	public void MyAccount_01_Customer_Info() {
		customerInfoPage.clickToFemaleRadioButon();
		customerInfoPage.inputToDynamicTextbox(driver,"FirstName",editFirstName);
		customerInfoPage.inputToDynamicTextbox(driver,"LastName",editLastName);
		customerInfoPage.selectToDateOfBirthDayDropdown(dateOfBirthDay);
		customerInfoPage.selectToDateOfBirthMonthDropdown(dateOfBirthMonth);
		customerInfoPage.selectToDateOfBirthYearDropdown(dateOfBirthYear);
		customerInfoPage.inputToDynamicTextbox(driver,"Email",editEmail);
		customerInfoPage.inputToDynamicTextbox(driver,"Company",company);
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
		addressPage = customerInfoPage.clickToAddressLink();
		addressPage.clickToAddNewButton();
		addressPage.inputToDynamicTextbox(driver, "Address.FirstName", editFirstName);
		addressPage.inputToDynamicTextbox(driver, "Address.LastName", editLastName);
		addressPage.inputToDynamicTextbox(driver, "Address.Email", editEmail);
		addressPage.inputToDynamicTextbox(driver, "Address.Company", company);
		addressPage.selectItemCountryDropDown(country);
		addressPage.inputToDynamicTextbox(driver, "Address.City", city);
		addressPage.inputToDynamicTextbox(driver, "Address.Address1", address1);
		addressPage.inputToDynamicTextbox(driver, "Address.ZipPostalCode", zipCode);
		addressPage.inputToDynamicTextbox(driver, "Address.PhoneNumber", phone);
		addressPage.clickToSaveButton();
		
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
