package com.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.myAccount.CustomerAddressesPageObject;
import pageObjects.myAccount.CustomerInfoPageObject;
import pageObjects.myAccount.SidebarMyAccountPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;
import pageObjects.user.PageGeneratorManager;

public class Level_07_SwitchPage extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;
	SidebarMyAccountPageObject myAccountPage;
	CustomerInfoPageObject customerInfoPage;
	CustomerAddressesPageObject customerAddressPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browerName) {
		driver = getBrowserName(browerName);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC_1_SwitchPage() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailAddress("quynh12345678@yopmail.com");
		loginPage.inputToPassword("123456");
		homePage = loginPage.clickToLoginBtn();
		myAccountPage = homePage.clickMyAccountLink();
		customerInfoPage= myAccountPage.openCustomerInfoLink();
		customerAddressPage= myAccountPage.openCustomerAddressesLink();
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
