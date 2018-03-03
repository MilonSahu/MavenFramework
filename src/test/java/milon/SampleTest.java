package milon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest {
	@Test
	public void ghdus()
	{
//		System.out.println("hi");
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\TYSS\\Downloads\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver=new ChromeDriver();
//		driver.get("https://www.google.co.in/");
//		driver.close();
		try
		{
			//int a=10/0;
			Assert.assertEquals(false, true);
			//System.out.println("isjdi");
		}
		catch(Exception e)
		{
			System.out.println("Error");
			 //e.printStackTrace();
			//throw e;
		}
	}
}