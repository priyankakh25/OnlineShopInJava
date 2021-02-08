package com.demo.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.pojo.Item;
import com.demo.pojo.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

@WebServlet("/viewCart")
public class ViewCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService productService=new ProductServiceImpl();
		List<Item> list=new ArrayList<>();
		HttpSession session = request.getSession();
		if(session.getAttribute("cart")==null)
		{
			response.sendRedirect("home");
		}
		HashMap<Integer, Integer> cart=(HashMap<Integer, Integer>) session.getAttribute("cart");
		for(Map.Entry<Integer,Integer> i:cart.entrySet()) {
			try {
				Product p=productService.getProduct(i.getKey());
				list.add(new Item(p.getPid(),p.getPname(),p.getImageUrl(),p.getPrice(),i.getValue()));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/viewCart.jsp").forward(request, response);;
	}


}
