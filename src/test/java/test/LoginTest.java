package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	WebDriver driver;
	
	ExcelReader exlread = new ExcelReader("testData/TF_TestData.xlsx");
	String userName = exlread.getCellData("LoginInfo", "UserName", 2);
	String password = exlread.getCellData("LoginInfo", "Password", 2);
	String expectedDashboardHeaderText = exlread.getCellData("DashboardInfo", "DashboardHeader", 2);
	String expectedUserAlertText = exlread.getCellData("LoginInfo", "alerUserValidationText", 2);
	String expectedPasswordAlertText = exlread.getCellData("LoginInfo", "alertPasswordValidationText", 2);
	
	@Test
	public void validUserShouldBeAbleToLogin() {
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSignInButton();
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		String actualDashboardHeaderText = dashboardPage.getDashboardValidationText();
		Assert.assertEquals(actualDashboardHeaderText, expectedDashboardHeaderText, "Dashboard page is not found!!");
		BrowserFactory.tearDown();
		
	}
	
	@Test
	public void validateAlertPopup() {
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.clickSignInButton();
		Assert.assertEquals(loginPage.getUserAlertMsg(), expectedUserAlertText, "User Alert msg doesn't match");
		loginPage.insertUserName(BrowserFactory.getUserName());
		loginPage.clickSignInButton();
		Assert.assertEquals(loginPage.getPasswordAlertMsg(), expectedPasswordAlertText, "User Alert msg doesn't match");
		BrowserFactory.tearDown();
	}
}