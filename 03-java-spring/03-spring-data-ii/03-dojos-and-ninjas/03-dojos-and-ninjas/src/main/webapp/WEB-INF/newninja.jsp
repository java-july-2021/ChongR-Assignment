<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Ninja</title>
</head>
<body>

<h1>New Ninja</h1>
<hr>

<form:form action="/newninja" method="post" modelAttribute="ninja">

<p>
<form:label path="dojo">Dojo:</form:label>
<form:select path="dojo">
<c:forEach items="${allDojos}" var="dojo">
<option value="${dojo.id }">${dojo.name}</option>
</c:forEach>
</form:select>
</p>

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

<p>
<form:label path="age">Age:</form:label>
<form:input path="age"/>
<form:errors path="age"></form:errors>
</p>

<button>Create !</button>



</form:form>

</body>
</html>