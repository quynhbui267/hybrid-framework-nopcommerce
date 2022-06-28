package com.nopcommerce.user;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;
import pageObjects.user.PageGeneratorManager;

public class Level_06_Page_Generator_Manager extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;

	@Parameters("browser")
	// Nếu muốn dùng nhiều param thì khai báo dưới dạng mảng @Parameters({"browser",
	// "server"})
	@BeforeClass
	public void beforeClass(String browerName) {
		driver = getBrowserName(browerName);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC_01_Login_With_Empty_Data() {
		loginPage = homePage.clickToLoginLink();
		loginPage.clickToLoginBtn();
		Assert.assertEquals(loginPage.getEmailErrorMessage(), "Please enter your email");
	}

	@Test
	public void TC_02_Login_With_Invalid_Email() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailAddress("quynh123");
		loginPage.clickToLoginBtn();
		Assert.assertEquals(loginPage.getEmailErrorMessage(), "Wrong email");
	}

	@Test
	public void TC_03_Login_With_Not_Registerd_Email() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailAddress("quynh123@yopmail.com");
		loginPage.clickToLoginBtn();
		Assert.assertEquals(loginPage.getCredentialErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");
	}

	@Test
	public void TC_4_Login_With_Empty_Password() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailAddress("quynh12345678@yopmail.com");
		loginPage.clickToLoginBtn();
		Assert.assertEquals(loginPage.getCredentialErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");
	}

	@Test
	public void TC_5_Login_With_Wrong_Password() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailAddress("quynh12345678@yopmail.com");
		loginPage.inputToPassword("123");
		loginPage.clickToLoginBtn();
		Assert.assertEquals(loginPage.getCredentialErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");
	}

	@Test
	public void TC_6_Login_With_Valid_Credential() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailAddress("quynh12345678@yopmail.com");
		loginPage.inputToPassword("123456");
		homePage = loginPage.clickToLoginBtn();
		assertTrue(homePage.isMyAccountLinkDisplayed());
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
