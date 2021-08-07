<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/">Dashboard</a>

<c:out value="${thiLang.name}"/>
<c:out value="${thiLang.creator}"/>
<c:out value="${thiLang.version}"/>

<p><a href="/edit/${thisLang.id}">Edit</a>|<a href="/delete/${thisLang.id}">Delete</a></p>
</body>
</html>