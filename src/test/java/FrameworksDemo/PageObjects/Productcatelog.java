package FrameworksDemo.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GeneralUtilities.AbstractComponents;

public class Productcatelog extends AbstractComponents {
	
	WebDriver driver;

	public Productcatelog(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3 .card")
	List<WebElement> Products;
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> Orders;
	
	@FindBy(css=".ng-animating")
	WebElement loading;
	
	By productBy=By.cssSelector(".mb-3 .card");
	By addTocartBtn=By.cssSelector(".card-body button:last-of-type");
	By toastmsg=By.id("toast-container");
	
	public List<WebElement> getProducts() {
		waitForElementToAppear(productBy);
		return Products;
	}
	
	

	public WebElement getProductByName(String Prodname) throws InterruptedException {
		
		/*for(WebElement pro:Products) {
			System.out.println(pro.findElement(By.cssSelector("div h5 b")).getText());
		}*/
		
//		getProducts().stream().
//		forEach(product -> System.out.println(product.findElement(By.cssSelector("div h5 b")).getText()));
		
		WebElement prod = getProducts().stream()
				.filter(product -> product.findElement(By.cssSelector("div h5 b")).getText().contains(Prodname))
				.findFirst().orElse(null);
		return prod;
	}
	
	public String getOrders(String Prodname) {
		
		orders();
		WebElement prod = Orders.stream()
				.filter(product -> product.getText().equals(Prodname))
				.findFirst().orElse(null);
		return prod.getText();
	}
	
	public CheckOut addToCart(String Prodname) throws InterruptedException {
		getProductByName(Prodname).findElement(addTocartBtn).click();
		waitForElementToAppear(toastmsg);
		waitForElemntToDisappear(loading);
		CheckOut co=new CheckOut(driver);
		return co.goToCart();
	}

}
