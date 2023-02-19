package com.project.ebill;

public class InputReader {
	private String Receiptno;
	private String Name;
	private String Address;
	private String Course;
	private String Total;
	private String ModeOfPayment;
	private String Comments;
	private String Fees;

public String getReceiptno() {
	return Receiptno;
}

public void setReceiptno(String receiptno) {
	Receiptno = receiptno;
}

public void setName(String name) {
	Name = name;
}
public String getName() {
	return Name;
}
public void setAddress(String address) {
	Address = address;
}
public String getAddress() {
	return Address;
}
public String getCourse() {
	return Course;
}
public void setCourse(String course) {
	Course = course;
}
public String getTotal() {
	return Total;
}
public void setTotal(String total) {
	Total = total;
}
public void setModeOfPayment(String modeOfPayment) {
	ModeOfPayment = modeOfPayment;
}
public String getModeOfPayment() {
	return ModeOfPayment;
}
public void setComments(String comments) {
	Comments = comments;
}
public String getComments() {
	return Comments;
}
public void setFees(String fees) {
	Fees = fees;
}
public String getFees() {
	return Fees;
}
}
