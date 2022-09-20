<%@ page import="java.sql.*" %>
<%@ page import="daoimp.customerDaoImplementation,model.Customer,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Book Shopping Portal</title>
<style>
body {
  background-image: url('book.jpg');
}
.container
{
	margin:auto;
	width:60%;
	height:400px;
	text-align:center;
	background-color:lightyellow;
}
fieldset
{
	width:300px;
	margin:auto;
	padding-top:80px;
	border:none;

}
.portal
{
	text-align:center;
	width:500px;
	margin:auto;
	padding-top:130px;
	border:none;
	color:white;

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
  width:300px;
}
p
{
float:left;}
.float-container {
    border: none;
    padding: 20px;
}

.float-child-c1 {
    width: 8%;
    float: left;
    padding: 20px;
    border:  none;
    height:400px;
    margin-left:50px;
    background-color:lightyellow;
    margin-top:100px;
    margin-right:50px;
}  
.float-child-c2 {
    width: 70%;
    float: left;
    padding: 20px;
    border: none;
     height:500px;
     background-color:#faebbd;
     margin:auto;
      background-image: url('cust.jpg');
}  

.button {
  background-color: #c0c6ed;
  border: none;
  color: black;
  padding: 12px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  width:130px;
}
.topnav 
{
  position: relative;
  background-color: #333;
  overflow: hidden;
  text-align: center;
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
	background-color:#ced2c2;
	border: none;
	text-align: center;
	padding: 20px;
	height: 520px;
	width: 1000px;
	margin: auto;
	margin-top: 50px;
}

table
{
	width:80%;
	background-color:lightyellow;
}

th
{
	background-color:lightblue;
	text-align:center;}
td{
text-align:center;}

</style>

<script>
function preventBack(){window.history.forward();}
 setTimeout("preventBack()", 0);
 window.onunload=function(){null};

function validateForm() 
{
	  let bname = document.forms["addBookForm"]["bname"].value;
	  let bauthor = document.forms["addBookForm"]["bauthor"].value;
	  let bprice = document.forms["addBookForm"]["bprice"].value;
	  if (bname == "") 
	  {
	    alert("Book name must be filled out");
	    return false;
	  }
	  else if(bauthor=="")
		{
		alert("Book author must be filled out.");
		 return false;
		  }
	  else if(bprice=="")
	  {
	  alert("Book price must be filled out.");
	  return false;
	  }
	  else
		  {
		  alert("Book has been added successfully.");

		  return true;
		  }
}

function updateForm() 
{
 
		
		  alert("Book has been updated successfully.");
		 
		  return true;
		  
}
function deleteForm() 
{

		  alert("Book has been deleted successfully.");
		  return true;
		  
}

function hello() 
{
	document.getElementById('category').style.display="block";
	document.getElementById('purchaseBook').style.display="block";
		  
}

function validateUpdate(select)
{
	if(select.value=="price")
		{
			document.getElementById('bp').style.display="block";
			document.getElementById('bs').style.display="none";
		}
	else if(select.value=="stock")
		{
			document.getElementById('bs').style.display="block";
			document.getElementById('bp').style.display="none";
		}
	}


</script>
</head>
<body bgcolor="#fbfaf0">
<br>
<h2 style="color:white"><center>Welcome <%=(String)session.getAttribute("customerName") %></center></h2>
<div class="float-container">
  <div class="float-child-c1">
	  <center>
	  	<button onclick="hello()" class="button" name="book">Books</button><br><br>
	  	<button style="display:none; width:100px;background-color:pink;" class="button" name="purchaseBook"  id="purchaseBook" onclick="location.href='customerViewBook'">View Books</button>
	  	<button style="display:none; width:100px;margin-bottom:20px;background-color:pink;" class="button" name="category"  id="category" onclick="location.href='category.jsp'">Category</button>
	  	<button class="button" name="searchBook"  onclick="location.href='customerSearch'">Search Books</button><br><br>
	  	<button class="button" name="transactionHistory"  onclick="location.href='transactionHistory'">Transaction History</button><br><br>
	  	<button class="button" name="transactionHistory"  onclick="location.href='logout.jsp'">Log Out</button>
	  </center>
  </div>
  	<div class="float-child-c2" id="portal" style="display:block;">
	   <div class="portal">
	   		<h1>Welcome to Customer Portal</h1>
			<h2>Happy Shopping with us!</h2>
		</div>
	</div>

  
</div>
</body>
</html>
