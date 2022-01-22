<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Bookings</title>

</head>
<body style="background-color:#9dedde;">
<script type="text/javascript">
	var isValid = "cancelled";
	function visiblecancelbtn(status){
		
		if (isValid === status) {
			document.getElementById("cancelbtn")style.display = "none";
			} else {
				document.getElementById("cancelbtn")style.display = "block";
			}
		
	}
	
</script>
	<br></br>

	<center>
		<h1 >****My Booking History****</h1>
	</center>
	<div align="right">
		<a href="/rentacar/"><font color="black">Log Out</font></a>
	</div>

	<table border="1" align="center">
		<tr>
			<th>BOOKING_ID</th>
			<th>Car Id</th>
			<th>User Name</th>
			<th>Booked From</th>
			<th>Booked Till</th>
			<th>Booking Status</th>


		</tr>
		<c:forEach items="${requestScope.bookingList}" var="book">
			<tr>
				<td>${book.booking_id}</td>
				<td>${book.carid}</td>
				<td>${user.username}</td>
				<td>${book.bookedFrom}</td>
				<td>${book.bookedTill}</td>
				<td>${book.status}</td>


				<td><form action="myBookings.htm" name="form1" method="post" >
						<input type="submit" value="cancel Booking" id="cancelbtn">
						<input type="hidden" name="booking_id" value="${book.booking_id}"></input>
						<input type="hidden" name="form" value="25"></input>
					</form></td>
			</tr>

		</c:forEach>
	</table>

</body>
</html>