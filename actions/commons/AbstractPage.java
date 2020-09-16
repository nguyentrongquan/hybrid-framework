package commons;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.wordPress.user.HomePageObject;
import pageObject.wordPress.user.SearchResultPageObject;
import pageObjects.wordPress.admin.DashboardPageObject;
import pageObjects.wordPress.admin.LoginPageObject;
import pageUIs.wordPress.user.HomePageUI;


public abstract class AbstractPage {

	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public void setImplicitWait(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public String getCurentUrl(WebDriver driver) {
		return driver.getCurrentUrl();

	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();

	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();

	}

	public void refreshCurrenPage(WebDriver driver) {
		driver.navigate().refresh();

	}

	public void fowardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void waitAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		waitAlertPresence(driver);
		alert = driver.switchTo().alert();
		alert.accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitAlertPresence(driver);
		alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String getAlertText(WebDriver driver) {
		waitAlertPresence(driver);
		alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void sendkeyToAlert(WebDriver driver, String text) {
		waitAlertPresence(driver);
		alert = driver.switchTo().alert();
		alert.sendKeys(text);
	}

	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	public WebElement find(WebDriver driver, String xpathValue) {
		return driver.findElement(By.xpath(xpathValue));
	}

	public List<WebElement> finds(WebDriver driver, String xpathValue) {
		return driver.findElements(By.xpath(xpathValue));
	}

	public By byXpath(String xpathValue) {
		return By.xpath(xpathValue);
	}

	public void clickToElement(WebDriver driver, String xpathValue) {
		find(driver, xpathValue).click();
	}

	public void clickToElement(WebDriver driver, String xpathValue, String... values) {
		find(driver, castToObject(xpathValue, values)).click();
		
	}

	public String castToObject(String xpathValue, String... values) {
		return String.format(xpathValue, (Object[]) values);
	}

	public void sendkeyToElement(WebDriver driver, String xpathValue, String text) {

		element = find(driver, xpathValue);
		element.clear();
		element.sendKeys(text);

	}

	public void sendkeyToElement(WebDriver driver, String xpathValue, String text, String... values) {

		element = find(driver, castToObject(xpathValue, values));
		element.clear();
		element.sendKeys(text);

	}

	public void selectItemInDropdown(WebDriver driver, String xpathValue, String itemValue) {
		select = new Select(find(driver, xpathValue));
		select.selectByVisibleText(itemValue);

	}

	public String getSelectedItemInDropdown(WebDriver driver, String xpathValue) {
		select = new Select(find(driver, xpathValue));
		return select.getFirstSelectedOption().getText();

	}

	public boolean isDropdownMutiple(WebDriver driver, String xpathValue) {
		select = new Select(find(driver, xpathValue));
		return select.isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
			String expectedItem) {
		find(driver, parentLocator).click();
		sleepInSecond(1);

		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byXpath(childItemLocator)));

		List<WebElement> allItems = finds(driver, childItemLocator);

		for (WebElement item : allItems) {
			if (item.getText().equals(expectedItem)) {
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);

				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}

	public String getAtributeValue(WebDriver driver, String xpathValue, String attributeName) {
		return find(driver, xpathValue).getAttribute(attributeName);
	}

	public String getTextElement(WebDriver driver, String xpathValue) {
		return find(driver, xpathValue).getText();

	}

	public String getTextElement(WebDriver driver, String xpathValue, String... values) {
		return find(driver, castToObject(xpathValue, values)).getText();

	}

	public int countElementNumber(WebDriver driver, String xpathValue) {
		return finds(driver, xpathValue).size();

	}

	public int countElementNumber(WebDriver driver, String xpathValue, String... values) {
		return finds(driver, castToObject(xpathValue, values)).size();

	}

	public void checkTheCheckbox(WebDriver driver, String xpathValue) {
		element = find(driver, xpathValue);
		if (!element.isSelected()) {
			element.click();
		}

	}

	public void uncheckToTheCheckbox(WebDriver driver, String xpathValue) {
		element = find(driver, xpathValue);
		if (element.isSelected()) {
			element.click();
		}

	}

	public boolean isElementDisplayed(WebDriver driver, String xpathValue) {
		try {
			return find(driver, xpathValue).isDisplayed();
		} catch (NoSuchElementException noSuchException) {
			return false;
		}
		

	}
	public boolean isElementDisplayed(WebDriver driver, String xpathValue, String... values) {
		try {
			return find(driver, castToObject(xpathValue, values)).isDisplayed();
		} catch (NoSuchElementException noSuchException) {
			return false;
		}

	}
	public void overrideGlobalTimeout(WebDriver driver, long timeout) {
		
		driver.manage().timeouts().implicitlyWait(timeout,TimeUnit.SECONDS);
		
	}
	public boolean isElementUndisplayed(WebDriver driver, String xpathValue) {
		overrideGlobalTimeout(driver,GlobalConstants.SHORT_TIMEOUT);
		List<WebElement> elements = driver.findElements(By.xpath(xpathValue));
		
		if(elements.size() == 0) {
			System.out.println("Element not in DOM");
			overrideGlobalTimeout(driver,GlobalConstants.LONG_TIMEOUT);
			return true;
		}else if(elements.size() >0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element in Dom but not visible/displayed");
			overrideGlobalTimeout(driver,GlobalConstants.LONG_TIMEOUT);
			return true;
		}else {
			System.out.println("Element in Dom and visible/displayed");
			overrideGlobalTimeout(driver,GlobalConstants.LONG_TIMEOUT);
			return false;
		}
		
	}
	public boolean isElementUndisplayed(WebDriver driver, String xpathValue, String... values) {
		overrideGlobalTimeout(driver,GlobalConstants.SHORT_TIMEOUT);
		List<WebElement> elements = driver.findElements(By.xpath(castToObject(xpathValue, values)));
		
		if(elements.size() == 0) {
			System.out.println("Element not in DOM");
			overrideGlobalTimeout(driver,GlobalConstants.LONG_TIMEOUT);
			return true;
		}else if(elements.size() >0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element in Dom but not visible/displayed");
			overrideGlobalTimeout(driver,GlobalConstants.LONG_TIMEOUT);
			return true;
		}else {
			System.out.println("Element in Dom and visible/displayed");
			overrideGlobalTimeout(driver,GlobalConstants.LONG_TIMEOUT);
			return false;
		}
	}

	

	public boolean isElementSelected(WebDriver driver, String xpathValue) {
		return find(driver, xpathValue).isSelected();

	}

	public boolean isElementEnabled(WebDriver driver, String xpathValue) {
		return find(driver, xpathValue).isEnabled();

	}

	public void switchToFrameOrIframe(WebDriver driver, String xpathValue) {
		driver.switchTo().frame(find(driver, xpathValue));

	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverToElement(WebDriver driver, String xpathValue) {
		action = new Actions(driver);
		action.moveToElement(find(driver, xpathValue)).perform();

	}

	public void sendkeyBoardToElement(WebDriver driver, String xpathValue, Keys key) {
		action = new Actions(driver);
		action.sendKeys(find(driver, xpathValue), key).perform();

	}

	public void sendkeyBoardToElement(WebDriver driver, String xpathValue, Keys key, String... values) {
		action = new Actions(driver);
		action.sendKeys(find(driver, castToObject(xpathValue, values)), key).perform();

	}

	public Object executeForBrowser(String javaSript) {
		return jsExecutor.executeScript(javaSript);
	}

	public boolean verifyTextInInnerText(String textExpected) {
		String textActual = (String) jsExecutor
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		System.out.println("Text actual = " + textActual);
		return textActual.equals(textExpected);
	}

	// Element
	public void highlightElement(WebDriver driver, String xpathValue) {
		element = find(driver, xpathValue);
		String originalStyle = element.getAttribute("style");
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 5px solid red; border-style: dashed;");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);

	}

	public void clickToElementByJS(WebDriver driver, String xpathValue) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", find(driver, xpathValue));
	}
	public void clickToElementByJS(WebDriver driver, String xpathValue, String... values) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", find(driver, castToObject(xpathValue, values)));
	}

