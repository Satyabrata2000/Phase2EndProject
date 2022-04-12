package stepDefs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSteps {

	WebDriver driver = BaseClass.driver;
	
	@Given("User is on login page")
	public void user_is_on_login_page() throws InterruptedException {
		driver.get("https://www.saucedemo.com/");
	    Thread.sleep(5000); 
	}

	@When("User enters Username {string} and Password {string}")
	public void user_enters_Username_and_Password(String username, String password)throws InterruptedException {
		WebElement Username=driver.findElement(By.id("user-name"));
    	WebElement Password=driver.findElement(By.id("password"));
    	Username.sendKeys(username);
    	Password.sendKeys(password);
    	WebElement LoginBtn=driver.findElement(By.id("login-button"));
		Thread.sleep(5000);
    	LoginBtn.click();
	}

	@When("User is on Products Page")
	public void user_is_on_Products_Page() {
		String ExpTitle="PRODUCTS";
    	WebElement product=driver.findElement(By.xpath("//span[@class='title']"));
    	String actual=product.getText();
    	Assert.assertEquals(ExpTitle, actual);
	   
	}

	@Then("User compares the following products price")
	public void user_compares_the_following_products_price(DataTable dataTable) {
		int rows = dataTable.height();
		for(int i=0;i<rows;i++) {
			
			String product= dataTable.cell(i, 0);
			String price= dataTable.cell(i, 1);
			String actualprice=driver.findElement(By.xpath("//div[text()='"+product+"']/following::div[@class='inventory_item_price'][1]")).getText();
			Assert.assertEquals(price, actualprice);
		}

	}
}
