package ObjectRepository;

import org.openqa.selenium.By;

public class LeavePage {
	
	public static final By LeaveTab = By.xpath("//a [. = 'Leave']");
	public static final By Leave_Entitlements = By.xpath("//a [. = 'Entitlements']");	
	public static final By Leave_Reports = By.xpath("//a [. = 'Entitlements'] /../following-sibling::*[position()=1] //a [. = 'Reports']");
	public static final By Leave_AssignLeave = By.xpath("//a [text() = 'Assign Leave']");	
	
}
