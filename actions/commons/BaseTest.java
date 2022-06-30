package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
	String urlName;
	String projectPath = System.getProperty("user.dir");

	protected WebDriver getBrowserName(String browserName, String urlValue) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		switch (browserList) {
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		// Với WebDriverManager 5.x trở lên thì chỉ cần return
		// WebDriverManager.firefoxdriver().create();
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			break;
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			break;
		// Sẽ tải về C:\Users\thuannk\.cache\selenium
		default:
			throw new RuntimeException("Browser name is not valid");
		}
		driver.get(urlValue);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
}
