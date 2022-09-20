<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Book Shopping Portal</title>
<style>
body
{
background-image:url('wall.jpg');
}
p
{
float:left;}
fieldset
{
	width:300px;
	margin:auto;
	padding-top:50px;
	border:none;
}
input[type=submit] {
  background-color: #04AA6D;
  border: none;
  color: white;
  padding: 8px 16px;
  text-decoration: none;
  border-radius: 20px 20px;
  margin: 4px 2px;
  cursor: pointer;
  width:100px;
}
input[type=reset] {
  background-color: red;
  border: none;
  color: white;
  padding: 8px 16px;
  text-decoration: none;
  border-radius: 20px 20px;
  margin: 4px 2px;
  cursor: pointer;
  width:100px;
}
.topnav 
{
  position: relative;
  background-color: #333;
  overflow: hidden;
  text-align: center;
}

/* Style the links inside the navigation bar */
.topnav a 
{
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
  text-align: center;
  display: inline-block;
  padding-left: 80px;
   padding-right: 80px;
}

/* Change the color of links on hover */
.topnav a:hover 
{
  background-color: #ddd;
  color: black;
}

/* Container styling */
.container
{
	background-color:lightyellow;
	border: none;
	text-align: center;
	padding: 20px;
	height: 300px;
	width: 600px;
	margin: auto;
	margin-top: 50px;
}

</style>

<script>
function validateForm() 
{
	  let x = document.forms["userLoginForm"]["username"].value;
	  let y = document.forms["userLoginForm"]["password"].value;
	  if (x == "") 
	  {
	    alert("ID must be filled out");
	    return false;
	  }
	  else if(y=="")
		  {
		  alert("Password must be filled out.");
		  }
}
</script>
</head>
<body bgcolor="#e1f8dc">

<h2><center>Online Book Shopping Portal</center></h2>
<div class="topnav">
<a href="aboutus.jsp">About Us</a>
	<a href="login.jsp" class="link"  id="aboutus" rel="aboutus">Admin Login</a>
  	<a href="customerLogin.jsp" class="link"  id="aboutus" rel="aboutus">Customer Login</a>
  	<a href="contactus.jsp">Contact Us</a>
</div>

<div class="container">
<fieldset>
<form method="post" action="adminLogin" name="userLoginForm" onsubmit="return validateForm()" >
<p>
<label for="username" name="username" id="username" >Enter User ID</label> &nbsp;&nbsp;&nbsp;
<input style="float:right;" type ="text" name="username" id="uid"/>
</p>
<p>
<label for="password" name="password" id="password">Enter Password</label>&nbsp;&nbsp;
<input style="float:right;" type="password" name="password" id="password"/>
</p>
<p style="float:right">
<input type="submit" value="Login"/>
<input type="reset" value="Clear"/>
</p>
</form>
</fieldset>
<h3><center><% String e = request.getParameter("error");
if(e==null)
{
}
else
{
	out.println(e);
}
%></center></h3>
</div>

</body>
</html>