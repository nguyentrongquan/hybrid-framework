package pageObject.liveguru.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class HomePageObject extends AbstractPage {
    WebDriver driver;	
    public HomePageObject( WebDriver driver) {
	this.driver= driver;
    }
    

}
