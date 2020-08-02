package pageUIs;

import org.openqa.selenium.By;

public class loginPageUI {
	public static final By USER_TEXTBOX = By.name("uid");
	public static final By PASSWORD_TEXTBOX = By.name("password");
	public static final By LOGIN_BUTTON = By.name("btnLogin");
	public static final By HERE_LINK = By.xpath("//a[text() = 'here']");
	public static final By EMAIL_TEXTBOX = By.name("emailid");
	public static final By SUBMIT_EMAIL_BUTTON = By.name("btnLogin");
	public static final By GET_USER_ID = By.xpath("//td[text() = 'User ID :']/following-sibling::td");
	public static final By GET_PASSWORD = By.xpath("//td[text() = 'Password :']/following-sibling::td");
}
