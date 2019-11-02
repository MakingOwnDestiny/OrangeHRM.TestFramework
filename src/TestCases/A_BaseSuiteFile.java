package TestCases;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Configuration.Log4jInFile;
import LibraryFiles.ReusableLibraryFile;
import Configuration.TestListeners;
import Configuration.TestStatistics;
import ObjectRepository.AddEmployeePage;

@Listeners(Configuration.TestListeners.class)
public class A_BaseSuiteFile extends ReusableLibraryFile{
	
	//declare test class objects here
	TC_LoginToPage obj_LoginToPage;
	TC_AddEmplyoeeTest obj_addEmployeeTest;
	TC_CheckLeaveBalanceTest obj_CheckLeaveBalanceTest;
	TC_AssignLeaveTest obj_AssignLeaveTest;
	TC_EmpDesignationFromDirectory obj_EmpDesignationFromDirectory;
	TC_AdminPage_EmployeeDetails_Test obj_AdminPage_EmployeeDetails_Test;
	TC_AdminPage_EmpNatioanality_Test obj_AdminPage_EmpNatioanality_Test;
	TC_Validate_LoginCredentials obj_Validate_LoginCredentials;
	TC_ExcelReadWriteOHRM obj_ExcelReadWriteOHRM;
	TC_VerifyReadExcelData obj_VerifyReadExcelData;
	
  @BeforeSuite
  public void beforeSuite() {
	 
	 System.out.println("========Before Suite===========");
	 System.out.println("Test suite started");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("========After Suite===========");
	  System.out.println("Test suite Ends");
  } 
  
  @BeforeTest
  public void beforeTest()
  {
	  System.out.println("=======Before Test  =======");
	  Log4jInFile.LogFunction();
	  Log4jInFile.LOG.info("=======Starting new testcase here====== ");
	  
	  DateFormat df = new SimpleDateFormat("ddMMyy_HHmmss");
	  Date dateobj = new Date();
	  String subString = df.format(dateobj);
	  String WSpath = System.getProperty("user.dir");
	  String ExtentFilePath = WSpath+"\\TestReports\\HtmlReport_"+subString+".html";
	  
	  extent = new ExtentReports(ExtentFilePath, false);
	  extent.addSystemInfo("Environment","OrangeHRM");
	  extent.addSystemInfo("Username","Gouri Das");
	  extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	 
  }
  
  @BeforeClass 
  //instantiate object here
  public void beforeClass() {
	  System.out.println("=======Before Class=========");
	  System.out.println("Objects are getting created");
	  Log4jInFile.LOG.info("Instantiating test class object here");
	  obj_LoginToPage = new TC_LoginToPage();
	  obj_addEmployeeTest = new TC_AddEmplyoeeTest();
	  obj_CheckLeaveBalanceTest = new TC_CheckLeaveBalanceTest();
	  obj_AssignLeaveTest = new TC_AssignLeaveTest();
	  obj_EmpDesignationFromDirectory = new TC_EmpDesignationFromDirectory();
	  obj_AdminPage_EmployeeDetails_Test = new TC_AdminPage_EmployeeDetails_Test();
	  obj_AdminPage_EmpNatioanality_Test = new TC_AdminPage_EmpNatioanality_Test ();
	  obj_Validate_LoginCredentials = new TC_Validate_LoginCredentials();
	  obj_ExcelReadWriteOHRM = new TC_ExcelReadWriteOHRM();
	  obj_VerifyReadExcelData = new TC_VerifyReadExcelData();
  }
  
  @BeforeMethod
  public void beforeMethod(Method testMethod) throws IOException, InterruptedException {
	  System.out.println("========Before Method===========");
	  Log4jInFile.LOG.info("Entering B4 method and instantiating browser object");
	  OpenBrowserInstance();
	  extent.addSystemInfo("Browser", "Chrome");
	  logger = extent.startTest(testMethod.getName(),testMethod.getAnnotation(Test.class).description());
	  LaunchApplication();
  }
  
