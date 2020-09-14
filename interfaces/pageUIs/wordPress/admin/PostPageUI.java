package pageUIs.wordPress.admin;

public class PostPageUI {
	public static final String ADD_NEW_POST_BUTTON="//a[@class='page-title-action' and text()='Add New']";
	public static final String SEARCH_POST_TEXTBOX="//input[@id='post-search-input']";
	public static final String SEARCH_POST_BUTTON="//input[@id='search-submit']";
	public static final String SEARCH_ONLY_ONE_ROW="//tr//a[text()='%s']//ancestor::td//following-sibling::td/a[text()='%s']//ancestor::td//following-sibling::td/a[text()='%s']//ancestor::td//following-sibling::td/a[text()='%s']";
}
