<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>File Upload-Shopping Bee</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="<c:url value='/static/css/home.css' />" rel="stylesheet"></link>
	<script src="<c:url value='/static/js/jquery.min.js'/>"></script>
	<script src="<c:url value='/static/js/bootstrap.min.js'/>"></script>
	<link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet"></link>
</head>
<body> 
 	<div class="container-fluid">
			<div class="header">
				<img id="logo" class="logo" src="<c:url value='/static/images/logo.png' />" alt="Logo" href="http://localhost:8080/ShoppingBee/static/html/home.htm" width="5%!important" height="15%!important">
				<span id="title" class="title">Shopping Bee</span>
				<div class="btn-group-vertical">
					<a href="cart.htm" id="mycart" type="button" class="btn btn-link btn-lg" href="cart.htm">
						<span class="glyphicon glyphicon-shopping-cart"></span> My Cart
					</a>
					<a href="http://localhost:8080/ShoppingBee/logout" id="logout" type="button" class="btn btn-link btn-lg" href="#">
						<span class="glyphicon glyphicon-off"></span> Logout
					</a>
				</div>
        <div class="btn-group-vertical">
          <a href="http://localhost:8080/ShoppingBee/static/html/account.htm" id="mycart" type="button" class="btn btn-link btn-lg" href="cart.htm">
            <span class="glyphicon glyphicon-user"></span> My Account
          </a>
          <a href="login.htm" id="logout" type="button" class="btn btn-link btn-lg" href="#">
            <span class="glyphicon glyphicon-heart"></span> My Wishlist
          </a>
        </div>
        <div class="btn-group-vertical">
					<a href="http://localhost:8080/ShoppingBee/static/html/order.htm" id="mycart" type="button" class="btn btn-link btn-lg" href="cart.htm">
						<span class="glyphicon glyphicon-tags"></span> My Orders
					</a>
				</div>
			</div>
		</div>
		<div id="nav" class="btn-group btn-group-justified">
			<div class="btn-group">
				<a href="http://localhost:8080/ShoppingBee/static/html/home.htm" id="home" type="button" class="btn btn-primary"><span class="glyphicon glyphicon-home"></span> HOME</a>
			</div>
			<div class="btn-group">
				<a href="http://localhost:8080/ShoppingBee/static/html/electronics.htm" id="electronics" type="button" class="btn btn-primary">ELECTRONICS</a>
			</div>
			<div class="btn-group">
				<a href="http://localhost:8080/ShoppingBee/static/html/books.htm" id="books" type="button" class="btn btn-primary">BOOKS</a>
			</div>
			<div class="btn-group">
				<a href="http://localhost:8080/ShoppingBee/static/html/sports.htm" id="sports" type="button" class="btn btn-primary">SPORTS</a>
			</div>
			<div class="btn-group">
				<a href="http://localhost:8080/ShoppingBee/static/html/clothes.htm" id="clothing" type="button" class="btn btn-primary">CLOTHING</a>
			</div>
		</div>
    <div class="container">
        <h1>Spring 4 MVC File Upload Example </h1>
        <form:form method="POST" modelAttribute="fileBucket" enctype="multipart/form-data" class="form-horizontal">
         
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="file">Upload a file</label>
                    <div class="col-md-7">
                        <form:input type="file" path="file" id="file" class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="file" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
     
            <div class="row">
                <div class="form-actions floatRight">
                    <input type="submit" value="Upload" class="btn btn-primary btn-sm">
                </div>
            </div>
        </form:form>
        <a href="<c:url value='/welcome' />">Home</a>
    </div>
</body>