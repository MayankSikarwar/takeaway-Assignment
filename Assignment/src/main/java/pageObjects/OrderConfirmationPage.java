package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderConfirmationPage {
	public WebDriver driver;
	
	By orderReference = By.xpath("//span[@class='order-purchaseid']");
	
	public WebElement getOrderReference(WebDriver driver) {
		return driver.findElement(orderReference);
	}
	
}
