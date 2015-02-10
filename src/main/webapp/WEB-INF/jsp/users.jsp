<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp"%>
<link href="<c:url value="/resources/css/account.css" />"
	rel="stylesheet">
<script type="text/javascript">
	$(document).ready(function() {
		$('.triggerRemove').click(function(e) {
			e.preventDefault();
			$("#delModal .removeBtn").attr("href", $(this).attr("href"));
			$("#delModal").modal();
		});
	});
</script>
<div class="container" style="height: 500px;">

		<table class="table table-bordered table-hover table-striped">
			<thead>
				<tr>
					<th>user name</th>
					<th>operation</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td><strong><a href="<spring:url value="/users/${user.id}.html"/>">
								${user.username }</a></strong></td>
						<td><a
							href="<spring:url value="/users/remove/${user.id}.html" />"
							class="btn btn-danger triggerRemove">DELETE USER</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

<%@ include file="../jsp/delete-user-modal.jsp"%>