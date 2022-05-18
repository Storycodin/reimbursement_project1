package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static String url = "jdbc:postgresql://${datachanUsername}/p1reimburs";
	private static String username = ${datachanUsername};
	private static String password = ${datachanPassword}";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
	//IF YOU WANT TO USE JDBC WITH A WAR PROJECT YOU NEED TO DO THE FOLLOWING:
    static { //(this would normally go into your dao layer)
          try {
              Class.forName("org.postgresql.Driver");
          }catch(ClassNotFoundException e) {
              e.printStackTrace();
              System.out.println("Static block has failed me");
          }
    }
    
    //add a test db and a new connection here(?)
}
