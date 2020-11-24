<%@page import="com.cg.service.InsuranceQuoteGenerationService"%>
<%@page import="com.cg.service.IInsuranceQuoteGenerationService"%>
<%@page import="com.cg.model.Policy"%>
<%@page import="java.util.List"%>
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
		if (session.getAttribute("adminName") != null || session.getAttribute("agentName")!=null || session.getAttribute("insuredName")!=null)
		{%>
			
			
<% if(session.getAttribute("adminName")!=null)
{
%>


<div align="center">
		<form action="viewPolicy.jsp" method="post">
			<table>
				<tr>
					<td>Enter AccountNumber or PolicyNumber:</td>
					<td><input type="number" min="1000000000" name="accPolNumber">
					<td></td>
					<td><input type="submit" value="Search" class="signupbutton">
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
	</tr>
	<%
		IInsuranceQuoteGenerationService service = new InsuranceQuoteGenerationService();
		long accPolNumber = 0l;
		if(request.getParameter("accPolNumber")!=null)
			accPolNumber = Long.parseLong(request.getParameter("accPolNumber"));
		ResultSet resultSet = service.viewAllPolicy(accPolNumber);
		
		
		
		while(resultSet.next())
		{
			%>
			<tr>
				<td><%= resultSet.getLong(1) %>
				<td><%= resultSet.getDouble(2) %>
				<td><%= resultSet.getLong(3) %>
			</tr> 
	<%
		}%> 
	
	</table>
	</div>


<%}
else if(session.getAttribute("agentName")!=null)
{
%>
<div align="center">
		<form action="viewPolicy.jsp" method="post">
			<table>
				<tr>
					<td>Enter AccountNumber or PolicyNumber:</td>
					<td><input type="number" min="1000000000" name="accPolNumber">
					<td></td>
					<td><input type="submit" value="Search" class="signupbutton">
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
	</tr>
	<%
		
		IInsuranceQuoteGenerationService service = new InsuranceQuoteGenerationService();
		long accPolNumber = 0l;
		if(request.getParameter("accPolNumber")!=null)
			accPolNumber = Long.parseLong(request.getParameter("accPolNumber"));
		List<Policy> policies = service.viewAllPolicy(accPolNumber,session.getAttribute("agentName").toString());
		
		
		
		for(Policy policy : policies)
		{
			%>
			<tr>
				<td><%= policy.getPolicyNumber() %>
				<td><%= policy.getPolicyPremium() %>
				<td><%= policy.getAccountNumber() %>
			</tr> 
	<%
		}%> 
	
	</table>
	</div>
	<%}
		
		else if(session.getAttribute("insuredName")!=null)
		{
		%>
		
		<div align="center">
		<form action="viewPolicy.jsp" method="post">
			<table>
				<tr>
					<td>Enter PolicyNumber:</td>
					<td><input type="number" min="1000000000" name="accPolNumber">
					<td></td>
					<td><input type="submit" value="Search" class="signupbutton">
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
	</tr>
	<%
		IInsuranceQuoteGenerationService service = new InsuranceQuoteGenerationService();
		long accPolNumber = 0l;
		if(request.getParameter("accPolNumber")!=null)
			accPolNumber = Long.parseLong(request.getParameter("accPolNumber"));
		List<Policy> policies = service.viewAllPolicyOfInsured(accPolNumber,session.getAttribute("insuredName").toString());
		
		
		
		for(Policy policy : policies)
		{
			%>
			<tr>
				<td><%= policy.getPolicyNumber() %>
				<td><%= policy.getPolicyPremium() %>
				<td><%= policy.getAccountNumber() %>
			</tr> 
	<%
		}%> 
	
	</table>
	</div>
		<%
		}
	}//close of if
		else
		{
			response.sendRedirect("LoginScreen.jsp");
		}
	%>
</body>
</html>