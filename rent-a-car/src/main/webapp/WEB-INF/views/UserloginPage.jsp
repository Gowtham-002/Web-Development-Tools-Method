<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!-- %@page contentType="text/html" pageEncoding="UTF-8"% "text/css"-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1; text/css"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!--  meta http-equiv="Content-Type" content="text/html; charset=UTF-8"-->
<title>Login Form</title>
<h1>Welcome to rent-A-car Application</h1>
</head>
<!--body background="/images/home1.jpg"> ! -->

<body style="background-color:#9dedde;">
<link href="../css/login.css" rel="stylesheet" type="text/css">

	<br />

	<h2>Login</h2>
	<br>
<div><font color="red"><c:out value="${requestScope.loginErr}"/></font></div> 
	<form:form action="UserloginPage.htm" modelAttribute="user" method="post">

		<table>
			
				<tr>
					<td>User Name:</td>
					<td><input name="username" size="30" required="required" /></td>
				</tr>

				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" size="30"
						required="required" /></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="Login" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="UserSignup.htm">   Register a new User</a></td>
				</tr>

			</table>

	</form:form>

</body>
</html>