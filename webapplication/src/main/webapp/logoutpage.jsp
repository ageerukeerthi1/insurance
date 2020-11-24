<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout page</title>
</head>
<body>
	<div align="right" class="navbar">
		<table>
			<tr>
				<td>
					<h4>
						<font color="white"> <%if(session.getAttribute("adminName")!=null){ %>
							<%=session.getAttribute("adminName")%> <%}
				else if(session.getAttribute("agentName")!=null){ %> <%=session.getAttribute("agentName")%>
							<%}
				else if(session.getAttribute("insuredName")!=null){ %> <%=session.getAttribute("insuredName")%>
							<%}%>

						</font>
					</h4>
				<td><a href="LoginScreen.jsp"><button type="button"
							class="signupbutton">LOGOUT</button></a>
			</tr>
		</table>
	</div>
</body>
</html>