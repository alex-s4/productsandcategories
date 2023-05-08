<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
</head>
<body>
	<h1>New Product</h1>
	<a href="../">Home</a>
	<hr>
	<form:form method="POST" action="/createProduct" modelAttribute="product">
	
		<table>

			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="description">Description</form:label></td>
				<td><form:input path="description" /></td>
			</tr>
			<tr>
				<td><form:label path="price">Price</form:label></td>
				<td><form:input type="number" step="0.01" path="price" /></td>
			</tr>
			
			<tr>
				<th colspan="2"><input type="submit" value="Submit"></th>
			</tr>
		</table>
		
		<p><form:errors path="name" /></p>
		<p><form:errors path="description" /></p>
		<p><form:errors path="price" /></p>
		
	</form:form>
</body>
</html>