package com.demo.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.pojo.User;
import com.demo.service.UserService;
import com.demo.service.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		User user=null;
		String msg;
		try {
			user = userService.validate(email, pass);
		} catch (SQLException e) {
			msg="Database Error";
		}
		if (user != null) {
			HttpSession session=request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("home");
		} else {
			msg="Invalid User";
			request.setAttribute("errorMsg", msg);
			request.getRequestDispatcher("views/login.jsp").forward(request, response);
		}
	}

}
