package resources;

import javax.json.*;
import java.io.*;
import java.util.HashMap;
import java.util.Properties;

public class ReadJsonData {
	public static Properties prop;

	public static HashMap<String, String> customerDetails(int testCaseNumber) throws IOException {

		// define Input Stream for the Json file
		InputStream inputStream = null;
		// define Json Reader
		JsonReader jsonReader = null;
		// define Json Object
		JsonObject jsonObject = null;
		try {
			testCaseNumber = testCaseNumber - 1;
			inputStream = new FileInputStream("/Users/msikarwar/eclipse-workspace/eclipseNew/Assignment/testData/testData.json");// copy the path of the testData.json from the testData folder 
			jsonReader = Json.createReader(inputStream);
			jsonObject = jsonReader.readObject();
			JsonArray testSteps = jsonObject.getJsonArray("customerDetails");
			HashMap<String, String> customerdetailsHashMap = new HashMap<String, String>();
			customerdetailsHashMap.put("postCode", testSteps.getJsonObject(testCaseNumber).getString("postCode"));
			customerdetailsHashMap.put("location", testSteps.getJsonObject(testCaseNumber).getString("location"));
			customerdetailsHashMap.put("restaurantName",
					testSteps.getJsonObject(testCaseNumber).getString("restaurantName"));
			customerdetailsHashMap.put("mealName", testSteps.getJsonObject(testCaseNumber).getString("mealName"));
			customerdetailsHashMap.put("address", testSteps.getJsonObject(testCaseNumber).getString("address"));
			customerdetailsHashMap.put("completePostCode",
					testSteps.getJsonObject(testCaseNumber).getString("completePostCode"));
			customerdetailsHashMap.put("city", testSteps.getJsonObject(testCaseNumber).getString("city"));
			customerdetailsHashMap.put("name", testSteps.getJsonObject(testCaseNumber).getString("name"));
			customerdetailsHashMap.put("phoneNumber", testSteps.getJsonObject(testCaseNumber).getString("phoneNumber"));
			customerdetailsHashMap.put("email", testSteps.getJsonObject(testCaseNumber).getString("email"));
			customerdetailsHashMap.put("companyName", testSteps.getJsonObject(testCaseNumber).getString("companyName"));
			customerdetailsHashMap.put("remark", testSteps.getJsonObject(testCaseNumber).getString("remark"));
			customerdetailsHashMap.put("deliveryTime",
					testSteps.getJsonObject(testCaseNumber).getString("deliveryTime"));
			return customerdetailsHashMap;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			inputStream.close();
			jsonReader.close();
		}
		return null;
	}

}