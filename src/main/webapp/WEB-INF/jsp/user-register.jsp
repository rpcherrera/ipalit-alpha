<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp"%>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
<script type="text/javascript" src="<c:url value="/resources/js/regValidate.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.numeric.js" />"></script>

<link href="<c:url value="/resources/css/registration.css" />" rel="stylesheet">

<div class="container" style="max-width:1200px; height: auto; overflow: hidden; padding-top:50px; padding-bottom:50px; ">

            <div class="fields">
            <h2 align="center">Create iPalit Account</h2>
                <form:form commandName="user" cssClass="form-horizontal regForm">
            <fieldset id="form">
                <c:if test="${success eq true }">
                    <div class="alert alert-success">Registration successful!</div>
                </c:if>
               

                <div class="form-group">
                    <label for="name" class="col-sm-4 control-label">First Name</label>
                    <div class="col-sm-7">
                        <form:input path="name" cssClass="form-control" id="name" />
                        <form:errors path="name" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="lname" class="col-sm-4 control-label">Last Name</label>
                    <div class="col-sm-7">
                        <form:input path="lname" cssClass="form-control" id="lname" />
                        <form:errors path="lname" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="username" class="col-sm-4 control-label">Username</label>
                    <div class="col-sm-7">
                        <form:input path="username" cssClass="form-control" />
                        <form:errors path="username" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-4 control-label">Email</label>
                    <div class="col-sm-7">
                        <form:input path="email" cssClass="form-control" />
                        <form:errors path="email" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-4 control-label">Password</label>
                    <div class="col-sm-7">
                        <form:password path="password" cssClass="form-control" />
                        <form:errors path="password" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-4 control-label">Re-type
                        password</label>
                    <div class="col-sm-7">
                        <input type="password" name="cpassword" id="cpassword"
                            class="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="contactnum" class="col-sm-4 control-label">Contact
                        Number</label>
                    <div class="col-sm-7">
                        <form:input path="contactnum" cssClass="form-control" id="con"/>
                        <form:errors path="contactnum" />
                    </div>
                </div>
                   <input class="btn btn-lg btn-success btn-block" type="submit" value="Create" style="background-color: ##2980b9" />
        
                    </fieldset>
                </form:form>
            </div>

            <div id="imagecontainer">

                <div id="image">
            <img id="gadgetimg" src='<c:url value="/resources/images/prac.png"/>' />
        </div>
    </div>
</div>