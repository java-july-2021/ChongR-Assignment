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
<title>Login</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">

<h1>Welcome to Mock Java Exam!</h1>

<hr>
<div class="row">

<div class="col">
	<p>Login</p>
	<p>${error}</p><!--  //Show if there's any error during loggin -->
	
		<form action="/login" method="POST" <%-- modelAttribute="userToLogIn" --%>>
			<div class="form-control">
				<label for="email">Email</label>
				<input type="text" name="loginemail">
			</div>
			<div class="form-control">
				<label for="password">Password</label>
				<input type="password" name="loginpassword">
			</div>
		
			<button>Login</button>
		
		</form >
</div>

<div class="col">
	<h2>Register</h2>
		<form:form action="/register" method="POST" modelAttribute="user">
			<div class="form-group">
				<form:label path="firstName">First Name</form:label>
				<form:errors path="firstName"/>
				<form:input class="form-control" path="firstName"/>
			</div>
		
			<div class="form-group">
				<form:label path="lastName">Last Name</form:label>
				<form:errors path="lastName"/>
				<form:input class="form-control" path="lastName"/>
			</div>
		
			<div class="form-group">
				<form:label path="email">Email</form:label>
				<form:errors path="email"/>
				<form:input type="email" class="form-control" path="email"/>
			</div>
			
			<div class="form-group">
				<form:label path="password">Password</form:label>
				<form:errors path="password"/>
				<form:input type="password" class="form-control" path="password"/>
			</div>
			
			<div class="form-group">
				<form:label path="confirmPassword">Confirm Password</form:label>
				<form:errors path="confirmPassword"/>
				<form:input type="password" class="form-control" path="confirmPassword"/>
			</div>
			
			<input class="btn btn-danger" type="submit" value="Submit"/>
		</form:form>
	</div>
</div>


</div>

</body>
</html>