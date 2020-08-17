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


![Test Execution ](https://github.com/MayankSikarwar/takeaway-Assignment/blob/master/Assignment/reports/reportScreenShot1.png)



![Dashboard ](https://github.com/MayankSikarwar/takeaway-Assignment/blob/master/Assignment/reports/reportScreenShot2.png)
