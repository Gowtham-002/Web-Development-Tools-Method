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
<form:form name="formlocation" modelAttribute="location">
		<input type="hidden" name="form"></input>
		<center>
			<h1>****Add Locations in USA****</h1>
		</center>
		<table align="center">

			<tr>
				<td>*State:</td>
				<td><form:input path="state" size="30" /> <font color="red"><form:errors
							path="state" /></font></td>
			</tr>

			<tr>
				<td>*City</td>
				<td><form:input path="city" size="30" /> <font
					color="red"><form:errors path="city" /></font></td>
			</tr>

						
		</table>
		<center>
			<input type="submit" value="add" name="submit"></input> 
			<input type="reset" value="reset" />
		</center>

	</form:form>
</body>
</html>