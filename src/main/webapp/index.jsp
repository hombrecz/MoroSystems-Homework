<%@ page language="java" 
	contentType="text/html; charset=ISO-8859-2" 
	pageEncoding="ISO-8859-2"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Moro System - Task1</title>
	</head>
		<a href="<c:url value="/j_spring_security_logout" />" >Logout</a>
	<body>
		<h1>Moro System - Task1</h1>
		<table class="menu">
		<tr>
		    <th>Phase</th>
		    <th>Description</th>
		    <th>Link</th>
		</tr>
		<tr>
			<td>1</td>
			<td>Viewing data</td>
			<td>
				<form method="post" action="oldView">
					<input type="submit" value="View examples">
				</form> 	
			</td>
		</tr>
		<tr>
			<td>1</td>
			<td>Viewing image</td>
			<td>	
			    <form method="post" action="image">
			    	<input type="text" name="imagename" value="singleton_logo.png">
	            	<input type="submit" value="Show Image">
				</form>
			</td>
		</tr>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
		<tr>
			<td>2</td>
			<td>Database</td>
			<td>
				<form method="post" action="view">
					<input type="text" name="userID" value="1">
	 				<input type="submit" value="Select user ID">
				</form>
			</td>
		</tr>
		</sec:authorize>
		<tr>
			<td>3</td>
			<td>Users list and adding/modifying</td>
			<td>
				<form method="get" action="users">
					<input type="submit" value="View all users">
				</form>
			</td>
		</tr>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
		<tr>
			<td>4</td>
			<td>Admin</td>
			<td>
				<form method="get" action="admin/adminUsers">
					<input type="submit" value="Admin">
				</form> 
			</td>
		</tr>
		</sec:authorize>
		<tr>
			<td>5</td>
			<td>Lazy loading and Eager strategy</td>
			<td>
				<form method="post" action="viewBetter">
					<input type="text" name="userId" value="1">
					<input type="submit" value="Select user ID">
				</form>
			</td>
		</tr>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
		<tr>
			<td>6</td>
			<td>Spring security</td>
			<td>done</td>
		</tr>
		<tr>
			<td>7</td>
			<td>Property editor and interceptor</td>
			<td>done</td>
		</tr>
		<tr>
			<td>8</td>
			<td>Spring security - database</td>
			<td>done</td>
		</tr>
		</sec:authorize>
		</table>
	</body> 
</html> 