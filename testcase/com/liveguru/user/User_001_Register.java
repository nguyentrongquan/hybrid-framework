package com.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorLiveGuruManager;
import pageObject.liveguru.user.HomePageObject;
import pageObject.liveguru.user.LoginPageObject;
import pageObject.liveguru.user.MyDashboardPageObject;
import pageObject.liveguru.user.RegisterPageObject;

public class User_001_Register extends AbstractTest{
    WebDriver driver;
    String email= "automation" +randomEmail()+"@hotmail.com";
    String password="123123";
    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName,String appUrl) {
	driver =getBrowserDriver(browserName, appUrl);
	homePage= PageGeneratorLiveGuruManager.getHomePage(driver);
	homePage.openMenuFooterPageByPageName(driver, "My Account");
	loginPage=PageGeneratorLiveGuruManager.getLoginPage(driver);
	loginPage.clickToCreateAnAccountButton();
	registerPage=PageGeneratorLiveGuruManager.getRegisterPage(driver);
    }

    @Test
    public void TC_01_Register() {
	registerPage.inputToFirstnameTextbox("neuer");
	registerPage.inputToLastnameTextbox("kenvin");
	registerPage.inputToEmailTextbox(email);
	registerPage.inputToPasswordTextbox(password);
	registerPage.inputToConfirmPasswordTextbox(password);
	registerPage.clickToRegisterButton();
	myDashboarPage=PageGeneratorLiveGuruManager.getMyDashboardPage(driver);
	verifyEquals(myDashboarPage.getWelcomeSuccessMessage(), "Thank you for registering with Main Website Store.");
	myDashboarPage.clickToLogOutLink();
	homePage= PageGeneratorLiveGuruManager.getHomePage(driver);
    }
    
    public void TC_02_Login() {
	homePage.openMenuFooterPageByPageName(driver, "My Account");
	loginPage=PageGeneratorLiveGuruManager.getLoginPage(driver);
	loginPage.inputToEmailTextbox(email);
	loginPage.inputToPasswordTextbox(password);
    }
     
    @AfterClass
    public void afterClass() {
    }
  
  HomePageObject homePage;
  RegisterPageObject registerPage;
  LoginPageObject loginPage;
  MyDashboardPageObject myDashboarPage;
}
