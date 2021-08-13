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
<title>New Product</title>
</head>
<body>

<form:form action="/product/new" method="POST" modelAttribute="product">

<p>
<form:label path="name">Name: </form:label>
<form:errors  path="name"></form:errors>
<form:input path="name"/>
</p>

<p>
<form:label path="description">Description: </form:label>
<form:errors  path="description"></form:errors>
<form:textarea path="description"/>
</p>


<p>
<form:label path="price">Price: </form:label>
<form:errors  path="price"></form:errors>
<form:input path="price"/>
</p>

<button> Create </button>

</form:form>



</body>
</html>