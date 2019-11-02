package TestCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import LibraryFiles.ReusableLibraryFile;
import ObjectRepository.AdminPage;

public class TC_AdminPage_EmployeeDetails_Test extends ReusableLibraryFile {
	
	public void ValidateUserDetailsFromAdminTab () throws IOException, InterruptedException{
		
		TC_LoginToPage obj = new TC_LoginToPage();
		obj.LoginToTheApplication();
		WaitAndClickOnControl(AdminPage.adminTab);
		//SendValueToInputControl(AdminPage.adminTab_enterEmployeeName, "John Smith");
		WaitAndClickOnControl(AdminPage.adminTab_Search);
		Thread.sleep(1000);
		
		System.out.println("Scrolling operation about to perform");
		Thread.sleep(2000);
		WebElement element = driver.findElement(AdminPage.adminTab_Footer);
		Actions action = new Actions (driver);
		//action.sendKeys(Keys.PAGE_DOWN).build().perform();
		action.moveToElement(element).build().perform();;
		Thread.sleep(2000);		
		System.out.println("Validating User Data from the table");
		WebElement tableElement = driver.findElement(AdminPage.adminTab_TableData);
		List <WebElement> rowList = tableElement.findElements(By.tagName("tr"));
		int numberOfEmployeeFound = rowList.size();
		System.out.println("Number of employee with the entered name fetched is - "+ --numberOfEmployeeFound);
		for (int rowNumber=1;rowNumber<rowList.size();rowNumber++){
			List <WebElement> columnList =rowList.get(rowNumber).findElements(By.tagName("td"));
			for (int columnNumber=0;columnNumber<columnList.size();columnNumber++){				
				if (columnNumber==3) {
					System.out.println("User Name of "+columnList.get(columnNumber).getText()+ " is - " );
					
					String UserName = columnList.get(1).getText();
					System.out.println("      "+UserName);
				}
			}
		}
		
		
		
	}

	
	
	

}
