package resources;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pageObjects.CheckoutContainer;
import pageObjects.LandingPage;
import pageObjects.OrderConfirmationPage;
import pageObjects.RestaurantListContainer;
import pageObjects.RestaurantsHome;

public class Utility {

	public WebDriver driver;
	RestaurantsHome restaurantsHome = new RestaurantsHome(driver);
	RestaurantListContainer restaurantListContainer = new RestaurantListContainer(driver);
	CheckoutContainer checkoutContainer = new CheckoutContainer(driver);
	LandingPage landingPage = new LandingPage(driver);
	OrderConfirmationPage orderConfirmationPage=new OrderConfirmationPage();

	public Utility(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	// Accept Cookies
	public void acceptCookies() {
		try {
			landingPage.getAcceptCookies(driver).click();
		} catch (Exception e) {
			System.out.println("Exception caught acceptCookies " + e);
		}
	}

	// Get Page Title
	public void getTitle() {
		try {
			landingPage.getTitle(driver);
		} catch (Exception e) {
			System.out.println("Exception caught getTitle " + e);
		}
	}

	public void clickOrderButtonFromRestaurantsHome() {
		try {
			restaurantsHome.getOrderButton(driver).click();
		} catch (Exception e) {
			System.out.println("Exception caught getOrderButtonFromRestaurantsHome " + e);
		}
	}

	// Get Location by Name
	public void selectLocation(String availableLocation) {
		try {
			landingPage.getPopAvailableLocations(driver, availableLocation).click();
		} catch (Exception e) {
			System.out.println("Exception caught selectLocation " + e);
		}
	}

	public void clickSearchBox() {
		try {
			landingPage.getSearchBox(driver).click();
		} catch (Exception e) {
			System.out.println("Exception caught clickSearchBox " + e);
		}
	}

	public void setAddress(String address) {
		checkoutContainer.getAddressField(driver).sendKeys(address);
	}

	public void setPostCode(String postCode) {
		checkoutContainer.getPostCodField(driver).clear();
		checkoutContainer.getPostCodField(driver).sendKeys(postCode);
	}

	public void setCity(String city) {
		checkoutContainer.getCityField(driver).sendKeys(city);
	}

	public void setName(String name) {
		checkoutContainer.getNameField(driver).sendKeys(name);
	}

	public void setEmail(String email) {
		checkoutContainer.getEmailField(driver).clear();
		checkoutContainer.getEmailField(driver).sendKeys(email);
	}

	public void setPhoneNumer(String phoneNumber) {
		checkoutContainer.getPhoneNumberField(driver).sendKeys(phoneNumber);
	}

	public void setCompanyName(String companyName) {
		checkoutContainer.getCompanyNameField(driver).sendKeys(companyName);
	}
	
	public void getNotificationMessage()
	{
		checkoutContainer.getNotificationWrapper(driver).getText();
	}

	// This method selects the deliveryTime received as the parameter if that field is empty then it
	// selects the first timeslot from the list
	public boolean selectDeliverTime(String deliveryTime) {
		boolean selectedTimeSlot = false;
		Select dropdown = new Select(checkoutContainer.getDeliveryTimeField(driver));
		List<WebElement> availableDeliveryTimeSlots = dropdown.getOptions();
		// Loop to print one by one
		for (int time = 0; time < availableDeliveryTimeSlots.size(); time++) {
			if (deliveryTime != null && availableDeliveryTimeSlots.get(time).getText().equalsIgnoreCase(deliveryTime)) {
				availableDeliveryTimeSlots.get(time).click();
				System.out.println(availableDeliveryTimeSlots.get(time).getText());
				selectedTimeSlot = true;
				return selectedTimeSlot;

			}
		}
		availableDeliveryTimeSlots.get(1).click();
		return false;
	}

	public boolean selectPayWith(String amount) {
		boolean selectedAmount = false;
		Select dropdown = new Select(checkoutContainer.getPayWithDropdown(driver));
		List<WebElement> availableAmounts = dropdown.getOptions();
		for (int amt = 0; amt < availableAmounts.size(); amt++) {
			if (amount != null && availableAmounts.get(amt).getText().equalsIgnoreCase(amount)) {
				availableAmounts.get(amt).click();
				System.out.println(availableAmounts.get(amt).getText());
				selectedAmount = true;
				return selectedAmount;
			}
		}
		availableAmounts.get(1).click();
		return false;

	}

	public boolean selectPayWithClosestAmout() {
		boolean selectedAmount = true;
		Select dropdown = new Select(checkoutContainer.getPayWithDropdown(driver));
		List<WebElement> availableAmounts = dropdown.getOptions();
		availableAmounts.get(1).click();
		return selectedAmount;

	}

	public void clickOrderAndPayButton() {
		checkoutContainer.getOrderAndPayButton(driver).click();
	}

	public void setRemarks(String remarks) {
		checkoutContainer.getRemarkField(driver).sendKeys(remarks);
	}

	public void clickSaveRemarks() {
		checkoutContainer.getSaveRemarkCheckbox(driver).click();
	}

	public void setLocationInSearchBox(String location) {
		try {
			landingPage.getSearchBox(driver).click();
			landingPage.getSearchBox(driver).sendKeys(location);
			landingPage.getSearchBox(driver).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			System.out.println("Exception caught setLocationInSearchBox " + e);
		}
	}
	
	//Get Order Reference
	public String getOrderReference()
	{
		return orderConfirmationPage.getOrderReference(driver).getText();
	}
	
	
	// Method to get Meal by Name
	public boolean getMeal(String mealName) {
		try {
			boolean mealSelected = false;
			restaurantsHome.getMenuSearchButton(driver).click();
			restaurantsHome.getMenuSearchBox(driver).sendKeys(mealName);
			Thread.sleep(3000);
			String resetSearchButtonVisibility = restaurantsHome.getNoProductsFoundContainer(driver)
					.getAttribute("style");
			if (resetSearchButtonVisibility.contains("block")) {
				System.out.println("Sorry! The requested meal " + mealName + " is not available at this restaurant");
				mealSelected = false;
				return mealSelected;

			} else {
				List<WebElement> listOfMeals = restaurantsHome.getMealWrapper(driver);
				for (int meal = 0; meal < listOfMeals.size(); meal++) {
					if (mealName != null && listOfMeals.get(meal).getText().equalsIgnoreCase(mealName)) {
						System.out.println("Meal Selected : " + listOfMeals.get(meal).getText());
						listOfMeals.get(meal).click();
						mealSelected = true;
						return mealSelected;
					} else if (mealName == null || mealName == "") {
						listOfMeals.get(0).click();
						mealSelected = true;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Exception caught getMeal " + e);
			return false;
		}
		return false;
	}

	// Method to calculate order cart total
	public double calculateOrderTotal() {
		try {
			double price = 0;
			double orderTotal = 0;
			List<WebElement> productsInCart = restaurantsHome.getProductPrice(driver);
			System.out.println(productsInCart.size());
			for (int product = 0; product < productsInCart.size() - 1; product++) {
				String stringPrice = productsInCart.get(product).getText();
				String[] splitPriceFromCurrency = stringPrice.split(" ");
				String stringToConvert = splitPriceFromCurrency[1].replace(",", ".");
				price = Double.parseDouble(stringToConvert);
				orderTotal = orderTotal + price;
			}
			if (restaurantsHome.getDeliverCost(driver).getText() == "Free"
					&& restaurantsHome.getDeliverCost(driver).getText() == "Gratis")
			// Can be Changed to another method which does not use Hard-coded text
			{
				return orderTotal;
			}
			{
				String deliveryCostInString = restaurantsHome.getDeliverCost(driver).getText();
				String[] splitDeliveryCostFromCurrency = deliveryCostInString.split(" ");
				double deliverCost = Double.parseDouble(splitDeliveryCostFromCurrency[1].replace(",", "."));
				return orderTotal + deliverCost;
			}

		} catch (Exception e) {
			System.out.println("Exception caught getOrderTotal " + e);
		}
		return 0;
	}

	public double getOrderTotal() {
		String stringPrice = restaurantsHome.getOrderTotal(driver).getText();
		String[] splitPriceFromCurrency = stringPrice.split(" ");
		String stringToConvert = splitPriceFromCurrency[1].replace(",", ".");
		return Double.parseDouble(stringToConvert);

	}

	// Method to get Restaurants by name
	public boolean getRestaurant(String restaurantName) {
		try {
			boolean restaurantSelected = false;
			restaurantListContainer.getSearchBox(driver).sendKeys(restaurantName);
			Thread.sleep(3000);
			String resetSearchButtonVisibility = restaurantListContainer.getSearchResultBlock(driver)
					.getAttribute("style");
			if (resetSearchButtonVisibility.contains("block")) {
				System.out.println("Sorry! The requested restaurant is not available at your location");
				restaurantSelected = false;
				return restaurantSelected;

			} else {
				List<WebElement> resturants = restaurantListContainer.getRestaurantsWrapper(driver);
				System.out.println(resturants.size()-1);
				for (int x = 0; x < resturants.size(); x++) {
					if (restaurantName != null && resturants.get(x).getText().equalsIgnoreCase(restaurantName)) {
						System.out.println("Restaurant Selected : "+resturants.get(x).getText());
						resturants.get(x).click();
						restaurantSelected = true;
						return restaurantSelected;
					}
				}
			}

		} catch (Exception e) {
			System.out.println("Exception caught in getRestaurant " + e);
		}
		return false;
	}
}
