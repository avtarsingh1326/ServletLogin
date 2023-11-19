<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>
<link rel="stylesheet" href="css/style.css">
<style>
	input {
		width: 100%;
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

	<div style="width: 50%">
		<form action="/LoginExample2/UserServlet" method="post" style="padding : 10px" enctype="multipart/form-data" >
			<label>Student Name: </label> <input type="text" name="studentName" required="required">
			<label>Student Age: </label> <input type="text" name="age" required="required"> <label>Student
				Course: </label> <input type="text" name="course" required="required"><br><br>
				<label>Student Image</label> <input name="file" type="file">
				<input type="hidden" name="action" value="add"></br></br>
				<input type="submit" value="Add User">
		</form>
		<div></div>
</body>
</html>