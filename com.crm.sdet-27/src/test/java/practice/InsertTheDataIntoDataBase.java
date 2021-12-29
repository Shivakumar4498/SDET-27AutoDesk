package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertTheDataIntoDataBase {

	public static void main(String[] args) throws Throwable {
		//register the database
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//Establish the connection with the database
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb3", "root", "root");
		
		//Issue the statement
		Statement statement = connection.createStatement();
		
		//Execute Querry
		int result = statement.executeUpdate("insert into studentinfo(fname,lname,address) value ('yashutosh','singh','india')");
		
		//verification
		if(result==1) {
			System.out.println("==>One set of data is added to database");
		}
		else
		{
			System.out.println("==>data is not added to database");
		}
		connection.close();
	}
}
