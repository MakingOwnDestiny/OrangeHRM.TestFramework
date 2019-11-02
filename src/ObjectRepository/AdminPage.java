package ObjectRepository;

import org.openqa.selenium.By;

public class AdminPage {
	
	public static final By adminTab = By.xpath("//a [.= 'Admin']");
	public static final By adminTab_enterEmployeeName = By.xpath("//input [@id= 'searchSystemUser_employeeName_empName']");
	public static final By adminTab_Search = By.xpath("//input [@id = 'searchBtn']");
	public static final By adminTab_Footer = By.xpath("//div [@id = 'footer']");
	public static final By adminTab_TableData = By.xpath("//table [@id = 'resultTable']");
	public static final By adminTab_Nationality = By.xpath("//a [@id = 'menu_admin_nationality']");
	public static final By adminTab_NationalityTable = By.xpath("//table [@id = 'resultTable']");
	public static final By adminTab_AddNatioanlity = By.xpath("//input [@id = 'btnAdd']");
	public static final By adminTab_DeleteNatioanlity = By.xpath("//input [@id = 'btnDelete']");
	public static final By adminTab_EnterNewNationality = By.xpath("//input [@id = 'nationality_name']");
	public static final By adminTab_SaveButton = By.xpath("//input [@id = 'nationality_name']");
		
}
