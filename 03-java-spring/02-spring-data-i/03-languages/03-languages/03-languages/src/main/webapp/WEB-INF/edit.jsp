<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Language</title>
</head>
<body>

<form:form action="/edit/${language.id}" method="POST" modelAttribute="languages">
<p>
<form:label path="name">Name:</form:label>
<form:errors path="name"/>
<form:input path="name"/>
</p>

<p>
<form:label path="creator">Creator:</form:label>
<form:errors path="creator"/>
<form:input path="creator"/>
</p>

<p>
<form:label path="version">Version:</form:label>
<form:errors path="version"/>
<form:input path="version"/>
</p>

<button>Submit</button>

</form:form>

</body>
</html>