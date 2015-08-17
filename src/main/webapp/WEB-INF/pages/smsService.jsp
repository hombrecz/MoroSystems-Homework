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

	<h2>Moro Systems Task1 - sms sending interface</h2>

<%-- 	<form method="post" action="smsService"> --%>
<!-- 		<input name="phoneNumber" value="Recipients phone number" /> -->
<!-- 		<input type="text" name="message" value="Write your SMS here" /> -->
<!-- 		<input type="submit" value="Send SMS" /> -->
<%-- 	</form> --%>
	
		<form:form method="post" action="smsService" modelAttribute="sms">
			<form:input path="phoneNumber" value="Recipients phone number" />
			<form:input type="textarea" path="message" value="Write your SMS here" />
			<input type="submit" value="Send SMS" />
		</form:form>

</body>
</html>