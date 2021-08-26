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

<h1>Log In Successful!</h1>

<a href="/logout">Log Out</a>

<h1>Hi ${user.firstName}!</h1>

<%-- <form:form method="POST" action="/idea/addIdea" modelAttribute="ideaAAA">
<form:label path="iBody">Post ideas</form:label>
<form:errors path="iBpdy"/>
<form:textarea path="iBody"/>
<form:input type="hidden" value="${user.id }" path="author"/>
<button>Add Idea</button>
</form:form> --%>


<form:form method="POST" action="" modelAttribute="idea">
<form:label path="iBody">Post ideas</form:label>
</form:form>


<hr>
<h3>All Ideas</h3>
<c:forEach items="${ideas}" var="idea">

<p>${idea.author.firstName} says:</p>
<p>${idea.iBody}</p>
<p><a href="/idea/like/${idea.id }">Like</a> - ${idea.likers.size() }</p>

</c:forEach>


</body>
</html>