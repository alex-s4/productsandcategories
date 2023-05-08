<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h1>Home Page</h1>
	<a href="../products/new">New Product</a>
	<a href="../categories/new">New Category</a>
	<hr>
	<table>
		<tr>
			<th>Products</th>
			<th>Categories</th>
		</tr>
		<tr>
			<td>
				<ul>
					<c:forEach var="product" items="${products}">
						<li><a href="/products/${product.getId() }">${product.getName()}</a></li>
					</c:forEach>
				</ul>
			</td>
			<td>
				<ul>
					<c:forEach var="category" items="${categories}">
						<li><a href="/categories/${category.getId() }">${category.getName()}</a></li>
					</c:forEach>
				</ul>
			</td>
		</tr>
	</table>
</body>
</html>