	public void scrollToElement(WebDriver driver, String xpathValue) {
		
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", find(driver, xpathValue));
	}
	public void scrollToElement(WebDriver driver, String xpathValue, String... values) {

		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", find(driver,castToObject(xpathValue, values)));
	}

	public void sendkeyToElementByJS(WebDriver driver, String xpathValue, String value) {

		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", find(driver, xpathValue));
	}

	public void removeAttributeInDOM(WebDriver driver, String xpathValue, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", find(driver, xpathValue));
	}
	public void removeAttributeInDOM(WebDriver driver, String xpathValue, String attributeRemove, String... values) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", find(driver, castToObject(xpathValue, values)));
	}

	public boolean isImageLoaded(WebDriver driver, String xpathValue) {
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return  arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				find(driver, xpathValue));
		if (status) {
			return true;
		} else {
			return false;
		}
		
	}
	public boolean isImageLoaded(WebDriver driver, String xpathValue, String... values) {
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return  arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				find(driver, castToObject(xpathValue, values)));
		if (status) {
			return true;
		} else {
			return false;
		}

	}

	public void waitElementVisible(WebDriver driver, String xpathValue) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(xpathValue)));
	}

	public void waitElementVisible(WebDriver driver, String xpathValue, String... values) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(castToObject(xpathValue, values))));
		System.out.println(castToObject(xpathValue, values));
	}

	public void waitElementClickable(WebDriver driver, String xpathValue) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(xpathValue)));
	}

	public void waitElementClickable(WebDriver driver, String xpathValue, String... values) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(castToObject(xpathValue, values))));
		System.out.println(castToObject(xpathValue, values));
	}

	public void waitElementInvisible(WebDriver driver, String xpathValue) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(byXpath(xpathValue)));
	}
	public void waitElementsInvisible(WebDriver driver, String xpathValue) {
		explicitWait = new WebDriverWait(driver,GlobalConstants.LONG_TIMEOUT);
		elements = finds(driver,xpathValue);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}
	public void uploadMutipleFiles(WebDriver driver, String... fileNames) {
		String filePath= GlobalConstants.UPLOAD_FOLDER;
		String fullFileName = "";
		for(String file : fileNames) {
			fullFileName = fullFileName + filePath+ file + "\n";
		}
		fullFileName =fullFileName.trim();
		sendkeyToElement(driver,AbstractWordPressPageUIs.UPLOAD_FILE_TYPE,fullFileName);
	}
	
	public boolean areUploadFilesDisplayed(WebDriver driver, String... fileNames) {
		boolean status= false;
		int number = fileNames.length;
		waitElementsInvisible(driver,AbstractWordPressPageUIs.MEDIA_INPROGRESS_BAR_ICON);
		sleepInSecond(5);
		elements= finds(driver,AbstractWordPressPageUIs.ALL_UPLOAD_IMAGE);
		ArrayList<String> imageValues = new ArrayList<String>();
		int i=0;
		for (WebElement image : elements) {
			System.out.println(image.getAttribute("src"));
			imageValues.add(image.getAttribute("src"));
			System.out.println(imageValues.size());
			i++;
			if(i == number) {
				break;
			}
			
		}
		for(String fileName: fileNames) {
			String[] file= fileName.split("\\.");
			fileName = file[0].toLowerCase();
			
			for(i=0;i< imageValues.size();i++) {
				if(!imageValues.get(i).contains(fileName)) {
					status =false;
					if(i == imageValues.size() -1) {
						return status;
					}
				}else {
					status=true;
					break;
				}
			}
			
				
		}
				
		return status;
		
	}
	public void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

