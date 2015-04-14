<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="ISO-8859-2"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	<h2>Moro Systems Task1 - user detail</h2>

	<h3>Books</h3>
	<table class="data">
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>&nbsp;</th>
			<th>&nbsp;</th>
		</tr>
		<c:if test="${not empty books}">
			<c:forEach items="${books}" var="book">
				<tr>
					<td>${book.title}</td>
					<td>${book.description}</td>
					<td><form:form method="get" modelAttribute="book"
							action="adminUserDetailAddEditBook">
							<form:input type="hidden" path="id" value="${book.id}" />
							<form:input type="hidden" path="title" value="${book.title}" />
							<form:input type="hidden" path="description"
								value="${book.description}" />
							<form:input type="hidden" path="user.userid"
								value="${book.user.userid}" />
							<input type="submit" value="Edit" />
						</form:form></td>
					<td><form:form method="post" modelAttribute="book"
							action="adminUserDetailDeleteBook">
							<form:input type="hidden" path="id" value="${book.id}" />
							<form:input type="hidden" path="title" value="${book.title}" />
							<form:input type="hidden" path="description"
								value="${book.description}" />
							<form:input type="hidden" path="user.userid"
								value="${book.user.userid}" />
							<input type="submit" value="Delete" />
						</form:form></td>
				</tr>
			</c:forEach>
		
		Favorite book:	
		<form:form method="post" modelAttribute="user"
				action="adminUserFavoriteBook">
				<form:select path="favorite_book_id" items="${books}"
					itemLabel="title" />
				<form:input type="hidden" path="userid" value="${user.userid}" />
				<input type="submit" value="Set" />
			</form:form>

		</c:if>
		<form:form method="get" modelAttribute="user"
			action="adminUserDetailAddBook">
			<tr>
				<form:input type="hidden" path="userid" value="${user.userid}" />
				<td><input type="submit" value="Add"></td>
				<td>&nbsp;</td>
			</tr>
		</form:form>
	</table>


	<h3>Accounts</h3>
	<table class="data">
		<tr>
			<th>Name</th>
			<th>Account prefix</th>
			<th>Account Number</th>
			<th>Bank code</th>
			<th>&nbsp;</th>
			<th>&nbsp;</th>
		</tr>
		<c:if test="${not empty accounts}">
			<c:forEach items="${accounts}" var="account">
				<tr>
					<td>${account.name}</td>
					<td>${account.accountPrefix}</td>
					<td>${account.accountNumber}</td>
					<td>${account.bankCode}</td>
					<td><form:form method="get" modelAttribute="account"
							action="adminUserDetailAddEditAccount">
							<form:input type="hidden" path="id" value="${account.id}" />
							<form:input type="hidden" path="name" value="${account.name}" />
							<form:input type="hidden" path="accountPrefix"
								value="${account.accountPrefix}" />
							<form:input type="hidden" path="accountNumber"
								value="${account.accountNumber}" />
							<form:input type="hidden" path="bankCode"
								value="${account.bankCode}" />
							<form:input type="hidden" path="user.userid"
								value="${account.user.userid}" />
							<input type="submit" value="Edit" />
						</form:form></td>
					<td><form:form method="post" modelAttribute="account"
							action="adminUserDetailDeleteAccount">
							<form:input type="hidden" path="id" value="${account.id}" />
							<form:input type="hidden" path="name" value="${account.name}" />
							<form:input type="hidden" path="accountPrefix"
								value="${account.accountPrefix}" />
							<form:input type="hidden" path="accountNumber"
								value="${account.accountNumber}" />
							<form:input type="hidden" path="bankCode"
								value="${account.bankCode}" />
							<form:input type="hidden" path="user.userid"
								value="${account.user.userid}" />
							<input type="submit" value="Delete" />
						</form:form></td>
				</tr>
			</c:forEach>
		
		Preffered account:
		<form:form method="post" modelAttribute="user"
				action="adminUserFavoriteAccount">
				<form:select path="favorite_account_id" items="${accounts}"
					itemLabel="name" />
				<form:input type="hidden" path="userid" value="${user.userid}" />
				<input type="submit" value="Set" />
			</form:form>

		</c:if>
		<form:form method="get" modelAttribute="user"
			action="adminUserDetailAddAccount">
			<tr>
				<form:input type="hidden" path="userid" value="${user.userid}" />
				<td><input type="submit" value="Add"></td>
				<td>&nbsp;</td>
			</tr>
		</form:form>
	</table>
</body>
</html>