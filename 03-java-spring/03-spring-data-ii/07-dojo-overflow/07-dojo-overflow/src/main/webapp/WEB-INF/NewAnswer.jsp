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
<title>New Answer</title>
</head>
<body>
<h1> <c:out value="${question.question_body}"/> </h1>

<ul> <c:forEach items="${question.tags }" var="tag">
 	<li>${tag.subject }</li>
</c:forEach></ul>

<hr>
<!-- <table>
	<tr>
		<th>Answers</th>
	</tr>
	<tbody> -->
<h2>Answers :</h2>
	<ul>
	<c:forEach items="${question.answers}" var="answer">
		<li>${answer.answer_body}</li>
	</c:forEach>
	</ul>
	<hr>
<!-- 	</tbody>
</table> -->

<form:form action="/newanswer/${question.id }" method="POST" modelAttribute="answer">
<form:hidden path="question" value="${question.id }"/>
<p>
<form:label path="answer_body">answer: </form:label>
<form:errors  path="answer_body"></form:errors>
<form:textarea path="answer_body"/>
</p>

<button>Answer it</button>
</form:form> 

</body>
</html>