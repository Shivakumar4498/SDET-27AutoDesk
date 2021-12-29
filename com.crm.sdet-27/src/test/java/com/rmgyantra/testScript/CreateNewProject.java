package com.rmgyantra.testScript;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class CreateNewProject {

	public static void main(String[] args) throws Throwable 
	{
		Connection connection =null;
		try {
		Driver driver = new Driver();
		//register the database
		DriverManager.registerDriver(driver);
		//establish connection with database
		 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		//Issue the statement
		Statement statement = connection.createStatement();
		//Execute query
		int result = statement.executeUpdate("insert into project(project_id, created_by, created_on, project_name, status, team_size)value('TY_PROJ_222','Mohan', '16/12/2021', 'Nissan', 'On going','0' )");
		String expectedName="Maruti Suzuki";
		//Verification
		ResultSet res = statement.executeQuery("select * from project");
		while(res.next())
		{
			if(res.getString(4).equals(expectedName))
		
		{
			System.out.println("Passed==>Data is Present");
		}
			else
				System.out.println("Passed==>Data is not Present");
		}
	} 
		finally
	{
			connection.close();
	}

}
}
