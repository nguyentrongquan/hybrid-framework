package pageObject.liveguru.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageObject.liveGuru.user.MyDashboardPageUI;

public class MyDashboardPageObject extends AbstractPage  {
    WebDriver driver;	
    public MyDashboardPageObject( WebDriver driver) {
	this.driver= driver;
    }
    public Object getWelcomeSuccessMessage() {
	waitElementVisible(driver, MyDashboardPageUI.WELCOME_REGISTER_SUCCESS_MESSAGE);
	return getTextElement(driver,MyDashboardPageUI.WELCOME_REGISTER_SUCCESS_MESSAGE);
    }
    public void clickToLogOutLink() {
	waitElementClickable(driver, MyDashboardPageUI.HEADER_ACCOUNT_LINK);
	clickToElement(driver, MyDashboardPageUI.HEADER_ACCOUNT_LINK);
	waitElementClickable(driver, MyDashboardPageUI.HEADER_ACCOUNT_LOGOUT_LINK);
	clickToElement(driver, MyDashboardPageUI.HEADER_ACCOUNT_LOGOUT_LINK);
    }

}
