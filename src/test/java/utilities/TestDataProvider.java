package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

	
	@DataProvider(name="TestDataprovider")
	public String[][] getData() throws IOException {
		
		String path = "./testdata/UserNameAndPassword_Rahul.xlsx";
		
		ExcelUtility xlutils = new ExcelUtility(path);
		
		int totalrows = xlutils.getRowCount("Sheet1");
		int totalcols = xlutils.getCellCount("Sheet1", 1);
		
		
		String loginData[][] = new String[totalrows][totalcols];
		
		for(int i=1; i<=totalrows; i++) {
			
			for(int j=0; j<totalcols; j++) {
				
				loginData[i-1][j] = xlutils.getCellData("Sheet2", i, j);
			}
		}
		
		return loginData;
		
		
	}
}
