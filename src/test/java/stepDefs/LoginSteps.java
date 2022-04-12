package stepDefs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps {
	
	WebDriver driver = BaseClass.driver;
	
	@Given("User is on the landing page") 
	public void user_is_on_landing_page() throws InterruptedException {
	    driver.get("https://www.saucedemo.com/");
	    Thread.sleep(5000);
	}
	
	@When("User enters username {string} and password {string}") 
	public void user_enters_username_and_password(String username, String password) throws InterruptedException {
		Thread.sleep(5000);
		WebElement Username=driver.findElement(By.id("user-name"));
    	WebElement Password=driver.findElement(By.id("password"));
    	Username.sendKeys(username);
    	Password.sendKeys(password);
	}

	@When("User clicks on Login button") 
	public void user_clicks_on_Login_button() throws InterruptedException {
		WebElement LoginBtn=driver.findElement(By.id("login-button"));
		Thread.sleep(5000);
    	LoginBtn.click();
	}

	@Then("User enters the products webpage")
	public void user_enters_the_products_webpage() {
		String ExpTitle="PRODUCTS";
    	WebElement product=driver.findElement(By.xpath("//span[@class='title']"));
    	String actual=product.getText();
    	Assert.assertEquals(ExpTitle, actual);
	}

	@Then("User finds an error message {string}")
	public void user_finds_an_error_message(String ExpMsg) {
		WebElement ErrorMsg = driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface')]"));
		String ActualMsg = ErrorMsg.getText();
		Assert.assertEquals(ActualMsg, ExpMsg);
	}

}
