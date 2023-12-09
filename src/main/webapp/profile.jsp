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

.sort {
	padding: 5px;
	font-size: 20px;
	background-color: #04AA6D;
	border: 1px solid;
	box-shadow: 1px;
	color: black;
}

select {
	padding: 9px;
}
.profile_image{
	height: 140px;
    width: 140px;
    display: block;
}
.profile_image img{
	
	height: 100%;
    width: 100%;
}


</style>

<script type="text/javascript">
	function getSortedData(sortVal) {
		document.getElementById("sortType").value = sortVal;
		document.getElementById("sortSubmit").click();
	}
	
	
	function chooseFile(studentId){
		document.getElementById('changeFile_' + studentId).click();
		
		
		var fileInput = document.getElementById('changeFile_' + studentId);
		alert(fileInput);
	      var file = fileInput.files[0];
	      alert(file);
	      if (file) {
	        var xhr = new XMLHttpRequest();
	        var formData = new FormData();

	        formData.append('file', file);
	        formData.append('action', 'updateImage');
	        formData.append('studentId', studentId);
	        
	        

	        xhr.open('POST', '/LoginExample2/MyProfileServlet', true);

	        xhr.onload = function () {
	          if (xhr.status >= 200 && xhr.status < 300) {
	            console.log('Image uploaded successfully');
	          } else {
	            console.error('Image upload failed');
	          }
	        };

	        xhr.send(formData);
	      } else {
	        console.error('No file selected');
	      }
		
		
			
	}
	
	
</script>



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

	<%
	String sortType = "";
	if (request.getParameter("sortType") != null) {
		sortType = request.getAttribute("sortType").toString().trim();			
	}
	%>



	<div class="button-div">
		<a href="addUser.jsp"> <span class="span-button">Add User</span></a> <label
			class="sort">Sort By :</label> <select
			onchange="getSortedData(this.value);">
			<option <% if(sortType.equals("") || sortType.equals("id")){%>selected<% }%> value="id">Id</option>
			<option <% if(sortType.equals("name")){%>selected<% }%> value="name">Name</option>
			<option <% if(sortType.equals("age")){%>selected<% }%> value="age">Age</option>
		</select>
	</div>


	<div>
		<table>
			<tr>
				<th>Id</th>
				<th>Student Name</th>
				<th>Age</th>
				<th>Course</th>
				<th>Images</th>
				<th>Action</th>
			</tr>
			<%
			StudentService studentService = new StudentService();

			List<Student> list = studentService.getAllStudents(sortType);
			String image= "noprofile.jpg";

			for (Student student : list) {
			%>
			<tr>
				<td><%=student.getId()%></td>
				<td><%=student.getName()%></td>
				<td><%=student.getAge()%></td>
				<td><%=student.getCourse()%></td>
				
				<%
					if(student.getProfileImage() != null){
						image = student.getProfileImage().trim();
					}
				
				%>
				
				<td><div class="profile_image"><img alt="img" src="/LoginExample2/uploadedImages/<%=image%>">
				<input type="file" id="changeFile_<%=student.getId()%>" style="display: none">
				</div></td>
				<td><a
					href="/LoginExample2/UserServlet?action=delete&id=<%=student.getId()%>">
						<span class="span-button">Delete</span>
				</a><a
					href="/LoginExample2/UserServlet?action=update&id=<%=student.getId()%>">
						<span class="span-button">Update</span>
				</a><span onclick="chooseFile('<%=student.getId()%>')" class="span-button">Update Image</span></td>
			</tr>
			<%}%>
		</table>
	</div>



	<form action="/LoginExample2/MyProfileServlet">
		<input id="sortType" value="id" type="hidden" name="sortType">
		<input id="sortSubmit" type="submit" style="display: none;">
	</form>



</body>

</html>