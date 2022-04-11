package stepDefs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSteps {

	WebDriver driver=BaseClass.driver;
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
	   
	}

	@When("User enters Username {string} and Password {string}")
	public void user_enters_Username_and_Password(String string, String string2) {
	    
	}

	@When("User is on Products Page")
	public void user_is_on_Products_Page() {
		String ExpTitle="PRODUCTS";
    	WebElement product=driver.findElement(By.xpath("//span[@class='title']"));
    	String actual=product.getText();
    	Assert.assertEquals(ExpTitle, actual);
    	System.out.println("User is on Products Page");  
	   
	}

	@Then("User compares the following products price")
	public void user_compares_the_following_products_price(io.cucumber.datatable.DataTable dataTable) {
	    
	}

}
