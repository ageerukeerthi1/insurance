<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Creation</title>
</head>
<body>
	<div class = "accountbox">
	<h1>Account Creation</h1>
	<br>
	<form action = "InsuredAccountCreation" method = "post">
		<p>User Name</p>
		<input type = "text" name = "userName" placeholder = "Enter Insured name" pattern = "[a-zA-Z][a-zA-Z0-9]{8,20}" title = "The insured name should contain letters and numbers with atleast 8 characters" required>
		<p>Insured Name</p>
		<input type = "text" name = "insuredName" placeholder = "Enter Insured name" pattern = "[a-zA-Z][a-zA-Z0-9]{8,20}" title = "The insured name should contain letters and numbers with atleast 8 characters" required>
		<p>Insured Street</p>
		<input type = "text" name = "insuredStreet" placeholder = "Enter Insured street" pattern = "[a-zA-Z]{6,20}" title = "The street name should contain only letters with atleast 6 characters" required>
		<p>Insured City</p>
		<input type = "text" name = "insuredCity" placeholder = "Enter Insured city" pattern = "[a-zA-Z]{8,20}" title = "The city name should contain only letters with atleast 8 characters" required>
		<p>Insured State</p>
		<input type = "text" name = "insuredState" placeholder = "Enter Insured state" pattern = "[a-zA-Z]{8,20}" title = "The state name should contain only letters with atleast 8 characters" required>
		<p>Insured zip</p>
		<input type = "text" name = "insuredZip" placeholder = "Enter Insured zip" required><br><br>
		<p>Business Segment</p>
		<select name = "busSegName">
			<option value = "Business Auto">Business Auto</option>
			<option value = "Restaurant">Restaurant</option>
			<option value = "Apartment">Apartment</option>
			<option value = "General Merchant">General Merchant</option>
			<!-- <option value = "life">Life</option> -->
		</select><br><br>
		<center><input type = "submit" name = "submit" value = "Create Account"></center>
	</form>
</body>
</html>