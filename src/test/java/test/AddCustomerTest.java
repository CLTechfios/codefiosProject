package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.CustomerListPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {
WebDriver driver;
	
	ExcelReader exlread = new ExcelReader("testData/TF_TestDataCL.xlsx");
	String userName = exlread.getCellData("LoginInfo", "UserName", 2);
	String password = exlread.getCellData("LoginInfo", "Password", 2);
	String expectedDashboardHeaderText = exlread.getCellData("DashboardInfo", "DashboardHeader", 2);
	String expectedAddCustomerHeaderText = exlread.getCellData("AddContactInfo", "AddContactValidationText", 2);
	String fullName = exlread.getCellData("AddContactInfo", "FullName", 2);
	String email = exlread.getCellData("AddContactInfo", "Email", 2);
	String company = exlread.getCellData("AddContactInfo", "CompanyName", 2); 
	String phone = exlread.getCellData("AddContactInfo", "Phone", 2);
	
	String address = exlread.getCellData("AddContactInfo", "Address", 2);
	String city = exlread.getCellData("AddContactInfo", "City", 2);
	String state = exlread.getCellData("AddContactInfo", "State", 2);
	String zip = exlread.getCellData("AddContactInfo", "Zip", 2);
	String country = exlread.getCellData("AddContactInfo", "Country", 2);
	
	@Test
	public void userShouldBeAbleToCreateNewCustomer() {
		
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSignInButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		Assert.assertEquals(dashboardPage.getDashboardValidationText(), expectedDashboardHeaderText, "Dashboard page is not found!!");
		dashboardPage.clickOnCustomer();
		dashboardPage.clickOnAddCustomer();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		Assert.assertEquals(addCustomerPage.getAddCustomerValidationText(), expectedAddCustomerHeaderText, "Add Customer page is not found!!");
		
		String name = addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompany(company);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhone(phone);
		addCustomerPage.insertZip(zip);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.selectCountry(country);
		addCustomerPage.clickSaveButton();
		CustomerListPage customerListPage = PageFactory.initElements(driver, CustomerListPage.class);
		customerListPage.validateInsertedNameAndDelete(name);
		BrowserFactory.tearDown();

	}
	

}