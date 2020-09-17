package com.wordpress.post;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObject.wordPress.user.HomePageObject;
import pageObject.wordPress.user.PostDetailPageObject;
import pageObject.wordPress.user.SearchResultPageObject;
import pageObjects.wordPress.admin.DashboardPageObject;
import pageObjects.wordPress.admin.LoginPageObject;
import pageObjects.wordPress.admin.NewEditPostPageObject;
import pageObjects.wordPress.admin.PostPageObject;

public class Post_01_Create_View_Edit_Delete extends AbstractTest {
	private WebDriver driver;
	int fakeNumber = randomNumber();
	String datecreate=getToday();
	String featureImage ="Coding-automation.jpeg";
	String newPostTitle="[QUANNT] NEW_POST_TITLE"+ fakeNumber;
	String newPostCategory="NEW LIVE CODING";
	String newPostContent="[QUANNT] NEW POST CONTENT"+ fakeNumber;
	String author="Automation FC";
	String newPostTag="NEW Post Tag"+ fakeNumber;
	String editPostTitle = "[QUANNT] EDIT_POST_TITLE"+ fakeNumber;
	String editPostCategory="EDIT LIVE CODING";
	String editPostContent="[QUANNT] EDIT POST CONTENT"+ fakeNumber;
	String editPostTag="Edit Post Tag"+ fakeNumber;
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-condition - Open browser");
		driver = getBrowserDriver(browserName, appUrl);

		log.info("Pre-condition - STEP 01: Open Login Page Admin");
		loginAdminPage = PageGeneratorManager.getLoginAdminPage(driver);

		log.info("Pre-condition - STEP 02: Input To 'Email' textbox ");
		loginAdminPage.inputToEmailOrUsernameTextbox(GlobalConstants.USER_NAME);

		log.info("Pre-condition - STEP 03: Click to 'Continue' button");
		loginAdminPage.clickToContinueButton();

		log.info("Pre-condition - STEP 04: Input to 'Password' textbox");
		loginAdminPage.inputToPasswordTextbox(GlobalConstants.PASS_WORD);

		log.info("Pre-condition - STEP 05: Click to 'Login' button");
		dashboardAdminPage = loginAdminPage.clickToLoginButton(driver);

