<%@ include file="../layouts/taglib.jsp"%>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
<script type="text/javascript" src="<c:url value="/resources/js/blogValidate.js" />" ></script>
<!-- Button trigger modal -->
<!-- <input type="button" class="btn btn-info btn-block"
										data-toggle="modal" data-target="#myModal" value="Add Item"
										style="width: 100px; margin: 20px 0 20px 20px;" /> -->
<form:form commandName="blog" cssClass="form-horizontal blogForm">
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
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
							<form:input path="itemname" cssClass="form-control" id="itemname" />
							<form:errors path="itemname" />
						</div>
					</div>
					<div class="form-group">
						<label for="warranty" class="col-sm-2 control-label">Warranty</label>
						<div class="col-sm-7">
							<form:select path="warranty" cssClass="form-control" id="warranty" >
								<form:option value="No Warranty"></form:option>
								<form:option value="Shop Warranty"></form:option>
								<form:option value="Personal Warranty"></form:option>
							</form:select>
						</div>
					</div>
					<div class="form-group">
						<label for="itemCondition" class="col-sm-2 control-label">Item Condition</label>
						<div class="col-sm-7">
							<form:select path="itemCondition" cssClass="form-control" id="itemCondition" >
								<form:option value="Brand New"></form:option>
								<form:option value="Already Used"></form:option>
								<form:option value="Newly Replaced"></form:option>
								<form:option value="Defective"></form:option>
							</form:select>
						</div>
					</div>
					<div class="form-group">
						<label for="url" class="col-sm-2 control-label">Description</label>
						<div class="col-sm-7">
							<form:textarea path="itemdescription" cssClass="form-control" id="itemdescription" />
							<form:errors path="itemdescription" />
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