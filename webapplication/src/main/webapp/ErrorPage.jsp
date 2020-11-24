<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Occured</title>
</head>
<body>
<% if (session.getAttribute("adminName") != null || session.getAttribute("agentName")!=null || session.getAttribute("insuredName")!=null) 
{
	
	String prevPage = request.getHeader("referer");
	String prevPageName = prevPage.substring(prevPage.lastIndexOf('/')+1);
	
	//Logger logger = LoggerUtility.getLogger();
	//logger.error("An exception has occured");
	//logger.info(prevPageName);
	if(prevPageName.equals("Admin.jsp"))
	{
%>
	<button type="button" class="signupbutton" onClick="location.href='Admin.jsp'">Back</button>
	<%}
	else if(prevPageName.equals("Agent.jsp"))
	{
		%>
		<button type="button" class="signupbutton" onClick="location.href='Agent.jsp'">Back</button>
	<%
	}
	else if(prevPageName.equals("Insured.jsp"))
	{
		%>
		<button type="button" class="signupbutton" onClick="location.href='Insured.jsp'">Back</button>
		<%
	}
	
	else{ %>
		<button type="button" class="signupbutton" onClick="javascript:history.go(-1)">Back</button>
</body>
<%
	}
}
else
{
	response.sendRedirect("LoginScreen.jsp");
}
%>
</html>