		log.info("Pre-condition - STEP 06: Verify Dashboard Header Displayed");
		Assert.assertTrue(dashboardAdminPage.isDashboardHeaderDisplayed());
	}

	@Test
	public void TC_Post_01_Create_New_Post_At_Admin_Page() {
		// new_post
		dashboardAdminPage.openMenuPageByPageName(driver, "Posts");
		postAdminPage = PageGeneratorManager.getPostAdminPage(driver);

		newEditPostAdminPage = postAdminPage.clickToAddNewButton();
		newEditPostAdminPage.inputToPostTitleTextbox(newPostTitle);
		newEditPostAdminPage.inputToPostContentTextbox(newPostContent);
		newEditPostAdminPage.selectCategoryCheckbox(newPostCategory);
		newEditPostAdminPage.inputToTagTextbox(newPostTag);
		newEditPostAdminPage.clickToTagButton();
		newEditPostAdminPage.clickToSetFeatureImageLink();
		newEditPostAdminPage.clickToUploadFilesTab();
		newEditPostAdminPage.uploadMutipleFiles(driver, featureImage);
		verifyTrue(newEditPostAdminPage.areUploadFilesDisplayed(driver, featureImage));
		newEditPostAdminPage.clickToSetFeaturedImageButton();
		verifyTrue(newEditPostAdminPage.isUploadFilesImageDisplayed(featureImage));
		newEditPostAdminPage.clickToPublishButton();
		verifyTrue(newEditPostAdminPage.isPostSuccessMessageDisplayedWithValue("Post published."));
		newEditPostAdminPage.openMenuPageByPageName(driver, "Posts");
		postAdminPage = PageGeneratorManager.getPostAdminPage(driver);

		// Search_Post_At_Admin_Page
		postAdminPage.inputToSearchPostTextbox(newPostTitle);
		postAdminPage.clickToSearchPostButton();
		verifyTrue(postAdminPage.isOnlyOneRowDisplayed(newPostTitle, author, newPostCategory, newPostTag));

		// View_Post_At_User_Page
		homeUserPage = postAdminPage.openEndUserPage(driver);
		verifyTrue(homeUserPage.isPostDisplayedOnLatestPost(driver, newPostCategory,newPostTitle,datecreate));
		verifyTrue(homeUserPage.isPostImageDisplayedAtPostTitleName(driver, newPostTitle,featureImage));
		

		// Go_Post_Detail At_User_Page
		postDetailPage = homeUserPage.clickToDetailWithTitleName(newPostTitle);
		verifyTrue(postDetailPage.isPostDetailTitleNameDisplayed(newPostTitle));
		verifyTrue(postDetailPage.isPostDetailCategoryNameDisplayed(newPostCategory));
		verifyTrue(postDetailPage.isPostDetailImageNameDisplayed(featureImage));
		verifyTrue(postDetailPage.isPostDetailContentDisplayed(newPostContent));
		verifyTrue(postDetailPage.isPostDetailTagDisplayed(newPostTag));
		verifyTrue(postDetailPage.isPostDetailDateCreatedDisplayed(datecreate));
		verifyTrue(postDetailPage.isPostDetailAuthorDisplayed(author));

		// Search_Post_At_User_Page
		searchResultPage = postDetailPage.inputToSearchTexboxAtEndUserPage(driver, newPostTitle);
		
		verifyTrue(searchResultPage.isPostTitleDisplayedOnHeader(newPostTitle));
		
		verifyTrue(searchResultPage.isPostDisplayedOnLatestPost(driver, newPostCategory,newPostTitle,datecreate));
		verifyTrue(searchResultPage.isPostImageDisplayedAtPostTitleName(driver, newPostTitle,featureImage));

	}
	@Test
	public void TC_Post_02_Edit_Post_At_Admin_Page() {
		// navigate to amdin site
		dashboardAdminPage = searchResultPage.openAdminPage(driver);

		// Search_Post_At_Admin_Page
		dashboardAdminPage.openMenuPageByPageName(driver, "Posts");
		postAdminPage = PageGeneratorManager.getPostAdminPage(driver);
		postAdminPage.inputToSearchPostTextbox(newPostTitle);
		postAdminPage.clickToSearchPostButton();
		verifyTrue(postAdminPage.isOnlyOneRowDisplayed(newPostTitle, author, newPostCategory, newPostTag));

		// edit post
		newEditPostAdminPage = postAdminPage.clickToPostWithTitleName(newPostTitle);
		newEditPostAdminPage.inputToPostTitleTextbox(editPostTitle);
		newEditPostAdminPage.inputToPostContentTextbox(editPostContent);
		newEditPostAdminPage.deSelectCategoryCheckbox(newPostCategory);
		newEditPostAdminPage.selectCategoryCheckbox(editPostCategory);
		newEditPostAdminPage.inputToTagTextbox(editPostTag);
		newEditPostAdminPage.clickToTagButton();
		newEditPostAdminPage.clickToDeleteWithTagName(newPostTag);
		newEditPostAdminPage.clickToUpdateButton();
		verifyTrue(newEditPostAdminPage.isPostSuccessMessageDisplayedWithValue("Post updated."));

		// View_Post_At_User_Page
		homeUserPage = newEditPostAdminPage.openEndUserPage(driver);

		verifyTrue(homeUserPage.isPostDisplayedOnLatestPost(driver, editPostCategory,editPostTitle,datecreate));
		verifyTrue(homeUserPage.isPostImageDisplayedAtPostTitleName(driver, editPostTitle,featureImage));

		// Go_Post_Detail At_User_Page
		postDetailPage = homeUserPage.clickToDetailWithTitleName(editPostTitle);
		verifyTrue(postDetailPage.isPostDetailTitleNameUnDisplayed(newPostTitle));
		verifyTrue(postDetailPage.isPostDetailTitleNameDisplayed(editPostTitle));
		verifyTrue(postDetailPage.isPostDetailCategoryNameUnDisplayed(newPostCategory));
		verifyTrue(postDetailPage.isPostDetailCategoryNameDisplayed(editPostCategory));
		verifyTrue(postDetailPage.isPostDetailTagUnDisplayed(newPostTag));
		verifyTrue(postDetailPage.isPostDetailTagDisplayed(editPostTag));
		verifyTrue(postDetailPage.isPostDetailImageNameDisplayed(featureImage));
		verifyTrue(postDetailPage.isPostDetailContentDisplayed(editPostContent));
		verifyTrue(postDetailPage.isPostDetailDateCreatedDisplayed(datecreate));
		verifyTrue(postDetailPage.isPostDetailAuthorDisplayed(author));

		// Search_Post_At_User_Page
		searchResultPage = postDetailPage.inputToSearchTexboxAtEndUserPage(driver, editPostTitle);
		verifyTrue(searchResultPage.isPostTitleDisplayedOnHeader(editPostTitle));		
		verifyTrue(searchResultPage.isPostDisplayedOnLatestPost(driver, editPostCategory,editPostTitle,datecreate));
		verifyTrue(searchResultPage.isPostImageDisplayedAtPostTitleName(driver, editPostTitle,featureImage));
	}
