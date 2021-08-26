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
<title>Create Task</title>
</head>
<body>

<h1>Create a new task</h1>

<form:form method="POST" action="/newtask" modelAttribute="task">
<p>
<form:label path="name"> Task: </form:label>
<form:errors path="name"/>
<form:input path="name"/>
</p>

<p>
<form:label path="assigned">Assignee: </form:label>
<form:select path="assigned">
	<c:forEach items="${allUsers}" var="victim">
	<option value=${ victim.id }>${ victim.firstName } ${ victim.lastName }</option>
	</c:forEach>
</form:select>
</p>

<p>
<form:label path="priority">Priority: </form:label>
<form:select path="priority">
	<form:option value="High">High</form:option>
	<form:option value="Medium">Medium</form:option>
	<form:option value="Low">Low</form:option>
</form:select>
</p>

<form:input type="hidden" value="${creator.id}" path="creator"/>

<button>Create</button>
</form:form>

</body>
</html>