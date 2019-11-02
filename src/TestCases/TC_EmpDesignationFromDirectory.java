package TestCases;

import java.io.IOException;

import org.openqa.selenium.support.ui.Wait;

import LibraryFiles.ReusableLibraryFile;
import ObjectRepository.DirectoryPage;

public class TC_EmpDesignationFromDirectory extends ReusableLibraryFile {
	
	public void VerifyEmployeeDesignationFromDirectory() throws IOException, InterruptedException{
		
		TC_LoginToPage obj = new TC_LoginToPage();
		obj.LoginToTheApplication();
		System.out.println("Navigating to the Search Directory Page");
		WaitAndClickOnControl(DirectoryPage.tab_Directory);
		SendValueToInputControl(DirectoryPage.enterEmployeeName_Directory, "John Smith");
		SelectDropDownByVisibleText(DirectoryPage.jobLocation_Directory, "All");
		SelectDropDownByVisibleText(DirectoryPage.jobLocation_Directory, "All");
		WaitAndClickOnControl(DirectoryPage.searchButton_Directory);
		String employee_Designation = getText(DirectoryPage.designation_Directory);
		System.out.println("Employee Designation found to be "+ employee_Designation);
		
		
		
	}

}
