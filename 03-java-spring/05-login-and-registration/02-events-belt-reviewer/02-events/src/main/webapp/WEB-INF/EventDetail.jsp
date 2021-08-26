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
<title>Event Detail</title>
</head>
<body>
<!-- Event Info -->
<h1>${event.name}</h1>
<hr>
<h3>Host: ${user.firstName} ${user.lastName}</h3>
<h3>Date: ${event.event_date }</h3>
<h3>Location: ${event.city}, ${event.state}</h3>
<h3>People who are attending this event: ${event.User.size()}</h3>

<table>
	<tr>
		<th>Name</th>
		<th>Location</th>
	</tr>
	
	<tbody>
		<c:forEach items="${event.users}" var="user">
		<tr>
		<td><a href="">${user.firstName} ${user.lastName}</a></td>
		<td><a href="">${user.city}, ${user.state}</a></td>
		</tr>
		</c:forEach>
	</tbody>
</table>


<!-- Message Window -->
<h1>Message Wall</h1>

<c:forEach items="${message}">
	<h4>${message.users.firstName} says: </h4>
	<h4>${message.message_body}</h4>
	<hr>
 </c:forEach>
 

<form method="POST" action="/eventinfo/${event.id}">
<p>
<label for="message">Add Comment:</label>
<textarea name="message" id="message"></textarea>
</p>

<button>Add</button>

</form>



<a href="/dashboard">Dashboard</a>






</body>
</html>