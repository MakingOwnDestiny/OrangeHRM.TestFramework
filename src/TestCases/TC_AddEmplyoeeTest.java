package TestCases;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import LibraryFiles.ReusableLibraryFile;
import ObjectRepository.AddEmployeePage;

public class TC_AddEmplyoeeTest extends ReusableLibraryFile {
	
	public void ValidateScenarioToAddEmployee() throws IOException, InterruptedException{
		
		TC_LoginToPage obj_LoginToPage= new TC_LoginToPage();
		obj_LoginToPage.LoginToTheApplication();
		System.out.println("Fillinf the required details:");
		WaitAndClickOnControl(AddEmployeePage.clickOn_PIMTab);
		WaitAndClickOnControl(AddEmployeePage.clickOn_addEmployeeSubTab);
		SendValueToInputControl(AddEmployeePage.enterText_FirstName, "Gouri");
		SendValueToInputControl(AddEmployeePage.enterText_MiddleName, "Sankar");
		SendValueToInputControl(AddEmployeePage.enterText_LastName, "Das");
		SendValueToInputControl(AddEmployeePage.clickOn_ChooseFileFor_Photograph,"C:\\Users\\Sundarii\\Desktop\\IMG_3223 .jpg");
		Thread.sleep(5000);			
		WaitAndClickOnControl(AddEmployeePage.clickOn_Save_Button);		
		System.out.println("Employee Added Successfully");
		
		
	}
	
}
