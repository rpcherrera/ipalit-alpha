<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<!-- CSS NI ACE -->
<link href="<c:url value="/resources/css/bootstrap2.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/font-awesome.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/animate.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

<!-- JS NI ACE -->
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap2.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/main.js" />"></script>



<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

<!-- JS NI MIKE -->
<script type="text/javascript"
	src="<c:url value="/resources/js/search.js" />"></script>
<!-- RALPH -->
<%-- <link href="<c:url value="/resources/css/carousel.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/signin.css" />" rel="stylesheet"> --%>

<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">

<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
 -->


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
</head>
<body>

	<tilesx:useAttribute name="current" />

	<header class="navbar navbar-inverse navbar-fixed-top wet-asphalt"
		role="banner">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href='<spring:url value="/" />'><img
					src='<c:url value="/resources/images/logo2.png"/>' alt="logo"></a>
			</div>
			<div class="collapse navbar-collapse">
				<div class="col-sm-3 col-md-3 pull-left" style="padding-top: 15px;">

					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search"
							name="q" id="field-1" value="${asdf}">
						<div class="input-group-btn">
							<button class="btn btn-default" type="submit" id="test">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</div>
					</div>
				 <input id="tradables" type="radio" name="itemsearch" value="tradables">Tradables
					<input id="wishlist" type="radio" name="itemsearch" value="wishlist">Wishlist<br />
				</div>
				<ul class="nav navbar-nav navbar-right">
					<li class="${current == 'index' ? 'active' :''} "><a
						href='<spring:url value="/" />'>Home</a></li>
					<li class="${current == 'tradables' ? 'active' :''} "><a
						href='<spring:url value="/items.html" />'>Tradables</a></li>
					<li class="${current == 'wishlists' ? 'active' :''} "><a
						href='<spring:url value="/wishlists.html" />'>Wishlists</a></li>
					<security:authorize access="hasRole('ROLE_ADMIN')">
						<li class="${current == 'users' ? 'active' :''} "><a
							href='<spring:url value="/users.html" />'>Users</a></li>
					</security:authorize>
					<security:authorize access="hasRole('ROLE_USER')">
						<li class="${current == 'account' ? 'active' :''} "><a
							href='<spring:url value="/account.html" />'>My Account</a></li>
					</security:authorize>
					<security:authorize access="! isAuthenticated()">
						<li class="${current == 'register' ? 'active' :''} "><a
							href='<spring:url value="/register.html" />'>Register</a></li>
						<li class="${current == 'login' ? 'active' :''} "><a
							href='<spring:url value="/login.html" />'>Sign in</a></li>
					</security:authorize>
					<security:authorize access="isAuthenticated()">
						<li><a href='<spring:url value="/logout" />'>Logout</a></li>
					</security:authorize>
				</ul>
			</div>
		</div>
	</header>
	<!--/header-->

	<tiles:insertAttribute name="body" />
	<!-- <section id="search-boxes">
	<div class="container">
		<div class="boxOne">
			<div id="searchOne">
				<input type="text" style="width: 375px; height: 40px;"
					placeholder="I'm Looking for..." id="field-1"/>
				<button class="btn-search btn-danger" type="button" id="test">
					<span class="glyphicon glyphicon-search"></span>
				</button>
				<div>
					SOME TEXT HERE
				</div>
			</div>
		</div>
		<div class="boxTwo">
			<div id="searchTwo">
				<input type="text" style="width: 375px; height: 40px;"
					placeholder="I would like to trade..." />
				<button class="btn btn-danger" type="button">
					<span class="glyphicon glyphicon-search"></span>
				</button>
				<div>
					SOME TEXT HERE
				</div>
			</div>
		</div>
	</div>
</section>
/#search-boxes -->
	<br />
	<br />

	<center>
		<tiles:insertAttribute name="footer" />
	</center>
</body>
</html>