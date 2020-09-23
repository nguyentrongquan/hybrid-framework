package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorNopcommerceManager;
import pageUIs.nopcommerce.user.ComputerPageUI;

public class ComputerPageObject extends AbstractPage{
	private WebDriver driver;

	public ComputerPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public NotebooksPageObject openToNotebooksPage() {
		waitElementClickable(driver, ComputerPageUI.OPEN_PAGE_NOTEBOOKS_LINK);
		clickToElement(driver, ComputerPageUI.OPEN_PAGE_NOTEBOOKS_LINK);
		return PageGeneratorNopcommerceManager.getNotebooksPage(driver);
		
	}

}
