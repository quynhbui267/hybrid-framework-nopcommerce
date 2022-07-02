package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.jquery.JQueryHomePageObject;

public class PageGeneratorManagerJquery extends BasePage {

	public static JQueryHomePageObject getJqueryHomePage(WebDriver driver) {
		return new JQueryHomePageObject(driver);

	}

}
