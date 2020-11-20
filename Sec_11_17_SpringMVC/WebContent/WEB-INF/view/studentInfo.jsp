<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Student Info</title>
	</head>
	
	<body>
		The student's name: ${stu.firstName} ${stu.lastName}
		
		<br><br>
		
		The student's gender: ${stu.gender}
		
		<br><br>
		
		The student's hometown: ${stu.hometown}
		
		<br><br>
		
		The student's favorite programming language: ${stu.favLang}
		
		<br><br>
		
		The student's experiecned with:
		
		<ul>
			<c:forEach var="os" items="${stu.OSs}">
				<li> <b> ${os} </b> </li>
			</c:forEach>
		</ul>
		
		The student's course code: ${stu.courseCode}
	</body>
</html>