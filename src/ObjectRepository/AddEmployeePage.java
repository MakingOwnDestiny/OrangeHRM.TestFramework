package ObjectRepository;

import org.openqa.selenium.By;

public class AddEmployeePage {
	
	public static final By clickOn_PIMTab = By.xpath("//a [.= 'PIM']");
	public static final By clickOn_addEmployeeSubTab = By.xpath("//a [text()= 'Add Employee']");
	
	public static final By enterText_FirstName = By.xpath("//input [@id= 'firstName']");
	public static final By enterText_MiddleName = By.xpath("//input [@id= 'middleName']");
	public static final By enterText_LastName = By.xpath("//input [@id= 'lastName']");
	
	public static final By doubleClick_On_EmployeeId = By.xpath("//input [@id= 'employeeId']");
	public static final By clickOn_ChooseFileFor_Photograph = By.xpath("//input [@id= 'photofile']");
	
	public static final By clickOn_CreateLoginDetails_CheckBox = By.xpath("//input [@id= 'chkLogin']");
	
	public static final By enterTexto_UserName = By.xpath("//input [@id= 'user_name']");
	public static final By enterTexto_Password = By.xpath("////input [@id= 'user_password']");
	public static final By enterTextTo_Confirm_Password = By.xpath("//input [@id= 're_password']");
	public static final By clickOn_Status_Field = By.xpath("//select[@id= 'status']");
	public static final By clickOn_EnableStatus = By.xpath("//option [@value= 'Enabled']");
	public static final By clickOn_DisableStatus = By.xpath("//option [@value= 'Disabled']");
	
	public static final By clickOn_Save_Button = By.xpath("//input [@id= 'btnSave']");

	
	}
		
	

