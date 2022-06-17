package pageUIs;

public class RegisterPageUI {
	public final static String REGISTER_BTN = "//button[@id()='register-button']";
	public final static String REGISTER_SUCCESS_MSG = "//div[@class='result']";
	public final static String EXISTING_EMAIL_ERROR_MSG = "//div[contains(@class,'message-error')]//li";
	
	
	public final static String FIRSTNAME_ERROR_MSG = "//span[@id()='FirstName-error']";
	public final static String LASTNAME_ERROR_MSG = "//span[@id()='LastName-error']";
	public final static String EMAIL_ERROR_MSG = "//span[@id()='Email-error']";
	public final static String PASSWORD_ERROR_MSG = "//span[@id()='Password-error']";
	public final static String CPASSWORD_ERROR_MSG = "//span[@id()='ConfirmPassword-errorr']";
		
	public final static String FIRSTNAME_TXTBOX = "//input[@id()='FirstName']";
	public final static String LASTNAME_TXTBOX = "//input[@id()='LastName']";
	public final static String EMAIL_TXTBOX = "//input[@id()='Email']";
	public final static String PASSWORD_TXTBOX = "//input[@id()='Password']";
	public final static String CPASSWORD_TXTBOX = "//input[@id()='ConfirmPassword']";
	
}
