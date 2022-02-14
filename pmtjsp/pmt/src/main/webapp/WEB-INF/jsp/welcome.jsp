<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
 <!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PMT Application</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
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

<body >
	<div class="container">
    <img src="PMT.PNG"  style="max-width:100%; max-height:100%;"  alt="pmt">
		<label style="color: blue;text-align: center; font-size: 40px " class="well well-lg">Welcome to
			Password Management Tool Application</label>
		<f:form style="text-align: center; max-width:500px; margin:auto;">
			<br>
			<label style="text-align: center; font-size: 20px" class="alert alert-info">Click a option</label>
			<br>
			<br>
			<button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo">PMT</button>
  <div id="demo" class="collapse">
   <label> Password Management Tool (PMT)</label>
    <label>
Vision:</label>
 <label>
Build secured password management tool which supports various interfaces like Web, Smart Devices, browser plugins, Application Plugins. The application should be scalable, maintainable.
</label>
 <label>Introduction:</label>
 <label>
We have to remember many passwords for our day to day activities. But it is very tedious job as the secured application list is growing day by day. So one can use Password Management Tool to maintain the passwords for each application and user can remember only one master password. As PMT stores data in PC's Memory, it should have strong encryption before storing the user's personal data to the hard drive or any where.
  </label>
  </div>
  <br>
  <br>
			<br>
			<label style="color: red">
				<a href="/masterUserRegister" class="btn btn-primary btn-lg">Click Here for Register </a>
			</label>
			<br>
			<br>
			<br>
			<label style="color: green">

				<a href="/login" class="btn btn-success btn-lg">Click Here for Login </a>
			</label>
			<br>
			<br>
			<br>
			<label style="color: orange">

				<a href="/viewAllUsers" class="btn btn-info btn-lg">Click Here for Display All Master Users </a>
			</label>
			<br>
			<br>
			<br>
			<div class="alert alert-danger">
  <strong>${message}</strong> 
</div>
		</f:form>
	</div>
</body>
</html>