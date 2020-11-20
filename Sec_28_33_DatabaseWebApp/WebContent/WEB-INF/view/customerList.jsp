<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Customer List</title>
		
		<!-- referencing the css files -->
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
	</head>
	
	<body>
		<div id="wrapper">
			<div id="header">
				<h2> CUSTOMER RELATIONSHIP MANAGEMENT SYSTEM (CRMS) </h2>
			</div>
		</div>
		
		<div id="container">
			<div id="content">
			
				<!-- button: Add Customer -->
				<input type="button" value="Add Customer" onclick="window.location.href='addCustomer'; return false;" class="add-button">
				
				<!-- table -->
				<table>
					<tr>
						<th> ID </th>
						<th> First Name </th>
						<th> Last Name </th>
						<th> Email </th>
						<th> Action </th>
					</tr>
					
					<c:forEach var="cust" items="${custList}">
						
						<!-- construct customerID-embedded update & delete links -->
						<c:url var="update" value="/customer/updateCustomer"> <c:param name="id" value="${cust.id}" /> </c:url>
						
						<c:url var="delete" value="/customer/deleteCustomer"> <c:param name="id" value="${cust.id}" /> </c:url>
						
						<tr>
							<td> ${cust.id} </td>
							<td> ${cust.firstName} </td>
							<td> ${cust.lastName} </td>
							<td> ${cust.email} </td>
							
							<!-- display the actual update & delete links -->
							<td> 
								<a href="${update}"> Update </a> 
								| 
								<a href="${delete}" onclick="if(!(confirm('Sure?'))) return false"> Delete </a> 
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</body>
</html>