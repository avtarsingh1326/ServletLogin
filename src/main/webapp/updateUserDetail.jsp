<%@page import="com.login.beans.Student"%>
<%@page import="com.login.service.StudentService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
<style>
input {
	width: 100%;
}
</style>
</head>
<body>

	<%
	int id = 0;
	if (request.getAttribute("id") != null) {
		id = Integer.parseInt(request.getAttribute("id").toString());
	}

	StudentService studentService = new StudentService();

	Student student = studentService.getUserByUserId(id);
	%>
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
		<form action="/LoginExample2/UserServlet" method="post"
			style="padding: 10px">
			<label>Student Name: </label> <input type="text" name="studentName"
				required="required" value="<%=student.getName()%>"> <label>Student Age: </label> <input
				type="text" name="age" required="required" value="<%=student.getAge()%>"> <label>Student
				Course: </label> <input type="text" name="course" required="required" value="<%=student.getCourse()%>"><br>
			<br> <input type="hidden" name="action" value="updateData">
			<input type="hidden" name="id" value="<%=student.getId()%>"> <input
				type="submit" value="Update User">
		</form>
		<div></div>
</body>
</html>