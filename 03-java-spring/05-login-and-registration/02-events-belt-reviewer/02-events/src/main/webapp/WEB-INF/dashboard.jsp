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
<title>Insert title here</title>
</head>
<body>

<h1>Log In Successful!</h1>

<a href="/logout">Log Out</a>

<h1>Welcome, ${user.firstName} ${user.lastName}</h1>



<h3>Here are some of the events in your state:</h3>
<table>
<tr>
	<th>Name</th>
	<th>Date</th>
	<th>Location</th>
	<th>Action / Status</th>
</tr>

<tbody>
<c:forEach items="${EventSameState}" var="event">
	<td><a href="">${event.name}</a></td>
	<td>${event.event_date}</td>
	<td>${event.city}</td>
	<td>${event.host.firstName}</td>
	
	<c:choose>
	
		<c:when test="${event.host.id} == ${user.id}">
			<td><a href="editEvent/${event.id }">Edit</a> | <a href="deldetEvent/${event.id}">Delete</a>
		</c:when>
		
		<c:otherwise>
			<c:choose>
				<c:when test="${event.users.contains(user)}">
					<td> Joining  <a href="event/${event.id}/a/cancel">Cancel</a></td>
				</c:when>
				<c:otherwise>
					<a href="event/${event.id}/a/join">Join</a>
				</c:otherwise>
			</c:choose>
		</c:otherwise>

	
	</c:choose>
	
</c:forEach>
</tbody>
</table>





<h3>Here are some of the events in other states:</h3>
<table>
<tr>
	<th>Name</th>
	<th>Date</th>
	<th>Location</th>
	<th>Action / Status</th>
</tr>

<tbody>
<c:forEach items="${EventOtherState}" var="event">
	<td><a href="">${event.name}</a></td>
	<td>${event.event_date}</td>
	<td>${event.city}</td>
	<td>${event.host.firstName}</td>

	<c:choose>
	
		<c:when test="${event.host.id} == ${user.id}">
			<td><a href="editEvent/${event.id }">Edit</a> | <a href="deldetEvent/${event.id}">Delete</a>
		</c:when>
		
		<c:otherwise>
			<c:choose>
				<c:when test="${event.users.contains(user)}">
					<td> Joining  <a href="event/${event.id}/a/cancel">Cancel</a></td>
				</c:when>
			
				<c:otherwise>
					<a href="event/${event.id}/a/join">Join</a>
				</c:otherwise>
			</c:choose>
		</c:otherwise>

	
	</c:choose>
	
	
</c:forEach>
</tbody>
</table>


<h2>Create an Event</h2>

<form:form action="/createEvent" method="post" modelAttribute="event">

<p>
<form:label path="name">Name: </form:label>
<form:errors  path="name"></form:errors>
<form:input path="name"/>
</p>


<p>
<form:label path="event_date">Date: </form:label>
<form:errors  path="event_date"></form:errors>
<form:input type="date" path="event_date" placeholder="YYYY/MM/DD"/>
</p>


<p>
<form:label path="city">Location: </form:label>
<form:errors  path="city"></form:errors>
<form:input path="city"/>
</p>

<p>
<form:label path="state">State: </form:label>
<form:errors  path="state"></form:errors>
<form:input path="state" placeholder="XX"/>
</p>
<button> Create </button>

</form:form>



</body>
</html>


