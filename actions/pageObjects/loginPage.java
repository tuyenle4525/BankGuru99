package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.ObjectManagement;
import commons.driverUtils;
import pageUIs.loginPageUI;

public class loginPage extends Page{

	public loginPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void inputUserID(){
		driverUtils.enterText(driver, loginPageUI.USER_TEXTBOX, "hello");
	}
	
	public void clickToHereLink() {
		driverUtils.Click(driver, loginPageUI.HERE_LINK);
	}
	
	public void inputEmail(){
		String number = driverUtils.getRandomNumber();
		driverUtils.enterText(driver, loginPageUI.EMAIL_TEXTBOX, "test" + number + "@gmail.com");
	}
	public void clickToSubMitEmailButton() {
		driverUtils.Click(driver, loginPageUI.SUBMIT_EMAIL_BUTTON);
	}
	
	public String getUserID() {
		return driverUtils.getText(driver, loginPageUI.GET_USER_ID);
	}

	public String getPassword() {
		return driverUtils.getText(driver, loginPageUI.GET_PASSWORD);
	}
	
	public String getLoginPageURL() {
		return driverUtils.getCurrentURL(driver);
	}
	
	public void openLoginPageURL(String url) {
		driverUtils.goToUrl(driver, url);
	}
	
	public void inputUserID(String value) {
		driverUtils.clear(driver, loginPageUI.USER_TEXTBOX);
		driverUtils.enterText(driver, loginPageUI.USER_TEXTBOX, value);
	}
	
	public void inputPassword(String value) {
		driverUtils.clear(driver, loginPageUI.PASSWORD_TEXTBOX);
		driverUtils.enterText(driver, loginPageUI.PASSWORD_TEXTBOX, value);
	}
	
	public homePage clickOnLoginButton() {
		driverUtils.Click(driver, loginPageUI.LOGIN_BUTTON);
		return ObjectManagement.getHomePage(driver);
	}

}
