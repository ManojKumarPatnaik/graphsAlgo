<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Edit Account Page</title>
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
<f:form  method="post" modelAttribute="account">
	<div class="alert alert-info">
    <strong>Edit an Account</strong> 
  </div>
  <div class="alert alert-danger">
  <strong>${message}</strong> 
</div>
	
	
	<table class="table table-striped" aria-hidden="true">
	<tr> <td>Account ID:       </td> <td><f:input path="accountId"
			placeholder="Enter the accountId" required="true" value="${account.accountId}" readonly="true" /></td></tr>
	<tr> <td>Enter Account URL:       </td> <td><f:input path="url"
			placeholder="Enter the URL" required="true" value="${account.url}" /></td></tr>
	<tr> <td>Enter Account Name:      </td> <td><f:input path="username"
			placeholder="Enter the UserName" required="true" value="${account.username}"/></td></tr>
		
	<tr> <td>Enter Account Password:  </td> <td><f:input type="password" path="password"
			placeholder="Enter the Password" required="true" value="${account.password}" /></td></tr>
		
	<tr> <td>Enter Account Group:    </td> <td><f:input  path="group"
			placeholder="Enter the Group" required="true" value="${account.group}" /></td></tr>
			</table>
		
		<input type="submit" class="btn btn-primary btn-lg" value="Edit Account">

	</f:form>
	
	<br>
	<a href="/viewAccount"  class="btn btn-info btn-lg" >Click Here for Home</a>
	</div>
</body>
</html>