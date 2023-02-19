<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/x-icon" href="https://lh3.googleusercontent.com/p/AF1QipOf9Q4QU04s1UXiTbNPD1B-IY2jx1TXl9zlCbpo=s680-w680-h510">
<meta charset="ISO-8859-1">
<title>View bill</title>
 <style>
      .container 
      {
        width: 500px;																
        height: 300px;
        background-color: lightyellow;
        border: 3px solid black;	
        text-align: center;																																																																														
        padding: 30px;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
      }
      h1
      {
      text-align: center;
      border-bottom: 6px solidblack;
      background-color: lightgrey;
      border-style: double;
      }     
    </style>
</head>
<body>
<div class="container">
      <h1>VIEW BILL</h1>
      <form action="viewreciept" method="post">
        <label for="receiptno" style="font-size: 25px;">Receipt no:</label>
        <input type="text" id="receiptno" name="receiptno"><br><br>
        <input type="submit" value="Submit" style="font-size: 20px;">
      </form>
</div>
</body>
</html>