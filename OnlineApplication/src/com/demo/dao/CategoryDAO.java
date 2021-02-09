package com.demo.dao;

import java.sql.SQLException;
import java.util.List;

import com.demo.pojo.Category;

public interface CategoryDAO {

	List<Category> getAll() throws SQLException;

	Category getCategory(int cid) throws SQLException;

}
