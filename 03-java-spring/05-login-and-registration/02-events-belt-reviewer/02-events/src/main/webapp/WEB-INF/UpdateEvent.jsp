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
<title>Edit Event</title>
</head>
<body>

<h1>${event.name}</h1>

<h3>Edit Event</h3>

<form:form method="POST" action="/editEventInfo/${event.id}" modelAttribute="event">
<p>
<form:label path="name">Name: </form:label>
<form:input path="name"></form:input>
<form:errors path="name"></form:errors>
</p>

<p>
<form:label path="even_date">Date:</form:label>
<form:input type="Date" path="even_date"></form:input>
<form:errors path="even_date"></form:errors>
</p>

<p>
<form:label path="city">Location: </form:label>
<form:input path="city"></form:input>
<form:errors path="city"></form:errors>
</p>

<p>
<form:label path="state">State:</form:label>
<form:input path="state"></form:input>
<form:errors path="state"></form:errors>
</p>

<button>Edit</button>
</form:form>

</body>
</html>