<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Customer Info</title>
		
		<!-- referencing the css files -->
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
	</head>
	
	<body>
		<div id="wrapper">
			<div id="header"> <h2> CUSTOMER RELATIONSHIP MANAGEMENT SYSTEM (CRMS) </h2> </div>
		</div>
			
		<div id="container">
			<h3> Save Customer </h3>
			
			<form:form action="saveCustomer" modelAttribute="cust" method="POST">
				
				<!-- 
					- create a hidden form field to link the updated data with a specific customer id 
					- when this form's loaded, customer.getId() is called -> updated data is linked to a customer
					- when this form's submitted, customer.setId() is called, that customer's data is updated
					- without this line, the back-end system can't know which customer has his/her data updated
				-->
				<form:hidden path="id" />
			
				<table>
					<tbody>
						<tr> 
							<td> <label> First Name: </label> </td> 
							<td> <form:input path="firstName"/> </td>
						</tr>
						
						<tr> 
							<td> <label> Last Name: </label> </td> 
							<td> <form:input path="lastName"/> </td>
						</tr>
						
						<tr> 
							<td> <label> Email: </label> </td> 
							<td> <form:input path="email"/> </td>
						</tr>
						
						<tr>
							<td> <label></label> </td>
							<td> <input type="submit" value="Submit"/> </td>
						</tr>
					</tbody>
				</table>
			</form:form>
			
			<br><br>
			
			<p> <a href="${pageContext.request.contextPath}/customer/list"> Back to the customer list </a> </p>		
		</div>
	</body>
</html>