//	public AboutUsPageObject openAboutUsPage(WebDriver driver) {
//		waitElementVisible(driver, AbstractPageUI.ABOUT_US_FOOTER_LINK);
//		clickToElement(driver, AbstractPageUI.ABOUT_US_FOOTER_LINK);
//		return PageGeneratorManager.getAboutUsPage(driver);
//	}
//
//	public SearchTermPageObject openSearchTermPage(WebDriver driver) {
//		waitElementVisible(driver, AbstractPageUI.SEARCH_TERM_FOOTER_LINK);
//		clickToElement(driver, AbstractPageUI.SEARCH_TERM_FOOTER_LINK);
//		return PageGeneratorManager.getSearchTermPage(driver);
//	}
//
//	public CustomerServicePageObject openCustomerServicePage(WebDriver driver) {
//		waitElementVisible(driver, AbstractPageUI.CUSTOMER_SERVICE_FOOTER_LINK);
//		clickToElement(driver, AbstractPageUI.CUSTOMER_SERVICE_FOOTER_LINK);
//		return PageGeneratorManager.getCustomerServicePage(driver);
//
//	}
//
//	public AdvancedSearchPageObject openAdvancedSearchPage(WebDriver driver) {
//		waitElementVisible(driver, AbstractPageUI.ADVANCED_SEARCH_FOOTER_LINK);
//		clickToElement(driver, AbstractPageUI.ADVANCED_SEARCH_FOOTER_LINK);
//		return PageGeneratorManager.getAdvancedSearchPage(driver);
//	}

	// số lượng page ít (15-20Page)
