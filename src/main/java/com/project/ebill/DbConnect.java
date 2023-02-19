package com.project.ebill;
import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect 
{
	private static final String DB_DRIVER = 
	           "com.mysql.jdbc.Driver";
private static final String DB_URL = 
	        "jdbc:mysql://localhost:3306/ebill";
private static final String DB_USERNAME = "root";
private static final String DB_PASSWORD = "root";

public static Connection getConnection()
{
	Connection conn = null;
	try
	{
		Class.forName(DB_DRIVER);
		conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
	}
	catch(Exception e)
	{
		System.out.println("Connection to database error");
	}
	return conn;
}	
public static Connection getConnect()
{
	Connection conn1 = null;
	try
	{
		Class.forName(DB_DRIVER);
		conn1 = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
	}
	catch(Exception e)
	{
		System.out.println("Connection to database error");
	}
	return conn1;
}	
}



