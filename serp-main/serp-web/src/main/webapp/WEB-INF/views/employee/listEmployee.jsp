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
    function myFunction() {
    	  var input, filter, table, tr, td, i;
    	  input = document.getElementById("myInput");
    	  filter = input.value.toUpperCase();
    	  table = document.getElementById("myTable");
    	  tr = table.getElementsByTagName("tr");
    	  for (i = 0; i < tr.length; i++) {
    	    td = tr[i].getElementsByTagName("td")[1];
    	    if (td) {
    	      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
    	        tr[i].style.display = "";
    	      } else {
    	        tr[i].style.display = "none";
    	      }
    	    }       
    	  }
    	}
</script>

</head>
<body>

	<spring:url value="/employee/addEmployee" var="addURL" />
	<a href="${addURL }">Add Employee</a>
	<form:form>
		<c:if test="${not empty exception}">
			<font class="error"><c:out value="${exception.errCode}" /> <c:out
					value="${exception.errMsg}" /></font>
		</c:if>
		<form:errors />
		<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names.." title="Type in a name">
		<table width="50%" border=1 id="myTable">
			<tr>
				<th>Employee Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
				<th>Gender</th>
				<th>Address</th>
				<th>Email</th>
				<th>Department</th>
				<th colspan="2">Action</th>
			</tr>

			<c:forEach items="${listEmployee}" var="emp">
				<tr>
					<td>${emp.employeeId}</td>
					<td>${emp.firstname}</td>
					<td>${emp.lastname}</td>
					<td>${emp.age}</td>
					<td>${emp.gender}</td>
					<td>${emp.address}</td>
					<td>${emp.email}</td>
					<td>${emp.department.name}</td>

					<td><spring:url
							value="/employee/updateEmployee/${emp.employeeId}"
							var="updateURL" /> <a href="${updateURL }">Update</a></td>
					<td><spring:url
							value="/employee/deleteEmployee/${emp.employeeId}"
							var="deleteURL" /> <a href="${deleteURL }">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
	</form:form>
</body>
</html>