<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Person</title>
</head>
<body>
<h1> New Person </h1>
<hr>
<form:form action="/new" method="post" modelAttribute="person">

<p>
<form:label path="firstName">First Name:</form:label>
<form:input path="firstName"/>
<form:errors path="firstName"></form:errors>
</p>

<p>
<form:label path="lastName">Last Name:</form:label>
<form:input path="lastName"/>
<form:errors path="lastName"></form:errors>
</p>

<button>Add Now!</button>

</form:form> 


</body>
</html>