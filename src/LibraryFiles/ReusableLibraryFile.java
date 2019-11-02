package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFFormulaEvaluator.SheetsFlushedException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class ReusableLibraryFile {
	
	//Global variables goes here
	public static WebDriver driver;
	String path = System.getProperty("user.dir");
	String PropertiesFilePath = path + "\\GlobalSettings.properties";
	
	public static ExtentTest logger;
	public static ExtentReports extent;
		
	public void OpenBrowserInstance() throws IOException
	{
		System.out.print("Setting chrome driver");
		System.setProperty("webdriver.chrome.driver", GetPropertyFileValue("ChromeDriverPath"));
		System.out.print("Opening browser instance");
		driver = new ChromeDriver();
		driver.manage().window().maximize();	
	}
	
	public String GetPropertyFileValue(String Key) throws IOException
	{
		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream(PropertiesFilePath);
		obj.load(objfile);
		String value = obj.getProperty(Key);
		return value;
	}
	
	public void LaunchApplication() throws IOException, InterruptedException
	{
		String Environment = GetPropertyFileValue("EnvironmentUrl");
		driver.get(Environment);
		Thread.sleep(2000);
	}
	
	public void WaitAndClickOnControl(By Element) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Element));
		driver.findElement(Element).click();
		Thread.sleep(1000);
	}
	
	public void SendValueToInputControl(By Element, String value) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Element));
		WebElement control = driver.findElement(Element);
		control.clear();
		Thread.sleep(1000);
		control.sendKeys(value);
		Thread.sleep(1000);
	}
	
	public boolean IsElementVisible(By Element) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Element));
		WebElement control = driver.findElement(Element);
		return control.isDisplayed();
	}
	
	public void SelectDropDownByVisibleText(By Element, String visibleText)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Element));
		WebElement element = driver.findElement(Element);
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}
	
	public static void TakeScreenShot(ITestResult result) throws IOException
	{
		String WSpath = System.getProperty("user.dir");
		String SnapPath = null;
		if(result.getStatus()==ITestResult.SUCCESS)
			SnapPath = WSpath+"\\ScreenShots\\Passed\\";
		else if(result.getStatus()==ITestResult.FAILURE || result.getStatus()==ITestResult.SKIP)
			SnapPath = WSpath+"\\ScreenShots\\Failed_Skipped\\";
		DateFormat df = new SimpleDateFormat("ddMMyy_HHmmss");
		Date dateobj = new Date();
		String subString = df.format(dateobj);
		File srcFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File(SnapPath+"SnapAt_"+subString+".png");
		FileUtils.copyFile(srcFile, destFile);
		String screenShotPath = destFile.getPath();
		logger.log(LogStatus.INFO, "Screen shot captured below: "+logger.addScreenCapture(screenShotPath));
	}
	
	
	public String getText(By Element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Element));
		String textToReturn =  driver.findElement(Element).getText();
		return textToReturn;	
	}
	
	public void readExcelData(String filePath) throws IOException
	{
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook fileName = new XSSFWorkbook(fis);
		XSSFSheet sheetName = fileName.getSheetAt(0);
		int rowSize = sheetName.getLastRowNum();
		for(int rowNum=0;rowNum<rowSize;rowNum++)
		{
			System.out.print("Excel values are - ");
			Row row = sheetName.getRow(rowNum);
			for(int colNum = 0;colNum<row.getLastCellNum();colNum++)
			{
				String strValue=row.getCell(colNum).getStringCellValue();
				System.out.print("\t "+strValue+ "\t");
			}
			System.out.println();
		}
		fileName.close();
	}
	public void writeExcelData(String filePath,String value) throws IOException
	{
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook fileName = new XSSFWorkbook(fis);
		XSSFSheet sheetName = fileName.getSheetAt(0);
		int rowSize = sheetName.getLastRowNum();
		int columnSize= sheetName.getRow(0).getLastCellNum();
		for(int rowNum=1;rowNum<=rowSize;rowNum++)
		{
			Row row = sheetName.getRow(rowNum);
			for(int colNum=0;colNum <= columnSize;colNum++){
				if(colNum == (columnSize-1))
				{
					sheetName.getRow(rowNum).createCell(colNum).setCellValue(value);
					break;
				}
				
			}
		}
		System.out.println(" Simply printing");
		FileOutputStream fos = new FileOutputStream(file);
		fileName.write(fos);
		System.out.println("Closing the excel sheet");
		fileName.close();
	}
	
	// Row count in a sheet
	public int getRowCount(String excelPath,String sheetName) throws IOException
	{
		File file = new File(excelPath);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int index=workbook.getSheetIndex(sheetName);
		XSSFSheet sheet=workbook.getSheetAt(index);
		int numberOfRows = sheet.getLastRowNum()+1;
		workbook.close();
		return numberOfRows;
	}
	//Set cell value as "NIL" if cell value is marked as blank
	public void setNullIfCellEmpty(String excelPath,String sheetName,String newValue) throws IOException
	{
		File file = new File(excelPath);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int index = workbook.getSheetIndex(sheetName);
		XSSFSheet sheet = workbook.getSheetAt(index);
		int row_Size=sheet.getLastRowNum();
		int col_Size=sheet.getRow(0).getLastCellNum();
		for(int row=0;row<row_Size;row++)
		{
			for(int column=0;column<col_Size;column++)
			{
				Cell cell = sheet.getRow(row).getCell(column);
				String cellValue = cell.toString();
				if(cellValue.equals(null)||cellValue.equals(""))
				{
					sheet.getRow(row).createCell(column).setCellValue(newValue);
				}
			}
			
		}
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		workbook.close();
	}
	//Create an additional sheet on the excel 
	public void additionalExcelSheetCreate(String excelPath,String sheetName) throws IOException
	{
		File file = new File(excelPath);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		workbook.createSheet(sheetName);
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		workbook.close();
	}
	public void createSheetAndPastePreviousSheetContents(String excelPath,String fromSheetName,String NewSheetName) throws IOException
	{
		File file = new File(excelPath);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int noOfSheets = workbook.getNumberOfSheets();
		System.out.println("Total number of sheets are - "+noOfSheets);
		int index = workbook.getSheetIndex(fromSheetName);
		XSSFSheet sheet1 = workbook.getSheetAt(index);
		workbook.createSheet(NewSheetName);
		int newSheetIndex=workbook.getSheetIndex(NewSheetName);
		XSSFSheet sheet2=workbook.getSheetAt(newSheetIndex);
		int row_Size=sheet1.getLastRowNum();
		int col_Size=sheet1.getRow(index).getLastCellNum();
		for(int row=0;row<row_Size;row++)
		{
			for(int column=0;column<col_Size;column++)
			{
				String cellValue = sheet1.getRow(row).getCell(column).getStringCellValue();
				sheet2.getRow(row).createCell(column).setCellValue(cellValue);
				System.out.println(cellValue);
			}
		}
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		workbook.close();		
	}
}
