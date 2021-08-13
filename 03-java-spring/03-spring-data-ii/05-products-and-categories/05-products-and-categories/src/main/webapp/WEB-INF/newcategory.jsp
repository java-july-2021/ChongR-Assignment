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
<title>New Category</title>
</head>
<body>
<h1>New Category</h1>

<form:form method="POST" action="/category/new" modelAttribute="category">

<p>
<form:label path="name">Name: </form:label>
<form:errors  path="name"></form:errors>
<form:input path="name"/>
</p>

<button> Create </button>

</form:form>



</body>
</html>