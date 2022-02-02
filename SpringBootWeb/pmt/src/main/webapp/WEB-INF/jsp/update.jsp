<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Update Account Details</title>
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
	<label class="alert alert-info">Update Account Details</label>
	<f:form  method="post" modelAttribute="account" >
	<div class="alert alert-success">
    <strong>${message}</strong> 
  </div>
	<br>
	<div class="alert alert-danger">
  <strong>${errorMessage}</strong> 
</div>
	<table class="table table-striped" aria-hidden="true">
	<tr> <td> Enter Account URL:  </td> <td> <f:input path="url"
			placeholder="Enter Account URL" required="true" /></td></tr>
		
	<tr> <td> Enter new password name:   </td> <td> <f:input type="password" path="password"
			placeholder="Enter new password name" required="true" /></td></tr>
		
	</table>
		<input type="submit"   class="btn btn-warning btn-lg" value="Update">

	</f:form>
	<br>
	<br>
	<a href="/viewAccount"  class="btn btn-primary btn-lg">Click Here for Home</a>
	</div>
</body>
</html>