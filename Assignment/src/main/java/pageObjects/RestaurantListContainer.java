package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RestaurantListContainer {

	public WebDriver driver;

	By restaurantsWrapper = By.xpath("//h2[@class='restaurantname']");
	By searchBox = By.xpath("//input[@id='irestaurantsearchstring-middle']");
	By resultBlock=By.xpath("//div[@class='noresults filter restaurant_noresults js-noresults-search']");

	public RestaurantListContainer(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}

	public List<WebElement> getRestaurantsWrapper(WebDriver driver) {
		return driver.findElements(restaurantsWrapper);
	}

	public WebElement getSearchBox(WebDriver driver) {
		return driver.findElement(searchBox);
	}
	
	public WebElement getSearchResultBlock(WebDriver driver)
	{
		return driver.findElement(resultBlock);
	}
}
