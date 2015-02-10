<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp"%>
<link href="<c:url value="/resources/css/item-page.css" />" rel="stylesheet">
<div class="container" style="margin-top: 40px; margin-bottom: 40px;">
        <div class="col-sm-9 padding-right">
                        <div class="searchheader">
                            <h2 class="title text-center"><c:out value="${item.itemname }"/></h2>
                        </div>
                        <hr>
        <div class="row">

            <div class="detailsContainer">
            <div class="span9">
            <ul id="productDetail" class="nav nav-tabs">
              <li class="active"><a href="#home" data-toggle="tab">Item Details</a></li>
             <!--  <li><a href="#profile" data-toggle="tab">Owner Details</a></li> -->
            </ul>
            <div id="myTabContent" class="tab-content">
              <div class="tab-pane fade active in" id="home">
              <h4>Product Information</h4>
                <table class="table table-bordered" cellspacing="0">
                <tbody>
                <tr class="techSpecRow"><th colspan="2">Item Details</th></tr>
                <tr class="techSpecRow"><td class="techSpecTD1">Item ID: </td><td class="techSpecTD2"><c:out value="${item.id }"/></td></tr>
                <tr class="techSpecRow"><td class="techSpecTD1">Item Name:</td><td class="techSpecTD2"><c:out value="${item.itemname }"/></td></tr>
                <tr class="techSpecRow"><td class="techSpecTD1">Warranty:</td><td class="techSpecTD2"><c:out value="${item.warranty }"/></td></tr>
                <tr class="techSpecRow"><td class="techSpecTD1">Condition:</td><td class="techSpecTD2"><c:out value="${item.itemCondition }"/></td></tr>
                <tr class="techSpecRow"><td class="techSpecTD1">Description:</td><td class="techSpecTD2"><c:out value="${item.itemdescription }"/></td></tr>
                
				<tr class="techSpecRow"><td class="techSpecTD1"><b>Looking for: </b></td><td class="techSpecTD2">
				<c:forEach items="${item.user.wish}" var="ooh">
				
				<strong><a href="<spring:url value="/wishlists/${ooh.id }.html"/>">${ooh.wishlistName }</a></strong>
				
				</c:forEach>
				<br /></td></tr>
				<tr class="techSpecRow"><td class="techSpecTD1">Posted by:</td><td class="techSpecTD2"><strong><a href="<spring:url value="/profile/${item.user.id }.html"/>">${item.user.username }</a></strong></td></tr>
                <tr class="techSpecRow"><td class="techSpecTD1">Posted on:</td><td class="techSpecTD2">${item.datePosted }<br /></td></tr>
                </tbody>
                </table>
              </div>


            <div class="tab-pane fade" id="profile">
              <h4>Owner Information</h4>
                <table class="table table-bordered" cellspacing="0">
                <tbody>
                <tr class="techSpecRow"><th colspan="2">Owner Details</th></tr>
                <tr class="techSpecRow"><td class="techSpecTD1">Blank: </td><td class="techSpecTD2">Blah blah blah</td></tr>
                <tr class="techSpecRow"><td class="techSpecTD1">Blank:</td><td class="techSpecTD2">Blah blah blah</td></tr>
                <tr class="techSpecRow"><td class="techSpecTD1">Blank:</td><td class="techSpecTD2">Blah blah blah</td></tr>
                <tr class="techSpecRow"><td class="techSpecTD1">Blank:</td><td class="techSpecTD2">Blah blah blah</td></tr>
                <tr class="techSpecRow"><td class="techSpecTD1">Blank:</td><td class="techSpecTD2">Blah blah blah</td></tr>
                </tbody>
                </table>
            </div>
            </div>

            </div>
            </div><!--detailsContainer-->



                <div class="wala padding-right">
                    <div class="features_items"><!--features_items-->

                        <div class="col-sm-4">
                            <div class="product-image-wrapper">
                                <div class="single-products">
                                        <div class="productinfo text-center">

                                            <img src="http://www.getelastic.com/wp-content/uploads/open-box.jpg" alt="" />


                                            <h2><c:out value="${item.itemname }"/></h2>
                                        </div>
                                </div>
                            </div>
                        </div>  
                    </div><!--features_items-->
                </div>
        </div>
                </div>
        </div>