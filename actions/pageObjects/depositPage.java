package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.driverUtils;
import pageUIs.depositPageUI;

public class depositPage extends Page{

	public depositPage(WebDriver driver) {
		super(driver);
	}

	public void inputAccountId(String text) {
		driverUtils.clear(driver, depositPageUI.ACCOUNT_NO_TEXTBOX);
		driverUtils.enterText(driver, depositPageUI.ACCOUNT_NO_TEXTBOX, text);
	}

	public void inputAmount(String text) {
		driverUtils.clear(driver, depositPageUI.AMOUNT_TEXTBOX);
		driverUtils.enterText(driver, depositPageUI.AMOUNT_TEXTBOX, text);
	}

	public void inputDesciption(String text) {
		driverUtils.clear(driver, depositPageUI.DESCRIPTION_TEXTBOX);
		driverUtils.enterText(driver, depositPageUI.DESCRIPTION_TEXTBOX, text);
	}

	public void clickOnSubmitButton() {
		driverUtils.Click(driver, depositPageUI.SUBMIT_BUTTON);
	}

	public boolean isDepositMessageDisplay(String expected) {
		String actual = driverUtils.getText(driver, depositPageUI.DEPOSIT_MESSAGE);
		return actual.equals(expected);
	}

	public String getTextNewDeposit(String text) {
		return driverUtils.getTextDyNamic(driver, depositPageUI.GET_DEPOSIT_TEXT, text);
	}
}
