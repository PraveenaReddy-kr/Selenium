package FrameworksDemo.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import GeneralUtilities.AbstractComponents;

public class Confirm extends AbstractComponents {
	
	WebDriver driver;

	public Confirm(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".hero-primary")
	WebElement hero;
	
	
	public Boolean getConfirm() {
		Boolean match= hero.getText().equalsIgnoreCase("Thankyou for the order.");
		return match;
	}
	

	
}
