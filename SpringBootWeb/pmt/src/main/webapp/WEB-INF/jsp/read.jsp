<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Read Password</title>
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
<label class="alert alert-success">Read Password</label>
<br>
	<div class="alert alert-success">
    <strong>${message}</strong> 
  </div>
	<br>
	<f:form  method="post" modelAttribute="account">
	<table class="table table-striped" aria-hidden="true">
		
	<tr> <td>  Account name:   </td> <td> <f:input  path="username"
			placeholder="Enter Account name" required="true" readonly="true" /></td></tr>
	</table>
		

	</f:form>
<br>
<br>


<br>
	<a href="/viewAccount"  class="btn btn-primary btn-lg">Click Here for Home</a>
</div>
</body>
</html>