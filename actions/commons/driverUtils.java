package commons;

import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class driverUtils {
	final static Log log = LogFactory.getLog(driverUtils.class.getClass());

	
	public static void goToUrl(WebDriver driver, String url) {
		driver.get(url);
	}
	
	public static String getCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public static void clear(WebDriver driver, By locator) {
		WebElement element = null;
		try {
			waitForElementToBeVisible(driver, locator);
			element = driver.findElement(locator);
			element.clear();
		}catch (Exception e) {
			String message = String.format("An error happens when trying to send text to element. Element information: %s", locator);
			log.fatal(message, e);
		}
	}
	
	public static void enterText(WebDriver driver, By locator, String text){
		WebElement element = null;
		try {
			waitForElementToBeVisible(driver, locator);
			element = driver.findElement(locator);
			element.sendKeys(text);
		}catch (Exception e) {
			String message = String.format("An error happens when trying to send text to element. Element information: %s", locator);
			log.fatal(message, e);
		}
	}
	
	public static void Click(WebDriver driver, By locator) {
		WebElement element = null;
		try {
			waitForElementToBeClickable(driver, locator);
			element = driver.findElement(locator);
			element.click();
		}catch (Exception e) {
			String message = String.format("An error happens when trying to click to element. Element information: %s", locator);
			log.fatal(message, e);
		}
	}
	
	public static String getText(WebDriver driver, By locator){
		WebElement element = null;
		try {
			waitForElementToBeVisible(driver, locator);
			element = driver.findElement(locator);
			return element.getText();
		}catch (Exception e) {
			String message = String.format("An error happens when trying to get element text. Element information: %s", locator);
			log.fatal(message, e);
			return null;
		}
	}
	
	public static String getTextDyNamic(WebDriver driver, String locator, String value){
		WebElement element = null;
		try {
			locator = String.format(locator, value);
			By by = By.xpath(locator);
			waitForElementToBeClickable(driver, by);
			element = driver.findElement(by);
			return element.getText();
		}catch (Exception e) {
			String message = String.format("An error happens when trying to get element text. Element information: %s", locator);
			log.fatal(message, e);
			return null;
		}
	}
	
	public static void waitForElementToBeVisible(WebDriver driver, By locator){
		try {
			WebDriverWait wait = new WebDriverWait(driver, getTimeOut());
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}catch (Exception e) {
			String message = String.format("element can not visible as expected: %s", locator);
			log.fatal(message, e);
		}
	}
	
	public static void waitForElementToBeClickable(WebDriver driver, By locator){
		try {
			WebDriverWait wait = new WebDriverWait(driver, getTimeOut());
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		}catch (Exception e) {
			String message = String.format("element can not clickable as expected: %s", locator);
			log.fatal(message, e);
		}
	}
	
	public static Object removeAttribute(WebDriver driver, By locator, String attribute){
		WebElement element = null;
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			waitForElementToBeVisible(driver, locator);
			element = driver.findElement(locator);
			return js.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
		}catch (Exception e) {
			String message = String.format("An error happens when trying to remove element attribute. Element information: %s", locator);
			log.fatal(message, e);
			return null;
		}
	}
	
	public static void selectComboboxByText(WebDriver driver, By locator, String text) {
		WebElement element = null;
		try {
			waitForElementToBeClickable(driver, locator);
			element = driver.findElement(locator);
			Select select = new Select(element);
			select.selectByVisibleText(text);
		}catch (Exception e) {
			String message = String.format("An error happens when trying to select element. Element information: %s", locator);
			log.fatal(message, e);
		}
	}
	
	public static void ScrollBy(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,750)");
	}
	
	public static int getTimeOut() {
		return constants.TIMEOUT;
	}
	
	public static String getRandomNumber() {
		return String.valueOf(new Date().getTime()).substring(5);
	}

}
