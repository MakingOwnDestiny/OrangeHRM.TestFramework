package TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import LibraryFiles.ReusableLibraryFile;
import ObjectRepository.LeavePage;
import ObjectRepository.Leave_AssignLeave;

public class TC_AssignLeaveTest extends ReusableLibraryFile {
	
	public void verifyLeaveAssignment() throws IOException, InterruptedException{

		System.out.println("Logging to the application"); 
		TC_LoginToPage obj_LoginToPage= new TC_LoginToPage();
		obj_LoginToPage.LoginToTheApplication();
		
		System.out.print("Navigating to the Leave assign page");
		WaitAndClickOnControl(LeavePage.LeaveTab);
		WaitAndClickOnControl(LeavePage.Leave_AssignLeave);
		
		System.out.println("Filling required detailsa");
		SendValueToInputControl(Leave_AssignLeave.enterEmployeeName,"John Smith");
		SelectDropDownByVisibleText(Leave_AssignLeave.leaveTypeDropDown,"FMLA US");
		SendValueToInputControl(Leave_AssignLeave.leaveFromDate,"2019-10-09");
		SendValueToInputControl(Leave_AssignLeave.leaveToDate,"2019-10-09");
		WaitAndClickOnControl(By.xpath("//label [text() = 'From Date ']"));
		Assert.assertTrue(IsElementVisible(Leave_AssignLeave.leaveDuration), "Error: Duration should be available on page");
		SelectDropDownByVisibleText(Leave_AssignLeave.leaveDuration, "Half Day");
		SendValueToInputControl(Leave_AssignLeave.leaveRequest_Comment, "Teri Maa ben; Ghar jaa ra me");
		WaitAndClickOnControl(Leave_AssignLeave.assignLeaveButton);
		
		
		
	}

}
