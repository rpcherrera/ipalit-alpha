<%@ include file="../layouts/taglib.jsp"%>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
<script type="text/javascript" src="<c:url value="/resources/js/wishValidate.js" />" ></script>
<!-- Button trigger modal -->
<!-- <input type="button" class="btn btn-info btn-block"
										data-toggle="modal" data-target="#myModal2" value="Add Wishlist"
										style="width: 125px; margin: 20px 0 20px 20px;" /> -->
<form:form commandName="wish" cssClass="form-horizontal wishForm" action="acct.html">
	<!-- Modal -->
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Add Item</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Item Name</label>
						<div class="col-sm-7">
							<form:input path="wishlistName" cssClass="form-control" id="wishlistName" />
							<form:errors path="wishlistName" />
						</div>
					</div>
		
					<div class="form-group">
						<label for="url" class="col-sm-2 control-label">Description</label>
						<div class="col-sm-7">
							<form:textarea path="wishlistDesc" cssClass="form-control" id="wishlistDesc" />
						<form:errors path="wishlistDesc" />
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