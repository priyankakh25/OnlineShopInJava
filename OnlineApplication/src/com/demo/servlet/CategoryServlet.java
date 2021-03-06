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
import com.demo.service.CategoryService;
import com.demo.service.CategoryServiceImpl;
import com.demo.service.CategoryService;

@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryService cateoryService=new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			List<Category> list=cateoryService.getCategory();
			//list.stream().forEach(System.out::println);
			req.setAttribute("list", list);
		} catch (SQLException e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", e.getMessage());
		}
		req.getRequestDispatcher("views/category.jsp").forward(req, resp);
	}
}
