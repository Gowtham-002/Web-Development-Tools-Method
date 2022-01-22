<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Form</title>
</head>
<body style="background-color:#9dedde;">

	<a href="addNewUserForm.htm">Register a new User</a>
	<br />

	<h2>Login</h2>

	<form:form action="home.htm" modelAttribute="user" method="post">

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
					<td colspan="2"><input type="submit" value="Login" /></td>
				</tr>

			</table>

	</form:form>

</body>
</html>