package ObjectRepository;

import org.openqa.selenium.By;

public class Leave_AssignLeave {
	
	public static final By enterEmployeeName = By.xpath("//input [@id = 'assignleave_txtEmployee_empName']");
	public static final By leaveTypeDropDown = By.xpath("//select[@id = 'assignleave_txtLeaveType']");
	public static final By leaveFromDate = By.xpath("//input [@id = 'assignleave_txtFromDate']");
	public static final By leaveToDate = By.xpath("//input [@id = 'assignleave_txtToDate']");
	public static final By leaveRequest_Comment = By.xpath("//TEXTAREA[@id = 'assignleave_txtComment']");
	public static final By assignLeaveButton = By.xpath("//input[@id = 'assignBtn']");
	public static final By leaveBalance = By.xpath("//div[@id = 'assignleave_leaveBalance']");	
	public static final By leaveDuration = By.xpath("//select[@id='assignleave_duration_duration']");

}
