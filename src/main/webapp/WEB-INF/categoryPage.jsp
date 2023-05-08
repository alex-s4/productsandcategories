<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Page</title>
</head>
<body>
	<h1>${category.getName()}</h1>
	<a href="/">Home</a>
	<hr>
	<h2>Products:</h2>
	<ul>
		<c:forEach var="product" items="${productsOnCat}">
			<li>${product.getName()}</li>
		</c:forEach>
		
	</ul>
	<hr>
	
	<form:form method="POST" action="/categories/${category.getId()}" modelAttribute="category">
		<input type="hidden" name="_method" value="PUT">
		<form:input type="hidden" path="name" value="${category.getName()}" />
		
			<c:forEach var="product" items="${productsOnCat}">
				<form:input type="hidden" path="products" value="${product.getId()}" />
			</c:forEach>
		
			<form:label path="products"><h2>Add Product:</h2></form:label>
			
			<form:select path="products" multiple="false">
        
	        <c:forEach var="product" items="${productsNotOnCat}">
				<form:option value="${product.getId()}">${product.getName()}</form:option>
	        </c:forEach>
        
        </form:select>
		
		<input type="submit" value="Add">
	</form:form>
	




</body>
</html>