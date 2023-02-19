<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=${encoding}"></head>
<%@page import="java.io.File"%>
<%@page import="java.io.*"%>
<%@page import="javax.servlet.*"%>
<%@page import="com.itextpdf.text.Image"%>
<%@page import="com.itextpdf.text.Document"%>
<%@page import="com.itextpdf.text.DocumentException"%>
<%@page import="com.itextpdf.text.pdf.PdfReader"%>
<%@page import="com.itextpdf.text.pdf.PdfImportedPage"%>
<%@page import="com.itextpdf.text.pdf.PdfWriter"%>
<%@page import="com.itextpdf.text.pdf.PdfContentByte"%>
<%@ page language="java" contentType="application/pdf; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String Filename = (String)request.getAttribute("fn");%>
<%
    try{
    response.reset();
    response.setContentType("application/pdf");
    File file = new File(Filename);
    response.setHeader("Content-Type", "application/pdf");
    response.setHeader("Content-Disposition","inline;Filename=Receipt.pdf");
    response.setContentLength((int) file.length());
    response.setHeader("Content-Type",getServletContext().getMimeType(file.getName()));
    response.setHeader("Content-Length", String.valueOf(file.length()));
    FileInputStream in = new FileInputStream(file);
    OutputStream outs = response.getOutputStream();
    response.setContentLength(in.available());
    byte[] buf = new byte[8192];
    int c = 0;
    try 
    {
        while ((c = in.read(buf, 0, buf.length)) > 0) 
        {
        outs.write(buf, 0, c);
        out.write(outs.toString());
        }

    } 
    catch (IOException ioe) 
    {
    	System.out.println("Input Output Error in Pdfdisplay");
    }
    finally 
    {
        outs.flush();
        outs.close();
        in.close();
    }}
catch(Exception e)
{
	System.out.println("Error in pdfdisplay"+e);
}
%>
</html>