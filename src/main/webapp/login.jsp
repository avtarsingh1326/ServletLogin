<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" href="css/style.css">
<style type="text/css">

.login_container{
	width: 40%;
    margin: auto;
}
.login_container input{
	width: 100%;
    padding-top: 5px;
    padding-bottom: 5px;
}
.login_container label{
	font-size: 20px;
}

.login_container_submit{
	text-align: center;
	background-color: #04AA6D;
	width: 101%;
	border: 1px solid;
	box-shadow: 0.5px 0.5px 0.5px 0.5px black;
}
.login_container form{
	margin: 25px;
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

	<div class="login_container">
		<form class="form" method="post" action="/LoginExample2/LoginServlet">
			<label>UserName: </label><input type="text" name="username">
			<label>Password: </label><input type="password" name="password">
			<br><span style="padding: 10px"></span><br>
			<input class="login_container_submit" type="submit" value="Login">
		</form>
	</div>
</body>
</html>