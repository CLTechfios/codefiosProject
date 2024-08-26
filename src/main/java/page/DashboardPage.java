package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage {

	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@class='panel-title']") WebElement DASHBOARD_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//span[text()='Customers']") WebElement CUSTOMER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[@title='Add Customer']") WebElement ADD_CUSTOMER_ELEMENT;
	
	public String getDashboardValidationText() {
		String actualDashboardHeaderText = DASHBOARD_HEADER_ELEMENT.getText();
		return actualDashboardHeaderText;
	}

	public void clickOnCustomer() {
		CUSTOMER_ELEMENT.click();
		
	}

	public void clickOnAddCustomer() {
		ADD_CUSTOMER_ELEMENT.click();
		
	}
	
	
	
}
