package FrameworksDemo.TestComponenets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import FrameworksDemo.PageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public LandingPage lp;

	public WebDriver initializeDriver() throws IOException {
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\frameworksDemo\\Resources\\GlobalData.properties");
		prop.load(fis);
		
		
		String Browsername=System.getProperty("browser")!=null? System.getProperty("browser"):prop.getProperty("browser");
		
		if(Browsername.contains("chrome"))
		{
			ChromeOptions options=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		
		
		if(Browsername.contains("headless")) {
		options.addArguments("headless");
		}
	    driver=new ChromeDriver(options);
	    driver.manage().window().setSize(new Dimension(1400,900));
		}
		
		if(Browsername.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
		    driver=new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	public String Screenshots(String testcaseName,WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File Source=ts.getScreenshotAs(OutputType.FILE);
		File des=new File(System.getProperty("user.dir")+"//reports//"+testcaseName+".png");
		FileUtils.copyFile(Source, des);
		return System.getProperty("user.dir")+"//reports//"+testcaseName+".png";
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage LaunchlandingPage() throws IOException {
		driver= initializeDriver();
		lp=new LandingPage(driver);
		lp.goTo();
		return lp;
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void close() {
		driver.close();
	}
	
	public List<HashMap<String, String>> getHashMap(String path) throws IOException {
		
		String jsonContent= FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);
		
		ObjectMapper mapper=new ObjectMapper(); // Jackson databind
		List<HashMap<String,String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
		
		return data;
	}
}
