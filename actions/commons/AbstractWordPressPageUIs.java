package commons;

public class AbstractWordPressPageUIs {
	public static final String DYNAMIC_PAGE_BY_PAGE_NAME="//div[@class='wp-menu-name' and text()='%s']";
	public static final String UPLOAD_FILE_TYPE="//input[@type='file']";
	public static final String MEDIA_INPROGRESS_BAR_ICON="//div[@class='thumbnail']//div[@class='media-progress-bar']";
	public static final String ALL_UPLOAD_IMAGE="//div[@class='thumbnail']//img";
	public static final String SEARCH_POST_BY_TITLE_USER_PAGE ="//input[@placeholder='Search']";
	public static final String SEARCH_POST_BUTTON_USER_PAGE ="//button[@class='search-button']";
	public static final String SEARCH_POST_ACTIVE_BUTTON_USER_PAGE ="//a[@class='search-toggle']";
	public static final String DYNAMIC_IMAGE_AVATAR_POST_AT_TITLE="//a[@title='%s']//img[contains(@src,'%s')]";
	public static final String LATEST_POST="//p[@class='post-categories']//a[text()='%s']/parent::p/following-sibling::h2[@class='post-title']//a[text()='%s']/parent::h2/following-sibling::p[@class='post-meta']/a[text()='%s']";

}
