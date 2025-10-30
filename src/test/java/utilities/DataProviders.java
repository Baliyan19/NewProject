package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="LoginData")
	public String[][] LoginData()
	{
		String [][] data= {{"kashishbaliyan@gmail.com","19Justice@#","Valid"},
				{"kandsdkad@yahoo.com","aksdbdkjh","Invalid"},
				{"akdkkkak@gmail.com","akdjgk","Invalid"},
				{"abc123@gmail.com","test@123","Valid"}};
		return data;
	}
	
}
