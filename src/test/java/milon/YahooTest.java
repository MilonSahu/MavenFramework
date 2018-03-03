package milon;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import General.ExcelData;

public class YahooTest {
	ExcelData edata=new ExcelData();
	@Test
	public void ConfigYahoo() throws Throwable
	{
		System.out.println("enter into Testscript");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\TYSS\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get("https://www.yahoo.com/");
	driver.findElement(By.id("uh-signin")).click();
	driver.findElement(By.id("createacc")).click();
	String fname=edata.getExceldata("Sheet1", 1,0);
	String lname=edata.getExceldata("Sheet1", 1,1);
	String email=edata.getExceldata("Sheet1", 1,2);
	String password=edata.getExceldata("Sheet1", 1,3);
	String mobile=edata.getExceldata("Sheet1", 1,4);
	String date=edata.getExceldata("Sheet1", 1,5);
	String year=edata.getExceldata("Sheet1", 1,6);
	driver.findElement(By.id("usernamereg-firstName")).sendKeys(fname);
	driver.findElement(By.id("usernamereg-lastName")).sendKeys(lname);
	driver.findElement(By.id("usernamereg-yid")).sendKeys(email);
	driver.findElement(By.id("usernamereg-password")).sendKeys(password);
	driver.findElement(By.id("usernamereg-phone")).sendKeys(mobile);
	WebElement msel=driver.findElement(By.id("usernamereg-month"));
	Select sel=new Select(msel);
	sel.selectByVisibleText("June");
	driver.findElement(By.id("usernamereg-day")).sendKeys(date);
	driver.findElement(By.id("usernamereg-year")).sendKeys(year);
	driver.findElement(By.xpath("//button[text()='Continue']")).click();
	driver.findElement(By.name("sendCode")).click();
	
	
	
	
	
	}

}
