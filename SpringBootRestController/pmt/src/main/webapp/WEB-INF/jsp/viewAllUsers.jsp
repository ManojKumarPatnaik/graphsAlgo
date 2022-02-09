<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Display Users Page</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
.container{ width=20%;
border:1px solid black;
margin: auto;
padding: 20px;
font-size: 20px;}
</style>
</head>
<body>
<div class="container">
	<div class="alert alert-success">
    <strong>${message}</strong> 
  </div>
	<br>
	<br>
	
	<table border=1 class="table table-striped" aria-hidden="true">
		<tr>
			<th>Id</th>
			<th>UserName</th>
			<th>Password</th>
		</tr>
		<c:forEach items="${accounts}" var="task">
			<tr>
				<td><c:out value="${task.userid}" /></td>
				<td><c:out value="${task.username}" /></td>
				<td><c:out value="${task.password}" /></td>
			</tr>

		</c:forEach>

	</table>

	<br>
	<a href="/welcome" class="btn btn-warning" >Click Here for Welcome</a>
	</div>
</body>
</html>