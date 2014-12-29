<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp"%>

<form:form commandName="user" cssClass="form-horizontal">
	<div class="form-group">
		<label for="fname" class="col-sm-2 control-label">First Name</label>
		<div class="col-sm-7">
			<form:input path="fname" cssClass="form-control" />
		</div>
	</div>
	<div class="form-group">
		<label for="lname" class="col-sm-2 control-label">Last Name</label>
		<div class="col-sm-7">
			<form:input path="lname" cssClass="form-control" />
		</div>
	</div>
	<div class="form-group">
		<label for="username" class="col-sm-2 control-label">Username</label>
		<div class="col-sm-7">
			<form:input path="username" cssClass="form-control" />
		</div>
	</div>
	<div class="form-group">
		<label for="email" class="col-sm-2 control-label">Em@il</label>
		<div class="col-sm-7">
			<form:input path="email" cssClass="form-control" />
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Password</label>
		<div class="col-sm-7">
			<form:password path="password" cssClass="form-control" />
		</div>
	</div>
	<div class="form-group">
		<label for="contactnum" class="col-sm-2 control-label">Contact Number</label>
		<div class="col-sm-7">
			<form:input path="contactnum" cssClass="form-control" />
		</div>
	</div>
	<center><div class="form-group">
		<div class="col-sm-2">
			<input type="submit" value="Register" class="btn btn-lg btn-info" />
		</div></center>
	</div>
</form:form>