//	public AbstractPage openPageByName(WebDriver driver, String pageName) {
//		waitElementVisible(driver, AbstractPageUI.DYNAMIC_FOOTER_PAGE, pageName);
//		clickToElement(driver, AbstractPageUI.DYNAMIC_FOOTER_PAGE, pageName);
//
//		if (pageName.equals("About Us")) {
//			return PageGeneratorManager.getAboutUsPage(driver);
//
//		} else if (pageName.equals("Search Terms")) {
//			return PageGeneratorManager.getSearchTermPage(driver);
//		} else if (pageName.equals("Customer Service")) {
//			return PageGeneratorManager.getCustomerServicePage(driver);
//		} else {
//			return PageGeneratorManager.getAdvancedSearchPage(driver);
//		}

//		switch (pageName) {
//			case "About Us" :
//				return PageGeneratorManager.getAboutUsPage(driver);
//			case "Search Terms" :
//				return PageGeneratorManager.getSearchTermPage(driver);
//			case "Customer Service" :
//				return PageGeneratorManager.getCustomerServicePage(driver);
//			default :
//				
//				return PageGeneratorManager.getAdvancedSearchPage(driver);
//				

//	}

//	public void openMenuPageByPageName(WebDriver driver, String pageName) {
//		waitElementVisible(driver, AbstractWordPressPageUIs.DYNAMIC_FOOTER_PAGE, pageName);
//		clickToElement(driver, AbstractWordPressPageUIs.DYNAMIC_FOOTER_PAGE, pageName);
//	}
	public void openMenuPageByPageName(WebDriver driver, String pageName) {
		waitElementVisible(driver,AbstractWordPressPageUIs.DYNAMIC_PAGE_BY_PAGE_NAME, pageName);
		clickToElement(driver, AbstractWordPressPageUIs.DYNAMIC_PAGE_BY_PAGE_NAME, pageName);
	}

	/* Bank Guru  Dynamic Page Component */
	
