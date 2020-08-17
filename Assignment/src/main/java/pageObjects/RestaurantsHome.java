package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RestaurantsHome {

	public WebDriver driver;

	By menuSearchButton = By.xpath("//div[@class='menu-category-search']");
	By orderButton = By.xpath("//button[@class='basket__order-button cartbutton-button']");
	By mealWrapper = By.xpath("//span[@class='meal-name']");
	By productPrice = By.xpath("//span[@class='cart-meal-price notranslate']");
	By deliverCost = By.xpath("//*[@id='sum']/div[2]/span[2]");
	By noProductsFoundContainer=By.xpath("//div[@class='no_products_found']");
	By menuSearchBox = By.xpath("//input[@class='menu-meal-search-input js-product-search']");
	By orderTotal= By.xpath("//*[@id='sum']/div[3]/span[2]");

	public RestaurantsHome(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}

	public WebElement getMenuSearchButton(WebDriver driver) {
		return driver.findElement(menuSearchButton);
	}

	public List<WebElement> getMealWrapper(WebDriver driver) {
		return driver.findElements(mealWrapper);
	}

	public List<WebElement> getProductPrice(WebDriver driver) {
		return driver.findElements(productPrice);
	}

	public WebElement getDeliverCost(WebDriver driver) {
		return driver.findElement(deliverCost);
	}
	public WebElement getNoProductsFoundContainer(WebDriver driver)
	{
		return driver.findElement(noProductsFoundContainer);
	}
	public WebElement getMenuSearchBox(WebDriver driver)
	{
		return driver.findElement(menuSearchBox);
	}
	public WebElement getOrderTotal(WebDriver driver)
	{
		return driver.findElement(orderTotal);
	}
	public WebElement getOrderButton(WebDriver driver)
	{
		return driver.findElement(orderButton);
	}

}
