<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Users</title>
</head>
<body>

<h1>${person.firstName} ${person.lastName}</h1>
<hr>

<p> License Number:  ${person.license.returnLicenseNumbers()} </p>

<p> Expiration Date:  ${person.license.expirationDate} </p>

<p> State:  ${person.license.state} </p>

</body>
</html>