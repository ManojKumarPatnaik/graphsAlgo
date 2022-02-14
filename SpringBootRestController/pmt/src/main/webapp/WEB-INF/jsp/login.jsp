<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
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
	<label style="text-align: center; font-size: 40px" class="alert alert-success">Login</label>
	<br>
	<br>
	
	<label>Enter your master
		credentials</label>
	<f:form method="post" modelAttribute="masterUser">
		
	<br>
	<div class="alert alert-danger">
  <strong>${message}</strong> 
</div>
		
	<div class="form-group">
      <label >Master User Name:</label>
      <input class="form-control" id="username" placeholder="Enter the Master User Name"  name="username"  >
    </div>
    <div class="form-group">
      <label >Master Password: </label>
      <input type="password" class="form-control" id="password" placeholder="Enter the Master Password" name="password">
    </div>
		<input type="submit" class="btn btn-success" value="Login">




	</f:form>
	<br>
	<a href="/welcome" class="btn btn-warning" >Click Here for Welcome</a>
	</div>
</body>
</html>