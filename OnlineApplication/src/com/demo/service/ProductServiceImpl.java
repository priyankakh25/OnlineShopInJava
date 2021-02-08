package com.demo.service;

import java.sql.SQLException;
import java.util.List;

import com.demo.dao.CategoryDAO;
import com.demo.dao.CategoryDAOImpl;
import com.demo.dao.ProductDAO;
import com.demo.dao.ProductDAOImpl;
import com.demo.pojo.Category;
import com.demo.pojo.Product;

public class ProductServiceImpl implements ProductService {
	ProductDAO productDAO = new ProductDAOImpl();
	@Override
	public List<Product> getAllProduct(int cid) throws SQLException {
		return productDAO.getAllProduct(cid);
	}
	@Override
	public Product getProduct(int pid) throws SQLException {
		return productDAO.getProduct(pid);
	}
	@Override
	public List<Product> getAllProduct() throws SQLException {
		return productDAO.getAllProduct();
	}

	
}
