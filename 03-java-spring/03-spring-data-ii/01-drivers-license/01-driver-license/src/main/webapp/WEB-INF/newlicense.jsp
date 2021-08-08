<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New License</title>
</head>
<body>

<h1> New License </h1>
<hr>
<form:form action="/newlicense" method="post" modelAttribute="license">

<p>
<form:label path="person">Person:</form:label>
<form:errors path="person"/>
<form:select path="person">
<c:forEach items="${people}" var="person">
<option value="${person.id}">${person.firstName} ${person.lastName}</option>
</c:forEach>

</form:select>
</p>

<p>
<form:label path="state">State:</form:label>
<form:input path="state"/>
<form:errors path="state"></form:errors>
</p>

<p>
<form:label path="expirationDate">Expiration Date: </form:label>
<form:input type="date" path="expirationDate"/>
<form:errors path="expirationDate"></form:errors>
</p> 

<button>Create!</button>
 
</form:form> 



</body>
</html>