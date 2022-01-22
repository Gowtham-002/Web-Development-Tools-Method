<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
            document.getElementById("id1").innerHTML = "cartypeId cant be empty";
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
	<center>
		<h1>****Search a car to Update****</h1>
	</center>
	<form:form action="updateCar.htm" modelAttribute="car" name="carform" method="post"  >
		<input type="hidden" name="form" value="6"></input>
		<table align="center">

	

	
		<tr>
		<td>Car ID</td>
		<td><input type="text" name="carid" ></td>
		<td><font color="red"></font></td>
	</tr>
	
	
</table>

		<br></br>
		<center>
			<input type="submit" value="search" name="submit">
		</center>
	</form:form>
</body>
</html>