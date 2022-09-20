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
    padding: 20px;
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
}

th
{
	background-color:lightblue;
	text-align:center;}
td{
text-align:center;}
</style>

<script>

function deleteForm() 
{
	alert("Book has been deleted successfully.");
	return true;  
}
</script>
</head>
<body bgcolor="#ecddd0">
<br>
<h2><center>Welcome Admin</center></h2>
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
  
	<div class="float-child-c2">
	  	<fieldset>
	   <h2><center>Delete Book Form</center></h2>
	   <%
	   List<book> list = (List<book>)request.getAttribute("list");
	   %>
		<form method="post" action="deleteBook" name="updateBookForm" onsubmit="return deleteForm()">
		<p>
		<label for="bnamedel" name="bnamedel" id="bnamedel" >Select Book ID</label>
		<select id="bnamedel" name="bnamedel" style="width:180px;">
		<%
		for(book b:list)
		{%>
		<option value="<%=b.getBid()%>"><%=b.getBid()%></option>
		<%} %>
		</select>
		</p>
		<input type="submit" value="Delete Book"/>
		</form>
		</fieldset>
	</div>

  
</div>
</body>
</html>
