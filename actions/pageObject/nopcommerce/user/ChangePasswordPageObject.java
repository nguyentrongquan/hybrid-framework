package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorNopcommerceManager;
import pageUIs.nopcommerce.user.ChangePasswordPageUI;
import pageUIs.nopcommerce.user.ComputerPageUI;

public class ChangePasswordPageObject extends AbstractPage{
	private WebDriver driver;

	public ChangePasswordPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public boolean isMessageChangePasswordSuccessDisplayed(String textMessage) {
		waitElementVisible(driver, ChangePasswordPageUI.CHANGE_PASSWORD_MESSAGE, textMessage);
		return isElementDisplayed(driver, ChangePasswordPageUI.CHANGE_PASSWORD_MESSAGE, textMessage);
	}

	public void clickToChangePasswordButton() {
		waitElementClickable(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver,  ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
	}


}
