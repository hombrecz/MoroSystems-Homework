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
		</c:if>
		<c:if test="${status=='null'}">
			<div>User: user not found!</div>
			<br />
		</c:if>
	</c:if>

</body>
</html>