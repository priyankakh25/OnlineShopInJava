<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.Map,java.util.HashMap,com.demo.pojo.Product"
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
	<table class="table table-bordered">
		<thead>
			<tr>
				<th scope="col">Sr.no</th>
				<th scope="col">Product Name</th>
				<th scope="col">Qty</th>
				<th scope="col">Price</th>
				<th scope="col">Amount</th>
			</tr>
		</thead>
		<tbody>
			<%
				double total = 0;
				HashMap<Product, Integer> hm = (HashMap<Product, Integer>) session.getAttribute("cart");
				if (hm != null) {
					int i = 0;
					for (Map.Entry<Product, Integer> entry : hm.entrySet()) {
						Product p = entry.getKey();
						int qty = entry.getValue();
						double amt = qty * p.getPrice();
			%>

			<tr>
				<th scope="row"><%=(++i)%>></th>
				<td><%=p.getPname()%></td>
				<td><%=qty%></td>
				<td><%=p.getPrice()%></td>
				<td><%=amt%></td>
			</tr>
			<%
				}
			%>
			<tr>
				<th scope="row"><%=(++i) %>></th>
				<td colspan="2">Total</td>
				<td><%=total %>></td>
			</tr>
		</tbody>
	</table>
	<%
		} else {
	%>
	<h1>Product not available....</h1>
	<%
		}
	%>
</body>
</html>