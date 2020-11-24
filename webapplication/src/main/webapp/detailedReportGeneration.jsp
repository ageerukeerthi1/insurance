<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cg.model.PolicyDetails"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.cg.dao.PolicyDAO"%>
<%@page import="com.cg.dao.IPolicyDAO"%>
<%@page errorPage="ErrorPage.jsp" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body style="background-image: url('b10.png');">
	
	<%
		if (session.getAttribute("adminName") != null)
		{%>
			
			
<div align="center">
		<form action="detailedReportGeneration.jsp" method="post">
			<table>
				<tr>
					<td>Enter AccountNumber or PolicyNumber:</td>
					<td><input type="number" min="1000000000" name="accPolNumber">
					<td></td>
					<td><input type="submit" value="Search" class="searchbutton">
				</tr>
			</table>
		</form>
	</div>
	
	<div align="center" style="margin-top: 60px" >
	<table border="2" cellpadding="10px" style="background-color: white; opacity: 1">
	<tr style="background-color: #91065e; color:white">
		<th>Policy Number
		<th>Policy Premium
		<th>Account Number
		<th></th>
	</tr>
	<%
		IPolicyDAO iPolicyDAO = new PolicyDAO();
		long accPolNumber = 0l;
		if(request.getParameter("accPolNumber")!=null)
			accPolNumber = Long.parseLong(request.getParameter("accPolNumber"));
		ResultSet resultSet = iPolicyDAO.viewAllPolicy(accPolNumber);
		
		
		
		while(resultSet.next())
		{
			%>
			<tr>
				<td><%= resultSet.getLong(1) %>
				<td><%= resultSet.getDouble(2) %>
				<td><%= resultSet.getLong(3) %>
				<td><a href="ReportGenerationServlet?policyNumber=<%=resultSet.getLong(1) %>"><button class="signupbutton">View Detailed Report</button></a>
			</tr> 
	<%
		}
		%>
			
	<c:if test="${pdfStatus!=null }">
		<c:out value="Pdf Creation Status : ${pdfStatus}"></c:out>
	</c:if>
<%		
	
	}
else
{
	response.sendRedirect("LoginScreen.jsp");
}

%>
</body>
</html>