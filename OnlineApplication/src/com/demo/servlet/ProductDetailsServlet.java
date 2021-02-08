package com.demo.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.pojo.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

/**
 * Servlet implementation class ProductDetailsServlet
 */
@WebServlet("/productDetails")
public class ProductDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService productService=new ProductServiceImpl();
		try {
			Product p=null;
			if(request.getParameter("pid")==null) {
				response.sendRedirect("product");
			}
			else {
				int pid=Integer.parseInt(request.getParameter("pid"));
				p=productService.getProduct(pid);
			}
			request.setAttribute("product", p);
			
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
		request.getRequestDispatcher("views/productDetails.jsp").forward(request, response);
	}

}
