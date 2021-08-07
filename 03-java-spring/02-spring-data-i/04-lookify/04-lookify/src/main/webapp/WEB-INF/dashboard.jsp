<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3><a href="/songs/new">Add New</a></h3>
<h3><a href="/search/top">Top Songs</a></h3>

<form:form action="/" method="GET" modelAttribute="song">
<form:label path="name">Search</form:label>
<form:errors path="name"/>
<form:input path="name"/>
<button>Submit</button>
</form:form>

<table>
<thead>
<tr>
<td>Name</td>
<td>Rating</td>
<td>Action</td>
</tr>
</thead>
<tbody>
<c:forEach items="allSongs" var="song">
<tr>
<td><a href="/show/${song.id}">${song.name}</a></td>
<td>${song.rating}</td>
<td><a href="/delete/${song.id}">Delete</a></td>
</tr>
</c:forEach>
</tbody>
</table>

</body>
</html>