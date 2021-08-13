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
<title>Shoppers</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1>Welcome Shoppers</h1>
<hr>
<h3><a href="/product/new">New Product</a>  |  <a href="/category/new">New Category</a></h3>

<div class="container">

<table class="table table-dark">
<tr>
	<th>ID</th>
</tr>
<tbody>

<c:forEach items="${allCat}" var="cat">
<tr>
<td>${cat.id}</td>
<td><a href="/category/${cat.id}">${cat.Name}</a></td>
</c:forEach>


</tbody>
</table>



</div>
</body>
</html>