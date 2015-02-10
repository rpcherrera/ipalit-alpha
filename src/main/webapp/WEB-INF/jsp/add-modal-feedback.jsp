<%@ include file="../layouts/taglib.jsp"%>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
<script type="text/javascript" src="<c:url value="/resources/js/feedValidate.js" />" ></script>
<!-- Button trigger modal -->
<input type="button" class="btn btn-info btn-xs"
										data-toggle="modal" data-target="#myModal3" value="Post Feedback"
										style="width: 100px; margin: 20px 0 20px 20px;" />
<form:form commandName="feed" cssClass="form-horizontal feedForm" action="feed.html">
	<!-- Modal -->
	<div class="modal fade" id="myModal3" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Post Feedback</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="rating" class="col-sm-2 control-label">Rating</label>
						<div class="col-sm-7">
							<form:select path="rating" cssClass="form-control" id="rating" >
								<form:option value="No Rating(Comment Only)"></form:option>
								<form:option value="Good"></form:option>
								<form:option value="Bad"></form:option>
							</form:select>
						</div>
					</div>
					<div class="form-group">
						<label for="url" class="col-sm-2 control-label">Message</label>
						<div class="col-sm-7">
							<form:textarea path="feedbackDesc" cssClass="form-control" id="feedbackDesc" />
							<form:errors path="feedbackDesc" />
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<input type="submit" class="btn btn-primary" value="Save" />  
				</div>
			</div>
		</div>
	</div>
</form:form>