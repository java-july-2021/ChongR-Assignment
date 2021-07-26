<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Date</title>
	<link rel="stylesheet" type="text/css" href="/css/datestyle.css">
	<script type="text/javascript" src="/js/date.js"></script>
</head>

<body>

	<h1> The time is: <%= new Date() %></h1>
	<h1> The time is: <c:out value="${date}"/></h1>

</body>
</html>