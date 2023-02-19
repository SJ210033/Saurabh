<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.Calendar"%>
<%@page import=" com.project.ebill.Receiptno" %>


<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/x-icon" href="https://lh3.googleusercontent.com/p/AF1QipOf9Q4QU04s1UXiTbNPD1B-IY2jx1TXl9zlCbpo=s680-w680-h510">
<meta charset="ISO-8859-1">
<title>Registration</title>
<style>
.corner{
   padding-top: 20px;
text-align:auto 
 }
.center{
padding-left: 100px
}
.box {
  background-color: lightyellow;
  width: 300px;
  border: 2px solid black;
  padding: 25px;
  margin: auto;
}
</style>
</head>
<body>

<%Receiptno rn=new Receiptno(); %>
<div class="box">
<h1 style="text-align:center;border-bottom: solid black;border-style: double;"> Ebill </h1>
<p style="text-align:left;">Receipt No :<%=rn.receipt() %> </p>
<p id="myId" style="text-align:left;"></p>
<form action="ebill" method="post">
<div class="corner:">
<label for="fname">First name:</label>
<input type="text" required pattern="[A-Za-z ]+" id="fname" name="fname" class="center"><br><br>
<label for="lname">Last name:</label>
<input type="text" required pattern="[A-Za-z ]+" id="lname" name="lname" class="center"><br><br>
<label for="dno">Door no:</label>
<input type="text" id="dno" name="dno" class="center"><br><br>
<label for="street">Street:</label>
<input type="text" required pattern="[A-Za-z0-9 ]+" id="street" name="street" class="center"><br><br>
<label for="city">City:</label>
<input type="text" required pattern="[A-Za-z ]+" id="city" name="city" class="center"><br><br>
<label for="state">State:</label>
<input type="text" required pattern="[A-Za-z ]+" id="state" name="state" class="center"><br><br>
<label for="pincode">Pincode:</label>
<input type="text" required pattern="[0-9]+"id="pincode" name="pincode" class="center"><br><br>
<label for="course">Course </label><br>
<select id="course" name="course">
  <option value="Java">JAVA</option>
  <option value="Python">PYTHON</option>
  <option value="C++">C++</option>
  <option value="Html">HTML</option>
<option value="other">OTHER</option>
</select><br>
<input type="text" id="otherInput" style="display:none">
<br>
<label for="mop">Mode Of Payment:</label>
<select name="mop" id="mop">
 <option value="UPI">UPI</option>
 <option value="cash">CASH</option>
</select><br><br>
<label for="comment">Comments:</label>
<input type="text" required pattern="[A-Za-z ]+" id="comment" name="comment" class="center"><br><br>
<label for="fees">Fees:</label>
<input type="text" required pattern="[0-9]+" id="fees" name="fees" class="center"><br><br>
<input type="submit" value="Submit"style="margin-left:100px" style="height:50px;width:50px;">
</div>

</form>
</div>
<script> 
var date = new Date(); 
var dd = date.getDate(); 
var mm = date.getMonth() + 1; 
var yyyy = date.getFullYear(); 
var newDate = "DATE :" + dd + "/" + mm + "/" +yyyy; 
var p = document.getElementById("myId"); 
p.innerHTML = newDate; 
</script>
<script>
  var select = document.getElementById("course");
  var input = document.getElementById("otherInput");
  select.addEventListener("change", function() {
    if (select.value === "other") {
      input.style.display = "block";
    } else {
      input.style.display = "none";
    }
  });
  </script>
 
<body >
</body>
</html>