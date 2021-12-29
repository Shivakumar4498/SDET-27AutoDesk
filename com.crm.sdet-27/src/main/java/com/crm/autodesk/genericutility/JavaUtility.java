package com.crm.autodesk.genericutility;

import java.util.Date;
import java.util.Random;

/**
 * 
 * 
 * @author Shiavakumar S
 */
public class JavaUtility {
	/**
	 * Its used to generate random number
	 * @return int data
	 */
	public int getRandomNumber() 
	{
		Random random =new Random();
		int intRandom = random.nextInt(10000);
		return intRandom;
	}
	
	/**
	 * It is used to generate System date And Time
	 * @return String
	 */
	public String getSystemDateAndTime()
	{
		Date date = new Date();
		return date.toString();
	}
	
	/**
	 * It is used to generate date format YYYY-MM-DD
	 * @return
	 */
	public String getSystemDateWithFormat()
	
	{
		 Date date =new Date();
		 String dateAndTime = date.toString();
		 
		 String YYYY = dateAndTime.split(" ")[5];
		 String MM = dateAndTime.split(" ")[2];
		 int DD = date.getMonth()+1;	
		 
		 String finalFormat = YYYY +"-"+MM+"-"+DD;
		 return finalFormat;
	}
}
