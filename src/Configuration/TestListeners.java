package Configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.TestResult;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import LibraryFiles.ReusableLibraryFile;

public class TestListeners implements ITestListener, ISuiteListener{
	
	public static List<ITestNGMethod> FailedTests = new ArrayList<ITestNGMethod>();
	public static List<ITestNGMethod> PassedTests = new ArrayList<ITestNGMethod>();
	public static List<ITestNGMethod> SkippedTests = new ArrayList<ITestNGMethod>();
	public static Date startDate;
	public static Date EndDate; 
	//This is just a comment


	public void onTestSuccess(ITestResult result) {
		System.out.println("The name of the testcase passed is :"+result.getName());
		Log4jInFile.LOG.info("Taking screen shot for the passed testcase");
		try {
			ReusableLibraryFile.TakeScreenShot(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		PassedTests.add(result.getMethod());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("The name of the testcase failed is :"+result.getName());
		Log4jInFile.LOG.info("Taking screen shot for the failed testcase");
		try {
			ReusableLibraryFile.TakeScreenShot(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FailedTests.add(result.getMethod());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("The name of the testcase skipped is :"+result.getName());
		Log4jInFile.LOG.info("Taking screen shot for the failed testcase");
		try {
			ReusableLibraryFile.TakeScreenShot(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SkippedTests.add(result.getMethod());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		EndDate = context.getEndDate();
		
	}
	
	public void onStart(ITestContext context) {
		startDate = context.getStartDate();
		
	}

	public void onStart(ISuite suite) {
	}

	public void onFinish(ISuite suite) {
		ReusableLibraryFile.driver.quit();
		System.out.println("Closing all browser instance");
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	}
}