  @AfterMethod
  public void afterMethod(ITestResult result) throws InterruptedException, IOException {
	  System.out.println("========After Method=======");
	  if(result.getStatus()==ITestResult.FAILURE){
		  logger.log(LogStatus.INFO, "Testcase failed is: " +result.getName());
		  logger.log(LogStatus.INFO, "failure is: " +result.getThrowable());
	  }
	  else if(result.getStatus()==ITestResult.SKIP){
		  logger.log(LogStatus.INFO, "Testcase skipped is: " +result.getName());}
	  	  Log4jInFile.LOG.info("Entering after method and closing browser object");
	      //TakeScreenShot(result);
	  	  Thread.sleep(3000);
	  	  System.out.println("Closing driver instance");
	  	  driver.close();
	  	  extent.endTest(logger);
  }

  
  @AfterTest
  public static void afterTest()
  {
	  System.out.println("=======After Test=======");
	  Log4jInFile.LOG.info("Reached after test & closing extent object");
	  TestStatistics.printSuiteStatistics();
	  extent.flush();
	  extent.close();
  }

  /*Start of TestCases
   * 
   * ==========================================================================
   * ==========================================================================
   * ==========================================================================
   * 
   */
  
  @Test(enabled=true)
  public void LoginTest() throws InterruptedException, IOException
  {
	  System.out.println("======Test Case started===");
	  obj_LoginToPage.LoginToTheApplication();
  }
  
   @Test(enabled=false)
   public void ValidateScenarioToAddEmployee () throws IOException, InterruptedException
   {
	  System.out.println("=====Testing Adding an employee feature to the DB=====");
	  obj_addEmployeeTest.ValidateScenarioToAddEmployee();
   }
  
  @Test(enabled=false)
  public void VerifyAnEmployeeLeaveBalanceFromDashBoard() throws IOException, InterruptedException, AWTException
  {
	  System.out.println("Leave Balance from Dashboard test");
	  obj_CheckLeaveBalanceTest.VerifyAnEmployeeLeaveBalanceFromDashBoard();
  }
  
  @Test(enabled=false)
  public void ValidateScenarioToAssignLeaveToEmployee() throws IOException, InterruptedException
  {
	  System.out.println("Virifying Leave Assignment Test");
	  obj_AssignLeaveTest.verifyLeaveAssignment();
  }
  
  @Test(enabled=false)
  public void VerifyEmployeeDesignationFromDirectory() throws IOException, InterruptedException
  {
	  System.out.println("Vrifying Employee Designation");
	  obj_EmpDesignationFromDirectory.VerifyEmployeeDesignationFromDirectory();
	  	  
  }
  
  @Test(enabled=false)
  public void ValidateUserDetailsFromAdminTab() throws IOException, InterruptedException
  {
	  System.out.println("Verifying User Details from the Admin Tab");
	  obj_AdminPage_EmployeeDetails_Test.ValidateUserDetailsFromAdminTab();
  }
  
  @Test (enabled = false)
  public void validateNationalityFromAdminTab() throws IOException, InterruptedException
  {
	  System.out.println("Verifying Employee Nationality====");
	  obj_AdminPage_EmpNatioanality_Test.validateNationalityFromAdminTab();
  }
  
  @Test (enabled = false)
  public void ValidateLoginCredentialsfromExcelSheet() throws IOException, InterruptedException
  {
	  System.out.println("Verifying user credentials test====");
	  obj_Validate_LoginCredentials.ValidateLogin_FromExcelData();
  }
  
  @Test (enabled = false)
  public void ExcelReadandWriteCheck() throws IOException, InterruptedException
  {
      obj_ExcelReadWriteOHRM.ExcelOHRM();
  }
  
  @Test(enabled=false)
  public void readExcelDataThroughMethod() throws IOException
  {
	  obj_VerifyReadExcelData.excelReadData();
  }
  @Test(enabled=false)
  public void writeToExcelDataThroughMethod() throws IOException
  {
	  //obj_VerifyReadExcelData.excelWriteData();
	  logger.log(LogStatus.INFO, "Verifying Excel Operations");
	  //obj_VerifyReadExcelData.excelRowCount();
	  //obj_VerifyReadExcelData.setBlankCellInExcel();
	  //obj_VerifyReadExcelData.excelSheetCreation();
	  obj_VerifyReadExcelData.excelSheetCopyAndPaste();
  }
 
  
}
