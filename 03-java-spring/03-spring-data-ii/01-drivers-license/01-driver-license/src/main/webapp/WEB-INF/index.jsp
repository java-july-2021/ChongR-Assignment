<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Person & License</title>
</head>
<body>
<h1>Person & License</h1>
<hr>
<a href="/persons/new">Add Person</a>  |  <a href="/licenses/create ">Add a License</a>
<hr>
<table>
<tr>
<th>ID</th>
<th>First Name</th>
<th>Last Name</th>
</tr>
<tbody>
<c:forEach items="${persons}" var="person">
<tr>
<td><a href="/${person.id}">${person.id}</a></td>
<td>${person.firstName}</td>
<td>${person.lastName}</td>
</tr>
</c:forEach>

</tbody>

</table>
</body>
</html>