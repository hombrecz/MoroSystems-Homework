<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="ISO-8859-2"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Moro System - Task1</title>
</head>

<body>
	<mytags:userbar />

	<h2>Moro Systems Task1 - view part</h2>
	<c:if test="${not empty status}">
		<c:if test="${status=='ok'}">
			<div>User: ${user.username}</div>
			<br />
			<table class="books">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Description</th>
				</tr>

				<c:forEach items="${user.books}" var="book">
					<tr>
						<td>${book.id}</td>
						<td>${book.title}</td>
						<td>${book.description}</td>
					</tr>
				</c:forEach>
			</table>

			<table class="accounts">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Account prefix</th>
					<th>Account Number</th>
					<th>Bank code</th>
				</tr>
				<c:forEach items="${user.accounts}" var="account">
					<tr>
						<td>${account.id}</td>
						<td>${account.name}</td>
						<td>${account.accountPrefix}</td>
						<td>${account.accountNumber}</td>
						<td>${account.bankCode}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

		<c:if test="${status=='null'}">
			<div>User: user not found!</div>
			<br />
		</c:if>

	</c:if>
</body>
</html>