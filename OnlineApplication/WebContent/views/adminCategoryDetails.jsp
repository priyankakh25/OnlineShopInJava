<%@ page import="java.util.List,com.demo.pojo.Category" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CategoryDetails</title>
<jsp:include page="links.jsp"></jsp:include>
</head>
<body>
<%
		if (session.getAttribute("user") == null) {
			response.sendRedirect("home");
		}
%>
<jsp:include page="navbar.jsp"></jsp:include>
	<br>
	<br>
	<div class="container">
		<button type="button" class="btn btn-success" data-toggle="modal"
			data-target="#addProduct">Add Category</button><br>
		<!-- Modal -->
		<div class="modal fade" id="addProduct" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<form action="addProduct" method="post">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Add Category</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<!-- form start -->
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputCid">Cid</label> <input type="text"
										class="form-control" id="inputCid" placeholder="Cid">
								</div>
								<div class="form-group col-md-6">
									<label for="inputCname">Cname</label> <input
										type="text" class="form-control" id="inputCname"
										placeholder="cname">
								</div>
							</div>
							
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputImageUrl">ImageUrl</label> <input type="text"
										class="form-control" id="inputImageUrl">
								</div>
							</div>
							<!-- form end -->
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary">Add
								Category</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- Model End -->
		<br>
		<%
			List<Category> clist = (List<Category>) request.getAttribute("list");
			if (clist != null) {
				clist.stream().forEach(System.out::println);
		%>
		<table class="table table-hover" >
			<thead>
				<tr>
					<th scope="col">Image</th>
					<th scope="col">Name</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<%
					for (Category c : clist) {
				%>
				<tr>
					<td><img style="width: 75px; height: 75px"
						alt="<%=c.getCname()%>" src="resources/img/<%=c.getImgUrl()%>"></td>
					<td><%=c.getCname()%></td>
					<td><a href="editProduct?pid=<%=c.getCid()%>"
						class="btn btn-warning">edit</a> / <a
						href="deleteProduct?pid=<%=c.getCid()%>" class="btn btn-danger"
						onclick="return confirm('Are you sure?')">delete</a></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<%
			} else {
		%>
		<h1>No List....</h1>
		<%
			}
		%>
	</div>
</body>
</html>