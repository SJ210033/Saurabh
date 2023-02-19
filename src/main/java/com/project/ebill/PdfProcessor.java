package com.project.ebill;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
@SuppressWarnings("unused")
public class PdfProcessor
{
    public InputReader ir;
	public PdfProcessor(InputReader ir)
	{
	  this.ir=ir;
	  
	}
	public String Filename()
	{
        String Filename="e:\\Ebill\\" + ir.getName() +ir.getReceiptno()  + ".pdf";
		return Filename;
	}
	public void convert() 
	{
		Document document = new Document(new com.itextpdf.text.Rectangle(800,600));
		try
		{
			Date date = new Date();
		    Calendar calendar = Calendar.getInstance();
		    calendar.setTime(date);
		    int year = calendar.get(Calendar.YEAR);
		    int month = calendar.get(Calendar.MONTH)+1;
		    int day = calendar.get(Calendar.DAY_OF_MONTH);
            String dates= day +"/"+month+"/"+year;
		    String Filename="E:\\Ebill\\" +ir.getName()+ir.getReceiptno()+ ".pdf";
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(Filename));
			document.open();
			Image image1 = Image.getInstance("E:\\infinity.jpg");
			image1.setAbsolutePosition(350f, 475f);
            image1.scaleAbsolute(125, 125);
			document.add(image1);
			Font font = new Font(Font.FontFamily.HELVETICA, 8);
			Font font1 = new Font(Font.FontFamily.HELVETICA, 22,Font.BOLD);
			Font font2 = new Font(Font.FontFamily.HELVETICA, 14);
			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph p = new Paragraph(" An Unit of",font);
			p.add(new Chunk(glue));
			p.add("F37,1'st Floor, \n");
			p.add("InfinityLoop Innovation Pvt Ltd.,");
			p.add(new Chunk(glue));
			p.add("Fairlands Murgan Temple Road, \n ");
			p.add("Reg.With Ministry Of Corporate Affairs-India");
			p.add(new Chunk(glue));			
			p.add("Fairlands ,Salem, \n ");
			p.add("CIN-U72900TZ2022PTC039652");
			p.add(new Chunk(glue));			
			p.add("Tamilnadu-636016, \n ");
			p.add("0427 7968112 | +91 70109 75779 \n academy@infinityloopsolutions.com \n www.infinityloopsolutions.com");
			document.add(p);
			Paragraph p1 = new Paragraph("InfinityLoop Academy \n\n",font1);
			p1.setAlignment(Element.ALIGN_CENTER);
			document.add(p1);
			LineSeparator line = new LineSeparator();
			line.setLineWidth(2);
            document.add(line);
			Paragraph p2 = new Paragraph("\n**Please keep the bill safely till the course completion as proof for your payment.Company is not responsible if your bill is lost.",font);
            Paragraph p3= new Paragraph("Counsellor",font2);
            p3.setAlignment(Element.ALIGN_RIGHT);
            PdfPTable table1 = new PdfPTable(1);
			PdfPTable table = new PdfPTable(2);
			PdfPTable table0=new PdfPTable(2);
			table1.setWidthPercentage(10);
			table1.setSpacingBefore(20f);
			table1.setSpacingAfter(5f);
			table.setWidthPercentage(75);
			table.setSpacingBefore(5f);
			table.setSpacingAfter(10f);
			float[] columnWidths = { 10f, 10f };
			table0.setWidths(columnWidths);
			table0.setWidthPercentage(75);
			table0.setSpacingBefore(5f);
			table0.setSpacingAfter(5f);
			table0.setWidths(columnWidths);
			Phrase c0=new Phrase("Receipt",FontFactory.getFont( FontFactory.TIMES_ROMAN, 14, Font.BOLD));
			Phrase c1=new Phrase("Receipt No : "+ir.getReceiptno(),FontFactory.getFont( FontFactory.TIMES_ROMAN, 14, Font.BOLD));
			Phrase c2=new Phrase("Date : "+dates,FontFactory.getFont( FontFactory.TIMES_ROMAN, 14, Font.BOLD));
			Phrase c3=new Phrase("Name & Address",FontFactory.getFont( FontFactory.TIMES_ROMAN, 14, Font.BOLD));
			Phrase c4=new Phrase("Course Details",FontFactory.getFont( FontFactory.TIMES_ROMAN, 14, Font.BOLD));
			Phrase c7=new Phrase("Mode of Payment",FontFactory.getFont( FontFactory.TIMES_ROMAN, 14, Font.BOLD));
			Phrase c9=new Phrase("Particulars",FontFactory.getFont( FontFactory.TIMES_ROMAN, 14, Font.BOLD));
			Phrase c10=new Phrase("Amount",FontFactory.getFont( FontFactory.TIMES_ROMAN, 14, Font.BOLD));
			Phrase c13=new Phrase("Total",FontFactory.getFont( FontFactory.TIMES_ROMAN, 14, Font.BOLD));
			PdfPCell cell0 = new PdfPCell(new Paragraph(c0));
			PdfPCell cell1 = new PdfPCell(new Paragraph(c1));
			PdfPCell cell2 = new PdfPCell(new Paragraph(c2));
			PdfPCell cell3 = new PdfPCell(new Paragraph(c3));
			PdfPCell cell4 = new PdfPCell(new Paragraph(c4));
			PdfPCell cell5 = new PdfPCell(new Paragraph(ir.getName()+"\n"+ir.getAddress()));
			PdfPCell cell6 = new PdfPCell(new Paragraph(ir.getCourse()));
            PdfPCell cell7 = new PdfPCell(new Paragraph(c7));
			PdfPCell cell8 = new PdfPCell(new Paragraph(ir.getModeOfPayment()));
			PdfPCell cell9 = new PdfPCell(new Paragraph(c9));
			PdfPCell cell10 = new PdfPCell(new Paragraph(c10));
			PdfPCell cell11= new PdfPCell(new Paragraph(ir.getComments()));
			PdfPCell cell12= new PdfPCell(new Paragraph(ir.getFees()));
			PdfPCell cell13= new PdfPCell(new Paragraph(c13));
			PdfPCell cell14 = new PdfPCell(new Paragraph(ir.getTotal()));
			cell0.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
	        cell0.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
			cell1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
	        cell1.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
	        cell2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
	        cell2.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
	        cell3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
	        cell3.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
	        cell4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
	        cell4.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
	        cell5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
	        cell5.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
	        cell6.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
	        cell6.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
	        cell7.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
	        cell7.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
	        cell8.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
	        cell8.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
	        cell9.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
	        cell9.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
	        cell10.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
	        cell10.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
	        cell11.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
	        cell11.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
	        cell12.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
	        cell12.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
	        cell13.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
	        cell13.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
	        cell14.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
	        cell14.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
	        cell0.setFixedHeight(30);
			cell1.setFixedHeight(30);
			cell2.setFixedHeight(30);
			cell3.setFixedHeight(30);
			cell4.setFixedHeight(30);
			cell5.setFixedHeight(70);
			cell6.setFixedHeight(70);
			cell7.setFixedHeight(30);
			cell8.setFixedHeight(30);
			cell9.setFixedHeight(30);
			cell10.setFixedHeight(30);
			cell11.setFixedHeight(30);
			cell12.setFixedHeight(30);
			cell13.setFixedHeight(30);
			cell14.setFixedHeight(30);
			table1.addCell(cell0).setBorderWidth(2);;
			table0.addCell(cell1).setBorderWidth(2);
			table0.addCell(cell2).setBorderWidth(2);
			table.addCell(cell3).setBorderWidth(2);
			table.addCell(cell4).setBorderWidth(2);
			table.addCell(cell5).setBorderWidth(2);
			table.addCell(cell6).setBorderWidth(2);
			table.addCell(cell7).setBorderWidth(2);
			table.addCell(cell8).setBorderWidth(2);
			table.addCell(cell9).setBorderWidth(2);
			table.addCell(cell10).setBorderWidth(2);
			table.addCell(cell11).setBorderWidth(2);
			table.addCell(cell12).setBorderWidth(2);
			table.addCell(cell13).setBorderWidth(2);
			table.addCell(cell14).setBorderWidth(2);
			document.add(table1);
			document.add(table0);
			document.add(table);
            document.add(p2);
            document.add(p3);
            document.close();
			writer.close();
		}
		catch(Exception e)
		{
			System.out.println("Error in creating Pdf");
		}
}}
