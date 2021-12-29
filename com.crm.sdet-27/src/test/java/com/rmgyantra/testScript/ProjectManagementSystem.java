package com.rmgyantra.testScript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;



public class ProjectManagementSystem {

	public static void main(String[] args) throws Throwable {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8084/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Login
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");  
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//click on Project
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		
		//create project
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		
		//project Details
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("Hyundai");
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Vinay");
		WebElement ele=driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		
		Select s = new Select(ele);
		s.selectByIndex(3);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//Verify in Database
		String project_name="Hyundai";
		
		Driver drive = new Driver();
		DriverManager.registerDriver(drive);
		//establish connection with DB
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		//issue the statement
		Statement statement = connection.createStatement();
		//Execute Querry
		ResultSet result = statement.executeQuery("select * from project");
		while(result.next()) {
			if (result.getString(4).equals(project_name)) {
				System.out.println("Passed");
			}
		}
		driver.quit();
		connection.close();
	}

}
