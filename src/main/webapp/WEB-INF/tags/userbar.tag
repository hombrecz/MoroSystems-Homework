<%@tag description="User bar for every page" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
</head>

<div id="userbar">
	Language : <a href="?lang=en">English</a>|<a href="?lang=cs_CS">Czech</a>
	<br />
	<fmt:message key="various.hello" />
	<br />

	<fmt:formatDate type="both" dateStyle="short" timeStyle="short"
		value="${timeActual}" />

	<c:choose>
		<c:when test="${usersCount == 1}">
			<fmt:message key="various.there_is" /> ${usersCount} <fmt:message
				key="various.user_in_db" />
		</c:when>
		<c:when test="${usersCount > 1}">
			<fmt:message key="various.there_are" /> ${usersCount} <fmt:message
				key="various.users_in_db" />
		</c:when>
		<c:otherwise>
			<fmt:message key="various.there_is_not" />
		</c:otherwise>
	</c:choose>

	<c:choose>
		<c:when test="${not empty loggedUsername}">
			User: ${loggedUsername}, 
			<a href="<c:url value="/j_spring_security_logout" />">Logout</a>
		</c:when>
		<c:otherwise>
			<form method="post" action="admin/adminUsers">
				<input type="submit" value="Log in">
			</form>
		</c:otherwise>
	</c:choose>

</div>