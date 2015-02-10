<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp"%>
<link href="<c:url value="/resources/css/search.css" />" rel="stylesheet">
<%-- <c:forEach items="${wishlists}" var="wishes">
	<a href="<spring:url value="/wishlists/${wishes.id}.html"/>"> <c:out
			value="${wishes.wishlistName}" />
	</a>
${wishes.id }<br />
${wishes.wishlistName }<br />
${wishes.wishlistDesc }<br />
${wishes.datePosted }<br />

	<h3>POSTED BY</h3>
${wishes.user.username }<br />
${wishes.user.name }<br />
${wishes.user.lname }<br />
${wishes.user.contactnum }<br />
${wishes.user.email }<br />
${wishes.user.dateJoined }<br />
</c:forEach> --%>
<div class="container" style="min-height: 768px;">
	<div class="col-sm-9 padding-right">
		<div class="searchheader">
			<h2 class="title text-center">Wishlists</h2>
		</div>
		<hr>
		<div class="row">

			<div class="wala padding-right">
				<div class="features_items">
					<!--features_items-->
						<c:forEach items="${wishlists}" var="wishes">
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center" style="height: 340px;">

										<!--<img src="http://www.urbansplatter.com/wp-content/uploads/2014/07/Ringo-Starr-the-beatles-31507635-500-678.jpg" alt="" />-->

										<img
											src="http://www.getelastic.com/wp-content/uploads/open-box.jpg"
											alt="" />
										<h2><c:out value="${wishes.wishlistName }" /></h2>
										<strong>Posted on: </strong><i><c:out value="${wishes.datePosted}" /></i>
									</div>
									<div class="product-overlay">
										<div class="overlay-content">
											<h2><c:out value="${wishes.wishlistName }" /></h2>
											<a class="btn btn-default add-to-cart" href="<spring:url value="/wishlists/${wishes.id}.html" /> ">
												<strong><i>
											More Info</i></strong></a>
										</div>
									</div>
								</div>
							</div>
							</div>
						</c:forEach>
				</div>
				<!--features_items-->
			</div>
		</div>
	</div>
</div>
<!-- /.container -->