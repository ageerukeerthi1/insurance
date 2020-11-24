<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class = "loginbox">
		<h1>Profile Creation</h1>
		
		<form action = "ProfileCreation" method = "post">
			<p>Username</p>
			<input type = "text" name = "username" pattern = "[a-zA-Z][a-zA-Z0-9]{8,20}" title = "The username should be combination of letters and numbers with atleast 8 characters" required>
			<br><p>Password</p>
			<input type = "password" name = "password" pattern = "(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}" title = "The password should be combination of uppercase letters, lowercase letters and numbers with atleast 8 charecters" required>
			<p>Role code</p>
			<br><select name = "rolecode">
				<option value="I">Insured</option>
				<option value="A">Agent</option>
				<option value="UW">UnderWriter</option>
			</select><br><br>
			<center><input type = "submit" name = "submit" value = "Register"></center>
		</form>		
	</div>
</body>
</html>