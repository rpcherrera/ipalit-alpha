<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp"%>
		
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">

<div class="logincontainer" align="center">
	<div id="image">
		<img src='<c:url value="/resources/images/imac.png"/>'
			style="width: 640px; height: 678 padding-top:20px;" />
	</div>
	<div id="loginForm">
		<!--<div class="panel panel-default">-->
		<div class="panel-body">
			<h2 style="font-family: Arial; font-weight: 600;" class="panel-title">Please sign in</h2>
			<br>
			<form class="form-signin" role="form"
				action='<spring:url value="/j_spring_security_check" />'
				method="POST">
				<fieldset>
					<input style="margin-top:15px; margin-bottom: 15px;" type="text" name="j_username" class="form-control" placeholder="Username" required="" autofocus=""> 
					<br>
					<input style="margin-top:15px; margin-bottom: 15px;" type="password" name="j_password" id="inputPassword" class="form-control" placeholder="Password" required="">
					<br>
					<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
				</fieldset>
			</form>			
		</div>
		Don't have an iPalit account? Register <strong><a href='<spring:url value="/register.html" />'>here.</a></strong>
	</div>
</div>