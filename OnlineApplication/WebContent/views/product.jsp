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
	<div class="row">
		<%
			List<Product> plist = (List<Product>) request.getAttribute("productList");
			if (plist != null)
				for (Product p : plist) {
					
					//out.print(p.getPname());
		%>
			
			<div class="col-md-3 p-1">
				<div class="card h-100" >
					<a href="productDetails?pid=<%=p.getPid() %>"><img src="resources/img/<%=p.getImageUrl()%>" class="card-img-top h-100" alt="<%=p.getPname()%>"></a>
					<div class="card-body">
						<h5 class="card-title"><%=p.getPname()%></h5>
						<p>Price:&#8377;<%=p.getPrice()%></p>
						<div class="row">
							<div class="col">
								<a href="productDetails?pid=<%=p.getPid() %>" class="btn btn-info btn-block">Details</a>
							</div>
							<div class="col">
								<a href="addToCart?pid=<%=p.getPid() %>&qty=1" class="btn btn-success btn-block">Add to Cart</a>
							</div>
						</div>
						 
					</div>
				</div>
			</div>
			<br>
			<br>
			<%
				}
				else {
			%>
			<h1>No List....</h1>
			<%
				}
			%>
		</div>
</body>
</html>