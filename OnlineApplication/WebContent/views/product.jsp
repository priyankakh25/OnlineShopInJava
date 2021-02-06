<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.List,com.demo.pojo.Category"
	pageEncoding="ISO-8859-1"%>
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
			List<Category> list = (List<Category>) request.getAttribute("list");
			if (list != null)
				for (Category c : list) {
		%>
		<div class="col-md-3">
			<div class="card " style="height: 25rem;">
				<img src="resources/img/<%=c.getImgUrl() %>" class="card-img-top h-100" alt="<%=c.getCname() %>">
				<div class="card-body">
					<h5 class="card-title"><%=c.getCname() %></h5>
					
					<a href="product?cid=<%=c.getCid() %>" class="btn btn-primary btn-block">Click</a>
				</div>
			</div>
		</div>
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