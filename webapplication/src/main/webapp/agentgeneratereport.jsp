<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.List"%>
<%@page import="com.cg.model.Accounts"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% Accounts accounts = (Accounts)request.getAttribute("account");
	   String busSegName = (String)request.getAttribute("busSegName");
	   List<String> questions = (List)request.getAttribute("questions");
	   List<String> selectedAnswers = (List)request.getAttribute("selectedAns");
	   Double premium = (Double)request.getAttribute("premium");
	   PrintWriter writer = response.getWriter();
	   writer.println(selectedAnswers);
	%>
	<%=accounts.getInsuredName() %><br>
	<%=accounts.getInsuredStreet() %><br>
	<%=accounts.getInsuredCity() %><br>
	<%=accounts.getInsuredState() %><br>
	<%=accounts.getInsuredZip() %><br>
	<%=busSegName %><br>
	<c:forEach items="${questions}" var="question">
	    	<c:out value="${question.polQuesDesc}" /><br>
	</c:forEach>
	
	<c:forEach items="${selectedAnswers}" var="answer">
	    	<c:out value="${answer}" /><br>
	</c:forEach>
	<%=premium %>
	
</body>
</html>