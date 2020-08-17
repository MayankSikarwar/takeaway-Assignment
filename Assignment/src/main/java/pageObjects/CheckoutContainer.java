package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutContainer {

	public WebDriver driver;
	public CheckoutContainer(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}
	// CheckoutContainer Page xpaths
		By  addressField = By.xpath("//input[@id='iaddress']");
		By  postCodField = By.xpath("//input[@id='ipostcode']");
		By  cityField = By.xpath("//input[@id='itown']");
		By  nameField = By.xpath("//input[@id='isurname']");
		By  emailField= By.xpath("//input[@id='iemail']");
		By  phoneNumberField= By.xpath("//input[@id='iphonenumber']");
		By  companynameField= By.xpath("//input[@id='icompanyname']");
		By  deliveryTimeField= By.xpath("//select[@id='ideliverytime']");
		By  remarkField = By.xpath("//textarea[@id='iremarks']");
		By  saveRemarkCheckbox = By.xpath("//*[@id=\"isaveremarks\"]");
		By  payWithDropdown= By.xpath("//*[@id='ipayswith']");
		By  orderAndPayButton= By.xpath("//input[@class='button_form cartbutton-button']");
		By notificationWrapper=By.xpath("//div[@class='notificationalert notificationfeedbackwrapper']");
		
		

		public WebElement getNotificationWrapper(WebDriver driver)
		{
			return driver.findElement(notificationWrapper);
		}
		public WebElement getAddressField(WebDriver driver) {
			return driver.findElement(addressField);
		}
		
		public WebElement getPostCodField(WebDriver driver) {
			return driver.findElement(postCodField);
		}
		
		public WebElement getCityField(WebDriver driver) {
			return driver.findElement(cityField);
		}
		
		public WebElement getNameField(WebDriver driver) {
			return driver.findElement(nameField);
		}
		
		public WebElement getEmailField(WebDriver driver) {
			return driver.findElement(emailField);
		}
		
		public WebElement getPhoneNumberField(WebDriver driver) {
			return driver.findElement(phoneNumberField);
		}
		
		public WebElement getCompanyNameField(WebDriver driver) {
			return driver.findElement(companynameField);
		}
		
		public WebElement getDeliveryTimeField(WebDriver driver) {
			return driver.findElement(deliveryTimeField);
		}
		
		public WebElement getRemarkField(WebDriver driver) {
			return driver.findElement(remarkField);
		}
		
		public WebElement getSaveRemarkCheckbox(WebDriver driver) {
			return driver.findElement(saveRemarkCheckbox);
		}
		
		public WebElement getPayWithDropdown(WebDriver driver) {
			return driver.findElement(payWithDropdown);
		}
		
		public WebElement getOrderAndPayButton(WebDriver driver) {
			return driver.findElement(orderAndPayButton);
		}
}
