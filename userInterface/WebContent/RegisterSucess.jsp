<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.userInterface.userInterface"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Successfully registered</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body>
	<h1>You have successfully registered!! Here is your registration
		details</h1>
	<div>
		<p>Click on the link for multiple registration</p>
		<br> <a href="Register.jsp">Click here to Register again </a>
		<%
			ArrayList<userInterface> uList = (ArrayList<userInterface>) request.getAttribute("list");
		%>
	</div>
	<div>
		<table border="1">
			<tr>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>PASSWORD</th>
				<th>MOBILE_NO</th>
			</tr>
			<%
				for (userInterface user : uList) {
			%>
			<tr>
				<td>
					<%
						out.println(user.getUserName());
					%>
				</td>
				<td>
					<%
						out.println(user.getEmial());
					%>
				</td>
				<td>
					<%
						out.println(user.getPassword());
					%>
				</td>
				<td>
					<%
						out.println(user.getMobileNo());
					%>
				</td>

				<%
					}
				%>

			</tr>

		</table>
	</div>
	<div>
		<h1>Click here to login!!</h1>
		<a href="Login.jsp">Click here to Login</a>


	</div>

</body>
</html>