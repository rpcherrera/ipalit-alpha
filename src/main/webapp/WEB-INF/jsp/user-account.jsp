<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp"%>
<link href="<c:url value="/resources/css/account.css" />"
	rel="stylesheet">
<script type="text/javascript">
$(document).on('click','a.spoiler',function() {
				$text = "<a href=\"\" onclick=\"return false\" class=\"spoiler\" content=\"<strong>"+ $(this).text()+ "\">"
				+ $(this).attr("content") + "</strong></a>";
				$(this).replaceWith($text);
});
</script>
<hr>
<div class="container">
	<div class="row">
		<div class="col-sm-10">
			<h1>
				<c:out value="${user.username }" />
			</h1>
		</div>
		<!-- <div class="col-sm-2">
			<a href="/users" class="pull-right"><img
				class="img-responsive img-thumbnail img-circle"
				src="images/mikee.jpg" alt=""></a>
		</div>
		<input style="width: 220px; float: right;" type="file"
			class="form-control"> -->
	</div>
	<div class="row">
		<div class="profileDetails"
			style="width: 350px; height: 250px; float: left;">
			<div class="profileInfo" style="width: 350px; height: 200px;">
				<!--left col-->

				<ul class="list-group-1">
					<li class="list-group-item text-muted">Profile</li>
					<li class="list-group-item text-right"><span class="pull-left"><strong>Username:</strong></span>
						<c:out value="${user.username }" /></li>
					<li class="list-group-item text-right"><span class="pull-left"><strong>Real
								Name: </strong></span> <c:out value="${user.name }" /> <c:out
							value="${user.lname }" /></li>

					<li class="list-group-item text-right"><span class="pull-left"><strong>Contact
								Number: </strong></span> <a href="" onclick="return false" class="spoiler"
						content="<c:out value="${user.contactnum }" />"> <strong>Click
								to show</strong>
					</a></li>

					<li class="list-group-item text-right"><span class="pull-left"><strong>Email
								Address:</strong></span> <c:out value="${user.email }" /></li>
					<li class="list-group-item text-right"><span class="pull-left"><strong>Member
								Since: </strong></span> <c:out value="${user.dateJoined }" /></li>
					
				</ul>
			</div>
		</div>
		<!--/col-3-->

		<!-- TRADABLES TAB -->

		<div class="col-sm-900">
			<ul class="nav nav-tabs" id="myTab">
				<li class="active"><a href="#tradaballs" data-toggle="tab">View
						Tradables</a></li>
				<li><a href="#swishlist" data-toggle="tab">View Wishlist</a></li>
				<li><a href="#feedback" data-toggle="tab">View Feedback</a></li>
				<li><a href="#edit" data-toggle="tab">Edit Profile</a></li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane active" id="tradaballs">
					<div class="table-responsive">
						<table class="table table-hover">
							<div class="row1">
								<div class="addItem">
									<input type="button" class="btn btn-info btn-block"
										data-toggle="modal" data-target="#myModal" value="Add Item"
										style="width: 100px; margin: 20px 0 20px 20px;" />
								</div>
								<hr>

								<c:forEach items="${user.blogs}" var="blog">
									<div class="col-sm-4 col-lg-4 col-md-4">
										<div class="thumbnail" id="blog_${blog.id}">
											<a href="<spring:url value="/blog/remove/${blog.id}.html" />"
												class="btn btn-danger btn-xs triggerRemove">Delete Item</a>
											<img
												src="http://www.getelastic.com/wp-content/uploads/open-box.jpg"
												alt="">
											<div class="caption">
												<h4>
													<a href="<spring:url value="/items/${blog.id}.html"/>">
														<c:out value="${blog.itemname}" />
													</a>
												</h4>
												<p>
													Item Condition: <strong><c:out
															value="${blog.itemCondition}" /></strong>
												</p>
												<em>Posted on: <c:out value="${blog.datePosted}" /></em>
											</div>
										</div>
									</div>
								</c:forEach>

							</div>
							</div>
							<!--/tab-pane-->
						</table>
						<div class="row1">
							<div class="col-md-4 col-md-offset-4 text-center">
								<ul class="pagination" id="myPager"></ul>
							</div>
						</div>
					</div>
					<!--/table-resp-->
				</div>

				<!-- WISHLIST TAB -->

				<!--/tab-pane-->
				<div class="tab-pane" id="swishlist">
					<div class="addItem">

						<input type="button" class="btn btn-info btn-block"
							data-toggle="modal" data-target="#myModal2" value="Add Wishlist"
							style="width: 125px; margin: 20px 0 20px 20px;" />
					</div>
					<hr>

					<div class="row1">
						<c:forEach items="${user.wish }" var="wish">
							<div class="col-sm-4 col-lg-4 col-md-4">

								<div class="thumbnail" id="blog_${wish.id}">
									<a href="<spring:url value="/wish/remove/${wish.id}.html" />"
										class="btn btn-danger btn-xs triggerRemove2">Delete
										Wishlist</a> <img
										src="http://www.getelastic.com/wp-content/uploads/open-box.jpg"
										alt="">
									<div class="caption">
										<h4>
											<a href="#"><c:out value="${wish.wishlistName}" /></a>
										</h4>
										<p>
											<em><c:out value="${wish.wishlistDesc}" /></em>
										</p>
										<strong><c:out value="${wish.datePosted}" /></strong>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>

				<!--/tab-pane-->
				<!-- FEEDBACJ TAB -->

				<div class="tab-pane" id="feedback">
					<hr>

					<div class="row">
						<div class="col-sm-4 col-lg-4 col-md-4">
							<c:forEach items="${user.feedbacks }" var="feedback">
								<div class="thumbnail" id="blog_${feedback.id}">
									<div class="caption">
										<h4>
											<a href="#"><c:out value="${feedback.rating}" /></a>
										</h4>
										<p>
											<em><c:out value="${feedback.feedbackDesc}" /></em>
										</p>
										<strong>Posted by <c:out
												value="${feedback.user.name}" /> on <c:out
												value="${feedback.datePosted}" />
										</strong>
									</div>
								</div>
							</c:forEach>
						</div>

					</div>

				</div>
				<!--/tab-pane-->



				<!-- EDIT PROFILE TAB -->

				<div class="tab-pane" id="edit">
					<form class="form" action="##" method="post" id="registrationForm">
						<div class="form-group">
							<div class="col-xs-6">
								<label for="user_name"><h4>Username</h4></label> <input
									type="text" class="form-control" name="user_name"
									id="user_name" placeholder="username">
							</div>
						</div>

						<div class="form-group">
							<div class="col-xs-6">
								<label for="full_name"><h4>Full Name</h4></label> <input
									type="text" class="form-control" name="full_name"
									id="full_name" placeholder="Full Name">
							</div>
						</div>

						<div class="form-group">
							<div class="col-xs-6">
								<label for="contact_number" style="margin-top: 30px;"><h4>Contact
										Number</h4></label> <input type="text" class="form-control"
									name="contact_number" id="contact_number"
									placeholder="Contact Number">
							</div>
						</div>

						<div class="form-group">
							<div class="col-xs-6">
								<label for="email_address" style="margin-top: 30px;"><h4>Email
										Address</h4></label> <input type="text" class="form-control"
									name="email_address" id="email_address"
									placeholder="Email Address">
							</div>
						</div>

						<div class="form-group">
							<div class="col-xs-6">
								<label for="birthday" style="margin-top: 30px;"><h4>Contact
										Number</h4></label> <input type="text" class="form-control" name="birthday"
									id="birthday" placeholder="Date of Birth"
									style="margin-bottom: 30px;">
							</div>
						</div>

						<div class="form-group">
							<div class="col-xs-6">
								<input class="btn btn-lg btn-success btn-block" type="submit"
									value="Save"
									style="float: left; width: 100px; margin-top: 70px; margin-bottom: 30px; background-color: ##2980b9">
							</div>
						</div>
					</form>
				</div>

			</div>
			<!--/tab-pane-->
		</div>
		<!--/tab-content-->
	</div>
	<!--/col-9-->
</div>
<!--/row-->
<%@ include file="add-modal.jsp"%>
<%@ include file="add-modal-wish.jsp"%>
<%@ include file="delete-item-modal.jsp"%>
<%@ include file="delete-wish-modal.jsp"%>
<%-- 
<%@ include file="add-modal.jsp"%>
<br />
<br />
<%@ include file="add-tab.jsp"%>
<br /> --%>