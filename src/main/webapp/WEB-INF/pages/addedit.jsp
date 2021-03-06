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
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<title>Moro System - Task1</title>
</head>

<body>
	<mytags:userbar />
	<h2>Moro Systems Task1 - add/edit user</h2>
	<form:form method="post" modelAttribute="user" action="addedit">
		<form:errors path="*" cssClass="errorblock" element="div" />

		<table>
			<tr>
				<td>UserName:</td>
				<td><form:input type="hidden" path="userid"
						value="${user.userid}" /> <form:input path="username"
						value="${user.username}" /></td>
				<td><form:input path="password" value="${user.password}" /></td>
				<td><form:errors path="username" cssClass="error" /></td>
			</tr>

			<tr>
				<td colspan="3"><input type="submit" value="Save user" /></td>
			</tr>
		</table>

	</form:form>

</body>
</html>