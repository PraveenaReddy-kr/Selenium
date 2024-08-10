package FrameworksDemo.testclasses;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FrameworksDemo.PageObjects.CheckOut;
import FrameworksDemo.PageObjects.Confirm;
import FrameworksDemo.PageObjects.Productcatelog;
import FrameworksDemo.TestComponenets.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EndToEndClass extends BaseTest{

		@Test(dataProvider="getData" ,groups= {"Purchase"})
		public void submitOrder(HashMap<String,String> input) throws InterruptedException, IOException {
	//	String Prodname="ZARA COAT 3";
		Productcatelog pc=lp.LoginAction(input.get("email"), input.get("pwd"));
		List<WebElement> products=pc.getProducts();
		pc.getProductByName(input.get("product"));
		CheckOut co=pc.addToCart(input.get("product"));	
		Assert.assertTrue(co.matchproduct(input.get("product")));
		Confirm con=co.selectCountry("india");
		Assert.assertTrue(con.getConfirm());
		
	}
		@Test(dependsOnMethods= {"submitOrder"})
		public void VerifyOrder() throws InterruptedException, IOException {
		String Prodname="ZARA COAT 3";
		Productcatelog pc=lp.LoginAction("NITISHREDDYSEERAPU@GMAIL.COM", "Npr@0612");
		pc.getOrders(Prodname);
		Assert.assertTrue(Prodname.equalsIgnoreCase(pc.getOrders(Prodname)));
		}
		
		
		@DataProvider
		public Object[][] getData() throws IOException{
			
			List<HashMap<String,String>> data= getHashMap(System.getProperty("user.dir")+"\\src\\main\\java\\freameworks\\data\\data.json");
			return new Object[][] {{data.get(0)},{data.get(1)}};
		}
		
		
	
		
		/*
		 * @DataProvider public Object[][] getData() {
		 * 
		 * 
		 * return new Object[][]
		 * {{"NITISHREDDYSEERAPU@GMAIL.COM","Npr@0612","ZARA COAT 3"
		 * },{"register1@gmail.com","Ammu@0611","ADIDAS ORIGINAL"}}; }
		 */
		
//		HashMap<String,String> map=new HashMap<String,String>();
//		map.put("email", "NITISHREDDYSEERAPU@GMAIL.COM");
//		map.put("pwd", "Npr@0612");
//		map.put("product", "ZARA COAT 3");
//		
//		HashMap<String,String> map1=new HashMap<String,String>();
//		map1.put("email", "register1@gmail.com");
//		map1.put("pwd", "Ammu@0611");
//		map1.put("product", "ADIDAS ORIGINAL");
//		
//		return new Object[][] {{map},{map1}};
}
