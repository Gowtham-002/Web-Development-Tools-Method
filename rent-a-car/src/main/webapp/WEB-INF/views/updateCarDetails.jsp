<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Car Type</title>
<script type="text/javascript">
    function cartypeIdValidation() //carTypeId validation//
    {
        var regexp1 = /\d/g;
        var ext = document.formvalidation.carId;
        if (ext.value == "") {
            document.getElementById("id1").innerHTML = "Car ID can't be empty";
            ext.focus();
            ext.select();
            return false;
        } else {
            document.getElementById("id1").innerHTML = "";
            return true;
        }
    }
    function validation1()
    {
        return cartypeIdValidation();
    }
</script>
</head>
<body style="background-color:#9dedde;">
	<form action="updateCarDetails.htm" method="post">
		<input type="hidden" name="form" value="22"></input>
		<center>
			<h1>****Update Car Details****
			</h1>
		</center>
		<c:if test="${sessionScope.car.carid !=null}">
			<table align="center" border="1">
				<tr>
					<th>Location ID</th>
					<th>Car ID</th>
					<th>Car Brand</th>
					<th>Car Name</th>
					<th>Car No Plate</th>
					<th>No Of Seats</th>
					<th>Per Hour rate</th>
					<th>Rating</th>
					<th>Year Of Manufacture</th>
					<th>Mileage In Miles</th>
					<th>Availability</th>
				</tr>
				<tr>
					<td><input type="text" value="${sessionScope.car.location_id}"
						name="location_id" readonly></input></td>
								<td><input type="text" value="${sessionScope.car.carid}"
						name="carid" readonly></input></td>
							<td><input type="text" value="${sessionScope.car.carbrand}"
						name="carbrand" ></input></td>
					<td><input type="text" value="${sessionScope.car.carname}"
						name="carname" ></input></td>
						<td><input type="text" value="${sessionScope.car.carnumplate}"
						name="carnumplate" ></input></td>
						<td><input type="text" value="${sessionScope.car.noofseats}"
						name="noofseats" ></input></td>
						<td><input type="text" value="${sessionScope.car.perhourrate}"
						name="perhourrate" ></input></td>
						<td><input type="text" value="${sessionScope.car.rating}"
						name="rating" ></input></td>
						<td><input type="text" value="${sessionScope.car.yearofmanufacture}"
						name="yearofmanufacture" ></input></td>
						<td><input type="text" value="${sessionScope.car.milageinmiles}"
						name="milageinmiles" ></input></td>
						<td><input type="text" value="${sessionScope.car.availability}"
						name="availability" ></input></td>
						
				</tr>
			</table>
			<br>
			<center>
				<input type="submit" value="update" name="submit"></input>
			</center>
		</c:if>

		<c:if test="${sessionScope.car.carid == null}">
			<center>
				<font color="red" size="4">Car Id Does Not Exist</font>
			</center>
		</c:if>

	</form>
</body>
</html>