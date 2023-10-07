<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" href="css/style.css">
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

	<form class="form" method="post" action="/LoginExample2/LoginServlet">
		<label>UserName: </label><input type="text" name="username"><br>
		<label>Password: </label><input type="password" name="password"><br>
		<input type="submit" value="Login">
	</form>
</body>
</html>