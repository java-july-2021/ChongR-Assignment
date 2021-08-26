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
<title>Questions Dashboard</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1>Questions Dashboard</h1>

<div class="container">

	<table class="table table-dark">
	<tr>
		<th>Question</th>
		<th>Tags</th>
	</tr>
	
	<tbody>
		<c:forEach items="${allQuestion}" var="question">
		<tr>
		<td><a href="/questions/${question.id}">${question.question_body}</a></td>
			<c:forEach items="${question.tags}" var="tag">
			<td class="tagTd">${tag.subject}</td>
			</c:forEach>
		</tr>
		</c:forEach>
	</tbody>
	</table>
</div>     

<h3><a href="/questions/new">New Question</a></h3>
</body>
</html>