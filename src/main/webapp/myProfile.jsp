<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<title>Welcome My Website</title>
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

    <h1><%=request.getParameter("username")%> Logged in Successfully</h1>

</body>

</html>