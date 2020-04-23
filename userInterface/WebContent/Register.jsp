<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Sign up page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">


</head>
<body background="#ffccff">
	<form action="Registerservlet" method="post">
		<div class="container">
			<h1>Registration page</h1>
			<p>Please fill the following details to login in</p>
			<hr>
			<div class="form-group">
				<label for="username"><b>User Name</b></label> <input type="text"
					class="form-control" value="username" required>
			</div>

			<div class="form-group">
				<label for="email"><b>Email-Id</b></label> <input type="email"
					class="form-control" value="email" required>
			</div>

			<div class="form-group">
				<label for="password"><b>Enter a password</b></label> <input
					type="password" class="form-control" value="password" required>
			</div>

			<div class="form-group">
				<label for="mobileno"><b>Mobile number</b></label> <input
					type="number" class="form-control" value="mobileno" required>
			</div>
			<hr>
			<button type="submit" class="btn btn-primary">Click here to
				register</button>
		</div>
	</form>
</body>
</html>