//	public void inputToDynamicTextbox(WebDriver driver, String nameAttributeValue, String inputValue) {
//		waitElementVisible(driver, AbstractBankPageUI.DYNAMIC_TEXTBOX, nameAttributeValue);
//		if(nameAttributeValue.equals("dob")) {
//			removeAttributeInDOM(driver, AbstractBankPageUI.DYNAMIC_TEXTBOX, "type", nameAttributeValue);
//		}
//		sendkeyToElement(driver, AbstractBankPageUI.DYNAMIC_TEXTBOX, inputValue, nameAttributeValue);
//		
//	}
//	public void inputToDynamicTextarea(WebDriver driver, String nameAttributeValue, String inputValue) {
//		waitElementVisible(driver, AbstractBankPageUI.DYNAMIC_TEXTAREA, nameAttributeValue);
//		sendkeyToElement(driver, AbstractBankPageUI.DYNAMIC_TEXTAREA, inputValue, nameAttributeValue);	
//	}
//	public void clickToDynamicRadioButton(WebDriver driver, String radioButtonValue) {
//		waitElementClickable(driver, AbstractBankPageUI.DYNAMIC_RADIO_BUTTON, radioButtonValue);
//		clickToElement(driver, AbstractBankPageUI.DYNAMIC_RADIO_BUTTON, radioButtonValue);
//	}
//	public void clickToDynamicButton(WebDriver driver, String buttonValue) {
//		waitElementClickable(driver, AbstractBankPageUI.DYNAMIC_BUTTON, buttonValue);
//		clickToElement(driver, AbstractBankPageUI.DYNAMIC_BUTTON, buttonValue);
//	}
//	public void clickToDynamicLink(WebDriver driver, String linkPageName) {
//		waitElementClickable(driver, AbstractBankPageUI.DYNAMIC_LINK, linkPageName);
//		clickToElement(driver, AbstractBankPageUI.DYNAMIC_LINK, linkPageName);
//	}
//	public boolean isDynamicMessageDisplayed(WebDriver driver, String messageText) {
//		waitElementVisible(driver,AbstractBankPageUI.DYNAMIC_MESSAGE,messageText);
//		return isElementDisplayed(driver,AbstractBankPageUI.DYNAMIC_MESSAGE,messageText);
//		
//	}
//	public String getDynamicValueColumnName(WebDriver driver, String columnName) {
//		waitElementVisible(driver,AbstractBankPageUI.DYNAMIC_BY_COMLUMN_NAME, columnName);
//		return getTextElement(driver, AbstractBankPageUI.DYNAMIC_BY_COMLUMN_NAME, columnName);
//	}
	public HomePageObject openEndUserPage(WebDriver driver) {
		openPageUrl(driver, GlobalConstants.USER_WORDPRESS_URL);
		return PageGeneratorManager.getHomeUserPage(driver);
	}
	public DashboardPageObject openAdminPage(WebDriver driver) {
		openPageUrl(driver, GlobalConstants.ADMIN_WORDPRESS_URL);
		return PageGeneratorManager.getDashboardAdminPage(driver);
		
	}
	public SearchResultPageObject inputToSearchTexboxAtEndUserPage(WebDriver driver, String titleValue) {
		waitElementClickable(driver,AbstractWordPressPageUIs.SEARCH_POST_ACTIVE_BUTTON_USER_PAGE );
		clickToElement(driver,AbstractWordPressPageUIs.SEARCH_POST_ACTIVE_BUTTON_USER_PAGE);
		waitElementVisible(driver,AbstractWordPressPageUIs.SEARCH_POST_BY_TITLE_USER_PAGE,titleValue );
		sendkeyToElement(driver,AbstractWordPressPageUIs.SEARCH_POST_BY_TITLE_USER_PAGE, titleValue);
		waitElementClickable(driver, AbstractWordPressPageUIs.SEARCH_POST_BUTTON_USER_PAGE);
		clickToElement(driver, AbstractWordPressPageUIs.SEARCH_POST_BUTTON_USER_PAGE);
		// TODO Auto-generated method stub
		return PageGeneratorManager.getSearchRultUserPage(driver);
	}
	public boolean isPostImageDisplayedAtPostTitleName(WebDriver driver,String titleValue,String imageValue) {
		String[] file= imageValue.split("\\.");
		waitElementVisible(driver, AbstractWordPressPageUIs.DYNAMIC_IMAGE_AVATAR_POST_AT_TITLE,titleValue,file[0].toLowerCase());
		return isElementDisplayed(driver, AbstractWordPressPageUIs.DYNAMIC_IMAGE_AVATAR_POST_AT_TITLE,titleValue,file[0].toLowerCase());
			//	&& isImageLoaded(driver,AbstractWordPressPageUIs.DYNAMIC_IMAGE_AVATAR_POST_AT_TITLE,titleValue,file[0].toLowerCase());
	}
	public boolean isPostDisplayedOnLatestPost(WebDriver driver,String titleValue,String categoryValue,String dateValue) {
		waitElementVisible(driver, AbstractWordPressPageUIs.LATEST_POST, titleValue,categoryValue,dateValue);
		return isElementDisplayed(driver, AbstractWordPressPageUIs.LATEST_POST,titleValue,categoryValue,dateValue);
	}

	private Actions action;
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
	private Select select;
	private Alert alert;
	private WebElement element;
	private List<WebElement> elements;
}
