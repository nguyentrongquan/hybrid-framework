package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPages {
	
	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	public void setImplicitWait(WebDriver driver,long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout,TimeUnit.SECONDS);
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
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	public void acceptAlert(WebDriver driver) {
		waitAlertPresence(driver);
		alert=driver.switchTo().alert();
		alert.accept();
	}
	public void cancelAlert(WebDriver driver) {
		waitAlertPresence(driver);
		alert= driver.switchTo().alert();
		alert.dismiss();
	}
	public String getAlertText(WebDriver driver) {
		waitAlertPresence(driver);
		alert=driver.switchTo().alert();
		return alert.getText();
	}
	public void sendkeyToAlert(WebDriver driver, String text) {
		waitAlertPresence(driver);
		alert= driver.switchTo().alert();
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
	public void sendkeyToElement(WebDriver driver, String xpathValue, String text) {
		
		element=find(driver, xpathValue);
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
		select= new Select(find(driver, xpathValue));
		return select.isMultiple();
	}


	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
			// 1 - Click vÃ o tháº» (cha) Ä‘á»ƒ xá»• ra táº¥t cáº£ cÃ¡c item con
			find(driver, parentLocator).click();
			sleepInSecond(1);

			// 2 - Chá»� cho táº¥t cáº£ cÃ¡c item con Ä‘Æ°á»£c load ra
			explicitWait = new WebDriverWait(driver, longTimeout);
			explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byXpath(childItemLocator)));

			// Ä�Æ°a táº¥t cáº£ cÃ¡c item trong dropdown vÃ o 1 list Ä‘á»ƒ kiá»ƒm tra
			List<WebElement> allItems = finds(driver, childItemLocator);

			// 3 - Cháº¡y qua táº¥t cáº£ cÃ¡c giÃ¡ trá»‹ Ä‘ang cÃ³ trong list
			for (WebElement item : allItems) {
				// 4 - Kiá»ƒm tra xem text cá»§a cÃ¡c giÃ¡ trá»‹ cÃ³ item nÃ o báº±ng vs text mong muá»‘n ko
				if (item.getText().equals(expectedItem)) {
					// 5 - Scroll xuá»‘ng Ä‘áº¿n Ä‘Ãºng item nÃ y
					jsExecutor = (JavascriptExecutor) driver;
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
					sleepInSecond(1);

					// 6 - Click vÃ o cÃ¡i item nÃ y
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
	public int countElementNumber(WebDriver driver, String xpathValue) {
		return finds(driver, xpathValue).size();
		
	}
	public void checkTheCheckbox(WebDriver driver, String xpathValue) {
		element = find(driver, xpathValue);
		if(!element.isSelected()) {
			element.click();
		}
		
		
	}
	public void uncheckToTheCheckbox(WebDriver driver, String xpathValue) {
		element = find(driver, xpathValue);
		if(element.isSelected()) {
			element.click();
		}

		
	}
	public boolean isControlDisplayed(WebDriver driver, String xpathValue) {
		return find(driver, xpathValue).isDisplayed();
		
	}
	public boolean isControlSelected(WebDriver driver, String xpathValue) {
		return find(driver, xpathValue).isSelected();
		
	}
	public boolean isControlEnabled(WebDriver driver, String xpathValue) {
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
		action= new Actions(driver);
		action.sendKeys(find(driver, xpathValue),key).perform();
		
	}
	public Object executeForBrowser(String javaSript) {
		return jsExecutor.executeScript(javaSript);
	}

	public boolean verifyTextInInnerText(String textExpected) {
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		System.out.println("Text actual = " + textActual);
		return textActual.equals(textExpected);
	}



	// Element
	public void highlightElement(WebDriver driver,String xpathValue) {
		element = find(driver, xpathValue);
		String originalStyle = element.getAttribute("style");
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 5px solid red; border-style: dashed;");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);

	}

	public void clickToElementByJS(WebDriver driver,String xpathValue) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", find(driver, xpathValue));
	}

	public void scrollToElement(WebDriver driver,String xpathValue) {
	
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);",find(driver, xpathValue));
	}

	public void sendkeyToElementByJS(WebDriver driver,String xpathValue, String value) {
		
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", find(driver, xpathValue));
	}

	public void removeAttributeInDOM(WebDriver driver,String xpathValue, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", find(driver, xpathValue));
	}
	public boolean isImageLoaded(WebDriver driver,String xpathValue) {
		jsExecutor = (JavascriptExecutor) driver;
		boolean status= (boolean) jsExecutor.executeScript("return  arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", find(driver, xpathValue));
		if(status) {
			return true;
		}else {
			return false;
		}
		
	}
	public void waitElementVisible(WebDriver driver,String xpathValue) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(xpathValue)));
	}
	public void waitElementClickable(WebDriver driver,String xpathValue) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(xpathValue)));
	}
	public void waitElementInvisible(WebDriver driver,String xpathValue) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(byXpath(xpathValue)));
	}
	public void sleepInSecond(long timeout) {
			try {
				Thread.sleep(timeout * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
 	private Actions action;
	private long longTimeout=30;
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
	private Select select;
	private Alert alert;
	private WebElement element;
	
}
