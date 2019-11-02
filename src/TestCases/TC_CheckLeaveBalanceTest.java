package TestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import LibraryFiles.ReusableLibraryFile;
import ObjectRepository.Leave_LeaveList;

public class TC_CheckLeaveBalanceTest extends ReusableLibraryFile {
	
	public void VerifyAnEmployeeLeaveBalanceFromDashBoard() throws IOException, InterruptedException, AWTException{
		
		TC_LoginToPage obj_LoginToPage= new TC_LoginToPage();
		obj_LoginToPage.LoginToTheApplication();
		WebElement dashboard = driver.findElement(Leave_LeaveList.link_Dashboard);
		dashboard.click();
		WebElement leaveList = driver.findElement(Leave_LeaveList.clickOn_LeaveList);
		leaveList.click();
		WebElement Calendar_LeaveFrom = driver.findElement(Leave_LeaveList.clickOn_LeaveFrom);
		Calendar_LeaveFrom.click();
		WebElement pickYear = driver.findElement(Leave_LeaveList.clickOn_YearPicker);
		pickYear.click();
		WebElement selectYear = driver.findElement(Leave_LeaveList.select_Year);
		selectYear.click();
		
		driver.findElement(Leave_LeaveList.select_Month).click();
		driver.findElement(Leave_LeaveList.select_Month_Value).click();
		driver.findElement(Leave_LeaveList.select_Date).click();
		Thread.sleep(3000);
		String leaveToDate = "2019-10-04";	
		
		WebElement ToAddress = driver.findElement(Leave_LeaveList.clickOn_LeaveTo);
		ToAddress.clear();
		ToAddress.sendKeys(leaveToDate);
		driver.findElement(Leave_LeaveList.clickOn_random).click();
		
			
		WebElement verifyCheckbox_Clickable = driver.findElement(Leave_LeaveList.allTypesOfLeave_CheckBox);
		Thread.sleep(3000);
		if (!verifyCheckbox_Clickable.isSelected()){
			verifyCheckbox_Clickable.click();
		}
		
		
		driver.findElement(Leave_LeaveList.enterEmployeeName_ToSearch).sendKeys("John Smith");
		Thread.sleep(3000);
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(Leave_LeaveList.enterEmployee_SubUnit).click();
		
		driver.findElement(Leave_LeaveList.enterEmployee_SubUnit_Value).click();
		driver.findElement(Leave_LeaveList.clickOn_SearchBox).click();
		Thread.sleep(4000);
		
		
		
		WebElement tableElement = driver.findElement(Leave_LeaveList.scrollTill_TableVisibility);
		Thread.sleep(3000);
		/*System.out.println("Verifying scroll behavior");
		action.moveToElement(tableElement).build().perform();*/
		
		List <WebElement> allRows = tableElement.findElements(By.tagName("tr"));
		for(int row = 0;row < allRows.size(); row++){			
			List <WebElement> allColumns = allRows.get(row).findElements(By.tagName("td"));
			if (row == 0){
				System.out.println("Column Headings are - " + allRows.get(row).getText());				
			}
			for(int col=0;col<allColumns.size();col++){
				System.out.println("Table data found to be - "+ allColumns.get(col).getText());
				
			}
		}
		
		
		
		
		
		
		
	
		
	}

}
