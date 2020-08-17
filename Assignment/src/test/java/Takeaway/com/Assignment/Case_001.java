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

public class Case_001 extends base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	public static ReadJsonData json;
	int testCaseNumber=1;

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();

	}

	@Test()
	public void caseOne_CreateOrderAndPayWithClosestAmout() throws IOException {
		
		System.out.println();
		Utility utility = new Utility(driver);
		driver.get(prop.getProperty("url"));
		utility.acceptCookies();
		utility.clickSearchBox();
		utility.setLocationInSearchBox(ReadJsonData.customerDetails(testCaseNumber).get("postCode"));
		utility.selectLocation(ReadJsonData.customerDetails(testCaseNumber).get("location"));
		Assert.assertEquals(true, utility.getRestaurant(ReadJsonData.customerDetails(testCaseNumber).get("restaurantName"))); // if the
																											// Requested
		// restaurant is
		// available it selects
		// and returns true if
		// restaurant is not
		// available it returns
		// false and test case
		// fails.
		Assert.assertEquals(true, utility.getMeal(ReadJsonData.customerDetails(testCaseNumber).get("mealName")));// if the Requested
																										// meal is
																										// available it
		// selects and returns true if meal is
		// not available // not available it
		// returns false and
		// test case fails.
		System.out.println(utility.getOrderTotal());
		utility.clickOrderButtonFromRestaurantsHome();
		utility.setAddress(ReadJsonData.customerDetails(testCaseNumber).get("address"));
		utility.setPostCode(ReadJsonData.customerDetails(testCaseNumber).get("completePostCode"));
		utility.setCity(ReadJsonData.customerDetails(testCaseNumber).get("city"));
		utility.setName(ReadJsonData.customerDetails(testCaseNumber).get("name"));
		utility.setEmail(ReadJsonData.customerDetails(testCaseNumber).get("email"));
		utility.setPhoneNumer(ReadJsonData.customerDetails(testCaseNumber).get("phoneNumber"));
		utility.setCompanyName(ReadJsonData.customerDetails(testCaseNumber).get("companyName"));
		utility.selectDeliverTime("As soon as possible");
		utility.setRemarks(ReadJsonData.customerDetails(testCaseNumber).get("remark"));
		utility.clickSaveRemarks();
		utility.selectPayWithClosestAmout();
		utility.clickOrderAndPayButton();
		utility.getOrderReference();
		Assert.assertNotNull(utility.getOrderReference());
		log.info("Order Reference : " + utility.getOrderReference());
		log.info("Successfully validated Text message");
		System.out.println("Test completed");

	}

	@AfterTest
	public void teardown() {

		driver.close();

	}

}
