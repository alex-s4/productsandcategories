<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Page</title>
</head>
<body>
	<h1>${product.getName()}</h1>
	<a href="/">Home</a>
	<hr>
	<h2>Categories:</h2>
	<ul>
		<c:forEach var="category" items="${categoriesOnProd}">
			<li>${category.getName()}</li>
		</c:forEach>
		
	</ul>
	
	
	<hr>
	
	<form:form method="POST" action="/products/${product.getId()}" modelAttribute="product">
		<input type="hidden" name="_method" value="PUT">
		<form:input type="hidden" path="name" value="${product.getName()}" />
		<form:input type="hidden" path="description" value="${product.getDescription()}" />
		<form:input type="hidden" path="price" value="${product.getPrice()}" />
		
		
			<c:forEach var="category" items="${categoriesOnProd}">
				<form:input type="hidden" path="categories" value="${category.getId()}" />
			</c:forEach>
		
		
		<form:label path="categories"><h2>Add Category:</h2></form:label>
		
		<form:select path="categories" multiple="false">
        
	        <c:forEach var="category" items="${categoriesNotOnProd}">
				<form:option value="${category.getId()}">${category.getName()}</form:option>
	        </c:forEach>
        
        </form:select>
        
        
        <input type="submit" value="Add">
	</form:form>
	
	
	
</body>
</html>