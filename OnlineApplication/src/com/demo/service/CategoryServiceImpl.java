package com.demo.service;

import java.sql.SQLException;
import java.util.List;

import com.demo.dao.CategoryDAO;
import com.demo.dao.CategoryDAOImpl;
import com.demo.pojo.Category;
import com.demo.pojo.Product;

public class CategoryServiceImpl implements CategoryService {
	CategoryDAO categoryDAO=new CategoryDAOImpl();
	@Override
	public List<Category> getCategory() throws SQLException {
		return categoryDAO.getAll();
	}
}
