package General;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class SampleListener implements ITestListener
{
	public void onTestFailure(ITestResult r)
	{
		String failedtestname=r.getMethod().getMethodName();
		EventFiringWebDriver edriver= new EventFiringWebDriver(BaseClass.driver);
		File srcfile=edriver.getScreenshotAs(OutputType.FILE);
		File dstfile= new File ("./Screenshot/" +failedtestname+ ".png");
		try
		{
			FileUtils.copyFile(srcfile, dstfile);
		}
		catch(IOException e)
		{
			
		}
		

	
		
	}

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult r) {
		String Successtestname=r.getMethod().getMethodName();
		EventFiringWebDriver edriver= new EventFiringWebDriver(BaseClass.driver);
		File srcfile=edriver.getScreenshotAs(OutputType.FILE);
		File dstfile= new File ("./Screenshot1/" +Successtestname+ ".png");
		try
		{
			FileUtils.copyFile(srcfile, dstfile);
		}
		catch(IOException e)
		{
			
		}
	}
}
