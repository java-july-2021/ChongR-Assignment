<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create new Song</title>
</head>
<body>

<form:form action="/" method="POST" modelAttribute="song">
<p>
<form:label path="title">Title</form:label>
<form:errors path="title"/>
<form:input path="title"/>
</p>

<p>
<form:label path="artist">Artist</form:label>
<form:errors path="artist"/>
<form:input path="artist"/>
</p>

<p>
<form:select path="rating">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
<option value="7">7</option>
<option value="8">8</option>
<option value="9">9</option>
<option value="10">10</option>
</form:select>
</p>

<button>Add Song</button>
</form:form>

</body>
</html>