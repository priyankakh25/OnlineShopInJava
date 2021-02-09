package com.demo.service;

import java.sql.SQLException;

import com.demo.dao.UserDAO;
import com.demo.dao.UserDAOImpl;
import com.demo.pojo.User;

public class UserServiceImpl implements UserService {
	UserDAO userDAO=new UserDAOImpl();
	@Override
	public User validate(String email, String pass) throws SQLException {
		return userDAO.authenticate(email, pass);
	}
	@Override
	public boolean save(User u) throws SQLException {
		
		return userDAO.save(u);
	}

}
