package com.demo.service;

import java.sql.SQLException;

import com.demo.pojo.User;

public interface UserService {

	User validate(String email, String pass) throws SQLException;
	boolean save(User u) throws SQLException;
}
