<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojos & Ninjas</title>
</head>
<body>

<h1>Dojos & Ninjas</h1>
<hr>
<h3><a href="/dojo/new">New Dojo</a> | <a href="/ninja/new">New Ninja</a></h3>

<table>
<tr>
<th>ID</th>
<th>Location</th>
<th>Action</th>
</tr>

<tbody>
<c:forEach items="${allDojo}" var="dojo">
<tr>
<td>${dojo.id }</td>
<td><a href="/dojo/${dojo.id}">${dojo.name }</a></td>
<td><a href="/edit/${dojo.id}">Edit</a> | <a href="delete/${dojo.id}">Delete</a></td>
</tr>
</c:forEach>
</tbody>



</table>

</body>
</html>