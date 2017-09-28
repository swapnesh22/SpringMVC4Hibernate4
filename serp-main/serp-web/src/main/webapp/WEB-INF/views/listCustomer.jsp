<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page isELIgnored="false"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customers</title>
<spring:url value="/resources/css/main.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<style type="text/css">
.error {
	color: red;
}

.cart { background-color: #CCC; }

#sidebar {
    display: none;
}
.cart:hover #sidebar {
    display:block;
}
</style>
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script>
    $(document).ready(function(){
        $("#boxchecked").click(function (){
            if ($("#boxchecked").prop("checked")){
                $("#hidden").hide();
            }else{
                $("#hidden").show();
            }              
        });
    });
</script>

</head>
<body>

	<spring:url value="/addCustomer" var="addURL" />
	<a href="${addURL }">Add New Customer</a>
	<form:form>
		<c:if test="${not empty exception}">
			<font class="error"><c:out value="${exception.errCode}" /> <c:out
					value="${exception.errMsg}" /></font>
		</c:if>
		<form:errors />
		<table width="50%" border=1>
			<tr>
				<th>Customer Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
				<th>Gender</th>
				<th>Address</th>
				<th>Type</th>
				<th colspan="2">Action</th>
			</tr>

			<c:forEach items="${listCustomer}" var="customer">
				<tr>
					<td>${customer.customernumber}</td>
					<td>${customer.firstname}</td>
					<td>${customer.lastname}</td>
					<td>${customer.age}</td>
					<td>${customer.gender}</td>
					<td>${customer.address}</td>
					<td>${customer.type}</td>

					<td><spring:url
							value="/updateCustomer/${customer.customernumber}"
							var="updateURL" /> <a href="${updateURL }">Update</a></td>
					<td><spring:url
							value="/deleteCustomer/${customer.customernumber}"
							var="deleteURL" /> <a href="${deleteURL }">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
	</form:form>
</body>
</html>