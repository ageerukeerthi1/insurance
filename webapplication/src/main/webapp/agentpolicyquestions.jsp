<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>

<% int count = 0; %>
 <form action = "AgentPremiumGenerationServlet" method = post>
 <c:forEach items = "${questions}" var = "ques">
 		<%count++; %>
		<c:out value="${ques.polQuesDesc}"/><br>
		<input type = "radio" name = "${ques.polQuesSeq }" value="${ques.polQuesId }!${ques.polQuesAns1}!${ques.polQuesAns1Weightage}"><c:out value="${ques.polQuesAns1}"/><br>
		<input type = "radio" name = "${ques.polQuesSeq }" value="${ques.polQuesId }!${ques.polQuesAns2}!${ques.polQuesAns2Weightage}"><c:out value="${ques.polQuesAns2}"/><br>
		<input type = "radio" name = "${ques.polQuesSeq }" value="${ques.polQuesId }!${ques.polQuesAns3}!${ques.polQuesAns3Weightage}"><c:out value="${ques.polQuesAns3}"/><br>
	</c:forEach>
	<input type="hidden" name = "numofquestions" value="<%=count %>">
	<input type = "submit" value="Create Policy">
  </form>
  </center>
  </body>
</html>