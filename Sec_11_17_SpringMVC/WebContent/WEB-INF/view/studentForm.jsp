<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Student Form</title>
		
		<!-- apply the css style to the error message -->
		<style> .error {color: red} </style>
	</head>
	
	<body>
		<form:form action="processForm" modelAttribute="stu">
			First Name <form:input path="firstName"/>
			
			<br><br>
			
			Last Name <form:input path="lastName"/>
			
			<br><br>
			
			Gender:
			
			<form:select path="gender">
				<form:option value="Male" label="M"/>
				<form:option value="Female" label="F"/>
				<form:option value="Other" label="Other"/>
			</form:select> 
			
			<br><br>
			
			Country:
			
			<form:select path="hometown">
				<form:options items="${stu.countries}"/>
			</form:select>
			
			<br><br>
			
			Favorite programming language: <br><br>
			
			<form:radiobuttons path="favLang" items="${stu.languages}"/>
			
			<br><br>
			
			Have experiences with any of these OSs: <br><br>
			
			Linux <form:checkbox path="OSs" value="Linux"/>
			
			Android <form:checkbox path="OSs" value="Android"/>
			
			IOS <form:checkbox path="OSs" value="IOS"/>
			
			macIOS <form:checkbox path="OSs" value="macIOS"/>
			
			Windows <form:checkbox path="OSs" value="Windows"/>
			
			<br><br>
			
			Course code: <form:input path="courseCode"/>
			
			<form:errors path="courseCode" cssClass="error"/>
			
			<br><br>
			
			<input type="submit" value="Submit"/>
		</form:form>
	</body>
</html>