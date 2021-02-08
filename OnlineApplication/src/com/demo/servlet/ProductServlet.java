package com.demo.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.pojo.Category;
import com.demo.pojo.Product;
import com.demo.service.CategoryService;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;
import com.demo.service.CategoryService;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService productService=new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			List<Product> plist;
			if(req.getParameter("cid")==null) {
				plist=productService.getAllProduct();
			}
			else {
				int cid=Integer.parseInt(req.getParameter("cid"));
				plist=productService.getAllProduct(cid);
			}
			req.setAttribute("productList", plist);
			
		} catch (SQLException e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", e.getMessage());
		}
		req.getRequestDispatcher("views/product.jsp").forward(req, resp);
	}
}
