package com.project.ebill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

public class Receiptno {
	public String receipt() {
		
	Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
   
	int billno = 0;
	String Receiptno = null;

	Connection conn = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet;
	String query = "select billno from register";
	try 
	{
	conn=DbConnect.getConnection();
	preparedStatement = conn.prepareStatement(query);
	resultSet=preparedStatement.executeQuery();
	while(resultSet.next())
	{
		if(resultSet.isLast())
		{
			billno=resultSet.getInt("billno")+1;	
		}
	}
	String billnumber = String.format("%04d",billno);
    Receiptno=year+"-"+billnumber;

	}
	catch(Exception e)
	{
		System.out.println("Connection to database error 1");
	}
return Receiptno;
}
	}

