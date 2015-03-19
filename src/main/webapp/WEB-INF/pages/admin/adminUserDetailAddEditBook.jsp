<%@ page language="java" 
	contentType="text/html; charset=ISO-8859-2" 
	pageEncoding="ISO-8859-2"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Moro System - Task1</title>
	</head>
	
	<body>
	<mytags:userbar/>
		<h2>Moro Systems Task1 - add/edit book</h2>
		<form:form method="post" modelAttribute="book" action="adminUserDetailAddEditBook">
			<table>
				<tr>
				    <th>Book</th>
				    <th>Title</th>
				    <th>Description</th>
				    <th>&nbsp;</th>
				</tr>
				<tr>
					<td><form:input type="hidden" path="id" value="${book.id}" /></td>
					<td><form:input type="text" path="title" value="${book.title}"/></td>
					<td><form:input type="text" path="description" value="${book.description}"/></td>
					<td><form:input type="hidden" path="user.userid" value="${book.user.userid}"/></td>
				</tr>
				<tr>
					<td colspan="3"><input type="submit" value="Save book"/></td>
				</tr>
			</table>
		</form:form>
		
	</body>
</html>