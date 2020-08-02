package pageUIs;

import org.openqa.selenium.By;

public class newAccountPageUI {
	public static final By CUSTOMER_ID_TEXTBOX = By.name("cusid");
	public static final By ACCOUNT_TYPE_COMBOBOX = By.name("selaccount");
	public static final By DEPOSIT_TEXTBOX = By.name("inideposit");
	public static final By SUBMIT_BUTTON = By.name("button2");
	public static final By ACCOUNT_MESSSAGE = By.xpath("//p[text() = 'Account Generated Successfully!!!']");
	public static final By DEPOSIT_LINK = By.linkText("Deposit");
	public static final String GET_ACCOUNT_TEXT = "//td[text() = '%s']/following-sibling::td";
}
