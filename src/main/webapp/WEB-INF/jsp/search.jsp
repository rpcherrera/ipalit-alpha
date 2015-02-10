<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp"%>
<link href="<c:url value="/resources/css/account.css" />"
	rel="stylesheet">
<div class="container" style="min-height: 768px;">
	<div class="col-sm-9 padding-right">
		<div class="searchheader">
			<h2 class="title text-center">Tradables</h2>
		</div>
		<hr>
		<div class="row">

			<div class="wala padding-right">
				<div class="features_items">
					<!--features_items-->
						<c:forEach items="${bluga}" var="blog">
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">

										<!--<img src="http://www.urbansplatter.com/wp-content/uploads/2014/07/Ringo-Starr-the-beatles-31507635-500-678.jpg" alt="" />-->

										<img
											src="http://www.getelastic.com/wp-content/uploads/open-box.jpg"
											alt="" />
										<h2><c:out value="${blog.itemname}" /></h2>
									</div>
									<div class="product-overlay">
										<div class="overlay-content">
											<h2><c:out value="${blog.itemname}" /></h2>
											<a class="btn btn-default add-to-cart" href="<spring:url value="/items/${blog.id}.html" /> ">
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