package com.project.ebill;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Viewreciept extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
    public Viewreciept() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Connection conn = null;
		PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        String rn=request.getParameter("receiptno");
		String Filename = null;
		int length = rn.length();
		String billnumber=rn.substring(length - 4);
		int billno=Integer.parseInt(billnumber);
		try 
		{
		conn=DbConnect.getConnection();
		preparedStatement = conn.prepareStatement("select bill from register where billno = " + billno );
		resultSet=preparedStatement.executeQuery();
		while(resultSet.next())
		{
			if(resultSet.isLast())
			{
				Filename=resultSet.getString("bill");	
			}
		}
		}
		catch(Exception e)
		{
			System.out.println("Connection to database error");
		}
		PrintWriter writer=response.getWriter();
		writer.println(Filename);
		request.setAttribute("fn",Filename);
		request.getRequestDispatcher("pdfdisplay.jsp").forward(request, response);
		
	}

}
