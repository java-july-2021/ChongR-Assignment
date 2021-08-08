<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Top Ten Songs</h1>
		<a class="float-right" href="/dashboard">Dashboard</a>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Rating</th>
					<th>Title</th>
					<th>Artist</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${song}" var="song">
				<tr>
					<td>${song.rating }</td>
					<td><a href="/songs/${song.id}">${song.name}</a></td>
					<td>${song.artist}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
</body>
</html>