package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.depositPage;
import pageObjects.homePage;
import pageObjects.newAccountPage;
import pageObjects.newCustomerPage;

public class ObjectManagement {

	public static homePage getHomePage(WebDriver driver) {
		return new homePage(driver);
	}
	
	public static newCustomerPage getRegisterPage(WebDriver driver) {
		return new newCustomerPage(driver);
	}
	
	public static newAccountPage getNewAccountPage(WebDriver driver) {
		return new newAccountPage(driver);
	}
	
	public static depositPage getNewDepositPage(WebDriver driver) {
		return new depositPage(driver);
	}
}
