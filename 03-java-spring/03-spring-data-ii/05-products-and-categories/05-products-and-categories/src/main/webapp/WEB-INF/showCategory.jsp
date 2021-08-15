<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category Page</title>
</head>
<body>

<h1>${category.name}</h1>

<h2>Products: </h2>
<ul>
<c:forEach items="${category.products}" var="product">
<li>${product.name} | ${product.description} | ${product.price}
</c:forEach>
</ul>


<form:form method="POST" action="/editcategory/${category.id}">
<p>
<form:select name="prod">
<c:forEach items="${notInCat}" var="product">
<option value="${product.id}">${product.name}</option>
</c:forEach>
</form:select>
</p>

<button>Add</button>

</form:form>

</body>
</html>