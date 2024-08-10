package FrameworksDemo.testclasses;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import FrameworksDemo.PageObjects.CheckOut;
import FrameworksDemo.PageObjects.Confirm;
import FrameworksDemo.PageObjects.Productcatelog;
import FrameworksDemo.TestComponenets.BaseTest;
import FrameworksDemo.TestComponenets.Retry;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorClass extends BaseTest{

		@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
		public void loginError() throws InterruptedException, IOException {
		
		Productcatelog pc=lp.LoginAction("NITISHREDDYSEPU@GMAIL.COM", "Npr@0661");
		Assert.assertEquals("Incorrect email or password.", lp.getError());
	}
		@Test
		public void productError() throws InterruptedException
		{
			String Prodname="ZARA COAT 3";
			Productcatelog pc=lp.LoginAction("NITISHREDDYSEERAPU@GMAIL.COM", "Npr@0612");
			List<WebElement> products=pc.getProducts();
			pc.getProductByName(Prodname);
			CheckOut co=pc.addToCart(Prodname);	
			Assert.assertFalse(co.matchproduct("ZARA COAT 33"));
		}

}
