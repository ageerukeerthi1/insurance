<%@page import="com.cg.model.PolicyQuestions"%>
<%@page import="java.util.List"%>
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
<jsp:include page="logoutpage.jsp"></jsp:include>
<script type="text/javascript">
window.history.forward();
function noBack() {
	window.history.forward();
}	
</script>
<form action="AgentPolicyCreationServlet" method="post">
Enter Account no<input type="number" name="accNo">
<input type="submit" name="submit" value="Submit">

</form>
</body>
</html>