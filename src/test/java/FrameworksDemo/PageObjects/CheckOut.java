package FrameworksDemo.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import GeneralUtilities.AbstractComponents;

public class CheckOut extends AbstractComponents {
	
	WebDriver driver;

	public CheckOut(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="button[routerlink='/dashboard/cart']")
	WebElement cart_btn;
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cart_items;

	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement select_Country;
	
	@FindBy(xpath="(//span[@class='ng-star-inserted'])[text()=' India']")
	WebElement select_Sug;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	public CheckOut goToCart() {
		cart_btn.click();
		CheckOut co=new CheckOut(driver);
		return co;
	}
	
	public List<WebElement> addeditems(){
		return cart_items;
	}
	
	public Boolean matchproduct(String Prodname) {
		Boolean match=addeditems().stream().anyMatch(prods->prods.getText().equalsIgnoreCase(Prodname));
		return match;
	}
	
	

	public Confirm selectCountry(String country) throws InterruptedException {
		
		checkOut();
		Actions a=new Actions(driver);
        a.sendKeys(select_Country, country).build().perform();
        
		select_Sug.click();
		submit.click();
		 return new Confirm(driver);
	}
}
