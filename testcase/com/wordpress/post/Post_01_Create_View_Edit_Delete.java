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
	public void Post_01_Create_New_Post_At_Admin_Page() {
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 01: click menu 'Post' Page");
		dashboardAdminPage.openMenuPageByPageName(driver, "Posts");
		postAdminPage = PageGeneratorManager.getPostAdminPage(driver);
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 02: click to 'Add New' post button");
		newEditPostAdminPage = postAdminPage.clickToAddNewButton();
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 03: input 'post tile' textbox");
		newEditPostAdminPage.inputToPostTitleTextbox(newPostTitle);
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 04:input 'post content' textbox");
		newEditPostAdminPage.inputToPostContentTextbox(newPostContent);
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 05: select category 'newPostCategory' checkbox");
		newEditPostAdminPage.selectCategoryCheckbox(newPostCategory);
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 06: input 'Tag' textbox");
		newEditPostAdminPage.inputToTagTextbox(newPostTag);
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 07: click to 'Tag' button");
		newEditPostAdminPage.clickToTagButton();
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 08: click to 'SetFeatureImage' link");
		newEditPostAdminPage.clickToSetFeatureImageLink();
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 09: click to 'UploadFiles' tab ");
		newEditPostAdminPage.clickToUploadFilesTab();
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 10:  upload file 'Select Files' ");
		newEditPostAdminPage.uploadMutipleFiles(driver, featureImage);
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 11: verify 'File Upload' displayed");
		verifyTrue(newEditPostAdminPage.areUploadFilesDisplayed(driver, featureImage));
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 12: click to 'Set FeatureImage' button");
		newEditPostAdminPage.clickToSetFeaturedImageButton();
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 13: verify 'Image thumnail' displayed");
		verifyTrue(newEditPostAdminPage.isUploadFilesImageDisplayed(featureImage));
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 14: click to 'Publish' button");
		newEditPostAdminPage.clickToPublishButton();
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 15: verify success message'Post published' displayed ");
		verifyTrue(newEditPostAdminPage.isPostSuccessMessageDisplayedWithValue("Post published."));
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 16: click to menu 'Post' page ");
		newEditPostAdminPage.openMenuPageByPageName(driver, "Posts");
		postAdminPage = PageGeneratorManager.getPostAdminPage(driver);

		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 16: input to 'Search Post' textbox");
		postAdminPage.inputToSearchPostTextbox(newPostTitle);
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 17: click to 'Search Post' button");
		postAdminPage.clickToSearchPostButton();
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 18: verify only one row 'Post' displayed ");
		verifyTrue(postAdminPage.isOnlyOneRowDisplayed(newPostTitle, author, newPostCategory, newPostTag));

		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 01: open Post Page");
		homeUserPage = postAdminPage.openEndUserPage(driver);
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 01: open Post Page");
		verifyTrue(homeUserPage.isPostDisplayedOnLatestPost(driver, newPostCategory,newPostTitle,datecreate));
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 01: open Post Page");
		verifyTrue(homeUserPage.isPostImageDisplayedAtPostTitleName(driver, newPostTitle,featureImage));
		

		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 01: open Post Page");
		postDetailPage = homeUserPage.clickToDetailWithTitleName(newPostTitle);
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 01: open Post Page");
		verifyTrue(postDetailPage.isPostDetailTitleNameDisplayed(newPostTitle));
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 01: open Post Page");
		verifyTrue(postDetailPage.isPostDetailCategoryNameDisplayed(newPostCategory));
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 01: open Post Page");
		verifyTrue(postDetailPage.isPostDetailImageNameDisplayed(featureImage));
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 01: open Post Page");
		verifyTrue(postDetailPage.isPostDetailContentDisplayed(newPostContent));
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 01: open Post Page");
		verifyTrue(postDetailPage.isPostDetailTagDisplayed(newPostTag));
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 01: open Post Page");
		verifyTrue(postDetailPage.isPostDetailDateCreatedDisplayed(datecreate));
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 01: open Post Page");
		verifyTrue(postDetailPage.isPostDetailAuthorDisplayed(author));

		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 01: open Post Page");
		searchResultPage = postDetailPage.inputToSearchTexboxAtEndUserPage(driver, newPostTitle);
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 01: open Post Page");
		verifyTrue(searchResultPage.isPostTitleDisplayedOnHeader(newPostTitle));
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 01: open Post Page");
		verifyTrue(searchResultPage.isPostDisplayedOnLatestPost(driver, newPostCategory,newPostTitle,datecreate));
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 01: open Post Page");
		verifyTrue(searchResultPage.isPostImageDisplayedAtPostTitleName(driver, newPostTitle,featureImage));

	}
	@Test
	public void Post_02_Edit_Post_At_Admin_Page() {
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		dashboardAdminPage = searchResultPage.openAdminPage(driver);

		// Search_Post_At_Admin_Page
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		dashboardAdminPage.openMenuPageByPageName(driver, "Posts");
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		postAdminPage = PageGeneratorManager.getPostAdminPage(driver);
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		postAdminPage.inputToSearchPostTextbox(newPostTitle);
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		postAdminPage.clickToSearchPostButton();
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		verifyTrue(postAdminPage.isOnlyOneRowDisplayed(newPostTitle, author, newPostCategory, newPostTag));

		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		newEditPostAdminPage = postAdminPage.clickToPostWithTitleName(newPostTitle);
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		newEditPostAdminPage.inputToPostTitleTextbox(editPostTitle);
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		newEditPostAdminPage.inputToPostContentTextbox(editPostContent);
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		newEditPostAdminPage.deSelectCategoryCheckbox(newPostCategory);
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		newEditPostAdminPage.selectCategoryCheckbox(editPostCategory);
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		newEditPostAdminPage.inputToTagTextbox(editPostTag);
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		newEditPostAdminPage.clickToTagButton();
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		newEditPostAdminPage.clickToDeleteWithTagName(newPostTag);
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		newEditPostAdminPage.clickToUpdateButton();
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		verifyTrue(newEditPostAdminPage.isPostSuccessMessageDisplayedWithValue("Post updated."));

		// View_Post_At_User_Page
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		homeUserPage = newEditPostAdminPage.openEndUserPage(driver);

		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		verifyTrue(homeUserPage.isPostDisplayedOnLatestPost(driver, editPostCategory,editPostTitle,datecreate));
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		verifyTrue(homeUserPage.isPostImageDisplayedAtPostTitleName(driver, editPostTitle,featureImage));

		// Go_Post_Detail At_User_Page
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		postDetailPage = homeUserPage.clickToDetailWithTitleName(editPostTitle);
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		verifyTrue(postDetailPage.isPostDetailTitleNameUnDisplayed(newPostTitle));
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		verifyTrue(postDetailPage.isPostDetailTitleNameDisplayed(editPostTitle));
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		verifyTrue(postDetailPage.isPostDetailCategoryNameUnDisplayed(newPostCategory));
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		verifyTrue(postDetailPage.isPostDetailCategoryNameDisplayed(editPostCategory));
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		verifyTrue(postDetailPage.isPostDetailTagUnDisplayed(newPostTag));
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		verifyTrue(postDetailPage.isPostDetailTagDisplayed(editPostTag));
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		verifyTrue(postDetailPage.isPostDetailImageNameDisplayed(featureImage));
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		verifyTrue(postDetailPage.isPostDetailContentDisplayed(editPostContent));
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		verifyTrue(postDetailPage.isPostDetailDateCreatedDisplayed(datecreate));
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		verifyTrue(postDetailPage.isPostDetailAuthorDisplayed(author));

		// Search_Post_At_User_Page
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		searchResultPage = postDetailPage.inputToSearchTexboxAtEndUserPage(driver, editPostTitle);
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		verifyTrue(searchResultPage.isPostTitleDisplayedOnHeader(editPostTitle));	
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		verifyTrue(searchResultPage.isPostDisplayedOnLatestPost(driver, editPostCategory,editPostTitle,datecreate));
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Post Page");
		verifyTrue(searchResultPage.isPostImageDisplayedAtPostTitleName(driver, editPostTitle,featureImage));
	}
	@Test
	
	public void Post_03_Delete_Post_At_Admin_Page() {
		// navigate to amdin site
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 01: open Post Page");
		dashboardAdminPage = searchResultPage.openAdminPage(driver);

		// Search_Post_At_Admin_Page
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 01: open Post Page");
		dashboardAdminPage.openMenuPageByPageName(driver, "Posts");
		
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 01: open Post Page");
		postAdminPage = PageGeneratorManager.getPostAdminPage(driver);
		
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 01: open Post Page");
		postAdminPage.inputToSearchPostTextbox(editPostTitle);
		
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 01: open Post Page");
		postAdminPage.clickToSearchPostButton();
		
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 01: open Post Page");
		verifyTrue(postAdminPage.isOnlyOneRowDisplayed(editPostTitle, author, editPostCategory, editPostTag));
		
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 01: open Post Page");
		newEditPostAdminPage = postAdminPage.clickToPostWithTitleName(editPostTitle);
		
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 01: open Post Page");
		postAdminPage = newEditPostAdminPage.clickToMoveTrashButton();
		
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 01: open Post Page");
		verifyTrue(postAdminPage.isPostSuccessMessageDisplayedWithValue("1 post moved to the Trash."));
		
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 01: open Post Page");
		postAdminPage.inputToSearchPostTextbox(editPostTitle);
		
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 01: open Post Page");
		postAdminPage.clickToSearchPostButton();
		
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 01: open Post Page");
		verifyTrue(postAdminPage.isPostDeletedUnDisplayedOnSearchPost(editPostTitle, author, editPostCategory, editPostTag));
		
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 01: open Post Page");
		verifyTrue(postAdminPage.isNoPostFoundMessageDisplayed("No posts found."));
		
		// View_Post_At_User_Page
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 01: open Post Page");
		homeUserPage = postAdminPage.openEndUserPage(driver);
		
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 01: open Post Page");
		verifyTrue(homeUserPage.isPostUnDisplayedOnLatestPost(driver, editPostCategory,editPostTitle,datecreate));
		
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 01: open Post Page");
		verifyTrue(homeUserPage.isPostImageUnDisplayedAtPostTitleName(driver, editPostTitle,featureImage));

		// Search_Post_At_User_Page
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 01: open Post Page");
		searchResultPage = homeUserPage.inputToSearchTexboxAtEndUserPage(driver, editPostTitle);
		
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 01: open Post Page");
		verifyTrue(searchResultPage.isPostTitleDisplayedOnHeader(editPostTitle));
		
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 01: open Post Page");
		verifyTrue(searchResultPage.isMessagePostNoFoundDisplayed());
		
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 01: open Post Page");
		verifyTrue(searchResultPage.isPostUnDisplayedOnLatestPost(driver, editPostCategory,editPostTitle,datecreate));
		
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 01: open Post Page");
		verifyTrue(searchResultPage.isPostImageUnDisplayedAtPostTitleName(driver, editPostTitle,featureImage));
	}

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
