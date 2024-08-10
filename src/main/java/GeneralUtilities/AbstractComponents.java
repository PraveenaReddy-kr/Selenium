package GeneralUtilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {

	WebDriver driver;
	@FindBy(css=".totalRow .btn-primary")
	WebElement Checkout_btn;
	
	@FindBy(css="button[routerlink='/dashboard/myorders']")
	WebElement MyOrders;
	
	public AbstractComponents(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	public void waitForElementToAppear(By locator) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitForWebElementToAppear(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void waitForElemntToDisappear(WebElement ele) throws InterruptedException {
		Thread.sleep(1000);
	//	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	//wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	public void checkOut() throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
	    Thread.sleep(1000);
		Checkout_btn.click();
	}
	
	public void orders() {
		MyOrders.click();
	}
}
