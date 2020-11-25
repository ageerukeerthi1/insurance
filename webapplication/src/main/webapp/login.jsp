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
    <center> <h1> User Login </h1> </center> 
    <form action="LoginServlet" method="post">
        <div class="container"> 
            <label>User ID : </label><br> 
            <input type="text" placeholder="Enter UserID" name="username" required><br>
            <label>Password : </label><br> 
            <input type="password" placeholder="Enter Password" name="password" required><br>
            <button type="submit">Login</button><br>
            <input type="checkbox" checked="checked"> Remember me 
            <button type="button" class="cancelbtn"> Cancel</button> 
     
        </div>
    </form>
    </center>
</body>
</html>