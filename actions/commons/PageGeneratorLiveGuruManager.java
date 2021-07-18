package commons;

import org.openqa.selenium.WebDriver;

import pageObject.liveguru.user.HomePageObject;
import pageObject.liveguru.user.LoginPageObject;
import pageObject.liveguru.user.MyDashboardPageObject;
import pageObject.liveguru.user.RegisterPageObject;

public class PageGeneratorLiveGuruManager {
    public static HomePageObject getHomePage(WebDriver driver) {
	return new HomePageObject(driver);
    }

    public static LoginPageObject getLoginPage(WebDriver driver) {
	return new LoginPageObject(driver);
    }

    public static RegisterPageObject getRegisterPage(WebDriver driver) {
	return new RegisterPageObject(driver);
    }
    public static MyDashboardPageObject getMyDashboardPage(WebDriver driver) {
	return new MyDashboardPageObject(driver);
    }
}
