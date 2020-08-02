package bankGuru99;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.initDriver;
import datas.Account;
import datas.Customer;
import datas.Deposit;
import pageObjects.depositPage;
import pageObjects.homePage;
import pageObjects.loginPage;
import pageObjects.newAccountPage;
import pageObjects.newCustomerPage;

public class bankGuru99Testcase extends initDriver {
	WebDriver driver;
	loginPage _loginPage;
	homePage _homePage;
	newCustomerPage _newCustomerPage;
	newAccountPage _newAccountPage;
	depositPage _depositPage;
	String loginPageURL;
	String username, password;
	String customerID, accountID;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		
		//Init driver
		driver = selectBrowser(browserName);
		_loginPage = new loginPage(driver);
		loginPageURL = _loginPage.getLoginPageURL();
		
		_loginPage.clickToHereLink();
		_loginPage.inputEmail();
		_loginPage.clickToSubMitEmailButton();
		
		//Get username and password
		username = _loginPage.getUserID();
		password = _loginPage.getPassword();
		
		//Navigate to login page url
		_loginPage.openLoginPageURL(loginPageURL);
		
		//Input username and password
		_loginPage.inputUserID(username);
		_loginPage.inputPassword(password);
		_homePage = _loginPage.clickOnLoginButton();
		_newCustomerPage = _homePage.clickOnNewCustomerLink();
	}
	
	@Test(priority = 1)
	public void TC_01_CreateNewCustomer(){
		
		//input data
		_newCustomerPage.inputCustomerName(Customer.newCustomer.CUSTOMER_NAME);
		_newCustomerPage.clickOnGender(Customer.newCustomer.GENDER);
		_newCustomerPage.selectDateOfBirth(Customer.newCustomer.DATE_OF_BIRTH);
		_newCustomerPage.inputAddress(Customer.newCustomer.ADDRESS);
		_newCustomerPage.inputCity(Customer.newCustomer.CITY);
		_newCustomerPage.inputState(Customer.newCustomer.STATE);
		_newCustomerPage.inputPin(Customer.newCustomer.PIN);
		_newCustomerPage.inputPhoneNumber(Customer.newCustomer.PHONE);
		_newCustomerPage.inputEmail(Customer.newCustomer.EMAIL);
		_newCustomerPage.inputPassword(Customer.newCustomer.PASSWORD);
		_newCustomerPage.clickOnSubmitButton();
		
		//verify new customer can be created
		Assert.assertTrue(_newCustomerPage.isCustomerMessageDisplay("Customer Registered Successfully!!!"));
		Assert.assertEquals(Customer.newCustomer.CUSTOMER_NAME, _newCustomerPage.getTextNewCustomer("Customer Name"));
		Assert.assertEquals(Customer.newCustomer.GENDER, _newCustomerPage.getTextNewCustomer("Gender"));
		Assert.assertEquals(Customer.newCustomer.DATE_OF_BIRTH, _newCustomerPage.getTextNewCustomer("Birthdate"));
		Assert.assertEquals(Customer.newCustomer.ADDRESS, _newCustomerPage.getTextNewCustomer("Address"));
		Assert.assertEquals(Customer.newCustomer.CITY, _newCustomerPage.getTextNewCustomer("City"));
		Assert.assertEquals(Customer.newCustomer.STATE, _newCustomerPage.getTextNewCustomer("State"));
		Assert.assertEquals(Customer.newCustomer.PIN, _newCustomerPage.getTextNewCustomer("Pin"));
		Assert.assertEquals(Customer.newCustomer.PHONE, _newCustomerPage.getTextNewCustomer("Mobile No."));
	
		//Get customer ID
		customerID = _newCustomerPage.getTextNewCustomer("Customer ID");
	}
	
	@Test(priority = 2)
	public void TC_02_CreateNewAccount(){
		_newAccountPage = _newCustomerPage.clickOnNewAccountLink();
		_newAccountPage.InputCusTomerID(customerID);
		_newAccountPage.selectAccountType(Account.newAccount.ACCOUNT_TYPE);
		_newAccountPage.inputDeposit(Account.newAccount.DEPOSTIT);
		_newAccountPage.clickOnSubmitButton();
		
		//verify to create new  account based on customer just created above
		Assert.assertTrue(_newAccountPage.isAccountMessageDisplay("Account Generated Successfully!!!"));
		Assert.assertEquals(Account.newAccount.ACCOUNT_TYPE, _newAccountPage.getTextNewAccount("Account Type"));
		Assert.assertEquals(Account.newAccount.DEPOSTIT, _newAccountPage.getTextNewAccount("Current Amount"));
		
		//Get account ID
		accountID = _newAccountPage.getTextNewAccount("Account ID");
	}
	
	@Test(priority = 3)
	public void TC_03_CreateDeposit() {
		_depositPage = _newAccountPage.clickonDepositLink();
		_depositPage.inputAccountId(accountID);
		_depositPage.inputAmount(Deposit.AMOUNT);
		_depositPage.inputDesciption(Deposit.DESCRIPTION);
		_depositPage.clickOnSubmitButton();
		
		//verify deposit
		Assert.assertTrue(_depositPage.isDepositMessageDisplay("Transaction details of Deposit for Account " + accountID));
		Assert.assertEquals(Deposit.AMOUNT, _depositPage.getTextNewDeposit("Amount Credited"));
		Assert.assertEquals(Deposit.DESCRIPTION, _depositPage.getTextNewDeposit("Description"));
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
}