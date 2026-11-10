package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	
	@DataProvider(name="logindata")
	public String[][] getdata() throws IOException {
		
	String path = "./testdata/UserNameAndPassword_Rahul.xlsx";	
	
	ExcelUtility xlutils = new ExcelUtility(path);
	
	int totalrows = xlutils.getRowCount("Sheet1");
	int totalcols = xlutils.getCellCount("Sheet1", 1);
	
	
	String logindata[][] = new String[totalrows][totalcols];
	
	for(int i = 1; i<=totalrows; i++) {
		
		for(int j=0 ; j<totalcols; j++) {
			
			logindata[i-1][j] = xlutils.getCellData("Sheet1", i, j);
			
		}
	}
	
	return logindata;
	
	
		
	}
	
}
