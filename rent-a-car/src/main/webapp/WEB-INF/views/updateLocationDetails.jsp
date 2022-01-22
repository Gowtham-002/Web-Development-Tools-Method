<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<!--<%@ include file="updateLocation.jsp" %>
    -->
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Car Type</title>
</head>
<body style="background-color:#9dedde;">
	<form action="updateLocationDetails.htm" method="post">
		<input type="hidden" name="form" value="6"></input>
		<center>
			<h1>****Update Location Details****
			</h1>
		</center>
		<c:if test="${sessionScope.location !=null}">
			<table align="center" border="1">
				<tr>
					<th>Location ID</th>
					<th>State</th>
					<th>City</th>
				</tr>
				<tr>
					<td><input type="text" value="${sessionScope.location.location_id}"
						name="location_id" readonly></input></td>
					<td><input type="text" value="${sessionScope.location.state}"
						name="state"></input></td>
					<td><input type="text" value="${sessionScope.location.city}"
						name="city"></input></td>
						
				</tr>
			</table>
			<br>
			<center>
				<input type="submit" value="update" name="submit"></input>
			</center>
		</c:if>

		<c:if test="${sessionScope.location == null}">
			<center>
				<font color="red" size="4">Location Id Does Not Exist</font>
			</center>
		</c:if>

	</form>
</body>
</html>