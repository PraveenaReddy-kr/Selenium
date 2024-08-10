package FrameworksDemo.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GeneralUtilities.AbstractComponents;

public class LandingPage extends AbstractComponents {
	
	WebDriver driver;

	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement UserPassword;
	
	@FindBy(id="login")
	WebElement Login_Button;
	
	@FindBy(css="[Class*='flyInOut']")
	WebElement Error;
	
	public Productcatelog LoginAction(String Email,String Password) {
		userEmail.sendKeys(Email);
		UserPassword.sendKeys(Password);
		Login_Button.click();
		Productcatelog pc=new Productcatelog(driver);
		return pc;
	}
	
	public String getError() {
		
		waitForWebElementToAppear(Error);
		return Error.getText();
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
}
