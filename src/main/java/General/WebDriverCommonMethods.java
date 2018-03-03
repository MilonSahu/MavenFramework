package General;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverCommonMethods 
{
	public void waitForPageLoad()
	{
		BaseClass.driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	public void windowMaximize()
	{
		BaseClass.driver.manage().window().maximize();
	}
	public void select(WebElement vsel,String value)
	{
		Select sel=new Select(vsel);
		sel.selectByValue(value);
		
	}
	public void select(WebElement isel,int index)
	{		
		Select sel=new Select(isel);
		sel.selectByIndex(index);
	}
	public void select1(WebElement tsel,String text)
	{		
		Select sel=new Select(tsel);
		sel.selectByVisibleText(text);
	}
	public void action(WebElement wb)
	{
		Actions act=new Actions(BaseClass.driver);
		act.moveToElement(wb).perform();
	}
	public void action2(WebElement wb1)
	{
		Actions act1=new Actions(BaseClass.driver);
		act1.moveToElement(wb1).perform();
	}
	public String getWindowIDs()
	{
	String WinID = null;
	Set<String> set = BaseClass.driver.getWindowHandles();
	Iterator<String> it = set.iterator();
	if(set.size()==2)
	{
	String parentWinID = it.next();
	String childWinID = it.next();
	WinID = parentWinID+";"+childWinID;
	}
	else if(set.size()==3)
	{
	String parentWinID = it.next();
	String childWinID = it.next();
	String subChildWinID = it.next();
	WinID = parentWinID+";"+childWinID+";"+subChildWinID;
	}
	return WinID;
	}
	public void switchToWindow(String WinID)
	{
		BaseClass.driver.switchTo().window(WinID);
	}
	
}
