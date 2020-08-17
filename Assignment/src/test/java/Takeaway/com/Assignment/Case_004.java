package Takeaway.com.Assignment;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.ReadJsonData;
import resources.Utility;
import resources.base;

public class Case_004 extends base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	int testCaseNumber=4;

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();

	}

	@Test()
	public void caseFour_MealNotAvailable() throws IOException {
		Utility utility = new Utility(driver);
		driver.get(prop.getProperty("url"));
		utility.acceptCookies();
		utility.clickSearchBox();
		utility.setLocationInSearchBox(ReadJsonData.customerDetails(testCaseNumber).get("postCode"));
		utility.selectLocation(ReadJsonData.customerDetails(testCaseNumber).get("location"));
		Assert.assertEquals(true, utility.getRestaurant(ReadJsonData.customerDetails(testCaseNumber).get("restaurantName"))); // if the Requested
																								// restaurant is
																								// available it selects
																								// and returns true if
																								// restaurant is not
																								// available it returns
																								// false and test case
																								// fails.
		Assert.assertEquals(false, utility.getMeal("Meal not available"));// if the Requested meal is available it
																				// selects and returns true if meal is
																				// not available it returns false and
																				// test case fails.
		log.info("Successfully validated Text message");
		System.out.println("Test completed");

	}

	@AfterTest
	public void teardown() {

		driver.close();

	}

}
