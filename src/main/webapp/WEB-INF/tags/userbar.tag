<%@tag description="User bar for every page" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@attribute name="loggedUsername"%>
<%@attribute name="timeActual"%>
<%@attribute name="usersCount"%>
<div id="userbar">

	<fmt:setLocale value="en"/>
	<fmt:bundle basename="com.hombre.language.Example">
   		<fmt:message key="various.hello"/><br/>
	</fmt:bundle>
	
	<fmt:setLocale value="cs_CS"/>
	<fmt:bundle basename="com.hombre.language.Example">
   		<fmt:message key="various.hello"/><br/>
	</fmt:bundle>

	<fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${timeActual}" />
	, there
	
	<c:choose>
		<c:when test="${usersCount == 1}">
			is 1 user in our DB!
		</c:when>
		<c:when test="${usersCount > 1}">
			are ${usersCount} users in our DB!
		</c:when>
		<c:otherwise>
			isn't any user in our DB!<br/>
		</c:otherwise>
	</c:choose>
	
	<c:choose>
		<c:when test="${not empty loggedUsername}">
			User: ${loggedUsername}, 
			<a href="<c:url value="/j_spring_security_logout" />" >Logout</a>
		</c:when>
		<c:otherwise>
			<form method="post" action="admin/adminUsers">
            	<input type="submit" value="Log in">
			</form>
		</c:otherwise>
	</c:choose>
	
</div>