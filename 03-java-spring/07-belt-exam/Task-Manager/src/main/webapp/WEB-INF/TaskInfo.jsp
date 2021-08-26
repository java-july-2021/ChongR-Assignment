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
<title>Task Info</title>
</head>
<body>
<h1>Task:  ${task.name}</h1>
<hr>
<h3>Creator: ${task.creator.firstName} ${task.creator.lastName}</h3>

<h3>Assignee: ${task.assigned.firstName}</h3>

<h3>Priority: ${task.priority}</h3>

<a href="/tasks/${task.id}/edit">Edit</a>

<a href="/deleteTask/${task.id}">Delete</a>

<a href="/deleteTask/${task.id}">Completed</a>

</body>
</html>