package commons;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
	protected final Log log;

	public BaseTest() {
		log = LogFactory.getLog(getClass());
	}
	@BeforeSuite
	public void initBeforeSuite() {
		deleteAllureReportFilesinFolder();
	}
	//Su dung khi phai switch page (Vi du he thong co 2 trang Admin/user)
	protected WebDriver getBrowserName(String browserName, String urlValue) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		switch (browserList) {
		case FIREFOX:
			driver = WebDriverManager.firefoxdriver().create();
			break;
		// Với WebDriverManager 5.x trở lên thì chỉ cần return
		// WebDriverManager.firefoxdriver().create();
		case CHROME:
			driver = WebDriverManager.chromedriver().create();
			break;
		case EDGE:
			driver = WebDriverManager.edgedriver().create();
			break;
		// Sẽ tải về C:\Users\thuannk\.cache\selenium
		default:
			throw new RuntimeException("Browser name is not valid");
		}
		driver.get(urlValue);
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		return driver;
	}
	//Su dung khi ko phai switch page - chi co 1 URL
	protected WebDriver getBrowserName(String browserName) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		switch (browserList) {
		case FIREFOX:
			driver = WebDriverManager.firefoxdriver().create();
			break;
		// Với WebDriverManager 5.x trở lên thì chỉ cần return
		// WebDriverManager.firefoxdriver().create();
		case CHROME:
			driver = WebDriverManager.chromedriver().create();
			break;
		case EDGE:
			driver = WebDriverManager.edgedriver().create();
			break;
		// Sẽ tải về C:\Users\thuannk\.cache\selenium
		default:
			throw new RuntimeException("Browser name is not valid");
		}
		driver.get(GlobalConstants.DEV_USER_URL);
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		return driver;
	}

	public WebDriver getDriverInstance() {
		return this.driver;
	}

	// Custom Hart Assert
	public boolean verifyEquals(String actual, String expected) {
		boolean status = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info("-----------PASSED----------");
			// Throwable thì chạy xong hết mới dừng, còn Exception thì sẽ dừng luôn
		} catch (Throwable e) {
			log.info("-----------FAILED----------");
			status = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return status;
	}

	public boolean verifyTrue(boolean condition) {
		boolean status = true;
		try {
			Assert.assertTrue(condition);
			log.info("-----------PASSED----------");
		} catch (Throwable e) {
			log.info("-----------FAILED----------");
			status = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return status;
	}

	public boolean verifyFalse(boolean condition) {
		boolean status = true;
		try {
			Assert.assertFalse(condition);
			log.info("-----------PASSED----------");
		} catch (Throwable e) {
			status = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return status;
	}
	
	public void deleteAllureReportFilesinFolder() {
		try {
			String pathFolderDownload = GlobalConstants.ALLURE_REPORTING_PATH;
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	public static int getRandomNumber(int maxValue) {
		Random rd = new Random();
		return rd.nextInt(maxValue);
	}
	
	protected void closeBrowserAndDriver() {
		String cmd = "";
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			if (driverInstanceName.contains("chrome")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				} else {
					cmd = "pkill chromedriver";
				}
			} else if (driverInstanceName.contains("internetexplorer")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				}
			} else if (driverInstanceName.contains("firefox")) {
				if (osName.contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				} else {
					cmd = "pkill geckodriver";
				}
			} else if (driverInstanceName.contains("edge")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
				} else {
					cmd = "pkill msedgedriver";
				}
			} else if (driverInstanceName.contains("opera")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq operadriver*\"";
				} else {
					cmd = "pkill operadriver";
				}
			} else if (driverInstanceName.contains("safari")) {
				if (osName.contains("mac")) {
					cmd = "pkill safaridriver";
				}
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
