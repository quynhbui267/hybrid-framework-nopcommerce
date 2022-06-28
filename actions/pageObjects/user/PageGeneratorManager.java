package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjects.myAccount.CustomerAddressesPageObject;
import pageObjects.myAccount.CustomerInfoPageObject;
import pageObjects.myAccount.SidebarMyAccountPageObject;

public class PageGeneratorManager extends BasePage {


	// Su dung static method de truy nhap truc tiep o cac PageObject ko phai khoi tao object PageGeneratorManager)
	// SidebarMyAccountPageObject co ham constructor voi bien driver nen ham getMyAccountPage cung phai co bien parameter la driver
	public static SidebarMyAccountPageObject getMyAccountPage(WebDriver driver) {
		return new SidebarMyAccountPageObject(driver);
	}

	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static CustomerInfoPageObject getCustomerInfoPage(WebDriver driver) {
		return new CustomerInfoPageObject(driver);
	}

	public static CustomerAddressesPageObject getCustomerAddressesPage(WebDriver driver) {
		return new CustomerAddressesPageObject(driver);
	}
}
