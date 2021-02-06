package com.demo.dao;

import java.sql.SQLException;
import java.util.List;

import com.demo.pojo.User;

public interface UserDAO{
	User authenticate(String uname,String pass) throws SQLException;

	boolean save(User u) throws SQLException;

	boolean update(int id,String uname,String email,String address) throws SQLException;

	boolean delete(int id) throws SQLException;
	public User displayById(int id) throws SQLException;
	List<User> display() throws SQLException;
}
