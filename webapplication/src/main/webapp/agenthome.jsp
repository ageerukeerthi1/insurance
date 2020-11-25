<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agent page</title>
<script>
	
	 window.history.forward();
		function noBack() 
		{
			window.history.forward();	
		}
	
		function accountCreation() {
			document.getElementById("displayIframe").innerHTML="<iframe src ='accountcreation.html' class ='userframe'></iframe>";
			}
	function policyCreation() {
	document.getElementById("displayIframe").innerHTML="<iframe src ='policycreation.html' class ='userframe'></iframe>";
	}
	function viewPolicy() {
		document.getElementById("displayIframe").innerHTML="<iframe src ='AgentViewPolicy' class ='userframe'></iframe>";
		}
	</script>
</head>
<body>
</center>

<%
//System.out.println(session.getAttribute("username"));
 if(session.getAttribute("username")==null)
{
	 session.invalidate();
     response.sendRedirect("index.html");
}	 
%> 

<div class = "userHP">
		<div class="header">
			<a href="index.html" class="logo">CompanyLogo</a>
			<div class="header-right">
				<a href="LogoutServlet">Logout</a>
			</div>
		</div>
		<div id ="displayIframe"></div>
		<ul>
			<li><button type = "submit" onclick="accountCreation()"><b>Account Creation</b></button></li>
			<li><button type = "submit" onclick="policyCreation()"><b>Policy  Creation</b></button></li>
			<li><button type = "submit" onclick="viewPolicy()"><b>View Policy</b></button></li>  
		</ul>
		</div>
		</center>
</body>
</html>