package com.demo.service;

import java.sql.SQLException;
import java.util.List;

import com.demo.pojo.Category;
import com.demo.pojo.Product;

public interface ProductService {

	List<Product> getAllProduct(int id) throws SQLException;

	Product getProduct(int pid) throws SQLException;

	List<Product> getAllProduct() throws SQLException;

}
