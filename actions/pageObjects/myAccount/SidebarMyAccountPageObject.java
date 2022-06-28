package pageObjects.myAccount;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjects.user.PageGeneratorManager;
import pageUIs.SidebarMyAccountPageUI;

public class SidebarMyAccountPageObject extends BasePage {
	WebDriver driver;
	
	public SidebarMyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}
	// Switch common page
		public CustomerInfoPageObject openCustomerInfoLink() {
			waitForElementClickable(driver, SidebarMyAccountPageUI.CUSTOMER_INFO_LINK);
			clickToElement(driver, SidebarMyAccountPageUI.CUSTOMER_INFO_LINK);
			return PageGeneratorManager.getCustomerInfoPage(driver);

		}
		
		public CustomerAddressesPageObject openCustomerAddressesLink() {
			waitForElementClickable(driver, SidebarMyAccountPageUI.CUSTOMER_ADDRESSES);
			clickToElement(driver, SidebarMyAccountPageUI.CUSTOMER_ADDRESSES);
			return PageGeneratorManager.getCustomerAddressesPage(driver);

		}
}
