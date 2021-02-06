package com.demo.service;

import java.sql.SQLException;
import java.util.List;

import com.demo.dao.CategoryDAO;
import com.demo.dao.CategoryDAOImpl;
import com.demo.pojo.Category;

public class ProductServiceImpl implements ProductService {
	CategoryDAO categoryDAO=new CategoryDAOImpl();
	@Override
	public List<Category> getCategory() throws SQLException {
		return categoryDAO.getAll();
	}

}
