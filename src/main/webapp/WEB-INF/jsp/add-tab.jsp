<%@ include file="../layouts/taglib.jsp"%>
<button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
  Button with data-target
</button>
<div class="collapse" id="collapseExample">
  <div class="well">
    <div role="tabpanel">
	<!-- Nav tabs -->
	<ul class="nav nav-tabs">
		<c:forEach items="${user.blogs}" var="blog">
			<li><a href="#blog_${blog.id}" data-toggle="tab"><c:out
						value="${blog.itemname}" /></a></li>
		</c:forEach>
	</ul>

	<!-- Tab panes -->
	<div class="tab-content">
		<c:forEach items="${user.blogs}" var="blog">
			<div class="tab-pane fade in active" id="blog_${blog.id}">
				<h4>
					<c:out value="${blog.itemname}" />
					<c:out value="${blog.itemdescription}" />
					<c:out value="${blog.datePosted}" />
				</h4>
				<p>
					<a href="<spring:url value="/blog/remove/${blog.id}.html" />"
						class="btn btn-danger triggerRemove">remove blog</a>
					<c:out value="${blog.itemdescription}" />
				</p>
				<table class="table table-bordered table-hover table-striped">
					<thead>
						<tr>
							<th>ITEM NAME</th>
							<th>ITEM DESC</th>
							<th>DATE POSTED</th>
						</tr>
					</thead>
					<tbody>
						<%-- <c:forEach items="${blog.items}" var="item"> --%>
							<tr>
								<td><c:out value="${blog.itemname}" /></td>
								<td><c:out value="${blog.itemdescription}" /></td>
								<td><c:out value="${blog.datePosted}" /></td>
							</tr>
						<%-- </c:forEach> --%>
					</tbody>
				</table>
			</div>
		</c:forEach>
	</div>
</div>

  </div>
</div>

<%@ include file="../jsp/delete-item-modal.jsp"%>