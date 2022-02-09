<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Menu Page</title>
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
	<label style="text-align: center;color: green; font-size: 50px" class="well well-lg">Menu Options</label>
	<br>
	<br>
	<label class="alert alert-info" >Click on the button for Respective option</label>
	<br>
	<br>
	<label>
		<a href="/createAccount" class="btn btn-primary btn-lg">Create Account</a>
	</label>
	<br>
	<br>
	<label>
		<a href="/viewAccount" class="btn btn-info btn-lg">Home Page </a>
	</label>
	<br>
	<br>
	<label>
		<a href="/deletegroup" class="btn btn-danger btn-lg">Delete Group</a>
	</label>
	<br>
	<br>
	<label>
		<a href="/deleteUrl" class="btn btn-danger btn-lg">Delete URL</a>
	</label>
	
	<br>
	<br>
	
	
	<br>
	<br>
	<label>
		<a href="/sortbygroup" class="btn btn-info btn-lg">Sort By Group Name</a>
	</label>
	<br>
	<br>
	<label>
		<a href="/logout" class="btn btn-danger btn-lg">Logout Account</a>
	</label>
	<br>
	<br>
	<div class="alert alert-success">
    <strong>${message}</strong> 
  </div>
</div>
</body>
</html>