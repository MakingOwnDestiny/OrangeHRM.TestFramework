package TestCases;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.mongodb.diagnostics.logging.Logger;
import com.relevantcodes.extentreports.LogStatus;

import Configuration.Log4jInFile;
import LibraryFiles.ReusableLibraryFile;
import ObjectRepository.LoginPage;

public class TC_LoginToPage extends ReusableLibraryFile{	
	
	/*public void LoginToTheApplication() throws InterruptedException
	{
		WebElement user = driver.findElement(LoginPage.username);
		user.sendKeys("Admin");
		WebElement pass = driver.findElement(LoginPage.password);
		pass.sendKeys("admin123");
		WebElement submit = driver.findElement(LoginPage.LoginBtn);
		submit.click();
		Thread.sleep(3000);
	}*/
	public void LoginToTheApplication() throws IOException, InterruptedException{
		Log4jInFile.LOG.info("start of testcase");
		String username =  GetPropertyFileValue("UserName");
		String password = GetPropertyFileValue("Password");
		logger.log(LogStatus.INFO, "Entering Credential");
		SendValueToInputControl(LoginPage.username, username);
		SendValueToInputControl(LoginPage.password,password);
		WaitAndClickOnControl(LoginPage.LoginBtn);
		logger.log(LogStatus.INFO, "Logged in successfully");
		logger.log(LogStatus.INFO, "Simply printing in extent report");
		Log4jInFile.LOG.info("End of testcase");
		Thread.sleep(3000);
	}

}