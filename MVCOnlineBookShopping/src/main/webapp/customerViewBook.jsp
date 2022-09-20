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

function validateUpdate(sort)
{
	if(sort.value=="sbname")
		{
			document.getElementById('byname').style.display="block";
			document.getElementById('byhighest').style.display="none";
			document.getElementById('bylowest').style.display="none";
			document.getElementById('byid').style.display="none";
		}
	else if(sort.value=="sbhprice")
		{
		document.getElementById('byname').style.display="none";
		document.getElementById('byhighest').style.display="block";
		document.getElementById('bylowest').style.display="none";
		document.getElementById('byid').style.display="none";
		}
	else if(sort.value=="sblprice")
	{
		document.getElementById('byname').style.display="none";
		document.getElementById('byhighest').style.display="none";
		document.getElementById('bylowest').style.display="block";
		document.getElementById('byid').style.display="none";
	}
	else
		{
		document.getElementById('byname').style.display="none";
		document.getElementById('byhighest').style.display="none";
		document.getElementById('bylowest').style.display="none";
		document.getElementById('byid').style.display="block";
		}
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
	  <div class="float-child-c2" id="c3" style="overflow-y:auto">
	  <center>
	   <h2>View Book</h2>
		<select name="sort" id="sort" onchange="validateUpdate(this)">
		<option value="">Sort</option>
		<option value="sbname">Sort By Name</option>
		<option value="sbhprice">Sort By Highest Price</option>
		<option value="sblprice">Sort By Lowest Price</option>
		</select><br><br>
		<table id="byid" style="display:block;">
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
		 List<book> viewBookList = (List<book>)request.getAttribute("viewBookList");
		 List<book> viewBookListByName = (List<book>)request.getAttribute("viewBookListByName");
		 List<book> viewBookListByLowestPrice = (List<book>)request.getAttribute("viewBookListByLowestPrice");
		 List<book> viewBookListByHighestPrice = (List<book>)request.getAttribute("viewBookListByHighestPrice");
			for(book b:viewBookList)
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
			%>
	
		</center>
		</table>
		<table id="byname" style="display:none;">
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
			for(book b:viewBookListByName)
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
			%>
		</table>
		<table id="byhighest" style="display:none;">
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
			for(book b:viewBookListByHighestPrice)
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
			%>
		</table>
		<table id="bylowest" style="display:none;">
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
			for(book b:viewBookListByLowestPrice)
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
			%>
		</table>
		</center>
	</div>
</div>
</body>
</html>
