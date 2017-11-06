<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form id="addCustomer" modelAttribute="customer" action="addCustomer" method="post">
<table>
	<tr><td colspan="2">Add Customer</td></tr>
	<tr><td>FirstName</td><td><form:input path="firstName"/> <td> <form:errors path="firstName" cssStyle="color: red;"/></td></td></tr>
	<tr><td>LastName</td><td><form:input path="lastName"/> </td></tr>
	<tr><td>Street</td><td><form:input path="street"/> </td></tr>
	<tr><td colspan="2"><form:button value="Add Customer" >AddCustomer</form:button> </td></tr>
</table>
</form:form>
</body>
</html>