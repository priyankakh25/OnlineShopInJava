package com.demo.dao;

import java.sql.SQLException;
import java.util.List;

import com.demo.pojo.Product;

public interface ProductDAO {

	List<Product> getAllProduct(int cid) throws SQLException;

	Product getProduct(int pid) throws SQLException;

	List<Product> getAllProduct() throws SQLException;

}
