# How to run the Test

1. Java environment
2. Maven

Note: Configure webdriver and testData.json path before execution..

## Configure WebDriver

* Update the chromeDriver path in the data.properties file which is located inside 
  #### /src/main/java/resources/data.properties.

* You can choose on which browser you have to run your test cases from the data.properties file.
 For example: 
    *  #### browser=Chrome          [All the Test cases will be executed on chrome]
    *  #### browser=Headless_Chrome [All the Test cases will be executed on Headless chrome]
 
* If there are any issues in the chromeDriver please download the latest version from https://chromedriver.chromium.org/downloads


## Configure Test Data file

 * Update the testData.json path in the ReadJsonData.java file which is located in the 
      #### src/main/java/resources/ReadJsonData.java
 * All the test cases are taking data from the testData.json file.  

### Example Test Data
```json

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


```

## Project is ready to run. Execute following commands and Enjoy
 * Go to project path in terminal. For example: 
     #### /Users/(your username)/Assignment
* Run the below
Run
```bash
mvn clean
```
```bash
mvn compile
```
```bash
mvn test
```




