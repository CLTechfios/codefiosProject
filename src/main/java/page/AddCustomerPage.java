package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCustomerPage extends BasePage {

	WebDriver driver;
	String name;
	
	@FindBy(how = How.XPATH, using = "//strong[text()='New Customer']") WebElement ADD_CUSTOMER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@name='name']") WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@name='company_name']") WebElement COMPANY_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@name='email']") WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@name='phone']") WebElement PHONE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@name='port']") WebElement ZIP_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@name='address']") WebElement ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@name='city']") WebElement CITY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@name='country']") WebElement COUNTRY_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[@id='save_btn']") WebElement SAVE_BUTTON_ELEMENT;
	
	public AddCustomerPage (WebDriver driver) {
		this.driver = driver;
		
	}
	
	public String getAddCustomerValidationText() {
		String actualAddCustomerHeaderText = ADD_CUSTOMER_ELEMENT.getText();
		return actualAddCustomerHeaderText;
	}

	
	
	public String insertFullName(String fullName) {
		String insertedName = fullName + generateRandomNum(999);
		name = insertedName;
		FULL_NAME_ELEMENT.sendKeys(insertedName);
		return name;
	}
	
	public void selectCompany(String company) {
		selectFromDropdown(COMPANY_DROPDOWN_ELEMENT, company);
		
	}

	public void insertEmail(String email) {
		String insertedEmail = generateRandomNum(999) + email;
		EMAIL_ELEMENT.sendKeys(insertedEmail);		
	}
	
	public void insertPhone(String phone) {
		String insertedPhone = generateRandomNum(999) + phone;
		PHONE_ELEMENT.sendKeys(insertedPhone);		
	}
	public void selectCountry(String country) {
		selectFromDropdown(COUNTRY_DROPDOWN_ELEMENT, country);
		
	}

	public void insertZip(String zip) {
		ZIP_ELEMENT.sendKeys(zip);	
		
	}

	public void insertAddress(String address) {
		ADDRESS_ELEMENT.sendKeys(address);	
		
	}

	public void insertCity(String city) {
		CITY_ELEMENT.sendKeys(city);	
		
	}
	
	public void clickSaveButton() {
		SAVE_BUTTON_ELEMENT.click();
	}
	
	

}
