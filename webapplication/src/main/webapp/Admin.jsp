<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADMIN</title>
</head>
<script>

window.history.forward();
function noBack()
{
	window.history.forward();
}

function openPage(pageName, elmnt,color) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablink");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].style.backgroundColor = "";
  }
  document.getElementById(pageName).style.display = "block";
  elmnt.style.backgroundColor = color;
}
document.getElementById("defaultOpen").click();
</script>
</head>

<%if(session.getAttribute("adminName")!=null)
{
%>
<body style="background-image: url('b7.png');">
<%-- <jsp:include page="logoutpage.jsp"></jsp:include> --%>
<button class="tablink" onclick="openPage('AccountCreation', this,'purple')">ACCOUNT CREATION</button>
<button class="tablink" onclick="openPage('profileCreation', this,'purple')" id="defaultOpen">PROFILE CREATION</button>
<button class="tablink" onclick="openPage('viewPolicy', this,'purple')">VIEW POLICY</button>
<button class="tablink" onclick="openPage('generateReport', this,'purple')">GENERATE REPORT</button>
<button class="tablink" onclick="openPage('newPolicyCreation', this,'purple')">POLICY CREATION</button>

<div class = "logout" align = "right">
	<a href="index.html">
  	<img src="log.png" alt="logout button" style="width:60px;height:55px;border:0;">
    </a>
</div>

<div align="center" style="font-size: 18px;">
	<h3 font-color = "#485C82">Welcome <%= session.getAttribute("adminName")%> ! </font></h3>
	<%if (request.getAttribute("userCreationMessage") != null)
	{
				out.println("<h3>"+request.getAttribute("userCreationMessage")+"</h3>");}
				
	if (request.getAttribute("accountCreationMessage") != null)
	{
				out.println("<h3>"+request.getAttribute("accountCreationMessage")+"</h3>");}
				%>
				
</div>

<div id="AccountCreation" class="tabcontent">
<form id="signupform" action="AccountDetailsServlet" method="POST">
<h1 style = "color : #ffffff; opacity : 1.9;">ACCOUNT CREATION</h1>
    <div class="input-info">
        <i class="input"></i>
        <input type="text" name="UserName" pattern="[a-zA-Z0-9]*" placeholder="User Name" required>
        <i class="input"></i>
        <input pattern="[a-zA-Z ]*"  type="text"  name="InsuredName" placeholder="Insured Name" required>
        <i class="input"></i>
        <input pattern="[a-zA-Z ]*"  type="text"  name="InsuredStreet" placeholder="Insured Street" required>
        <i class="input"></i>
        <input pattern="[a-zA-Z]*"  type="text"  name="InsuredCity" placeholder="Insured City" required>
        <i class="input"></i>
        <input pattern="[a-zA-Z ]*"  type="text"  name="InsuredState" placeholder="Insured State" required>
		 <i class="input"></i>
        <input type="text" title = "Enter exactly 5 digits."  pattern="^\d{5}$" name="InsuredZip" placeholder="Insured Zip" required>
        <i class="input"></i> 
     <input type="text" name="LOB" placeholder="Business Segment" list="dr" required>
      <datalist id="dr">
      <option name = "BusinessAuto" value = "Business Auto"></option>
      <option name = "Restuarant" value = "Restuarant"></option>
      <option name = "Apartment" value = "Apartment"></option>
      <option name = "GeneralMerchant" value = "General Merchant"></option>
      </datalist>
        
    </div>
    <div class="sign" align = "center">
            <input type="submit" class="signupbutton"><i class="input"></i>
    </div>
    </div>
</form>

</div>

<div id="profileCreation" class="tabcontent">
  <form id="signupform" action="UserCreationServlet" method="POST">
<h1 style = "color : #ffffff; opacity : 1.9;">PROFILE CREATION</h1>
    <div class="input-info">
        <i class="input"></i>
        <input pattern="[a-zA-Z0-9]*"  type="text"  name="uname" placeholder="User Name" required>
        <i class="input"></i>
         <input type = "password"  name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,12}" title="Must contain at least one number and one uppercase and lowercase letter, and have 8 to 12 characters" placeholder = "password" required>
      <input type="text" name="rolecode" placeholder="Role Code" list="lr" required>
      <datalist id="lr">
      <option value = "Admin" name="Admin"></option>
      <option value = "Agent" name="Agent"></option>
      <option value = "Insured" name="Insured"></option>
      </datalist>
    </div>
    <div class="sign">
            <input type="submit" class="signupbutton"><i class="input"></i>
    </div>
</form>

</div>

<div id="viewPolicy" class="tabcontent" align="center">
  <iframe src="viewPolicy.jsp"
     height="900" width="100%" ></iframe>
</div>

<div id="generateReport" class="tabcontent">
  <iframe src="detailedReportGeneration.jsp"
     height="900" width="100%" ></iframe>
</div>

<div id="newPolicyCreation" class="tabcontent">
 	<iframe src="policyCreation.jsp"
     height="900" width="100%" ></iframe>
</div>
	
	<%
if(request.getAttribute("userCreationMessage")!=null)
	{
	
	out.println("<div align='center'><h1>"+request.getAttribute("userCreationMessage")+"</h1></div>");
	} %>
	
	<div class="footer">
  <p>@Copyrights Capgemini India Pvt Limited</p>
</div>
</body>
<%}
else
{
	response.sendRedirect("LoginScreen.jsp");
}
%>

</html>