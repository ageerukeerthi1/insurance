<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Policy Premium</title>
</head>
<body style="background-image: url('b10.png');">
<script type="text/javascript">
window.onload = function (){
		window.history.forward();
		function noBack() {
			window.history.foward();
		}
}
	</script>
	<% 
	if (session.getAttribute("adminName") != null || session.getAttribute("agentName")!=null) 
	{	
%>
	
<div align="center">
<form action="PolicyServlet" method="post">
Enter Account Number<input type="number" min="1000000000" name="accno" required><br><br>
<input type="submit" name="submit" value="submit" class="signupbutton">
</form>
</div>
<div align="center">
	<form action="GeneratePolicyServlet" method="post">
	<table style="background-color: white; opacity: 1;">
	<tr style="background-color: #91065e; color:white" style="font-size: 28px">
		<th>Questions
		<th  colspan="5">Answers
	</tr>
		<%
		if(request.getAttribute("accountNotFound")!=null)
		{
			out.println("<h1 style='background-color: white'>"+request.getAttribute("accountNotFound")+"</h1>");
		}
		ResultSet resultSet = (ResultSet)request.getAttribute("questions");
		
		if(resultSet!=null)
		{
			int i = 0;
			
			ArrayList<String> qIds = new ArrayList<>();
			
			
			
			while(resultSet.next())
			{
				out.println("<tr style='font-size: 18px'>");
				qIds.add(resultSet.getString(1));
				out.println("<td><h5>"+resultSet.getString(4)+" :</td></font></h4>");
				out.println("<td></td><td><h5><input type='radio' name='"+qIds.get(i)+"' value='"+resultSet.getString(5)+" "+resultSet.getString(6)+"' required>"+resultSet.getString(5)+"</h5></td>");
				out.println("<td><h5><input type='radio' name='"+qIds.get(i)+"' value='"+resultSet.getString(7)+" "+resultSet.getString(8)+"' required>"+resultSet.getString(7)+"</h5></td>");
				out.println("<td><h5><input type='radio' name='"+qIds.get(i)+"' value='"+resultSet.getString(9)+" "+resultSet.getString(10)+"' required>"+resultSet.getString(9)+"</h5></td>");
				out.println("</tr>");
				i++;
			}
			session.setAttribute("questionIds", qIds); 
			%>
		
		<tr><td><input type="submit" value="Create Policy" class="signupbutton"></td></tr>
		<% }
			
		%>
	</table>
	</form>
</div>
<%}
	else
	{
		response.sendRedirect("LoginScreen.jsp");
	}
%>
</body>
</html>