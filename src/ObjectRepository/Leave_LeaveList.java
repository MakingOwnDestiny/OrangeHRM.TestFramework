package ObjectRepository;

import org.openqa.selenium.By;

public class Leave_LeaveList {
	public static final By link_Dashboard = By.xpath("//a [. = 'Dashboard']");
	public static final By clickOn_LeaveList = By.xpath("//span [text() = 'Leave List']");
	public static final By clickOn_LeaveFrom = By.xpath("//input [@id = 'calFromDate']");
	public static final By clickOn_YearPicker = By.xpath("//select [@class= 'ui-datepicker-year']");
	public static final By select_Year = By.xpath("//option[text()= '2018']");
	public static final By select_Month = By.xpath("//select[@class= 'ui-datepicker-month']");
	public static final By select_Month_Value = By.xpath("//option [@value= '9']");
	public static final By select_Date = By.xpath("//a[text()= '4']");
	public static final By clickOn_LeaveTo = By.xpath("//input [@id = 'calToDate']");
	public static final By clickOn_random = By.xpath("//label[text()= 'To']");
	
	public static final By allTypesOfLeave_CheckBox = By.xpath("//input [@id = 'leaveList_chkSearchFilter_checkboxgroup_allcheck']");
	public static final By enterEmployeeName_ToSearch = By.xpath("//input [@id = 'leaveList_txtEmployee_empName']");
	public static final By clickOn_EmployeeName_ToSearch =By.xpath("//strong [text()= 'John Smith']");
	public static final By enterEmployee_SubUnit = By.xpath("//select[@id = 'leaveList_cmbSubunit']");
	public static final By enterEmployee_SubUnit_Value = By.xpath("//option[text () = 'All']");
	public static final By clickOn_SearchBox = By.xpath("//input [@id= 'btnSearch']");
	
	public static final By scrollTill_TableVisibility = By.xpath("//table [@id = 'resultTable']");	
	

}
