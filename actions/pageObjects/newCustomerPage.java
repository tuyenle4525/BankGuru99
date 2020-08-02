package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.ObjectManagement;
import commons.driverUtils;
import pageUIs.newCustomerPageUI;

public class newCustomerPage extends Page{

	public newCustomerPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void inputCustomerName(String value) {
		driverUtils.clear(driver, newCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		driverUtils.enterText(driver, newCustomerPageUI.CUSTOMER_NAME_TEXTBOX, value);
	}
	
	public void clickOnGender(String gender) {
		if (gender.toLowerCase().equals("male")){
			driverUtils.Click(driver, newCustomerPageUI.MALE_CHECKBOX);
		}else {
			driverUtils.Click(driver, newCustomerPageUI.FEMALE_CHECKBOX);
		}
	}
	
	public void selectDateOfBirth(String dateOfBirth) {
		driverUtils.removeAttribute(driver, newCustomerPageUI.DATE_OF_BIRTH, "type");
		driverUtils.enterText(driver, newCustomerPageUI.DATE_OF_BIRTH, dateOfBirth);
	}
	
	public void inputAddress(String value) {
		driverUtils.clear(driver, newCustomerPageUI.ADDRESS_TEXTBOX);
		driverUtils.enterText(driver, newCustomerPageUI.ADDRESS_TEXTBOX, value);
	}
	
	public void inputCity(String value) {
		driverUtils.clear(driver, newCustomerPageUI.CITY_TEXTBOX);
		driverUtils.enterText(driver, newCustomerPageUI.CITY_TEXTBOX, value);
	}
	
	public void inputState(String value) {
		driverUtils.clear(driver, newCustomerPageUI.STATE_TEXTBOX);
		driverUtils.enterText(driver, newCustomerPageUI.STATE_TEXTBOX, value);
	}
	
	public void inputPin(String value) {
		driverUtils.clear(driver, newCustomerPageUI.PIN_TEXTBOX);
		driverUtils.enterText(driver, newCustomerPageUI.PIN_TEXTBOX, value);
	}
	
	public void inputPhoneNumber(String value) {
		driverUtils.clear(driver, newCustomerPageUI.PHONE_TEXTBOX);
		driverUtils.enterText(driver, newCustomerPageUI.PHONE_TEXTBOX, value);
	}
	
	public void inputEmail(String value) {
		String email = value + driverUtils.getRandomNumber() + "@gmail.com";
		driverUtils.clear(driver, newCustomerPageUI.EMAIL_TEXTBOX);
		driverUtils.enterText(driver, newCustomerPageUI.EMAIL_TEXTBOX, email);
	}
	
	public void inputPassword(String value) {
		driverUtils.clear(driver, newCustomerPageUI.PASSWORD_TEXTBOX);
		driverUtils.enterText(driver, newCustomerPageUI.PASSWORD_TEXTBOX, value);
	}
	
	public void clickOnSubmitButton() {
		driverUtils.Click(driver, newCustomerPageUI.SUBMIT_BUTTON);
	}
	
	public boolean isCustomerMessageDisplay(String expected) {
		String actual = driverUtils.getText(driver, newCustomerPageUI.NEW_CUSTOMER_MESSAGE);
		return actual.equals(expected);
	}
	
	public String getTextNewCustomer(String value) {
		return driverUtils.getTextDyNamic(driver, newCustomerPageUI.GET_CUSTOMER_TEXT, value);
	}

	public newAccountPage clickOnNewAccountLink() {
		driverUtils.ScrollBy(driver);
		driverUtils.Click(driver, newCustomerPageUI.NEW_ACCOUNT_LINK);
		return ObjectManagement.getNewAccountPage(driver);
	}
}
