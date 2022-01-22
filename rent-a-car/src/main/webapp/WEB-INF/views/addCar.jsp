<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Car Details</title>

</head>
<body style="background-color:#9dedde;">
<form:form name="formcar" modelAttribute = "car">
<input type="hidden" name="form" value="11"></input>
<center><h1>****Add Cars****</h1></center>
<table align="center" >
	
		<tr>
		<td>Location ID</td>
		<td><input type="text" name="location_id"></td>
		<td><font color="red"></font><span id="id2"></span></td>
	</tr>
	<tr>
		<td>Car Brand</td>
		<td><input type="text" name="carbrand"></td>
		<td><font color="red"></font></td>
	</tr>
	<tr>
		<td>Car Number</td>
		<td><input type="text" name="carnumplate" ></td>
		<td><font color="red"></font><span id="id1"></span></td>
	</tr>
	<tr>
		<td>Car Name</td>
		<td><input type="text" name="carname" ></td>
		<td><font color="red"></font><span id="id2"></span></td>
	</tr>
	<tr>
		<td>Per Hour Rate</td>
		<td><input type="text" name="perhourrate"></td>
		<td><font color="red"></font><span id="id3"></span></td>
	</tr>
	<tr>
		<td>Availability</td>
		<td><input type="text" name="availability"></td>
		<td><font color="red"></font><span id="id4"></span></td>
	</tr>
	
	<tr>
		<td>Year Of Manufacture</td>
		<td><input type="text" name="yearofmanufacture"></td>
		<td><font color="red"></font></td>
	</tr>
	
	<tr>
		<td>Rating</td>
		<td><input type="text" name="rating"></td>
		<td><font color="red"></font></td>
	</tr>
	
	<tr>
		<td>milage in miles</td>
		<td><input type="text" name="milageinmiles"></td>
		<td><font color="red"></font></td>
	</tr>
	
	<tr>
		<td>no of seats</td>
		<td><input type="text" name="noofseats"></td>
		<td><font color="red"></font></td>
	</tr>
	
	
	
	<tr>
		<td></td>
		<td><input type="submit" value="add"></input> <input type="reset" value="reset"/></td>
	</tr>
</table>
</form:form>
</body>
</html>