package General;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;

public class BaseClass implements Constants
{
	public static WebDriver driver;
	public ExtentReports extent; 
	WebDriverCommonMethods wdcm=new WebDriverCommonMethods();
	@BeforeSuite
	public void configBeforeSuite()
	{
		extent=new ExtentReports("./test-output/customreport.html");
		extent.loadConfig(new File("C:\\Users\\TYSS\\Desktop\\java\\milon\\src\\main\\resources\\extent-config.xml"));
				
	}
	@AfterSuite
	public void configAfterSuite()
	{
		extent.flush();
		extent.close();
	}
	
	@BeforeClass
	public void configBeforeClass()
{
	Reporter.log("Open Browser",true);
	if(Constants.browser.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver","/home/tyss/Desktop/Software/chromedriver");
		driver=new ChromeDriver();
	}
	else 
	{
		System.setProperty("webdriver.firefox.driver","/home/tyss/Desktop/Software/geckodriver");
		driver=new FirefoxDriver();
	}
}
	@BeforeMethod
	public void configBeforeMethod() throws Throwable
	{
	Reporter.log("Login",true);
	driver.get(url);
	Thread.sleep(3000);
	
	
	}
	@AfterMethod
	public void configAfterMethod() throws Throwable
	{
	Reporter.log("Logout",true);
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[@class='dropdown dropdown-toggle']/i[2]")).click();
	
	
	//driver.findElement(By.xpath("//a[text()=' My Account']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li[11]/a")).click();
	}
	@AfterClass
	public void configAfterClass()
	{
	Reporter.log("Close Browser",true);
	driver.quit();
	}
}
