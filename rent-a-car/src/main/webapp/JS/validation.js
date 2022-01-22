
function fnvalidation()  //Firstname validation//
{
	var fname=document.form1.name;
	if(fname.value=="")
	{
		document.getElementById("id1").innerHTML="first name cant be empty";
		fname.focus();
		fname.select();
		return false;
	}
	else if(isNaN(fname.value)==false)
	{
		document.getElementById("id1").innerHTML="first name should be in characters";
		fname.focus();
		fname.select();
		return false;
	}
	else
	{
		document.getElementById("id1").innerHTML="";
		return emailvalidation();
		
	}
}



function emailvalidation()     //email validation//
{
	var email=document.form1.email;
	var atpos=email.value.indexOf("@");
	var dotpos=email.value.lastIndexOf(".");

	if(email.value=="")
	{
		document.getElementById("id4").innerHTML="please enter E-mail id";
		email.focus();
		email.select();
		return false;
	}
	else if(atpos<1||atpos+2>dotpos||dotpos>email.value.length-2)
	{
		document.getElementById("id4").innerHTML="Please enter valid email";
		email.focus();
		email.select();
		return false;
	}
	else
	{
		document.getElementById("id4").innerHTML="";
		return pwdvalidation();
		
	}
}

function pwdvalidation()  //Password validation//
{
	var password=document.form1.password;
	var password1=document.form1.password1;
	if(password.value=="")
	{
		document.getElementById("id5").innerHTML="password cant be empty";
		password.focus();
		password.select();
		return false;
	}
	else if(password.value.length<6)
	{
		document.getElementById("id5").innerHTML="password should be of 6 characters";
		password.focus();
		password.select();
		return false;
	}
	else if(password.value!=password1.value)
	{
		alert("Passwords doesn't match");
		password1.focus();
		password1.select();
		return false;

	}
	else
	{
		document.getElementById("id5").innerHTML="";
		document.getElementById("id6").innerHTML="";
		return mblvalidation();
	}
}

function mblvalidation()    //mobile no validation//
{
	var regexp1=/[^0-6]\d{9}/g;
	var mobile=document.form1.mobile;
	if(mobile.value=="")
	{
		document.getElementById("id7").innerHTML="mobile no cant be empty";
		mobile.focus();
		mobile.select();
		return false;
	}
	else if(mobile.value.match(regexp1)==null)
	{
		document.getElementById("id7").innerHTML="Enter valid Mobile Number";
		mobile.focus();
		mobile.select();
		return false;
	}
	else
	{
		document.getElementById("id7").innerHTML="";
		return isAddress();
		
	}
}

function isAddress()
{
	var address=document.form1.address;
	if(address.value=="")
	{
		document.getElementById("id8").innerHTML="address field cant be empty";
		address.focus();
		address.select();
		return false;
	}
	else
	{
		document.getElementById("id8").innerHTML="";
		return true;
		
	}
}
function validation1()
{
	
	if(!fnvalidation())
	{
	alert("Please Fill the Complete Form");
	return fnvalidation();
	}
	else
		return true;
	
}

