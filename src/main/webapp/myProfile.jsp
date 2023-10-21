<%@page import="com.login.beans.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.login.service.StudentService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>Welcome My Website</title>
<link rel="stylesheet" href="css/style.css">

<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}

.button-div {
	margin: 10px;
}

.button-div button {
	padding: 5px;
	font-size: 20px;
	background-color: #04AA6D;
	border: 1px solid;
	box-shadow: 1px;
}

.span-button {
	padding: 5px;
	font-size: 20px;
	background-color: #04AA6D;
	border: 1px solid;
	box-shadow: 1px;
	color: black;
}

a {
	text-decoration: none;
}

</style>
</head>

<body>
	<header class="header">
		<h1 class="header_title">Admin Portal</h1>
	</header>

	<nav>
		<ul>
			<li><a href="/LoginExample2/MyProfileServlet">My Profile</a></li>
			<li><a href="login.jsp">Login</a></li>
			<li><a href="/LoginExample2/Logout">Logout</a></li>
		</ul>
	</nav>



	<h1><%=session.getAttribute("username").toString().toUpperCase()%>
		Logged in Successfully
	</h1>


	<div class="button-div">
		<a href="addUser.jsp"> <span class="span-button">Add User</span></a>
	</div>


	<div>
		<table>
			<tr>
				<th>Id</th>
				<th>Student Name</th>
				<th>Age</th>
				<th>Course</th>
				<th>Action</th>
			</tr>
			<%
			StudentService studentService = new StudentService();

			List<Student> list = studentService.getAllStudents();

			for (Student student : list) {
			%>
			<tr>
				<td><%=student.getId()%></td>
				<td><%=student.getName()%></td>
				<td><%=student.getAge()%></td>
				<td><%=student.getCourse()%></td>
				<td><a href="/LoginExample2/UserServlet?action=delete&id=<%=student.getId()%>"> <span class="span-button">Delete</span>
				</a><a href="/LoginExample2/UserServlet?action=update&id=<%=student.getId()%>"> <span class="span-button">Update</span>
				</a></td>
			</tr>
			<%}%>
		</table>
	</div>







</body>

</html>