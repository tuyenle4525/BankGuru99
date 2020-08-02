package pageUIs;

import org.openqa.selenium.By;

public class depositPageUI {
	public static final By ACCOUNT_NO_TEXTBOX = By.name("accountno");
	public static final By AMOUNT_TEXTBOX = By.name("ammount");
	public static final By DESCRIPTION_TEXTBOX = By.name("desc");
	public static final By SUBMIT_BUTTON = By.name("AccSubmit");
	public static final By DEPOSIT_MESSAGE = By.xpath("//p[@class = 'heading3' and contains(text(), 'Transaction details of Deposit for Account')]");
	public static final String GET_DEPOSIT_TEXT = "//td[text() = '%s']/following-sibling::td";
}
