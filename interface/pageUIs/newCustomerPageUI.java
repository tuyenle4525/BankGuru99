package pageUIs;

import org.openqa.selenium.By;

public class newCustomerPageUI {
	public static final By CUSTOMER_NAME_TEXTBOX = By.name("name");
	public static final By MALE_CHECKBOX = By.cssSelector("input[value = m]");
	public static final By FEMALE_CHECKBOX = By.name("input[value = f]");
	public static final By DATE_OF_BIRTH = By.name("dob");
	public static final By ADDRESS_TEXTBOX = By.name("addr");
	public static final By CITY_TEXTBOX = By.name("city");
	public static final By STATE_TEXTBOX = By.name("state");
	public static final By PIN_TEXTBOX = By.name("pinno");
	public static final By PHONE_TEXTBOX = By.name("telephoneno");
	public static final By EMAIL_TEXTBOX = By.name("emailid");
	public static final By PASSWORD_TEXTBOX = By.name("password");
	public static final By SUBMIT_BUTTON = By.name("sub");
	public static final By NEW_CUSTOMER_MESSAGE = By.xpath("//p[text() = 'Customer Registered Successfully!!!']");
	public static final By NEW_ACCOUNT_LINK = By.linkText("New Account");
	public static final String GET_CUSTOMER_TEXT = "//td[text() = '%s']/following-sibling::td";
}
