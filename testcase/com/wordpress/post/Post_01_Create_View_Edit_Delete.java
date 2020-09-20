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
import commons.PageGeneratorWordPressManager;
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
		loginAdminPage = PageGeneratorWordPressManager.getLoginAdminPage(driver);

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
		postAdminPage = PageGeneratorWordPressManager.getPostAdminPage(driver);
		
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
		postAdminPage = PageGeneratorWordPressManager.getPostAdminPage(driver);

		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 16: input to 'Search Post' textbox");
		postAdminPage.inputToSearchPostTextbox(newPostTitle);
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 17: click to 'Search Post' button");
		postAdminPage.clickToSearchPostButton();
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 18: verify only one row 'Post' displayed ");
		verifyTrue(postAdminPage.isOnlyOneRowDisplayed(newPostTitle, author, newPostCategory, newPostTag));

		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 19: open user Page");
		homeUserPage = postAdminPage.openEndUserPage(driver);
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 20: verify 'latest Post' displayed");
		verifyTrue(homeUserPage.isPostDisplayedOnLatestPost(driver, newPostCategory,newPostTitle,datecreate));
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 21: verify image 'latest post' at title displayed");
		verifyTrue(homeUserPage.isPostImageDisplayedAtPostTitleName(driver, newPostTitle,featureImage));
		

		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 22: click to 'Title' post ");
		postDetailPage = homeUserPage.clickToDetailWithTitleName(newPostTitle);
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 23: verify detail 'Title' name displayed");
		verifyTrue(postDetailPage.isPostDetailTitleNameDisplayed(newPostTitle));
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 24: verify detail 'Category' name displayed");
		verifyTrue(postDetailPage.isPostDetailCategoryNameDisplayed(newPostCategory));
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 25: verify detail 'Image' name displayed");
		verifyTrue(postDetailPage.isPostDetailImageNameDisplayed(featureImage));
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 26: verify detail 'Content' displayed");
		verifyTrue(postDetailPage.isPostDetailContentDisplayed(newPostContent));
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 27: verify detail 'Tag' displayed");
		verifyTrue(postDetailPage.isPostDetailTagDisplayed(newPostTag));
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 28: verify detail 'Date created' displayed");
		verifyTrue(postDetailPage.isPostDetailDateCreatedDisplayed(datecreate));
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 29: verify detail 'Author' displayed");
		verifyTrue(postDetailPage.isPostDetailAuthorDisplayed(author));

		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 30: input 'Search' textbox and click to 'Search' button");
		searchResultPage = postDetailPage.inputToSearchTexboxAtEndUserPage(driver, newPostTitle);
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 31: verify 'Post Title' on header displayed");
		verifyTrue(searchResultPage.isPostTitleDisplayedOnHeader(newPostTitle));
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 32: verify 'post' displayed");
		verifyTrue(searchResultPage.isPostDisplayedOnLatestPost(driver, newPostCategory,newPostTitle,datecreate));
		
		log.info("Post_01_Create_New_Post_At_Admin_Page- STEP 33: verify 'Image Post' displayed");
		verifyTrue(searchResultPage.isPostImageDisplayedAtPostTitleName(driver, newPostTitle,featureImage));

	}
	@Test
	public void Post_02_Edit_Post_At_Admin_Page() {
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 01: open Admin Post Page");
		dashboardAdminPage = searchResultPage.openAdminPage(driver);

		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 02: click to menu'Posts' Page");
		dashboardAdminPage.openMenuPageByPageName(driver, "Posts");
		postAdminPage = PageGeneratorWordPressManager.getPostAdminPage(driver);
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 03: input to 'Search Posts' textbox");
		postAdminPage.inputToSearchPostTextbox(newPostTitle);
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 04: click to 'Search Posts' button");
		postAdminPage.clickToSearchPostButton();
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 05: verify only one row 'Post' displayed");
		verifyTrue(postAdminPage.isOnlyOneRowDisplayed(newPostTitle, author, newPostCategory, newPostTag));

		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 06: click to 'Title Name' post ");
		newEditPostAdminPage = postAdminPage.clickToPostWithTitleName(newPostTitle);
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 07: input to 'Title' edit textbox");
		newEditPostAdminPage.inputToPostTitleTextbox(editPostTitle);
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 08: input to 'Content' edit textbox");
		newEditPostAdminPage.inputToPostContentTextbox(editPostContent);
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 09: deselect 'newCategory' checkbox");
		newEditPostAdminPage.deSelectCategoryCheckbox(newPostCategory);
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 10: select 'editCategory' checkbox ");
		newEditPostAdminPage.selectCategoryCheckbox(editPostCategory);
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 11: input to 'Tag' textbox");
		newEditPostAdminPage.inputToTagTextbox(editPostTag);
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 12: click to 'Tag' button");
		newEditPostAdminPage.clickToTagButton();
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 13: click to 'Delete Tag' button");
		newEditPostAdminPage.clickToDeleteWithTagName(newPostTag);
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 14: click to 'Update' button");
		newEditPostAdminPage.clickToUpdateButton();
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 15: verify success message'Post updated' displayed");
		verifyTrue(newEditPostAdminPage.isPostSuccessMessageDisplayedWithValue("Post updated."));

		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 16: open url 'User' Post Page");
		homeUserPage = newEditPostAdminPage.openEndUserPage(driver);

		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 17: verify 'Latest Post' displayed");
		verifyTrue(homeUserPage.isPostDisplayedOnLatestPost(driver, editPostCategory,editPostTitle,datecreate));
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 18: verify 'Image Post' displayed");
		verifyTrue(homeUserPage.isPostImageDisplayedAtPostTitleName(driver, editPostTitle,featureImage));

		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 19: click to 'Title Name'post ");
		postDetailPage = homeUserPage.clickToDetailWithTitleName(editPostTitle);
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 20: verify 'Title new_Post' on detail undisplayed ");
		verifyTrue(postDetailPage.isPostDetailTitleNameUnDisplayed(newPostTitle));
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 21: verify 'Title edit_Post' on detail displayed");
		verifyTrue(postDetailPage.isPostDetailTitleNameDisplayed(editPostTitle));
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 22: verify 'Category new_post' on detail undisplayed ");
		verifyTrue(postDetailPage.isPostDetailCategoryNameUnDisplayed(newPostCategory));
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 23: verify 'Category edit_post' on detail displayed");
		verifyTrue(postDetailPage.isPostDetailCategoryNameDisplayed(editPostCategory));
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 24: verify 'Tag new_post' on detail undisplayed");
		verifyTrue(postDetailPage.isPostDetailTagUnDisplayed(newPostTag));
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 25: verify 'Tag edit_post' on detail displayed");
		verifyTrue(postDetailPage.isPostDetailTagDisplayed(editPostTag));
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 26: verify 'Image Post' on detail displayed");
		verifyTrue(postDetailPage.isPostDetailImageNameDisplayed(featureImage));
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 27: verify 'Content edit_post' on detail displayed");
		verifyTrue(postDetailPage.isPostDetailContentDisplayed(editPostContent));
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 28: verify 'date created' on detail displayed");
		verifyTrue(postDetailPage.isPostDetailDateCreatedDisplayed(datecreate));
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 29: verify 'Author' on detail displayed");
		verifyTrue(postDetailPage.isPostDetailAuthorDisplayed(author));

		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 30: input to 'Search' textbox and click to 'Search' button");
		searchResultPage = postDetailPage.inputToSearchTexboxAtEndUserPage(driver, editPostTitle);
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 31: verify 'Post Title' on header displayed");
		verifyTrue(searchResultPage.isPostTitleDisplayedOnHeader(editPostTitle));	
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 32: verify 'edit_post' displayed");
		verifyTrue(searchResultPage.isPostDisplayedOnLatestPost(driver, editPostCategory,editPostTitle,datecreate));
		
		log.info("Post_02_Edit_Post_At_Admin_Page- STEP 33: verify 'Image Post' displayed");
		verifyTrue(searchResultPage.isPostImageDisplayedAtPostTitleName(driver, editPostTitle,featureImage));
	}
	@Test
	
	public void Post_03_Delete_Post_At_Admin_Page() {
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 01: open url 'Admin' Page");
		dashboardAdminPage = searchResultPage.openAdminPage(driver);

		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 02: click to menu'Posts' Page");
		dashboardAdminPage.openMenuPageByPageName(driver, "Posts");
		postAdminPage = PageGeneratorWordPressManager.getPostAdminPage(driver);
		
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 03: input to 'Search Posts' textbox");
		postAdminPage.inputToSearchPostTextbox(editPostTitle);
		
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 04:  click to 'Search Posts' button");
		postAdminPage.clickToSearchPostButton();
		
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 05: verify only one row 'Post' displayed");
		verifyTrue(postAdminPage.isOnlyOneRowDisplayed(editPostTitle, author, editPostCategory, editPostTag));
		
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 06:  click to 'Title Name' post");
		newEditPostAdminPage = postAdminPage.clickToPostWithTitleName(editPostTitle);
		
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 07: click to 'Move to Trash' button");
		postAdminPage = newEditPostAdminPage.clickToMoveTrashButton();
		
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 08: verify messages success 'Move to Trash' displayed");
		verifyTrue(postAdminPage.isPostSuccessMessageDisplayedWithValue("1 post moved to the Trash."));
		
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 09: input to 'Search Posts' textbox");
		postAdminPage.inputToSearchPostTextbox(editPostTitle);
		
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 10: click to 'Search Posts' button");
		postAdminPage.clickToSearchPostButton();
		
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 11: verify post deleted Undisplayed");
		verifyTrue(postAdminPage.isPostDeletedUnDisplayedOnSearchPost(editPostTitle, author, editPostCategory, editPostTag));
		
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 12: verify Message 'No Post Found' displayed");
		verifyTrue(postAdminPage.isNoPostFoundMessageDisplayed("No posts found."));
		
		// View_Post_At_User_Page
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 13: open url 'User' Page");
		homeUserPage = postAdminPage.openEndUserPage(driver);
		
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 14: verify 'Post' on latest post undisplayed");
		verifyTrue(homeUserPage.isPostUnDisplayedOnLatestPost(driver, editPostCategory,editPostTitle,datecreate));
		
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 15: verify 'image_Post' on latest post undisplayed");
		verifyTrue(homeUserPage.isPostImageUnDisplayedAtPostTitleName(driver, editPostTitle,featureImage));

		// Search_Post_At_User_Page
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 16: input to 'Search' textbox and click to 'Search' button");
		searchResultPage = homeUserPage.inputToSearchTexboxAtEndUserPage(driver, editPostTitle);
		
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 17: verify 'Post Title' on header displayed");
		verifyTrue(searchResultPage.isPostTitleDisplayedOnHeader(editPostTitle));
		
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 18: verify message post no found displayed");
		verifyTrue(searchResultPage.isMessagePostNoFoundDisplayed());
		
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 19:verify 'post' undisplayed ");
		verifyTrue(searchResultPage.isPostUnDisplayedOnLatestPost(driver, editPostCategory,editPostTitle,datecreate));
		
		log.info("Post_03_Delete_Post_At_Admin_Page - STEP 20: verify 'Image_Post' undisplayed");
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
