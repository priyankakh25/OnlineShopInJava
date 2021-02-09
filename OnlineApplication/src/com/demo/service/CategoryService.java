package com.demo.service;

import java.sql.SQLException;
import java.util.List;

import com.demo.pojo.Category;
import com.demo.pojo.Product;

public interface CategoryService {

	List<Category> getCategory() throws SQLException;

	Category getCategory(int cid) throws SQLException;

}
