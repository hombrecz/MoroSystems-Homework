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
	
	<h2>Moro Systems Task1 - users list</h2> 	
		<table class="data">
			<tr>
			    <th>Id</th>
			    <th>Username</th>
			    <th>&nbsp;</th>
			</tr>
		<c:if test="${not empty userslist}">
		<c:forEach items="${userslist}" var="user">
		    <tr>	
				<td>${user.userid}</td>
				<td>${user.username}</td>
				<td>
					<form:form method="get" modelAttribute="user" action="addedit">
						<form:input type="hidden" path="userid" value="${user.userid}"/>
						<form:input type="hidden" path="username" value="${user.username}"/>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<input type="submit" value="edit"/>
						</sec:authorize>
					</form:form>	
				</td>
			</tr>
		</c:forEach>
		</c:if>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<tr>
				<td>
					<form:form method="get" action="addedit">
						<input type="hidden" name="userid"value="-1">
						<input type="hidden" name="username"value="new name">
						<input type="submit" value="add user">
					</form:form>
				</td>
			</tr>
		</sec:authorize>			
		</table>		
	
	</body>
</html>