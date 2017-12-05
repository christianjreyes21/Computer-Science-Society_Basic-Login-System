<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CSS LOGIN</title>
</head>
<body>
	<h2>Login</h2>
	<form action="processlogin.html" method="post">
		<p>USERNAME: <input type="text" name="username" size="25" required="required"></p>
		<p>PASSWORD: <input type="password" name="password" size="25" required="required"></p>
		<!--  <input type="hidden" name="action" value="insert">  -->
		<input type="submit" value="Login">
	</form>
</body>
</html>