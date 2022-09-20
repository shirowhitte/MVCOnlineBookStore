package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyDBConnect {
	public static Connection dbConnect()
	{
		Connection conn = null;
		try {
			//step 1
	
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//step 2
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dbuser","dbuser");
			if(conn!=null){
				System.out.println("DB connected successfully!!");
			}
			else{
				System.out.println("Sorry..!! Something went wrong");
			}

	
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
	