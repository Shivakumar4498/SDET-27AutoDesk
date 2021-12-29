package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPracticeTest {
	
	
	
	@Test (dataProvider ="getData")
	public void readDataFromDataProviderTest(String Name, int launchyear)
	{
		System.out.println("BrandNameAndModel---->"+Name+"----->Launch Year----->"+launchyear+"");
	}
	
	@DataProvider
	public Object [][] getData()
	{
		Object [][] objArr = new Object [3][2];
		
		objArr[0][0] = "Hyundai i20";
		objArr[0][1] = 2021;
		
		objArr[1][0] = "Tata Altroz EV";
		objArr[1][1] = 2022;
		
		objArr[2][0] = "Maruti Suzuki Swift";
		objArr[2][1] = 2023;
		return objArr;
		
	}

} 
