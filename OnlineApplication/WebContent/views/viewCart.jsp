<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,com.demo.pojo.Item"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<jsp:include page="links.jsp" ></jsp:include>
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
	<div class="jumbotron shadow">
	<ul class="list-unstyled">
  

		<%
			List<Item> ilist = (List<Item>) request.getAttribute("list");
			double totAmt=0;
			if (ilist != null)
				for (Item item : ilist) {
					totAmt+=item.getPrice()*item.getQty();
		%>
		
			<li class="media">
			  <img class="mr-3" style="height: 100px;width: 100px;" src="resources/img/<%=item.getImgUrl() %>" alt="<%=item.getpName()%>">
			  <div class="media-body">
			    <h5 class="mt-0"><%=item.getpName()%><a class="close" href="removeFromCart?pid=<%=item.getPid() %>"><span aria-hidden="true">&times;</span></a></h5>
			    Price:-&#8377;<%=item.getPrice() %><br/>
			    QTY:- <%=item.getQty() %><br/>
			    Total:- &#8377;<%=item.getPrice()*item.getQty() %><br/>
			  </div>
			</li>
		<%} %>
		</ul>
		<h3>Total Amount:-&#8377;<%=totAmt %></h3>
		<a href="confirmOrder" class="btn btn-outline-info btn-block">Confirm</a>
	</div>
	</div>
</body>
</html>