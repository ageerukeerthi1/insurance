<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insured page</title>
<script>
	function accountCreation() {
	document.getElementById("displayIframe").innerHTML="<iframe src ='InsuredAccountCreation.jsp' class ='userframe'></iframe>";
	}
	</script>
</head>
<body>
<div class = "userHP">
		<div class="header">
			
			<div class="header-right">
				
			</div>
		</div>
		<div id ="displayIframe"></div>
		<ul>
			<li><button type = "submit" onclick="accountCreation()"><b>Account Creation</b></button></li>
			<li><button type = "submit" onclick="viewPolicy()"><b>View Policy</b></button></li>  
		</ul>

</body>
</html>