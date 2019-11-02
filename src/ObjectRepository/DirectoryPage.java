package ObjectRepository;

import org.openqa.selenium.By;

public class DirectoryPage {

	public static final By tab_Directory = By.xpath("//a [.= 'Directory']");
	public static final By enterEmployeeName_Directory = By.xpath("//input[@id = 'searchDirectory_emp_name_empName']");
	public static final By jobTitle_Directory = By.xpath("//select[@id = 'searchDirectory_job_title']");
	public static final By jobLocation_Directory = By.xpath("//select[@id = 'searchDirectory_location']");
	public static final By searchButton_Directory = By.xpath("//input [@id = 'searchBtn']");
	public static final By designation_Directory = By.xpath("//li [text () = 'CEO']");
	
	
	
}
