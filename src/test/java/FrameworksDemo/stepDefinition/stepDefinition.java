package FrameworksDemo.stepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import FrameworksDemo.PageObjects.CheckOut;
import FrameworksDemo.PageObjects.Confirm;
import FrameworksDemo.PageObjects.LandingPage;
import FrameworksDemo.PageObjects.Productcatelog;
import FrameworksDemo.TestComponenets.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinition extends BaseTest{

	LandingPage landingPage;
	Productcatelog prodcat;
	CheckOut checkout;
	Confirm  con;
	
	@Given("I landed on Login Page")
	public void I_landed_on_Login_Page() throws IOException {
		
		landingPage= LaunchlandingPage();
	}
	
	@Given("^I login with (.+) and (.+)$")
	public void I_login_with_email_and_password(String email,String password) {
		
		prodcat = landingPage.LoginAction(email, password);
	
	}
	
	@When("^I Select (.+) and add to cart$")
	public void I_Select_product_and_add_to_cart(String product) {
		
		List<WebElement> products=prodcat.getProducts();
		
	}
	
	@When("^Checkout (.+) and Submit Order$")
	public void Checkout_product_and_Submit_Order(String product) throws InterruptedException {
		checkout=prodcat.addToCart(product);
		Assert.assertTrue(checkout.matchproduct(product));
		con=checkout.selectCountry("india");
	}
	
	@Then("I need to get {string}")
	public void I_need_to_get_Confirmation(String string) {
		Assert.assertTrue(con.getConfirm());
		driver.close();
	}
	
	@Then("I should get {string} message")
	public void I_should_get_error_message(String string){
		Assert.assertEquals(string, landingPage.getError());
		driver.close();
	}
	
}
