<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>INSURED</title>
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

<%if(session.getAttribute("insuredName")!=null)
{
%>

<body style="background-image: url('b6.png');">
<%if(request.getAttribute("accountExists")!=null)
		{
			System.out.println(request.getAttribute("accountExists"));
			if(request.getAttribute("accountExists").equals("Yes"))
			{
			%>
<button class="tablink" onclick="openPage('AccountCreation', this,'purple')" disabled>ACCOUNT CREATION</button>
<%}
	else
		{
	%>
	<button class="tablink" onclick="openPage('AccountCreation', this,'purple')">ACCOUNT CREATION</button>
			<%}
		}
			%>
<button class="tablink" onclick="openPage('viewPolicy', this,'purple')">VIEW POLICY</button>

<div class = "logout" align = "right">
	<a href="index.html">
  	<img src="log.png" alt="logout button" style="width:60px;height:55px;border:0;">
    </a>
</div>

<div align="center" style="font-size: 18px;">
	<h3 font-color = "#485C82">Welcome <%= session.getAttribute("insuredName")%> ! </font></h3>
	<%if (request.getAttribute("userCreationMessage") != null)
	{
				out.println("<h3>"+request.getAttribute("userCreationMessage")+"</h3>");}
				
	if (request.getAttribute("accountCreationMessage") != null)
	{
				out.println("<h3>"+request.getAttribute("accountCreationMessage")+"</h3>");}
				%>
				
</div>

<%
		if (request.getAttribute("accNum") != null) {
	%>
	<style>
		h1 {
  			text-shadow: 2px 2px #33cccc;
		}
	</style>
	<div align="center">
		<h1>
			<font color="black"><%=request.getAttribute("accNum")%></font>
		</h1>
	</div>
	<%} %>
	

<div id="AccountCreation" class="tabcontent">
<form id="signupform" action="AccountDetailsServlet" method="POST">
<h1 style = "color : #ffffff; opacity : 1.9;">ACCOUNT CREATION</h1>
    <div class="input-info">
        <i class="input"></i>
        <input type="text" name="UserName" placeholder="User Name" required>
        <i class="input"></i>
        <input pattern="[a-zA-Z ]*"  type="text"  name="InsuredName" placeholder="Insured Name" required>
        <i class="input"></i>
        <input pattern="[a-zA-Z]*"  type="text"  name="InsuredStreet" placeholder="Insured Street" required>
        <i class="input"></i>
        <input pattern="[a-zA-Z]*"  type="text"  name="InsuredCity" placeholder="Insured City" required>
        <i class="input"></i>
        <input pattern="[a-zA-Z]*"  type="text"  name="InsuredState" placeholder="Insured State" required>
		 <i class="input"></i>
        <input type="text" title = "Enter exactly 5 digits."  pattern="^\d{5}$" name="InsuredZip" placeholder="Insured Zip" required>
        <i class="input"></i> 
     <input type="text" name="LOB" placeholder="Business Segment" list="dr">
      <datalist id="dr">>
      <option name = "BusinessAuto" value = "Business Auto">Business Auto</option>
      <option name = "Restuarant" value = "Restuarant">Restaurant</option>
      <option name = "Apartment" value = "Apartment">Apartment</option>
      <option name = "GeneralMerchant" value = "General Merchant">Generation Merchant</option></select>
      </datalist>
        
    </div>
    <div class="sign">
        <a href="" target="_blank">
            <button class="signupbutton" form="signupform"><i class="input"></i><b>Create</b></button>
        </a>
    </div>
</form>

</div>



<div id="viewPolicy" class="tabcontent">
   <iframe src="viewPolicy.jsp"
     height="900" width="100%" ></iframe>
</div>
<div class="footer">
  <p>@Copyrights Capgemini India Pvt Limited</p>
</div>
</html>
</body>

<%}
else
{
	response.sendRedirect("LoginScreen.jsp");
}
%>
</html>