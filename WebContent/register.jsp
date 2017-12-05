<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Member Record</title>
</head>
<body>
	<h2>Add Member Record</h2>
	<form action="processregistration.html" method="post">
		<p>USERNAME: <input type="text" name="username" size="25" required="required"></p>
		<p>PASSWORD: <input type="password" name="password" size="25" required="required"></p>
		<p>First Name: <input type="text" name="firstName" size="25" required="required"></p>
		<p>Last Name: <input type="text" name="lastName" size="25" required="required"></p>
		
		<label>Gender:</label>
		<p>
		<input type="radio" name="gender" value="Male" >Male <br/>
		<input type="radio" name="gender" value="Female" style="float: left;">Female 
		</p>
		
		<p>Birthday: <input type="text" name="birthdate" size="25" required="required">(MM/DD/YYYY)</p>
		<p>Email: <input type="text" name="email" size="25" required="required"></p>
		<!--  <input type="hidden" name="action" value="insert">  -->
		<input type="submit" value="Register">
	</form>
</body>
</html>