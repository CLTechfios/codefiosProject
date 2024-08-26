package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CustomerListPage extends BasePage {

	WebDriver driver;
	
	public CustomerListPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public void validateInsertedNameAndDelete(String name) {
		for (int i = 1; i<5;i++) {
			String actualName = driver.findElement(By.xpath("//tbody/tr["+i+"]/td[2]/a")).getText();
			if(actualName.contains(name)) {
				driver.findElement(By.xpath("//tbody/tr["+i+"]/td[9]/button")).click();
				driver.findElement(By.xpath("//a[text()='Yes']")).click();
				break;
			}
		}
		
	}
}
