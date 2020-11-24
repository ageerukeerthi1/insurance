<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin page</title>

<script>
	function profileCreation() {
	document.getElementById("displayIframe").innerHTML="<iframe src ='profilecreation.html'  class ='userframe'></iframe>";
	}
	function accountCreation() {
	document.getElementById("displayIframe").innerHTML="<iframe src ='accountcreation.html' class ='userframe'></iframe>";
	}
	function policyCreation() {
	document.getElementById("displayIframe").innerHTML="<iframe src ='policycreation.html' class='userframe'></iframe>";
	}
	/* function reportGeneration() {
	document.getElementById("displayIframe").innerHTML="<iframe src ='reportGeneration.html' class ='userframe'></iframe>";
	} */
	function viewPolicy() {
	document.getElementById("displayIframe").innerHTML="<iframe src ='ViewPolicy' class ='userframe' height = '700' width = '500'></iframe>";
	}
	
	</script>
</head>

<body>
	<div class="adminHP">
		<div class="header">
			<button href="index.html" class="logo"></button>
			<div class="header-right">
				<button class="active" href="index.html"></button>
			</div>
		</div>
		</div>

	<div id ="displayIframe"></div>
	<ul>

		<li><button type = "submit" onclick="profileCreation()"><b>ProfileCreation</b></button></li>
		<li><button type = "submit" onclick="accountCreation()"><b>Account Creation</b></button></li>
		<li><button type = "submit" onclick="policyCreation()"><b>Policy Creation</b></button></li>
		<li><button type = "submit" onclick="viewPolicy()"><b>ViewPolicy</b></button></li>  
	</ul>
	

	
</body>

</html>