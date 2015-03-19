<%@ page language="java" 
	contentType="text/html; charset=ISO-8859-2" 
	pageEncoding="ISO-8859-2"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Moro System - Task1</title>
	</head>
	
	<body>
	<mytags:userbar/>

	<h2>Moro Systems Task1 - View part</h2> 
	 
 	<div>String: ${string}</div><br/>
 	
 	<div>Date: ${date}</div><br/>

	
	<div>List: <br/> 
		<c:if test="${not empty lists}">
			<ul>
				<c:forEach var="listValue" items="${lists}">
					<li>${listValue}</li>
				</c:forEach>
			</ul>
		</c:if>	
	</div>
	
	<div>HashMap: <br/>
		<c:if test="${not empty hashmaps}">
			<ul>
				<c:forEach var="mapValue" items="${hashmaps}">
					<li>${mapValue}</li>
				</c:forEach>
			</ul>
		</c:if>
	</div>
	
	</body>
</html>