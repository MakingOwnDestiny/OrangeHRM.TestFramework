package TestCases;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.relevantcodes.extentreports.LogStatus;

import LibraryFiles.ReusableLibraryFile;

public class TC_VerifyReadExcelData extends ReusableLibraryFile {
	public String filePath ="C:\\Users\\Sundarii\\workspace\\Gouri.OrangeHRM.QA.TestFamework\\TestData\\Excel_Book1.xlsx";
	public String strData = "Valid";
    public void excelReadData() throws IOException{
    	 //String filePath ="C:\\Users\\Sundarii\\workspace\\Gouri.OrangeHRM.QA.TestFamework\\TestData\\Excel_Book1.xlsx";
    	 readExcelData(filePath);
    }	
    public void excelWriteData() throws IOException{
   	    // String filePath ="C:\\Users\\Sundarii\\workspace\\Gouri.OrangeHRM.QA.TestFamework\\TestData\\Excel_Book1.xlsx";
   	     writeExcelData(filePath,strData);
    }
    
    public void excelRowCount() throws IOException{
    	int numberOfRows=getRowCount(filePath, "Credential_List");
    	System.out.println("Number of rows present in the excel sheet is - "+numberOfRows);
    	logger.log(LogStatus.INFO, "Verification Successful");
    }
    public void setBlankCellInExcel() throws IOException{
    	System.out.println("Setting the blank cell");
    	setNullIfCellEmpty(filePath,"Credential_List","NIL"); 	
    }
    public void excelSheetCreation() throws IOException{
    	System.out.println("Creating Additioanl Excel sheet");
    	additionalExcelSheetCreate(filePath, "MTP_Reports");
    }
    public void excelSheetCopyAndPaste() throws IOException{
    	System.out.println("Copy and paste between sheets");
    	Random random = new Random();
        String sheetname = "No_Microsoft_PLS_"+ random.nextInt(1000);
    	createSheetAndPastePreviousSheetContents(filePath, "Credential_List", sheetname);
    }
 }
	 