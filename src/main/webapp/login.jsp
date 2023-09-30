<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/LoginExample2/LoginServlet">
		<label>UserName: </label><input type="text" name="username"><br>
		<label>Password: </label><input type="password" name="password"><br>
		<input type="submit" value="Login">
	</form>
</body>
</html>