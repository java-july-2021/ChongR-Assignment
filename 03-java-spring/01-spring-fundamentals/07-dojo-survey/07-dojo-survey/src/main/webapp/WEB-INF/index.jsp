<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Dojo Survey</title>
	<link rel="stylesheet" href="/css/style.css">
</head>

<body>	
	<div class="Info">
	
		<form method="post" action="/result">
		
			<div class="upper">
				<label>Your Name</label>
				<input type="text"  name="name" placeholder="Name">  
				<!-- Having a default "Name" in the box when I have a value="name"-->
				
				<label>Dojo Location</label>
					<select name="location" required>
						<option value="San Jose">San Jose</option>
						<option value="Chicago">Chicago</option>
						<option value="Los Angeles" >Los Angeles</option>
					</select>
					
				
				<label>Favorite Language</label>
					<select name="lang" required>
						<option value="Java">Java</option>
						<option value="Python">Python</option>
						<option value="JS">JS</option>
					</select>
			</div>
			
			<div class="lower">
				<label>Comment (Optional)</label>
				<textarea name="comment" placeholder="Comments"></textarea>
			</div>
			
			<input type="submit">
			
		</form>
	</div>


</body>
</html>