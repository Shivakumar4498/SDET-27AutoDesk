package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class VerifyTheDataFromDataBase {

	public static void main(String[] args) throws Throwable {
	System.out.println("Start");
	String expectedfname="suhas";   
	//String expectedlname="singh";
	
	Driver driver = new Driver();
	DriverManager.registerDriver(driver);
	
	//Establish the connection with database
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb3","root","root");
	
	//Issue the statement
	Statement statement = connection.createStatement();

	//Execute Querries
	ResultSet result = statement.executeQuery("select * from studentinfo");
	while(result.next()) 
	{
		if (result.getString(2).equals(expectedfname))
			//if (result.getString(3).equals(expectedlname))
		{
			System.out.println("passed");
		}
	}
	//Close the data Base Connection
	connection.close();
	}

}
