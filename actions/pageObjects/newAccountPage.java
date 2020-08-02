package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.ObjectManagement;
import commons.driverUtils;
import pageUIs.newAccountPageUI;

public class newAccountPage extends Page{

	public newAccountPage(WebDriver driver) {
		super(driver);
	}

	public void InputCusTomerID(String text) {
		driverUtils.clear(driver, newAccountPageUI.CUSTOMER_ID_TEXTBOX);
		driverUtils.enterText(driver, newAccountPageUI.CUSTOMER_ID_TEXTBOX, text);
	}

	public void selectAccountType(String text) {
		driverUtils.selectComboboxByText(driver, newAccountPageUI.ACCOUNT_TYPE_COMBOBOX, text);
	}

	public void inputDeposit(String text) {
		driverUtils.clear(driver, newAccountPageUI.DEPOSIT_TEXTBOX);
		driverUtils.enterText(driver, newAccountPageUI.DEPOSIT_TEXTBOX, text);
	}

	public void clickOnSubmitButton() {
		driverUtils.Click(driver, newAccountPageUI.SUBMIT_BUTTON);
	}

	public boolean isAccountMessageDisplay(String expected) {
		String actual = driverUtils.getText(driver, newAccountPageUI.ACCOUNT_MESSSAGE);
		return actual.equals(expected);
	}

	public String getTextNewAccount(String value) {
		return driverUtils.getTextDyNamic(driver, newAccountPageUI.GET_ACCOUNT_TEXT, value);
	}

	public depositPage clickonDepositLink() {
		driverUtils.Click(driver, newAccountPageUI.DEPOSIT_LINK);
		return ObjectManagement.getNewDepositPage(driver);
	}

}
