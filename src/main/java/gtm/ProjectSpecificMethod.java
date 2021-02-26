package gtm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import gtm.utilities.DataLibrary;
import gtm.utilities.Reporter;

public class ProjectSpecificMethod{
	public String excelFileName;
	public static ChromeDriver driver; 
	public int i = 0;
	public static boolean tagStatus;
	public static boolean tagExistingCheck;
	protected HashSet<String> dec=new HashSet<String>();  
	protected HashSet<String> sts=new HashSet<String>(); 

	
	
	
	@Parameters("url")
	@BeforeMethod
	public void launchBrowser(String url) {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
	@DataProvider(name="fetchdata")
	public Object[][] inputExcel() throws IOException {
		DataLibrary readData = new DataLibrary();
		Object[][] allData = readData.readExcelData();
		return allData;
	}
	

	
	
	public static void writeExcel(HashSet<String> Description, HashSet<String> Status) throws IOException {
		
		ArrayList<String> desc =new  ArrayList<String>(Description);
		ArrayList<String> status =new  ArrayList<String>(Status);
		
		String filepath="E:\\GTMreport.xlsx";
		System.out.println("Dec set size: "+Description.size());
		for (int j = 1; j <=Description.size(); j++) {
			if(j==1) {
				 File file = new File(filepath);
				 XSSFWorkbook wb = new XSSFWorkbook();
				 XSSFSheet sh = wb.createSheet("First Sheet");
				 //enter header
				 sh.createRow(0).createCell(0).setCellValue("S No");
				 sh.getRow(0).createCell(1).setCellValue("Tag Description");
				 sh.getRow(0).createCell(2).setCellValue("Tag Status");
				 
				 //enter status of tag

				 sh.createRow(j+1).createCell(0).setCellValue(j);
				 sh.getRow(j+1).createCell(1).setCellValue(desc.get(j));
				 sh.getRow(j+1).createCell(2).setCellValue(status.get(j));
				 
				 FileOutputStream fos = new FileOutputStream(file);
				 wb.write(fos);
				 System.out.println("created and entered successfully");

			}else {
				//open existing excel and add row
				
				FileInputStream inp = new FileInputStream(filepath); 
			    Workbook wb = WorkbookFactory.create(inp); 
			    org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheetAt(0); 
			    int num = sheet.getLastRowNum(); 
			    Row row = sheet.createRow(++num); 
			    row.createCell(0).setCellValue(j);
			    row.createCell(1).setCellValue(desc.get(j)); 
			    row.createCell(2).setCellValue(status.get(j)); 
			    
			        // Now this Write the output to a file 
			        FileOutputStream fileOut = new FileOutputStream(filepath); 
			    wb.write(fileOut); 
			    fileOut.close();
				
			}
		}
	}

	}

