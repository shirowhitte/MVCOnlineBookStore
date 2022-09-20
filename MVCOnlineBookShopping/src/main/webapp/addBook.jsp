<%@ page import="java.sql.*" %>
<%@ page import="daoimp.bookDaoImplementation,model.book,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Book Shopping Portal</title>
<style>

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
	margin-left:400px;
	width:500px;

	padding-top:30px;
border:none;

}
.portal
{
	text-align:center;
	width:500px;
	margin:auto;
	padding-top:50px;
	border:none;

}
input[type=submit]
{
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
	float:left;
}
.float-container 
{
    border: none;
    padding: 20px;
}

.float-child-c1 
{
    width: 7%;
    float: left;
    padding: 20px;
    border:  none;
    height:450px;
    margin-left:50px;
    background-color:lightyellow;
    margin-top:40px;
    margin-right:50px;
}  
.float-child-c2 {
    width: 70%;
    float: left;
    padding: 10px;
    border: none;
     height:500px;
     background-color:#faebbd;
     margin:auto;
     
}  

.button {
  background-color: #c0c6ed;
  border: none;
  color: black;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
 	width:110px;
 	height:60px;
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
	text-align:center;
}

th
{
	background-color:lightblue;
	text-align:center;}
td{
text-align:center;}

</style>

<script>

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
</script>
</head>
<body bgcolor="#ecddd0">

<h2><center>Welcome Admin</center></h2>
<!-- Top navigation -->

<div class="float-container">
  <div class="float-child-c1">
	  <center>
	  	<button class="button" name="addBook" onclick="location.href='addBook.jsp'">Add Books</button><br><br>
	  	<button class="button" name="viewBook"  onclick="location.href='viewBook'">View Books</button><br><br>
	  	<button class="button" name="updateBook"  onclick="location.href='updateBook'">Update Books</button><br><br>
	  	<button class="button" name="deleteBook"  onclick="location.href='deleteBook'">Delete Books</button><br><br>
	  	<button class="button" name="customerTransction"  onclick="location.href='viewCustomerTransaction'">History</button><br><br>
	  	<button class="button" name="logout"  onclick="location.href='login.jsp'">Logout</button>
	  </center>
  </div>
  
    <div class="float-child-c2" >
	   <fieldset>
	   <h2>Add Book Form</h2>
		<form method="post" action="addBook" name="addBookForm" onsubmit="return validateForm()" >
		<p>
		<label for="bname" name="bname" id="bname" >Enter Book Name</label>
		<input type ="text" name="bname" id="bname"/>
		</p>
		<p>
		<label for="bauthor" name="bauthor" id="bauthor">Enter Author</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="text" name="bauthor" id="bauthor"/>
		</p>
		<p>
		<label for="bstock" name="bstock" id="bstock">Select Stock</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<select id="bstock" name="bstock" style="width:170px;">
			<option value="50">50</option>
			<option value="100">100</option>
			<option value="150">150</option>
			<option value="200">200</option>
		</select>
		</p>
		<p>
		<label for="bprice" name="bprice" id="bprice">Enter Price</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="text" name="bprice" id="bprice"/>
		</p>
		<p>
		<label for ="sort" id="sort" name="sort">Select Category</label>&nbsp;&nbsp;&nbsp;
		<select name="sort" id="sort" style="width:170px;">
		<option value="Computer">Computer</option>
		<option value="Laws">Laws</option>
		<option value="Literature">Literature</option>
		<option value="Novel">Novel</option>
		<option value="Poems">Poems</option>
		</select>
		</p>
		<p>
		<label for ="file" id="file" name="sort">Select Image</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="file" name="file" />
        </p>
		<input type="submit" value="Add Book"/>
		</form>
		</fieldset>
	</div>

  
</div>
</body>
</html>

