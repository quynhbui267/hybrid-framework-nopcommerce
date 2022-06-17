package pageObjects;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage{
	 WebDriver driver;
	
	
		public HomePageObject(WebDriver driver) {
			this.driver = driver;
		}
	
	public void clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
	}
}
