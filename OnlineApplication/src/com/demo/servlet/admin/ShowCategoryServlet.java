package com.demo.servlet.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.pojo.Category;
import com.demo.service.CategoryService;
import com.demo.service.CategoryServiceImpl;


@WebServlet("/adminCategory")
public class ShowCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryService categoryService=new CategoryServiceImpl();
		try {
			request.setAttribute("list", categoryService.getCategory());
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
		request.getRequestDispatcher("views/adminCategoryDetails.jsp").forward(request, response);
	}

}
