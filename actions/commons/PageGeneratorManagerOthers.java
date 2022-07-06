package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.facebook.FacebookHomePageObject;
import pageObjects.jquery.JQueryHomePageObject;

public class PageGeneratorManagerOthers extends BasePage {

	public static JQueryHomePageObject getJqueryHomePage(WebDriver driver) {
		return new JQueryHomePageObject(driver);

	}
	
	public static FacebookHomePageObject getFacebookHomePage (WebDriver driver) {
		return new FacebookHomePageObject(driver);

	}

}
