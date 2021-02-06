<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="home">Online Shop</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="home">Home <span class="sr-only">(current)</span></a>
      </li>
      <% if(session.getAttribute("user")!=null)
    	{%>
      <li class="nav-item">
        <a class="nav-link" href="category">Category</a>
      </li>
      <%} %>
    </ul>
    
    <ul class="navbar-nav ml-auto">
    <% if(session.getAttribute("user")==null)
    	{%>
      <li class="nav-item">
        <a class="nav-link" href="login">SignIn</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="register">SignUp</a>
      </li>
      <% }else{%>
    	  <li class="nav-item">
        <a class="nav-link" href="logout">Logout</a>
      </li>
      <%}%>
    </ul>
  </div>
</nav>