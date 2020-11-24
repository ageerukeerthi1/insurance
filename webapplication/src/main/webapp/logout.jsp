<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
 if(session.getAttribute("usernameUW") != null)
 {
	 session.setAttribute("usernameUW", "");
	 //session.removeAttribute("usernameUW");
	 //session.invalidate();
	 application.setAttribute("msg", "successfully logout!!");
	 response.sendRedirect("login.jsp");
 }
 else if(session.getAttribute("usernameA") != null)
 {
	 session.invalidate();
	 application.setAttribute("msg", "successfully logout!!");
	 response.sendRedirect("agenthome.jsp");
 }
%>
</html>