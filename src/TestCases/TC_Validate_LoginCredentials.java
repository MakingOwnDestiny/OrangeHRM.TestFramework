package TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

import LibraryFiles.ReusableLibraryFile;
import ObjectRepository.LoginPage;

public class TC_Validate_LoginCredentials extends ReusableLibraryFile{
	
	public static String filePath ="C:\\Users\\Sundarii\\workspace\\Gouri.OrangeHRM.QA.TestFamework\\TestData\\Excel_Book1.xlsx"; 
	public void ValidateLogin_FromExcelData () throws IOException, InterruptedException{
		
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		//XSSFSheet sheet = workbook.getSheet("Credential_List");
		int rowSize = sheet.getLastRowNum();
		System.out.println("Total number of users are - "+rowSize);
		//System.out.println("List of Credentials are -->");
		for(int rowNum=1;rowNum<=rowSize;rowNum++){
			for(int colNum=1;colNum==1;colNum++){
				
				Row row = sheet.getRow(rowNum);
				String username = row.getCell(0).getStringCellValue();				
				String password = row.getCell(colNum).getStringCellValue();
				// String cellValue = sheet.getRow(rowNum).getCell(0).getStringCellValue();
				//System.out.println("Username : "+username +"\t Password :"+ password);	
				Thread.sleep(2000);
				System.out.println("Trying with "+rowNum+"th credential");
				SendValueToInputControl(LoginPage.username,username);
				SendValueToInputControl(LoginPage.password,password);
				WaitAndClickOnControl(LoginPage.LoginBtn);
				Thread.sleep(2000);
				List <WebElement> element = driver.findElements(LoginPage.invalid_Credentials);
				if (element.isEmpty()){
					System.out.println("Entered Credentials is valid : \n Username : "+username +"\tPassword :"+ password);
					WaitAndClickOnControl(TC_LogoutPage.welcomeAdmin);
					WaitAndClickOnControl(TC_LogoutPage.logoutfromAppliation);
				}
				else{
					System.out.println("Invalid Credentials entered :\n Username : "+username +"\tPassword :"+ password);
				}			
			}
		}
		 System.out.println("Closing the excel sheet");
		 workbook.close();
		}
		
	}
	
        
