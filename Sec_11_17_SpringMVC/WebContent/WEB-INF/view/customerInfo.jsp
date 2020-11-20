<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Customer Info</title>
	</head>
	
	<body>
		The customer's name: ${cust.firstName} ${cust.lastName}
		
		<br><br>
		
		The customer's age: ${cust.age}
		
		<br><br>
		
		The customer's postal code: ${cust.postalCode}
		
		<br><br>
		
		The customer's ID: ${cust.id}
	</body>
</html>