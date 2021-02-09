package com.demo.servlet.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

/**
 * Servlet implementation class ShowProductsServlet
 */
@WebServlet("/adminProduct")
public class ShowProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductService productService=new ProductServiceImpl();
		try {
			request.setAttribute("list", productService.getAllProduct());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("views/adminProductList.jsp").forward(request, response);
	}

}
