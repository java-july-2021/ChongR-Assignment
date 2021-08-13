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
<title>Insert title here</title>
</head>
<body>

<h1>${product.name}</h1>

<h2>Categories: </h2>
<ul>
<c:forEach items="${product.categories}" var="category">
<li>${category.name}
</c:forEach>
</ul>


<form:form>
<p>
<form:select path="product">
<c:forEach items="${product.categories}" var="category">
<option value="${category.id}">${category.name}</option>
</c:forEach>
</form:select>
</p>

<button>Add</button>

</form:form>



</body>
</html>