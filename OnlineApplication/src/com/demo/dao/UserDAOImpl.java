package com.demo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.pojo.User;

public class UserDAOImpl implements UserDAO {
	private PreparedStatement pstValid, pstInsert, pstUpdate, pstDelete, pstDisplay, pstDisplayById;

	public UserDAOImpl() {
		try {
			pstInsert = DBUtiil.getConnection()
					.prepareStatement("insert into users(firstname,lastname,address,email,password,mobile, role) value(?,?,?,?,?,?,?)");
			pstUpdate = DBUtiil.getConnection()
					.prepareStatement("update users set name=?,email=?,address=? where id=?");
			pstDelete = DBUtiil.getConnection().prepareStatement("delete from users where id=?");
			pstDisplay = DBUtiil.getConnection().prepareStatement("select * from users");
			pstDisplayById = DBUtiil.getConnection().prepareStatement("select * from users where id=?");
			pstValid = DBUtiil.getConnection().prepareStatement("select * from users where email=? and password=?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User authenticate(String uname, String pass) throws SQLException {
		pstValid.setString(1, uname);
		pstValid.setString(2, pass);
		ResultSet rs = pstValid.executeQuery();
		//System.out.println("Authenticate:-" + uname + "," + pass);
		User user = null;
		if (rs.next()) {

			user = new User(rs.getInt("uid"), rs.getString("firstname"), rs.getString("lastname"),
					rs.getString("address"), rs.getString("email"), rs.getString("password"), rs.getString("mobile"),
					rs.getString("role"));

		}

		return user;

	}

	@Override
	public boolean save(User u) throws SQLException {
		
		  pstInsert.setString(1, u.getFname());
		  pstInsert.setString(2, u.getLname());
		  pstInsert.setString(3, u.getAddress());
		  pstInsert.setString(4, u.getEmail()); 
		  pstInsert.setString(5, u.getPassword());
		  pstInsert.setString(6, u.getPhone());
		  pstInsert.setString(7, u.getRole());
		  if(pstInsert.executeUpdate()>0) {
			  	return true;
		  }
		 
		return false;
	}

	@Override
	public boolean update(int id, String uname, String email, String address) throws SQLException {
		pstUpdate.setString(1, uname);
		pstUpdate.setString(2, email);
		pstUpdate.setString(3, address);
		pstUpdate.setInt(4, id);
		if (pstUpdate.executeUpdate() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int id) throws SQLException {
		pstDelete.setInt(1, id);
		if (pstDelete.executeUpdate() > 0) {
			return true;
		}
		return false;

	}

	public void finalize() {
		try {
			pstInsert.close();
			pstUpdate.close();
			pstDelete.close();
			pstDisplay.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> display() throws SQLException {
		List<User> userList = new ArrayList<>();
		ResultSet rs = pstDisplay.executeQuery();
		while (rs.next()) {
			userList.add(null);
		}
		return userList;
	}

	@Override
	public User displayById(int id) throws SQLException {
		pstDisplayById.setInt(1, id);
		User user = null;
		ResultSet rs = pstDisplayById.executeQuery();
		if (rs.next()) {
			return null;// new
						// User(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("address"),rs.getString("password"));
		}
		return user;
	}
}
