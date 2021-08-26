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
<title>New Question</title>
</head>
<body>
<h1>What is your question?</h1>

<form:form action="/newquestion" method="POST" modelAttribute="question">

<p>
<form:label path="question_body">Question: </form:label>
<form:errors  path="question_body"></form:errors>
<form:textarea path="question_body"/>
</p>

<p>
<form:label path="tagsFromFrontEnd">Tags: </form:label>  <!--   //Why tagsFromFrontEnd but not List<Tag> tags -->
<form:errors  path="tagsFromFrontEnd"></form:errors>
<form:input path="tagsFromFrontEnd"/>
</p>

<button>Submit</button>
</form:form>

</body>
</html>