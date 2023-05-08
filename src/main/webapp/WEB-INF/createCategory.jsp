<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Category</title>
</head>
<body>
	<h1>New Category</h1>
	<a href="../">Home</a>
	<hr>
	<form:form method="POST" action="/createCategory" modelAttribute="category">
	
		<table>

			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			
			<tr>
				<th colspan="2"><input type="submit" value="Submit"></th>
			</tr>
		</table>
		
		<p><form:errors path="name" /></p>
	
	</form:form>
</body>
</html>