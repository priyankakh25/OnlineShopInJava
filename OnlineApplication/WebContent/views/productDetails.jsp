<%@page import="com.demo.pojo.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Details</title>
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
	
		<%
			Product product=(Product) request.getAttribute("product");
			if(product!=null){
		%>
		<div class="container">
			<div class="row">
				<div class="col-md-5"><img src="resources/img/<%= product.getImageUrl()%>" class="shadow-lg img-thumbnail w-100"></div>
				<div class="col-md-7 shadow-lg bg-light">
				<h3 class="text-uppercase"><%=product.getPname() %></h3>
				<h5>Price:- &#8377; <%=product.getPrice() %></h5>
				<form>
					<input type="hidden" value="<%= product.getPid()%>" name="pid">
					<%
						if(product.getQty()<=0){
							out.print("<h4 class='text-danger'>Out Of Stock</h4>");
						}else{
					%>
					<h5>QTY:- <select name="qty">
					<%
						int qty=product.getQty()>9 ? 9 : product.getQty();
						for(int i=1;i<=qty;i++){%>
							<option value="<%=i%>"><%=i%></option>
						<%}
						}
					%>
					</select></h5>
					<button formaction="addToCart" class="btn btn-info btn-block">Add to cart</button>
					<hr>
					<button formaction="billing" class="btn btn-primary btn-block">Buy Now</button>
					
				</form>
				</div>
			</div>
			<br>
			<div class="shadow-lg bg-light">
				The term pizza was first recorded in the 10th century in a Latin manuscript from the Southern Italian town of Gaeta in Lazio, on the border with Campania.[4] Modern pizza was invented in Naples, and the dish and its variants have since become popular in many countries.[5] It has become one of the most popular foods in the world and a common fast food item in Europe and North America, available at pizzerias (restaurants specializing in pizza), restaurants offering Mediterranean cuisine, and via pizza delivery.[5][6] Many companies sell ready-baked frozen pizzas to be reheated in an ordinary home oven. The Associazione Verace Pizza Napoletana (lit. True Neapolitan Pizza Association) is a non-profit organization founded in 1984 with headquarters in Naples that aims to promote traditional Neapolitan pizza.[7] In 2009, upon Italy's request, Neapolitan pizza was registered with the European Union as a Traditional Speciality Guaranteed dish,[8][9] and in 2017 the art of its making was included on UNESCO's list of intangible cultural heritage.
			</div>
			</div>
		<%
			}
			else {
		%>
		<h1>No Product Available....</h1>
		<%
			}
		%>
	
</body>
</html>