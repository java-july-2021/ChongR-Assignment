<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Show Info</title>
</head>

<body>
	<h1>Submitted Info</h1>
	<h3>Name: <c:out value="${name}"/></h3>
	<h3>Location: <c:out value="${location}"/></h3>
	<h3>Favorite Language: <c:out value="${lang}"/> !!!</h3>
	<h3>Comment: <c:out value="${comment}"/></h3>
	
	<button action="/index.jsp">Go Back</button>

</body>
</html>