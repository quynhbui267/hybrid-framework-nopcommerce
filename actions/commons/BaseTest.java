package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	String projectPath = System.getProperty("user.dir");

	public WebDriver getBrowserName(String browserName) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		switch (browserList) {
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver();
			//Với WebDriverManager 5.x trở lên thì chỉ cần return WebDriverManager.firefoxdriver().create();
		case CHROME:
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();
		case EDGE:
			WebDriverManager.edgedriver().setup();
			return new EdgeDriver(); 
			//Sẽ tải về C:\Users\thuannk\.cache\selenium
		default:
			throw new RuntimeException("Browser name is not valid");
	}
	}
}
