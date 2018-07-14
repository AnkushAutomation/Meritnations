package dataProvider;

import org.testng.annotations.DataProvider;

import utility.ExcelHandler;

public class DataProviderForLogin {
	
	@DataProvider(name = "Credentials")
	public Object[][] passCredentials(){
		ExcelHandler config = new ExcelHandler("TestDataNew", "Ankush");
		int rows = config.getRowCount();
		Object[][] data = new Object[rows-1][3];
		for(int row=1; row<rows; row++) {
			data[row-1][0] = config.getCellData(row, 0);
			data[row-1][1] = config.getCellData(row, 1);
			data[row-1][2] = config.getCellData(row, 2);
		}
		return data;
	}

}