//	@Test
//	
//	public void TC_Post_03_Delete_Post_At_Admin_Page() {
		// navigate to amdin site
//		dashboardAdminPage = searchResultPage.openAdminPage(driver);
//
//		// Search_Post_At_Admin_Page
//		dashboardAdminPage.inputToSearchPostTextbox();
//		dashboardAdminPage.clickToSearchPostButton();
//		verifyTrue(dashboardAdminPage.isOnlyOneRowDisplayed("edit_title", "author", "edit_category", "edit_tag"));
//
//		newEditPostAdminPage = dashboardAdminPage.clickToPostDetailByTitleName("edit_title");
//		postAdminPage = newEditPostAdminPage.clickToMoveTrashButton();
//		verifyTrue(postAdminPage.isPostSuccessMessageDisplayedWithValue("deleted"));
//		//search post admin Page
//		postAdminPage.inputToSearchPostTextbox("title");
//		postAdminPage.clickToSearchPostButton();
//		verifyFalse(dashboardAdminPage.isOnlyOneRowDisplayed("title", "author", "category", "tag"));
//		verifyTrue(dashboardAdminPage.isNoPostFoundMessageDisplayed("no post found"));
//		
//		// View_Post_At_User_Page
//		homeUserPage = postAdminPage.openEndUserPage(driver);
//		verifyFalse(homeUserPage.isNewPostDisplayedOnLatestPost("category", "title", "date"));
//		verifyFalse(homeUserPage.isPostImageDisplayedAtPostTitleName("title", "image"));
//
//		// Search_Post_At_User_Page
//		searchResultPage = postDetailPage.inputToSearchTexboxAtEndUserPage(driver, "title");
//		// design trong abstractpage
//		verifyFalse(searchResultPage.isNewPostDisplayedOnLatestPost("category", "title", "date"));
//		verifyfalse(searchResultPage.isPostImageDisplayedAtPostTitleName("title", "image"));
//	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("Post condition - Close browser ");
		closeBrowserAndDriver(driver);
	}
	
	LoginPageObject loginAdminPage;
	DashboardPageObject dashboardAdminPage;
	PostPageObject postAdminPage;
	NewEditPostPageObject newEditPostAdminPage;
	HomePageObject homeUserPage;
	PostDetailPageObject postDetailPage;
	SearchResultPageObject searchResultPage;
	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}
}
