package pageUIs.wordPress.user;

public class HomePageUI {
	public static final String NEW_LATEST_POST="//p[@class='post-categories']//a[text()='%s']/parent::p/following-sibling::h2[@class='post-title']//a[text()='%s']/parent::h2/following-sibling::p[@class='post-meta']/a[text()='%s']";
	public static final String FEATURE_IMAGE_NEW_POST="//img[contains(@src,'%s')]";
	public static final String TITLE_POST_LINK="//h2[@class='post-title']/a[text()='%s']";

}
