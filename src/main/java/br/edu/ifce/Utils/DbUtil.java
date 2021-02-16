package br.edu.ifce.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	static Connection connection;
	
	public static Connection getConnection() {
	if (connection != null) {
		return connection;
	}else {
	String url = "jdbc:mysql://localhost:3306/";
	String dbName ="twjbd"; 
	String uname = "admin";
	String pwd = "adminTWJ2020";
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(url+dbName,uname,pwd);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return connection;
	}
	}
}
