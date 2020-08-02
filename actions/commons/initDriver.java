package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class initDriver {
	WebDriver driver;

	public WebDriver selectBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("chromeheadless")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size =1366x768");
			driver = new ChromeDriver(options);
		} else {
			System.out.println("please choose a browser to run !");
		}
		driver.get(constants.URL);
		driver.manage().window().maximize();
		return driver;
	}
}
