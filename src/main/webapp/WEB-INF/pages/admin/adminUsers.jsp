<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="ISO-8859-2"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Moro System - Task1</title>
</head>

<body>
	<mytags:userbar />

	<h2>Moro Systems Task1 - admin users</h2>
	<a href="<c:url value="/j_spring_security_logout" />"> Logout</a>
	<c:if test="${not empty userslist}">
		<table class="data">
			<tr>
				<th>Id</th>
				<th>Username</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${userslist}" var="user">
				<tr>
					<td>${user.userid}</td>
					<td>${user.username}</td>
					<td><form:form method="get" modelAttribute="user"
							action="adminUserAddEdit">
							<form:input type="hidden" path="userid" value="${user.userid}" />
							<form:input type="hidden" path="username"
								value="${user.username}" />
							<form:input type="hidden" path="enabled" value="${user.enabled}" />
							<input type="submit" value="Edit" />
						</form:form></td>
					<td><form:form method="post" modelAttribute="user"
							action="adminUserDelete">
							<form:input type="hidden" path="userid" value="${user.userid}" />
							<form:input type="hidden" path="username"
								value="${user.username}" />
							<form:input type="hidden" path="enabled" value="${user.enabled}" />
							<input type="submit" value="Delete" />
						</form:form></td>
					<td><form:form method="get" modelAttribute="user"
							action="adminUserDetail">
							<form:input type="hidden" path="userid" value="${user.userid}" />
							<form:input type="hidden" path="username"
								value="${user.username}" />
							<form:input type="hidden" path="enabled" value="${user.enabled}" />
							<input type="submit" value="Detail" />
						</form:form></td>

				</tr>
			</c:forEach>
			<form:form method="get" modelAttribute="user"
				action="adminUserAddEdit">
				<tr>
					<td>&nbsp;</td>
					<td><form:input type="hidden" path="userid" value="-1" /> <form:input
							type="hidden" path="username" value="new name" /> <form:input
							type="hidden" path="password" value="new password" /> <form:input
							type="hidden" path="enabled" value="true" /></td>
					<td><input type="submit" value="Add user"></td>
				</tr>
			</form:form>
		</table>
	</c:if>
</body>
</html>