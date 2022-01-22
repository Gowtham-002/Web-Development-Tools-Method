<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Booking Form</title>
</head>

<body style="background-color:#9dedde;">
<h1 align="center"> Car Booking </h1>
<div align="right"><a href="/rentacar/">Log Out</a></div>
<form action="carBooking.htm" method="post">
<input type="hidden" name="form" value="3"></input>
<script language="javascript">
function bookedFromValidation()
    {
        var ext = document.formvalidation.bookedFrom;
        if (ext.value == "") {
            document.getElementById("id2").innerHTML = "bookedFrom field cant be empty";
            ext.focus();
            ext.select();
            return false;
        } else {
            document.getElementById("id2").innerHTML = "";
            return bookedTillValidation();
        }
    }
    function bookedTillValidation()
    {
        var ext = document.formvalidation.bookedTill;
        if (ext.value == "") {
            document.getElementById("id3").innerHTML = "bookedTill field cant be empty";
            ext.focus();
            ext.select();
            return false;
        } else {
            document.getElementById("id3").innerHTML = "";
            return true;
        }
    }
    function validation1()
    {
        return select_Onchange();
    }
</script>

        <LINK href="jsp/JS/calendar.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="jsp/JS/prototype.js"></script>
        <script type="text/javascript" src="jsp/JS/calendarview.js"></script>
        <script type="text/javascript" src="jsp/JS/calendarview1.js"></script>
        <script type="text/javascript">
     window.onload = function()
      {
       Calendar.setup({
         dateField      : 'bookedFrom',
         triggerElement : 'calendarButton'})
          }
          </script>
		<table align="center" >
			<caption ><h2>Booking Details</h2></caption>
	<h2>Welcome ${user.username}</h2>
	<tr>
			<td>
				Person Id
			</td>
			<td>
			<input type="text" name="userid" readonly="readonly" value=${user.userid}></input>
			<font color="red"></font><span id="id1"></span>
			</td>
			</tr>
		<tr>
			
			<td>
				Location Id
			</td><td>
				<input type="text" name="location_id" readonly="readonly" value="${requestScope.car.location_id}"></input>
		
			</td>
		</tr>
		<tr>
			<td>
				Car Id
			</td>
			<td>
				<input type="text" name="carid" readonly="readonly" value="${requestScope.car.carid}"></input>
			</td>
		</tr>

			
			<tr>
				<td>
				*Booked From(dd-mm-yyyy hh:mm):</td>
				<td>
					<input type ="text" name="bookedFrom" onblur="bookedFromValidation()"> <font color="red"><span id="id2"></span></font>
				</td>	
			</tr>
			
			<tr>
				<td>
				*Booked Till(mm-dd-yyyy hh:mm):</td>
				<td>
					<input type ="text" name="bookedTill" onblur="bookedTillValidation()">
					<font color="red"><span id="id3"></span></font>
				</td>	
			</tr>
			<tr>
				<td>
				Mobile No:</td>
				<td>
					<input type ="text" name="phonenumber">
					<font color="red"></font>
				</td>	
			</tr>
			<tr>
			<td> </td>
			<td>
			<input type="submit" value="Book"  name="book" />
			</td>
			</tr>
			</table>

</form>
</body>
</html>