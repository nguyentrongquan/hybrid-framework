package commons;

import org.openqa.selenium.WebDriver;

import pageObject.nopcommerce.user.AddressPageObject;
import pageObject.nopcommerce.user.ChangePasswordPageObject;
import pageObject.nopcommerce.user.ComputerPageObject;
import pageObject.nopcommerce.user.CustomerInfoPageObject;
import pageObject.nopcommerce.user.HomePageObject;
import pageObject.nopcommerce.user.LoginPageObject;
import pageObject.nopcommerce.user.MyAccountPageObject;
import pageObject.nopcommerce.user.MyProductReviewPageObject;
import pageObject.nopcommerce.user.NotebooksPageObject;
import pageObject.nopcommerce.user.ProductDetailPageObject;
import pageObject.nopcommerce.user.ProductReviewPageObject;
import pageObject.nopcommerce.user.RegisterPageObject;
import pageObject.nopcommerce.user.SearchPageObject;


public class PageGeneratorNopcommerceManager {
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
		return new MyAccountPageObject(driver);
	}
	
	public static NotebooksPageObject getNotebooksPage(WebDriver driver) {
		return new NotebooksPageObject(driver);
	}
	public static ComputerPageObject getComputerPage(WebDriver driver) {
		return new ComputerPageObject(driver);
	}
	public static CustomerInfoPageObject getCustomerPage(WebDriver driver) {
		return new CustomerInfoPageObject(driver);
	}
	public static ChangePasswordPageObject getChangePasswordPage(WebDriver driver) {
		return new ChangePasswordPageObject(driver);
	}
	
	public static AddressPageObject getAddressPage(WebDriver driver) {
		return new AddressPageObject(driver);
	}
	
	public static MyProductReviewPageObject getMyProductReviewPage(WebDriver driver) {
		return new MyProductReviewPageObject(driver);
	}
	
	public static SearchPageObject getSearchPage(WebDriver driver) {
		return new SearchPageObject(driver);
	}
	
	public static ProductReviewPageObject getProductReviewPage(WebDriver driver) {
		return new ProductReviewPageObject(driver);
	}
	
	public static ProductDetailPageObject getProductDetailPage(WebDriver driver) {
		return new ProductDetailPageObject(driver);
	}
	

}
