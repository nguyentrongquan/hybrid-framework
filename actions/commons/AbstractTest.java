package commons;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class AbstractTest {
	protected final Log log;
	protected AbstractTest() {
		log = LogFactory.getLog(getClass());
	}
	protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
	protected WebDriver getBrowserDriver(String browserName) {
		Browser browser = Browser.valueOf(browserName.toUpperCase());
		if(browser == Browser.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			setDriver(new FirefoxDriver());
		}else if(browser == Browser.CHROME) {
			WebDriverManager.chromedriver().setup();
			setDriver(new ChromeDriver());
		}else if(browser == Browser.EDGE) {
			WebDriverManager.edgedriver().setup();
			setDriver(new EdgeDriver());
		} else if(browser == Browser.IE) {
			WebDriverManager.iedriver().arch32().setup();
			setDriver(new InternetExplorerDriver());
		}else if(browser == Browser.COCCOC) {
			WebDriverManager.chromedriver().driverVersion("81.0.4044.138").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Users\\Admin\\AppData\\Local\\CocCoc\\Browser\\Application\\browser.exe");
			setDriver(new ChromeDriver(options));
		} else {
			throw new RuntimeException("please input your browser name");
		}
		getDriver().get("http://live.demoguru99.com/");
		getDriver().manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		Browser browser = Browser.valueOf(browserName.toUpperCase());
		if(browser == Browser.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			setDriver(new FirefoxDriver());
		}else if(browser == Browser.CHROME) {
			WebDriverManager.chromedriver().setup();
			setDriver(new ChromeDriver());
		}else if(browser == Browser.EDGE) {
			WebDriverManager.edgedriver().setup();
			setDriver(new EdgeDriver());
		} else if(browser == Browser.IE) {
			WebDriverManager.iedriver().arch32().setup();
			setDriver(new InternetExplorerDriver());
		}else if(browser == Browser.COCCOC) {
			WebDriverManager.chromedriver().driverVersion("83.0.4103.39").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Users\\Admin\\AppData\\Local\\CocCoc\\Browser\\Application\\browser.exe");
			setDriver(new ChromeDriver(options));
		} else {
			throw new RuntimeException("please input your browser name");
		}
		getDriver().get(appUrl);
		getDriver().manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		getDriver().manage().window().maximize();
		return getDriver();
	}
	private void setDriver(WebDriver driver) {
		threadLocalDriver.set(driver);
	}
	
	private WebDriver getDriver() {
		return threadLocalDriver.get();
	}
	protected void removeDriver() {
		getDriver().quit();
		threadLocalDriver.remove();
	}
	public static Date getDateTimeNow() {
		Date date = new Date();
		return date;
	}
	
	public int randomEmail() {
		Random rand= new Random();
		return rand.nextInt(999);
	}
	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	protected String getCurrentDay() {
		DateTime nowUTC = new DateTime();
		int day = nowUTC.getDayOfMonth();
		if (day < 10) {
			String dayValue = "0" + day;
			return dayValue;
		}
		return String.valueOf(day);
	}

	protected String getCurrentMonth() {
		DateTime now = new DateTime();
		int month = now.getMonthOfYear();
		if (month < 10) {
			String monthValue = "0" + month;
			return monthValue;
		}
		return  String.valueOf(month);
	}

	protected String getCurrentYear() {
		DateTime now = new DateTime();
		return now.getYear() + "";
	}

	protected String getToday() {
		return getCurrentDay()+"/"+ getCurrentMonth() + "/" + getCurrentYear();
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}
	protected void closeBrowserAndDriver(WebDriver driver) {
		try {
			String osName = System.getProperty("os.name").toLowerCase();

			String cmd = "";
			if (driver != null) {
				driver.quit();
			}

			if (driver.toString().toLowerCase().contains("chrome")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill chromedriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				}
			} else if (driver.toString().toLowerCase().contains("internetexplorer")) {
				if (osName.toLowerCase().contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				}
			} else if (driver.toString().toLowerCase().contains("firefox")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill geckodriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				}
			}

			Process process = Runtime.getRuntime().exec(cmd);
			process.waitFor();

		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}
}
