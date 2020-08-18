# How to Download and Run the Tests

Prerequisite

1. Java environment
2. Maven (Version recommended : [Maven 3.6.3](https://maven.apache.org/download.cgi) )

## Download

* Download Project zip and extract `takeaway-Assignment-master`.
* Once the extraction is completed Open the folder `takeaway-Assignment-master` and copy the `Assignment` folder and paste it `user\Your_Home` folder

## Notes for Windows and Mac

* For Windows use double back slash `C:\\Users\\Your_User\\Assignment` for directory path
* For Mac use single forward slash `/Users/Your_User/Assignment` for directory path


## Configure webDriver and testData.json path before execution.

## Configure webDriver

* Copy the chromeDriver executable file path (path:`Assignment/browsers`) and paste it in the data.properties file (path:`Assignment/src/main/java/resources/data.properties`).

* You can choose on which browser you have to run your test cases from the data.properties file.
 For example: 
    *  #### browser=Chrome          [All the Test cases will be executed on chrome]
    *  #### browser=Headless_Chrome [All the Test cases will be executed on Headless chrome]
 
* If there are any issues in the chromeDriver please download the latest version from https://chromedriver.chromium.org/downloads


## Configure Test Data file

 * Copy the testData.json file path (path:`/Assignment/testData/`) and paste it in the ReadJsonData.java (path:`/Assignment/src/main/java/resources/ReadJsonData.java`)
     
 * All the test cases are taking data from the testData.json file.  

### Example Test Data
```json
{
	"customerDetails": [
		{
		    "caseNumber":"1",
			"postCode": "8888",
			"location": "8888 Alpha",
			"restaurantName": "Los Pollos Hermanos - Automation",
			"mealName": "Hermanito special burrito",
			"address": "main street 2415",
			"completePostCode": "8888AA",
			"city": "Enschede",
			"name": "TestUSer",
			"phoneNumber": "1234567890",
			"email": "testuser@test.test",
			"companyName": "TakeAway",
			"remark": "Make it extra Spicy",
			"deliveryTime": "As soon as possible"
		}
]
}

```

## Project is ready to run. Execute following commands and Enjoy
 * Go to project path in terminal. For example: `/Users/(your username)/Assignment`
* Run the below

  run `mvn clean`

  run `mvn compile`

  run `mvn test`


## Report

You can find the test result in `Assignment/reports/index.html`

Report contains Test and Dashboard tab 




Below are the screenshot of the Execution report

In the Test TAB , test execution details are available with the screenshot of the executed test case. 


![Test Execution ](https://github.com/MayankSikarwar/takeaway-Assignment/blob/master/Assignment/reports/reportScreenShot1.png)

In the Dashboard, Overall test execution details are available.

![Dashboard ](https://github.com/MayankSikarwar/takeaway-Assignment/blob/master/Assignment/reports/reportScreenShot2.png)


## Test Cases

The Assignment test cases are located inside the `Assignment/src/test/java/Takeaway/com/Assignment`

There are total 4 test cases

* Case_001 : User creates an order and pay with the closest available amount. 

             Note: For example if the order total is € 11.3 and if € 11.4 is available in 
             the list then the script selects € 11.4. additionally If we want to select 
             the nearest integer instead of decimal number then we can easily enhance 
             this method to do the same. 
 



* Case_002 : User creates an order and gets the Order Reference Number. 
             
             Note : After the execution is completed the order reference is stored in the 
             log file with name as `prints-todays date.xml` which is located inside the logs 
             folder. 
* Case_003 : User searches for an restaurant which is not available at his/her location.
             
             Note : The test script searches for a restaurant and validates that the reset 
             button is displayed if the requested restaurant is not available.

* Case_004 : User searches for an meal which is not available at the selected restaurant. 
             

             Note : The test script searches for a meal and validates that the reset button 
             is displayed if the requested meal is not available.

## Framework

I have created a Framework for assignment and the heart and the soul of the framework is located inside the  `Assignment/src/main/java/pageObjects` and `Assignment/src/main/java/resources` 

![Project Explorer ](https://github.com/MayankSikarwar/takeaway-Assignment/blob/master/Assignment/reports/Screenshot%202020-08-18%20at%2009.44.15.png)

In the Utility Class you will find all the reusable methods like

	acceptCookies
	getTitle
	clickOrderButtonFromRestaurantsHome
	selectLocation
	clickSearchBox
	setAddress
	setPostCode
	setCity
	setName
	setEmail
	setPhoneNumer
	setCompanyName
	getNotificationMessage
	selectDeliverTime This method selects the delivery time sent from the test case. 
	selectPayWith
	selectPayWithClosestAmout
	clickOrderAndPayButton
	setRemarks
	clickSaveRemarks
	setLocationInSearchBox
	getOrderReference
	getMeal
	calculateOrderTotal
	getOrderTotal
	getRestaurant

for example the below method `getRestaurant` will get the requested restaurant

```java
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
```

The below method `getMeal` gets the meal from the selected restaurant

```java 
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

```
