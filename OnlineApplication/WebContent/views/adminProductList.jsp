<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.List,com.demo.pojo.Product" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
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
			data-target="#addProduct">Add Product</button><br>
		<!-- Modal -->
		<div class="modal fade" id="addProduct" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<form action="addProduct" method="post">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Add Product</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<!-- form start -->
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputPid">Pid</label> <input type="text"
										class="form-control" id="inputPid" placeholder="Enter Pid">
								</div>
								<div class="form-group col-md-6">
									<label for="inputPname">Pname</label> <input
										type="text" class="form-control" id="inputPname"
										placeholder="Enter Pname">
								</div>
							</div>
							<div class="form-group">
								<label for="inputDescription">Description</label> <input type="text"
									class="form-control" id="inputDescription"
									placeholder="Enter Description">
							</div>
							<div class="form-group">
								<label for="inputSubCategory">SubCategory</label> <input type="text"
									class="form-control" id="inputSubCategory"
									placeholder="Apartment, studio, or floor">
							</div>
							<div class="form-row">
								<div class="form-group col-md-5">
									<label for="inputImageUrl">ImageUrl</label> <input type="text"
										class="form-control" id="inputImageUrl">
								</div>
								<div class="form-group col-md-4">
									<label for="inputQty">Qty</label> 
									<input type="text"
										class="form-control" id="inputQty">
								</div>
								<div class="form-group col-md-3">
									<label for="inputPrice">Price</label> <input type="text"
										class="form-control" id="inputPrice">
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputBrandName">BrandName</label> <input type="text"
										class="form-control" id="inputBrandName">
								</div>
								<div class="form-group col-md-4">
									<label for="inputCid">Cid</label> 
									<input type="text"
										class="form-control" id="inputCid">
								</div>
								<div class="form-group col-md-2">
									<label for="inputWt">Weightt</label> <input type="text"
										class="form-control" id="inputWt">
								</div>
							</div>
							<!-- form end -->
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary">Add
								Product</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- Model End -->
		<br>
		<%
			List<Product> plist = (List<Product>) request.getAttribute("list");
			if (plist != null) {
		%>
		<table class="table table-hover" id="myDataTable">
			<thead>
				<tr>
					<th scope="col">Image</th>
					<th scope="col">Name</th>
					<th scope="col">Price</th>
					<th scope="col">Qty</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<%
					for (Product p : plist) {
				%>
				<tr>
					<td><img style="width: 75px; height: 75px"
						alt="<%=p.getPname()%>" src="resources/img/<%=p.getImageUrl()%>"></td>
					<td><%=p.getPname()%></td>
					<td><%=p.getPrice()%></td>
					<td><%=p.getQty()%></td>
					<td><a href="editProduct?pid=<%=p.getPid()%>"
						class="btn btn-warning">edit</a> / <a
						href="deleteProduct?pid=<%=p.getPid()%>" class="btn btn-danger"
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