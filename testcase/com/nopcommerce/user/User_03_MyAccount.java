package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorNopcommerceManager;
import pageObject.nopcommerce.user.AddressPageObject;
import pageObject.nopcommerce.user.ChangePasswordPageObject;
import pageObject.nopcommerce.user.CustomerInfoPageObject;
import pageObject.nopcommerce.user.HomePageObject;
import pageObject.nopcommerce.user.LoginPageObject;
import pageObject.nopcommerce.user.MyAccountPageObject;
import pageObject.nopcommerce.user.MyProductReviewPageObject;
import pageObject.nopcommerce.user.NotebooksPageObject;
import pageObject.nopcommerce.user.ProductDetailPageObject;
import pageObject.nopcommerce.user.ProductReviewPageObject;
import pageObject.nopcommerce.user.RegisterPageObject;

public class User_03_MyAccount extends AbstractTest {
	WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	MyAccountPageObject myAccountPage;
	CustomerInfoPageObject customerInfoPage;
	AddressPageObject addressPage;
	ChangePasswordPageObject changePasswordPage;
	NotebooksPageObject notebooksPage;
	MyProductReviewPageObject myProductReviewPage;
	ProductDetailPageObject productDetailPage;
	ProductReviewPageObject productReviewPage;
	String firstName="Automatic";
	String lastName="FC";
	String email="automation"+randomEmail()+".vn@gmail.com";
	String company="auto FC";
	String password="123456";
	String editpassword="123321";
	String confirmpassword="123456";
	String editFirstName="Automation";
	String editLastName = "FC";
	String editEmail = "automationfc"+randomEmail()+".vn@gmail.com";
	String dateOfBirthDay="1";
	String dateOfBirthMonth="January";
	String dateOfBirthYear="1999";
	String city="Ha Noi";
	String address1="123 Ha Noi";
	String address2="234/05 Hai phong";
	String zipCode="123456";
	String country="Viet Nam";
	String phone="0972655111";
	String fax="123456551";
	String name=editFirstName+" "+editLastName;
	@Parameters({ "browser", "url" })
	
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorNopcommerceManager.getHomePage(driver);
		homePage.openMenuHeaderPageByPageName(driver, "Register");
		registerPage = PageGeneratorNopcommerceManager.getRegisterPage(driver);
		sleepInSecond(1);
		registerPage.inputToDynamicByValueNameTextbox(driver,"FirstName",firstName);
		registerPage.inputToDynamicByValueNameTextbox(driver,"LastName",lastName);
		registerPage.inputToDynamicByValueNameTextbox(driver,"Email",email);
		registerPage.inputToDynamicByValueNameTextbox(driver,"Password",password);
		registerPage.inputToDynamicByValueNameTextbox(driver,"ConfirmPassword",confirmpassword);
		registerPage.clickToRegisterButton();
		verifyTrue(registerPage.isMessageRegisterSuccessDisplayed());
		registerPage.openMenuHeaderPageByPageName(driver, "My account");
		customerInfoPage = PageGeneratorNopcommerceManager.getCustomerPage(driver);
	}
	public void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void MyAccount_01_Customer_Info() {
		customerInfoPage.clickToFemaleRadioButon();
		customerInfoPage.inputToDynamicByValueNameTextbox(driver,"FirstName",editFirstName);
		customerInfoPage.inputToDynamicByValueNameTextbox(driver,"LastName",editLastName);
		customerInfoPage.selectToDateOfBirthDayDropdown(dateOfBirthDay);
		customerInfoPage.selectToDateOfBirthMonthDropdown(dateOfBirthMonth);
		customerInfoPage.selectToDateOfBirthYearDropdown(dateOfBirthYear);
		customerInfoPage.inputToDynamicByValueNameTextbox(driver,"Email",editEmail);
		customerInfoPage.inputToDynamicByValueNameTextbox(driver,"Company",company);
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
		addressPage.inputToDynamicByValueNameTextbox(driver, "Address.FirstName", editFirstName);
		addressPage.inputToDynamicByValueNameTextbox(driver, "Address.LastName", editLastName);
		addressPage.inputToDynamicByValueNameTextbox(driver, "Address.Email", editEmail);
		addressPage.inputToDynamicByValueNameTextbox(driver, "Address.Company", company);
		addressPage.selectItemCountryDropDown(country);
		addressPage.inputToDynamicByValueNameTextbox(driver, "Address.City", city);
		addressPage.inputToDynamicByValueNameTextbox(driver, "Address.Address1", address1);
		addressPage.inputToDynamicByValueNameTextbox(driver, "Address.Address2", address2);
		addressPage.inputToDynamicByValueNameTextbox(driver, "Address.ZipPostalCode", zipCode);
		addressPage.inputToDynamicByValueNameTextbox(driver, "Address.PhoneNumber", phone);
		addressPage.inputToDynamicByValueNameTextbox(driver, "Address.FaxNumber", fax);
		addressPage.clickToSaveButton();
		verifyTrue(addressPage.isNameAddressDisplayed(name));
		verifyTrue(addressPage.isEmailAddressDisplayed(editEmail));
		verifyTrue(addressPage.isPhoneNumberAddressDisplayed(phone));
		verifyTrue(addressPage.isFaxAddressDisplayed(fax));
		verifyTrue(addressPage.isCompanyAddressDisplayed(company));
		verifyTrue(addressPage.isAddress1Displayed(address1));
		verifyTrue(addressPage.isAddress2Displayed(address2));
		verifyTrue(addressPage.isCityZipCodeAddressDisplayed(city+", "+zipCode));
		verifyTrue(addressPage.isCountryAddressDisplayed(country));
	}
	@Test
	public void MyAccount_03_Change_Password() {
		 addressPage.openToDynamicMenuPageListMyAccount(driver, "Change password");
		 changePasswordPage = PageGeneratorNopcommerceManager.getChangePasswordPage(driver);
		 changePasswordPage.inputToDynamicByValueNameTextbox(driver,"OldPassword",password);
		 changePasswordPage.inputToDynamicByValueNameTextbox(driver,"NewPassword",password);
		 changePasswordPage.inputToDynamicByValueNameTextbox(driver,"ConfirmNewPassword",password);
		 changePasswordPage.clickToChangePasswordButton();
		 verifyTrue(changePasswordPage.isMessageChangePasswordFailedDisplayed("You entered the password that is the same as one of the last passwords you used. Please create a new password."));
		 changePasswordPage.inputToDynamicByValueNameTextbox(driver,"OldPassword",password);
		 changePasswordPage.inputToDynamicByValueNameTextbox(driver,"NewPassword",editpassword);
		 changePasswordPage.inputToDynamicByValueNameTextbox(driver,"ConfirmNewPassword",editpassword);
		 changePasswordPage.clickToChangePasswordButton();
		 verifyTrue(changePasswordPage.isMessageChangePasswordSuccessDisplayed("Password was changed"));
		
	}
	@Test
	public void MyAccount_04_My_Product_Reviews() {
		changePasswordPage.clickToDynamicSubMenuByName(driver,"Computers","Notebooks");
		notebooksPage =PageGeneratorNopcommerceManager.getNotebooksPage(driver);
		notebooksPage.clickToPoductDetailByName(driver, "Apple MacBook Pro 13-inch");
		productDetailPage = PageGeneratorNopcommerceManager.getProductDetailPage(driver);
		productDetailPage.clickToAddYourReview();
		productReviewPage = PageGeneratorNopcommerceManager.getProductReviewPage(driver);
		productReviewPage.inputToReviewTitle("Review for Macbook Pro");
		productReviewPage.inputToReviewText("Product very good");
		productReviewPage.selectToRatingRadioButton("Excellent");
		productReviewPage.clickToSubmitReviewButton();
		verifyTrue(productReviewPage.isMessageProductReviewSuccessDisplayed("Product review is successfully added."));
		productReviewPage.openMenuHeaderPageByPageName(driver, "My account");
		customerInfoPage = PageGeneratorNopcommerceManager.getCustomerPage(driver);
		customerInfoPage.openToDynamicMenuPageListMyAccount(driver, "My product reviews");
		myProductReviewPage = PageGeneratorNopcommerceManager.getMyProductReviewPage(driver);
		verifyTrue(myProductReviewPage.isProductYourReviewNameDisplayed("Apple MacBook Pro 13-inch"));
	}
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		//closeBrowserAndDriver(driver);
	}

}
