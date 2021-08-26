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
<title>Dashboard</title>
</head>
<body>
<h1>Welcome ${user.firstName} ${user.lastName}! </h1>
<h3><a href="/logout">Log Out</a></h3>
<table>
<tr>
	<th>Task</th>
	<th>Creator</th>
	<th>Assignee</th>
	<th>Priority</th>
</tr>


<tbody>
<c:forEach items="${allTasks }" var="task">
<tr>
<td><a href="/tasks/${task.id}">${task.name}</a></td>
<td>${task.creator.firstName} ${task.creator.lastName}</td>
<td>${task.assigned.firstName}</td>
<td>${task.priority}</td>
</tr>
</c:forEach>

</tbody>

</table>


<a href="/tasks/new">Create Task</a>
</body>
</html>