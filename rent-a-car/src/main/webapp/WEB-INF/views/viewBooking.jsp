<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking Status</title>
</head>
<body style="background-color:#9dedde;">
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<form:form modelAttribute="userbooking">
		<input type="hidden" name="form" value="15"></input>
		<center>
			<h1>
				****Booking History****
			</h1>
		</center>
	
		<br></br>
		<center>
			<input type="submit" value="View My Booking" name="submit">
		</center>
		<div align="right">
		<a href="/rentacar/">Log Out</a>
	</div>
	</form:form>
	
</body>
</html>