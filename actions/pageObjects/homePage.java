package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.ObjectManagement;
import commons.driverUtils;
import pageUIs.homePageUI;

public class homePage extends Page {

	public homePage(WebDriver driver) {
		super(driver);
	}
	
	public newCustomerPage clickOnNewCustomerLink() {
		driverUtils.Click(driver, homePageUI.NEW_CUSTOMER_LINK);
		return ObjectManagement.getRegisterPage(driver);
	}
}
