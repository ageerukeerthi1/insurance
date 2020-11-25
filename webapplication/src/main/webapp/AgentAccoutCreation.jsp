<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	<div class = "accountbox">
	<h1>Account Creation</h1>
	<br>
	<form action = "AgentAccountCreationServlet" method = "post">
		<p>User Name</p>
		<input type = "text" name = "userName" pattern = "[A-Za-z][a-zA-Z0-9]{5,20}" title = "The insured name should contain letters and numbers with atleast 8 characters" required>
		<br><br><p>Insured Name</p>
		<input type = "text" name = "insuredName" pattern = "[A-Za-z][a-zA-Z0-9]{5,20}" title = "The insured name should contain letters and numbers with atleast 8 characters" required>
		<br><br><p>Insured Street</p>
		<input type = "text" name = "insuredStreet" pattern = "[A-Za-z]{6,20}" title = "The street name should contain only letters with atleast 6 characters" required>
		<br><br><p>Insured City</p>
		<input type = "text" name = "insuredCity"  pattern = "[A-Za-z]{8,20}" title = "The city name should contain only letters with atleast 8 characters" required>
		<br><br><p>Insured State</p>
		<input type = "text" name = "insuredState"  pattern = "[A-Za-z]{8,20}" title = "The state name should contain only letters with atleast 8 characters" required>
		<br><br><p>Insured zip</p>
		<input type = "text" name = "insuredZip"  required>
		<br><br><p>Business Segment</p>
		<br>
		<select name = "busSegName">
			<option value = "Business Auto">Business Auto</option>
			<option value = "Restaurant">Restaurant</option>
			<option value = "Apartment">Apartment</option>
			<option value = "General Merchant">General Merchant</option>
			<!-- <option value = "life">Life</option> -->
		</select>
		<br><br><center><input type = "submit" name = "submit" value = "Create Account"></center>
	</form>
	</div>
	</center>
</body>
</html>