<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>admin welcome</title>
</head>
<body style="background-color:#9dedde;">
<h2>
				<a href="/rentacar/"><font>Log Out</font></a>
		</h2>
<center>
	<h1><font color =red>
		Welcome Administrator <br> <br>
		
		Below are the Tasks for Admin  <br> 
		</font>
	</h1>
	
	<table border="2" align="center">
  <tr>
    <th><font color=red></font>CRUD Operation for Location</font></th>
    <th>CRUD Operation for Car</th>
  </tr>
  <tr>
    <td><a href="addLocation.htm">Add Location</a></td>
    <td><a href="addCar.htm">Add Car</a></td>
  </tr>
   <tr>
    <td><a href="updateLocation.htm">Update Location</a></td>
    <td><a href="updateCar.htm">Update Car</a></td>
  </tr>
    <tr>
    <td><a href="deleteLocation.htm">Delete Location</a></td>
    <td><a href="deleteCar.htm">Delete Car</a></td>
  </tr>
</table>

<br>
<br>
<br>
<a href="adminAllBookings.htm">View All Bookings</a>
			

		
	</center>
</body>
</body>
</html>