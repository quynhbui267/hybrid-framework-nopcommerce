package pageObjects.user;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.HomePageUI;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
	 WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void inputToEmailAddress(String emailAddress) {
		sendKeyToElement(driver, LoginPageUI.EMAIL_TXTBOX, emailAddress);
		
	}

	public void inputToPassword(String password) {
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TXTBOX, password);
		
	}

	public HomePageObject clickToLoginBtn() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BTN);
		clickToElement(driver, LoginPageUI.LOGIN_BTN);
		return new HomePageObject(driver);
	}
		

	public String getEmailErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MSG);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MSG);
		 
		
	}
	public String getCredentialErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.CREDENTIAL_ERROR_MSG);
		return getElementText(driver, LoginPageUI.CREDENTIAL_ERROR_MSG);
	}
	

}
