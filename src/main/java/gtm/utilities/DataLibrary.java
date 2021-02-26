package gtm.utilities;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import gtm.ProjectSpecificMethod;

public class DataLibrary  extends ProjectSpecificMethod{
	
	public Object[][] readExcelData() throws IOException{
		XSSFWorkbook book = new XSSFWorkbook("./data/gtmdata.xlsx");
		XSSFSheet sheet = book.getSheetAt(0);
		int countRow = sheet.getLastRowNum();
		XSSFRow firstRow = sheet.getRow(0);
		int countCol = firstRow.getLastCellNum();
		Object[][] data = new Object[countRow][countCol];
		for (int i = 1; i <=countRow; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < countCol; j++) {
				XSSFCell cell = row.getCell(j);
				String val= cell.getStringCellValue();
				data[i-1][j] = val;
			}
		}
		book.close();
		return data;
		
	}

}
