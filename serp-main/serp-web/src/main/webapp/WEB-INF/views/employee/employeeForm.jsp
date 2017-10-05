<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Form</title>
<spring:url value="/resources/css/main.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<h2>Employee Details</h2>
	<hr />
	<spring:url value="/employee/saveEmployee" var="saveEmployeeURL" />
	<form:form action="${saveEmployeeURL}" method="post"
		modelAttribute="employee">
		<form:hidden path="employeeId" />
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<table>
			<tr>
				<td>First Name</td>
				<td><form:input path="firstname" /> <form:errors
						path="firstname" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><form:input path="lastname" /> <form:errors
						path="lastname" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><form:input path="age" /> <form:errors path="age"
						cssClass="error" /></td>

			</tr>

			<tr>
				<td>Gender</td>
				<td><form:radiobutton path="gender" value="Male" label="Male" />
					<form:radiobutton path="gender" value="Female" label="Female" /> <form:errors
						path="gender" cssClass="error" /></td>
			</tr>

			<tr>
				<td>Address</td>
				<td><form:input path="address" /> <form:errors path="address"
						cssClass="error" /></td>
			</tr>
			
			<tr>
				<td>Email</td>
				<td><form:input path="email" /> <form:errors path="email"
						cssClass="error" /></td>
			</tr>

			<tr>
				<td>Department</td>
				<td>
					<form:select path="department.departmentId">
						<form:options items="${departmentList}" itemValue="departmentId" itemLabel="name"/>
					</form:select>
				</td>
				
				<td>
					<form:errors path="department" cssClass="error" />
				</td>
			</tr>


			<tr>
				<td><button type="submit" class="button">Submit</button></td>
				<td><spring:url value="/employee/listEmployee" var="goToListURL" /> <a
					href="${goToListURL}">Employee List</a></td>
			</tr>
		</table>
	</form:form>
</body>
</html>