<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Car Type</title>
</head>
<body style="background-color:#9dedde;">
	<br></br>

	<center>
		<h1 >****Location Details****</h1>
	</center>
	<div align="right">
		<a href="/rentacar/"><font>Log Out</font></a>
	</div>

	<c:if test="${!empty(locationList)}">

		<table border="1" align="center">

			<tr>
				<th>Location ID</th>
				<th>State</th>
				<th>City</th>
				<th></th>
			</tr>

			<c:forEach items="${requestScope.locationList}" var="locationList">
				<form action="searchCar.htm" method="post">
					<tr>
						<td>${locationList.location_id}</td>
						<td>${locationList.state}</td>
						<td>${locationList.city}</td>
	  				<td><input type="submit" value="Select a Location"></input></td>
					</tr>

					<input type="hidden" name="location_id"
						value="${locationList.location_id}"></input> <input type="hidden"
						name="form" value="8"></input>
				</form>
			</c:forEach>
		</table>

	</c:if>
	<c:if test="${empty(locationList)}">
		<center>
			<font color="red" size="4">No Location Available for Selection</font>
		</center>
	</c:if>
</body>
</html>