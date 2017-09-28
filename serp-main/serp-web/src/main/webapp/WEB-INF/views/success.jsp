<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Details</title>
</head>
<body>
	<h2>Customer Success From</h2>
	<hr />

	<table>
		<tr>
			<th>First Name</th>
			<td>${customer.firstname}</td>
		</tr>
		<tr>
			<th>Last Name</th>
			<td>${customer.lastname}</td>
		</tr>
		<tr>
			<th>Age</th>
			<td>${customer.age}</td>
		</tr>
		<tr>
			<th>Address</th>
			<td>${customer.address}</td>
		</tr>
	</table>
</body>
</html>