<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Home Account Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
.container {width =20%;
	border: 1px solid black;
	margin: auto;
	padding: 20px;
	font-size: 20px;
}
</style>
</head>
<body>


	<div class="container">
 
  <label><a href="/createAccount" class="btn btn-success btn-lg">Create Account</a></label> 
  <label><a href="/sortbygroup" class="btn btn-warning btn-lg">Sort By Group</a></label> 
  <label>
		<a href="/viewAccount" class="btn btn-info btn-lg">Refresh</a>
	</label>	
	
  <label><a href="/logout" class="btn btn-danger btn-lg">LogOut</a></label> 

	<br> <br>
	
		<div class="alert alert-success">
			<strong>${message}</strong>
		</div>
		<br> <br>

		<table border=1 class="table table-striped" aria-hidden="true">
			<tr>
				<th>Id</th>
				<th>URL</th>
				<th>UserName</th>
				<th>Password</th>
				<th>Group</th>
				<th>Action</th>
				<th>Action</th>
				<th>Action</th>
				
			</tr>
			<c:forEach items="${accounts}" var="task">
				<tr>
					<td><c:out value="${task.accountId}" /></td>
					<td><c:out value="${task.url}" /></td>
					<td><c:out value="${task.username}" /></td>
					<td><c:out value="${task.password}" /><a href="/read?username=${task.username}"
						class="btn btn-success">View</a></td>
					<td><c:out value="${task.group}" /></td>
					<td><a href="/edit/${task.accountId}"
						class="btn btn-primary">Edit </a></td>
					<td><a href="/deletegroup?group=${task.group}"
						class="btn btn-danger">Delete Group</a></td>
						<td><a href="/deleteUrl?url=${task.url}"
						class="btn btn-warning">Delete URL</a></td>
						
						
				</tr>

			</c:forEach>

		</table>
		</div>
</body>
</html>