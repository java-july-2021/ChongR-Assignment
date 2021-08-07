<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Song Detail</title>
</head>
<body>

<h3><a href="/dashboard">Dashboard</a></h3>

<h2>Title: ${song.title}</h2>
<h2>Artist: ${song.artist}</h2>
<h2>Rating: ${song.rating}</h2>

<a href="/delete/${song.id}">Delete</a>

</body>
</html>