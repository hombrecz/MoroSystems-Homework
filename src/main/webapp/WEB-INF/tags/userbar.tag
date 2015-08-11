<%@tag description="User bar for every page" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@attribute name="loggedUsername"%>
<%@attribute name="timeActual"%>
<%@attribute name="usersCount"%>

<head>
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
</head>

<div id="userbar">
	Language : <a href="?lang=en">English</a>|<a href="?lang=cs_CS">Czech</a>
	<br />
	<spring:message code="various.hello" text="default hello" />
	<br />

	<fmt:formatDate type="both" dateStyle="short" timeStyle="short"
		value="${timeActual}" />

	<c:choose>
		<c:when test="${usersCount == 1}">
			<spring:message code="various.there_is" /> ${usersCount} <spring:message
				code="various.user_in_db" />
		</c:when>
		<c:when test="${usersCount > 1}">
			<spring:message code="various.there_are" /> ${usersCount} <spring:message
				code="various.users_in_db" />
		</c:when>
		<c:otherwise>
			<spring:message code="various.there_is_not" />
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