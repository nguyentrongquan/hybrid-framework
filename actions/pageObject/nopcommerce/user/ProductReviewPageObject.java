package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopcommerce.user.ProductReviewPageUI;

public class ProductReviewPageObject extends AbstractPage {
	private WebDriver driver;

	public ProductReviewPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public void inputToReviewTitle(String textTitle) {
		waitElementVisible(driver, ProductReviewPageUI.PRODUCT_REVIEW_TITLE);
		sendkeyToElement(driver, ProductReviewPageUI.PRODUCT_REVIEW_TITLE, textTitle);
	}

	public void inputToReviewText(String textContent) {
		waitElementVisible(driver, ProductReviewPageUI.PRODUCT_REVIEW_TEXT);
		sendkeyToElement(driver, ProductReviewPageUI.PRODUCT_REVIEW_TEXT, textContent);
	}

	public void selectToRatingRadioButton(String itemRating) {
		waitElementClickable(driver, ProductReviewPageUI.RATING_RADIO_BUTTON, itemRating);
		clickToElement(driver, ProductReviewPageUI.RATING_RADIO_BUTTON, itemRating);
	}

	public void clickToSubmitReviewButton() {
		waitElementClickable(driver, ProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, ProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
	}

	public boolean isMessageProductReviewSuccessDisplayed(String textMessage) {
		waitElementVisible(driver, ProductReviewPageUI.MESSAGE_REVIEW_SUCCESS_TEXT,textMessage );
		return isElementDisplayed(driver, ProductReviewPageUI.MESSAGE_REVIEW_SUCCESS_TEXT,textMessage);
		
	}

	

	



}
