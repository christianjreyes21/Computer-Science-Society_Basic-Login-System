<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Member Registration Status</title>
</head>
<body>
	<%
	if (request.getParameter("success").equals("register")) { %>
		<h2>Successful Registration</h2>
		<br/>
		<p>Username: ${member.username}</p>
		<p>Last Name: ${member.lastName}</p>
		<p>First Name: ${member.firstName}</p>
		<p>Gender: ${member.gender}</p>
		<p>Birthday: ${member.birthdate}</p> 
	
	<% } else if (request.getParameter("success").equals("login")) { %>
	  <h2>Successful Login</h2>
		<br/>
		<p>Username: ${member.username}</p>
		<p>Last Name: ${member.lastName}</p>
		<p>First Name: ${member.firstName}</p>
		<p>Gender: ${member.gender}</p>
		<p>Birthday: ${member.birthdate}</p> 
	
	<% } else if (request.getParameter("success").equals("invalidPassword")) { %>
		<h1>Login Failed</h1>
	  <h3>Invalid PASSWORD</h3>	
	
	<% } else if (request.getParameter("success").equals("doesNotExist")) { %>
		<h1>Login Failed</h1>
	  <h3>USERNAME does not exist</h3>	
	
	<% } else { %>
	  <h1>Registration Failed</h1>
	  <h3>USERNAME ALREADY EXISTS</h3>		
	<% } %> 
	<br/>
	<p><a href="index.jsp">Click here to display the menu.</a></p>
</body>
</html>