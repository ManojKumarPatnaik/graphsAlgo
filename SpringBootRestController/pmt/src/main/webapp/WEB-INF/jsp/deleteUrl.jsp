<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Delete Account Details</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
<label class="alert alert-success">
	Delete Account Details </label>
	<form action="/deleteUrl" method="post" >
	
	<br>
	<div class="alert alert-danger">
  <strong>${message}</strong> 
</div>
	<table class="table table-striped" aria-hidden="true">
	<tr> <td> Enter Account URL:  </td> <td> <input name="url"
			placeholder="Enter Account URL"  /></td></tr>
		
	
		
	</table>
		<input type="submit" class="btn btn-danger btn-lg" value="Delete">

	</form>
	<br>
	<br>
	<a href="/viewAccount" class="btn btn-primary btn-lg">Click Here for Home</a>
	</div>
</body>
</html>