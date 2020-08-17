package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	// Landing Page Xpaths
	By acceptCookies = By.xpath("//button[contains(text(),'OK')]");
	By searchBox = By.xpath("//input[@id='imysearchstring']");

	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}

	public WebElement getAcceptCookies(WebDriver driver) {
		return driver.findElement(acceptCookies);
	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public WebElement getPopAvailableLocations(WebDriver driver, String location) {
		return driver.findElement(By.xpath("//*[contains(text(),'" + location + "')]"));
	}

	public WebElement getSearchBox(WebDriver driver) {
		return driver.findElement(searchBox);
	}

}
