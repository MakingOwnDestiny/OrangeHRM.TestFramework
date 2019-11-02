package TestCases;

import java.io.IOException;
import java.util.List;

import javax.swing.ListCellRenderer;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import LibraryFiles.ReusableLibraryFile;
import ObjectRepository.AdminPage;

public class TC_AdminPage_EmpNatioanality_Test extends ReusableLibraryFile {
	
	public void validateNationalityFromAdminTab() throws IOException, InterruptedException{
		System.out.println("Loging into the application---");
		TC_LoginToPage obj = new TC_LoginToPage();
		obj.LoginToTheApplication();
		WaitAndClickOnControl(AdminPage.adminTab);
		WaitAndClickOnControl(AdminPage.adminTab_Nationality);
		
		WebElement tableElement = driver.findElement(AdminPage.adminTab_TableData);
		
		//ClickAgainstNationalityCheckBox(tableElement,"Indian");
		
		List <WebElement> rowList = tableElement.findElements(By.tagName("tr"));
		int numberOfAddedNatioality = rowList.size();
		System.out.println("Number of Natioanalities are - "+ --numberOfAddedNatioality);
		
		for(int rowNumber=1;rowNumber<rowList.size();rowNumber++){
			List <WebElement> columnList =rowList.get(rowNumber).findElements(By.tagName("td"));
			for (int columnNumber=0;columnNumber<columnList.size();columnNumber++){
				if(columnList.get(columnNumber).getText().equalsIgnoreCase("Indian")){
					Thread.sleep(2000);
					Actions action = new Actions(driver);
					WebElement  elm = columnList.get(columnNumber-1);
					action.moveToElement(elm);			
					Thread.sleep(2000);						
					if(!elm.isSelected())
					{
						elm.click();
						System.out.println("Clicked on the corresponding checkbox related to Indian");
						Thread.sleep(2000);
						break;
					}				
				}
				else{
					System.out.println("Entered Natioanlity not matching");
					break;
				}
			}
         }
		System.out.println("Natioanality Check has been successful");
		
	}
}

