<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body style="background-image: url('b10.png');">
<%
		if (session.getAttribute("adminName") != null || session.getAttribute("agentName") != null || session.getAttribute("insuredName") != null) {
			session.invalidate();
			out.println("<div align='center'><h1>Succesfully Logged out</h1></div>");
			
		}

		if(request.getAttribute("loginFailed")!=null)
		{
			out.println("<div align='center'><h1>"+request.getAttribute("loginFailed")+"</h1></div>");
		}

	%>

<form id="signupform" action="LoginServlet" method="POST">>>
<h1 style = "color : #ffffff; opacity : 1.9;">LOGIN</h1>
    <div class="input-info">
        <i class="input"></i>
        <input  type="text"  name="userName" placeholder="User Name" required>
         <i class="input"></i>
        <input type="password" name="password" placeholder="Password" required>
    </div>
    <div class="sign">
        <a href="" target="_blank">
            <button class="signupbutton" form="signupform"><i class="input"></i><b>Login</b></button>
        </a>
    </div>
</form>
<div class="footer">
  <p>@Copyrights Capgemini India Pvt Limited</p>
</div>
</body>
</html>