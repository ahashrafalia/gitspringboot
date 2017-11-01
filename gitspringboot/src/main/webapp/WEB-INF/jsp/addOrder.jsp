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
<form:form id="addOrder" modelAttribute="order" action="addOrder" method="post">
<table>
	<tr><td colspan="2">Add Order</td></tr>
	<tr><td>Select Customer</td><td> <form:select path = "custId">
                     <form:option value = "0" label = "Select"/>
                     <form:options items = "${mapCustomer}" />
                  </form:select></td></tr>
	<tr><td>Price</td><td><form:input path="totPrice"/> </td></tr>
	<tr><td>Description</td><td><form:input path="orderDesc"/> </td></tr>
	<tr><td colspan="2"><form:button value="Add Order" >Add Order</form:button> </td></tr>
</table>
</form:form>
</body>
</html>