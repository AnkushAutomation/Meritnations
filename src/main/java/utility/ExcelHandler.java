package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHandler {
	XSSFWorkbook wb;
	XSSFSheet sheet;
	public ExcelHandler(String wbName, String sheetName) {
		
		try {
			File location = new File("./src/test/resources/"+wbName+".xlsx");
			FileInputStream fin = new FileInputStream(location);
			wb = new XSSFWorkbook(fin);
			sheet = wb.getSheet(sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public int getRowCount() {
		return sheet.getLastRowNum()+1;
	}
	
	public String getCellData(int row, int col) {
		XSSFCell cell = sheet.getRow(row).getCell(col);
		cell.setCellType(CellType.STRING);
		return cell.getStringCellValue();
	}

}
