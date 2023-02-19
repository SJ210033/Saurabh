package com.project.ebill;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;


@SuppressWarnings("unused")
public class Ebill extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
   
    public Ebill() {
        super();
   
    }
    public static boolean isEmpty(String string) {
	    return (string == null || string.isEmpty());
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	Receiptno rn=new Receiptno();
    	PrintWriter writer = response.getWriter();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String dno = request.getParameter("dno");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String mop = request.getParameter("mop");
		String comment = request.getParameter("comment");
		String pincode = request.getParameter("pincode");
		String fees = request.getParameter("fees");
		String course=request.getParameter("course");
		String total=fees;
		String name=fname + " "+lname;
		String address=dno +"\n" +street + "\n" +city+"\n"+state;
		if(isEmpty(name)||isEmpty(address)||isEmpty(comment)||isEmpty(pincode)||isEmpty(fees))
		{
			writer.println("Invalid Input");
		}
		
	    InputReader ir=new InputReader();
		PdfProcessor pp=new PdfProcessor(ir);
		String Receipt=rn.receipt();
		ir.setReceiptno(rn.receipt());
		ir.setName(name);
		ir.setAddress(address);
		ir.setModeOfPayment(mop);
		ir.setComments(comment);
		ir.setFees(fees);
		ir.setCourse(course);
		ir.setTotal(total);
		pp.convert();
		String Filename=pp.Filename();
		Connection conn1= null;
		PreparedStatement preparedStatement1 = null;
	    String query1 = "insert into register" +"(receiptno,bill) " +"values (?,?)";
		try 
		{
		conn1=DbConnect.getConnect();
		preparedStatement1 = conn1.prepareStatement(query1);
		preparedStatement1.setString(1,rn.receipt());
		preparedStatement1.setString(2,pp.Filename());
		preparedStatement1.executeUpdate();
		preparedStatement1.close();
		conn1.close();
		}
		catch(Exception e)
		{
			System.out.println("Connection to database error 2");
		}	
		request.setAttribute("fn",Filename);
		request.getRequestDispatcher("pdfdisplay.jsp").forward(request, response);
	    writer.close();
    }
}
