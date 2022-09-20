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
body {
  background-image: url('book.jpg');
}

.byname, .byhighest, .bylowest
{
display:none;
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
  width:110px;
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
	width:70%;
	background-color:lightyellow;
}

th
{	width:100px;
	background-color:lightblue;
	text-align:center;}
td{
width:100px;
text-align:center;}

</style>

<script>

function preventBack(){window.history.forward();}
setTimeout("preventBack()", 0);
window.onunload=function(){null};

function hello() 
{
	document.getElementById('category').style.display="block";
	document.getElementById('purchaseBook').style.display="block";
		  
}

function validateUpdate(select)
{
	document.getElementById('category').value= select.value;

	}


</script>
</head>
<body bgcolor="#fbfaf0">
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
  
  
	<!--  view book -->
	  <div class="float-child-c2" id="c3" style="overflow-y:auto;">
	  <center>
	   <h2>View Book</h2>
	   <form action="category" method="post">
	   <label for ="sort" id="sort" name="sort">Select Category</label>
		<select name="sort" id="sort" onchange="validateUpdate(this)" style="width:60%">
		<option value="">Category</option>
		<option value="Computer">Computer</option>
		<option value="Laws">Laws</option>
		<option value="Literature">Literature</option>
		<option value="Novel">Novel</option>
		<option value="Poems">Poems</option>
		</select>
		<%
		out.println("<input type='submit' value='Enter' style='width:100px;height:30px'><br><br>");
		out.println("</form>");
					 List<book> viewBookListByCategory = (List<book>)request.getAttribute("viewBookListByCategory");
					 if(viewBookListByCategory != null && !viewBookListByCategory.isEmpty())
					 {
					 %>
				<table>
				<center>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Author</th>
					<th>Stock</th>
					<th>Price</th>
					<th>Image</th>
					<th>Add to Cart</th>
				</tr>
					<%
						for(book b:viewBookListByCategory)
						{
							out.println("<form action='carts' method='post'>");
							out.println("<tr>");
							out.println("<td>"+b.getBid()+"</td>");
							out.println("<td>"+b.getBname()+"</td>");
							out.println("<td>"+b.getBauthor()+"</td>");
							out.println("<td>"+b.getBstock()+"</td>");
							out.println("<td>"+b.getBprice()+"</td>");
							out.println("<td><img style='length:100px;width:100px;'src='img/"+b.getImg()+"'></td>");
							out.println("<input type='hidden' value="+b.getBid()+" name='addCart'>");
							out.println("<td><input type='submit' value='Purchase'></td>");
							out.println("</form>");
							out.println("</tr>");
						}
					 }
					 else
						{
							out.println("<h3>Nothing to show</h3>");
						}
						%>
		</center>
	</div>
  
</div>
</body>
</html>
