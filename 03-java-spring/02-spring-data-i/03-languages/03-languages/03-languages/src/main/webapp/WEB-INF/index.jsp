<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Language Index</title>
</head>
<body>
<h1>Welcome to languages</h1>
<hr>
<table border=1>

	<thead>
		<tr>
		<td>Name</td>
		<td>Creator</td>
		<td>Version</td>
		<td>Action</td>
		</tr>
	</thead>
	<tbody>	 
		<c:forEach items="${allLang}" var="lang">
		<tr>
		<td><a href="/show/${lang.name}">${lang.name}</a></td>  
		<td>${lang.creator}</td> 
		<td>${lang.version}</td> 
		<td><a href="/edit/${lang.id}">Edit</a>|<a href="/delete/${lang.id}">Delete</a></td> 
		</tr>
		</c:forEach>
	</tbody>
	
</table>

<h3>Create New Language</h3>
<form:form action="/" method="POST" modelAttribute="languages">
<p>
<form:label path="name">Name:</form:label>
<form:errors path="name"/>
<form:input path="name"/>
</p>

<p>
<form:label path="creator">Creator:</form:label>
<form:errors path="creator"/>
<form:input path="creator"/>
</p>

<p>
<form:label path="version">Version:</form:label>
<form:errors path="version"/>
<form:input path="version"/>
</p>

<button>Submit</button>

</form:form>

</body>
</html>