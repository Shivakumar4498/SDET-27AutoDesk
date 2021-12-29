package practice;

import java.util.Date;

public class SystemDateAndTimeTest {

	public static void main(String[] args) 
	
	{
		Date date = new Date();
		System.out.println(date);
		
	}

	
	{
		Date date =new Date();
		 String dateAndTime = date.toString();
		 
		 String YYYY = dateAndTime.split(" ")[5];
		 String MM = dateAndTime.split(" ")[2];
		 int DD = date.getMonth()+1;	
		 
		 String finalformat = YYYY +"-"+MM+"-"+DD;
		 System.out.println(finalformat);

	}

}
