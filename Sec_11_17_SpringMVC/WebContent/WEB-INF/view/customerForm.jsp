<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Customer Form</title>
		
		<!-- apply the css style to the error message -->
		<style> .error {color: red} </style>
	</head>
	
	<body>
		<i> Fill out the form. Asterisk (*) means required </i><br><br>
		
		<form:form action="processForm" modelAttribute="cust">
			First name: <form:input path="firstName"/>
			
			<br><br>
			
			Last name (*): <form:input path="lastName"/>
			
			<form:errors path="lastName" cssClass="error"/>
			
			<br><br>
			
			Age (*): <form:input path="age"/>
			
			<form:errors path="age" cssClass="error"/>
			
			<br><br>
			
			Postal code: <form:input path="postalCode"/>
			
			<form:errors path="postalCode" cssClass="error"/>
			
			<br><br>
			
			ID (*): <form:input path="id"/>
			
			<form:errors path="id" cssClass="error"/>
			
			<br><br>
			
			<input type="submit" value="Submit">
		</form:form>
	</body>
</html>